/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.recyclerview.widget.AsyncListUtil
 *  androidx.recyclerview.widget.ThreadUtil$MainThreadCallback
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.AsyncListUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

class AsyncListUtil.1
implements ThreadUtil.MainThreadCallback<T> {
    final AsyncListUtil this$0;

    AsyncListUtil.1(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
    }

    private boolean isRequestedGeneration(int n) {
        boolean bl = n == this.this$0.mRequestedGeneration;
        return bl;
    }

    private void recycleAllTiles() {
        int n = 0;
        while (true) {
            if (n >= this.this$0.mTileList.size()) {
                this.this$0.mTileList.clear();
                return;
            }
            this.this$0.mBackgroundProxy.recycleTile(this.this$0.mTileList.getAtIndex(n));
            ++n;
        }
    }

    public void addTile(int n, TileList.Tile<T> tile) {
        if (!this.isRequestedGeneration(n)) {
            this.this$0.mBackgroundProxy.recycleTile(tile);
            return;
        }
        TileList.Tile tile2 = this.this$0.mTileList.addOrReplace(tile);
        if (tile2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("duplicate tile @");
            stringBuilder.append(tile2.mStartPosition);
            Log.e((String)"AsyncListUtil", (String)stringBuilder.toString());
            this.this$0.mBackgroundProxy.recycleTile(tile2);
        }
        int n2 = tile.mStartPosition;
        int n3 = tile.mItemCount;
        n = 0;
        while (n < this.this$0.mMissingPositions.size()) {
            int n4 = this.this$0.mMissingPositions.keyAt(n);
            if (tile.mStartPosition <= n4 && n4 < n2 + n3) {
                this.this$0.mMissingPositions.removeAt(n);
                this.this$0.mViewCallback.onItemLoaded(n4);
                continue;
            }
            ++n;
        }
    }

    public void removeTile(int n, int n2) {
        if (!this.isRequestedGeneration(n)) {
            return;
        }
        Object object = this.this$0.mTileList.removeAtPos(n2);
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("tile not found @");
            ((StringBuilder)object).append(n2);
            Log.e((String)"AsyncListUtil", (String)((StringBuilder)object).toString());
            return;
        }
        this.this$0.mBackgroundProxy.recycleTile((TileList.Tile)object);
    }

    public void updateItemCount(int n, int n2) {
        if (!this.isRequestedGeneration(n)) {
            return;
        }
        this.this$0.mItemCount = n2;
        this.this$0.mViewCallback.onDataRefresh();
        AsyncListUtil asyncListUtil = this.this$0;
        asyncListUtil.mDisplayedGeneration = asyncListUtil.mRequestedGeneration;
        this.recycleAllTiles();
        this.this$0.mAllowScrollHints = false;
        this.this$0.updateRange();
    }
}
