package com.company.controller;

import com.company.dto.JobDto;
import com.company.exceptions.JobAlreadyExistsException;
import com.company.exceptions.JobNotFoundException;
import com.company.model.Job;
import com.company.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JobDto jobDto) {
        Job job;
        try {
            if (jobService.findJobByTitle(jobDto.getTitle()).isPresent())
                throw new JobAlreadyExistsException("Job already exists!");
            job = jobService.save(jobDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(job);
        } catch (JobAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Job> findJobByUUID(@PathVariable UUID uuid) {
        return jobService.findJobByUUID(uuid)
                .map(app -> ResponseEntity.ok().body(app))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> updateJobByUUID(@PathVariable UUID uuid, @RequestBody JobDto jobDto) {
        Job job;
        try {
            if (jobService.findJobByUUID(uuid).isEmpty())
                throw new JobNotFoundException("Job not found!");
            job = jobService.updateJobByUUID(uuid, jobDto);
            return ResponseEntity.ok().body(job);
        } catch (JobNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deleteJobByUUID(@PathVariable UUID uuid) {
        UUID statusId;
        try {
            if (!jobService.findJobByUUID(uuid).isPresent())
                throw new JobNotFoundException("Job not found!");
            statusId = jobService.deleteJobByUUID(uuid);
            return ResponseEntity.ok().body(statusId);
        } catch (JobNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
