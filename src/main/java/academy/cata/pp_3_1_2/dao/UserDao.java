package academy.cata.pp_3_1_2.dao;

import academy.cata.pp_3_1_2.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void deleteUser(int id);

    void saveUser(User user);

    User getUser(int id);
}
