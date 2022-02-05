import java.util.Scanner;

/**
 * Takes input from Telephone
 * Sends and gets info from MailSystem
 * @authors Benny Bergle, Andrey Kryschuk, Brayan Escobar
 * @version 12.11.2021
 *
 */
public class Connection {

   MailSystem system = new MailSystem();
    boolean connected = false;
    int exNumber; //extension number
    int passcode; //passcode for a given extension number

    /**
     * Asks user for extension number.
     * calls reachAnExtension which returns the location of exNumber (if found)
     * (if not found) keeps user in loop until they input an existing exNumber
     */
    public Connection() {
        System.out.println("Please enter the extension number you would like to reach");
        exNumber = Telephone.input.nextInt();
        while (reachAnExtension(exNumber) == null) {
            //while reachAnExtension isn't able to find a match

            exNumber = Telephone.input.nextInt(); //takes user input and sets it as the exNumber for future reference
        }
    }

    /**
     * keeps user connected to telephone
     */
    public void connect(){
        connected = true;
    }

    /**
     * disconnects user from telephone
     */
    public void hangUp() {
        connected = false;
    }

    /**
     * called when Connection() is called
     * @return location of given exNumber in the array
     */
    public MailBox reachAnExtension(int exNumber) {

        //if the input given matches with a possible extension number in the arrayList, return the mailbox location
        if (system.reachAnExtension(exNumber) != system.nullBox) {

            System.out.println("You have reached mailbox " + exNumber);
            return system.reachAnExtension(exNumber);
        }

        // if no match found, return null which prompts code to run again through Connection()
       else{
           System.out.println("----------------------------\n" +
                   "The mailbox you have entered does not exist!\n" +
                   "Please enter a valid extension:");
           return null; //prompts Connection() to keep user in loop
        }

    }

    /**
     * Method is originally called from start() method in Telephone,
     * user stays in this method due to while(loggedIn)
     *
     */
    public void logIn(){

        System.out.println("Please enter passcode");
        passcode = Telephone.input.nextInt();

        //if the passcode matches for the given passcode in the mailbox @ exNumber, give log in menu
        if(passcode == system.reachAnExtension(exNumber).passcode){

            Boolean loggedIn = true; //keeps user in the log in menu until prompted otherwise
            System.out.println("You are now logged into mailbox " + exNumber);
            while(loggedIn) {

                //log in dial menu
                System.out.println("----------------------------\n" +
                        "Select 1 to retrieve your messages\n" +
                        "Select 2 to change your passcode\n" +
                        "Select 3 to change your greeting\n" +
                        "Select 4 to return to the main menu");
                int option = Telephone.input.nextInt();

                if(option == 1){ //retrieve message
                    //calls get method at the specified mailbox # (exNumber)

                    System.out.println("You selected retrieve message!");
                    system.reachAnExtension(exNumber).retrieveMessage(); //call MailSystem array for the specific mailbox
                }
                else if (option == 2){ //change passcode
                    //Gets user input, saves input to the Mailbox array "boxes" at the specified mailbox (exNumber)

                    System.out.println("You selected to change passcode, please enter a new integer only passcode");
                    system.reachAnExtension(exNumber).managePasscode(Telephone.input.nextInt());
                    System.out.println("Your new passcode is: " + system.reachAnExtension(exNumber).passcode); //calls for the new passcode from the array

                }
                else if (option ==3){
                    //Gets user input for new greeting, saves to MailboxSystem at the specified mailbox (exNumber)

                    Scanner greeting = new Scanner(System.in);
                    System.out.println("You selected to change your greeting!\n" +
                            "please enter a new one below");
                    system.reachAnExtension(exNumber).manageGreeting(greeting.nextLine()); //gets user input
                    System.out.println("Your new greeting is: " + system.reachAnExtension(exNumber).greeting); //calls for the new greeting from the array

                }
                else if(option == 4){
                    //changes the boolean loggedIn to break from the method
                    //brings user back to the start method in telephone

                    System.out.println("Returning to the main menu");
                    loggedIn = false; //exits while loop

                }
            }
        }
        //if password doesn't match, prompt user again
        else{
            System.out.println("Incorrect passcode, please try again");

        }
    }

    /**
     * Leaves a message in the mailbox exNumber
     * References addMessage() method in the Message class in order to add to the FILO stack
     */
    public void leaveAMessage(){
        Scanner test1 = new Scanner(System.in);
        System.out.println("Connecting to mailbox " + exNumber + "...");
        System.out.println('"'+ system.reachAnExtension(exNumber).greeting + '"'); //gets the greeting from proper location in Mailbox array
        String prompt = test1.nextLine(); //prompts user to leave a message

        Message tmp = new Message(prompt); //message saved as temp
        system.reachAnExtension(exNumber).addMessage(tmp); //temp added to the Message class


    }

}