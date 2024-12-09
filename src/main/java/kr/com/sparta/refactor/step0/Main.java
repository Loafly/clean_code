package kr.com.sparta.refactor.step0;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 좌석 생성 (좌석Id : 좌석 상태)
        List<String> seats = new ArrayList<>();
        seats.add("A1:AVAILABLE");
        seats.add("A2:AVAILABLE");
        seats.add("A3:AVAILABLE");

        // 예약할 좌석 Id
        List<String> seats2 = List.of("A2", "A3", "A1", "A4");

        // 예약할 좌석 전체 예약 진행
        for (String seat2 : seats2) {
            boolean book = false;

            // 현재 존재 하는 모든 좌석을 순회 하여 상태에 따라 예약 진행
            for (int i = 0; i < seats.size(); i++) {
                String seat = seats.get(i);
                if (seat.startsWith(seat2)) {

                    // 이미 예약된 좌석인 경우 예약 불가 (중복 예약)
                    if (seat.endsWith("BOOKED")) {
                        System.out.println("Seat " + seat2 + " is already booked.");
                        book = true;
                        break;
                    } else { // 정상 케이스 - 좌석을 예약 상태로 변경
                        seats.set(i, seat2 + ":BOOKED");
                        System.out.println("Seat " + seat2 + " has been successfully booked.");
                        book = true;
                        break;
                    }
                }
            }

            // 좌석이 존재 하지 않는 경우 예약 불가
            if (!book) {
                System.out.println("Seat " + seat2 + " does not exist.");
            }
        }

        int count = 0;
        for (String seat : seats) {
            if (seat.endsWith("BOOKED")) {
                count++;
            }
        }
        System.out.println("Total booked seats: " + count);
    }
}
