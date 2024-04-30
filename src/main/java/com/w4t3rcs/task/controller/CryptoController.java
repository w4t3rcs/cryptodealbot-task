package com.w4t3rcs.task.controller;

import com.w4t3rcs.task.dto.CryptoDTO;
import com.w4t3rcs.task.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/cryptos")
@RequiredArgsConstructor
public class CryptoController {
    private final CryptoService cryptoService;

    @GetMapping
    public List<CryptoDTO> getAllCryptos() {
        return cryptoService.getAllCryptos();
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<CryptoDTO> getAllCryptos(@PathVariable String symbol) {
        return ResponseEntity.ok(cryptoService.getCrypto(symbol));
    }

    @GetMapping(params = {"firstSymbol", "secondSymbol"})
    public List<CryptoDTO> getAllCryptos(@RequestParam String firstSymbol, @RequestParam String secondSymbol) {
        return List.of(
                cryptoService.getCrypto(firstSymbol),
                cryptoService.getCrypto(secondSymbol)
        );
    }
}
