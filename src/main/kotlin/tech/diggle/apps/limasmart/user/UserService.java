package tech.diggle.apps.limasmart.user;

import java.security.Principal;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}