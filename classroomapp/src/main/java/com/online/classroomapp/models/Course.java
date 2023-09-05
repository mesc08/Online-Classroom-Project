package com.online.classroomapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    private String title;

    private String description;


    @ManyToOne
    @JoinColumn(name = "userid")
    private User instructor;

    private LocalDateTime  scheduled;
}
