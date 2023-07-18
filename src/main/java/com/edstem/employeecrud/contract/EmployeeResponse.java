package com.edstem.employeecrud.contract;
import lombok.*;
    @Builder
    @Getter
    @AllArgsConstructor
    public  class EmployeeResponse {
        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String position;
        private String department;
    }


