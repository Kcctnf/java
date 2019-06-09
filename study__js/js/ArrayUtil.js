/**
 * 设置一个Js对象:ArrayUtil
	提供两个方法
	search(array,target) :查询target元素在array数组中出现的索引位置
	max(array):在array中获取数组中的最大值
 */
//定义ArrayUtil对象
function ArrayUtil(){
	//search(array,target)
	this.search=function(array,target){
		//遍历数组
		for(var i =0 ; i <array.length;i++){
			if(array[i] == target){
				//返回角标
				return i ;
			}
		}
		//找不到,返回-1
		return -1 ;
	}
	//max(array):在array中获取数组中的最大值
	this.max = function(array){
		//定义一个参照物
		var max = array[0] ;
		//遍历其他元素
		for(var i = 1; i < array.length;i++){
			if(array[i]>max){
				max = array[i] ;
			}
		}
		return max ;
	}
	
}
