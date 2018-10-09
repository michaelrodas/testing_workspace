package exercises.patterns;

/**
 * Created by MichaelR on 14/02/2018.
 */
public class MeaningOfLife {
    private int value = 42;
    private static MeaningOfLife instance;

    private MeaningOfLife(){
        System.out.println("Only one....");
    }

    public static MeaningOfLife getInstance(){
        if(instance==null){
           // synchronized (MeaningOfLife.class){
                //if(instance==null){
                    instance=new MeaningOfLife();
                //}
           // }
        }
        return instance;
    }

    public final int getValue(){
        return value;
    }

}
