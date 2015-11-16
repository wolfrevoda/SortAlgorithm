/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 15:50
 * Algorithm Describe:
 * First, find the smallest item in the array and exchange it with the first entry. 
 * Then, find the next smallest item and exchange it with the second entry. Continue
 * in this way until the entire array is sorted. This method is called selection sort
 * because it works by repeatedly selecting the smallest remaining item.
 * 
 * ���ߣ���ͼ
 * ʱ�䣺2015.11.11 15:50
 * �㷨������
 * ���ȣ��ҵ���������С���Ǹ�Ԫ�أ���Σ�����������ĵ�һ��Ԫ�ؽ���λ�á�Ȼ������ʣ�µ�Ԫ�����ҵ���С
 * Ԫ���������еڶ���λ���ϵ�Ԫ�ؽ���λ�á���˷�����ֱ��������������Ϊֹ�����ַ���������ѡ��������Ϊ
 * ���㷨�ڲ��ϵ�ѡ��ʣ��Ԫ���е���С��
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
			int minPos = i;		//index of minimal entry ������СԪ��
			for(int j = i; j < sortedData.length; ++j){		//find the smallest item ������СԪ��
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
				while((temp = br.readLine()) != null)		//read file ��ȡ�ļ�
					tempData += temp + " ";
				sortedData = tempData.split(" ");	//split data �ָ�����
				s.selectSort(sortedData);	//sort data �����ݽ�������
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
