package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant){
        boolean spaceAvailable = capacity > this.data.size();
        if (spaceAvailable) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name){
        return data.removeIf(animal -> animal.getName().equals(name));
    }

    //getElephant(String retiredFrom) –
    // returns the elephant retired from the given place or null if no such elephant exists.

    public Elephant getElephant (String retiredFrom) {
       return this.data.stream().filter(elephant ->
                elephant.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);

    }

    public Elephant getOldestElephant(){
        return this.data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants(){
        return data.size();
    }


    public String getReport(){

        StringBuilder sb = new StringBuilder();

        sb.append("Saved elephants in the park:");
        sb.append(System.lineSeparator());
        data.forEach(elephant ->
                sb.append(String.format("%s came from: %s%n", elephant.getName(), elephant.getRetiredFrom())));
        return sb.toString();

    }
}
