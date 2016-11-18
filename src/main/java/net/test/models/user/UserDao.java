package net.test.models.user;

import java.util.List;

public interface UserDao {
    public List<User> list();

    public User get(long id);

    public void saveOrUpdate(User user);

    public void delete(int id);
}