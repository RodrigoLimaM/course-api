package com.courses.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDTO implements Serializable {

    private Integer id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @JsonProperty("course")
    private CourseDTO courseDTO;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime registrationDate;
}
