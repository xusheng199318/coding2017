package com.coding.basic.array;

import com.coding.basic.List;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public static void reverseArray(int[] origin){
		//边界一定要检测
		if(origin == null || origin.length == 0){
			return;
		}
		
		for(int i=0,j=origin.length-1; i<j; i++,j--){
			int temp = origin[i];
			origin[i] = origin[j];
			origin[j] = temp;
		}
	}
	public static void reverseArrayWrong(int[] origin){
		int[] newArray = new int[origin.length];
		for(int i=0; i<origin.length; i++){
			newArray[i] = origin[origin.length-1-i];
		}
		origin = newArray;
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public static int[] removeZero(int[] oldArray){
		if(oldArray == null){
			return null;
		}
		
		int[] newArray = new int[oldArray.length];
		int size = 0;
		for(int i : oldArray){
			if(i != 0){
				newArray[size++] = i;
			}
		}
		int[] result = new int[size];
		System.arraycopy(newArray, 0, result, 0, size);
		return result;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public static int[] merge(int[] array1, int[] array2){
		if(array1 == null){
			return array2;
		}
		if(array2 == null){
			return array1;
		}
		
		int[] newArray = new int[array1.length + array2.length];
		
		int i = 0;
		int j = 0;
		int t = 0;
		while(i<array1.length && j<array2.length){
			
			newArray[t] = array1[i] < array2[j] ? array1[i] : array2[j];

			if(array1[i] < array2[j]){
				newArray[t++] = array1[i++];
			}else if(array1[i] > array2[j]){
				newArray[t++] = array2[j++];
			}else{
				newArray[t++] = array1[i++];
				j++;
			}
		}

		while(i<array1.length){
			newArray[t++] = array1[i++];
		}

		while(j<array2.length){
			newArray[t++] = array2[j++];
		}
		
		int[] result = new int[t];
		System.arraycopy(newArray, 0, result, 0, t);
		
		return  result;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public static int[] grow(int [] oldArray,  int size){
		int[] newArr = new int[oldArray.length + size];
		System.arraycopy(oldArray, 0, newArr, 0, oldArray.length);
		return newArr;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public static int[] fibonacci(int max){
		if(max <= 1){
			return null;
		}
		
		//也可以用一个max长度的数组来做
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		int value = list.get(0) + list.get(1);		
		while(value < max){
			int index = list.size();			
			list.add(list.get(index-1) + list.get(index-2));
			index = list.size();
			value = list.get(index-1) + list.get(index-2);
		}
				
		int[] fibonacci = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			fibonacci[i] = list.get(i);
		}
		return fibonacci;
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public static int[] getPrimes(int max){
		if(max <= 2){
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		for(int num = 3; num < max; num++){
			if(isPrime(num)){
				list.add(num);
			}
		}
				
		int[] result = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			result[i] = list.get(i);
		}		
		return result;
	}
	private static boolean isPrime(int num) {
		boolean isPrime = true;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public static int[] getPerfectNumbers(int max){
		if(max < 1){
			throw new IndexOutOfBoundsException();
		}
		
		ArrayList<Integer> perfectNumbers = new ArrayList();
		for(int num=1; num < max; num++){
			ArrayList<Integer> list = new ArrayList();
			int i;
			for(i=1; i<Math.sqrt(num); i++){
				if(num % i == 0){
					int j = num / i;
					list.add(i);
					if(j != num){
						list.add(j);
					}
					System.out.println("num: "+num+" i: "+i+" j: "+j);
				}
			}
			if(i == Math.sqrt(num)){
				list.add(i);
				System.out.println("num: "+num+" sqrt: "+i);
			}
			if(list != null){
				int sum = 0;
				for(int j=0; j<list.size(); j++){
					sum += list.get(j);
				}
				System.out.println("num: "+num+" sum: "+sum);
				if(sum == num){
					perfectNumbers.add(num);
				}
			}
		}
				
		int[] result = new int[perfectNumbers.size()];
		for(int i=0; i<perfectNumbers.size(); i++){
			result[i] = perfectNumbers.get(i);
		}
		
		return result;
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public static String join(int[] array, String seperator){
		
		if(array==null || array.length==0){
			return null;
		}
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < array.length-1){
			sb.append(array[i] + seperator);
			i++;
		}
		sb.append(array[array.length-1]);
		return sb.toString();
	}
	

}
