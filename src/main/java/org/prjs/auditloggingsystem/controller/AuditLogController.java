package org.prjs.auditloggingsystem.controller;

import lombok.RequiredArgsConstructor;
import org.prjs.auditloggingsystem.model.AuditLog;
import org.prjs.auditloggingsystem.service.AuditLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/logs")
public class AuditLogController {
    private final AuditLogService service;
    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AuditLog> getUserLogs(@PathVariable String username) {
        return service.getUserLogs(username);
    }
}
