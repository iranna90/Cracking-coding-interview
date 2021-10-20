package basic;

public class Base64 {
  public static void main(String[] args) {
    String a = "A";
    byte[] bytes = a.getBytes();

    String s = java.util.Base64.getEncoder().encodeToString(bytes);
    System.out.println(s);
  }
}
