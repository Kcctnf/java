
package project;

enum State {
    NORMAL,         // 开始状态，平时的状态
    READ_CR,        // 已经读到一个 \r 的状态
}
public class StateTranstionMachine {
    private static String process(byte[] bytes) {
        State state = State.NORMAL;
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            switch (b) {
                case '\r':
                    if (state == State.READ_CR) {
                        sb.append((char)b);
                    }
                    state = State.READ_CR;
                    break;
                case '\n':
                    if (state == State.READ_CR) {
                        return sb.toString();
                    }
                    sb.append((char)b);
                    break;
                default:
                    if (state == State.READ_CR) {
                        sb.append('\r');
                    }
                    state = State.NORMAL;
                    sb.append((char)b);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String m = "he\nl\rlo\r\r\n";
        System.out.println(process(m.getBytes()));

        System.out.print("hello\r1");
    }
}
