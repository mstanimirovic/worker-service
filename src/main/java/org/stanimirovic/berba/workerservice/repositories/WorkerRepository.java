package org.stanimirovic.berba.workerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stanimirovic.berba.workerservice.models.Worker;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    List<Worker> findAllByUserId(UUID userId);
    Worker findByIdAndUserId(UUID id, UUID userId);
}
