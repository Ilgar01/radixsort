package az.tasks;

import java.util.Arrays;

public class RadixSort {
    int counter=0;
    void countingSort(int array[], int place) {
        int[] output = new int[array.length + 1];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            counter++;
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;
           counter++;

        for (int i = 0; i < array.length; i++)
            count[(array[i] / place) % 10]++;
           counter++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
            counter++;

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
            counter++;
        }

        for (int i = 0; i < array.length; i++)
            array[i] = output[i];
            counter++;
    }

    int getMax(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
               counter++;
        return max;
    }
    void radixSort(int array[]) {
        int max = getMax(array);
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, place);
    }

    public static void main(String args[]) {
        int[] data = { 3453, 4321, 8956, 0, 12345, 3210, 98,567,103 };
        System.out.println(Arrays.toString(data));
        int size = data.length;
        RadixSort rs = new RadixSort();
        rs.radixSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println(rs.counter);
    }
}
