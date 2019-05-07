package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.models.Auth;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component("authRepositoryHibernateImpl")
public class AuthRepositoryHibernateImpl implements AuthRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Auth findByCookieValue(String cookieValue) {
        Query q = em.createQuery("SELECT u FROM Auth u WHERE cookieValue = :val");
        q.setParameter("val", cookieValue);
        Auth u = (Auth) q.getSingleResult();
        return Optional.ofNullable(u).get();
    }


    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Auth find(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void save(Auth model) {
        Query q = em.createNativeQuery("insert into auth(user_id, cookie_value) values (?, ?)");
        q.setParameter(1, model.getUserId());
        q.setParameter(2, model.getCookieValue());
        q.executeUpdate();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Auth model) {

    }
}
