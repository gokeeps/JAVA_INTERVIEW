package other;

/**
 * Copyright (c) 2019-2020 danke.com All Rights.
 *
 * @author xuning
 **/
public class StringTest {
  public static void main(String[] args) {
    String a = "a" + "b";
    System.out.println("ab".equals(a));
    System.out.println(a == "ab");
    String b = new String("ab");
    System.out.println(a == b);
    String c = new String("ab");
    System.out.println(b.equals(c));
    System.out.println(b.intern().equals(c.intern()));
  }
}
