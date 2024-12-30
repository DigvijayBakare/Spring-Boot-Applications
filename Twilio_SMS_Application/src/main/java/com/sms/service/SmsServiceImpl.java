package com.sms.service;

import com.sms.controller.SMSRestController;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
//@Slf4j
public class SmsServiceImpl implements SmsService{
    private Logger logger = LoggerFactory.getLogger(SMSRestController.class);

    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    @PostConstruct
    private void setup() {
        logger.info("Creating class SmsServiceImpl");
        logger.info("ACCOUNT_SID: " + ACCOUNT_SID);
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    public String sendSms(String smsNumber, String smsMessage) {
        Message message = Message.creator(
                new PhoneNumber(smsNumber),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                smsMessage).create();
        return message.getStatus().toString();
    }
}
