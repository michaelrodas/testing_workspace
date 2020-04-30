package poc;

import java.util.regex.Pattern;

public class Regex {
    public static void main(String... args){
        String address = "5616       ES";
        final Pattern pattern = Pattern.compile("^\\d{4}\\s{0,1}[A-Za-z]{2}$");
        final Pattern patternFor4Digit = Pattern.compile("^\\d{4}$");
        address = address.replaceAll("\\s", "");
        if(pattern.matcher(address).matches()){
            System.out.println("it passed");
        }else {
            System.out.println("it didn't pass");
        }

        String[] bools = {null, "", " ", "false", "False", "FALSE", "FalSE", "True", "true", "TRUE", "TrUe"};
        for (String bol:bools) {
            System.out.println("Boolean value is: " + Boolean.parseBoolean(bol));
        }
    }
}
