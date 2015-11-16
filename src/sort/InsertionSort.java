/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:00
 * Algorithm Describe:
 * The algorithm that people often use to sort bridge hands is to consider the cards 
 * one at a time, inserting each into its proper place among those already considered.
 * In a computer implementation, we need to make space to insert the current item by 
 * moving larger items one position to the right, before inserting the current item into
 * the vacated position. This method is called insertion sort.
 * 
 * 作者：巴图
 * 时间：2015.11.11 15:50
 * 算法描述：
 * 通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的排中的适当位置。在计算机的实现中，
 * 为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。这种算法叫做插入排序
 * 
 *  */

package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort<T extends Comparable> {
	public void insertSort(T [] sortedData){
		for(int i = 1; i < sortedData.length; ++i){		//sort 进行排序
			for(int j = i; j > 0 && (sortedData[j].compareTo(sortedData[j-1]) < 0); --j){	// move移动
				T temp = sortedData[j];
				sortedData[j] = sortedData[j-1];
				sortedData[j-1] = temp;
			}
		}
	}
	
	public static void main(String args[]){
		InsertionSort insert = new InsertionSort();
		File f = new File("E:\\workspace\\Algorithm\\src\\words3.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String tempData = "";
			String [] sortedData = null;
			try {
				String temp;
				while((temp = br.readLine()) != null)
					tempData += temp + " ";
				sortedData = tempData.split(" ");
				for(int i = 0; i < sortedData.length; ++i)
					System.out.print(sortedData[i] + " ");
				System.out.println();
				insert.insertSort(sortedData);
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
