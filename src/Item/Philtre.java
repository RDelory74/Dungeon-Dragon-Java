package Item;

public  class Philtre extends Defense {
// constructor
    public Philtre(String name, int defense, String type) {

        setName(name);
        setDefense(defense);
        setType(type);
    }

    public Philtre() {
    }
//method
    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "Fouwing!";
    }


}

