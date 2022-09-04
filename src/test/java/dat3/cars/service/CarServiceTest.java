package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CarServiceTest {

    public  CarService carServiceTest;
    public static CarRepository carRepositoryTest;


    @BeforeAll
    public static void setupTestCars(@Autowired CarRepository car_RepositoryTest){
        carRepositoryTest = car_RepositoryTest;

        Car car1 = new Car("Toyota", "Aygo", 900);
        Car car2 = new Car("Bmw", "X1", 15000);
        Car car3 = new Car("Suzuki", "Swift", 1100);
        Car car4 = new Car("Merdedes", "Cla200", 15000);
        carRepositoryTest.save(car1);
        carRepositoryTest.save(car2);
        carRepositoryTest.save(car3);
        carRepositoryTest.save(car4);




    }

    @BeforeEach
    public void setCarServiceTest(){
        carServiceTest = new CarService(carRepositoryTest);
    }


    @Test
    void findCarsTest() {
        assertEquals(carServiceTest.getCars(false).get(0).getId(), 1);
        }

    @Test
    void addCarTest() {
        CarRequest car5 = new CarRequest(new Car("Tesla", "Model 3", 16000));
        assertEquals(carServiceTest.addCar(car5).getModel(), car5.getModel());
        System.out.println(carServiceTest.getCars(false));
    }

    @Test
    void findCarByIdTest() throws Exception {
        assertEquals(1, carServiceTest.findCarById(1, false).getId());
    }

    @Test
    void editCarTest() throws Exception {
        CarRequest car = new CarRequest(new Car("Tesla", "Model 3", 16000));
        carServiceTest.editCar(car, 2);
    }

    @Test
    void discountCarTest() throws Exception {
        carServiceTest.setDiscountForCar(1, 50);
        assertEquals(50, carServiceTest.findCarById(1, true).getBestDiscount());
    }


    @Test
    void deleteCarTest() {
        carServiceTest.deleteById(1);
        Exception exception = assertThrows(Exception.class, () -> carServiceTest.findCarById(1, false));
        assertEquals("404 NOT_FOUND \"Car not found\"", exception.getMessage());
    }





}
