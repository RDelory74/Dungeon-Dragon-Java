package Item;

import java.util.UUID;

public abstract class Item {
   // Attributs
   private UUID id;
    private String name;
    private int weight;
    private int value;
    //Constructor
    public Item(String name, int weight, int value) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public Item() {

    }
    //Méthode abstract
    public abstract void use();

    //Setter Getter

    public UUID getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
