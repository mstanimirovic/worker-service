package org.stanimirovic.berba.workerservice.services;

import org.springframework.stereotype.Service;
import org.stanimirovic.berba.workerservice.dto.WorkerRequestDTO;
import org.stanimirovic.berba.workerservice.dto.WorkerResponseDTO;
import org.stanimirovic.berba.workerservice.exceptions.WorkerNotAssociatedWithUserException;
import org.stanimirovic.berba.workerservice.exceptions.WorkerNotFoundException;
import org.stanimirovic.berba.workerservice.mappers.WorkerMapper;
import org.stanimirovic.berba.workerservice.models.Worker;
import org.stanimirovic.berba.workerservice.repositories.WorkerRepository;

import java.util.List;
import java.util.UUID;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    public WorkerService(final WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker verifyWorkerAndUserRelation(final UUID userId, final UUID workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new WorkerNotFoundException("Worker " + workerId + " not found"));
        if (!worker.getUserId().equals(userId)) {
            throw new WorkerNotAssociatedWithUserException("Worker with id " + workerId + " not associated with user " + userId);
        }
        return worker;
    }

    public List<WorkerResponseDTO> getWorkers(final UUID userId) {
        List<Worker> workers = workerRepository.findAllByUserId(userId);
        return workers.stream().map(WorkerMapper::toDTO).toList();
    }

    public WorkerResponseDTO getWorkerById(final UUID userId, final UUID workerId) {
        Worker worker = verifyWorkerAndUserRelation(userId, workerId);
        return WorkerMapper.toDTO(worker);
    }

    public WorkerResponseDTO createWorker(final UUID userId, final WorkerRequestDTO dto) {
        Worker worker = WorkerMapper.toEntity(dto);
        Worker newWorker = workerRepository.save(worker);
        return WorkerMapper.toDTO(newWorker);
    }

    public void deleteWorker(final UUID userId, final UUID workerId) {
        Worker worker = verifyWorkerAndUserRelation(userId, workerId);
        workerRepository.delete(worker);
    }
}
