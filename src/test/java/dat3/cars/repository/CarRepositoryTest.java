package dat3.cars.repository;

import dat3.cars.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CarRepositoryTest {


   public static CarRepository carRepository;


    @BeforeAll
    public static void setupTestCars(@Autowired CarRepository car_Repository){
        carRepository = car_Repository;
        /*
        Car car1 = new Car("Toyota", "Aygo", 900);
        Car car2 = new Car("Bmw", "X1", 15000);
        Car car3 = new Car("Suzuki", "Swift", 1100);
        Car car4 = new Car("Merdedes", "Cla200", 15000);
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);



         */
        System.out.println(car_Repository.findAll());

    }

}