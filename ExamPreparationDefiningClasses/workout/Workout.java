package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;


    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void addExercise(Exercise exercise) {
        boolean spaceAvailable = exerciseCount > this.exercises.size();
        if (spaceAvailable) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){
        return exercises.removeIf(exercise ->
                exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise (String name, String muscle){
        return this.exercises.stream().filter(exercise ->
                exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)).findAny().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise(){
       return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount(){
        return exercises.size();
    }

    public String getStatistics(){

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Workout type: %s%n", getType()));
        exercises.forEach(exercise ->
                sb.append(String.format("Exercise: %s, %s, %s%n",
                        exercise.getName(),exercise.getMuscle(), exercise.getBurnedCalories())));

        return sb.toString();


    }
}
