package kr.com.sparta.refactor.step4;

public class Seat {
    private final String seatNumber;
    private String status;

    public Seat(String seatNumber, String status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }

    // 상태 변경 로직을 캡슐화
    public void book() {
        if ("BOOKED".equals(status)) {
            throw new IllegalStateException("Seat " + seatNumber + " is already booked.");
        }
        this.status = "BOOKED";
    }
}
