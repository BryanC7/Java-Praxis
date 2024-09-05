package cl.praxis.startup.services;

import cl.praxis.startup.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO selectUser(int id);
    List<UserDTO> selectAllUsers();
    Optional<UserDTO> filterUser(String email, String password);
    Optional<UserDTO> filterUserRegister(String email, String nick);
    void insertUser(UserDTO user);
    UserDTO searchLastUser();
    List<UserDTO> selectUsersWithAddresses();
}