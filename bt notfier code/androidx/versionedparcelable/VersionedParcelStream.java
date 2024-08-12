/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcelable
 *  androidx.collection.ArrayMap
 *  androidx.versionedparcelable.VersionedParcel
 *  androidx.versionedparcelable.VersionedParcel$ParcelException
 *  androidx.versionedparcelable.VersionedParcelStream$FieldBuffer
 */
package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

class VersionedParcelStream
extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = Charset.forName("UTF-16");
    int mCount = 0;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId = -1;
    int mFieldSize = -1;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, (ArrayMap<String, Method>)new ArrayMap(), (ArrayMap<String, Method>)new ArrayMap(), (ArrayMap<String, Class>)new ArrayMap());
    }

    private VersionedParcelStream(InputStream object, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        arrayMap = null;
        object = object != null ? new DataInputStream((InputStream)new /* Unavailable Anonymous Inner Class!! */) : null;
        this.mMasterInput = object;
        object = arrayMap;
        if (outputStream != null) {
            object = new DataOutputStream(outputStream);
        }
        this.mMasterOutput = object;
        this.mCurrentInput = this.mMasterInput;
        this.mCurrentOutput = object;
    }

    private void readObject(int n, String charSequence, Bundle bundle) {
        switch (n) {
            default: {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Unknown type ");
                ((StringBuilder)charSequence).append(n);
                throw new RuntimeException(((StringBuilder)charSequence).toString());
            }
            case 14: {
                bundle.putFloatArray((String)charSequence, this.readFloatArray());
                break;
            }
            case 13: {
                bundle.putFloat((String)charSequence, this.readFloat());
                break;
            }
            case 12: {
                bundle.putLongArray((String)charSequence, this.readLongArray());
                break;
            }
            case 11: {
                bundle.putLong((String)charSequence, this.readLong());
                break;
            }
            case 10: {
                bundle.putIntArray((String)charSequence, this.readIntArray());
                break;
            }
            case 9: {
                bundle.putInt((String)charSequence, this.readInt());
                break;
            }
            case 8: {
                bundle.putDoubleArray((String)charSequence, this.readDoubleArray());
                break;
            }
            case 7: {
                bundle.putDouble((String)charSequence, this.readDouble());
                break;
            }
            case 6: {
                bundle.putBooleanArray((String)charSequence, this.readBooleanArray());
                break;
            }
            case 5: {
                bundle.putBoolean((String)charSequence, this.readBoolean());
                break;
            }
            case 4: {
                bundle.putStringArray((String)charSequence, (String[])this.readArray(new String[0]));
                break;
            }
            case 3: {
                bundle.putString((String)charSequence, this.readString());
                break;
            }
            case 2: {
                bundle.putBundle((String)charSequence, this.readBundle());
                break;
            }
            case 1: {
                bundle.putBundle((String)charSequence, this.readBundle());
                break;
            }
            case 0: {
                bundle.putParcelable((String)charSequence, null);
            }
        }
    }

    private void writeObject(Object object) {
        if (object == null) {
            this.writeInt(0);
        } else if (object instanceof Bundle) {
            this.writeInt(1);
            this.writeBundle((Bundle)object);
        } else if (object instanceof String) {
            this.writeInt(3);
            this.writeString((String)object);
        } else if (object instanceof String[]) {
            this.writeInt(4);
            this.writeArray((String[])object);
        } else if (object instanceof Boolean) {
            this.writeInt(5);
            this.writeBoolean((Boolean)object);
        } else if (object instanceof boolean[]) {
            this.writeInt(6);
            this.writeBooleanArray((boolean[])object);
        } else if (object instanceof Double) {
            this.writeInt(7);
            this.writeDouble((Double)object);
        } else if (object instanceof double[]) {
            this.writeInt(8);
            this.writeDoubleArray((double[])object);
        } else if (object instanceof Integer) {
            this.writeInt(9);
            this.writeInt((Integer)object);
        } else if (object instanceof int[]) {
            this.writeInt(10);
            this.writeIntArray((int[])object);
        } else if (object instanceof Long) {
            this.writeInt(11);
            this.writeLong((Long)object);
        } else if (object instanceof long[]) {
            this.writeInt(12);
            this.writeLongArray((long[])object);
        } else if (object instanceof Float) {
            this.writeInt(13);
            this.writeFloat(((Float)object).floatValue());
        } else {
            if (!(object instanceof float[])) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported type ");
                stringBuilder.append(object.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.writeInt(14);
            this.writeFloatArray((float[])object);
        }
    }

    public void closeField() {
        FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer == null) return;
        try {
            if (fieldBuffer.mOutput.size() != 0) {
                this.mFieldBuffer.flushField();
            }
            this.mFieldBuffer = null;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    protected VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, (ArrayMap<String, Method>)this.mReadCache, (ArrayMap<String, Method>)this.mWriteCache, (ArrayMap<String, Class>)this.mParcelizerCache);
    }

    public boolean isStream() {
        return true;
    }

    public boolean readBoolean() {
        try {
            boolean bl = this.mCurrentInput.readBoolean();
            return bl;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public Bundle readBundle() {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        int n2 = 0;
        while (n2 < n) {
            String string = this.readString();
            this.readObject(this.readInt(), string, bundle);
            ++n2;
        }
        return bundle;
    }

    public byte[] readByteArray() {
        try {
            int n = this.mCurrentInput.readInt();
            if (n <= 0) return null;
            byte[] byArray = new byte[n];
            this.mCurrentInput.readFully(byArray);
            return byArray;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    protected CharSequence readCharSequence() {
        return null;
    }

    public double readDouble() {
        try {
            double d = this.mCurrentInput.readDouble();
            return d;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public boolean readField(int n) {
        try {
            while (true) {
                int n2;
                if (this.mFieldId == n) {
                    return true;
                }
                if (String.valueOf(this.mFieldId).compareTo(String.valueOf(n)) > 0) {
                    return false;
                }
                if (this.mCount < this.mFieldSize) {
                    this.mMasterInput.skip(this.mFieldSize - this.mCount);
                }
                this.mFieldSize = -1;
                int n3 = this.mMasterInput.readInt();
                this.mCount = 0;
                int n4 = n2 = n3 & 0xFFFF;
                if (n2 == 65535) {
                    n4 = this.mMasterInput.readInt();
                }
                this.mFieldId = n3 >> 16 & 0xFFFF;
                this.mFieldSize = n4;
            }
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public float readFloat() {
        try {
            float f = this.mCurrentInput.readFloat();
            return f;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public int readInt() {
        try {
            int n = this.mCurrentInput.readInt();
            return n;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public long readLong() {
        try {
            long l = this.mCurrentInput.readLong();
            return l;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    public String readString() {
        try {
            int n = this.mCurrentInput.readInt();
            if (n <= 0) return null;
            Object object = new byte[n];
            this.mCurrentInput.readFully((byte[])object);
            object = new String((byte[])object, UTF_16);
            return object;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public IBinder readStrongBinder() {
        return null;
    }

    public void setOutputField(int n) {
        FieldBuffer fieldBuffer;
        this.closeField();
        this.mFieldBuffer = fieldBuffer = new FieldBuffer(n, this.mMasterOutput);
        this.mCurrentOutput = fieldBuffer.mDataStream;
    }

    public void setSerializationFlags(boolean bl, boolean bl2) {
        if (!bl) throw new RuntimeException("Serialization of this object is not allowed");
        this.mIgnoreParcelables = bl2;
    }

    public void writeBoolean(boolean bl) {
        try {
            this.mCurrentOutput.writeBoolean(bl);
            return;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void writeBundle(Bundle var1_1) {
        if (var1_1 == null) ** GOTO lbl12
        try {
            var2_4 = var1_1.keySet();
            this.mCurrentOutput.writeInt(var2_4.size());
            var2_4 = var2_4.iterator();
            while (var2_4.hasNext() != false) {
                var3_5 = (String)var2_4.next();
                this.writeString(var3_5);
                this.writeObject(var1_1.get(var3_5));
            }
            return;
lbl12:
            // 1 sources

            this.mCurrentOutput.writeInt(-1);
            return;
        }
        catch (IOException var1_2) {
            var1_3 = new VersionedParcel.ParcelException((Throwable)var1_2);
            throw var1_3;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void writeByteArray(byte[] var1_1) {
        if (var1_1 == null) ** GOTO lbl6
        try {
            block2: {
                this.mCurrentOutput.writeInt(var1_1.length);
                this.mCurrentOutput.write(var1_1);
                break block2;
lbl6:
                // 1 sources

                this.mCurrentOutput.writeInt(-1);
            }
            return;
        }
        catch (IOException var1_2) {
            throw new VersionedParcel.ParcelException((Throwable)var1_2);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void writeByteArray(byte[] var1_1, int var2_3, int var3_4) {
        if (var1_1 == null) ** GOTO lbl6
        try {
            block2: {
                this.mCurrentOutput.writeInt(var3_4);
                this.mCurrentOutput.write(var1_1, var2_3, var3_4);
                break block2;
lbl6:
                // 1 sources

                this.mCurrentOutput.writeInt(-1);
            }
            return;
        }
        catch (IOException var1_2) {
            throw new VersionedParcel.ParcelException((Throwable)var1_2);
        }
    }

    protected void writeCharSequence(CharSequence charSequence) {
        if (!this.mIgnoreParcelables) throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    public void writeDouble(double d) {
        try {
            this.mCurrentOutput.writeDouble(d);
            return;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public void writeFloat(float f) {
        try {
            this.mCurrentOutput.writeFloat(f);
            return;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public void writeInt(int n) {
        try {
            this.mCurrentOutput.writeInt(n);
            return;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public void writeLong(long l) {
        try {
            this.mCurrentOutput.writeLong(l);
            return;
        }
        catch (IOException iOException) {
            throw new VersionedParcel.ParcelException((Throwable)iOException);
        }
    }

    public void writeParcelable(Parcelable parcelable) {
        if (!this.mIgnoreParcelables) throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    /*
     * Unable to fully structure code
     */
    public void writeString(String var1_1) {
        if (var1_1 == null) ** GOTO lbl7
        try {
            block2: {
                var1_1 = var1_1.getBytes(VersionedParcelStream.UTF_16);
                this.mCurrentOutput.writeInt(((Object)var1_1).length);
                this.mCurrentOutput.write((byte[])var1_1);
                break block2;
lbl7:
                // 1 sources

                this.mCurrentOutput.writeInt(-1);
            }
            return;
        }
        catch (IOException var1_2) {
            throw new VersionedParcel.ParcelException((Throwable)var1_2);
        }
    }

    public void writeStrongBinder(IBinder iBinder) {
        if (!this.mIgnoreParcelables) throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    public void writeStrongInterface(IInterface iInterface) {
        if (!this.mIgnoreParcelables) throw new RuntimeException("Binders cannot be written to an OutputStream");
    }
}
