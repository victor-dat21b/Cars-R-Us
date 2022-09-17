package dat3.cars.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode  // When performance becomes important, never set like this

@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int pricePrDay;


    private int bestDiscount;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;





    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();




    public Car(String brand, String model, int pricePrDay) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }


    public void addReservation(Reservation res){
        reservations.add(res);
    }

}
