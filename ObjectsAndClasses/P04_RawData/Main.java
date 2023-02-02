package ObjectsAndClasses.P04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCars = Integer.parseInt(scanner.nextLine());
        LinkedHashMap <String, List<Car>> carsByCargo = new LinkedHashMap<>();

        for (int i = 1; i <=numOfCars ; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String model = inputLine[0];
            int engineSpeed = Integer.parseInt(inputLine[1]);
            int enginePower = Integer.parseInt(inputLine[2]);
            int cargoWeight = Integer.parseInt(inputLine[3]);
            String cargoType = inputLine[4];

            Engine engine = new Engine(engineSpeed,enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);

            List<Tire> tireList = new ArrayList<>();
            for (int tireItems = 5; tireItems <= 12; tireItems += 2) {
                Tire currentTire = new Tire(Double.parseDouble(inputLine[tireItems]), Integer.parseInt(inputLine[tireItems + 1]));
                tireList.add(currentTire);
            }

            Car currentCar = new Car(model,engine,cargo,tireList);

            carsByCargo.putIfAbsent(cargoType, new ArrayList<>());
            carsByCargo.get(cargoType).add(currentCar);
        }
        String command = scanner.nextLine();

        carsByCargo.get(command).forEach(car -> car.printCars(command));
    }
}
