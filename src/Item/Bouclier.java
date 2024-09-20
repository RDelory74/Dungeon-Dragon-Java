package Item;

public  class Bouclier extends Defense {




// constructor
    public Bouclier(String name, int defense, String type) {

        setName(name);
        setDefense(defense);
        setType(type);
    }

    public Bouclier() {
    }
//method
    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "Bouwing!";
    }


}

