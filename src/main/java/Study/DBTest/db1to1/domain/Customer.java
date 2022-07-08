package Study.DBTest.db1to1.domain;

import Study.DBTest.db1toN.domain.Team;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public void setSeat(Seat seat) {
        this.seat = seat;
        //seat.setCustomer(this);
    }
}
