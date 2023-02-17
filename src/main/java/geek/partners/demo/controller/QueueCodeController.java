package geek.partners.demo.controller;

import geek.partners.demo.entity.dto.QueueCodeDto;
import geek.partners.demo.service.QueueCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class QueueCodeController {
  private final QueueCodeService queueCodeService;

  @PostMapping()
  public ResponseEntity<QueueCodeDto> generateUniqueCode() throws Exception {
    return ResponseEntity.ok(queueCodeService.generateNextQueueCode());
  }
}
