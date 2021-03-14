package java_project.repository.Impl;

import java_project.constant.Constant;
import java_project.repository.IUserRepository;
import java_project.data.CreateData;
import java_project.entity.User;
import java_project.service.IRoleService;
import java_project.service.Impl.RoleService;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends DataRepository<User> implements IUserRepository {
    private final IRoleService roleService = new RoleService();

    @Override
    public List<User> findAll() {
        return CreateData.users;
    }

    @Override
    public User findUserById(long id) {
        for (User user : findAll()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByUserName(String name) {
        List<User> newUsers = new ArrayList<>();
        for (User user : findAll()) {
            if (user.getUsername().toLowerCase().contains(name)) {
                newUsers.add(user);
            }
        }
        return newUsers;
    }

    @Override
    public User FindByUserNameAndPassword(String userName, String password, int status) {
        for (User user : CreateData.users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)
                    && user.getStatus() == Constant.STATUS_ACTIVE) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        for (User u : CreateData.users) {
            if (u.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
        user.setRole(roleService.findRoleById(user.getRoleId()));
        return add(CreateData.users, user);
    }

    @Override
    public void removeUser(long userId) {
        User user = findUserById(userId);
        user.setStatus(Constant.STATUS_NON_ACTIVE);
    }

    @Override
    public void activeUser(long userId) {
        User user = findUserById(userId);
        user.setStatus(Constant.STATUS_ACTIVE);
    }
}
