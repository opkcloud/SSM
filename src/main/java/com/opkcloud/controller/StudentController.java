package com.opkcloud.controller;

import com.opkcloud.model.TStudent;
import com.opkcloud.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询学生信息", httpMethod = "GET", notes = "根据id查询学生信息")
    public TStudent getStudentById(@RequestParam int id) {
        return studentService.getStudentById(id);
    }

    @PostConstruct
    @Scheduled(cron = "* * * * * ?")
    public void printNum() {
        System.out.println("注解定时任务" + System.currentTimeMillis());
    }

}
