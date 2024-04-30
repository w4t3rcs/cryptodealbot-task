package com.w4t3rcs.task.service.impl;

import com.w4t3rcs.task.dto.CryptoDTO;
import com.w4t3rcs.task.service.CryptoService;
import com.w4t3rcs.task.service.ExchangeProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExchangeProcessorServiceImpl implements ExchangeProcessorService {
    private final CryptoService cryptoService;
    private final RestClient restClient;

    @Override
    @Async
    @Scheduled(fixedDelay = 5000)
    public void process() {
        Arrays.stream(Objects.requireNonNull(restClient.get()
                .uri("https://fapi.binance.com/fapi/v1/premiumIndex")
                .retrieve()
                .body(CryptoDTO[].class)))
                .forEach(cryptoService::saveCrypto);
    }
}
