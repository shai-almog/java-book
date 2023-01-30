package com.debugagent.benchmark.db;

import org.springframework.data.repository.CrudRepository;

public interface AccessLogRepository extends CrudRepository<AccessLog, Long> {
}
