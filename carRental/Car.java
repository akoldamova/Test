package carRental;
public class Car {
    private String name;
    private int horsePower;

    public Car(String name, int horsePower) {
        this.name = name;
        this.horsePower = horsePower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void editName (String newName){
        this.name = newName;
    }

    public String toString (){
        return this.name + ": " + this.horsePower + " hP";
    }
}
