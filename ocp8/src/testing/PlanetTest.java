package testing;

import exercises.patterns.Planet;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MichaelR on 14/02/2018.
 */
public class PlanetTest extends TestCase {

    public void testPlanet(){

        List<String> moons= new ArrayList<String>();
        moons.add("Moon1");
        moons.add("Moon2");
        moons.add("Moon3");

        Planet planet= new Planet("Earth",400,moons);

        moons.add("CrazyMoon");

        try {
            planet.getMoons().add("Moon 5");
            fail();
        }catch (Exception e){
        }

        assertEquals(planet.getMoons().size(),3);
    }

    public void testBuilderTest(){
        Planet.PlanetBuilder planetBuilder=new Planet.PlanetBuilder();
        List<String> moons= new ArrayList<String>();
        moons.add("Moon1");

        Planet planet = new Planet.PlanetBuilder().
                withName("Moon 1").
                withAge(1000).withColour("Pink").setMoons(moons).build();
        moons.add("CrazyMoon");

        try {
            planet.getMoons().add("Moon 5");
            fail();
        }catch (Exception e){
        }
        assertEquals(1,planet.getMoons().size());
    }
}
