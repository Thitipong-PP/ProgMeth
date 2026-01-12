package logic;

public class Item {
    private String name;
    private int pricePerPiece;

    public Item (String name, int pricePerPiece) {
        setName(name);
        setPricePerPiece(pricePerPiece);
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getPricePerPiece () {
        return this.pricePerPiece;
    }

    public void setPricePerPiece (int pricePerPiece) {
        if (pricePerPiece < 1) pricePerPiece = 1;
        this.pricePerPiece = pricePerPiece;
    }
}
