package logic;

import java.util.ArrayList;

public class Region {
    private String name;
    private ArrayList<Player> playerList;
    private ArrayList<Quest> questList;

    public Region (String name) {
        setName(name);
        this.playerList = new ArrayList<Player>(0);
        this.questList = new ArrayList<Quest>(0);
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        if (name.isBlank()) {
            name = "Nowhere";
        }

        this.name = name;
    }

    public ArrayList<Player> getPlayerList () {
        return this.playerList;
    }

    public void setPlayerList (ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Quest> getQuestList () {
        return this.questList;
    }

    public void setQuestList (ArrayList<Quest> questList) {
        this.questList = questList;
    }

    public int getPlayerCount () {
        return this.playerList.size();
    }

    public double getRegionRank () {
        if (getPlayerCount() == 0) return 0.00;
        double result = 0;

        for (int i=0; i<playerList.size(); i++) result = result + playerList.get(i).getRank();
        result = result / getPlayerCount();
        result = Math.round(result * 100.0)/100.0;
        return result;
    }

    public ArrayList<Quest> getAvailableQuests (Player player) {
        ArrayList<Quest> result = new ArrayList<Quest>(0);

        for (int i=0; i<this.questList.size(); i++) {
            if (this.questList.get(i).getAuthor() != player && this.questList.get(i).getStatus() == Status.AVAILABLE) {
                result.add(this.questList.get(i));
            }
        }

        return result;
    }

    public void addPlayerToRegion (Player player) {
        this.playerList.add(player);
    }

    public void addQuestToRegion (Quest quest) {
        this.questList.add(quest);
    }
}
