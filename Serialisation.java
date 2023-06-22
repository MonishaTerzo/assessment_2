import java.io.*;


    public class Serialization {
        public static void main(String[] args) {

            MyHome myHome = new MyHome("green chair", "beautiful fridge", " 5 history books",
                    "King-size bed", "one fastrack watch", "Smart lg TV", "Blue");

            try {
                FileOutputStream fileOut = new FileOutputStream("my_home.ser");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(myHome);
                objectOut.close();
                fileOut.close();
                System.out.println("My home serialized and saved to 'my_home.ser'");
            } catch (IOException e) {
                e.printStackTrace();
            }


            MyHome deserializedHome = null;

            try {
                FileInputStream fileIn = new FileInputStream("my_home.ser");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                deserializedHome = (MyHome) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


            if (deserializedHome != null) {
                System.out.println("Deserialized My Home:");
                deserializedHome.display();
            }
        }
    }


