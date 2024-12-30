package com.sms.entities;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter@Setter
//@ToString
//@Data
public class SMSSendRequest {
    private String destinationSMSNumber;
    private String smsMessage;

    public SMSSendRequest() {
    }

    public SMSSendRequest(String destinationSMSNumber, String smsMessage) {
        this.destinationSMSNumber = destinationSMSNumber;
        this.smsMessage = smsMessage;
    }

    public String getDestinationSMSNumber() {
        return destinationSMSNumber;
    }

    public void setDestinationSMSNumber(String destinationSMSNumber) {
        this.destinationSMSNumber = destinationSMSNumber;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    @Override
    public String toString() {
        return "SMSSendRequest {" +
                "destinationSMSNumber='" + destinationSMSNumber + '\'' +
                ", smsMessage='" + smsMessage + '\'' +
                '}';
    }
}
