package be.somedi.urologiereader.model;

import java.time.LocalDateTime;
import java.util.Random;

public class Message {
    private String messageDateTime, messageID, actionDateTime;

    public Message() {
        String date = LocalDateTime.now().toString();
        messageDateTime = date.substring(0, date.length() - 1).concat("Z");
        messageID = date.replace("T", "").replace(".", "").replaceAll(":", "").replaceAll(" ", "").concat("_") + new Random().nextInt(10000);
        actionDateTime = messageDateTime;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getActionDateTime() {
        return actionDateTime;
    }

    public void setActionDateTime(String actionDateTime) {
        this.actionDateTime = actionDateTime;
    }

    @Override
    public String toString() {
        return "Message [messageDateTime=" + messageDateTime + ", messageID=" + messageID + ", actionDateTime="
                + actionDateTime + "]";
    }

}
