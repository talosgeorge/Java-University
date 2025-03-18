package isp.lab5.exercise4;

import java.io.IOException;
import java.util.ArrayList;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event("Rock",EventType.CONCERT, 0));
        events.add(new Event("Fotball",EventType.SPORTING_EVENT,300));
        events.add(new Event("Untold",EventType.MUSIC_FESTIVAL,50000));

        TicketSystem ticketSystem = new TicketSystem(events);

        UserApp userApp = new UserApp(ticketSystem);
        OrganizerApp organizerApp = new OrganizerApp(ticketSystem);
        organizerApp.createEvent("Home Alone 2",EventType.MOVIE,506);

        userApp.buyTicket("Rock");
        userApp.buyTicket("Fotball");
        userApp.buyTicket("Untolddd");

        String validTicketCode = "Valid_Ticket_123";
        String invalidTicketCode = "Invalid_Ticket_456";
        userApp.validateTicket(validTicketCode);
        userApp.validateTicket(invalidTicketCode);
    }
}
