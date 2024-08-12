/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.widget;

private static class TimeCycleSplineSet.Sort {
    private TimeCycleSplineSet.Sort() {
    }

    static void doubleQuickSort(int[] nArray, float[][] fArray, int n, int n2) {
        int[] nArray2 = new int[nArray.length + 10];
        nArray2[0] = n2;
        nArray2[1] = n;
        n = 2;
        while (n > 0) {
            int n3 = nArray2[--n];
            n2 = n - 1;
            int n4 = nArray2[n2];
            n = n2;
            if (n3 >= n4) continue;
            int n5 = TimeCycleSplineSet.Sort.partition(nArray, fArray, n3, n4);
            n = n2 + 1;
            nArray2[n2] = n5 - 1;
            n2 = n + 1;
            nArray2[n] = n3;
            n3 = n2 + 1;
            nArray2[n2] = n4;
            n = n3 + 1;
            nArray2[n3] = n5 + 1;
        }
    }

    private static int partition(int[] nArray, float[][] fArray, int n, int n2) {
        int n3 = nArray[n2];
        int n4 = n;
        while (true) {
            if (n >= n2) {
                TimeCycleSplineSet.Sort.swap(nArray, fArray, n4, n2);
                return n4;
            }
            int n5 = n4;
            if (nArray[n] <= n3) {
                TimeCycleSplineSet.Sort.swap(nArray, fArray, n4, n);
                n5 = n4 + 1;
            }
            ++n;
            n4 = n5;
        }
    }

    private static void swap(int[] objectArray, float[][] fArray, int n, int n2) {
        int n3 = objectArray[n];
        objectArray[n] = objectArray[n2];
        objectArray[n2] = n3;
        objectArray = fArray[n];
        fArray[n] = fArray[n2];
        fArray[n2] = objectArray;
    }
}
