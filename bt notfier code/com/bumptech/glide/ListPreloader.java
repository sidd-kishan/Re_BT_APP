/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  com.bumptech.glide.ListPreloader$PreloadModelProvider
 *  com.bumptech.glide.ListPreloader$PreloadSizeProvider
 *  com.bumptech.glide.ListPreloader$PreloadTargetQueue
 *  com.bumptech.glide.RequestManager
 *  com.bumptech.glide.request.target.Target
 */
package com.bumptech.glide;

import android.widget.AbsListView;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;
import java.util.List;

public class ListPreloader<T>
implements AbsListView.OnScrollListener {
    private boolean isIncreasing = true;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public ListPreloader(RequestManager requestManager, PreloadModelProvider<T> preloadModelProvider, PreloadSizeProvider<T> preloadSizeProvider, int n) {
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = n;
        this.preloadTargetQueue = new PreloadTargetQueue(n + 1);
    }

    private void cancelAll() {
        int n = 0;
        while (n < this.maxPreload) {
            this.requestManager.clear((Target)this.preloadTargetQueue.next(0, 0));
            ++n;
        }
    }

    private void preload(int n, int n2) {
        int n3;
        int n4;
        if (n < n2) {
            n4 = Math.max(this.lastEnd, n);
            n3 = n2;
        } else {
            n3 = Math.min(this.lastStart, n);
            n4 = n2;
        }
        n3 = Math.min(this.totalItemCount, n3);
        n4 = Math.min(this.totalItemCount, Math.max(0, n4));
        if (n < n2) {
            for (n = n4; n < n3; ++n) {
                this.preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(n), n, true);
            }
        } else {
            for (n = n3 - 1; n >= n4; --n) {
                this.preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(n), n, false);
            }
        }
        this.lastStart = n4;
        this.lastEnd = n3;
    }

    private void preload(int n, boolean bl) {
        if (this.isIncreasing != bl) {
            this.isIncreasing = bl;
            this.cancelAll();
        }
        int n2 = bl ? this.maxPreload : -this.maxPreload;
        this.preload(n, n2 + n);
    }

    private void preloadAdapterPosition(List<T> list, int n, boolean bl) {
        int n2 = list.size();
        if (bl) {
            int n3 = 0;
            while (n3 < n2) {
                this.preloadItem(list.get(n3), n, n3);
                ++n3;
            }
            return;
        }
        int n4 = n2 - 1;
        while (n4 >= 0) {
            this.preloadItem(list.get(n4), n, n4);
            --n4;
        }
    }

    private void preloadItem(T object, int n, int n2) {
        if (object == null) {
            return;
        }
        int[] nArray = this.preloadDimensionProvider.getPreloadSize(object, n, n2);
        if (nArray == null) {
            return;
        }
        if ((object = this.preloadModelProvider.getPreloadRequestBuilder(object)) == null) {
            return;
        }
        object.into((Target)this.preloadTargetQueue.next(nArray[0], nArray[1]));
    }

    public void onScroll(AbsListView absListView, int n, int n2, int n3) {
        this.totalItemCount = n3;
        n3 = this.lastFirstVisible;
        if (n > n3) {
            this.preload(n2 + n, true);
        } else if (n < n3) {
            this.preload(n, false);
        }
        this.lastFirstVisible = n;
    }

    public void onScrollStateChanged(AbsListView absListView, int n) {
    }
}
