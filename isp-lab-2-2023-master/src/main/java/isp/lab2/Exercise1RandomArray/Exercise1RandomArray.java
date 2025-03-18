package isp.lab2.Exercise1RandomArray;

import java.util.Arrays;
import java.util.Random;
public class Exercise1RandomArray {

    public static int[] getArrayOfRandomNumbers(int n) {
        int[] array = new int[n];
        for(int i=0; i<n; i++) {
            array[i]=new Random().nextInt();
        }
        //TODO: implement the logic to fill the array with random numbers
        return array;

    }

    public static int[] findMaxAndMin(int[] array){
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        return new int[]{min, max};
    }



    public static void main(String[] args) {

        Random random = new Random();

        //genereaza numar random intre 10 si 100
        int size = random.nextInt(91) + 10;
        int[] a = getArrayOfRandomNumbers(size);
        int[] mm = findMaxAndMin(a);
        System.out.println("Min is:"+mm[0]+" Max is:"+mm[1] );
    }
}
