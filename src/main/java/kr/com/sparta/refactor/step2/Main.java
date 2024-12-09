package kr.com.sparta.refactor.step2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", "AVAILABLE"));
        seats.add(new Seat("A2", "AVAILABLE"));
        seats.add(new Seat("A3", "AVAILABLE"));

        List<String> selectedSeats = List.of("A2", "A3", "A1", "A4");

        for (String selectedSeat : selectedSeats) {
            bookSeat(seats, selectedSeat);
        }

        System.out.println("Total booked seats: " + countBookedSeats(seats));
    }

    public static void bookSeat(List<Seat> seats, String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                if ("BOOKED".equals(seat.getStatus())) {
                    System.out.println("Seat " + seatNumber + " is already booked.");
                } else {
                    seat.setStatus("BOOKED");
                    System.out.println("Seat " + seatNumber + " has been successfully booked.");
                }
                return;
            }
        }

        System.out.println("Seat " + seatNumber + " does not exist.");
    }

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
