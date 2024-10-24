package com.example.PersonalInfoManager.model;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  private String postalCode;

  private String city;

  private String street;
}
