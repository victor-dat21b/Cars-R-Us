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


    @Autowired CarRepository carRepository;


    @BeforeAll
    public static void setupTestCars(@Autowired CarRepository carRepository){
        Car car1 = new Car("Toyota", "Aygo", 1000, 200);
        Car car2 = new Car("Bmw", "X1", 1500, 250);
        carRepository.save(car1);
        carRepository.save(car2);


    }
    @Test
    public void checkCars(){
        assertNotNull(carRepository.findAll());


    }

}