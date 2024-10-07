package fr.campus.dand.engine;

import fr.campus.dand.item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Inventory {
    private UUID id;
    private List<Item> items;  //
    private Item equippedItem;

    /**
     * Create an ArrayList for the inventory and attribute an ID (UUID) for each inventory, allowing me to create an
     * inventory table (in the futur) and join it with my player table and my fr.campus.dand.item table
     */

    public Inventory() {
        this.id = UUID.randomUUID();
        items = new ArrayList<>();
        equippedItem = null;
    }

    public boolean isEmpty() {
        return items.isEmpty();
        /**
         * // Retourne true si la liste est vide
         */
    }


    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " ajouté à l'inventaire.");
        /**
         * // Ajouter un objet à l'inventaire
         */
    }


    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + " retiré de l'inventaire.");
        } else {
            System.out.println(item + " n'est pas dans l'inventaire.");
        }
        /**
         * // Retirer un objet de l'inventaire
         */
    }


    public void equipItem(Item item) {
        if (items.contains(item)) {
            equippedItem = item;
            System.out.println(item + " est maintenant équipé.");
        } else {
            System.out.println("Vous ne possédez pas " + item + ".");
            /**
             *     // Équiper un objet
             */
        }
    }


    public Item getEquippedItem() {
        return equippedItem;
    }

    /**
     * Methodes to display equipped stuff
     */
    public void displayInventory() {
        System.out.println("Inventaire : " + items);
        System.out.println("Objet équipé : " + (equippedItem != null ? equippedItem : items.isEmpty()));
    }
    /**
     * Methodes to display inventory and objects inside
     */
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println(" Votre inventaire est vide.");
        } else {
            System.out.println("Votre inventaire contient :");
            for (Item item : items) {
                System.out.println("- " + item.getName() + " || Poids: " + item.getWeight() + " || Valeur :" + item.getValue()+"Po");
            }
        }
    }
    //Setter getter
    public UUID getId() {
        return id;
    }

}
