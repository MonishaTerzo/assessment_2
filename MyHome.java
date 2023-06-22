import java.io.*;

class MyHome implements Serializable {
    private static final long serialVersionUID = 1L;
    private String chair;
    private String fridge;
    private String books;
    private String bed;
    private String watch;
    private String tv;
    private String wallColor;

    public MyHome(String chair, String fridge, String books, String bed, String watch, String tv, String wallColor) {
        this.chair = chair;
        this.fridge = fridge;
        this.books = books;
        this.bed = bed;
        this.watch = watch;
        this.tv = tv;
        this.wallColor = wallColor;
    }

    public void display() {
        System.out.println("Chair: " + chair);
        System.out.println("Fridge: " + fridge);
        System.out.println("Books: " + books);
        System.out.println("Bed: " + bed);
        System.out.println("Watch: " + watch);
        System.out.println("TV: " + tv);
        System.out.println("Wall Color: " + wallColor);
    }
}

