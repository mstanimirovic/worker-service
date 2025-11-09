package org.stanimirovic.berba.workerservice.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stanimirovic.berba.workerservice.dto.WorkerRequestDTO;
import org.stanimirovic.berba.workerservice.dto.WorkerResponseDTO;
import org.stanimirovic.berba.workerservice.models.Worker;
import org.stanimirovic.berba.workerservice.services.WorkerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users/{userId}/workers")
public class WorkerController {
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<WorkerResponseDTO>> getWorkers(@PathVariable UUID userId) {
        return ResponseEntity.ok(workerService.getWorkers(userId));
    }

    @GetMapping("/{workerId}")
    public ResponseEntity<WorkerResponseDTO> getWorkerById(@PathVariable UUID userId, @PathVariable UUID workerId) {
        return ResponseEntity.ok(workerService.getWorkerById(userId, workerId));
    }

    @PostMapping
    public ResponseEntity<WorkerResponseDTO> createWorker(@PathVariable UUID userId, @Valid @RequestBody WorkerRequestDTO dto) {
        return ResponseEntity.ok(workerService.createWorker(userId, dto));
    }

    @PutMapping("/{workerId}")
    public ResponseEntity<WorkerResponseDTO> updateWorker(@PathVariable UUID userId, @PathVariable UUID workerId, @RequestBody WorkerRequestDTO dto) {
        return ResponseEntity.ok(workerService.updateWorker(userId, workerId, dto));
    }

    @DeleteMapping("/{workerId}")
    public ResponseEntity<Void> deleteWorker(@PathVariable UUID userId, @PathVariable UUID workerId) {
        workerService.deleteWorker(userId, workerId);
        return ResponseEntity.ok().build();
    }
}
