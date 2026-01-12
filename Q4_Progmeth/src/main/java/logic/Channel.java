package logic;

import java.util.ArrayList;

public class Channel {
    private String name;
    private ArrayList<Message> messageList;

    public Channel (String name) {
        setName(name);
        this.messageList = new ArrayList<Message>(0);
    }

    public void addMessage (Message message) {
        this.messageList.add(message);
    }

    public void setName (String name) {
        this.name = (name.isBlank()) ? "off-topic" : name;
    }

    public int getMessageCount () {
        return this.messageList.size();
    }

    public String getName () {
        return this.name;
    }

    public ArrayList<Message> getMessageList() {
        return this.messageList;
    }
}
