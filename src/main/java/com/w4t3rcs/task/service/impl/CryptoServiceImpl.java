package com.w4t3rcs.task.service.impl;

import com.w4t3rcs.task.dto.CryptoDTO;
import com.w4t3rcs.task.exception.CryptoNotFoundException;
import com.w4t3rcs.task.repository.CryptoRepository;
import com.w4t3rcs.task.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoServiceImpl implements CryptoService {
    private final CryptoRepository cryptoRepository;

    @Override
    @Transactional
    public CryptoDTO saveCrypto(CryptoDTO cryptoDTO) {
        return CryptoDTO.fromCrypto(cryptoRepository.save(cryptoDTO.toCrypto()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CryptoDTO> getAllCryptos() {
        return cryptoRepository.findAll()
                .stream()
                .map(CryptoDTO::fromCrypto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CryptoDTO getCrypto(String symbol) {
        return CryptoDTO.fromCrypto(cryptoRepository.findById(symbol)
                .orElseThrow(CryptoNotFoundException::new));
    }
}
