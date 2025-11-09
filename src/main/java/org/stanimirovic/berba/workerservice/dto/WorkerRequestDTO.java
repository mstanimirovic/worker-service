package org.stanimirovic.berba.workerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerRequestDTO {
    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    @NotBlank
    @Size(min = 1, max = 20)
    private String phone;

    @Email(message = "Please provide a valid email address")
    private String email;

    @Size(min = 1, max = 100)
    private String description;

    private String paymentType;
    private String role;

    @NotNull
    private UUID userId;
}
