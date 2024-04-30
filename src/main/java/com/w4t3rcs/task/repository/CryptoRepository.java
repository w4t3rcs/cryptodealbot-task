package com.w4t3rcs.task.repository;

import com.w4t3rcs.task.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, String> {
}
