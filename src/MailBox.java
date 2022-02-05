import java.util.LinkedList;

/**
 * Holds mailbox information for each mailbox
 *
 * @authors Benny Bergle, Andrey Kryschuk, Brayan Escobar
 * @version 12.11.2021
 * Notes:
 * Finished retrieveMessage() method with listen, delete, and save use cases
 */
public class MailBox {

    public int passcode, exNumber;
    public String greeting;
    public LinkedList<String> newMessages = new LinkedList<String>(); //queue of new messages
    public LinkedList<String> oldMessages = new LinkedList<String>(); //queue of saved messages


    /**
     * Information from each mailbox
     * @param exNumber extension number
     * @param passcode passcode in order to access given mailbox
     * @param greeting greeting given when user wants to leave a message at given extension number
     */
    public MailBox(int exNumber, int passcode, String greeting){

        this.exNumber = exNumber;
        this.passcode = passcode;
        this.greeting = greeting;

    }

    /**
     * setter for new passcode
     * @param newPasscode user defined new passcode
     */
    public void managePasscode(int newPasscode){

        this.passcode = newPasscode;


    }

    /**
     * sets greeting to user defined greeting
     * @param newGreeting user defined new greeting
     */
    public void manageGreeting(String newGreeting){

        this.greeting = newGreeting;

    }

    /**
     * called from logIn() method in Connection class
     * stays in loop in order to return to this menu from other options
     * gets messages from newMessages/ oldMessages stack
     */
    public void retrieveMessage(){

        Boolean retrieving = true;

        //while set to true
        while(retrieving){
            System.out.println("----------------------------\n" +
                    "Select 1 to listen to new message\n" +
                    "Select 2 to delete new message\n" +
                    "Select 3 to save new message\n" +
                    "Select 4 to return to the main menu");
            int option = 0; //in order to keep user in loop until prompted otherwise
            option = Telephone.input.nextInt();

            if(option == 1){
                //listen to new message
                System.out.println("Listening to new message...\n" +
                                    "-- --------------------------");

                // if no new messages in newMessage stack, takes from top in oldMessage stack
                if(newMessages.isEmpty()){

                    //if both stacks are empty
                    if(oldMessages.isEmpty()){
                        System.out.println("No messages!");
                    }

                    //if only newMessages is empty
                    else{
                        System.out.println("No new messages! Playing most recent saved message...");
                        System.out.println('"'+ oldMessages.peek() +'"'); // looks at oldMessage stack
                    }

                }
                // gets top message in newMessage stack
                else {
                    System.out.println('"'+ newMessages.peek() +'"'); //looks at top message in stack
                }
            }

            else if(option == 2){
                //deletes top message in stack
                System.out.println("Deleting recent message...");

                //if newMessage is empty, remove message from oldMessages stack
                if(newMessages.isEmpty()) {

                    //if both stacks are empty, return an error
                    if (oldMessages.isEmpty()) {
                        System.out.println("No messages to delete!");
                    }

                    else if(!oldMessages.isEmpty()) {
                        System.out.println('"' + oldMessages.pop() + '"');
                    }
                }

                //remove from newMessages stack
                else{
                    System.out.println('"'+ newMessages.pop() +'"'); //not a pop method, no return needed
                }
            }

            else if(option == 3){
                //save the most recent message
                System.out.println("Saving recent message...");
                //if no messages in newMessage stack, do nothing
                if(newMessages.isEmpty()){
                    System.out.println("No new messages to save!");
                }
                //if there are messages in newMessage stack, save to oldMessage
                else {
                    System.out.println('"'+ newMessages.peek() +'"');
                    oldMessages.push(newMessages.pop()); //pops top message from newMessages stack and pushes it onto the oldMessage stack
                }
            }

            else if(option == 4){
                //return to the main menu
                System.out.println("Returning to log in menu...");
                retrieving = false; //exits while loop, sending back to logIn() method loop
            }
        }
    }

    /**
     * adds message to the message queue
     * @param message user given new message to add to queue
     */
    public void addMessage(Message message){

       System.out.println("Message saved to mailbox " + exNumber+ "!");
       newMessages.push(message.toString());


    }
}
