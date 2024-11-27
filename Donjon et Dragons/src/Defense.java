
public class Defense {

    //instance field
    private String name;
    private int defense;
    private String defenseType;


// constructor
public Defense(String defenseType) {
    if(defenseType.equals("Shield")){
        this.name = "Bouclier";
        this.defense = 6;

    } else if (defenseType.equals("Potion")){
        this.name = "Philtre";
        this.defense = 5;
    }
}

    public Defense() {
    }

//method
    public void fffuittt() {
        System.out.println("fffuittt!");
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
    
    public void setType(String type) {
        this.defenseType = defenseType;
    }

}

