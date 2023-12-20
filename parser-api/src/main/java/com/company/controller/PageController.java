package com.company.controller;

import com.company.dto.PageDto;
import com.company.exception.PageNotFoundException;
import com.company.model.Page;
import com.company.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pages")
public class PageController {
    private final PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PageDto pageDto) {
        Page page;
        page = pageService.save(pageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(page);
    }

    @GetMapping
    public List<Page> findAll() {
        return pageService.findAll();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Page> findPageByUUID(@PathVariable UUID uuid) {
        return pageService.findPageByUUID(uuid)
                .map(app -> ResponseEntity.ok().body(app))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> updatePageByUUID(@PathVariable UUID uuid, @RequestBody PageDto pageDto) {
        Page page;
        try {
            if (pageService.findPageByUUID(uuid).isEmpty())
                throw new PageNotFoundException("Page not found!");
            page = pageService.updatePageByUUID(uuid, pageDto);
            return ResponseEntity.ok().body(page);
        } catch (PageNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deletePageByUUID(@PathVariable UUID uuid) {
        UUID statusId;
        try {
            if (!pageService.findPageByUUID(uuid).isPresent())
                throw new PageNotFoundException("Page not found!");
            statusId = pageService.deletePageByUUID(uuid);
            return ResponseEntity.ok().body(statusId);
        } catch (PageNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/find-job-info/{uuid}")
    public ResponseEntity<?> findJobInfo(@PathVariable UUID uuid) {
        return ResponseEntity.ok().body(pageService.findJobInfo(uuid));
    }

}
