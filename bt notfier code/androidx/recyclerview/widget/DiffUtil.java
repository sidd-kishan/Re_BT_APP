/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.DiffUtil$Callback
 *  androidx.recyclerview.widget.DiffUtil$CenteredArray
 *  androidx.recyclerview.widget.DiffUtil$Diagonal
 *  androidx.recyclerview.widget.DiffUtil$DiffResult
 *  androidx.recyclerview.widget.DiffUtil$Range
 *  androidx.recyclerview.widget.DiffUtil$Snake
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new /* Unavailable Anonymous Inner Class!! */;

    private DiffUtil() {
    }

    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int n) {
        int n2;
        boolean bl = (range.oldSize() - range.newSize()) % 2 == 0;
        int n3 = range.oldSize();
        int n4 = range.newSize();
        int n5 = n2 = -n;
        while (n5 <= n) {
            int n6;
            int n7;
            int n8;
            if (n5 != n2 && (n5 == n || centeredArray2.get(n5 + 1) >= centeredArray2.get(n5 - 1))) {
                n8 = centeredArray2.get(n5 - 1);
                n7 = n8 - 1;
            } else {
                n7 = n8 = centeredArray2.get(n5 + 1);
            }
            int n9 = range.newListEnd - (range.oldListEnd - n7 - n5);
            int n10 = n != 0 && n7 == n8 ? n9 + 1 : n9;
            while (n7 > range.oldListStart && n9 > range.newListStart && callback.areItemsTheSame(n7 - 1, n9 - 1)) {
                --n7;
                --n9;
            }
            centeredArray2.set(n5, n7);
            if (bl && (n6 = n3 - n4 - n5) >= n2 && n6 <= n && centeredArray.get(n6) >= n7) {
                range = new Snake();
                range.startX = n7;
                range.startY = n9;
                range.endX = n8;
                range.endY = n10;
                range.reverse = true;
                return range;
            }
            n5 += 2;
        }
        return null;
    }

    public static DiffResult calculateDiff(Callback callback) {
        return DiffUtil.calculateDiff(callback, true);
    }

    public static DiffResult calculateDiff(Callback callback, boolean bl) {
        int n = callback.getOldListSize();
        int n2 = callback.getNewListSize();
        ArrayList<Diagonal> arrayList = new ArrayList<Diagonal>();
        ArrayList<Range> arrayList2 = new ArrayList<Range>();
        arrayList2.add(new Range(0, n, 0, n2));
        n = (n + n2 + 1) / 2 * 2 + 1;
        CenteredArray centeredArray = new CenteredArray(n);
        CenteredArray centeredArray2 = new CenteredArray(n);
        ArrayList<Range> arrayList3 = new ArrayList<Range>();
        while (true) {
            if (arrayList2.isEmpty()) {
                Collections.sort(arrayList, DIAGONAL_COMPARATOR);
                return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), bl);
            }
            Range range = (Range)arrayList2.remove(arrayList2.size() - 1);
            Snake snake = DiffUtil.midPoint(range, callback, centeredArray, centeredArray2);
            if (snake != null) {
                if (snake.diagonalSize() > 0) {
                    arrayList.add(snake.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range)arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = snake.startX;
                range2.newListEnd = snake.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = snake.endX;
                range.newListStart = snake.endY;
                arrayList2.add(range);
                continue;
            }
            arrayList3.add(range);
        }
    }

    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int n) {
        int n2;
        int n3 = Math.abs(range.oldSize() - range.newSize());
        boolean bl = true;
        if (n3 % 2 != 1) {
            bl = false;
        }
        int n4 = range.oldSize();
        int n5 = range.newSize();
        int n6 = n2 = -n;
        while (n6 <= n) {
            int n7;
            int n8;
            if (n6 != n2 && (n6 == n || centeredArray.get(n6 + 1) <= centeredArray.get(n6 - 1))) {
                n8 = centeredArray.get(n6 - 1);
                n3 = n8 + 1;
            } else {
                n3 = n8 = centeredArray.get(n6 + 1);
            }
            int n9 = range.newListStart + (n3 - range.oldListStart) - n6;
            int n10 = n != 0 && n3 == n8 ? n9 - 1 : n9;
            while (n3 < range.oldListEnd && n9 < range.newListEnd && callback.areItemsTheSame(n3, n9)) {
                ++n3;
                ++n9;
            }
            centeredArray.set(n6, n3);
            if (bl && (n7 = n4 - n5 - n6) >= n2 + 1 && n7 <= n - 1 && centeredArray2.get(n7) <= n3) {
                range = new Snake();
                range.startX = n8;
                range.startY = n10;
                range.endX = n3;
                range.endY = n9;
                range.reverse = false;
                return range;
            }
            n6 += 2;
        }
        return null;
    }

    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() < 1) return null;
        if (range.newSize() < 1) {
            return null;
        }
        int n = (range.oldSize() + range.newSize() + 1) / 2;
        centeredArray.set(1, range.oldListStart);
        centeredArray2.set(1, range.oldListEnd);
        int n2 = 0;
        while (n2 < n) {
            Snake snake = DiffUtil.forward(range, callback, centeredArray, centeredArray2, n2);
            if (snake != null) {
                return snake;
            }
            snake = DiffUtil.backward(range, callback, centeredArray, centeredArray2, n2);
            if (snake != null) {
                return snake;
            }
            ++n2;
        }
        return null;
    }
}
