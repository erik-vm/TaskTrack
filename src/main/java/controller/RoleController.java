package controller;

import jakarta.validation.Valid;
import model.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.RoleService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Validated
@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Role saveRole(@Valid @RequestBody Role role) {
        return service.saveRole(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRoleById(@PathVariable("id") Long id, @RequestBody Role role) {
        Role roleToUpdate = service.updateRoleById(id, role);
        if (roleToUpdate == null) {
            return new ResponseEntity<>("Role update failed! Check id!", BAD_REQUEST);
        }
        return new ResponseEntity<>(roleToUpdate, OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable("id") Long id) {
        Role roleToFind = service.getRoleById(id);
        if (roleToFind == null) {
            return new ResponseEntity<>("Role not found! Check id!", BAD_REQUEST);
        }
        return new ResponseEntity<>(roleToFind, OK);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return service.getAllRoles();
    }
}
