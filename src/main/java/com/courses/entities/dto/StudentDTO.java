package com.courses.entities.dto;

import com.courses.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO implements Serializable {

    private Integer id;

    @Column(nullable = false)
    @NonNull
    private String name;
}
