package ocjp;

public class Variable {

    public static void parse(String input) {
        Float f;
        try {
             f = Float.parseFloat(input);
            System.out.println(f);
            f = 10.0f;
        } catch (NumberFormatException exp) {
            f = 0.0f;
        }
    }
}
