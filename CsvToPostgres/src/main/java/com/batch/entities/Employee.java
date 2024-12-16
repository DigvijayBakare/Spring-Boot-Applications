package com.batch.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
public class Employee {
    private int emp_id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String job_title;
}
