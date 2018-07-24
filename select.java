package sequence;
@SuppressWarnings(value = { "all" })
public class select {
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
	//ѡ������
	public static void sort(Comparable[] a) {
		//��a[]����
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
	//��������
	public static void sort1(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j>0 && less(a[j],a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	//ϣ������
	
	public static void sort2(Comparable[] a) {
		int n = a.length;
		int h = 1;
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
