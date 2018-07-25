package sequence;

import java.util.Comparator;
@SuppressWarnings(value="all")

public class merge {
	//比较较小的值
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	//交换下标
	private static void exch(Comparable[] a, int i,int j) {
		Comparable t = a[i];
		a[i]=a[j];
		a[j]=t;
	}
	//打印数组
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}
	}
	//测试是否有序
	private static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	//原地归并(未排序)  创建辅助数组 利用额外空间
	public static void merge1(Comparable[] a,int low,int mid, int high) {
		//将a【low】-a【mid】和a【mid+1】-a【high】归并   
		int i=low;
		int j=mid+1;
		//将a【】复制到aux【】
		for(int k = low; k<=high;k++) {
			aux[k]=a[k];
		}
		for(int k=low;k<=high;k++) {
			if (i>mid) {
				a[k]=aux[j++];
			}
			else if (j>high) {
				a[k]=aux[i++];
			}
			else if (less(aux[j],aux[i])) {
				a[k]=aux[j++];
			}
			else {
				a[k]=aux[i++];
			}
		}
	}
	
	private static Comparable[] aux;//辅助数组
	private static void sort(Comparable[] a,int low,int high) {
		if (high<=low)  return;
		int mid = low+(high-low)/2;
		sort(a, low, mid);
		sort(a, mid+1, high);
		merge1(a, low, mid, high);
	}
	
	public static void sort(Comparable[] a) {
		aux=new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
}
