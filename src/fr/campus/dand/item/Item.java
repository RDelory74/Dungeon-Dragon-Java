package fr.campus.dand.item;

import java.util.UUID;

/**
 * Here is the mother class for item
 * This is from this class all the items will have UUId when we instance them.
 * It's an abstract class with an abstract method (use)
 * Under this motherCLass we will found 4 subClass group (Defense, Weapon,Valuable, Consumable)
 * Defense and Weapon will concern player equipped stuff and the special specs it affect
 * Consumable are the potion food drink every item which are consumable by the player
 * And finally the Valuable are all the items with important value only to sell.
     * Also we had subClass to weapon and defenses as armes, armures, sortileges,philtres, and each one set a custom
 * interact with the player
 *
 */


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

    public void setId(UUID id) {
        this.id = id;
    }

    public Item() {
        this.id = UUID.randomUUID();
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
