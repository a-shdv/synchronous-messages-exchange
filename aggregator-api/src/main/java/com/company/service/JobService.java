package com.company.service;

import com.company.dto.JobDto;
import com.company.model.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobService {
    Job save(JobDto job);
    List<Job> findAll();
    Optional<Job> findJobByUUID(UUID uuid);
    Optional<Job> findJobByTitle(String title);
    Job updateJobByUUID(UUID uuid, JobDto jobDto);
    UUID deleteJobByUUID(UUID uuid);
}
