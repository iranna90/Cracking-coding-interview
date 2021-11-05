package dynamic.onedimensional.recursion.tower;

public class Main {
  public static void main(String[] args) {
    Tower source = new Tower(1);
    Tower dest = new Tower(2);
    Tower temp = new Tower(3);
    source.add(5);
    source.add(4);
    source.add(3);
    source.add(2);
    source.add(1);
    System.out.println("Source is");
    source.printContent();
    source.moveDisks(5, dest, temp);
    System.out.println("Dest is");
    dest.printContent();
    System.out.println("Source is");
    source.printContent();
    System.out.println("Temp is");
    temp.printContent();
  }
}
