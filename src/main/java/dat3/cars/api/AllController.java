package dat3.cars.api;

import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllController {

    CarRepository carRepository;
    MemberRepository memberRepository;
    UserWithRolesRepository userWithRolesRepository;
    String passwordUsedByAll;



    public AllController(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }




    @GetMapping("/api/allusers")
    public String showDatabase(){
        return userWithRolesRepository.findAll().toString() + carRepository.findAll().toString();

    }



}
