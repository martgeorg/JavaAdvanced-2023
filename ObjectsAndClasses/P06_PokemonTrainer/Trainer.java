package ObjectsAndClasses.P06_PokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> listOfPokemons;

    public Trainer(String name, List<Pokemon> listOfPokemons) {
        this.name = name;
        this.badges = 0;
        this.listOfPokemons = listOfPokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void elementsChecking (String element) {
        if (isExists(element)){
            badges += 1;
        } else {
            for (int i = 0; i < listOfPokemons.size() ; i++) {
                listOfPokemons.get(i).setHealth(listOfPokemons.get(i).getHealth()-10);
                if (listOfPokemons.get(i).getHealth() <= 0){
                    listOfPokemons.remove(i);
                    i--;
                }
            }
        }
    }
    
    
    private boolean isExists (String element){
        for (Pokemon pokemon: listOfPokemons) {
            if (pokemon.getElement().equals(element)){
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + badges + " " + listOfPokemons.size();
    }
}
