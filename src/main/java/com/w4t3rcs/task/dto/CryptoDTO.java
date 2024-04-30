package com.w4t3rcs.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.w4t3rcs.task.entity.Crypto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoDTO implements Serializable {
    private String symbol;
    private float markPrice;

    public static CryptoDTO fromCrypto(Crypto crypto) {
        return new CryptoDTO(crypto.getSymbol(), crypto.getMarkPrice());
    }

    public Crypto toCrypto() {
        return new Crypto(this.getSymbol(), this.getMarkPrice());
    }
}
