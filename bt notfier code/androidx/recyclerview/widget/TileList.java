/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  androidx.recyclerview.widget.TileList$Tile
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.TileList;

class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray(10);

    public TileList(int n) {
        this.mTileSize = n;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int n = this.mTiles.indexOfKey(tile.mStartPosition);
        if (n < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile tile2 = (Tile)this.mTiles.valueAt(n);
        this.mTiles.setValueAt(n, tile);
        if (this.mLastAccessedTile != tile2) return tile2;
        this.mLastAccessedTile = tile;
        return tile2;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int n) {
        if (n < 0) return null;
        if (n < this.mTiles.size()) return (Tile)this.mTiles.valueAt(n);
        return null;
    }

    public T getItemAt(int n) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile != null) {
            if (tile.containsPosition(n)) return (T)this.mLastAccessedTile.getByPosition(n);
        }
        int n2 = this.mTileSize;
        if ((n2 = this.mTiles.indexOfKey(n - n % n2)) < 0) {
            return null;
        }
        this.mLastAccessedTile = (Tile)this.mTiles.valueAt(n2);
        return (T)this.mLastAccessedTile.getByPosition(n);
    }

    public Tile<T> removeAtPos(int n) {
        Tile tile = (Tile)this.mTiles.get(n);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(n);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}
