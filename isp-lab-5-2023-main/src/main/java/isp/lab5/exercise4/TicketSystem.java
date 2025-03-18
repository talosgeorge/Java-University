package isp.lab5.exercise4;

import java.util.ArrayList;

public class TicketSystem implements TicketsManager {

    ArrayList<Event> events;

    public TicketSystem(ArrayList<Event> events) {
        if (events==null){
            this.events = new ArrayList<>();
        } else {
            this.events = events;
        }
    }

    @Override
    public void buyTicket(String eventName){
        for(Event event:events){
            if(event.getName().equals(eventName)){
                event.buyTicket();
                return;
            }
        }
        System.out.println("Event not found." + eventName);
    }
    @Override
    public boolean validateTicket(String ticketCode){
        return Math.random() > 0.5;
    }
}
