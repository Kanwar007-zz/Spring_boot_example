package com.kanwar.study.restapi.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.kanwar.study.restapi.exceptionHandle.UserNotException;
import com.kanwar.study.restapi.pojo.Student;
import com.kanwar.study.restapi.services.StudentServices;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
    @Autowired
    StudentServices studentServices;
    @GetMapping(path="/students")
    public List<Student> getAllStudent(){
        return studentServices.getAllStudent();
    }
    @GetMapping(path="/students/{id}")
    public Student getstudent(@PathVariable int id){
       Student student= studentServices.getStudent(id);
       if(student == null){
           throw new UserNotException("ID ..."+id);
       }
        return student;
    }
    @PostMapping(path="/students")
     public ResponseEntity<Object> saveStudent(@RequestBody Student student){
       Student saveStudent = studentServices.saveStudent(student);
      URI location= ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}").buildAndExpand(saveStudent.getStudentId()).toUri();

    return ResponseEntity.created(location).build();
    
     }
     @DeleteMapping(path = "/student/{id}")
     public List<Student> deleteStudent(@PathVariable int id){
         return studentServices.deleteStudent(id);
     }
}
