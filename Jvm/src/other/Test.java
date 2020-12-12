package other;

import com.sun.javafx.tools.ant.CSSToBinTask;

/**
 * Copyright (c) 2019-2020 danke.com All Rights.
 *
 * @author xuning
 **/
public class Test {
  public Test() {
    System.out.println("TC");
  }

  static {
    System.out.println("static A");
  }
  public static void main(String[] args) {
    B b = new B();
  }

}

class B extends Test{
  public B() {
    System.out.println("BC");
  }

  static {
    System.out.println("static B");
  }
}