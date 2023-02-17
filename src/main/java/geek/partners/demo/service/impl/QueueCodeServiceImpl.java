package geek.partners.demo.service.impl;

import geek.partners.demo.entity.QueueCode;
import geek.partners.demo.entity.dto.QueueCodeDto;
import geek.partners.demo.repository.QueueCodeRepository;
import geek.partners.demo.service.QueueCodeService;
import geek.partners.demo.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueueCodeServiceImpl implements QueueCodeService {
  private final QueueCodeRepository queueCodeRepository;

  @Override
  public QueueCodeDto generateNextQueueCode() throws Exception {
    log.info(Constants.START_OF_EXECUTION_OF_GENERATE_NEXT_QUEUE_CODE_METHOD);

    Optional<QueueCode> optionalQueueCode = queueCodeRepository.findById(1L);
    if (optionalQueueCode.isEmpty()) {
      log.error(Constants.ERROR_THERE_IS_NO_INITIAL_CODE_IN_DATABASE);
      throw new Exception(Constants.ERROR_THERE_IS_NO_INITIAL_CODE_IN_DATABASE);
    }

    QueueCode queueCode = optionalQueueCode.get();
    queueCode.setCode(generateQueueCode(queueCode.getCode()));
    queueCodeRepository.save(queueCode);

    log.info(Constants.END_OF_EXECUTION_OF_GENERATE_NEXT_QUEUE_CODE_METHOD);
    return new QueueCodeDto(queueCode.getCode());
  }

  public String generateQueueCode(String code) {
    log.info(Constants.START_OF_CODE_GENERATION);
    char[] charArray = code.toCharArray();

    for (int i = charArray.length - 1; i >= 0; i--) {
      char currentChar = charArray[i];
      switch (currentChar) {
        case Constants.NINE -> charArray[i] = Constants.ZERO;
        case Constants.Z -> charArray[i] = Constants.A;
        default -> {
          charArray[i] = (char) (currentChar + 1);
          return new String(charArray);
        }
      }
      if (i == 0) {
        return Constants.A0 + new String(charArray);
      }
    }

    return new String(charArray);
  }
}
