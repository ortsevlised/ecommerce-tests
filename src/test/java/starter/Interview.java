package starter;

import java.util.Arrays;

public class Interview {

    public static String revereString(String toReverse) {
        char[] chars = toReverse.toCharArray();
        String reversed = "";
        for (char letter : chars) {
            reversed =letter+reversed ;
        }
    /*    StringBuilder reversed = new StringBuilder();
        for (int i = chars.length-1; i >=0; i--) {
            reversed.append(chars[i]);
        }
        String x = reversed.toString();*/
        System.out.println(reversed);
        return reversed;
    }

    public static int[] reversedArray(int[] array){
        int i=0;
        int j=array.length-1;
        int tmp;
        while (i<j){
            tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(array));

        return array;
    }
    public static void main(String[] args) {
       reversedArray(new int[]{1, 2,5,2,3});
        // revereString("Jorge");
    }
}
