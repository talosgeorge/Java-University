package isp.lab2.Exercise5EvenOddSearch;

public class Exercise5EvenOddSearch {

    public static int[] findEvenOdd(String input) {
        String[] numberStr = input.split(",");
        int[] numbers = new int[numberStr.length];
        for(int i=0; i<numberStr.length; i++){
            numbers[i] = Integer.parseInt(numberStr[i]);
        }
        //int i= Integer.parseInt("1");
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int maxEvenIndex = -1;
        int minOddIndex = -1;
        for(int i = 0; i< numbers.length; i++){
            int num= numbers[i];
            if(num%2==0 && num > maxEven){
                maxEven=num;
                maxEvenIndex=i;
            } else if (num % 2 != 0 && num < minOdd) {
                minOdd = num;
                minOddIndex = i;
            }
        }
        if (maxEvenIndex == -1) {
            System.out.println("Nu exista numere pare in lista.");
        } else {
            System.out.println("Cel mai mare numar par: " + maxEven + " ocupa pozitia " + (maxEvenIndex + 1));
        }
        if (minOddIndex == -1) {
            System.out.println("Nu exista numere impare in lista.");
        } else {
            System.out.println("Cel mai mic numar impar " + minOdd + " ocupa pozitia " + (minOddIndex + 1));
        }
        return new int[]{maxEven, maxEvenIndex, minOdd, minOddIndex};
    }

    public static void main(String[] args) {
        String input = "1,2,3,4,5,6,7,8,9,10";
        findEvenOdd(input);
    }
}
