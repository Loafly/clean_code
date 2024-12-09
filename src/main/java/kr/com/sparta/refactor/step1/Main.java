package kr.com.sparta.refactor.step1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> seats = new ArrayList<>();
        seats.add("A1:AVAILABLE");
        seats.add("A2:AVAILABLE");
        seats.add("A3:AVAILABLE");

        List<String> selectedSeats = List.of("A2", "A3", "A1", "A4");

        for (String selectedSeat : selectedSeats) {
            bookSeat(seats, selectedSeat);
        }

        System.out.println("Total booked seats: " + countBookedSeats(seats));
    }

    public static void bookSeat(List<String> seats, String seatNumber) {

        for (int i = 0; i < seats.size(); i++) {
            String seat = seats.get(i);

            if (seat.startsWith(seatNumber)) {
                if (seat.endsWith("BOOKED")) {
                    System.out.println("Seat " + seatNumber + " is already booked.");
                }else {
                    seats.set(i, seatNumber + ":BOOKED");
                    System.out.println("Seat " + seatNumber + " has been successfully booked.");
                }
                return;
            }
        }

        System.out.println("Seat " + seatNumber + " does not exist.");

    }

    public static int countBookedSeats(List<String> seats) {
        int count = 0;

        for (String seat : seats) {
            if (seat.endsWith("BOOKED")) {
                count++;
            }
        }

        return count;
    }
}
