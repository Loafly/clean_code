package kr.com.sparta.refactor.step4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 좌석 초기화
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", "AVAILABLE"));
        seats.add(new Seat("A2", "AVAILABLE"));
        seats.add(new Seat("A3", "AVAILABLE"));

        // 사용자가 선택한 좌석
        List<String> selectedSeats = List.of("A2", "A3", "A1", "A4");

        // BookingManager 생성
        BookingManager bookingManager = new BookingManager();

        // 예약 처리
        for (String selectedSeat : selectedSeats) {
            bookingManager.bookSeat(seats, selectedSeat);
        }

        // 총 예약된 좌석 수 출력
        System.out.println("Total booked seats: " + bookingManager.countBookedSeats(seats));
    }
}
