package org.prjs.auditloggingsystem.kafka;

import lombok.RequiredArgsConstructor;
import org.prjs.auditloggingsystem.model.AuditLog;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogProducer {
    private final KafkaTemplate<String, AuditLog> kafkaTemplate;

    public void sendLog(AuditLog log) {
        kafkaTemplate.send("audit_logs", log);
    }

}
