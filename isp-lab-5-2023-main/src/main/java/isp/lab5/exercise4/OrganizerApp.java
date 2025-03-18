package isp.lab5.exercise4;
import isp.lab5.exercise4.TicketSystem;
public class OrganizerApp {
    private TicketSystem ticketSystem;

    public OrganizerApp(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }

    public void createEvent(String name, EventType type, int numTicketsAvailable) {
        ticketSystem.events.add(new Event(name, type, numTicketsAvailable));
    }
}
