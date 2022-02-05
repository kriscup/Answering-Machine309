import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Connects user to a Voicemail system.
 * Purpose is to give user initial prompt, and keep user connected through Connection class
 * @authors Benny Bergle, Andrey Kryschuk, Brayan Escobar
 * @version 12.10.2021
 */
public class Telephone
{

    static Connection connection;
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args)
    {
        connect();
        connection.connect(); //sets connect boolean to true
        start();
    }

    /**
     * First menu given to the user
     * Calls Connection class from this method
     */
    public static void start() {

        while (connection.connected) {

                int option = 0;
                System.out.println("----------------------------\n" +
                        "Select 1 to leave a message\n" +
                        "Select 2 to log in\n" +
                        "Select 3 to hang up");
                option = input.nextInt();
                if (option == 1) {
                    //leave a message
                    connection.leaveAMessage(); //calls LeaveAMessage method from Connection class
                } else if (option == 2) {
                    //log in method
                    connection.logIn(); //calls logIn method from Connection class
                } else if (option == 3) {
                    //Call hangup method
                    System.out.println("[Disconnecting from service]");
                    connection.hangUp(); //sets connected to false, ends connection
                }
            }
        }

    /**
     * Creates a new connection instance for the user
     */
    public static void connect(){

        System.out.println("[Connecting to service]\n"+
                "----------------------------");
        connection = new Connection();
    }



}
