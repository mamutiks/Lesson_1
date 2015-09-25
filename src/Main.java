import java.util.Arrays;

/**
 * Created by user on 9/18/15.
 */
public class Main {

    private static final int[] array_1 = {1, 5, 4, 23, 65, 32, 78};
    private static final int[] array_2 = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
    private static final int[] array_3 = {3, 5, 24, 54, 1, 2, 34, 45, 32};

    public static void main(String[] args) {

        MyArraysUtil arraysUtil = new MyArraysUtil();

        int[] resultLeftUnion;
        int[] resultMerge;
        int[] resultInnerUnion;
        int[] resultOuterUnion;

        System.out.println("array_1 = " + Arrays.toString(array_1));
        System.out.println("array_2 = " + Arrays.toString(array_2));
        System.out.println("array_3 = " + Arrays.toString(array_3));

        resultLeftUnion = arraysUtil.leftUnion(array_1, array_2);
        System.out.println("resultLeftUnion = " + Arrays.toString(resultLeftUnion));

        resultMerge = arraysUtil.merge(array_1, array_3);
        System.out.println("resultMerge = " + Arrays.toString(resultMerge));

        resultInnerUnion = arraysUtil.innerUnion(array_1, array_2);
        System.out.println("resultInnerUnion = " + Arrays.toString(resultInnerUnion));

        resultOuterUnion = arraysUtil.outerUnion(array_1, array_2);
        System.out.println("resultOuterUnion = " + Arrays.toString(resultOuterUnion));
    }




}


