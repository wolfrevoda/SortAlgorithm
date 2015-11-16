/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:00
 * Algorithm Describe:
 * Heapsort breaks into two phases: heap construction and heap sort. In heap construction phrase, 
 * we reorganize the original array into a heap, and in the heap sort phrase, we pull the items 
 * out of the heap in decreasing order to build the sorted result. Most of the work during heapsort
 * is done during the second phase, where we remove the largest remaining item from the heap and put 
 * it into the array position vacated as the heap shrinks.
 * 
 * ���ߣ���ͼ
 * ʱ�䣺2015.11.11 15:50
 * �㷨������
 * ��������Է�Ϊ�����׶Σ��ѵĹ���׶κͶѵ�����׶Ρ����У��ڶѵù���׶Σ����ǽ�ԭʼ����������֯���Ž�һ�����У�Ȼ
 * ��������׶Σ��Ӷ��а��ݼ�˳��ȡ������Ԫ�ز��õ������������������Ҫ���������ڵڶ��׶���ɵġ��������ǽ����е���
 * ��Ԫ��ɾ����Ȼ��������С�������пճ���λ�á�
 * 
 *  */

package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort<T extends Comparable> {
	public void Heapsort(T [] DataSorted){
		CreateHeap(DataSorted);		//Create heap ������
		sinkSort(DataSorted);		//sink sort �³�����
	}
	
	public void CreateHeap(T [] dataSorted){
		int len = dataSorted.length;
		for(int i = len/2; i >= 1; --i){	//start index is 1 in heap sort �ڶ������У������������ʼ��Ϊ1
			sink(dataSorted, i, len);
		}
	}
	
	public void sinkSort(T [] dataSorted){	
		int len = dataSorted.length;
		for(int i = 1; i <= len; ++i){
			T temp = dataSorted[len-i];
			dataSorted[len-i] = dataSorted[0];
			dataSorted[0] = temp;
			sink(dataSorted, 1, len-i);
		}
	}
	
	public void sink(T [] dataSorted, int index, int len){
		while(2*index <= len){
			int trueIndex = index-1;	//map to the true array where start index is 0 ӳ�䵽��ʵ�����У���ʵ�������ʼ�������ֵΪ0
			int leftChild = 2*index-1;	//left child's index in the true array	���ӽڵ�����ʵ�����е�����ֵ
			int rightChild = 2*index;	//right child's index in the true array	�Һ��ӽڵ�����ʵ�����е�����ֵ
			int maxIndex = (rightChild == len) ? leftChild : 	//find the maximize value between left child and right child �����Ӻ��Һ��ӽڵ�֮���ҵ�ֵ�����Ǹ����ӽڵ�
				((dataSorted[leftChild].compareTo(dataSorted[rightChild]) > 0) ? leftChild:rightChild);
			if(dataSorted[trueIndex].compareTo(dataSorted[maxIndex]) < 0){	//delete maximize element and put it into the array position vacated as the heap shrinks.ɾ�����Ԫ�أ�Ȼ����ŵ�����С��ճ���λ��
				T temp = dataSorted[trueIndex];
				dataSorted[trueIndex] = dataSorted[maxIndex];
				dataSorted[maxIndex] = temp;
				index = maxIndex+1;
			}
			else
				break;
		}
	}
	
	public static void main(String args[]){
		HeapSort h = new HeapSort();
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
				h.Heapsort(sortedData);	//sort data �����ݽ�������
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
