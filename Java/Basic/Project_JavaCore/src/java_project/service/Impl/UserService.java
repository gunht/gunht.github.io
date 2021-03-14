package java_project.service.Impl;

import java_project.repository.IUserRepository;
import java_project.repository.Impl.UserRepository;
import java_project.entity.User;
import java_project.service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByUserName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User FindByUserNameAndPassword(String userName, String password, int status) {
        return userRepository.FindByUserNameAndPassword(userName, password, status);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public void removeUser(long userId) {
        userRepository.removeUser(userId);
    }

    @Override
    public void activeUser(long userId) {
        userRepository.activeUser(userId);
    }

}
