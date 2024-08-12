/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AdapterListUpdateCallback
 *  androidx.recyclerview.widget.AsyncDifferConfig
 *  androidx.recyclerview.widget.AsyncDifferConfig$Builder
 *  androidx.recyclerview.widget.AsyncListDiffer$ListListener
 *  androidx.recyclerview.widget.AsyncListDiffer$MainThreadExecutor
 *  androidx.recyclerview.widget.DiffUtil$DiffResult
 *  androidx.recyclerview.widget.DiffUtil$ItemCallback
 *  androidx.recyclerview.widget.ListUpdateCallback
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = new MainThreadExecutor();
    final AsyncDifferConfig<T> mConfig;
    private List<T> mList;
    private final List<ListListener<T>> mListeners = new CopyOnWriteArrayList<ListListener<T>>();
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List<T> mReadOnlyList = Collections.emptyList();
    private final ListUpdateCallback mUpdateCallback;

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor() != null ? asyncDifferConfig.getMainThreadExecutor() : sMainThreadExecutor;
    }

    public AsyncListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this((ListUpdateCallback)new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    private void onCurrentListChanged(List<T> list, Runnable runnable) {
        Iterator<ListListener<T>> iterator = this.mListeners.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                if (runnable == null) return;
                runnable.run();
                return;
            }
            iterator.next().onCurrentListChanged(list, this.mReadOnlyList);
        }
    }

    public void addListListener(ListListener<T> listListener) {
        this.mListeners.add(listListener);
    }

    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    void latchList(List<T> list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        List<T> list2 = this.mReadOnlyList;
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        this.onCurrentListChanged(list2, runnable);
    }

    public void removeListListener(ListListener<T> listListener) {
        this.mListeners.remove(listListener);
    }

    public void submitList(List<T> list) {
        this.submitList(list, null);
    }

    public void submitList(List<T> list, Runnable runnable) {
        int n;
        this.mMaxScheduledGeneration = n = this.mMaxScheduledGeneration + 1;
        List<T> list2 = this.mList;
        if (list == list2) {
            if (runnable == null) return;
            runnable.run();
            return;
        }
        List<T> list3 = this.mReadOnlyList;
        if (list == null) {
            n = list2.size();
            this.mList = null;
            this.mReadOnlyList = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, n);
            this.onCurrentListChanged(list3, runnable);
            return;
        }
        if (list2 == null) {
            this.mList = list;
            this.mReadOnlyList = Collections.unmodifiableList(list);
            this.mUpdateCallback.onInserted(0, list.size());
            this.onCurrentListChanged(list3, runnable);
            return;
        }
        this.mConfig.getBackgroundThreadExecutor().execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
