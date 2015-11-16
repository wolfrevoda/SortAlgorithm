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
 * ���ߣ���ͼ
 * ʱ�䣺2015.11.11 15:50
 * �㷨������
 * ���ڴ��ģ����������������������Ϊ��ֻ�ύ�����ڵ�Ԫ�أ����Ԫ��ֻ��һ��һ��Ĵ������һ���ƶ�����һ�ˡ�
 * ϣ������Ϊ�˽Ͽ��ٶȣ��Բ�������������޸ģ����������ڵ�Ԫ���Զ�����ľֲ��������򣬲������ò������򽫾ֲ�
 * ���������������˼����ʹ������������Ϊh��Ԫ�����򡣼�ÿ�ζ����õ�k��Ԫ�����k+h��Ԫ�ؽ��бȽϣ�������
 * ����Կ�����h=1��ϣ������
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
		while(h < len/3)	//set h ����hֵ
			h = 3*h + 1;
		while(h >= 1){	//do h/3 times sort ������h/3������
			for(int i = h; i < len; ++i){	
				for(int j = i; j >= h && sortedData[j].compareTo(sortedData[j-h])<0; j -= h){
					T temp = sortedData[j];
					sortedData[j] = sortedData[j-h];
					sortedData[j-h] = temp;
				}
			}
			h = h/3;	//update h ����hֵ
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
