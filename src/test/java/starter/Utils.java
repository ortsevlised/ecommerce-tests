package starter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Utils {
    /**
     * Returns a random value from an Enum
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Enum<?>> T getRandomValueFromEnum(Class<T> clazz) {
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }


    // Complete the sockMerchant function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int countera = 0;
        int counterb = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                ++countera;
            } else if (a.get(i) < b.get(i)) {
                ++counterb;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(countera);
        arrayList.add(counterb);


        return arrayList;

    }

    public static int getFactorial(int n) {
        if (n < 1) {
            throw new RuntimeException("no negative or zero");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return n * getFactorial(n - 1);
    }

    /**
     * Gets the fibonacci sequence at the index passed using recursion
     * Pros: DRY, readability
     * Cons: large stack, low performance O(2^n)
     *
     * @param n index
     * @return fib sequence
     */
    static int getFibonacciRecursive(int n) {
        if (n < 2) return n;
        return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
    }


    /**
     * Fibonacci sequence using an iterative approach
     * Pros: Fair performance O(n)
     * Cons: Readability is not the best.
     *
     * @param n index
     * @return fib sequence
     */
    static int getFibonacciIterative(int n) {
        if (n < 2) {
            return 1;
        }
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }


    /**
     * Reverses a string using an iterative approach
     * O(n)
     *
     * @param text
     * @return
     */
    static String reverseStringIterative(String text) {
        StringBuilder reverse = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse.append(text.charAt(i));
        }
        return reverse.toString();
    }

    /**
     * Another iterative approach to reverse a string
     * Still O(n) but shorter loop
     *
     * @param string
     * @return
     */
    public static String reverseStringIterative2(String string) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < (charArray.length / 2); i++) {
            char temp = charArray[i];
            charArray[i] = charArray[(charArray.length - 1) - i];
            charArray[(charArray.length - 1) - i] = temp;
        }
        return new String(charArray);
    }

    /**
     * Reverses a string using recursion
     * O(n)
     *
     * @param string
     * @return
     */
    public static String reverseStringRecursively(String string) {
        if (string.length() == 0) return "";
        return reverseStringRecursively(string.substring(1))
                + string.charAt(0);
    }

    public static String reverseString(char[] s) {
        StringBuilder a = new StringBuilder();

        for (int i = s.length - 1; i >= 0; i--) {
            a.append(s[i]);
        }
        return a.toString();
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add("Fizz");
                }
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * <p>
     * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int n : nums) {
            if (list.contains(n))
                list.remove(n);
            else list.add(n);
        }
        return list.getFirst();
    }

    public static int reverse(Long x) {
        StringBuilder a = new StringBuilder();
        if (x<0) a.append('-');
        x=Math.abs(x);
        while (x >= 10) {
            a.append(x % 10);
            x = x / 10;
        }
        return Integer.parseInt(a.append(x).toString());
    }


    public static void main(String[] args) {

        reverse(9646324351L);//
        // fizzBuzz(15);
        /*int[] nums = {4, 1, 2, 1, 2};
        singleNumber(nums);
        char[] JavaCharArray = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(reverseString(JavaCharArray));*/
      /*  System.out.println(reverseStringIterative("testing reverse"));
        System.out.println(reverseStringRecursively("testing reverse"));
        System.out.println(getFibonacciRecursive(0));
        System.out.println(getFibonacciIterative(0));
        System.out.println(getFactorial(-5));
        List<Integer> a = Arrays.asList(1, 52, 4);
        List<Integer> b = Arrays.asList(3, 2, 4);
        System.out.println(compareTriplets(a, b));*/
 LinkedList <String> a = new LinkedList<>();
    }


}
