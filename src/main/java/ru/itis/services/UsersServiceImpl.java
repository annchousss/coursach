package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.forms.UserForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.models.Auth;
import ru.itis.models.Customer;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UsersRepository;

import java.util.UUID;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    @Qualifier("authRepositoryHibernateImpl")
    private AuthRepository authRepository;

    @Override
    public void signUp(SignUpForm form) {
        Customer user = Customer.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .hashPassword(encoder.encode(form.getPassword()))
                .build();

        usersRepository.save(user);
    }

    @Override
    public UserForm signIn(SignInForm form) {
        Customer user = usersRepository.findByEmail(form.getEmail());

        if (user != null && encoder.matches(form.getPassword(), user.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();

            Auth auth = Auth.builder()
                    .userId(user.getId())
                    .cookieValue(cookieValue)
                    .build();

            authRepository.save(auth);

            return UserForm.builder()
                    .auth(auth.getCookieValue())
                    .userId(user.getId())
                    .build();
        }
        return null;
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }
}