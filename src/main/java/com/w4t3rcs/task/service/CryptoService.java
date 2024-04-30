package com.w4t3rcs.task.service;

import com.w4t3rcs.task.dto.CryptoDTO;

import java.util.List;

public interface CryptoService {
    CryptoDTO saveCrypto(CryptoDTO cryptoDTO);

    List<CryptoDTO> getAllCryptos();

    CryptoDTO getCrypto(String symbol);
}
