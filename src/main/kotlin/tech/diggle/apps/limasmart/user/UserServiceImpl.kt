package tech.diggle.apps.limasmart.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import tech.diggle.apps.limasmart.role.RoleRepository
import java.security.Principal


@Service("userService")
class UserServiceImpl(@Qualifier("userRepository")
                      @Autowired
                      val userRepository: UserRepository) : UserService {
    @Qualifier("roleRepository")
    @Autowired
    private val roleRepository: RoleRepository? = null
    @Autowired
    private val bCryptPasswordEncoder: BCryptPasswordEncoder? = null

    override fun findUserByEmail(email: String): User? {
        return userRepository!!.findByEmail(email)
    }

    override fun saveUser(user: User) {
        user.password = bCryptPasswordEncoder!!.encode(user.password!!)
        user.active = true
        val userRole = roleRepository!!.findByRole("USER")
        user.roles = mutableSetOf(userRole)
        userRepository!!.save(user)
        if (user.email == "admina@this.app") {
            val adminRole = roleRepository.findByRole("ADMIN")
            val userRoles = user.roles
            userRoles!!.add(adminRole)
            user.roles = userRoles
            userRepository.save(user)
        }
    }

    fun addRole(roleName: String) {

    }
}