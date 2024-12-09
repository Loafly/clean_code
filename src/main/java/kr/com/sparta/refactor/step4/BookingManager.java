package kr.com.sparta.refactor.step4;

import java.util.List;

public class BookingManager {
    // 좌석 예약 처리
    public void bookSeat(List<Seat> seats, String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                try {
                    seat.book();
                    System.out.println("Seat " + seatNumber + " has been successfully booked.");
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }

        System.out.println("Seat " + seatNumber + " does not exist.");
    }

    // 예약된 좌석 개수 계산
    public int countBookedSeats(List<Seat> seats) {
        int count = 0;

        for (Seat seat : seats) {
            if ("BOOKED".equals(seat.getStatus())) {
                count++;
            }
        }

        return count;
    }
}
