package com.example.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskList")
public class Task {

    @Id
    private String id;
    private String name;
    private Boolean done;
    private String description;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getDone() {
        return done;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
