import java.util.Arrays;

/**
 * Created by user on 9/18/15.
 */
public class Main {

    public static void main(String[] args) {

        MyArraysUtil arraysUtil = new MyArraysUtil();

        int[] result;

        result = arraysUtil.leftUnion(arraysUtil.getArray_1(), arraysUtil.getArray_2());
        System.out.println(Arrays.toString(result));

        result = arraysUtil.merge(arraysUtil.getArray_1(), arraysUtil.getArray_2());
        System.out.println(Arrays.toString(result));
    }


}


