package service;

import model.PersonRole;

import java.util.List;

public interface PersonRoleService {

    PersonRole startPersonRole(PersonRole personRole);

    PersonRole finishPersonRoleById(Long id, PersonRole personRole);

    PersonRole getPersonRoleById(Long id);

    List<PersonRole> getPersonRoles();
}
