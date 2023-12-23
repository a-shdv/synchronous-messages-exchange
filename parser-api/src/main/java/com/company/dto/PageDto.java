package com.company.dto;

import com.company.model.Page;
import lombok.Getter;

public record PageDto(@Getter String jobUrl) {
    public PageDto(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public static Page toPage(PageDto pageDto) {
        return Page.builder()
                .jobUrl(pageDto.getJobUrl())
                .build();
    }
}
