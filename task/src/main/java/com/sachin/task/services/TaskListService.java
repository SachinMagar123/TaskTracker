package com.sachin.task.services;

import com.sachin.task.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
}
