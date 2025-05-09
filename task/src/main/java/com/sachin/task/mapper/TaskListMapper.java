package com.sachin.task.mapper;

import com.sachin.task.domain.dto.TaskListDto;
import com.sachin.task.domain.entities.TaskList;

public interface TaskListMapper {

   TaskList fromDto(TaskListDto taskListDto);

   TaskListDto toDto(TaskList taskList);
}
