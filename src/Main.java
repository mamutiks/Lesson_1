import java.util.Arrays;

/**
 * Created by user on 9/18/15.
 */
public class Main {
    public static void main(String[] args) {
        int[] array_1 = {1,5,4,23,65,32,78};
        int[] array_2 = {3,5,24,4,1,2,34,45,32,5};
        int[] arrayTemp;
        int[] arrayResult;

        int length_a1 = array_1.length;
        int length_a2 = array_2.length;

        arrayTemp = new int[length_a1 + length_a2];

        for(int i = 0; i < array_1.length; i++) {
            arrayTemp[i] = array_1[i];
        }

        int count = array_1.length;

        for(int i = 0; i < length_a2; i++ ) {
            for (int j = 0; j < length_a1; j++) {
                if (array_2[i] == array_1[j]) {
                    arrayTemp[count] = array_1[j];
                    count++;
                }
            }
        }

        arrayResult = new int[count];

        for(int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = arrayTemp[i];
        }
        System.out.println(Arrays.toString(arrayResult));

    }
}
