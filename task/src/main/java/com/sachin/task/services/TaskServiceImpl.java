package com.sachin.task.services;

import com.sachin.task.domain.entities.Task;
import com.sachin.task.domain.entities.TaskList;
import com.sachin.task.domain.entities.TaskPriority;
import com.sachin.task.domain.entities.TaskStatus;
import com.sachin.task.repositories.TaskListRepository;
import com.sachin.task.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    private  final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository ;

    public TaskServiceImpl(TaskListRepository taskListRepository, TaskRepository taskRepository) {
        this.taskListRepository = taskListRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTask(UUID tasklistId) {
        return taskRepository.findByTasklist_Id(tasklistId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if(null !=task.getId()){
            throw new IllegalArgumentException("Task already has Id .");
        }

        if(null == task.getTaskname() || task.getTaskname().isBlank()){
            throw new IllegalArgumentException("Task must have a title");
        }

        //setting priority
        TaskPriority priority ;
        if(null!=task.getPriority()){
             priority = task.getPriority();
        }
        else priority = TaskPriority.medium ;

        TaskList taskList = taskListRepository.findById(taskListId).orElseThrow(()->new IllegalArgumentException("Invalid Task List ID provided"));

        LocalDateTime now = LocalDateTime.now();

        return taskRepository.save(new Task(null,task.getTaskname(),task.getDescription(),task.getDue_date(), TaskStatus.open, priority ,now ,now ,taskList));
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository.findByTasklist_IdAndId(taskListId , taskId) ;
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
        if(null== task.getId()){
            throw new IllegalArgumentException("Task must have ID");
        }
        if(!Objects.equals(taskId , task.getId()) ) {
            throw new IllegalArgumentException("Task Ids do not match");
        }
        if(null == task.getPriority()) {
            throw  new IllegalArgumentException("Task must have vaild priority");
        }
        if(null == task.getTaskstatus()) {
            throw new IllegalArgumentException("task must have valid status");
        }

        Task existingTask = taskRepository.findByTasklist_IdAndId(taskListId ,taskId).orElseThrow(()->new IllegalStateException("task not found"));

        existingTask.setTaskname(task.getTaskname());
        existingTask.setDescription(task.getDescription());
        existingTask.setDue_date(task.getDue_date());
        existingTask.setPriority(task.getPriority());
        existingTask.setTaskstatus(task.getTaskstatus());
        existingTask.setUpdated(LocalDateTime.now());

        return taskRepository.save(existingTask);
    }

    @Transactional
    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
        taskRepository.deleteByTaskList_IdAndId(taskListId , taskId);
    }
}
