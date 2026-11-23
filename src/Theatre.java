import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
//1. Создаём людей
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 174);
        Actor actor2 = new Actor("Петр", "Петров", Gender.MALE, 176);
        Actor actor3 = new Actor("Марина", "Маринина", Gender.FEMALE, 168);
        Actor actor4 = new Actor("Марина", "Маринина", Gender.FEMALE, 168);

        Person choreographer = new Person("Роман", "Романов", Gender.MALE);
        Person musicAuthor = new Person("Анна", "Аннова", Gender.FEMALE);
        Director director = new Director("Степан", "Степанов", Gender.MALE, 5);
        Director director2 = new Director("Орлеана", "Орлова", Gender.FEMALE, 15);
//2. Создаём спектакли
        Show simpleShow = new Show("Просто шоу", 60, director, new ArrayList<>());
        Ballet ballet = new Ballet("Балет", 60, director, new ArrayList<>(), musicAuthor, "Либретто балета", choreographer);
        Opera opera = new Opera("Опера", 75, director2, new ArrayList<>(), musicAuthor, "Либретто оперы", 4);
//3. Распределяем актёров
        simpleShow.addActor(actor1);
        simpleShow.addActor(actor3);
//4. Проверка добавления дубликата
        simpleShow.addActor(actor4);
        simpleShow.printListOfActors();
        ballet.addActor(actor1);
        ballet.addActor(actor2);
        ballet.printListOfActors();
        opera.addActor(actor1);
        opera.addActor(actor2);
        opera.addActor(actor3);
        opera.printListOfActors();
//5. Замена и попытка замены несуществующего
        ballet.changeActor(actor3, "Иванов");
        ballet.printListOfActors();
        opera.changeActor(actor2, "Актеров");
//6. Либретто
        opera.printLibretto();
        ballet.printLibretto();
    }
}
