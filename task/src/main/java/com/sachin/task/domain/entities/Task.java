package com.sachin.task.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name ="task")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id" , updatable = false , nullable = false)
    private UUID id;

    @Column(name = "taskname" , nullable = false)
    private String taskname;

    @Column(name = "description")
    private String description ;

    @Column(name="due_date")
    private LocalDateTime due_date;

    @Column(name="taskstatus", nullable = false)
    private TaskStatus taskstatus ;

    @Column(name="priority", nullable = false)
    private TaskPriority priority ;

    @Column(name="created", nullable = false)
    private  LocalDateTime created ;

    @Column(name="updated", nullable = false)
    private LocalDateTime updated ;

    public Task() {
    }

    public Task(UUID id, String taskname, String description, LocalDateTime due_date, TaskStatus taskstatus, TaskPriority priority, LocalDateTime updated, LocalDateTime created) {
        this.id = id;
        this.taskname = taskname;
        this.description = description;
        this.due_date = due_date;
        this.taskstatus = taskstatus;
        this.priority = priority;
        this.updated = updated;
        this.created = created;
    }

    public UUID getId() {
        return id;
    }

    public String getTaskname() {
        return taskname;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getTaskstatus() {
        return taskstatus;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public void setTaskstatus(TaskStatus taskstatus) {
        this.taskstatus = taskstatus;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskname='" + taskname + '\'' +
                ", description='" + description + '\'' +
                ", due_date=" + due_date +
                ", taskstatus=" + taskstatus +
                ", priority=" + priority +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(taskname, task.taskname) && Objects.equals(description, task.description) && Objects.equals(due_date, task.due_date) && taskstatus == task.taskstatus && priority == task.priority && Objects.equals(created, task.created) && Objects.equals(updated, task.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskname, description, due_date, taskstatus, priority, created, updated);
    }
}
