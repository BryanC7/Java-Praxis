package cl.praxis.reportes_inmobiliaria.controllers;

import cl.praxis.reportes_inmobiliaria.entities.UserEntity;
import cl.praxis.reportes_inmobiliaria.services.IBaseCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserRestController {
    @Autowired
    private IBaseCrud<UserEntity> userService;

    @GetMapping
    public List<UserEntity> getAllReports() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity userEntity) {
        return userService.update(userEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
