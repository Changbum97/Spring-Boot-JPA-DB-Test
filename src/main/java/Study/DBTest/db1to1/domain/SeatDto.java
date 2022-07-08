package Study.DBTest.db1to1.domain;

import lombok.Data;

@Data
public class SeatDto {

    private Long id;
    private String row;
    private int col;
    private String customerName;

    public SeatDto(Seat seat) {
        this.id = seat.getId();
        this.row = seat.getRow();
        this.col = seat.getCol();
      /*  if(seat.getCustomer() != null) {
            this.customerName = seat.getCustomer().getName();
        } else {
            this.customerName = null;
        }*/
    }
}
