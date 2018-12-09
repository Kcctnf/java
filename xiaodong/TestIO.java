package xiaodong;

import java.io.*;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Autor : dong
 * Time:2018/12/9
 */
public class TestIO {
    public static void code1() {
        OutputStream out = System.out;
        try {
            out.write("比特欢迎你".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void code2() throws IOException {
        InputStream in = System.in;
        byte[] data = new byte[1024];
        System.out.println("qing shu ru xin xi:");
        int temp = in.read(data);
        System.out.println("shu chu nei rong:" + new String(data, 0, temp));
    }

    public static void main(String[] args) {
        //需求： 借助Bufferedreader 实现程序点名
        //思路：
        //1. 人员数据
        //2. 人员读入到陈序
        //3. 生成随机数与人员关联
        //4. 输出人员目标
        //技术点：
        //1.
        File studentDataFile = Paths.get("D:", "test", "java6_student.txt").toFile();
        try (InputStream in = new FileInputStream(studentDataFile); Reader inputStreamReader = new
                InputStreamReader(in); BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = null;
            String[] student = new String[42];
            int index = -1;
            while ((line = reader.readLine()) != null) {
                index++;
                student[index] = line;
            }
            Random  random = new Random();
            int selectIndex = random.nextInt(student.length);
            System.out.println("选择的学生是："+student[selectIndex]);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}


















