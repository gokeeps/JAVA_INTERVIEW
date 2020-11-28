package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.remove("b");
        list.get(1);
        Vector<String> vector = new Vector<>();
        vector.add("a");
        vector.remove("a");
        vector.get(1);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.remove(1);
        linkedList.get(0);

        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("a");
        copyOnWriteList.remove("a");
        copyOnWriteList.get(0);

    }
}
