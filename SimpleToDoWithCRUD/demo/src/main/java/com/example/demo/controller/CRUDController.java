package com.example.demo.controller;

import com.example.demo.dao.TaskDAO;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//localhost:8080/api1.0/students/1
@Controller
@RequestMapping("/api1.0/tasks")
public class CRUDController {

    private TaskDAO taskDAO;

    @Autowired
    public CRUDController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", taskDAO.getTasks());
        return "index";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }


    @PostMapping
    public String create(@ModelAttribute("task") Task task) {
        taskDAO.save(task);
        return "redirect:/api1.0/tasks";
    }

    @GetMapping("/{keyword}/filter")
    public String filter(@PathVariable("keyword") String keyword) {
        taskDAO.filter(keyword);
        return "index";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskDAO.find(id));
        System.out.println(taskDAO.find(id));
        return "edit";
    }



    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskDAO.delete(id);
        return "redirect:/api1.0/tasks";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("task") Task updatedTask) {
        taskDAO.update(id, updatedTask);
        return "redirect:/api1.0/tasks";
    }




}

