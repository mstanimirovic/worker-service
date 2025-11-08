package org.stanimirovic.berba.workerservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true)
    private String email;

    private String description;

    @Enumerated(EnumType.STRING)
    private WorkerPaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private WorkerRole role;

    private LocalDateTime added;
    private LocalDateTime deleted;

    @Column(nullable = false)
    private UUID userId;
}
