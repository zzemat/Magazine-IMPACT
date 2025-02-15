package magazin.server.service;

import magazin.server.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}