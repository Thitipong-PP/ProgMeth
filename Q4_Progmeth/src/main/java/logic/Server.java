package logic;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class Server {
    private  String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server (String name, User owner, TemplateType template) {
        this.owner = owner;
        this.memberList = new ArrayList<User>(0);
        this.channelList = new ArrayList<Channel>(0);

        addUser(owner);
        setName(name);

        if (template == TemplateType.BASIC) addChannel(owner, "general");
        else if (template == TemplateType.GAMING) addChannel(owner, "gaming");
        else addChannel(owner, "homework-help");
    }

    public boolean isMemberInServer (User userToCheck) {
        // Check from name
        for (int i=0; i<this.memberList.size(); i++) if (this.memberList.get(i).getName() == userToCheck.getName()) return true;
//        for (int i=0; i<this.memberList.size(); i++) if (this.memberList.get(i) == userToCheck) return true;
        return false;
    }

    public Channel addChannel (User user, String channelName) {
        if (user != getOwner()) return null;

        this.channelList.add(new Channel(channelName));
        return this.channelList.getLast();
    }

    public User addUser (User user) {
        if (isMemberInServer(user)) return null;

        user.addJoinedServersList(this);
        this.memberList.add(user);

        return this.memberList.getLast();
    }

    public boolean kickUser (User kicker, User kicked) throws Exception {
        if (kicker != getOwner()) throw new Exception("The kicker is not this owner server!");
        else if (kicked == getOwner() || !isMemberInServer(kicked)) return false;

        kicked.getJoinedServersList().remove(this);
        this.memberList.remove(kicked);

        return true;
    }

    public void setName (String name) {
        if (name.isBlank()) name = owner.getName() + " home";
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public User getOwner () {
        return this.owner;
    }

    public ArrayList<Channel> getChannelList () {
        return this.channelList;
    }

    public ArrayList<User> getMemberList () {
        return this.memberList;
    }
}
