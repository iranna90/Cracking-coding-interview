package dynamic.onedimensional.recursion.tower;

import java.util.Stack;

public class Tower {
  private final int index;
  private final Stack<Integer> disks;

  public Tower(final int index) {
    this.index = index;
    this.disks = new Stack<>();
  }

  public void add(int disk) {
    if (!disks.isEmpty() && disks.peek() <= disk) {
      System.out.println("Error adding disk");
    } else {
      disks.push(disk);
    }
  }

  public void moveTop(Tower dest) {
    if (disks.isEmpty()) {
      System.out.println("Error as empty disks");
    } else {
      dest.add(disks.pop());
    }
  }

  public void moveDisks(int n, Tower dest, Tower temp) {
    if (n > 0) {
      moveDisks(n - 1, temp, dest);
      moveTop(dest);
      temp.moveDisks(n - 1, dest, this);
    }
  }

  public void printContent() {
    for (Integer disk: disks) {
      System.out.println(disk);
    }
  }
}
