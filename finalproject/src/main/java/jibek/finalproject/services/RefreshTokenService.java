package jibek.finalproject.services;

import jibek.finalproject.entities.RefreshToken;
import jibek.finalproject.repositories.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public RefreshToken generateRefreshToken() {
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setToken(UUID.randomUUID().toString());
        refreshTokenEntity.setDate(new Date(System.currentTimeMillis() + 86400 * 1000)); // Пример срока действия - 24 часа
        return refreshTokenRepository.save(refreshTokenEntity);
    }

    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
}
