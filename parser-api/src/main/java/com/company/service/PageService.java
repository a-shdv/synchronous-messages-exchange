package com.company.service;

import com.company.dto.PageDto;
import com.company.model.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PageService {
    Page save(PageDto pageDto);
    List<Page> findAll();
    Optional<Page> findPageByUUID(UUID uuid);
    Page updatePageByUUID(UUID uuid, PageDto pageDto);
    UUID deletePageByUUID(UUID uuid);
}
