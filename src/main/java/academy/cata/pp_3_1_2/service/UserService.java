package academy.cata.pp_3_1_2.service;

import academy.cata.pp_3_1_2.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    void delete(int id);

    void save(User user);

    Optional<User> findById(int id);
}
