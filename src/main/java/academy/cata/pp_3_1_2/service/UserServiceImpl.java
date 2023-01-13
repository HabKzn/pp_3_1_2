package academy.cata.pp_3_1_2.service;

import academy.cata.pp_3_1_2.dao.UserDao;
import academy.cata.pp_3_1_2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.saveUser(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.of(userDao.getUser(id));
    }
}
