

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Superhero> apex = new ArrayList<>();
        apex.add(new Superhero("Bangalore", "Anita Williams", 35));
        apex.add(new Superhero("Lifeline", "Ajay Che", 24));
        apex.add(new Superhero("Gibraltar", "Makao Gibralter", 30));
        apex.add(new Superhero("Caustic", "Alexander Nox", 48));
        apex.add(new Superhero("Bloodhound", "Unknown"));
        apex.add(new Superhero("Mirage", "Elliott Witt", 30));
        apex.add(new Superhero("Octane", "Octavio Silva", 24));
        apex.add(new Superhero("Pathfinder", "MRVN"));
        apex.add(new Superhero("Wraith", "Renee Blasey", 32));
        apex.add(new Superhero("Crypto", "Tae Joon Park", 31));
        apex.add(new Superhero("Wattson", "Natalie Paquette", 22));
        apex.add(new Superhero("Revenant", "Unknown", 288));
        apex.add(new Superhero("Loba", "Loba Andrade", 34));
        apex.add(new Superhero("Rampart", "Ramya Parekh", 21));
        apex.add(new Superhero("Horizon", "Dr. Mary Somers", 37));
        apex.add(new Superhero("Fuse", "Walter Fitzroy", 54));
        apex.add(new Superhero("Valkyrie", "Kairi Imahara", 30));
        apex.add(new Superhero("Seer", "Obi Edolasim", 26));
        apex.add(new Superhero("Ash", "Dr. Ashleigh Reid", 121));
        apex.add(new Superhero("Mad Maggie", "Margaret Kōhere", 55));
        apex.add(new Superhero("Newcastle", "Jackson Williams", 40));
        apex.add(new Superhero("Vantage", "Xiomara Contreras", 18));


        //sort med sort()
        //her bruker vi annon indre klasse
        apex.sort(new Comparator<Superhero>() {
            @Override
            public int compare(Superhero hero1, Superhero hero2) {
                return hero1.getAge() - hero2.getAge();
            }
        });

        //samme med lambda expression.
        //apex.sort((hero1, hero2) -> hero1.getAge() - hero2.getAge());

        //without method referance
        //performConditionally(apex,hero -> true, heroAction -> System.out.println(heroAction));

        //with method referance
        performConditionally(apex,hero -> true, System.out::println);

        //print out all super heroes
        System.out.println("===========print out heroes====================");
        printConditionally(apex,hero->true);

        System.out.println("===========print out hero which start with\"B\"====================");
        printConditionally(apex,hero -> hero.getName().startsWith("B"));

        System.out.println("===========all over 40 year====================");
        printConditionally(apex,hero->hero.getAge() > 40);

        System.out.println("===========all over 80 year====================");
        performConditionally(apex,hero -> hero.getAge() > 80,heroAction -> System.out.println(heroAction));

        System.out.println("===========all over 80 year====================");
        /*performConditionally(apex,
                hero -> hero.getAge() > 80,
                heroAction -> {
                    int current = heroAction.getAge();
                    heroAction.setAge(current+1);
                    System.out.println(heroAction);
                });

         */

        //without method referance
        performConditionally(apex,hero -> hero.getAge() > 40, heroAction->heroAction.addYear());

        //with method referance
        performConditionally(apex,hero -> hero.getAge() > 40, Superhero::addYear);


    }//end of main method

    public static void printConditionally(List<Superhero> heroList,Condition condition){
        for(Superhero hero : heroList){
            if(condition.test(hero))
            System.out.println(hero);
        }
    }

    public static void performConditionally(List<Superhero> heroList,Condition condition,Action action){
        for(Superhero hero : heroList){
            if(condition.test(hero))
                action.perform(hero);
        }
    }

}

