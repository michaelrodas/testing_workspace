package exercises.patterns;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Planet is an immutable class, since there is no way to change
 * its state after construction.
 */
public final class Planet {
    private String name;
    private int age;
    private List<String> moons;
    private String colour;

    public Planet(String name, int age, List<String> moons){
       this.name = name;
        this.age = age;
        this.moons = new ArrayList<String>(moons);

    }

    public Planet(String name, int age, List<String> moons,String colour){
        this(name,age,moons);
        this.colour=colour;

    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public List<String> getMoons(){
        return Collections.unmodifiableList(moons);
    }

    public static class PlanetBuilder{
        private String name;
        private int age;
        private List<String> moons;
        private String colour;

        public PlanetBuilder withName(String name){
            this.name = name;
            return this;
        }
        public PlanetBuilder withAge(int age){
            this.age = age;
            return this;
        }

        public PlanetBuilder setMoons(List<String> moons){
            this.moons = moons;
            return this;
        }
        public PlanetBuilder withColour(String colour){
            this.colour = colour;
            return this;
        }

        public Planet build(){
            return new Planet(name,age,moons,colour);
        }

    }
}