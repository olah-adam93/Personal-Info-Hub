package com.example.PersonalInfoManager.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AddressDTO {

  @NotBlank(message = "Postal code is required.")
  @Pattern(regexp = "^\\d{4,5}$", message = "Invalid postal code. Example: '1011'.")
  @Schema(example = "1011", description = "Postal code of the address. Should be 4 or 5 digits.")
  private String postalCode;

  @NotBlank(message = "City is required.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "City must start with a capital letter.")
  @Schema(example = "Budapest", description = "City of the address.")
  private String city;

  @NotBlank(message = "Street is required.")
  @Size(max = 50, message = "Street name cannot exceed 50 characters. Example: 'Fő utca'.")
  @Pattern(regexp = "^[A-ZÁÉÍÓÖŐÚÜŰ].*", message = "Street must start with a capital letter.")
  @Schema(example = "Fő utca", description = "Street name of the address, max 50 characters.")
  private String street;
}

