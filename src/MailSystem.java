import java.util.ArrayList;

/**
 * Array that holds all the different mailboxes (obj.)
 * Has the id to access the Mailbox class
 * @authors Benny Bergle, Andrey Kryschuk, Brayan Escobar
 * @version 12.11.2021
 */
public class MailSystem {
	
    public MailBox nullBox = new MailBox(0, 0, null);
    public MailBox[] boxes = new MailBox[6];

    public MailSystem() {

        boxes[0] = new MailBox(1,123,"Welcome to mailbox 1, please leave a message");
        boxes[1] = new MailBox(2,123,"Welcome to mailbox 2, please leave a message");
        boxes[2] = new MailBox(3,123,"Welcome to mailbox 3, please leave a message");
        boxes[3] = new MailBox(10,123,"Welcome to mailbox 10, please leave a message");
        boxes[4] = new MailBox(52,123,"Welcome to mailbox 52, please leave a message");
        boxes[5] = new MailBox(7,123,"Welcome to mailbox 7, please leave a message");

    }

    /**
     * Checks whether extension number given exists within MailSystem[] boxes
     * @param exNumber user specified extension number to check against array
     * @return if found, returns given location of mailbox, else returns nullBox
     */
    public MailBox reachAnExtension(int exNumber) {

        for (int i = 0; i < boxes.length; i++) {

            if (boxes[i].exNumber == exNumber) {
                return boxes[i];
            }

        }
        return nullBox;
    }

}
