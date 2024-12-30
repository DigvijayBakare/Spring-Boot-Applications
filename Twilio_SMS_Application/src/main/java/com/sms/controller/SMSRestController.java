package com.sms.controller;

import com.sms.entities.SMSSendRequest;
import com.sms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
//@Slf4j
public class SMSRestController {
    private Logger logger = LoggerFactory.getLogger(SMSRestController.class);

    /*@GetMapping("/processSMS")
    public String processSMS() {
        return "TODO";
    }*/

    @Autowired
    private SmsService service;

    @PostMapping("/processSMS")
    public String processSMS(@RequestBody SMSSendRequest sendRequest) {
        logger.info("ProcessSMS started send request: {}", sendRequest);
//        log.info("ProcessSMS started send request: " + sendRequest.toString());
        return service.sendSms(sendRequest.getDestinationSMSNumber(),sendRequest.getSmsMessage());
    }
}
