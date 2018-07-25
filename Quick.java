package sequence;

/**
 * 快速排序是归并排序的补充
 * 使用切点将数组切分，使得切点左边的都比切点小，右边的都比切点大
 * 然后对左右排序，得到的数组为有序数组
 * @author wangc
 *
 */

@SuppressWarnings(value = "all")
public class Quick {
	// 切分
	private static int partition(Comparable[] a, int low, int high) {
		// 将数组切分为a【low...i-1】，a【i】，a【i+1...high】
		int i = low, j = high + 1;// 左右扫描指针
		Comparable v = low;// 所使用的切分元素为第一个元素
		while (i != low || j != high) {// 判断是否扫描完成
			while (less(a[++i], v)) // 从左到右扫描，找到比v小的数
				while (less(v, a[--j]))// 从右到左扫描，找比v大的数
					exch(a, i, j);// 交换这两个数
		}
		exch(a, low, j);// 将切分元素v插入j位置，
		return j;
	}

	private static void sort(Comparable[] a, int low, int high) {
		if (high < low) {
			return;
		}
		int j = partition(a, low, high);// 切分
		sort(a, low, j - 1);//对左边进行排序
		sort(a, j + 1, high);//对右边进行排序
	}

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	// 比较较小的值
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// 交换下标
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// 打印数组
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}

	// 测试是否有序
	private static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
