package com.example.PersonalInfoManager.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PersonDTO {

  private long id;

  @NotBlank(message = "Last name is required.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "Last name must start with a capital letter.")
  @Schema(example = "Szabó", description = "The person's last name.")
  private String lastName;

  @NotBlank(message = "First name is required.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "First name must start with a capital letter.")
  @Schema(example = "Anna", description = "The person's first name.")
  private String firstName;

  @NotBlank(message = "Birth name is required.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "Birth name must start with a capital letter.")
  @Schema(example = "Szabó Anna", description = "The person's birth name.")
  private String birthName;

  @NotBlank(message = "Mother's name is required.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "Mother's name must start with a capital letter.")
  @Schema(example = "Kovács Piroska", description = "The name of the person's mother.")
  private String motherName;

  @Schema(example = "Female", description = "The person's gender.")
  private String gender;

  @NotBlank(message = "Nationality is required.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "Nationality must start with a capital letter.")
  @Schema(example = "Hungarian", description = "The person's nationality.")
  private String nationality;

  @NotNull(message = "Address is required.")
  @Valid
  @Schema(description = "The person's address.")
  private AddressDTO address;

  private AddressDTO mailingAddress;

  private AddressDTO residence;

  @NotBlank(message = "Phone number is required.")
  @Pattern(
          regexp = "^\\+?[0-9]{1,3}[- ]?[0-9]{1,4}[- ]?[0-9]{3,4}[- ]?[0-9]{3,4}$",
          message = "Invalid phone number. Example: '+36-30-123-4567'.")
  @Schema(example = "+36-30-1234567", description = "The person's phone number.")
  private String phoneNumber;

  @NotBlank(message = "Tax ID is required.")
  @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Tax ID format. Example: '1234567890'.")
  @Schema(example = "1234567890", description = "The person's tax ID.")
  private String taxId;

  @Size(max = 500, message = "Notes cannot exceed 500 characters.")
  @Schema(
          example = "Anna has a preference for communication over phone calls. She is available for meetings in the mornings and prefers remote work due to her location.",
          description = "Additional notes about the person.")
  private String notes;
}
