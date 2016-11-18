package net.test.models.role;

import java.util.List;

public interface RoleDao {
    public List<Role> list();

    public Role get(int id);

    public void saveOrUpdate(Role role);

    public void delete(int id);
}
