public class TicketCounter {
    private int available_ticket=1;
    public  synchronized void bookingticket(String name,int no_of_tickets_want){
        if(no_of_tickets_want>0 && no_of_tickets_want<=available_ticket){
            System.out.println("oops !"+ name +" you got your ticket....enjoy the journey");
              available_ticket=available_ticket-no_of_tickets_want;}
        else{
            System.out.println("ticket not available.....better luck next time..."+name);

    }}}
