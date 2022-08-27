package dat3.cars.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Member extends UserWithRoles {

    String firstName;

    public Member(String username, String email, String password, boolean enabled, LocalDateTime created, LocalDateTime edited, List<Role> roles, String firstName) {
        super(username, email, password, enabled, created, edited, roles);
        this.firstName = firstName;
    }

    public Member(){

    }
}
