package binary;

import java.util.*;
import java.io.*;

public class Binary {
	//二分查找，数组必须是有序的
	public static boolean binarySearch(int key, Vector<Integer> a){
		int low = 0;
		int high = a.size() - 1;
		//能用循环控制的尽量不要用递归，这里二分查找无需递归也可以很好的表达
		//这里要注意循环条件为<=而不是<
		while(low <= high){
			int mid = (low+high)/2;
			if(a.get(mid) == key)
				return true;
			else if(key < a.get(mid))
				high = mid-1;
			else
				low = mid + 1;
		}
		
		return false;
	}
	
	//为vector中的元素排序
	public static void sort(int low, int high, Vector<Integer> v){
		int target = v.get(low);
		int start = low;
		int end = high;
		while(start < end){
			while(start < end && v.get(end) > target)
				--end;
			v.set(start, v.get(end));
			while(start < end && v.get(start) < target)
				++start;
			v.set(end, v.get(start));
		}
		v.set(start, target);
		if(start > low)
			sort(low, start-1, v);
		if(start < high)
			sort(start+1, high, v);
	}
	
	public static void main(String[] args){	
		try{
			//创建文件对象
			FileReader file1 = new FileReader("E:\\workspace\\Algorithm\\src\\tinyW.txt");
			//创建高效输入流对象
			BufferedReader br = new BufferedReader(file1);
			String data;
			Vector v = new Vector();
			while((data = br.readLine()) != null)
				v.add(Integer.parseInt(data));
			sort(0, v.size()-1, v);
			//创建输入文件对象
			FileReader file2 = new FileReader("E:\\workspace\\Algorithm\\src\\tinyT.txt");
			BufferedReader br2 = new BufferedReader(file2);
			while((data = br2.readLine()) != null){
				if(!binarySearch(Integer.parseInt(data), v))
					System.out.println(data);
			}
			file1.close();
			file2.close();
			
		}catch (IOException e){
			System.out.println("Exception error!");
			e.printStackTrace();
		}		
	}
}
