package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.service.JavaCompilerImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JavaCompilerController {

    @PostMapping("/compile")
    public String compile(@RequestBody String code){
        String result = JavaCompilerImpl.compileAndExecuteJavaCode(code);
        return result;
    }
}
