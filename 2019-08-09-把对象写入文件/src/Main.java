import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, List<String>> list = new HashMap<>();

    public static void main(String[] args) throws IOException {
        /*
        list.put("hello", new ArrayList<>());
        list.put("peixinchen", new ArrayList<>());
        list.get("hello").add("0");
        list.get("hello").add("1");
        list.get("hello").add("2");
        list.get("hello").add("3");

        list.get("peixinchen").add("A");
        list.get("peixinchen").add("B");
        list.get("peixinchen").add("C");

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("list.bin"))) {
            os.writeObject(list);
        }
         */

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("list.bin"))) {
            try {
                list = (Map<String, List<String>>)is.readObject();
                System.out.println(list);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
