package com.merlini.musiclibrary.domain.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private int id;
  private String lastName;
  private String firstName;
  private String title;
  private Employee supervisor;
  private Date birthDate;
  private Date hireDate;
  private String address;
  private String city;
  private String state;
  private String country;
  private String postalCode;
  private String phone;
  private String fax;
  private String email;
}
