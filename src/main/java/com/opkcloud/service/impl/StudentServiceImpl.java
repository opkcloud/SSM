package com.opkcloud.service.impl;

import com.opkcloud.dao2.TStudentMapper;
import com.opkcloud.model.TStudent;
import com.opkcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TStudentMapper studentMapper;

    @Override
    public TStudent getStudentById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

}
