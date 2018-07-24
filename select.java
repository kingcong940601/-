/**
 * 
 * @author Wangc
 *  简单排序算法
 */

@SuppressWarnings(value = { "all" })
public class select {
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
	//选择排序
	public static void sort(Comparable[] a) {
		//将a[]排序
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i+1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min=j;
					exch(a, i, min);
				}
			}
		}
	}
	//插入排序
	public static void sort1(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j>0 && less(a[j],a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	//希尔排序
	
	public static void sort2(Comparable[] a) {
		int n = a.length;
		int h = 1;
		//以步长为3分组
		while(h<n/3) {
			h=h*3+1;
		}
		while(h>=1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j>=h&&less(a[j], a[j-1]); j-=h) {
					exch(a, j, j-h);
				}
				h/=3;
			}
		}
	}
}
