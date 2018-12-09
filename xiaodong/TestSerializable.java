package xiaodong;

import java.io.*;
import java.nio.file.Paths;

/**
 * Autor : dong
 * Time:2018/12/9
 */
class Person implements Serializable {
    private String name;
    private Integer age;
    private String telephone;

    public Person() {

    }


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String telephone) {
        this(name, age);
        this.telephone = telephone;
    }

    public String getName() {

        return name;
    }

    public Integer getAge() {

        return age;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Person[name" + name + "age" + age + "telephone" + telephone;
    }
}

public class TestSerializable {
    //序列化只序列化属性
    public static void main(String[] args) {
        //准备序列化输出的文件
        //准备要参与的序列化对象
        //业务操作（Object -> byte[]）
        File objFile = Paths.get("D:","test","person.obj").toFile();
        Person person = new Person("jack",22,"12312141");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(objFile));
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
