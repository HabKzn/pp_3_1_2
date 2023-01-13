package academy.cata.pp_3_1_2.dao;

import academy.cata.pp_3_1_2.model.User;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
   private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("SELECT u from User u").getResultList();
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.createQuery("DELETE FROM User WHERE id = :userId")
                .setParameter("userId", userId).executeUpdate();
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);
    }
}
