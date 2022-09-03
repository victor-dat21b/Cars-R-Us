package dat3.cars.dto;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {



    private String brand;


    private String model;


    private int pricePrDay;



    public CarRequest(Car car){
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
    }

    public static Car getCarEntity(CarRequest carRequest){
        return new Car(carRequest.getBrand(), carRequest.getModel(), carRequest.getPricePrDay());
    }

}
