/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:00
 * Algorithm Describe:
 * Quick sort is a divide-and-conquer method for sorting. We achieve a complete sort by partitioning,
 * then recursively applying the method。 We put a[j] into position where no entry in left is greater
 * than a[j], no entry in right is less than a[j] and then arranges the rest of the entries such that
 * the recursive calls finish the sort.
 * 
 * 作者：巴图
 * 时间：2015.11.11 15:50
 * 算法描述：
 * 快速排序是一种分治排序算法，其基本思想是通过通过递归的调用切分来排序的，先将某元素a[j]放到一个合适的位置，在该
 * 位置左边的元素都要比a[j]小，在该位置右边的元素都要比a[j]大，确定了a[j]的位置之后，再递归确定其他位置上的元素.
 * 
 *  */

package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort<T extends Comparable> {
	public void quickSort(T [] sortedData){
		int low = 0;
		int high = sortedData.length - 1;
		sort(sortedData, low, high);
	}
	
	public void sort(T [] sortedData, int low, int high){
		int i = low;
		int j = high+1;
		int splitPos = low;	//split position  切分点
		T objectVal = sortedData[low];
		while(i < j){	//find the split position 寻找切分点
			while(i < j && i < high && sortedData[--j].compareTo(objectVal) > 0);
			while(i < j && j > low && sortedData[++i].compareTo(objectVal) < 0);
			if(i >= j)
				break;
			T temp = sortedData[i];
			sortedData[i] = sortedData[j];
			sortedData[j] = temp;
		}
		sortedData[splitPos] = sortedData[j];	//the position for j stop must less than object value j所停位置必然是比目标值小的位置
		splitPos = j;
		sortedData[splitPos] = objectVal;
		if(splitPos-1 > low)
			sort(sortedData, low, splitPos-1);		//sort array in the left of split position 对切分点左边的元素排序
		if(splitPos+1 < high)
			sort(sortedData, splitPos+1, high);	//sort array in the right of split position 对切分点右边的元素排序
	}
	
	public static void main(String args[]){
		QuickSort q = new QuickSort();
		File f = new File("E:\\workspace\\Algorithm\\src\\words3.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String tempData = "";
			String sortedData[] = null;
			try {
				String temp;
				while((temp = br.readLine()) != null)		//read file 读取文件
					tempData += temp + " ";
				sortedData = tempData.split(" ");	//split data 分割数据
				for(int k = 0; k < sortedData.length; ++k)	
					System.out.print(sortedData[k] + " ");
				System.out.println();
				q.quickSort(sortedData);	//sort data 对数据进行排序
				for(int k = 0; k < sortedData.length; ++k)	
					System.out.print(sortedData[k] + " ");
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
