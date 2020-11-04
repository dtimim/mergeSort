import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] testArray = new int[]{-43, 89003, 920, -95, -66, 22, 0, 101, -21};
        testArray = mergeSort(testArray);
        for (int i : testArray) {
            System.out.println(i);
        }
    }

    public static int[] mergeSort(int[] array1) {
        int[] sortArr = Arrays.copyOf(array1, array1.length);
        int[] bufferArr = new int[array1.length];
        return recurtionMergeSort(sortArr, bufferArr, 0, array1.length);
    }

    public static int[] recurtionMergeSort(int[] sortArr, int[] bufferArr,
                                           int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return sortArr;
        }


        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] firstSortArr = recurtionMergeSort(sortArr, bufferArr, startIndex, middle);
        int[] secondSortArr = recurtionMergeSort(sortArr, bufferArr, middle, endIndex);


        int firstIndex = startIndex;
        int secondIndex = middle;
        int destIndex = startIndex;
        int[] result = firstSortArr == sortArr ? bufferArr : sortArr;
        while (firstIndex < middle && secondIndex < endIndex) {
            result[destIndex++] = firstSortArr[firstIndex] < secondSortArr[secondIndex]
                    ? firstSortArr[firstIndex++] : secondSortArr[secondIndex++];
        }
        while (firstIndex < middle) {
            result[destIndex++] = firstSortArr[firstIndex++];
        }
        while (secondIndex < endIndex) {
            result[destIndex++] = secondSortArr[secondIndex++];
        }
        return result;
    }
}
