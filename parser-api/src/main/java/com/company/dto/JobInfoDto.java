package com.company.dto;

import lombok.Getter;

public record JobInfoDto(@Getter String title, @Getter String description) {
    public JobInfoDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
