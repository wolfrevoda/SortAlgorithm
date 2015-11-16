/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 15:50
 * Algorithm Describe:
 * First, find the smallest item in the array and exchange it with the first entry. 
 * Then, find the next smallest item and exchange it with the second entry. Continue
 * in this way until the entire array is sorted. This method is called selection sort
 * because it works by repeatedly selecting the smallest remaining item.
 * 
 * 作者：巴图
 * 时间：2015.11.11 15:50
 * 算法描述：
 * 首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置。然后，再在剩下的元素中找到最小
 * 元素与数组中第二个位置上的元素交换位置。如此反复，直到整个数组有序为止。这种方法被称作选择排序，因为
 * 该算法在不断的选择剩余元素中的最小者
 * 
 *  */

package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SelectionSort<T extends Comparable > {
	public void selectSort(T [] sortedData){
		for(int i = 0; i < sortedData.length; ++i){
			T minVal = sortedData[i];
			int minPos = i;		//index of minimal entry 索引最小元素
			for(int j = i; j < sortedData.length; ++j){		//find the smallest item 搜索最小元素
				if(sortedData[j].compareTo(minVal) < 0){
					minVal = sortedData[j];
					minPos = j;
				}
			}
			sortedData[minPos] = sortedData[i];
			sortedData[i] = minVal;
		}
	}
	
	public static void main(String args[]){
		SelectionSort s = new SelectionSort();
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
				s.selectSort(sortedData);	//sort data 对数据进行排序
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
