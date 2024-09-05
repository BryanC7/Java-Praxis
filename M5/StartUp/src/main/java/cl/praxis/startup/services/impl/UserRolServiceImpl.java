package cl.praxis.startup.services.impl;

import cl.praxis.startup.dao.UserRolDAO;
import cl.praxis.startup.dao.impl.UserRolDAOImpl;
import cl.praxis.startup.model.UserRolDTO;
import cl.praxis.startup.services.UserRolService;

public class UserRolServiceImpl implements UserRolService {
    private final UserRolDAO OBJ_USERADDRESS_DAO;

    public UserRolServiceImpl() {
        this.OBJ_USERADDRESS_DAO = new UserRolDAOImpl();
    }

    @Override
    public void insertUserRol(UserRolDTO userRolDTO) { OBJ_USERADDRESS_DAO.insertUserRol(userRolDTO); }
}
