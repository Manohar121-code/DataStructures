package array;

import java.util.Scanner;

public class SpirallyTraversingMatrix {
	public static void main(String[] args) {
		SpirallyTraversingMatrix obj = new SpirallyTraversingMatrix();
//		int[][] arr = { {1,2,3,4,5}, {16,17,18,19,6}, {15,24,25,20,7}, {14,23,22,21,8}, {13,12,11,10,9} };
//		int[][] arr = { {1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7} };
//		int[][] arr = { {1,2,3,4,5,6}, {14,15,16,17,18,7}, {13,12,11,10,9,8} };
//		int[][] arr = { {1,2,3}, {12,13,4}, {11,14,5}, {10,15,6}, {9,8,7} };
		int[][] arr = { {1,2}, {12,13}, {11,14}, {10,15}, {9,8}, {91,92} };
		long startTime = System.nanoTime();
		// obj.doOperation(arr, arr.length, subArraySize);
//		obj.doOperation4SquareMatrix(arr, arr.length);
		obj.doOperation4RectangleMatrix(arr, 6, 2);
		long endTime = System.nanoTime();
		System.out.println("\nTime taken " + (endTime - startTime));
		
		System.out.println("-------------------------------");
		spiralPrintGFGAnswer(6, 2, arr);
		System.out.println("-------------------------------");
		
		// for GFG
		/*Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		for (int i = 1; i <= n; i++) {
			int[][] arr = new int[4][4];
			for (int x = 0; x < 4 ; x++) {
				for (int y = 0; y < 4; y++) {
					arr[x][y] = scr.nextInt();
				}
			}
			obj.doOperation4RectangleMatrix(arr, 4, 4);
		}*/
	}
	
//	1,2,3,4
//	12,13,14,5
//	11,16,15,6
//	10,9,8,7
	
//	1,2,3,4,5
//	16,17,18,19,6
//	15,24,25,20,7
//	14,23,22,21,8
//	13,12,11,10,9
	
	private void doOperation4SquareMatrix(int[][] arr, int length) {
		for (int i = 0; i < (length+1)/2; i++) {
			int bottomRightCorner = (length-1)-i;
			for (int j = i; j < length-i && i != bottomRightCorner ; j++) {
				System.out.print(arr[i][j]+" ");
			}
			for (int j = i+1; j < bottomRightCorner; j++) {
				System.out.print(arr[j][bottomRightCorner]+" ");
			}
			for (int j = bottomRightCorner; j >= i; j--) {
				System.out.print(arr[bottomRightCorner][j]+" ");
			}
			for (int j = bottomRightCorner-1; j > i; j--) {
				System.out.print(arr[j][i]+" ");
			}
		}
	}
	
//	1,2,3,4,5,6
//	14,15,16,17,18,7
//	13,12,11,10,9,8

//	1,2,3
//	12,13,4
//	11,14,5
//	10,15,6
//	9,8,7
//	91,92,93
	private void doOperation4RectangleMatrix(int[][] arr, int rows, int cols) {
		StringBuilder sbl = new StringBuilder();
		int mainLoop = (Math.min(rows, cols)+1)/2;
		for (int i = 0; i < mainLoop; i++) {
			int lastRow = (rows-1)-i;
			int lastColumn = (cols-1)-i;
			for (int j = i; j < cols-i; j++) {
//				System.out.print(arr[i][j]+" ");
				sbl.append(arr[i][j]+" ");
			}
			for (int j = i+1; j < lastRow; j++) {
//				System.out.print(arr[j][lastColumn]+" ");
				sbl.append(arr[j][lastColumn]+" ");
			}
			for (int j = lastColumn; i != lastRow && j >= i; j--) {
//				System.out.print(arr[lastRow][j]+" ");
				sbl.append(arr[lastRow][j]+" ");
			}
			for (int j = lastRow-1; i != lastColumn && j > i; j--) {
//				System.out.print(arr[j][i]+" ");
				sbl.append(arr[j][i]+" ");
			}
		}
		sbl.deleteCharAt(sbl.length()-1);
		System.out.println(sbl.toString());
	}
	
	// Function print matrix in spiral form
    static void spiralPrintGFGAnswer(int m, int n, int a[][])
    {
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
          
        while (k < m && l < n)
        {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i)
            {
                System.out.print(a[k][i]+" ");
            }
            k++;
  
            // Print the last column from the remaining columns 
            for (i = k; i < m; ++i)
            {
                System.out.print(a[i][n-1]+" ");
            }
            n--;
  
            // Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    System.out.print(a[m-1][i]+" ");
                }
                m--;
            }
  
            // Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.print(a[i][l]+" ");
                }
                l++;    
            }        
        }
    }
    
}
