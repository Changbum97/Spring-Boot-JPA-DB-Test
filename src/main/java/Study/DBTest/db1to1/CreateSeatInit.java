package Study.DBTest.db1to1;

import Study.DBTest.db1to1.domain.Seat;
import Study.DBTest.db1to1.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CreateSeatInit {

    private final SeatRepository seatRepository;

    @PostConstruct
    public void init() {
        Seat seat1 = new Seat(); seat1.setRow("A"); seat1.setCol(1); seatRepository.save(seat1);
        Seat seat2 = new Seat(); seat2.setRow("A"); seat2.setCol(2); seatRepository.save(seat2);
        Seat seat3 = new Seat(); seat3.setRow("A"); seat3.setCol(3); seatRepository.save(seat3);

        Seat seat4 = new Seat(); seat4.setRow("B"); seat4.setCol(1); seatRepository.save(seat4);
        Seat seat5 = new Seat(); seat5.setRow("B"); seat5.setCol(2); seatRepository.save(seat5);
        Seat seat6 = new Seat(); seat6.setRow("B"); seat6.setCol(3); seatRepository.save(seat6);

        Seat seat7 = new Seat(); seat7.setRow("C"); seat7.setCol(1); seatRepository.save(seat7);
        Seat seat8 = new Seat(); seat8.setRow("C"); seat8.setCol(2); seatRepository.save(seat8);
        Seat seat9 = new Seat(); seat9.setRow("C"); seat9.setCol(3); seatRepository.save(seat9);

    }
}
