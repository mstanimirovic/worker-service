package org.stanimirovic.berba.workerservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String name;

    private String phone;
    private String email;
    private String description;
    private String paymentType;
    private String role;

    @NotNull
    private UUID userId;
}
