
public class clientside {
    public static void main(String[] args) {
        TicketCounter t=new TicketCounter();
        Ticketbooking person1=new Ticketbooking(t,"Monisha",1);
        Ticketbooking person2=new Ticketbooking(t,"Aparna",1);
        person1.start();
        person2.start();



    }
}
