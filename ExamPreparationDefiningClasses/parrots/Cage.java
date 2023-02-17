package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    //add(Parrot parrot) method - adds an entity to the data if there is room for it

    public void add(Parrot parrot){
        boolean spaceAvailable = capacity > this.data.size();
        if (spaceAvailable) {
            this.data.add(parrot);
        }
    }

    //remove(String name) method - removes a parrot by given name, if such exists, and returns boolean

    public boolean remove(String name){
        return data.removeIf(parrot -> parrot.getName().equals(name));
    }

    //sellParrot(String name) method -
    // sell (set its available property to false without removing it from the collection)
    // the first parrot with the given name, also return the parrot

    public Parrot sellParrot(String name){
        Parrot parrot = null;
        for (Parrot currentParrot : this.data) {
            if (currentParrot.getName().equals(name)) {
                parrot = currentParrot;
                currentParrot.setAvailable(false);
            }
        }
        return parrot;
    }

    //sellParrotBySpecies(String species) method -
    // sells and returns all parrots from that species as a List

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> parrotList = new ArrayList<>();
        for (Parrot currentParrot : this.data) {
            if (currentParrot.getSpecies().equals(species)) {
                currentParrot.setAvailable(false);
                parrotList.add(currentParrot);
            }
        }
        return parrotList;
    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                sb.append(parrot.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
