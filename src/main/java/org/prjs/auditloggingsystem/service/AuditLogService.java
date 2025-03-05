package org.prjs.auditloggingsystem.service;

import lombok.RequiredArgsConstructor;
import org.prjs.auditloggingsystem.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogService {
    private final AuditLogRepository auditLogRepository;


}
