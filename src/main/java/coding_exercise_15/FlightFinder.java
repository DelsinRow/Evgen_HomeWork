package coding_exercise_15;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class FlightFinder {
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm, dd MMM, yyyy");

    private Map<String, List<Flight>> allFlights = new HashMap<>();

    public FlightFinder(Map<String, List<Flight>> allFlights) {
        this.allFlights = allFlights;
    }

    public List<NavigableSet<Flight>> findFlights(int dayOfMonth, int month, int year,
                                                  int preferredDepartureStartHour, int preferredDepartureEndHour,
                                                  String departureCity, String arrivalCity, String finalArrivalCity,
                                                  String departureCityTimeZone, String arrivalCityTimeZone) {

        List<NavigableSet<Flight>> result = new ArrayList<>();

        // Step 1: Construct ZonedDateTime objects to represent User-specified time interval when flights depart
        LocalDateTime clientStartLocalDateTime = LocalDateTime.of(year, month, dayOfMonth, preferredDepartureStartHour, 0,0);
        LocalDateTime clientEndLocalDateTime = LocalDateTime.of(year, month, dayOfMonth, preferredDepartureEndHour, 0,0);

        ZonedDateTime departureZonedDateTime = clientStartLocalDateTime.atZone(ZoneId.of(departureCityTimeZone));
        ZonedDateTime arrivalZonedDateTime = departureZonedDateTime.withZoneSameInstant(ZoneId.of(arrivalCityTimeZone));

//        System.out.println(dateFormat.format(departureZonedDateTime));
//        System.out.println(dateFormat.format(arrivalZonedDateTime));

        // Step 2: Find departing flights at departureCity
        List<Flight> allDepartingFlights = allFlights.get(arrivalCity);

        NavigableSet<Flight> departingflights = new TreeSet<>();

        for (Flight flight : allDepartingFlights) {
            if (flight.getDepartureCity().equals(departureCity) & flight.getDepartureTime().isAfter(clientStartLocalDateTime) & flight.getDepartureTime().isBefore(clientEndLocalDateTime)){
                departingflights.add(flight);
            }
        }

        // Step 3: Find connecting flights
        List<Flight> allConnectingFlights = allFlights.get(arrivalCity);
        List<Flight> allFlighsList = allFlights.get(departureCity);

        NavigableSet<Flight> connectingflights = new TreeSet<>();

        for (Flight secondFlight : allConnectingFlights) {
            for(Flight firstFlight : allFlighsList) {
                if (!secondFlight.getDepartureCity().equals(departureCity) &
                        firstFlight.getArrivalTime().plusHours(2).isBefore(secondFlight.getDepartureTime())) {
                    connectingflights.add(secondFlight);
                }
            }
        }

        result.add(departingflights);
        result.add(connectingflights);

        return result;
    }

    public static void main(String[] args) {
        Flight f1 = new Flight(1, "1", "Emirates", "New York", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f2 = new Flight(2, "2", "Delta", "San Francisco", "Paris",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f3 = new Flight(3, "3", "Delta", "San Francisco", "Rome",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f4 = new Flight(4, "4", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 8, 0));
        Flight f5 = new Flight(5, "5", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 9, 30), LocalDateTime.of(2017, 12, 20, 9, 30));
        Flight f6 = new Flight(6, "6", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 11, 30), LocalDateTime.of(2017, 12, 20, 11, 30));
        Flight f7 = new Flight(7, "7", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 12, 30), LocalDateTime.of(2017, 12, 20, 12, 30));
        Flight f8 = new Flight(8, "8", "Emirates", "San Francisco", "Dubai",
                LocalDateTime.of(2017, 12, 20, 16, 0), LocalDateTime.of(2017, 12, 20, 16, 30));
        Flight f9 = new Flight(9, "9", "Emirates", "Paris", "New Delhi",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f10 = new Flight(10, "10", "Emirates", "Dubai", "Singapore",
                LocalDateTime.of(2017, 12, 20, 9, 0), LocalDateTime.of(2017, 12, 20, 9, 0));
        Flight f11 = new Flight(11, "11", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 9, 30), LocalDateTime.of(2017, 12, 20, 9, 30));
        Flight f12 = new Flight(12, "12", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 10, 30), LocalDateTime.of(2017, 12, 20, 10, 30));
        Flight f13 = new Flight(13, "13", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 12, 0), LocalDateTime.of(2017, 12, 20, 12, 0));
        Flight f14 = new Flight(14, "14", "Emirates", "Dubai", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 14, 0), LocalDateTime.of(2017, 12, 20, 14, 0));
        Flight f15 = new Flight(15, "15", "Emirates", "Rome", "Mumbai",
                LocalDateTime.of(2017, 12, 20, 14, 0), LocalDateTime.of(2017, 12, 20, 14, 0));

        System.out.println(f4.getArrivalTime());

        Map<String, List<Flight>> allFlights = new HashMap<>();

        allFlights.put("New York", Arrays.asList(f1));
        allFlights.put("San Francisco", Arrays.asList(f2, f3, f4, f5, f6, f7, f8));
        allFlights.put("Paris", Arrays.asList(f9));
        allFlights.put("Dubai", Arrays.asList(f10, f11, f12, f13, f14));
        allFlights.put("Rome", Arrays.asList(f15));

        List<NavigableSet<Flight>> result = new FlightFinder(allFlights).findFlights(20, 12, 2017, 9, 13, "San Francisco", "Dubai", "Mumbai", "America/Los_Angeles", "Asia/Dubai");

        System.out.println("result: " +result);
    }

}
