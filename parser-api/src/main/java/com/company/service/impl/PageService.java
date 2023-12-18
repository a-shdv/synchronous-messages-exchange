package com.company.service.impl;

import com.company.dto.PageDto;
import com.company.model.Page;
import com.company.repo.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PageService implements com.company.service.PageService {
    private final PageRepository pageRepository;

    @Autowired
    public PageService(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @Override
    public Page save(PageDto pageDto) {
        return pageRepository.save(PageDto.toPage(pageDto));
    }

    @Override
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    public Optional<Page> findPageByUUID(UUID uuid) {
        return Optional.ofNullable(pageRepository.findById(uuid).get());
    }

    @Override
    public Page updatePageByUUID(UUID uuid, PageDto pageDto) {
        Page page = pageRepository.findById(uuid).get();
        page.setHeader(pageDto.getHeader());
        page.setBody(pageDto.getBody());
        return pageRepository.save(page);
    }

    @Override
    public UUID deletePageByUUID(UUID uuid) {
        pageRepository.deleteById(uuid);
        return uuid;
    }
}
