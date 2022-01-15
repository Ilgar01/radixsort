package az.tasks;

import java.util.Arrays;

public class RadixSort {
    int counter=0;
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
            counter++;
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;
           counter++;

        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;
           counter++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
            counter++;

        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
            counter++;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
            counter++;
    }

    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
               counter++;
        return max;
    }
    void radixSort(int array[], int size) {
        // Get maximum element
        int max = getMax(array, size);
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
    }

    public static void main(String args[]) {
        int[] data = { 3453, 4321, 8956, 0, 12345, 3210, 98,567,103 };
        System.out.println(Arrays.toString(data));
        int size = data.length;
        RadixSort rs = new RadixSort();
        rs.radixSort(data, size);
        System.out.println(Arrays.toString(data));
        System.out.println(rs.counter);
    }
}