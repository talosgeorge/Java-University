package isp.lab5.exercise4;

import java.io.IOException;

public class UserApp {
    private TicketSystem ticketSystem;

    public UserApp(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
    }
    public void buyTicket(String eventName){
        ticketSystem.buyTicket(eventName);
    }
    public void validateTicket(String ticketCode) throws IOException {
        if(ticketSystem.validateTicket(ticketCode)){
            System.out.println("Ticket is valid.");
            Process exec = Runtime.getRuntime().exec("cmd /c start \"C:\\Users\\talos\\OneDrive\\Desktop\\Scoala\\An II\\ISP\\isp-seria-a-2024-talosgeorge-1\\isp-lab-5-2023-main\\docs\\Image.png\"");
        } else {
            System.out.println("Ticket is invalid.");
        }
    }
}
