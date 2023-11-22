package com.merlini.musiclibrary.adapters.drivers.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
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
public class EmployeeRequest {
  public interface PatchEmployeeRequest {
  }
  
  private Integer id;

  @NotBlank(message = "Last name is required.", groups = EmployeeRequest.class)
  private String lastName;

  @NotBlank(message = "First name is required.", groups = EmployeeRequest.class)
  private String firstName;

  @NotBlank(message = "Title is required.", groups = EmployeeRequest.class)
  private String title;

  @Valid
  private EmployeeRequest supervisor;

  @NotNull(message = "Birth date is required.", groups = EmployeeRequest.class)
  @Past(message = "Birth date must be in the past.", groups = {EmployeeRequest.class,
      PatchEmployeeRequest.class})
  private Date birthDate;

  @NotNull(message = "Hire date is required.", groups = EmployeeRequest.class)
  @Past(message = "Hire date must be in the past.", groups = {EmployeeRequest.class,
      PatchEmployeeRequest.class})
  private Date hireDate;

  private String address;

  private String city;

  private String state;

  @NotBlank(message = "Country is required.", groups = EmployeeRequest.class)
  private String country;

  private String postalCode;

  @NotBlank(message = "Phone is required.", groups = EmployeeRequest.class)
  @Pattern(regexp = "\\d{10}", message = "Invalid phone number format. It should have 10 digits.")
  private String phone;

  private String fax;

  @NotBlank(message = "Email is required.", groups = EmployeeRequest.class)
  @Email(message = "Invalid email format.", groups = {EmployeeRequest.class,
      PatchEmployeeRequest.class})
  private String email;
}
