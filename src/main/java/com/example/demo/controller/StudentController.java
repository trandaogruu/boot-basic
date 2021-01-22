package com.example.demo.controller;

import com.example.demo.model.bo.StudentFBC;
import com.example.demo.model.entities.StudentEntity;
import com.example.demo.model.in.StudentIn;
import com.example.demo.model.in.UpdatePasswordIn;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student-management")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @PostMapping(value = "/students")
    public StudentEntity create (@RequestBody StudentIn studentEntityIn){
        return null;
    }

    @PutMapping(value = "/students")
    public StudentEntity update (@RequestBody StudentIn studentEntityIn){
        return null;
    }

    @DeleteMapping(value = "/students/{id}")
    public String delete (@PathVariable int idClass){
        return null;
    }

    @GetMapping
    public List<StudentEntity> findAll(@RequestParam(value = "idClass") int idClass,
                                       @RequestParam(value = "page")int page,
                                       @RequestParam(value = "limit") int limit){
        return null;
    }

    @GetMapping(value = "/students/{id}")
    public List<StudentEntity> findById(@PathVariable(value = "id")int id){
        return null;
    }

    @PutMapping(value = "/students/{id}/name")
//    /api/v1/student-management/students/2?name=name+
    public List<StudentEntity> updateName(@PathVariable(value = "id")int id,
                                        @RequestParam(value = "name")int name){
        return null;
    }
    @PutMapping(value = "/students/{id}/password")
    public StudentEntity updatePassword (@PathVariable(value = "id")int id,
                                         @RequestBody UpdatePasswordIn updatePasswordIn){
        return null;
    }


    @PutMapping(value = "/students/reset-password")
    public StudentEntity retrievalPassword (@RequestBody StudentIn studentEntityIn){
        return null;
    }

    @GetMapping(value = "/students/filter")
    public List<StudentEntity> findByFullNameAndBirthdayAndClass(
                                        @RequestParam(value = "fullName") int fullname,
                                        @RequestParam(value = "birthday") int birthday,
                                        @RequestParam(value = "classid") int classid,
                                       @RequestParam(value = "page")int page,
                                       @RequestParam(value = "limit") int limit){

        StudentFBC studentFBC = new StudentFBC();
        return null;
    }

    @GetMapping(value = "/css/{idClass}/student/{id}")
    public List<StudentEntity> findStudentByClassId(@PathVariable(value = "id")int id,
                                                    @PathVariable(value = "idClass")int idClass
    ){
        return null;
    }
}
