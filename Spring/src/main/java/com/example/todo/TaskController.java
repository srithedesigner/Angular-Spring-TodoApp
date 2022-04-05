package com.example.todo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.websocket.server.PathParam;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.where;

@CrossOrigin("*")
@RestController
@RequestMapping(path="api")
public class TaskController{

    private final TaskRepository taskRepository;

    @Autowired
    public  TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @GetMapping(value = "tasks/{taskID}")
    public Task getTask(@PathVariable final String taskID) {
        return taskRepository.findById(taskID).orElseGet(Task::new);
    }

    @PostMapping(value = "add")
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
    }


    @PostMapping(value = "flip")
    public Task flip(@RequestParam(value = "taskID") String taskID){

        Optional<Task> task = taskRepository.findById(String.valueOf(new ObjectId(taskID)));
        Task tsk;
        if(task.isPresent())
        {
            tsk = task.get();
            tsk.setDone(!tsk.getDone());
            return taskRepository.save(tsk);
        }

        return null;

    }


}
