package org.prjs.auditloggingsystem.kafka;

import lombok.RequiredArgsConstructor;
import org.prjs.auditloggingsystem.model.AuditLog;
import org.prjs.auditloggingsystem.repository.AuditLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogConsumer {
    private final AuditLogRepository repository;

    @KafkaListener(topics = "audit_logs", groupId = "audit-log-group")
    public void consume(AuditLog log) {
        repository.save(log);
    }
}
