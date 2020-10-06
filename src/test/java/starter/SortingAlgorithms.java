package starter;

public class SortingAlgorithms {

    static int[] bubbleSort(int[] arrayToSort) {
        int length = arrayToSort.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int tmp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = tmp;
                }
            }
        }
        return arrayToSort;
    }

    private static void selectionSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
           int min = i;
            for (int j = 0; j < length; j++) {
                if (numbers[j] < numbers[i]) {
                    min = numbers[j];
                }
            }

        }
    }

    class Solution {
        public String reverseString(char[] s) {
            StringBuilder a = new StringBuilder();

            for (int i = s.length; i > 0; i--) {
                a.append(s[i]);
            }
            return a.toString();
        }

    }

    static int[] seqlectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        bubbleSort(numbers);
        selectionSort(numbers);
    }
}
