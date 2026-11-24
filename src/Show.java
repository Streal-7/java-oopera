import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final List<Actor> listOfActors;

    public Show(String title, int duration, Director director, List<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors == null ? new ArrayList<>() : new ArrayList<>(listOfActors);
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Director getDirector() {
        return director;
    }

    public List<Actor> getListOfActors() {
        return new ArrayList<>(listOfActors);
    }

    public boolean addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актер " + actor + " уже участвует в спектакле '" + title + "'");
            return false;
        }
        listOfActors.add(actor);
        return true;
    }

    public boolean changeActor(Actor newActor, String surname) {
        int index = -1;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equalsIgnoreCase(surname)) {
                if (index != -1) {
                    System.out.println("В спектакле найдено несколько актёров с фамилией " + surname + ". Уточните имя.");
                    return false;
                }
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Актер с фамилией " + surname + " не участвует в спектакле " + title);
            return false;
        }
        Actor oldActor = listOfActors.get(index);
        if (!oldActor.equals(newActor) && listOfActors.contains(newActor)) {
            System.out.println("Актер " + newActor + " уже участвует в спектакле");
            return false;
        }
        listOfActors.set(index, newActor);
        System.out.println("В спектакле '" + title + "' актер " + oldActor + " заменен на " + newActor);
        return true;
    }

    public void printDirectorInfo() {
        System.out.println(director);
    }

    public void printListOfActors() {
        System.out.println("*".repeat(32));
        System.out.println("Список актеров спектакля '" + title + "':");
        if (listOfActors.isEmpty()) {
            System.out.println("В спектакле нет актеров");
            return;
        }
        int index = 1;
        for (Actor actor : listOfActors) {
            System.out.println((index++) + ". " + actor);
        }
        System.out.println("*".repeat(32) + "\n");
    }
}
