public class Ticketbooking extends  Thread{
    private TicketCounter ticketcounter;
    private String name;
    private int no_of_tickets;

    public Ticketbooking(TicketCounter ticketcounter, String name, int no_of_tickets) {
        this.ticketcounter = ticketcounter;
        this.name = name;
        this.no_of_tickets = no_of_tickets;
    }
    public void run(){
          ticketcounter.bookingticket(name,no_of_tickets);
    }
}

