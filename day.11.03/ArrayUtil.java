public class ArrayUtil{
	//计算数组中的最大值s
	public static int arrayMaxElement(int [] data){
		int max = Integer.MIN_VALUE;
		if(data == null){
			throw new IllegalArgumentException("a must be not null");
		}
		for(int i = 0;i < data.length;++i){
		   if(data[i] > max){
			  max = data[i];
		    }
		}
		return max;
	} 
	
	//计算数组中的最小值
	 public static int arrayMinElement(int [] data){
		 int min = Integer.MAX_VALUE;
		 if(data == null){
			 throw new IllegalArgumentException("a must be not null");
		 }
		 for(int i = 0;i < data.length;++i){
			 if(data[i] < min){
				 min = data[i];
			 }
		 }
		 return min;
	 }
	
	 //计算数组值之和
	 public static int arrayElementSum(int [] data){
		 if(data == null){
			 throw new IllegalArgumentException("a must be not null");
		 }
		 int sum = 0;
		 for(int i = 0;i < data.length;++i){
			 sum = sum + data[i];
		 }
		 return sum;
	 }
	 //数组的拼接
	 public static int[] arrayJoin(int[] a,int[] b){
		 if(a == null){
			 throw new IllegalArgumentException("a must be not null");
		 }
		 if(b == null){
			 throw new IllegalArgumentException("b must be not null");
		 }
		 int len = a.length + b.length;
		 //将两个数组的长度相加
		 int[] c = new int [len];
		 for(int i =0;i < a.length;++i){
			 c[i] = a[i];
		 }
		 for(int i = a.length;i < c.length;++i){
			 //b数组要从第一个数组长度完了之后算起。
			 c[i] = b[i - a.length];
		 }
		 return c;
	 } 
	 //数组的截取
	 //【start,end）
	 public static int[] arraySub(int[] a,int start,int end){
		 if(a == null){
			 throw new IllegalArgumentException("a must be not null");
		 }
		 if(start < 0 || end < 0){
			 throw new IllegalArgumentException("start or end must be >0");
		 }
		 if(end < start){
			 throw new IllegalArgumentException("end must be > start");
		 }
		 if(start >= a.length){
			 throw new IllegalArgumentException("start must be < a.length");
	     }
		 int count = end - start;
		 if(count > a.length){
			 throw new IllegalArgumentException("count must be < a.length");
		 }
		 int [] b = new int[count];
		 //从哪一个元素开始进行选择，到哪一个元素结束。
		 //自己进行初始化一个数组，然后进行思考就可以。
		 for(int i = start;i < end;++i){
			 b[i - start] = a[i];
		 }
		 return b;
	     }
	  public static void printArray(int [] a){
		 if(a == null){
			 //注意前边是一个无返回值的方法void
			 return;
		 }
		 for(int i = 0;i < a.length;++i){
			 System.out.print(a[i] + " ");
		 }
		 System.out.println();
	 }
	
	public static void main(String [] args){
		int [] a = new int[]{1,2,3,4,5};
		int [] b = new int[]{6,7,8};
		int max = arrayMaxElement(a);
		int min = arrayMinElement(a);
		int sum = arrayElementSum(a);
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
		int [] join = arrayJoin(a,b);
		int [] sub = arraySub(a,1,3);
		printArray(join);
		printArray(sub);
	}
}











