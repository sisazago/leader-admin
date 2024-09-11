package com.co.leader.admin.application.leader.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderRequest {

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String country;

    private String countryOfResidence;

    private String company;

    private String email;

    private String password;

    private String confirmPassword;
}
