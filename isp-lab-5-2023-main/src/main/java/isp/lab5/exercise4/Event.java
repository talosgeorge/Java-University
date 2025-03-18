package isp.lab5.exercise4;

public class Event {
    private String name;
    private EventType type;
    private int numTicketsAvailable;

    public Event(String name, EventType type, int numTicketsAvailable) {
        this.name = name;
        this.type = type;
        this.numTicketsAvailable = numTicketsAvailable;
    }

    public String getName() {
        return name;
    }

    public EventType getType() {
        return type;
    }

    public int getNumTicketsAvailable() {
        return numTicketsAvailable;
    }

    public void buyTicket() {
        if (numTicketsAvailable > 0) {
            numTicketsAvailable--;
            System.out.println("Ticket purchased succesfully for " + name);
        } else {
            System.out.println("Ticket is not available anymore for " + name);
        }
    }
}
