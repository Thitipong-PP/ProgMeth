package logic;

public class Station {
    private String name;
    private int number;

    public Station (String name, int number) {
        setName(name);
        setNumber(number);
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public void setNumber (int number) {
        if (number < 0) number = 0;
        this.number = number;
    }

    public int getNumber () {
        return this.number;
    }
}
