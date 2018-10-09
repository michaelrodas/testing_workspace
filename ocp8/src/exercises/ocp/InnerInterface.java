package exercises.ocp;

public class InnerInterface {


    private interface MyInnerInterface{}

}

interface AnotherInterface{
    public default int getNumberOfFins(){
        return 4;
    }

    public default double getLongestFinLength(){
        return 2.2;
    }

    public default boolean doFinsHaveScales(){
        return true;
    }
}

interface Another2 extends AnotherInterface{
    public default int getNumberOfFins(){
        return 8;
    }

    public double getLongestFinLength();
/*
    public boolean doFinsHaveScales(){
        return false;
    }*/
}