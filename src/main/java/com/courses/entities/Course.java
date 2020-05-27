package com.courses.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_name", nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    private String area;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @NonNull
    @Column(name = "course_value")
    private BigDecimal courseValue;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<Student> students = new ArrayList<>();
}
