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
 * 作者：巴图
 * 时间：2015.11.11 15:50
 * 算法描述：
 * 堆排序可以分为两个阶段：堆的构造阶段和堆的排序阶段。其中，在堆得构造阶段，我们将原始数据重新组织安排进一个堆中，然
 * 后在排序阶段，从堆中按递减顺序取出所有元素并得到排序结果。堆排序的主要工作都是在第二阶段完成的。这里我们将堆中的最
 * 大元素删除，然后放入堆缩小后数组中空出的位置。
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
		CreateHeap(DataSorted);		//Create heap 创建堆
		sinkSort(DataSorted);		//sink sort 下沉排序
	}
	
	public void CreateHeap(T [] dataSorted){
		int len = dataSorted.length;
		for(int i = len/2; i >= 1; --i){	//start index is 1 in heap sort 在堆排序中，数组的索引初始点为1
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
			int trueIndex = index-1;	//map to the true array where start index is 0 映射到真实数组中，真实数组的起始点的索引值为0
			int leftChild = 2*index-1;	//left child's index in the true array	左孩子节点在真实数组中的索引值
			int rightChild = 2*index;	//right child's index in the true array	右孩子节点在真实数组中的索引值
			int maxIndex = (rightChild == len) ? leftChild : 	//find the maximize value between left child and right child 在左孩子和右孩子节点之间找到值最大的那个孩子节点
				((dataSorted[leftChild].compareTo(dataSorted[rightChild]) > 0) ? leftChild:rightChild);
			if(dataSorted[trueIndex].compareTo(dataSorted[maxIndex]) < 0){	//delete maximize element and put it into the array position vacated as the heap shrinks.删除最大元素，然后将其放到堆缩小后空出的位置
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
				while((temp = br.readLine()) != null)		//read file 读取文件
					tempData += temp + " ";
				sortedData = tempData.split(" ");	//split data 分割数据
				for(int k = 0; k < sortedData.length; ++k)	
					System.out.print(sortedData[k] + " ");
				System.out.println();
				h.Heapsort(sortedData);	//sort data 对数据进行排序
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
