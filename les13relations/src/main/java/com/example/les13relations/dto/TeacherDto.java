package com.example.les13relations.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherDto {
    public Long id;

    @NotBlank
    public String firstName;

    @Size(min = 3, max = 255)
    public String lastName;

    @Past
    public LocalDate dob;

    public List<String> courseTitles = new ArrayList<>();
}
