package logic;

public class OrderItem {
    private Item item;
    private int itemAmount;

    public OrderItem (Item item, int itemAmount) {
        setItem(item);
        setItemAmount(itemAmount);
    }

    public void increaseItemAmount (int amount) {
        this.itemAmount = (amount >= 0) ? this.itemAmount + amount : this.itemAmount;
    }

    public int calculateTotalPrice () {
        int result = this.item.getPricePerPiece() * this.itemAmount;
        return result;
    }

    public Item getItem () {
        return this.item;
    }

    public void setItem (Item item) {
        this.item = item;
    }

    public int getItemAmount () {
        return this.itemAmount;
    }

    public void setItemAmount (int itemAmount) {
        this.itemAmount = (itemAmount >= 0) ? itemAmount : 0;
    }
}
