package com.company.service.impl;

import com.company.dto.JobDto;
import com.company.model.Job;
import com.company.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JobService implements com.company.service.JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    @Transactional
    public Job save(JobDto jobDto) {
        return jobRepository.save(JobDto.toJob(jobDto));
    }

    @Override
    @Transactional
    public List<Job> findAll(){
        return jobRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Job> findJobByUUID(UUID uuid) {
        return Optional.ofNullable(jobRepository.findById(uuid).get());
    }

    @Override
    @Transactional
    public Optional<Job> findJobByTitle(String title) {
        return Optional.ofNullable(jobRepository.findJobByTitle(title)).get();
    }

    @Override
    @Transactional
    public Job updateJobByUUID(UUID uuid, JobDto jobDto) {
        Job job = jobRepository.findById(uuid).get();
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        return jobRepository.save(job);
    }

    @Override
    @Transactional
    public UUID deleteJobByUUID(UUID uuid) {
        jobRepository.deleteById(uuid);
        return uuid;
    }
}