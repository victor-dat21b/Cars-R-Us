package dat3.cars.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Member extends UserWithRoles {

    @Column(length = 50)
    String firstName;


    @Column(length = 50)
    String lastName;

    public Member(String username, String email, String password, boolean enabled, LocalDateTime created, LocalDateTime edited, List<Role> roles, String firstName) {
        super(username, email, password, enabled, created, edited, roles);
        this.firstName = firstName;
    }

    public Member(String username, String email, String password, String firstName, String lastName) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Member(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
