package cl.praxis.reportes_inmobiliaria.services.impl;

import cl.praxis.reportes_inmobiliaria.entities.UserEntity;
import cl.praxis.reportes_inmobiliaria.repositories.IUserRepository;
import cl.praxis.reportes_inmobiliaria.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements IBaseCrud<UserEntity> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
