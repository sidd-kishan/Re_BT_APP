/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.SortedList$BatchedCallback
 *  androidx.recyclerview.widget.SortedList$Callback
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.SortedList;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public SortedList(Class<T> clazz, Callback<T> callback) {
        this(clazz, callback, 10);
    }

    public SortedList(Class<T> clazz, Callback<T> callback, int n) {
        this.mTClass = clazz;
        this.mData = (Object[])Array.newInstance(clazz, n);
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t, boolean bl) {
        int n;
        int n2 = this.findIndexOf(t, this.mData, 0, this.mSize, 1);
        if (n2 == -1) {
            n = 0;
        } else {
            n = n2;
            if (n2 < this.mSize) {
                T t2 = this.mData[n2];
                n = n2;
                if (this.mCallback.areItemsTheSame(t2, t)) {
                    if (this.mCallback.areContentsTheSame(t2, t)) {
                        this.mData[n2] = t;
                        return n2;
                    }
                    this.mData[n2] = t;
                    Callback callback = this.mCallback;
                    callback.onChanged(n2, 1, callback.getChangePayload(t2, t));
                    return n2;
                }
            }
        }
        this.addToData(n, t);
        if (!bl) return n;
        this.mCallback.onInserted(n, 1);
        return n;
    }

    private void addAllInternal(T[] TArray) {
        if (TArray.length < 1) {
            return;
        }
        int n = this.sortAndDedup(TArray);
        if (this.mSize == 0) {
            this.mData = TArray;
            this.mSize = n;
            this.mCallback.onInserted(0, n);
        } else {
            this.merge(TArray, n);
        }
    }

    private void addToData(int n, T object) {
        int n2 = this.mSize;
        if (n > n2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("cannot add item to ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" because size is ");
            ((StringBuilder)object).append(this.mSize);
            throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
        }
        Object[] objectArray = this.mData;
        if (n2 == objectArray.length) {
            objectArray = (Object[])Array.newInstance(this.mTClass, objectArray.length + 10);
            System.arraycopy(this.mData, 0, objectArray, 0, n);
            objectArray[n] = object;
            System.arraycopy(this.mData, n, objectArray, n + 1, this.mSize - n);
            this.mData = objectArray;
        } else {
            System.arraycopy(objectArray, n, objectArray, n + 1, n2 - n);
            this.mData[n] = object;
        }
        ++this.mSize;
    }

    private T[] copyArray(T[] TArray) {
        Object[] objectArray = (Object[])Array.newInstance(this.mTClass, TArray.length);
        System.arraycopy(TArray, 0, objectArray, 0, TArray.length);
        return objectArray;
    }

    private int findIndexOf(T t, T[] TArray, int n, int n2, int n3) {
        while (n < n2) {
            int n4 = (n + n2) / 2;
            T t2 = TArray[n4];
            int n5 = this.mCallback.compare(t2, t);
            if (n5 < 0) {
                n = n4 + 1;
                continue;
            }
            if (n5 == 0) {
                if (this.mCallback.areItemsTheSame(t2, t)) {
                    return n4;
                }
                n = this.linearEqualitySearch(t, n4, n, n2);
                if (n3 != 1) return n;
                if (n != -1) return n;
                n = n4;
                return n;
            }
            n2 = n4;
        }
        if (n3 == 1) return n;
        n = -1;
        return n;
    }

    private int findSameItem(T t, T[] TArray, int n, int n2) {
        while (n < n2) {
            if (this.mCallback.areItemsTheSame(TArray[n], t)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private int linearEqualitySearch(T t, int n, int n2, int n3) {
        T t2;
        int n4;
        int n5 = n - 1;
        while (true) {
            n4 = n;
            if (n5 < n2) break;
            t2 = this.mData[n5];
            if (this.mCallback.compare(t2, t) != 0) {
                n4 = n;
                break;
            }
            if (this.mCallback.areItemsTheSame(t2, t)) {
                return n5;
            }
            --n5;
        }
        do {
            if ((n = n4 + 1) >= n3) return -1;
            t2 = this.mData[n];
            if (this.mCallback.compare(t2, t) != 0) {
                return -1;
            }
            n4 = n;
        } while (!this.mCallback.areItemsTheSame(t2, t));
        return n;
    }

    private void merge(T[] TArray, int n) {
        int n2;
        boolean bl = this.mCallback instanceof BatchedCallback ^ true;
        if (bl) {
            this.beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int n3 = 0;
        this.mOldDataStart = 0;
        this.mOldDataSize = n2 = this.mSize;
        this.mData = (Object[])Array.newInstance(this.mTClass, n2 + n + 10);
        this.mNewDataStart = 0;
        while (this.mOldDataStart < this.mOldDataSize || n3 < n) {
            n2 = this.mOldDataStart;
            int n4 = this.mOldDataSize;
            if (n2 == n4) {
                System.arraycopy(TArray, n3, this.mData, this.mNewDataStart, n -= n3);
                this.mNewDataStart = n3 = this.mNewDataStart + n;
                this.mSize += n;
                this.mCallback.onInserted(n3 - n, n);
                break;
            }
            if (n3 == n) {
                n = n4 - n2;
                System.arraycopy(this.mOldData, n2, this.mData, this.mNewDataStart, n);
                this.mNewDataStart += n;
                break;
            }
            Object object = this.mOldData[n2];
            Object object2 = TArray[n3];
            if ((n2 = this.mCallback.compare(object, object2)) > 0) {
                object = this.mData;
                n4 = this.mNewDataStart;
                this.mNewDataStart = n2 = n4 + 1;
                object[n4] = object2;
                ++this.mSize;
                ++n3;
                this.mCallback.onInserted(n2 - 1, 1);
                continue;
            }
            if (n2 == 0 && this.mCallback.areItemsTheSame(object, object2)) {
                Callback callback = this.mData;
                n2 = this.mNewDataStart;
                this.mNewDataStart = n2 + 1;
                callback[n2] = object2;
                n2 = n3 + 1;
                ++this.mOldDataStart;
                n3 = n2;
                if (this.mCallback.areContentsTheSame(object, object2)) continue;
                callback = this.mCallback;
                callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(object, object2));
                n3 = n2;
                continue;
            }
            object2 = this.mData;
            n2 = this.mNewDataStart;
            this.mNewDataStart = n2 + 1;
            object2[n2] = object;
            ++this.mOldDataStart;
        }
        this.mOldData = null;
        if (!bl) return;
        this.endBatchedUpdates();
    }

    private boolean remove(T t, boolean bl) {
        int n = this.findIndexOf(t, this.mData, 0, this.mSize, 2);
        if (n == -1) {
            return false;
        }
        this.removeItemAtIndex(n, bl);
        return true;
    }

    private void removeItemAtIndex(int n, boolean bl) {
        int n2;
        T[] TArray = this.mData;
        System.arraycopy(TArray, n + 1, TArray, n, this.mSize - n - 1);
        this.mSize = n2 = this.mSize - 1;
        this.mData[n2] = null;
        if (!bl) return;
        this.mCallback.onRemoved(n, 1);
    }

    private void replaceAllInsert(T t) {
        T[] TArray = this.mData;
        int n = this.mNewDataStart;
        TArray[n] = t;
        this.mNewDataStart = ++n;
        ++this.mSize;
        this.mCallback.onInserted(n - 1, 1);
    }

    private void replaceAllInternal(T[] TArray) {
        boolean bl = this.mCallback instanceof BatchedCallback ^ true;
        if (bl) {
            this.beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int n = this.sortAndDedup(TArray);
        this.mData = (Object[])Array.newInstance(this.mTClass, n);
        while (this.mNewDataStart < n || this.mOldDataStart < this.mOldDataSize) {
            int n2;
            int n3;
            int n4 = this.mOldDataSize;
            if ((n3 = this.mOldDataStart++) >= n4) {
                n2 = this.mNewDataStart;
                System.arraycopy(TArray, n2, this.mData, n2, n -= n2);
                this.mNewDataStart += n;
                this.mSize += n;
                this.mCallback.onInserted(n2, n);
                break;
            }
            n2 = this.mNewDataStart;
            if (n2 >= n) {
                n = n4 - n3;
                this.mSize -= n;
                this.mCallback.onRemoved(n2, n);
                break;
            }
            T t = this.mOldData[n3];
            T t2 = TArray[n2];
            if ((n2 = this.mCallback.compare(t, t2)) < 0) {
                this.replaceAllRemove();
                continue;
            }
            if (n2 > 0) {
                this.replaceAllInsert(t2);
                continue;
            }
            if (!this.mCallback.areItemsTheSame(t, t2)) {
                this.replaceAllRemove();
                this.replaceAllInsert(t2);
                continue;
            }
            Callback callback = this.mData;
            n2 = this.mNewDataStart;
            callback[n2] = t2;
            this.mNewDataStart = n2 + 1;
            if (this.mCallback.areContentsTheSame(t, t2)) continue;
            callback = this.mCallback;
            callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t2));
        }
        this.mOldData = null;
        if (!bl) return;
        this.endBatchedUpdates();
    }

    private void replaceAllRemove() {
        --this.mSize;
        ++this.mOldDataStart;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(T[] TArray) {
        if (TArray.length == 0) {
            return 0;
        }
        Arrays.sort(TArray, this.mCallback);
        int n = 1;
        int n2 = 1;
        int n3 = 0;
        while (n < TArray.length) {
            T t = TArray[n];
            if (this.mCallback.compare(TArray[n3], t) == 0) {
                int n4 = this.findSameItem(t, TArray, n3, n2);
                if (n4 != -1) {
                    TArray[n4] = t;
                } else {
                    if (n2 != n) {
                        TArray[n2] = t;
                    }
                    ++n2;
                }
            } else {
                if (n2 != n) {
                    TArray[n2] = t;
                }
                n3 = n2++;
            }
            ++n;
        }
        return n2;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }

    public int add(T t) {
        this.throwIfInMutationOperation();
        return this.add(t, true);
    }

    public void addAll(Collection<T> collection) {
        this.addAll(collection.toArray((Object[])Array.newInstance(this.mTClass, collection.size())), true);
    }

    public void addAll(T ... TArray) {
        this.addAll(TArray, false);
    }

    public void addAll(T[] TArray, boolean bl) {
        this.throwIfInMutationOperation();
        if (TArray.length == 0) {
            return;
        }
        if (bl) {
            this.addAllInternal(TArray);
        } else {
            this.addAllInternal(this.copyArray(TArray));
        }
    }

    public void beginBatchedUpdates() {
        this.throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        this.throwIfInMutationOperation();
        int n = this.mSize;
        if (n == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, n, null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, n);
    }

    public void endBatchedUpdates() {
        BatchedCallback batchedCallback;
        this.throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback)callback).dispatchLastEvent();
        }
        if ((callback = this.mCallback) != (batchedCallback = this.mBatchedCallback)) return;
        this.mCallback = batchedCallback.mWrappedCallback;
    }

    public T get(int n) throws IndexOutOfBoundsException {
        if (n < this.mSize && n >= 0) {
            T[] TArray = this.mOldData;
            if (TArray == null) return this.mData[n];
            int n2 = this.mNewDataStart;
            if (n < n2) return this.mData[n];
            return TArray[n - n2 + this.mOldDataStart];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asked to get item at ");
        stringBuilder.append(n);
        stringBuilder.append(" but size is ");
        stringBuilder.append(this.mSize);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int indexOf(T t) {
        if (this.mOldData == null) return this.findIndexOf(t, this.mData, 0, this.mSize, 4);
        int n = this.findIndexOf(t, this.mData, 0, this.mNewDataStart, 4);
        if (n != -1) {
            return n;
        }
        n = this.findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (n == -1) return -1;
        return n - this.mOldDataStart + this.mNewDataStart;
    }

    public void recalculatePositionOfItemAt(int n) {
        this.throwIfInMutationOperation();
        T t = this.get(n);
        this.removeItemAtIndex(n, false);
        int n2 = this.add(t, false);
        if (n == n2) return;
        this.mCallback.onMoved(n, n2);
    }

    public boolean remove(T t) {
        this.throwIfInMutationOperation();
        return this.remove(t, true);
    }

    public T removeItemAt(int n) {
        this.throwIfInMutationOperation();
        T t = this.get(n);
        this.removeItemAtIndex(n, true);
        return t;
    }

    public void replaceAll(Collection<T> collection) {
        this.replaceAll(collection.toArray((Object[])Array.newInstance(this.mTClass, collection.size())), true);
    }

    public void replaceAll(T ... TArray) {
        this.replaceAll(TArray, false);
    }

    public void replaceAll(T[] TArray, boolean bl) {
        this.throwIfInMutationOperation();
        if (bl) {
            this.replaceAllInternal(TArray);
        } else {
            this.replaceAllInternal(this.copyArray(TArray));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int n, T t) {
        this.throwIfInMutationOperation();
        T t2 = this.get(n);
        int n2 = t2 != t && this.mCallback.areContentsTheSame(t2, t) ? 0 : 1;
        if (t2 != t && this.mCallback.compare(t2, t) == 0) {
            this.mData[n] = t;
            if (n2 == 0) return;
            Callback callback = this.mCallback;
            callback.onChanged(n, 1, callback.getChangePayload(t2, t));
            return;
        }
        if (n2 != 0) {
            Callback callback = this.mCallback;
            callback.onChanged(n, 1, callback.getChangePayload(t2, t));
        }
        this.removeItemAtIndex(n, false);
        n2 = this.add(t, false);
        if (n == n2) return;
        this.mCallback.onMoved(n, n2);
    }
}
