package coding_exercise_12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public static void main(String[] args) {
        TicketReservation ticketReservation = new TicketReservation();

        System.out.println(ticketReservation.bookFlight("Mike","A",18,"male", "business", "A1"));
        System.out.println(ticketReservation.bookFlight("Nick","A",28,"male", "economy", "A2"));
        System.out.println(ticketReservation.bookFlight("Ann","A",19,"female", "economy", "A3"));
        System.out.println(ticketReservation.bookFlight("Luke","A",18,"male", "economy", "A4"));
        System.out.println(ticketReservation.bookFlight("Marina","A",69,"female", "business", "A5"));
        System.out.println(ticketReservation.bookFlight("kate","A",45,"female", "economy", "A6"));
        System.out.println(ticketReservation.bookFlight("Jack","A",66,"male", "economy", "A7"));
        System.out.println(ticketReservation.bookFlight("Bob","A",80,"male", "economy", "A8"));
        System.out.println(ticketReservation.bookFlight("Alice","A",33,"female", "economy", "A9"));
        System.out.println(ticketReservation.bookFlight("Masha","A",36,"female", "economy", "A10"));

        System.out.println(ticketReservation.bookFlight("Alex","A",27,"male", "economy", "A11"));
        System.out.println(ticketReservation.bookFlight("Mark","A",30,"male", "economy", "A12"));
        System.out.println(ticketReservation.bookFlight("Pooh","A",19,"female", "economy", "A13"));
        System.out.println(ticketReservation.bookFlight("Ron","A",44,"male", "economy", "A14"));

        System.out.println(ticketReservation.getConfirmedList().toString());
        System.out.println(ticketReservation.getWaitingList().toString());

        System.out.println(ticketReservation.cancel("A9"));

        System.out.println(ticketReservation.getConfirmedList().toString());
        System.out.println(ticketReservation.getWaitingList().toString());


        System.out.println(ticketReservation.cancel("A12"));

        System.out.println(ticketReservation.getConfirmedList().toString());
        System.out.println(ticketReservation.getWaitingList().toString());

        System.out.println(ticketReservation.cancel("A12"));

    }
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }
    public Deque<Passenger> getWaitingList() {
        return waitingList;
    }
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
            if(confirmedList.size() < CONFIRMEDLIST_LIMIT){
                confirmedList.add(passenger);
            } else {
                if(waitingList.size() < WAITINGLIST_LIMIT){
                        waitingList.add(passenger);
                    } else {
                        return false;
                    }
                }
        return true;
    }

    public boolean cancel(String confirmationNumber) {
        return removePassenger(waitingList.iterator(), confirmationNumber);
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        for (int i = 0; i < confirmedList.size(); i++) {
            if (confirmedList.get(i).getConfirmationNumber().equals(confirmationNumber)) {
                confirmedList.remove(i);
                confirmedList.add(waitingList.pollFirst());
                return true;
            }
        }

        iterator = waitingList.iterator();
        if(iterator.next().getConfirmationNumber().equals(confirmationNumber)) {
            try {
                iterator.remove();
            } catch (UnsupportedOperationException | IllegalStateException ignore){
            }
            return true;
        }
        else return false;
    }
}
