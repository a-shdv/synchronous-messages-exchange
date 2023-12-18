package com.company.dto;

import com.company.model.Page;
import lombok.Getter;

public record PageDto(@Getter String header, @Getter String body) {
    public PageDto(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public static Page toPage(PageDto pageDto) {
        return Page.builder()
                .header(pageDto.getHeader())
                .body(pageDto.getBody())
                .build();
    }
}
