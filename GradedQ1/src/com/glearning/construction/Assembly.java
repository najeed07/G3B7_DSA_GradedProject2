package com.glearning.construction;

import java.util.Scanner;

public class Assembly {
	int front;
	int rear;
	private int maxSize;
	int arr[];
	static Scanner sc = new Scanner(System.in);

	public Assembly() {
		System.out.println("Enter the total number of floors in the building: ");
		maxSize = sc.nextInt();
		front = 0;
		rear = 0;
		arr = new int[maxSize + 1];
	}

	public boolean isFull() {
		if (rear == maxSize - 1) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	public void enqueue() {
		if (!isFull()) {
			for (int i = 1; i <= maxSize; i++) {
				System.out.println("Enter the floor size given on day :" + i);
				int m = sc.nextInt();
				arr[m] = i;
				rear++;
				if (front == 0)
					front = 1;
			}
		}
	}
	
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("underflow");
		} else {
			int j = maxSize;
			boolean status;
			System.out.println("The order of custruction is as follows");
			for (int i = 1; i <= maxSize; i++) {
				status = false;
				System.out.println("Day: " + i + "\n");
				while (j >= 1 && arr[j] <= i) {
					status = true;
					System.out.print(j + " ");
					j--;
				}
				if (status == true) {
					System.out.println();
				}
			}
			if (front == rear) {
				front = 0;
				rear = 0;
			} else {
				front++;
			}
		}
	}
}