package com.email.model;

import lombok.*;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class Email {
    private String to;
    private String subject;
    private String message;
}
