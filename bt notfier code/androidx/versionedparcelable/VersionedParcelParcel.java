/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  androidx.collection.ArrayMap
 *  androidx.versionedparcelable.VersionedParcel
 */
package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.Method;

class VersionedParcelParcel
extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField = -1;
    private final int mEnd;
    private int mFieldId = -1;
    private int mNextRead = 0;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup = new SparseIntArray();
    private final String mPrefix;

    VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", (ArrayMap<String, Method>)new ArrayMap(), (ArrayMap<String, Method>)new ArrayMap(), (ArrayMap<String, Class>)new ArrayMap());
    }

    private VersionedParcelParcel(Parcel parcel, int n, int n2, String string, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mParcel = parcel;
        this.mOffset = n;
        this.mEnd = n2;
        this.mNextRead = n;
        this.mPrefix = string;
    }

    public void closeField() {
        int n = this.mCurrentField;
        if (n < 0) return;
        int n2 = this.mPositionLookup.get(n);
        n = this.mParcel.dataPosition();
        this.mParcel.setDataPosition(n2);
        this.mParcel.writeInt(n - n2);
        this.mParcel.setDataPosition(n);
    }

    protected VersionedParcel createSubParcel() {
        int n;
        Parcel parcel = this.mParcel;
        int n2 = parcel.dataPosition();
        int n3 = n = this.mNextRead;
        if (n == this.mOffset) {
            n3 = this.mEnd;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mPrefix);
        stringBuilder.append("  ");
        return new VersionedParcelParcel(parcel, n2, n3, stringBuilder.toString(), (ArrayMap<String, Method>)this.mReadCache, (ArrayMap<String, Method>)this.mWriteCache, (ArrayMap<String, Class>)this.mParcelizerCache);
    }

    public boolean readBoolean() {
        boolean bl = this.mParcel.readInt() != 0;
        return bl;
    }

    public Bundle readBundle() {
        return this.mParcel.readBundle(((Object)((Object)this)).getClass().getClassLoader());
    }

    public byte[] readByteArray() {
        int n = this.mParcel.readInt();
        if (n < 0) {
            return null;
        }
        byte[] byArray = new byte[n];
        this.mParcel.readByteArray(byArray);
        return byArray;
    }

    protected CharSequence readCharSequence() {
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    public double readDouble() {
        return this.mParcel.readDouble();
    }

    public boolean readField(int n) {
        boolean bl;
        while (true) {
            int n2 = this.mNextRead;
            int n3 = this.mEnd;
            bl = true;
            if (n2 >= n3) break;
            n3 = this.mFieldId;
            if (n3 == n) {
                return true;
            }
            if (String.valueOf(n3).compareTo(String.valueOf(n)) > 0) {
                return false;
            }
            this.mParcel.setDataPosition(this.mNextRead);
            n3 = this.mParcel.readInt();
            this.mFieldId = this.mParcel.readInt();
            this.mNextRead += n3;
        }
        if (this.mFieldId == n) return bl;
        bl = false;
        return bl;
    }

    public float readFloat() {
        return this.mParcel.readFloat();
    }

    public int readInt() {
        return this.mParcel.readInt();
    }

    public long readLong() {
        return this.mParcel.readLong();
    }

    public <T extends Parcelable> T readParcelable() {
        return (T)this.mParcel.readParcelable(((Object)((Object)this)).getClass().getClassLoader());
    }

    public String readString() {
        return this.mParcel.readString();
    }

    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public void setOutputField(int n) {
        this.closeField();
        this.mCurrentField = n;
        this.mPositionLookup.put(n, this.mParcel.dataPosition());
        this.writeInt(0);
        this.writeInt(n);
    }

    public void writeBoolean(boolean bl) {
        this.mParcel.writeInt(bl ? 1 : 0);
    }

    public void writeBundle(Bundle bundle) {
        this.mParcel.writeBundle(bundle);
    }

    public void writeByteArray(byte[] byArray) {
        if (byArray != null) {
            this.mParcel.writeInt(byArray.length);
            this.mParcel.writeByteArray(byArray);
        } else {
            this.mParcel.writeInt(-1);
        }
    }

    public void writeByteArray(byte[] byArray, int n, int n2) {
        if (byArray != null) {
            this.mParcel.writeInt(byArray.length);
            this.mParcel.writeByteArray(byArray, n, n2);
        } else {
            this.mParcel.writeInt(-1);
        }
    }

    protected void writeCharSequence(CharSequence charSequence) {
        TextUtils.writeToParcel((CharSequence)charSequence, (Parcel)this.mParcel, (int)0);
    }

    public void writeDouble(double d) {
        this.mParcel.writeDouble(d);
    }

    public void writeFloat(float f) {
        this.mParcel.writeFloat(f);
    }

    public void writeInt(int n) {
        this.mParcel.writeInt(n);
    }

    public void writeLong(long l) {
        this.mParcel.writeLong(l);
    }

    public void writeParcelable(Parcelable parcelable) {
        this.mParcel.writeParcelable(parcelable, 0);
    }

    public void writeString(String string) {
        this.mParcel.writeString(string);
    }

    public void writeStrongBinder(IBinder iBinder) {
        this.mParcel.writeStrongBinder(iBinder);
    }

    public void writeStrongInterface(IInterface iInterface) {
        this.mParcel.writeStrongInterface(iInterface);
    }
}
