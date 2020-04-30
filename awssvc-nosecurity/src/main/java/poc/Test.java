package poc;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static void main(String args[]) {
        Logger.getAnonymousLogger().log(Level.INFO,"a message{0}", 666);
/*
        String url = "https://internal.dev.cloud.jumbo.com/v1/routeplanner/postalcodes?countryCode=<countryCode>&postalCode=<address>&street=<street>";

        IntStream.range(0, 1000).parallel().forEach(
                x -> {
                    //int resp = rpError.execute(x % 2 == 0 ? url : "");
                    int resp = rpError.execute(url);
                    System.out.println(resp==1?"good exec":"bad exec");
                }
        );

        System.out.println("Test finished");*/
        Map<Integer, String> myMap = new HashMap<>();
        int count=0;
        for (int i = 0; i < 30; i++) {
            count = i;
            if(myMap.size()<25)
                myMap.put(i,"wooww");
            else
                break;

        }
        System.out.println(myMap.size() + " and count "+ count);
        error();
        Double lat=25.123456789;
        Double lati=25.123456789;
        System.out.println("double2long: " + (Double.doubleToLongBits(lat) == Double.doubleToLongBits(lati)));
        BigDecimal a = new BigDecimal(lat);
        BigDecimal b = new BigDecimal(lati);
        System.out.println("bigdecimal: " + (a.compareTo(b)==0));
        System.out.println("double: " + (Double.compare(lat,lati)==0));
        System.out.println("equals: " + (lat.equals(lati)));
    }

    public static void error(Object... params){
        if(params.length==0)
            System.out.println(1);
        else
            System.out.println(2);
    }

}
