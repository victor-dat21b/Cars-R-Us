package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {


    private int id;

    private String brand;


    private String model;


    private int pricePrDay;


    private int bestDiscount;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;


    public CarResponse(Car car, boolean includeAll) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        if(includeAll){
            this.created = car.getCreated();
            this.edited = car.getEdited();
            this.bestDiscount = car.getBestDiscount();
        }
    }
}
