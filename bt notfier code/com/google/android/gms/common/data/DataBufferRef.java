/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.net.Uri
 *  com.google.android.gms.common.data.DataHolder
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public abstract class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zaa;

    public DataBufferRef(DataHolder dataHolder, int n) {
        this.mDataHolder = (DataHolder)Preconditions.checkNotNull((Object)dataHolder);
        this.zaa(n);
    }

    protected void copyToBuffer(String string, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.zad(string, this.mDataRow, this.zaa, charArrayBuffer);
    }

    public boolean equals(Object object) {
        if (!(object instanceof DataBufferRef)) return false;
        object = (DataBufferRef)object;
        if (!Objects.equal((Object)((DataBufferRef)object).mDataRow, (Object)this.mDataRow)) return false;
        if (!Objects.equal((Object)((DataBufferRef)object).zaa, (Object)this.zaa)) return false;
        if (((DataBufferRef)object).mDataHolder != this.mDataHolder) return false;
        return true;
    }

    protected boolean getBoolean(String string) {
        return this.mDataHolder.getBoolean(string, this.mDataRow, this.zaa);
    }

    protected byte[] getByteArray(String string) {
        return this.mDataHolder.getByteArray(string, this.mDataRow, this.zaa);
    }

    protected int getDataRow() {
        return this.mDataRow;
    }

    protected double getDouble(String string) {
        return this.mDataHolder.zac(string, this.mDataRow, this.zaa);
    }

    protected float getFloat(String string) {
        return this.mDataHolder.zab(string, this.mDataRow, this.zaa);
    }

    protected int getInteger(String string) {
        return this.mDataHolder.getInteger(string, this.mDataRow, this.zaa);
    }

    protected long getLong(String string) {
        return this.mDataHolder.getLong(string, this.mDataRow, this.zaa);
    }

    protected String getString(String string) {
        return this.mDataHolder.getString(string, this.mDataRow, this.zaa);
    }

    public boolean hasColumn(String string) {
        return this.mDataHolder.hasColumn(string);
    }

    protected boolean hasNull(String string) {
        return this.mDataHolder.hasNull(string, this.mDataRow, this.zaa);
    }

    public int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.mDataRow, this.zaa, this.mDataHolder});
    }

    public boolean isDataValid() {
        if (this.mDataHolder.isClosed()) return false;
        return true;
    }

    protected Uri parseUri(String string) {
        if ((string = this.mDataHolder.getString(string, this.mDataRow, this.zaa)) != null) return Uri.parse((String)string);
        return null;
    }

    protected final void zaa(int n) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n >= 0) {
            bl2 = bl;
            if (n < this.mDataHolder.getCount()) {
                bl2 = true;
            }
        }
        Preconditions.checkState((boolean)bl2);
        this.mDataRow = n;
        this.zaa = this.mDataHolder.getWindowIndex(n);
    }
}
