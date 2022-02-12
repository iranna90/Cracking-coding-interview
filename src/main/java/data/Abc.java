package data;

public class Abc {
    public static void main(String[] args) {
        int result = work((a, b) -> a + b, 4, 5);
        System.out.println(result);

        result = work((a, b) -> a * b + b, 4, 5);
        System.out.println(result);
    }


    private static int work(Add i, int a, int b) {
        return i.add(a, b);
    }

    public enum Day {
        Monday,
        Tuesday,
        Wedensday
    }
}
