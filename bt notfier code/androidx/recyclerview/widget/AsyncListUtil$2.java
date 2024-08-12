/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseBooleanArray
 *  androidx.recyclerview.widget.AsyncListUtil
 *  androidx.recyclerview.widget.ThreadUtil$BackgroundCallback
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.recyclerview.widget.AsyncListUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

class AsyncListUtil.2
implements ThreadUtil.BackgroundCallback<T> {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    final SparseBooleanArray mLoadedTiles;
    private TileList.Tile<T> mRecycledRoot;
    final AsyncListUtil this$0;

    AsyncListUtil.2(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
        this.mLoadedTiles = new SparseBooleanArray();
    }

    private TileList.Tile<T> acquireTile() {
        TileList.Tile tile = this.mRecycledRoot;
        if (tile == null) return new TileList.Tile(this.this$0.mTClass, this.this$0.mTileSize);
        this.mRecycledRoot = tile.mNext;
        return tile;
    }

    private void addTile(TileList.Tile<T> tile) {
        this.mLoadedTiles.put(tile.mStartPosition, true);
        this.this$0.mMainThreadProxy.addTile(this.mGeneration, tile);
    }

    private void flushTileCache(int n) {
        int n2 = this.this$0.mDataCallback.getMaxCachedTiles();
        while (this.mLoadedTiles.size() >= n2) {
            int n3 = this.mLoadedTiles.keyAt(0);
            SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
            int n4 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
            int n5 = this.mFirstRequiredTileStart - n3;
            int n6 = n4 - this.mLastRequiredTileStart;
            if (n5 > 0 && (n5 >= n6 || n == 2)) {
                this.removeTile(n3);
                continue;
            }
            if (n6 <= 0) return;
            if (n5 >= n6) {
                if (n != 1) return;
            }
            this.removeTile(n4);
        }
    }

    private int getTileStart(int n) {
        return n - n % this.this$0.mTileSize;
    }

    private boolean isTileLoaded(int n) {
        return this.mLoadedTiles.get(n);
    }

    private void log(String string, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[BKGR] ");
        stringBuilder.append(String.format(string, objectArray));
        Log.d((String)"AsyncListUtil", (String)stringBuilder.toString());
    }

    private void removeTile(int n) {
        this.mLoadedTiles.delete(n);
        this.this$0.mMainThreadProxy.removeTile(this.mGeneration, n);
    }

    private void requestTiles(int n, int n2, int n3, boolean bl) {
        int n4 = n;
        while (n4 <= n2) {
            int n5 = bl ? n2 + n - n4 : n4;
            this.this$0.mBackgroundProxy.loadTile(n5, n3);
            n4 += this.this$0.mTileSize;
        }
    }

    public void loadTile(int n, int n2) {
        if (this.isTileLoaded(n)) {
            return;
        }
        TileList.Tile tile = this.acquireTile();
        tile.mStartPosition = n;
        tile.mItemCount = Math.min(this.this$0.mTileSize, this.mItemCount - tile.mStartPosition);
        this.this$0.mDataCallback.fillData(tile.mItems, tile.mStartPosition, tile.mItemCount);
        this.flushTileCache(n2);
        this.addTile(tile);
    }

    public void recycleTile(TileList.Tile<T> tile) {
        this.this$0.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
        tile.mNext = this.mRecycledRoot;
        this.mRecycledRoot = tile;
    }

    public void refresh(int n) {
        this.mGeneration = n;
        this.mLoadedTiles.clear();
        this.mItemCount = this.this$0.mDataCallback.refreshData();
        this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
    }

    public void updateRange(int n, int n2, int n3, int n4, int n5) {
        if (n > n2) {
            return;
        }
        n = this.getTileStart(n);
        n2 = this.getTileStart(n2);
        this.mFirstRequiredTileStart = this.getTileStart(n3);
        this.mLastRequiredTileStart = n3 = this.getTileStart(n4);
        if (n5 == 1) {
            this.requestTiles(this.mFirstRequiredTileStart, n2, n5, true);
            this.requestTiles(n2 + this.this$0.mTileSize, this.mLastRequiredTileStart, n5, false);
        } else {
            this.requestTiles(n, n3, n5, false);
            this.requestTiles(this.mFirstRequiredTileStart, n - this.this$0.mTileSize, n5, true);
        }
    }
}
