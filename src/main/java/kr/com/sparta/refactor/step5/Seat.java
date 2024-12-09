package kr.com.sparta.refactor.step5;

public class Seat {
    private final String seatNumber;
    private SeatStatus status;

    public Seat(String seatNumber, SeatStatus status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    // 상태 변경 로직을 캡슐화
    public void book() {
        if (status == SeatStatus.BOOKED) {
            throw new IllegalStateException("Seat " + seatNumber + " is already booked.");
        }
        this.status = SeatStatus.BOOKED;
    }
}
