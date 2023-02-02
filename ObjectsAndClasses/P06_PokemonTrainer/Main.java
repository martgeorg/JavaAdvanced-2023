package ObjectsAndClasses.P06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstCommandLine = scanner.nextLine();
        Map <String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        while (!firstCommandLine.equals("Tournament")){
            String [] arrayOfCommands = firstCommandLine.split("\\s+");

            String trainerName = arrayOfCommands[0];
            String pokemonName = arrayOfCommands[1];
            String pokemonElement = arrayOfCommands[2];
            int health = Integer.parseInt(arrayOfCommands[3]);

            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,health);
            pokemonByTrainers.putIfAbsent(trainerName, new ArrayList<>());
            pokemonByTrainers.get(trainerName).add(pokemon);

            firstCommandLine = scanner.nextLine();
        }

        List <Trainer> trainerList = pokemonByTrainers.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(),t.getValue()))
                .collect(Collectors.toList());

        String secondCommandLine = scanner.nextLine();

        while (!secondCommandLine.equals("End")){

            for (Trainer trainer: trainerList) {
                trainer.elementsChecking(secondCommandLine);
            }
            secondCommandLine = scanner.nextLine();
        }

        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
}
