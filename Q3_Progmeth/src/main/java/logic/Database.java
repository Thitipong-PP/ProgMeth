package logic;

import java.util.ArrayList;

public class Database {
    private ArrayList<Player> playerList;
    private ArrayList<Region> regionList;

    public Database () {
        playerList = new ArrayList<Player>(0);
        regionList = new ArrayList<Region>(0);
    }

    public Database (ArrayList<Player> playerList, ArrayList<Region> regionList) {
        setPlayerList(playerList);
        setRegionList(regionList);
    }

    public Player addPlayer (String name, Region region) throws Exception {
        for (int i=0; i<this.playerList.size(); i++) {
            if (this.playerList.get(i).getName() == name) {
                throw new Exception("This player already in the region");
            }
        }

        this.playerList.add(new Player(name));
        region.addPlayerToRegion(this.playerList.getLast());

        return this.playerList.getLast();
    }

    public boolean addRegion (String name) {
        if (getRegionByName(name) != null) return false;

        this.regionList.add(new Region(name));
        return true;
    }

    public Region getRegionByName (String name) {
        for (int i=0; i<this.regionList.size(); i++) {
            if (this.regionList.get(i).getName() == name) return this.regionList.get(i);
        }

        return null;
    }

    public void addQuest (Player player, Region region, String name, String description) {
        region.addQuestToRegion(new Quest(player, region, name, description));
    }

    public ArrayList<Player> getPlayerList () {
        return this.playerList;
    }

    public void setPlayerList (ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Region> getRegionList () {
        return this.regionList;
    }

    public void setRegionList (ArrayList<Region> regionList) {
        this.regionList = regionList;
    }
}
