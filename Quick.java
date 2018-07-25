package sequence;

/**
 * ���������ǹ鲢����Ĳ���
 * ʹ���е㽫�����з֣�ʹ���е���ߵĶ����е�С���ұߵĶ����е��
 * Ȼ����������򣬵õ�������Ϊ��������
 * @author wangc
 *
 */

@SuppressWarnings(value = "all")
public class Quick {
	// �з�
	private static int partition(Comparable[] a, int low, int high) {
		// �������з�Ϊa��low...i-1����a��i����a��i+1...high��
		int i = low, j = high + 1;// ����ɨ��ָ��
		Comparable v = low;// ��ʹ�õ��з�Ԫ��Ϊ��һ��Ԫ��
		while (i != low || j != high) {// �ж��Ƿ�ɨ�����
			while (less(a[++i], v)) // ������ɨ�裬�ҵ���vС����
				while (less(v, a[--j]))// ���ҵ���ɨ�裬�ұ�v�����
					exch(a, i, j);// ������������
		}
		exch(a, low, j);// ���з�Ԫ��v����jλ�ã�
		return j;
	}

	private static void sort(Comparable[] a, int low, int high) {
		if (high < low) {
			return;
		}
		int j = partition(a, low, high);// �з�
		sort(a, low, j - 1);//����߽�������
		sort(a, j + 1, high);//���ұ߽�������
	}

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	// �ȽϽ�С��ֵ
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// �����±�
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// ��ӡ����
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

	// �����Ƿ�����
	private static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
