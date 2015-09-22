import java.util.Arrays;

/**
 * Created by user on 9/18/15.
 */
public class Main {
    public static void main(String[] args) {
        int[] array_1 = {1, 5, 4, 23, 65, 32, 78};
        int[] array_2 = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        int[] union = leftUnion(array_1, array_2);

        System.out.println(Arrays.toString(union));

    }

    static public int[] leftUnion(int[] leftArray, int[] rightArray){
        int[] arrayTemp;
        int[] arrayResult;

        int length_left_arr = leftArray.length;
        int length_right_arr = rightArray.length;

        arrayTemp = new int[length_left_arr + length_right_arr];

        for(int i = 0; i < length_left_arr; i++) {
            arrayTemp[i] = leftArray[i];
        }

        int count = length_left_arr;

        for(int i = 0; i < length_right_arr; i++ ) {
            for (int j = 0; j < length_left_arr; j++) {
                if (rightArray[i] == leftArray[j]) {
                    arrayTemp[count] = leftArray[j];
                    count++;
                }
            }
        }

        arrayResult = new int[count];

        for(int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = arrayTemp[i];
        }

        return arrayResult;
    }
}
