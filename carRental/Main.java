package carRental;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, Car> carList = new HashMap<>();
        Map <String, Car> carsRented = new HashMap<>();

        while (!input.equals("End")){
            switch (input){
                case "Create":
                    createCar(sc, carList);
                    break;
                case "Edit":
                    editCarName(sc, carList);
                    break;
                case "List":
                    carList.keySet().forEach(key -> {
                        System.out.println(carList.get(key));
                    });
                    break;
                case "Rent":
                    rentCar(sc, carList, carsRented);
                    break;
                case "Availability":
                    System.out.println("Enter car name: ");
                    String availableCar = sc.nextLine();
                    if (isAvailable(availableCar, carList, carsRented)){
                        System.out.printf("%s is available\n", availableCar);
                    } else {
                        System.out.printf("%s is not available\n", availableCar);
                    }
                    break;
            }
            input = sc.nextLine();
        }
    }

    private static void rentCar(Scanner sc, Map<String, Car> carList, Map<String, Car> carsRented) {
        System.out.println("Enter car name to rent: ");
        String toRent = sc.nextLine();
        if (isAvailable(toRent, carList, carsRented)){
            Car carRent = carList.get(toRent);
            carsRented.put(toRent, carRent);
            System.out.println("Car rented!");
        } else {
            System.out.printf("%s is not available\n", toRent);
        }
    }

    private static void createCar(Scanner sc, Map<String, Car> carList) {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter horsePower: ");
        int horsePower = Integer.parseInt(sc.nextLine());
        Car car = new Car(name, horsePower);
        carList.put(name, car);
        System.out.println("Car created!");
    }

    private static void editCarName(Scanner sc, Map<String, Car> carList) {
        System.out.println("Enter name to edit: ");
        String nameEdit = sc.nextLine();
        Car carEdit = carList.get(nameEdit);
        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        carEdit.editName(newName);
        carList.remove(nameEdit);
        carList.put(newName, carEdit);
        System.out.println("Car renamed!");
    }

    private static boolean isAvailable(String carName, Map<String, Car> carList, Map<String, Car> carsRented) {
        if (!carsRented.containsKey(carName) && carList.containsKey(carName)){
            return true;
        } else{
            return false;
        }
    }


}
