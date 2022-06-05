package com.example.demo.dao;

import com.example.demo.model.Task;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TaskDAO  {
    private static int id = 0;
    private List<Task> tasks = new ArrayList<>();
    {
        tasks.add(new Task(++id, "do dishes", new Date()));
        tasks.add(new Task(++id, "do homework", new Date()));
        tasks.add(new Task(++id, "do exercise", new Date()));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task find(int id) {
        for(Task task : tasks) {
            if(task.getId() == id)
                return task;
        }

        return null;
    }

    public Task filter(String keyword) {
        for(Task task : tasks)
        {
            Pattern pattern = Pattern.compile(keyword);
            Matcher matcher = pattern.matcher(task.getName());

            if(matcher.find())
            {
                return task;
            }
        }
        return null;
    }



    public void save(Task newTask) {
        newTask.setId(++id);
        newTask.setDate();
        tasks.add(newTask);

    }

    public void delete(int id) {
        tasks.remove(find(id));
    }

    public void update(int id, Task updatedTask) {
        Task task = find(id);
        task.setName(updatedTask.getName());

    }




}
