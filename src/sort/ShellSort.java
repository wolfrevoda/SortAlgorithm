/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:30
 * Algorithm Describe:
 * Insertion sort is slow for large unordered arrays because the only exchanges it does involve
 * adjacent entries, so items can move through the array only one place at a time.Shellsort is 
 * a simple extension of insertion sort that gains speed by allowing exchanges of array entries 
 * that are far apart, to produce partially sorted arrays that can be efficiently sorted, 
 * eventually by insertion sort. The idea is to rearrange the array to give it the property that
 * taking every hth entry yields a sorted subsequence. We can regard the insertion sort as the
 * shell sort with h = 1
 * 
 * 作者：巴图
 * 时间：2015.11.11 15:50
 * 算法描述：
 * 对于大规模乱序数组插入排序很慢，因为它只会交换相邻的元素，因此元素只能一点一点的从数组的一端移动到另一端。
 * 希尔排序为了较快速度，对插入排序进行了修改，交换不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部
 * 有序的数组排序。其思想是使数组中任意间隔为h的元素有序。即每次都是让第k个元素与第k+h个元素进行比较，插入排
 * 序可以看做是h=1的希尔排序
 *  
 *  */

package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShellSort<T extends Comparable> {
	public void shellSort(T [] sortedData){
		int len = sortedData.length;
		int h = 1;
		while(h < len/3)	//set h 设置h值
			h = 3*h + 1;
		while(h >= 1){	//do h/3 times sort 共进行h/3轮排序
			for(int i = h; i < len; ++i){	
				for(int j = i; j >= h && sortedData[j].compareTo(sortedData[j-h])<0; j -= h){
					T temp = sortedData[j];
					sortedData[j] = sortedData[j-h];
					sortedData[j-h] = temp;
				}
			}
			h = h/3;	//update h 更新h值
		}
	}
	
	public static void main(String args[]){
		ShellSort s = new ShellSort();
		File f = new File("E:\\workspace\\Algorithm\\src\\words3.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String [] sortedData = null;
			String tempData = "";
			String temp;
			try {
				while((temp = br.readLine()) != null)
					tempData += (temp+" ");
				sortedData = tempData.split(" ");
				for(int i = 0; i < sortedData.length; ++i)
					System.out.print(sortedData[i] + " ");
				System.out.println();
				s.shellSort(sortedData);
				for(int i = 0; i < sortedData.length; ++i)
					System.out.print(sortedData[i] + " ");
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
