/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CharArrayBuffer
 *  android.database.Cursor
 *  android.database.CursorIndexOutOfBoundsException
 *  android.database.CursorWindow
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 *  com.google.android.gms.common.data.DataHolder$Builder
 *  com.google.android.gms.common.data.zab
 *  com.google.android.gms.common.data.zac
 *  com.google.android.gms.common.data.zad
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.sqlite.CursorWrapper
 */
package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zab;
import com.google.android.gms.common.data.zac;
import com.google.android.gms.common.data.zad;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public final class DataHolder
extends AbstractSafeParcelable
implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zad();
    private static final Builder zak = new zab(new String[0], null);
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    boolean zae;
    private final String[] zaf;
    private final CursorWindow[] zag;
    private final int zah;
    private final Bundle zai;
    private boolean zaj;

    DataHolder(int n, String[] stringArray, CursorWindow[] cursorWindowArray, int n2, Bundle bundle) {
        this.zae = false;
        this.zaj = true;
        this.zaa = n;
        this.zaf = stringArray;
        this.zag = cursorWindowArray;
        this.zah = n2;
        this.zai = bundle;
    }

    public DataHolder(Cursor cursor, int n, Bundle bundle) {
        CursorWrapper cursorWrapper = new CursorWrapper(cursor);
        String[] stringArray = cursorWrapper.getColumnNames();
        ArrayList<Cursor> arrayList = new ArrayList<Cursor>();
        try {
            int n2;
            int n3 = cursorWrapper.getCount();
            cursor = cursorWrapper.getWindow();
            if (cursor != null && cursor.getStartPosition() == 0) {
                cursor.acquireReference();
                cursorWrapper.setWindow(null);
                arrayList.add(cursor);
                n2 = cursor.getNumRows();
            } else {
                n2 = 0;
            }
            while (n2 < n3 && cursorWrapper.moveToPosition(n2)) {
                cursor = cursorWrapper.getWindow();
                if (cursor != null) {
                    cursor.acquireReference();
                    cursorWrapper.setWindow(null);
                } else {
                    super(false);
                    cursor.setStartPosition(n2);
                    cursorWrapper.fillWindow(n2, (CursorWindow)cursor);
                }
                if (cursor.getNumRows() == 0) {
                    break;
                }
                arrayList.add(cursor);
                n2 = cursor.getStartPosition();
                int n4 = cursor.getNumRows();
                n2 += n4;
            }
        }
        finally {
            cursorWrapper.close();
        }
        this(stringArray, arrayList.toArray(new CursorWindow[arrayList.size()]), n, bundle);
    }

    private DataHolder(Builder builder, int n, Bundle bundle) {
        this(Builder.zab((Builder)builder), DataHolder.zae(builder, -1), n, null);
    }

    /* synthetic */ DataHolder(Builder builder, int n, Bundle bundle, int n2, zab zab2) {
        this(Builder.zab((Builder)builder), DataHolder.zae(builder, -1), n, bundle);
    }

    /* synthetic */ DataHolder(Builder builder, int n, Bundle bundle, zab zab2) {
        this(builder, n, null);
    }

    public DataHolder(String[] stringArray, CursorWindow[] cursorWindowArray, int n, Bundle bundle) {
        this.zae = false;
        this.zaj = true;
        this.zaa = 1;
        this.zaf = (String[])Preconditions.checkNotNull((Object)stringArray);
        this.zag = (CursorWindow[])Preconditions.checkNotNull((Object)cursorWindowArray);
        this.zah = n;
        this.zai = bundle;
        this.zaa();
    }

    public static Builder builder(String[] stringArray) {
        return new Builder(stringArray, null, null);
    }

    public static DataHolder empty(int n) {
        return new DataHolder(zak, n, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static CursorWindow[] zae(Builder var0, int var1_2) {
        var1_2 = Builder.zab((Builder)var0 /* !! */ ).length;
        var4_3 = 0;
        if (var1_2 == 0) {
            return new CursorWindow[0];
        }
        var12_4 = Builder.zac((Builder)var0 /* !! */ );
        var5_5 = var12_4.size();
        var9_6 = new CursorWindow(false);
        var11_7 = new ArrayList<Object>();
        var11_7.add(var9_6);
        var9_6.setNumColumns(Builder.zab((Builder)var0 /* !! */ ).length);
        var1_2 = 0;
        var2_8 = 0;
        while (var1_2 < var5_5) {
            try {
                var8_11 = var9_6.allocRow();
                if (!var8_11) {
                    var9_6 = new StringBuilder(72);
                    var9_6.append("Allocating additional cursor window for large data set (row ");
                    var9_6.append(var1_2);
                    var9_6.append(")");
                    Log.d((String)"DataHolder", (String)var9_6.toString());
                    var10_12 = new CursorWindow(false);
                    var10_12.setStartPosition(var1_2);
                    var10_12.setNumColumns(Builder.zab((Builder)var0 /* !! */ ).length);
                    var11_7.add(var10_12);
                    var9_6 = var10_12;
                    if (!var10_12.allocRow()) {
                        Log.e((String)"DataHolder", (String)"Unable to allocate row to hold data.");
                        var11_7.remove(var10_12);
                        return var11_7.toArray(new CursorWindow[var11_7.size()]);
                    }
                }
                var14_14 = (Map)var12_4.get(var1_2);
                var8_11 = true;
                for (var3_9 = 0; var3_9 < Builder.zab((Builder)var0 /* !! */ ).length; ++var3_9) {
                    if (!var8_11) ** GOTO lbl99
                    var10_12 = Builder.zab((Builder)var0 /* !! */ )[var3_9];
                    var13_13 = var14_14.get(var10_12);
                    if (var13_13 == null) {
                        var8_11 = var9_6.putNull(var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof String) {
                        var8_11 = var9_6.putString((String)var13_13, var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof Long) {
                        var8_11 = var9_6.putLong(((Long)var13_13).longValue(), var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof Integer) {
                        var8_11 = var9_6.putLong((long)((Integer)var13_13).intValue(), var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof Boolean) {
                        var6_10 = true != (Boolean)var13_13 ? 0L : 1L;
                        var8_11 = var9_6.putLong(var6_10, var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof byte[]) {
                        var8_11 = var9_6.putBlob((byte[])var13_13, var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof Double) {
                        var8_11 = var9_6.putDouble(((Double)var13_13).doubleValue(), var1_2, var3_9);
                        continue;
                    }
                    if (var13_13 instanceof Float) {
                        var8_11 = var9_6.putDouble((double)((Float)var13_13).floatValue(), var1_2, var3_9);
                        continue;
                    }
                    ** GOTO lbl-1000
                }
                ** GOTO lbl96
            }
            catch (RuntimeException var0_1) {
                var2_8 = var11_7.size();
                var1_2 = var4_3;
                while (var1_2 < var2_8) {
                    ((CursorWindow)var11_7.get(var1_2)).close();
                    ++var1_2;
                }
                throw var0_1;
            }
lbl-1000:
            // 1 sources

            {
                block22: {
                    block21: {
                        var9_6 = String.valueOf(var13_13);
                        var1_2 = String.valueOf(var10_12).length();
                        var2_8 = String.valueOf(var9_6).length();
                        var12_4 = new StringBuilder(var1_2 + 32 + var2_8);
                        var12_4.append("Unsupported object for column ");
                        var12_4.append((String)var10_12);
                        var12_4.append(": ");
                        var12_4.append((String)var9_6);
                        var0 /* !! */  = new IllegalArgumentException(var12_4.toString());
                        throw var0 /* !! */ ;
lbl96:
                        // 1 sources

                        if (!var8_11) break block21;
                        var2_8 = 0;
                        break block22;
                    }
                    if (var2_8 != 0) ** GOTO lbl-1000
                    var10_12 = new StringBuilder(74);
                    var10_12.append("Couldn't populate window data for row ");
                    var10_12.append(var1_2);
                    var10_12.append(" - allocating new window.");
                    Log.d((String)"DataHolder", (String)var10_12.toString());
                    var9_6.freeLastRow();
                    var9_6 = new CursorWindow(false);
                    var9_6.setStartPosition(var1_2);
                    var9_6.setNumColumns(Builder.zab((Builder)var0 /* !! */ ).length);
                    var11_7.add(var9_6);
                    --var1_2;
                    var2_8 = 1;
                }
                ++var1_2;
            }
        }
        return var11_7.toArray(new CursorWindow[var11_7.size()]);
lbl-1000:
        // 1 sources

        {
            var0 /* !! */  = new zac("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            throw var0 /* !! */ ;
        }
    }

    private final void zaf(String string, int n) {
        Bundle bundle = this.zab;
        if (bundle != null && bundle.containsKey(string)) {
            if (this.isClosed()) throw new IllegalArgumentException("Buffer is closed.");
            if (n < 0) throw new CursorIndexOutOfBoundsException(n, this.zad);
            if (n >= this.zad) throw new CursorIndexOutOfBoundsException(n, this.zad);
            return;
        }
        string = (string = String.valueOf(string)).length() != 0 ? "No such column: ".concat(string) : new String("No such column: ");
        throw new IllegalArgumentException(string);
    }

    @Override
    public void close() {
        synchronized (this) {
            CursorWindow[] cursorWindowArray;
            if (this.zae) return;
            this.zae = true;
            int n = 0;
            while (n < (cursorWindowArray = this.zag).length) {
                cursorWindowArray[n].close();
                ++n;
            }
            return;
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (!this.zaj) return;
            if (this.zag.length <= 0) return;
            if (this.isClosed()) return;
            this.close();
            String string = this.toString();
            int n = String.valueOf(string).length();
            StringBuilder stringBuilder = new StringBuilder(n + 178);
            stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
            stringBuilder.append(string);
            stringBuilder.append(")");
            Log.e((String)"DataBuffer", (String)stringBuilder.toString());
            return;
        }
        finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String string, int n, int n2) {
        this.zaf(string, n);
        if (Long.valueOf(this.zag[n2].getLong(n, this.zab.getInt(string))) != 1L) return false;
        return true;
    }

    public byte[] getByteArray(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].getBlob(n, this.zab.getInt(string));
    }

    public int getCount() {
        return this.zad;
    }

    public int getInteger(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].getInt(n, this.zab.getInt(string));
    }

    public long getLong(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].getLong(n, this.zab.getInt(string));
    }

    public Bundle getMetadata() {
        return this.zai;
    }

    public int getStatusCode() {
        return this.zah;
    }

    public String getString(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].getString(n, this.zab.getInt(string));
    }

    public int getWindowIndex(int n) {
        int n2;
        int n3;
        block1: {
            int[] nArray;
            int n4 = 0;
            boolean bl = n >= 0 && n < this.zad;
            Preconditions.checkState((boolean)bl);
            do {
                nArray = this.zac;
                n3 = nArray.length;
                n2 = ++n4;
                if (n4 >= n3) break block1;
            } while (n >= nArray[n4]);
            n2 = n4 - 1;
        }
        n = n2;
        if (n2 != n3) return n;
        n = n2 - 1;
        return n;
    }

    public boolean hasColumn(String string) {
        return this.zab.containsKey(string);
    }

    public boolean hasNull(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].isNull(n, this.zab.getInt(string));
    }

    public boolean isClosed() {
        synchronized (this) {
            boolean bl = this.zae;
            return bl;
        }
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeStringArray((Parcel)parcel, (int)1, (String[])this.zaf, (boolean)false);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)2, (Parcelable[])this.zag, (int)n, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.getStatusCode());
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)4, (Bundle)this.getMetadata(), (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1000, (int)this.zaa);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
        if ((n & 1) == 0) return;
        this.close();
    }

    public final void zaa() {
        String[] stringArray;
        int n;
        this.zab = new Bundle();
        int n2 = 0;
        for (n = 0; n < (stringArray = this.zaf).length; ++n) {
            this.zab.putInt(stringArray[n], n);
        }
        this.zac = new int[this.zag.length];
        int n3 = 0;
        n = n2;
        while (true) {
            if (n >= (stringArray = this.zag).length) {
                this.zad = n3;
                return;
            }
            this.zac[n] = n3;
            n2 = stringArray[n].getStartPosition();
            n3 += this.zag[n].getNumRows() - (n3 - n2);
            ++n;
        }
    }

    public final float zab(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].getFloat(n, this.zab.getInt(string));
    }

    public final double zac(String string, int n, int n2) {
        this.zaf(string, n);
        return this.zag[n2].getDouble(n, this.zab.getInt(string));
    }

    public final void zad(String string, int n, int n2, CharArrayBuffer charArrayBuffer) {
        this.zaf(string, n);
        this.zag[n2].copyStringToBuffer(n, this.zab.getInt(string), charArrayBuffer);
    }
}
