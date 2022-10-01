package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://cars-r-us-dat12b.azurewebsites.net/", maxAge = 3600)
@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    //Security --> Anonymous
    @GetMapping
    List<CarResponse> getCars()
    { return carService.getCars(false);}


    //Security --> Admin
    @GetMapping(path = "/admin")
    List<CarResponse> getCarsAdmin()
    { return carService.getCars(true);}


    //Security --> USER/ADMIN
    @GetMapping(path = "/{id}")
    CarResponse getCarById(@PathVariable int id) throws Exception {
        return carService.findCarById(id, false);
    }

    //Security --> USER/ADMIN
    //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    // same as above when you are using @RestController
    CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);

    }


    //Security --> USER/ADMIN
    @PutMapping("/{id}")
    CarResponse editCar(@RequestBody CarRequest body, @PathVariable int id) throws Exception {
        return carService.editCar(body, id);
    }

    //Security USER/ADMIN
    @PatchMapping("/discount/{id}/{value}")
    void setDiscountForCar(@PathVariable int id, @PathVariable int value) throws Exception {
        carService.setDiscountForCar(id, value);
    }

    // Security ADMIN
    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable int id) {
        carService.deleteById(id);
    }


}

