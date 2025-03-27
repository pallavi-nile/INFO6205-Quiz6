import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

    private QuickSort() { }

    public static void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a)); // prevents worst-case
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo + 1;
        int j = hi;

        while (true) {
            while (i <= hi && less(a[i], pivot)) i++;
            while (j > lo && less(pivot, a[j])) j--;

            if (i >= j) break;

            exch(a, i, j);
            i++;
            j--;
        }

        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private static void show(Comparable[] a) {
        for (Comparable item : a)
            System.out.println(item);
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter strings separated by spaces:");
        String[] a = scanner.nextLine().split("\\s+");
        scanner.close();
        QuickSort.sort(a);
        show(a);
    }
}