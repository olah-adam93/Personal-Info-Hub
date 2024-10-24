package com.example.PersonalInfoManager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String lastName;

  private String firstName;

  private String birthName;

  private String motherName;

  private String gender;

  private String nationality;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
          @AttributeOverride(name = "city", column = @Column(name = "address_city")),
          @AttributeOverride(name = "street", column = @Column(name = "address_street"))
  })
  private Address address;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_address_postal_code")),
          @AttributeOverride(name = "city", column = @Column(name = "mailing_address_city")),
          @AttributeOverride(name = "street", column = @Column(name = "mailing_address_street"))
  })
  private Address mailingAddress;

  @Embedded
  @AttributeOverrides({
          @AttributeOverride(name = "postalCode", column = @Column(name = "residence_postal_code")),
          @AttributeOverride(name = "city", column = @Column(name = "residence_city")),
          @AttributeOverride(name = "street", column = @Column(name = "residence_street"))
  })
  private Address residence;

  private String phoneNumber;

  private String taxId;

  private String notes;
}
