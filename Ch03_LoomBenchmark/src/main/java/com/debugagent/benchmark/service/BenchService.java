package com.debugagent.benchmark.service;

import com.debugagent.benchmark.db.AccessLog;
import com.debugagent.benchmark.db.AccessLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BenchService {
    private final AccessLogRepository accessLogRepository;

    @GetMapping("/withDb")
    @Transactional
    public String withDb(HttpServletRequest request) {
        AccessLog log = new AccessLog(request.getRemoteHost(), System.currentTimeMillis());
        accessLogRepository.save(log);
        return "" + log.getTime();
    }

    @GetMapping("/withoutDb")
    public String without() {
        return "" + System.currentTimeMillis();
    }
}
