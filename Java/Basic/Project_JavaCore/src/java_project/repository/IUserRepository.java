package java_project.repository;

import java_project.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    List<User> findByUserName(String name);
    User findUserById(long id);
    User FindByUserNameAndPassword(String userName, String password, int status);
    User saveUser(User user);
    void removeUser(long userId);
    void activeUser(long userId);
}
