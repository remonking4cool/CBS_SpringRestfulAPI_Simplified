package com.rest.SpringRest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long CustomerAcctNumber;
    private String CustomerName;
    private int CustomerAge;
    private String CustomerAddress;
    private Long CustomerBalance;
    private Long CustomerPhoneNo;
    private String CustomerEmailAddress;
    private Long CustomerBVN;
    private Long CustomerCIFId;
}
