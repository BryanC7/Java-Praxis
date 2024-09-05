package cl.praxis.startup.dao;

import cl.praxis.startup.model.UserDTO;

import java.util.List;

public interface UserDAO {
    UserDTO selectUser(int id);

    List<UserDTO> selectAllUsers();

    void insertUser(UserDTO user);
    List<UserDTO> selectUsersWithAddresses();
}