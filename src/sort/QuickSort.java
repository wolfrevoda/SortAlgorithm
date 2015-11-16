/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:00
 * Algorithm Describe:
 * Quick sort is a divide-and-conquer method for sorting. We achieve a complete sort by partitioning,
 * then recursively applying the method�� We put a[j] into position where no entry in left is greater
 * than a[j], no entry in right is less than a[j] and then arranges the rest of the entries such that
 * the recursive calls finish the sort.
 * 
 * ���ߣ���ͼ
 * ʱ�䣺2015.11.11 15:50
 * �㷨������
 * ����������һ�ַ��������㷨�������˼����ͨ��ͨ���ݹ�ĵ����з�������ģ��Ƚ�ĳԪ��a[j]�ŵ�һ�����ʵ�λ�ã��ڸ�
 * λ����ߵ�Ԫ�ض�Ҫ��a[j]С���ڸ�λ���ұߵ�Ԫ�ض�Ҫ��a[j]��ȷ����a[j]��λ��֮���ٵݹ�ȷ������λ���ϵ�Ԫ��.
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
		int splitPos = low;	//split position  �зֵ�
		T objectVal = sortedData[low];
		while(i < j){	//find the split position Ѱ���зֵ�
			while(i < j && i < high && sortedData[--j].compareTo(objectVal) > 0);
			while(i < j && j > low && sortedData[++i].compareTo(objectVal) < 0);
			if(i >= j)
				break;
			T temp = sortedData[i];
			sortedData[i] = sortedData[j];
			sortedData[j] = temp;
		}
		sortedData[splitPos] = sortedData[j];	//the position for j stop must less than object value j��ͣλ�ñ�Ȼ�Ǳ�Ŀ��ֵС��λ��
		splitPos = j;
		sortedData[splitPos] = objectVal;
		if(splitPos-1 > low)
			sort(sortedData, low, splitPos-1);		//sort array in the left of split position ���зֵ���ߵ�Ԫ������
		if(splitPos+1 < high)
			sort(sortedData, splitPos+1, high);	//sort array in the right of split position ���зֵ��ұߵ�Ԫ������
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
				while((temp = br.readLine()) != null)		//read file ��ȡ�ļ�
					tempData += temp + " ";
				sortedData = tempData.split(" ");	//split data �ָ�����
				for(int k = 0; k < sortedData.length; ++k)	
					System.out.print(sortedData[k] + " ");
				System.out.println();
				q.quickSort(sortedData);	//sort data �����ݽ�������
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
