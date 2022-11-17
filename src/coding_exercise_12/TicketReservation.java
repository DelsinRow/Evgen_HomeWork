package coding_exercise_12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>(CONFIRMEDLIST_LIMIT);
    private Deque<Passenger> waitingList = new ArrayDeque<>(WAITINGLIST_LIMIT);

    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    /**
     * Returns true if passenger could be added into either confirmedList or waitingList. Passenger will be added to waitingList only if confirmedList is full.
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        for(Passenger confirmedPassenger : confirmedList) {
            if(confirmedPassenger.equals(null)){
                confirmedList.add(passenger);
        } else {
                for (Passenger waitingPassenger : waitingList) {
                    if(waitingPassenger.equals(null)){
                        waitingList.add(passenger);
                    } else {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public boolean cancel(String confirmationNumber) {
        return removePassenger(waitingList.iterator(), confirmationNumber);
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        for (int i = 0; i < confirmedList.size(); i++) {
            if (confirmedList.get(i).getConfirmationNumber() == confirmationNumber) {
                confirmedList.remove(i);
                confirmedList.add(waitingList.pollFirst());
                return true;
            }
        }

        iterator = waitingList.iterator();
        if(iterator.next().getConfirmationNumber() == confirmationNumber){
            try {
                iterator.remove();
            } catch (UnsupportedOperationException | IllegalStateException ignored){
            }
            return true;
        }
        return false;
    }
}
