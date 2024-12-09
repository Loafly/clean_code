package kr.com.sparta.refactor.step3;

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

        // 예약 처리
        for (String selectedSeat : selectedSeats) {
            bookSeat(seats, selectedSeat);
        }

        // 총 예약된 좌석 수 출력
        System.out.println("Total booked seats: " + countBookedSeats(seats));
    }

    // 좌석 예약 처리
    public static void bookSeat(List<Seat> seats, String seatNumber) {
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
    public static int countBookedSeats(List<Seat> seats) {
        int count = 0;

        for (Seat seat : seats) {
            if ("BOOKED".equals(seat.getStatus())) {
                count++;
            }
        }

        return count;
    }
}
