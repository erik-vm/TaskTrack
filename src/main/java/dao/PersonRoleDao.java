package dao;

import model.PersonRole;

import java.util.List;

public interface PersonRoleDao {

    PersonRole savePersonRole(PersonRole personRole);

    PersonRole getPersonRoleById(Long id);

    List<PersonRole> getAllPersonRoles();
}
