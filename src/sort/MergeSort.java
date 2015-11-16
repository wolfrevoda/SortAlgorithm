/* 
 * Author: Wolfrevoda_ba
 * Time: 2015.11.11 16:00
 * Algorithm Describe:
 * Merge sort: to sort an array, divide it into two halves, sort the two halves(recursively),
 * and then merge the results.
 * 
 * ���ߣ���ͼ
 * ʱ�䣺2015.11.11 15:50
 * �㷨������
 * �鲢����Ҫ��һ���������򣬿����ȵݹ�Ľ����ֳ�����ֱ�����Ȼ���ٽ�����鲢����
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
		sort(low, high, sortedData, tempArray);	//sort array ����������
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
			if(i > mid){	//left array done ��ߵ������Ѿ��鲢���ˣ�ʣ���λ�ö����ұ��������
				while(j <= high)
					sortedData[x++] = tempArray.get(j++);
			}
			else if(j > high){	//right array done �ұߵ������Ѿ��鲢���ˣ�ʣ���λ�ö�������������
				while(i <= mid)
					sortedData[x++] = tempArray.get(i++);
			}
			else if(tempArray.get(i).compareTo(tempArray.get(j))<0)	//the element in left array lower than the element in right array ���Ԫ��С���ұ�Ԫ��
				sortedData[x++] = tempArray.get(i++);
			else	//the element in left array higher than the element in right array ��������ӦԪ�ش����ұ������ӦԪ��
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
