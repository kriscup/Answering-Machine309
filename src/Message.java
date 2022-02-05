/**
 * Takes the message from the message queue and converts to a String
 * @authors Benny Bergle, Andrey Kryschuk, Brayan Escobar
 * @version 12.10.2021
 */
public class Message {

    public String message = "";

    /**
     * Sets given message to Message class in order for toString() to function properly
     * @param message sets given message
     */
    public Message(String message){

        this.message = message;

    }

    /**
     * toString method for the given message
     * @return the converted message
     */
    @Override
    public String toString(){

        return(this.message);

    }



}
