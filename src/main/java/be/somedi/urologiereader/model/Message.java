package be.somedi.urologiereader.model;

import java.time.LocalDateTime;
import java.util.Random;

public class Message {
    private String messageDateTime, messageID, actionDateTime;

    public Message() {
        var date = LocalDateTime.now().toString();
        messageDateTime = date.substring(0, date.length() - 1).concat("Z");
        messageID = date.replace("T", "").replace(".", "").replaceAll(":", "").replaceAll(" ", "").concat("_") + new Random().nextInt(10000);
        actionDateTime = messageDateTime;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getActionDateTime() {
        return actionDateTime;
    }


}
