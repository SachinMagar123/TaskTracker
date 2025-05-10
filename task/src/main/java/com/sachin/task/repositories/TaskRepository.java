package com.sachin.task.repositories;

import com.sachin.task.domain.entities.Task;
import com.sachin.task.domain.entities.TaskList;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task , UUID> {

List<Task> findByTaskListId(UUID tasklistid);

Optional<Task> findByTaskListIdandId(UUID tasklistid , UUID id);
}
