package geek.partners.demo.service;

import geek.partners.demo.entity.dto.QueueCodeDto;

public interface QueueCodeService {
    QueueCodeDto generateNextQueueCode() throws Exception;
}
