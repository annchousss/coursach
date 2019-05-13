package ru.itis.services;

import ru.itis.repositories.AuthRepository;

public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }
}
