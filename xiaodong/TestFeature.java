package xiaodong;

/**
 * Autor : dong
 * Time:2018/12/9
 */
public class TestFeature {
    public static int add1(int[] data) {
        if (data == null) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }

    //可变参数
    public static int add2(int... data) {
        if (data == null) {
            return -1;
        }
        int result = 0;
        for (int i = 0, len = data.length; i < len; i++) {
            result += data[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add1(new int[]{1, 2, 3}));
        int[] data = new int[]{1, 2, 3};
        System.out.println(add1(data));

        System.out.println(add2(1, 2, 3));

        int[] data1 = new int[]{1, 2, 3, 4, 5};
        //直接将数组的内容付给前边的 j,然后一次一次打印
        for (int j : data1) {
            System.out.println(j);
        }
    }
}
