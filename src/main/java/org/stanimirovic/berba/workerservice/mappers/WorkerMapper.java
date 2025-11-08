package org.stanimirovic.berba.workerservice.mappers;

import org.stanimirovic.berba.workerservice.dto.WorkerRequestDTO;
import org.stanimirovic.berba.workerservice.dto.WorkerResponseDTO;
import org.stanimirovic.berba.workerservice.models.Worker;
import org.stanimirovic.berba.workerservice.models.WorkerPaymentType;
import org.stanimirovic.berba.workerservice.models.WorkerRole;

import java.time.LocalDateTime;

public class WorkerMapper {
    public static WorkerResponseDTO toDTO(Worker worker) {
        return WorkerResponseDTO.builder()
                .id(worker.getId())
                .name(worker.getName())
                .phone(worker.getPhone())
                .email(worker.getEmail())
                .description(worker.getDescription())
                .paymentType(worker.getPaymentType().toString())
                .role(worker.getRole().toString())
                .added(worker.getAdded())
                .deleted(worker.getDeleted())
                .userId(worker.getUserId())
                .build();
    }

    public static Worker toEntity(WorkerRequestDTO dto) {
        return Worker.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .description(dto.getDescription())
                .paymentType(WorkerPaymentType.valueOf(dto.getPaymentType()))
                .role(WorkerRole.valueOf(dto.getRole()))
                .added(LocalDateTime.now())
                .userId(dto.getUserId())
                .build();
    }
}
