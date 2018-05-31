package it.si2001.dao;

import it.si2001.model.PersistentLogin;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

import javax.persistence.NoResultException;

@Repository("persistenteTokenRepository")
@Transactional
public class PersistentTokenDaoImpl extends AbstractDao<String,PersistentLogin> implements PersistentTokenRepository {



    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        persist(persistentLogin);
    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        PersistentLogin persistentLogin = getByKey(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        update(persistentLogin);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            PersistentLogin persistentLogin = (PersistentLogin) getEntityManager()
                    .createQuery("SELECT p FROM PersistentLogin p WHERE p.series LIKE :seriesId")
                    .setParameter("seriesId", seriesId)
                    .getSingleResult();
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeUserTokens(String username) {

        PersistentLogin persistentLogin=null;
        try
        {
            persistentLogin = (PersistentLogin) getEntityManager()
                    .createQuery("SELECT p FROM PersistentLogin p WHERE p.username LIKE :username")
                    .setParameter("username", username)
                    .getSingleResult();
        }
        catch (NoResultException noR)
        {

        }

        if (persistentLogin!=null)
        {
            System.err.println("rememberMe was selected");
            delete(persistentLogin);
        }
    }
}
