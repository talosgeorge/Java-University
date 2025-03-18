package isp.lab5.exercise4;

public interface TicketsManager {
    void buyTicket(String eventName);
    boolean validateTicket(String ticketCode);
}
