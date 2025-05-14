package com.sachin.task.services;

import com.sachin.task.domain.entities.TaskList;
import com.sachin.task.repositories.TaskListRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService{

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTasklist(TaskList taskList) {

        if(null!= taskList.getId()){
            throw new IllegalArgumentException("task list already hasan id .");
        }

        if(null==taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("tasklist title must be present .");
        }

        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(null,taskList.getTitle(),taskList.getDescription(),now,now,null));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTasklist(UUID id, TaskList taskList) {
        if(null==taskList.getId()){
            throw new IllegalArgumentException("TaskList must have an id");
        }

        if (!Objects.equals(taskList.getId().toString(), id.toString())) {
            throw new IllegalArgumentException(
                    "Attempting to change task list ID, this is not permitted!");
        }

        TaskList existingTaskList = taskListRepository.findById(id).orElseThrow(()->new IllegalStateException("Task List not found !")) ;

                existingTaskList.setTitle(taskList.getTitle());
                existingTaskList.setDescription(taskList.getDescription());
                existingTaskList.setUpdated(LocalDateTime.now());

        return taskListRepository.save(existingTaskList);

    }

    @Override
    public void deleteTaskList(UUID id) {
        taskListRepository.deleteById(id);
    }
}
