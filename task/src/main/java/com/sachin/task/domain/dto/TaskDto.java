package com.sachin.task.domain.dto;


//using record to make dto object variable 'final' (immutable)

//automatically provide us Constructor for all fields
//    Getter methods (using the component names)
//    equals() and hashCode() methods
//    toString() method
//    Immutability (all fields are final)

import com.sachin.task.domain.entities.TaskPriority;
import com.sachin.task.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status

        //No created or updated timestamps - these are internal concerns
        //No taskList reference - we'll handle this relationship through URLs in our REST API
        //No JPA annotations - DTOs are simple data carriers
) { }
