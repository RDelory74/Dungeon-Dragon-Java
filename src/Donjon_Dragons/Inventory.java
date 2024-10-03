package Donjon_Dragons;

import Item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Inventory {
    private UUID id;
    private List<Item> items;  //
    private Item equippedItem;



    public Inventory() {
        this.id = UUID.randomUUID();
        items = new ArrayList<>();
        equippedItem = null;
    }

    public boolean isEmpty() {
        return items.isEmpty(); // Retourne true si la liste est vide
    }

    // Ajouter un objet à l'inventaire
    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " ajouté à l'inventaire.");
    }

    // Retirer un objet de l'inventaire
    public void removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + " retiré de l'inventaire.");
        } else {
            System.out.println(item + " n'est pas dans l'inventaire.");
        }
    }

    // Équiper un objet
    public void equipItem(Item item) {
        if (items.contains(item)) {
            equippedItem = item;
            System.out.println(item + " est maintenant équipé.");
        } else {
            System.out.println("Vous ne possédez pas " + item + ".");
        }
    }

    // Obtenir l'objet actuellement équipé
    public Item getEquippedItem() {
        return equippedItem;
    }

    // Afficher le contenu de l'inventaire
    public void displayInventory() {
        System.out.println("Inventaire : " + items);
        System.out.println("Objet équipé : " + (equippedItem != null ? equippedItem : items.isEmpty()));
    }
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

    public List<Item> getItems() {
        return items;
    }
}
