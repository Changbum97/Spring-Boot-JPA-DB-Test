package Study.DBTest.db1to1;

import Study.DBTest.db1to1.domain.Customer;
import Study.DBTest.db1to1.domain.Seat;
import Study.DBTest.db1to1.domain.SeatDto;
import Study.DBTest.db1to1.repository.CustomerRepository;
import Study.DBTest.db1to1.repository.SeatRepository;
import Study.DBTest.db1toN.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final SeatRepository seatRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/add")
    public String add(@RequestParam String name, Long seatId){
        Seat seat = seatRepository.findById(seatId);
        if(seat.getCustomer() == null) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setSeat(seat);
            customerRepository.save(customer);
            return "complete";
        } else {
            return "fail";
        }
    }

    @GetMapping("/show-seat")
    public SeatDto showSeat(@RequestParam Long seatId) {
        Seat seat = seatRepository.findById(seatId);
        return new SeatDto(seat);
    }

   /* @GetMapping("/show-seat")
    public Seat showSeat(@RequestParam Long seatId) {
        Seat seat = seatRepository.findById(seatId);
        return seat;
    }*/
}
