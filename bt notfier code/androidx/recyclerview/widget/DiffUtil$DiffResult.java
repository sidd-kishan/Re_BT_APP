/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AdapterListUpdateCallback
 *  androidx.recyclerview.widget.BatchingListUpdateCallback
 *  androidx.recyclerview.widget.DiffUtil$Callback
 *  androidx.recyclerview.widget.DiffUtil$Diagonal
 *  androidx.recyclerview.widget.DiffUtil$PostponedUpdate
 *  androidx.recyclerview.widget.ListUpdateCallback
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public static class DiffUtil.DiffResult {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_MASK = 15;
    private static final int FLAG_MOVED = 12;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 4;
    public static final int NO_POSITION = -1;
    private final DiffUtil.Callback mCallback;
    private final boolean mDetectMoves;
    private final List<DiffUtil.Diagonal> mDiagonals;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;

    DiffUtil.DiffResult(DiffUtil.Callback callback, List<DiffUtil.Diagonal> list, int[] nArray, int[] nArray2, boolean bl) {
        this.mDiagonals = list;
        this.mOldItemStatuses = nArray;
        this.mNewItemStatuses = nArray2;
        Arrays.fill(nArray, 0);
        Arrays.fill(this.mNewItemStatuses, 0);
        this.mCallback = callback;
        this.mOldListSize = callback.getOldListSize();
        this.mNewListSize = callback.getNewListSize();
        this.mDetectMoves = bl;
        this.addEdgeDiagonals();
        this.findMatchingItems();
    }

    private void addEdgeDiagonals() {
        DiffUtil.Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
        if (diagonal == null || diagonal.x != 0 || diagonal.y != 0) {
            this.mDiagonals.add(0, new DiffUtil.Diagonal(0, 0, 0));
        }
        this.mDiagonals.add(new DiffUtil.Diagonal(this.mOldListSize, this.mNewListSize, 0));
    }

    private void findMatchingAddition(int n) {
        int n2;
        int n3;
        block3: {
            int n4 = this.mDiagonals.size();
            n3 = 0;
            n2 = 0;
            while (n3 < n4) {
                DiffUtil.Diagonal diagonal = this.mDiagonals.get(n3);
                while (n2 < diagonal.y) {
                    if (this.mNewItemStatuses[n2] == 0 && this.mCallback.areItemsTheSame(n, n2)) {
                        n3 = this.mCallback.areContentsTheSame(n, n2) ? 8 : 4;
                        break block3;
                    }
                    ++n2;
                }
                n2 = diagonal.endY();
                ++n3;
            }
            return;
        }
        this.mOldItemStatuses[n] = n2 << 4 | n3;
        this.mNewItemStatuses[n2] = n << 4 | n3;
    }

    private void findMatchingItems() {
        Iterator<DiffUtil.Diagonal> iterator = this.mDiagonals.iterator();
        block0: while (true) {
            if (!iterator.hasNext()) {
                if (!this.mDetectMoves) return;
                this.findMoveMatches();
                return;
            }
            DiffUtil.Diagonal diagonal = iterator.next();
            int n = 0;
            while (true) {
                if (n >= diagonal.size) continue block0;
                int n2 = diagonal.x + n;
                int n3 = diagonal.y + n;
                int n4 = this.mCallback.areContentsTheSame(n2, n3) ? 1 : 2;
                this.mOldItemStatuses[n2] = n3 << 4 | n4;
                this.mNewItemStatuses[n3] = n2 << 4 | n4;
                ++n;
            }
            break;
        }
    }

    private void findMoveMatches() {
        Iterator<DiffUtil.Diagonal> iterator = this.mDiagonals.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            DiffUtil.Diagonal diagonal = iterator.next();
            while (n < diagonal.x) {
                if (this.mOldItemStatuses[n] == 0) {
                    this.findMatchingAddition(n);
                }
                ++n;
            }
            n = diagonal.endX();
        }
    }

    private static DiffUtil.PostponedUpdate getPostponedUpdate(Collection<DiffUtil.PostponedUpdate> postponedUpdate, int n, boolean bl) {
        Iterator<DiffUtil.PostponedUpdate> iterator;
        block3: {
            iterator = postponedUpdate.iterator();
            while (iterator.hasNext()) {
                postponedUpdate = iterator.next();
                if (postponedUpdate.posInOwnerList != n || postponedUpdate.removal != bl) continue;
                iterator.remove();
                break block3;
            }
            postponedUpdate = null;
        }
        while (iterator.hasNext()) {
            DiffUtil.PostponedUpdate postponedUpdate2 = iterator.next();
            if (bl) {
                --postponedUpdate2.currentPos;
                continue;
            }
            ++postponedUpdate2.currentPos;
        }
        return postponedUpdate;
    }

    public int convertNewPositionToOld(int n) {
        if (n >= 0 && n < this.mNewListSize) {
            if (((n = this.mNewItemStatuses[n]) & 0xF) != 0) return n >> 4;
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index out of bounds - passed position = ");
        stringBuilder.append(n);
        stringBuilder.append(", new list size = ");
        stringBuilder.append(this.mNewListSize);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int convertOldPositionToNew(int n) {
        if (n >= 0 && n < this.mOldListSize) {
            if (((n = this.mOldItemStatuses[n]) & 0xF) != 0) return n >> 4;
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index out of bounds - passed position = ");
        stringBuilder.append(n);
        stringBuilder.append(", old list size = ");
        stringBuilder.append(this.mOldListSize);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
        listUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback)listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
        int n = this.mOldListSize;
        ArrayDeque<DiffUtil.PostponedUpdate> arrayDeque = new ArrayDeque<DiffUtil.PostponedUpdate>();
        int n2 = this.mOldListSize;
        int n3 = this.mNewListSize;
        int n4 = this.mDiagonals.size() - 1;
        while (true) {
            DiffUtil.PostponedUpdate postponedUpdate;
            int n5;
            if (n4 < 0) {
                listUpdateCallback.dispatchLastEvent();
                return;
            }
            DiffUtil.Diagonal diagonal = this.mDiagonals.get(n4);
            int n6 = diagonal.endX();
            int n7 = diagonal.endY();
            int n8 = n2;
            n2 = n;
            while (true) {
                int n9 = 0;
                n = n2;
                n5 = n3;
                if (n8 <= n6) break;
                n = n8 - 1;
                n9 = this.mOldItemStatuses[n];
                if ((n9 & 0xC) != 0) {
                    int n10 = n9 >> 4;
                    postponedUpdate = DiffUtil.DiffResult.getPostponedUpdate(arrayDeque, n10, false);
                    if (postponedUpdate != null) {
                        n5 = n2 - postponedUpdate.currentPos - 1;
                        listUpdateCallback.onMoved(n, n5);
                        n8 = n;
                        if ((n9 & 4) == 0) continue;
                        listUpdateCallback.onChanged(n5, 1, this.mCallback.getChangePayload(n, n10));
                        n8 = n;
                        continue;
                    }
                    arrayDeque.add(new DiffUtil.PostponedUpdate(n, n2 - n - 1, true));
                    n8 = n;
                    continue;
                }
                listUpdateCallback.onRemoved(n, 1);
                --n2;
                n8 = n;
            }
            while (n5 > n7) {
                n3 = n5 - 1;
                n2 = this.mNewItemStatuses[n3];
                if ((n2 & 0xC) != 0) {
                    n6 = n2 >> 4;
                    postponedUpdate = DiffUtil.DiffResult.getPostponedUpdate(arrayDeque, n6, true);
                    if (postponedUpdate == null) {
                        arrayDeque.add(new DiffUtil.PostponedUpdate(n3, n - n8, false));
                        n5 = n3;
                        continue;
                    }
                    listUpdateCallback.onMoved(n - postponedUpdate.currentPos - 1, n8);
                    n5 = n3;
                    if ((n2 & 4) == 0) continue;
                    listUpdateCallback.onChanged(n8, 1, this.mCallback.getChangePayload(n6, n3));
                    n5 = n3;
                    continue;
                }
                listUpdateCallback.onInserted(n8, 1);
                ++n;
                n5 = n3;
            }
            n8 = diagonal.x;
            n2 = diagonal.y;
            for (n3 = n9; n3 < diagonal.size; ++n8, ++n2, ++n3) {
                if ((this.mOldItemStatuses[n8] & 0xF) != 2) continue;
                listUpdateCallback.onChanged(n8, 1, this.mCallback.getChangePayload(n8, n2));
            }
            n2 = diagonal.x;
            n3 = diagonal.y;
            --n4;
        }
    }

    public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
        this.dispatchUpdatesTo((ListUpdateCallback)new AdapterListUpdateCallback(adapter));
    }
}
