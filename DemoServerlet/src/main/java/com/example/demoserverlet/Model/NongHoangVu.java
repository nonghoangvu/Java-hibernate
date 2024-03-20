package com.example.demoserverlet.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NongHoangVu {
    private String fullName;
    private int age;
    private String major;

    @Override
    public String toString() {
        return this.fullName;
    }
}
