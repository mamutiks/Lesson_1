/**
 * Created by Сандро on 23.09.2015.
 */
public class MyArraysUtil { // без использования Arrays и массивы не должны содержать нули !!!

    private int[] cuttingArray(int[] smallArray, int[] bigArray) { // удаление нулей в конце
        for (int i = 0; i < smallArray.length; i++) smallArray[i] = bigArray[i];
        return smallArray;
    }

    private int[] cloneArray(int[] array){

        int length = array.length;
        int[] resultArray = new int[length];

        for (int i = 0; i < length; i++) resultArray[i] = array[i];

        return resultArray;
    }

    private int[] bubbleSort(int[] array) {

        int[] arrayResult = cloneArray(array);

        int temp;

        for (int i = 1; i < arrayResult.length; i++) {
            for (int j = arrayResult.length - 1; j >= i; j--)
                if (arrayResult[j - 1] > arrayResult[j]) {
                    temp = arrayResult[j - 1];
                    arrayResult[j - 1] = arrayResult[j];
                    arrayResult[j] = temp;
                }
        }

        return arrayResult;
    }

    private int[] dublicateKill(int[] array) {

        int count = 0;
        int[] arrayResult = new int[array.length];
        int[] arrayTemp;
        arrayTemp = cloneArray(array);

        for (int i = 0; i < arrayTemp.length; i++) {

            boolean flag = false; // нет дубликата

            for (int j = 0; j < arrayResult.length; j++){ // проверка на дубликаты
                if (arrayTemp[i] == arrayResult[j]) {
                    flag = true;
                    break;
                }
            }

            if (flag){
                flag = false;
                continue;
            } else {
                arrayResult[count] = arrayTemp[i];
                count++;
            }
        }

        int[] newResult = new int[count];

        return cuttingArray(newResult, arrayResult);
    }

    private int[] dublicateKillWithOriginal(int[] array) {

        int count = 0;
        int[] arrayResult = new int[array.length];
        int[] arrayTemp = cloneArray(array);
        int pos = 0;
        int n = 0;

        for (int i = 0; i < arrayTemp.length; i++) {

            //if (arrayTemp[i] == arrayTemp[i+1]) {

                while (arrayTemp[pos] == arrayTemp[pos+1]) {
                    pos++;
                    n++;
                }
                i = pos + n;

            //}

            arrayResult[count] = arrayTemp[i];
            count++;

        }





        int[] newArrayResult = new int[count];

        return cuttingArray(newArrayResult, arrayResult);
    }

    public int[] leftUnion(int[] leftArray, int[] rightArray){
        int[] arrayTemp;
        int[] arrayResult;

        arrayTemp = new int[leftArray.length + rightArray.length];

        for (int i = 0; i < leftArray.length; i++) {
            arrayTemp[i] = leftArray[i];
        }

        int count = leftArray.length;

        for (int i = 0; i < rightArray.length; i++) {
            for (int j = 0; j < leftArray.length; j++) {
                if (rightArray[i] == leftArray[j]) {
                    arrayTemp[count] = leftArray[j];
                    count++;
                }
            }
        }

        arrayResult = new int[count];

        cuttingArray(arrayResult, arrayTemp);

        return arrayResult;
    }

    public int[] merge(int[] leftArray, int[] rightArray){ // без дубликатов
        int[] arrayTemp;
        int[] arrayResult;

        arrayTemp = new int[leftArray.length + rightArray.length];

        for (int i = 0; i < leftArray.length; i++) {
            arrayTemp[i] = leftArray[i];
        }

        int count = leftArray.length;

        for (int i = 0; i < rightArray.length; i++) {
            for (int j = 0; j < leftArray.length; j++) {
                if (rightArray[i] == leftArray[j]) {
                    break;
                } else {
                    if ((rightArray[i] != leftArray[j]) && (j == (leftArray.length - 1))) {
                        arrayTemp[count] = rightArray[i];
                        count++;
                    }
                }
            }
        }

        arrayResult = new int[count];

        cuttingArray(arrayResult, arrayTemp);

        return arrayResult;
    }

    public int[] innerUnion(int[] leftArray, int[] rightArray){ // Объединение общих элементов без дубликатов
        int[] arrayTemp;
        int[] arrayResult;

        arrayTemp = (leftArray.length > rightArray.length) ?  new int[leftArray.length] : new int[rightArray.length];

        int count = 0;

        for (int i = 0; i < rightArray.length; i++) {
            for (int j = 0; j < leftArray.length; j++) {
                if (rightArray[i] == leftArray[j]) {
                    arrayTemp[count] = rightArray[i];
                    count++;
                } else {
                    continue;
                }
            }
        }

        arrayResult = new int[count];
        cuttingArray(arrayResult, arrayTemp);
        return dublicateKill(arrayResult);
    }

    public int[] outerUnion(int[] leftArray, int[] rightArray){ // Вывод разных отличающихся элементов

        int count = 0;
        int[] arrayTemp = new int[leftArray.length + rightArray.length];

        for (int i = 0; i < leftArray.length; i++) {
            arrayTemp[i] = leftArray[i];
        }

        for (int j = leftArray.length; j < arrayTemp.length; j++) {
            arrayTemp[j] = rightArray[count];
            count++;
        }

        int[] arrayResult = bubbleSort(arrayTemp);

        return dublicateKillWithOriginal(arrayResult);
    }
}
