package org.stanimirovic.berba.workerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private String paymentType;
    private String role;
    private LocalDateTime added;
    private LocalDateTime deleted;
    private UUID userId;
}
