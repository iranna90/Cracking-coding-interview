package data;

public class AnotherAdd implements Add {
    @Override
    public int add(int a, int b) {
        return a * b + b;
    }
}
