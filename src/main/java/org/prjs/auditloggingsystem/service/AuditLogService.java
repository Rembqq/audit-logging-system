package org.prjs.auditloggingsystem.service;

import lombok.RequiredArgsConstructor;
import org.prjs.auditloggingsystem.model.AuditLog;
import org.prjs.auditloggingsystem.repository.AuditLogRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService {
    private final AuditLogRepository repository;

    public void logAction(String username, String action, String details) {
        AuditLog log = AuditLog.builder()
                .username(username)
                .action(action)
                .details(details)
                .timestamp(LocalDateTime.now())
                .build();
        repository.save(log);
    }
    public List<AuditLog> getUserLogs(String username) {
        return repository.findByUsername(username);
    }
}
