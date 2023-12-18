package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Job {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
}
