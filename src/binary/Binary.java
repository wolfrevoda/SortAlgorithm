package binary;

import java.util.*;
import java.io.*;

public class Binary {
	//���ֲ��ң���������������
	public static boolean binarySearch(int key, Vector<Integer> a){
		int low = 0;
		int high = a.size() - 1;
		//����ѭ�����Ƶľ�����Ҫ�õݹ飬������ֲ�������ݹ�Ҳ���Ժܺõı��
		//����Ҫע��ѭ������Ϊ<=������<
		while(low <= high){
			int mid = (low+high)/2;
			if(a.get(mid) == key)
				return true;
			else if(key < a.get(mid))
				high = mid-1;
			else
				low = mid + 1;
		}
		
		return false;
	}
	
	//Ϊvector�е�Ԫ������
	public static void sort(int low, int high, Vector<Integer> v){
		int target = v.get(low);
		int start = low;
		int end = high;
		while(start < end){
			while(start < end && v.get(end) > target)
				--end;
			v.set(start, v.get(end));
			while(start < end && v.get(start) < target)
				++start;
			v.set(end, v.get(start));
		}
		v.set(start, target);
		if(start > low)
			sort(low, start-1, v);
		if(start < high)
			sort(start+1, high, v);
	}
	
	public static void main(String[] args){	
		try{
			//�����ļ�����
			FileReader file1 = new FileReader("E:\\workspace\\Algorithm\\src\\tinyW.txt");
			//������Ч����������
			BufferedReader br = new BufferedReader(file1);
			String data;
			Vector v = new Vector();
			while((data = br.readLine()) != null)
				v.add(Integer.parseInt(data));
			sort(0, v.size()-1, v);
			//���������ļ�����
			FileReader file2 = new FileReader("E:\\workspace\\Algorithm\\src\\tinyT.txt");
			BufferedReader br2 = new BufferedReader(file2);
			while((data = br2.readLine()) != null){
				if(!binarySearch(Integer.parseInt(data), v))
					System.out.println(data);
			}
			file1.close();
			file2.close();
			
		}catch (IOException e){
			System.out.println("Exception error!");
			e.printStackTrace();
		}		
	}
}
