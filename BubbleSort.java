package example;

import java.util.Arrays;

public class BubbleSort {
	/**
	 * 基本版的冒泡排序
	 * 
	 */
	public static int[] bubbleSort_1(int[] arr) {
		int temp = 0;// 存储临时变量
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {// 从小到大排列
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
		return arr;

	}

	/**
	 * 如果我们能判断出剩下待轮转的数列已经有序，并且做出标记，剩下的几轮排序就可以不必执行，提早结束工作。
	 * 第二版的冒泡排序：升级1
	 * ru
	 */
	public static int[] bubbleSort_2(int[] arr) {
		int temp = 0;// 存储临时变量
		for (int i = 0; i < arr.length; i++) {

			// 有序标记，每一轮的初始是true
			boolean isStored = true;

			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {// 从小到大排列
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					// 有元素交换，所以不是有序，标记为false
					isStored = false;
				}
			}

			if (isStored) {
				break;
			}
		}
		return arr;

	}

	/**
	 * 如果后面的几个数列都是有序的，就没有必要在每次轮转的时候都要参与比较
	 * 第三版的冒泡排序：升级2
	 */
	public static int[] bubbleSort_3(int[] arr) {
		int temp = 0;// 存储临时变量

		// 记录最后一次交换的位置
		int lastExchangeIndex = 0;
		// 无序数列的边界，每次比较只需要比到这里为止
		int sortBorder = arr.length - 1;

		for (int i = 0; i < arr.length; i++) {
			// 有序标记，每一轮的初始是true
			boolean isStored = true;

			for (int j = 0; j < sortBorder; j++) {
				if (arr[j] > arr[j + 1]) {// 从小到大排列
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					// 有元素交换，所以不是有序，标记为false
					isStored = false;

					// 把无序数列的边界更新为最后一次交换元素的位置
					lastExchangeIndex = j;
				}
			}

			sortBorder = lastExchangeIndex;
			if (isStored) {
				break;
			}
		}
		return arr;

	}

	public static void main(String[] args) throws Exception {
		int[] arr = { 3, 4, 2, 1, 5, 6, 7, 8 };
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(bubbleSort_3(arr)));

	}
}
