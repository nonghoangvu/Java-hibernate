package com.vunh.Model;

import com.vunh.Filters.LoginFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private long id;
    private String fullName;
    private boolean gender;
    private LocalDate dateOfBirth;
    private String country;

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, today);
        return period.getYears();
    }
    public static String decodeBase64(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
    public static String username = Account.decodeBase64(LoginFilter.first);
    public static String password = Account.decodeBase64(LoginFilter.second);
}
