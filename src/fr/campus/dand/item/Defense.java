package fr.campus.dand.item;

public abstract class Defense extends Item {

    //instance field

    private String name;
    private int defense;
    private String defenseType;


// constructor
public Defense(String name) {
 this.name = name;
}

    public Defense() {
    super();
    }

//method
    public abstract void use ();
    public String toString() {
        return "Chloung!";
    }


//getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getType() {
        return defenseType;
    }

    public void setType(String defenseType) {
        this.defenseType = defenseType;
    }

}

