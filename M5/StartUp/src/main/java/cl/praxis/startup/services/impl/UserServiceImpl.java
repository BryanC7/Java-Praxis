package cl.praxis.startup.services.impl;

import cl.praxis.startup.dao.UserDAO;
import cl.praxis.startup.dao.impl.UserDAOImpl;
import cl.praxis.startup.model.UserDTO;
import cl.praxis.startup.services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDAO OBJ_USER_DAO;

    public UserServiceImpl() {
        this.OBJ_USER_DAO = new UserDAOImpl();
    }

    @Override
    public UserDTO selectUser(int id) { return OBJ_USER_DAO.selectUser(id); }

    @Override
    public List<UserDTO> selectAllUsers() {
        return OBJ_USER_DAO.selectAllUsers();
    }

    @Override
    public Optional<UserDTO> filterUser(String email, String password) {
        List<UserDTO> users = OBJ_USER_DAO.selectAllUsers();

        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst();
    }

    @Override
    public Optional<UserDTO> filterUserRegister(String email, String nick) {
        List<UserDTO> users = OBJ_USER_DAO.selectAllUsers();

        return users.stream()
                .filter(user -> user.getEmail().equals(email) || user.getNick().equals(nick))
                .findFirst();
    }

    @Override
    public void insertUser(UserDTO user) {
        OBJ_USER_DAO.insertUser(user);
    }

    @Override
    public UserDTO searchLastUser() {
        List<UserDTO> users = OBJ_USER_DAO.selectAllUsers();
        return users.get(users.size() - 1);
    }

    @Override
    public List<UserDTO> selectUsersWithAddresses() {
        return OBJ_USER_DAO.selectUsersWithAddresses();
    }
}