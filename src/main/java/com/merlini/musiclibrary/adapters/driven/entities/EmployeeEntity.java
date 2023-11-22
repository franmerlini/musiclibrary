package com.merlini.musiclibrary.adapters.driven.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "EmployeeId")
  private Integer id;

  @Basic
  @Column(name = "LastName")
  private String lastName;

  @Basic
  @Column(name = "FirstName")
  private String firstName;

  @Basic
  @Column(name = "Title")
  private String title;

  @ManyToOne
  @JoinColumn(name = "ReportsTo")
  private EmployeeEntity supervisor;

  @Basic
  @Column(name = "BirthDate")
  private Date birthDate;

  @Basic
  @Column(name = "HireDate")
  private Date hireDate;

  @Basic
  @Column(name = "Address")
  private String address;

  @Basic
  @Column(name = "City")
  private String city;

  @Basic
  @Column(name = "State")
  private String state;

  @Basic
  @Column(name = "Country")
  private String country;

  @Basic
  @Column(name = "PostalCode")
  private String postalCode;

  @Basic
  @Column(name = "Phone")
  private String phone;

  @Basic
  @Column(name = "Fax")
  private String fax;

  @Basic
  @Column(name = "Email")
  private String email;
}
