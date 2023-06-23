package com.example.les13relations.service;

import com.example.les13relations.dto.TeacherDto;
import com.example.les13relations.exception.ResourceNotFoundException;
import com.example.les13relations.model.Course;
import com.example.les13relations.model.Teacher;
import com.example.les13relations.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository repos;

    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    public Long createTeacher(TeacherDto tdto) {

        // mapping
        Teacher t = new Teacher();
        t.setFirstName(tdto.firstName);
        t.setLastName(tdto.lastName);
        t.setDob(tdto.dob);

        repos.save(t);

        return t.getId();
    }

    public TeacherDto getTeacher(Long id) {
        Teacher t = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        // mapping
        TeacherDto tdto = new TeacherDto();
        tdto.id = t.getId();
        tdto.firstName = t.getFirstName();
        tdto.lastName = t.getLastName();
        tdto.dob = t.getDob();

        for (Course c : t.getCourses()) {
            tdto.courseTitles.add(c.getTitle());
        }

        return tdto;
    }
}
