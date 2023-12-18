package com.company.dto;

import com.company.model.Job;
import lombok.Getter;

public record JobDto(@Getter String title, @Getter String description) {

    public JobDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static Job toJob(JobDto jobDto) {
        return Job.builder()
                .title(jobDto.getTitle())
                .description(jobDto.getDescription())
                .build();
    }
}
