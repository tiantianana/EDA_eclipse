
public class DivideYVenceras {

	public static int searchBinary(int A[], int start, int end, int x) {
		if (start > end || start < A.length) {
			System.out.println("Error");
			return -1;
		}

		int m = (start + end) / 2;
		if (A[m] == x)
			return m;
		else if (A[m] < x)
			return searchBinary(A, m + 1, end, x);
		else
			return searchBinary(A, start, m - 1, x);
	}

	public static int findMax(int[] vector, int i, int j) {
		int mid, max_left, max_right;
		if (i == j)
			return vector[i];
		else {
			mid = (i + j) / 2;
			max_left = findMax(vector, i, mid);
			max_right = findMax(vector, mid + 1, j);
		}
		if (max_left > max_right)
			return max_left;
		else
			return max_right;
	}

	public static int[] mergesort(int a[]) {
		if (a == null) {
			return null;
		}
		return mergesort(a, 0, a.length - 1);
	}

	public static int[] mergesort(int a[], int start, int end) {
		if (start == end)
			return new int[] { a[start] };
		int middle = (start + end) / 2;
		int[] m1 = mergesort(a, start, middle);
		int[] m2 = mergesort(a, middle + 1, end);
		int m[] = merge(m1, m2);
		return m;
	}

	public static int[] merge(int a[], int b[]) {
		if (a == null || b == null) {
			System.out.println("arrays cant be null");
			return null;
		}
		int m[] = new int[a.length + b.length];
		int k = 0;
		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				m[k] = a[i];
				i++;
			} else {
				m[k] = b[i];
				j++;
			}
			k++;
		}

		while (i < a.length) {
			m[k] = a[i];
			i++;
			k++;
		}

		while (j < b.length) {
			m[k] = b[j];
			j++;
			k++;
		}

		return m;
	}

	public static void doPartition(int a[], int start, int end) {
		if (a == null) {
			return;
		}

		if (start >= end)
			return;
		int middle = start + (end - start) / 2;
		int pivote = a[middle];
		int i = start;
		int j = end;

		while (i <= j) {
			while (a[i] < pivote)
				i++;
			while (a[j] > pivote)
				j++;

			if (i <= j) {
				int x = a[i];
				a[i] = a[j];
				a[j] = x;
				i++;
				j--;
			}
		}

		if (start < j)
			doPartition(a, start, j);
		if (i < end)
			doPartition(a, i, end);
	}
}
