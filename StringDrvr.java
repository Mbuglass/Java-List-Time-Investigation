/**
 * TimedListOpsStringDrvr.java
 *   Driver for TimedListOps<E> using String for E
 */
import java.util.*;
import java.io.*;

public class StringDrvr {
  private static List<String> loadData(char mode, String path) throws IOException {
    List<String> data = null;
    if (mode == 'a') {
      System.out.println("ArrayList<String>");
      data = new ArrayList<String>();
    } else if (mode == 'l') {
      System.out.println("LinkedList<String>");
      data = new LinkedList<String>();
    } else {
      System.out.println("List mode unrecognised");
      System.exit(0);
    }
    Scanner input = new Scanner(new BufferedReader(new FileReader(path)));
    while (input.hasNextLine())
      data.add(input.nextLine());
    System.out.printf("%d items\n", data.size());
    input.close();
    return data;
  }

  public static void main(String[] args) throws IOException {
    if (args.length < 2) {
      System.err.println("Usage: java StringDrvr {a|l} <file path>");
      return;
    }
    TimedListOps<String> app
       = new TimedListOps<String>(loadData(args[0].charAt(0), args[1]));
    for (int i = 0; i < 10; i++) {
      app.fetch(app.dLen()-100+5*i);
      app.fetch(100-5*i);
    }
    for (int i = 0; i < 10; i++) {
      app.insert(100-5*i, "******* insert *******");
    }
    for (int i = 0; i < 10; i++) {
      app.delete(100-5*i);
    }
  } 
}
