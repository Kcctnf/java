//String类扩展功能实现
public class Strings{
     /**
     * 重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
	 //(1)
    public static String repeat(char c, int count) {
		int i = 0;
		char[] data = new char[count];
		if(count <= 0){
			return "";
		}
		else{
			for(i = 0;i < count;++i){
			data[i] = c;
			}
			return new String(data);
		}
    }
	//(2)
	public static String repeat1(char c, int count) {
		StringBuffer Str = new StringBuffer();
		if(count < 0){
			return "";
		}else{
			for(;count > 0;count--){
				Str.append(c);
			}
			//return new String(Str);两种都可以。
			return Str.toString();
		}
    }
    
    
     /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
	 if(str == null){
		   return "";
	   }
	   if(str.length() >= len){
		   return str;
	   }else{
		   int i = 0;
		   //将字符串先传入StringBuffer();
		   StringBuffer sb = new StringBuffer(str);
		   for(i = str.length();i < len;i++){
			 sb.insert(0,filledChar);
			 //sb.insert(0,sr[i]);
		   }
		   return sb.toString();
	   }
	   
    }
    
    /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
        if(str == null){
			return "";
		}if(str.length() >= len){
			return str;
		}else{
			//注意注意传字符串进去
			StringBuffer SB = new StringBuffer(str);
			for(int i = str.length();i < len;i++){
				SB.insert(str.length(),filledChar);
			}
			return SB.toString();
		}
    }

    /**
     * 移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
    public static String removeAll(CharSequence str, CharSequence strToRemove) {
        if(str == null){
			return "";
		}else{
			String str1 = str.toString();
			String str2 = strToRemove.toString();
			return str1.replaceAll(str2,"");
		}
        
    }
    
    /**
     * 反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
		if(str == null){
			return "";
		}else{
			char[] ch = new char[str.length()];
			for(int i = str.length()-1;i >= 0;i--){
				char c = str.charAt(i);
				ch[str.length()-i-1] = c;
			}
			return new String(ch);
        }
    }
    public static void main(String[] args){
		System.out.println(repeat('a',3));
		System.out.println(repeat1('a',3));
		System.out.println("...............");
		System.out.println(fillBefore("abcd",'C',6));
		System.out.println();
		System.out.println(fillAfter("abcd",'C',6));
		System.out.println("...............");
		System.out.println(removeAll("a-b-c","-"));
		System.out.println();
		System.out.println(reverse("abcdefg"));
	}
}





