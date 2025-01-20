package service.impl;

import dao.PersonRoleDao;
import model.PersonRole;
import org.springframework.stereotype.Service;
import service.PersonRoleService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonRoleServiceImpl implements PersonRoleService {

    private final PersonRoleDao dao;

    public PersonRoleServiceImpl(PersonRoleDao dao) {
        this.dao = dao;
    }

    @Override
    public PersonRole startPersonRole(PersonRole personRole) {
        personRole.setStartedAt(LocalDateTime.now());
        return dao.savePersonRole(personRole);
    }

    @Override
    public PersonRole finishPersonRoleById(Long id, PersonRole personRole) {
        PersonRole personRoleToUpdate = dao.getPersonRoleById(id);
        if (personRoleToUpdate != null) {
            personRoleToUpdate.setFinishedAt(LocalDateTime.now());
            dao.savePersonRole(personRoleToUpdate);
        }
        return personRoleToUpdate;
    }

    @Override
    public PersonRole getPersonRoleById(Long id) {
        return dao.getPersonRoleById(id);
    }

    @Override
    public List<PersonRole> getPersonRoles() {
        return dao.getAllPersonRoles();
    }
}
