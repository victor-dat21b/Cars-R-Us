package dat3.cars.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//-----------
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;



    @ManyToOne
    Member member;

    @ManyToOne
    Car car;

    @CreationTimestamp
    LocalDateTime reservationDate;


    LocalDate rentalDate;

    public Reservation(Member member, Car car, LocalDate localDate) {
        this.member = member;
        member.addReservation(this);
        this.car = car;
        car.addReservation(this);
        this.rentalDate = localDate;
    }




}
