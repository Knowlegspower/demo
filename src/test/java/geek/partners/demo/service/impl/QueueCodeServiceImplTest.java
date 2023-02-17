package geek.partners.demo.service.impl;

import geek.partners.demo.repository.QueueCodeRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class QueueCodeServiceImplTest {

  @Mock private QueueCodeRepository queueCodeRepository;

  @Test
  void testGenerateQueueCodeForOneIncrease() {
    QueueCodeServiceImpl queueCodeService = new QueueCodeServiceImpl(queueCodeRepository);
    String startCode = "a0a1";
    String expectedCode = "a0a2";
    String generatedCode = queueCodeService.generateQueueCode(startCode);
    assertEquals(expectedCode, generatedCode);
  }

  @Test
  void testGenerateQueueCodeForThreeIncrease() {
    QueueCodeServiceImpl queueCodeService = new QueueCodeServiceImpl(queueCodeRepository);
    String startCode = "a0z9";
    String expectedCode = "a1a0";
    String generatedCode = queueCodeService.generateQueueCode(startCode);
    assertEquals(expectedCode, generatedCode);
  }

  @Test
  void testGenerateQueueCodeForSixIncrease() {
    QueueCodeServiceImpl queueCodeService = new QueueCodeServiceImpl(queueCodeRepository);
    String startCode = "z9z9";
    String expectedCode = "a0a0a0";
    String generatedCode = queueCodeService.generateQueueCode(startCode);
    assertEquals(expectedCode, generatedCode);
  }

  @Test
  void testGenerateQueueCodeForEightIncrease() {
    QueueCodeServiceImpl queueCodeService = new QueueCodeServiceImpl(queueCodeRepository);
    String startCode = "z9z9z9";
    String expectedCode = "a0a0a0a0";
    String generatedCode = queueCodeService.generateQueueCode(startCode);
    assertEquals(expectedCode, generatedCode);
  }
}
