package xiaodong;

import java.util.Properties;

/**
 * Autor : dong
 * Time:2018/12/9
 */
public class TestSystem {
    public static void main(String[] args) {
        //系统属性
        Properties properties = System.getProperties();
        //常用的系统属性
        //user.home
        //user.dir
        //java.home
        //path.separator
        //file.separator
        String userHome = (String)properties.get("user.home");
        System.out.println(userHome);

        //系统的环境变量
        //Map<String ,String>env = System.getenv();
        //for(Map.entry<String,String> entry:env.entrySet()){
        //System.out.println(entry.getKey()+"="+entry.getValue());
        // }

        //JAVA_HOME
        //SystemDriver
        //Path
        //ProgramW6432
        //TEMP

    }
}
