package sequence;

import java.util.Comparator;
@SuppressWarnings(value="all")

public class merge {
	//�ȽϽ�С��ֵ
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	//�����±�
	private static void exch(Comparable[] a, int i,int j) {
		Comparable t = a[i];
		a[i]=a[j];
		a[j]=t;
	}
	//��ӡ����
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}
	}
	//�����Ƿ�����
	private static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	//ԭ�ع鲢(δ����)  ������������ ���ö���ռ�
	public static void merge1(Comparable[] a,int low,int mid, int high) {
		//��a��low��-a��mid����a��mid+1��-a��high���鲢   
		int i=low;
		int j=mid+1;
		//��a�������Ƶ�aux����
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
	
	private static Comparable[] aux;//��������
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
