public class Lab2 {

    public static void main(String[] args) {

        int[] arr1 = { 8, 4, 5, 3, 7, 10 };
        int[][] arr2 = { { 48, 23, 38, 43 }, { 63, 32, 53, 44 }, { 97, 26, 59, 12 } };
        int[] arr3 = { 10, 10, 20, 5, 100, 2 };
        int[][] arr5 = { { 1, 1, 2 }, { 2, 5, 2 }, { 4, 4, 4 }, { 3, 0, 0 } };

        D1FindMax(arr1);
        D2FindMax(arr2);
        System.out.println();

        D1FindMin(arr1);
        D2FindMin(arr2);
        System.out.println();

        D1FindAvg(arr1);
        D2FindAvg(arr2);
        System.out.println();

        D1FindSum(arr1);
        D2FindSum(arr2);
        System.out.println();

        D1FindEven(arr1);
        System.out.print("}");
        D2FindEven(arr2);
        System.out.println("}\n");

        D1FindOdd(arr1);
        System.out.print("}");
        D2FindOdd(arr2);
        System.out.println("}\n");

        D1FindSquare(arr1);
        System.out.println();
        D2FindSquare(arr2);
        System.out.println();

        SumOfTwo(arr1, arr3);
        System.out.println();
        MultiOfTwo(arr2, arr5);
        System.out.println();

        findMaxSubArray(arr2);
        System.out.println();
        


    }

    public static void D1FindMax(int[] array) {

        int max = array[0];

        for (int row = 0; row < array.length; row++) {
            if (array[row] > max) {
                max = array[row];
            }
        }
        System.out.println("the Max in 1D Array is: " + max);
    }

    public static void D2FindMax(int[][] array) {

        int max = array[0][0];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] > max) {
                    max = array[row][col];
                }
            }
        }
        System.out.println("the Max in 2D Array is: " + max);
    }

    public static void D1FindMin(int[] array) {

        int min = array[0];

        for (int row = 0; row < array.length; row++) {
            if (array[row] < min) {
                min = array[row];
            }
        }
        System.out.println("the Min in 1D Array is: " + min);
    }

    public static void D2FindMin(int[][] array) {

        int min = array[0][0];

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] < min) {
                    min = array[row][col];
                }
            }
        }
        System.out.println("the Max in 2D Array is: " + min);
    }

    public static void D1FindAvg(int[] array) {

        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            sum = sum + array[row];
        }

        double avg = sum / array.length;
        System.out.println("the AVG in 1D Array is: " + avg);
    }

    public static void D2FindAvg(int[][] array) {

        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                sum = sum + array[row][col];
            }
        }

        double avg = sum / (array.length * array[0].length);
        System.out.println("the AVG in 2D Array is: " + avg);
    }

    public static void D1FindSum(int[] array) {

        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            sum = sum + array[row];
        }
        System.out.println("the Sum in 1D Array is: " + sum);
    }

    public static void D2FindSum(int[][] array) {

        int sum = 0;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                sum = sum + array[row][col];
            }
        }
        System.out.println("the Sum in 2D Array is: " + sum);
    }

    public static void D1FindEven(int[] array) {

        System.out.print("the Even num in 1D Array is: { ");
        for (int row = 0; row < array.length; row++) {
            if (array[row] % 2 == 0) {
                System.out.print(array[row] + " ");
            }
        }
    }

    public static void D2FindEven(int[][] array) {

        System.out.print("the Even num in 2D Array is: { ");
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] % 2 == 0) {
                    System.out.print(array[row][col] + " ");
                }
            }
        }
    }

    public static void D1FindOdd(int[] array) {

        System.out.print("the Odd num in 1D Array is: { ");
        for (int row = 0; row < array.length; row++) {
            if (array[row] % 2 != 0) {
                System.out.print(array[row] + " ");
            }
        }
    }

    public static void D2FindOdd(int[][] array) {

        System.out.print("the Odd num in 2D Array is: { ");
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] % 2 != 0) {
                    System.out.print(array[row][col] + " ");
                }
            }
        }
    }

    public static void D1FindSquare(int[] array) {

        int square;

        for (int row = 0; row < array.length; row++) {
            square = array[row] * array[row];
            System.out.println("in D1 array the square for " + array[row] + " is: " + square);
        }
    }

    public static void D2FindSquare(int[][] array) {

        int square;

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                square = array[row][col] * array[row][col];
                System.out.println("in D2 array the square for " + array[row][col] + " is: " + square);
            }
        }
    }

    public static void SumOfTwo(int[] array1, int[] array2) {

        int[] array3 = new int[array1.length];

        System.out.print("the sum for the two arrays is: { ");
        for (int row = 0; row < array1.length; row++) {
            array3[row] = array1[row] + array2[row];
            System.out.print(array3[row] + " ");
        }
        System.out.println("}");

    }

    public static void MultiOfTwo(int[][] array1, int[][] array2) {

        int[][] array3 = new int[array1.length][array2[0].length];

        System.out.print("the miltiplication for the two arrays is: {{ ");
        for (int row = 0; row < array1.length; row++) {
            for (int col = 0; col < array2[0].length; col++) {
                for (int i = 0; i < array1[0].length; i++) {
                    array3[row][col] = array3[row][col] + array1[row][i] * array2[i][col];
                }
                System.out.print(array3[row][col]);
                if (col < array2[0].length - 1) {
                    System.out.print(", ");
                }

            }
            if (row < array1.length - 1) {
                System.out.print("}, {");
            }
        }
        System.out.println("}}");
    }

    public static void findMaxSubArray(int[][] array) {
        int maxSum = array[0][0];
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                for (int k = i; k < array.length; k++) {
                    for (int l = j; l < array[0].length; l++) {
                        int sum = 0;
                        for (int x = i; x <= k; x++) {
                            for (int y = j; y <= l; y++) {
                                sum += array[x][y];
                            }
                        }
                        if (sum > maxSum) {
                            startRow = i;
                            startCol = j;
                            endRow = k;
                            endCol = l;
                            maxSum = sum;
                        }
                    }
                }
            }
        }
        System.out.println("[" + startRow + "," + startCol + "]--->" + "[" + endRow + "," + endCol + "]");
        System.out.println("The maximum subarray sum is " + maxSum);
    }

}
