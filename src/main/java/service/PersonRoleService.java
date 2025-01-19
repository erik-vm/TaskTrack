package service;

import model.PersonRole;

import java.util.List;

public interface PersonRoleService {

    PersonRole savePersonRole(PersonRole personRole);

    PersonRole updatePersonRole(PersonRole personRole);

    PersonRole getPersonRoleById(Long id);

    List<PersonRole> getPersonRoles();
}
