import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1152 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String data = sc.nextLine();

    StringTokenizer st = new StringTokenizer(data, " ");
    System.out.println(st.countTokens());
  }
}
