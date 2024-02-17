package com.gabo.microservicecourse.entity;


import com.gabo.microservicecourse.entity.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nameCourse;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CourseUser> cursoXusers;

    @Transient
    private List<User> usersList;

    public Course() {
        cursoXusers = new ArrayList<>();
        usersList = new ArrayList<>();
    }

    public void addCourseUser(CourseUser courseUserAdd){
        cursoXusers.add(courseUserAdd);
    }
    public void removeCourseUser(CourseUser courseUserDelete){
        cursoXusers.remove(courseUserDelete);
    }


}
