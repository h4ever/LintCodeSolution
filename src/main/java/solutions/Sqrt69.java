package solutions;

public class Sqrt69 {
	public int mySqrt(int x) {
		int left = 1;
		int right = x;
		int mid;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
				return mid;
			} else if (mid > x / mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
