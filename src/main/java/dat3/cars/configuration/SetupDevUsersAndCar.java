package dat3.cars.configuration;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

@Controller
public class SetupDevUsersAndCar implements ApplicationRunner {


    CarRepository carRepository;
    MemberRepository memberRepository;
    UserWithRolesRepository userWithRolesRepository;
    String passwordUsedByAll;




    public SetupDevUsersAndCar(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;

        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        setupUserWithRoleUsers();
        setupCar();
    }

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {

        Member member1 = new Member("m1", "pw", "m1@a.dk", "Jens", "Jensen","Elmegade", "København", "2100" );
        Member member2 = new Member("m2", "pw", "mm@a.dk", "Berit", "jOHN", "Elmegade", "København", "2100");
        Member member3= new Member("m3", "pw", "mmM@a.dk", "bENT", "bØRGE", "Elmegade", "Roskilde", "2100");
        Member member4= new Member("m4", "pw", "mmM4@a.dk", "Hans", "Brian", "Elmegade", "Roskilde", "2100");
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
    }

    public void setupCar(){
        Car car1 = new Car("Toyota", "Aygo", 1000, 200);
        Car car2 = new Car("Bmw", "X1", 1500, 250);
        carRepository.save(car1);
        carRepository.save(car2);

    }
}
