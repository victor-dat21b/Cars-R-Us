package dat3.cars.configuration;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import dat3.cars.service.ReservationService;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import dat3.security.repository.UserWithRolesRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class SetupDevUsersAndCar implements ApplicationRunner {


    CarRepository carRepository;
    MemberRepository memberRepository;
    UserWithRolesRepository userWithRolesRepository;
    String passwordUsedByAll;

    ReservationService reservationService;



    public SetupDevUsersAndCar(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository, CarRepository carRepository, ReservationService reservationService) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.reservationService = reservationService;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        //setupUserWithRoleUsers();
        //setupCar();
        //setupReservations();
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

        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        Car car1 = new Car("Toyota", "Aygo", 900);
        Car car2 = new Car("Bmw", "X1", 15000);
        Car car3 = new Car("Suzuki", "Swift", 1100);
        Car car4 = new Car("Merdedes", "Cla200", 15000);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);


        //Reservation res1 = new Reservation(member1, car1, LocalDate.of(2022,11,9));
        memberRepository.save(member1);
        carRepository.save(car1);
        //this.reservationService.reserveCar("m1", 1,LocalDate.of(2022,11,9));

    }

    public void setupCar(){

    }

    public void setupReservations(){
        /*
        Reservation reservation1 = new Reservation();
        reservation1.setReservationDate(LocalDateTime.now());
        reservation1.setMember(memberRepository.findAll().get(0));
        reservation1.setCar(carRepository.findAll().get(0));

         */

    }
}
