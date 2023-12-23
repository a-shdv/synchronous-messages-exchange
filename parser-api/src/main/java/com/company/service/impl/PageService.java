package com.company.service.impl;

import com.company.dto.JobInfoDto;
import com.company.dto.PageDto;
import com.company.model.Page;
import com.company.repo.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PageService implements com.company.service.PageService {
    private final PageRepository pageRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public PageService(PageRepository pageRepository, RestTemplate restTemplate) {
        this.pageRepository = pageRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public Page save(PageDto pageDto) {
        return pageRepository.save(PageDto.toPage(pageDto));
    }

    @Override
    @Transactional
    public List<Page> findAll() {
        return pageRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Page> findPageByUUID(UUID uuid) {
        return Optional.ofNullable(pageRepository.findById(uuid).get());
    }

    @Override
    @Transactional
    public Page updatePageByUUID(UUID uuid, PageDto pageDto) {
        Page page = pageRepository.findById(uuid).get();
        page.setJobUrl(pageDto.getJobUrl());
        return pageRepository.save(page);
    }

    @Override
    @Transactional
    public UUID deletePageByUUID(UUID uuid) {
        pageRepository.deleteById(uuid);
        return uuid;
    }

    @Override
    @Transactional
    public JobInfoDto findJobInfo(UUID jobUUID) {
        String jobInfoUrl = "http://nginx/aggregator-api/jobs/" + jobUUID;
        return restTemplate.getForObject(jobInfoUrl, JobInfoDto.class);
    }
}
