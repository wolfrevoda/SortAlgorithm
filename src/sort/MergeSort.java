/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:00
 * Algorithm Describe:
 * Merge sort: to sort an array, divide it into two halves, sort the two halves(recursively),
 * and then merge the results.
 * 
 * 作者：巴图
 * 时间：2015.11.11 15:50
 * 算法描述：
 * 归并排序：要将一个数组排序，可以先递归的将它分成两半分别排序，然后再将结果归并起来
 * 
 *  */

package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MergeSort <T extends Comparable>{
	public void mergeSort(T [] sortedData){
		int len = sortedData.length;
		ArrayList<T> tempArray = new ArrayList<T>();
		for(int i = 0; i < len; ++i)
			tempArray.add(sortedData[i]);
		int low = 0; 
		int high = len-1;
		sort(low, high, sortedData, tempArray);	//sort array 对数组排序
	}
	
	public void sort(int low, int high, T [] sortedData, ArrayList<T> tempArray){
		if(low >= high)
			return;
		int mid = (low+high)/2;
		sort(low, mid, sortedData, tempArray);
		sort(mid+1, high, sortedData, tempArray);
		merge(low, high, mid, sortedData, tempArray);
	}
	
	public void merge(int low, int high, int mid, T [] sortedData, ArrayList<T> tempArray){
		int i = low;
		int j = mid+1;
		int x = low;
		for(int k = low; k <= high; ++k)
			tempArray.set(k, sortedData[k]);
		while(x <= high){
			if(i > mid){	//left array done 左边的数组已经归并完了，剩余的位置都由右边数组填充
				while(j <= high)
					sortedData[x++] = tempArray.get(j++);
			}
			else if(j > high){	//right array done 右边的数组已经归并完了，剩余的位置都有左边数组填充
				while(i <= mid)
					sortedData[x++] = tempArray.get(i++);
			}
			else if(tempArray.get(i).compareTo(tempArray.get(j))<0)	//the element in left array lower than the element in right array 左边元素小于右边元素
				sortedData[x++] = tempArray.get(i++);
			else	//the element in left array higher than the element in right array 左边数组对应元素大于右边数组对应元素
				sortedData[x++] = tempArray.get(j++);		
		}
	}
	
	public static void main(String args[]){
		MergeSort m = new MergeSort();
		File f = new File("E:\\workspace\\Algorithm\\src\\words3.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String [] sortedData;
			String tempData = "";
			String temp;
			try {
				while((temp = br.readLine()) != null)
					tempData += temp+" ";
				System.out.println(tempData);
				sortedData = tempData.split(" ");
				m.mergeSort(sortedData);
				for(int i = 0; i < sortedData.length; ++i)
					System.out.print(sortedData[i]+" ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
