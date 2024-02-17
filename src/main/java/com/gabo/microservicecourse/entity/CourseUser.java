package com.gabo.microservicecourse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "course_user")
@Getter
@Setter
public class CourseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id" , unique = true)
    private Long user_id;


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (!(obj instanceof CourseUser)){
            return false;
        }
        CourseUser obja = (CourseUser) obj;

        return this.user_id != null && this.user_id.equals(obja.user_id);
    }
}
