package Donjon_Dragons;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<String> items;  //
    private String equippedItem;

    public Inventory() {
        items = new ArrayList<>();
        equippedItem = null;
    }

    public boolean isEmpty() {
        return items.isEmpty(); // Retourne true si la liste est vide
    }

    // Ajouter un objet à l'inventaire
    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " ajouté à l'inventaire.");
    }

    // Retirer un objet de l'inventaire
    public void removeItem(String item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + " retiré de l'inventaire.");
        } else {
            System.out.println(item + " n'est pas dans l'inventaire.");
        }
    }

    // Équiper un objet
    public void equipItem(String item) {
        if (items.contains(item)) {
            equippedItem = item;
            System.out.println(item + " est maintenant équipé.");
        } else {
            System.out.println("Vous ne possédez pas " + item + ".");
        }
    }

    // Obtenir l'objet actuellement équipé
    public String getEquippedItem() {
        return equippedItem;
    }

    // Afficher le contenu de l'inventaire
    public void displayInventory() {
        System.out.println("Inventaire : " + items);
        System.out.println("Objet équipé : " + (equippedItem != null ? equippedItem : "Aucun"));
    }
    public void showInventory() {
        if (items.isEmpty()) {
            System.out.println(" Votre inventaire est vide.");
        } else {
            System.out.println("Votre inventaire contient :");
            for (String item : items) {
                System.out.println("- " + item);
            }
        }
    }
}
