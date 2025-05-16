package com.sachin.task.repositories;

import com.sachin.task.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task , UUID> {

List<Task> findByTasklist_Id(UUID tasklistId);

Optional<Task> findByTasklist_IdAndId(UUID tasklistId , UUID id);

void deleteByTaskList_IdAndId(UUID taskListId, UUID taskId);
}
