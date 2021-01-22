package com.example.demo.controller;


import com.example.demo.model.entities.ClassEntity;
import com.example.demo.model.in.ClassIn;
import com.example.demo.model.out.StudentDTO;
import com.example.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/class-management/class")
public class ClassController {
    @Autowired
    private IClassService iClassService;

    @PostMapping
    public ClassEntity create (@RequestBody ClassIn classEntityIn){
        return null;
    }

    @PutMapping
    public ClassEntity update (@RequestBody ClassIn classEntityIn){
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public String delete (@PathVariable(value = "id") int id){
        return null;
    }

    @GetMapping
    public List<ClassEntity> findAll(@RequestParam(value = "page")int page,
                                     @RequestParam(value = "limit") int limit){
        return null;
    }

    @GetMapping(value = "/{id}")
    public ClassEntity findById(@PathVariable(value = "id") int id){
        return null;
    }

    @GetMapping(value = "/{id}/students")
    public ResponseEntity<List<StudentDTO>> findAllByClass(
            @PathVariable(value = "id") int idClass,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "limit") int limit){
        return null;
    }


}
