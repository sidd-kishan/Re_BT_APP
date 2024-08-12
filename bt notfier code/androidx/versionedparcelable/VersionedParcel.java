/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.NetworkOnMainThreadException
 *  android.os.Parcelable
 *  android.util.Size
 *  android.util.SizeF
 *  android.util.SparseBooleanArray
 *  androidx.collection.ArrayMap
 *  androidx.collection.ArraySet
 *  androidx.versionedparcelable.VersionedParcel$1
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int n, String string) {
        switch (n) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown exception code: ");
                stringBuilder.append(n);
                stringBuilder.append(" msg ");
                stringBuilder.append(string);
                return new RuntimeException(stringBuilder.toString());
            }
            case -1: {
                return new SecurityException(string);
            }
            case -2: {
                return new BadParcelableException(string);
            }
            case -3: {
                return new IllegalArgumentException(string);
            }
            case -4: {
                return new NullPointerException(string);
            }
            case -5: {
                return new IllegalStateException(string);
            }
            case -6: {
                return new NetworkOnMainThreadException();
            }
            case -7: {
                return new UnsupportedOperationException(string);
            }
            case -9: 
        }
        return (Exception)this.readParcelable();
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> clazz) throws ClassNotFoundException {
        Class<?> clazz2;
        Class<?> clazz3 = clazz2 = (Class<?>)this.mParcelizerCache.get((Object)clazz.getName());
        if (clazz2 != null) return clazz3;
        clazz3 = Class.forName(String.format("%s.%sParcelizer", clazz.getPackage().getName(), clazz.getSimpleName()), false, clazz.getClassLoader());
        this.mParcelizerCache.put((Object)clazz.getName(), clazz3);
        return clazz3;
    }

    private Method getReadMethod(String string) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method;
        Method method2 = method = (Method)this.mReadCache.get((Object)string);
        if (method != null) return method2;
        System.currentTimeMillis();
        method2 = Class.forName(string, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put((Object)string, (Object)method2);
        return method2;
    }

    protected static Throwable getRootCause(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }

    private <T> int getType(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof VersionedParcelable) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(t.getClass().getName());
        stringBuilder.append(" cannot be VersionedParcelled");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private Method getWriteMethod(Class clazz) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = (Method)this.mWriteCache.get((Object)clazz.getName());
        GenericDeclaration genericDeclaration = method;
        if (method != null) return genericDeclaration;
        genericDeclaration = this.findParcelClass(clazz);
        System.currentTimeMillis();
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("write", clazz, VersionedParcel.class);
        this.mWriteCache.put((Object)clazz.getName(), (Object)genericDeclaration);
        return genericDeclaration;
    }

    private <T, S extends Collection<T>> S readCollection(S s) {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        if (n == 0) return s;
        int n2 = this.readInt();
        if (n < 0) {
            return null;
        }
        int n3 = n;
        if (n2 == 1) {
            while (n3 > 0) {
                s.add(this.readVersionedParcelable());
                --n3;
            }
            return s;
        }
        n3 = n;
        if (n2 == 2) {
            while (n3 > 0) {
                s.add(this.readParcelable());
                --n3;
            }
            return s;
        }
        n3 = n;
        if (n2 == 3) {
            while (n3 > 0) {
                s.add((Serializable)this.readSerializable());
                --n3;
            }
            return s;
        }
        n3 = n;
        if (n2 == 4) {
            while (n3 > 0) {
                s.add((String)this.readString());
                --n3;
            }
            return s;
        }
        if (n2 != 5) {
            return s;
        }
        while (n > 0) {
            s.add((IBinder)this.readStrongBinder());
            --n;
        }
        return s;
    }

    private Exception readException(int n, String string) {
        return this.createException(n, string);
    }

    private int readExceptionCode() {
        return this.readInt();
    }

    /*
     * Enabled force condition propagation
     */
    private <T> void writeCollection(Collection<T> iterator) {
        if (iterator == null) {
            this.writeInt(-1);
            return;
        }
        int n = iterator.size();
        this.writeInt(n);
        if (n <= 0) return;
        n = this.getType(iterator.iterator().next());
        this.writeInt(n);
        switch (n) {
            default: {
                return;
            }
            case 8: {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.writeFloat(((Float)iterator.next()).floatValue());
                }
                return;
            }
            case 7: {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.writeInt((Integer)iterator.next());
                }
                return;
            }
            case 5: {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.writeStrongBinder((IBinder)iterator.next());
                }
                return;
            }
            case 4: {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.writeString((String)iterator.next());
                }
                return;
            }
            case 3: {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.writeSerializable((Serializable)iterator.next());
                }
                return;
            }
            case 2: {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.writeParcelable((Parcelable)iterator.next());
                }
                return;
            }
            case 1: 
        }
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            this.writeVersionedParcelable((VersionedParcelable)iterator.next());
        }
    }

    private <T> void writeCollection(Collection<T> collection, int n) {
        this.setOutputField(n);
        this.writeCollection(collection);
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            this.writeString(null);
            return;
        }
        String string = serializable.getClass().getName();
        this.writeString(string);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            this.writeByteArray(byteArrayOutputStream.toByteArray());
            return;
        }
        catch (IOException iOException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("VersionedParcelable encountered IOException writing serializable object (name = ");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append(")");
            throw new RuntimeException(((StringBuilder)serializable).toString(), iOException);
        }
    }

    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            Class clazz = this.findParcelClass(versionedParcelable.getClass());
            this.writeString(clazz.getName());
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(versionedParcelable.getClass().getSimpleName());
            stringBuilder.append(" does not have a Parcelizer");
            throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
        }
    }

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    protected <T> T[] readArray(T[] TArray) {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        if (n == 0) return arrayList.toArray(TArray);
        int n2 = this.readInt();
        if (n < 0) {
            return null;
        }
        int n3 = n;
        if (n2 == 1) {
            while (n3 > 0) {
                arrayList.add(this.readVersionedParcelable());
                --n3;
            }
            return arrayList.toArray(TArray);
        }
        n3 = n;
        if (n2 == 2) {
            while (n3 > 0) {
                arrayList.add(this.readParcelable());
                --n3;
            }
            return arrayList.toArray(TArray);
        }
        n3 = n;
        if (n2 == 3) {
            while (n3 > 0) {
                arrayList.add(this.readSerializable());
                --n3;
            }
            return arrayList.toArray(TArray);
        }
        n3 = n;
        if (n2 == 4) {
            while (n3 > 0) {
                arrayList.add(this.readString());
                --n3;
            }
            return arrayList.toArray(TArray);
        }
        if (n2 != 5) {
            return arrayList.toArray(TArray);
        }
        while (n > 0) {
            arrayList.add(this.readStrongBinder());
            --n;
        }
        return arrayList.toArray(TArray);
    }

    public <T> T[] readArray(T[] TArray, int n) {
        if (this.readField(n)) return this.readArray(TArray);
        return TArray;
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean bl, int n) {
        if (this.readField(n)) return this.readBoolean();
        return bl;
    }

    protected boolean[] readBooleanArray() {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        boolean[] blArray = new boolean[n];
        int n2 = 0;
        while (n2 < n) {
            boolean bl = this.readInt() != 0;
            blArray[n2] = bl;
            ++n2;
        }
        return blArray;
    }

    public boolean[] readBooleanArray(boolean[] blArray, int n) {
        if (this.readField(n)) return this.readBooleanArray();
        return blArray;
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int n) {
        if (this.readField(n)) return this.readBundle();
        return bundle;
    }

    public byte readByte(byte by, int n) {
        if (this.readField(n)) return (byte)(this.readInt() & 0xFF);
        return by;
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] byArray, int n) {
        if (this.readField(n)) return this.readByteArray();
        return byArray;
    }

    public char[] readCharArray(char[] cArray, int n) {
        if (!this.readField(n)) {
            return cArray;
        }
        int n2 = this.readInt();
        if (n2 < 0) {
            return null;
        }
        cArray = new char[n2];
        n = 0;
        while (n < n2) {
            cArray[n] = (char)this.readInt();
            ++n;
        }
        return cArray;
    }

    protected abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int n) {
        if (this.readField(n)) return this.readCharSequence();
        return charSequence;
    }

    protected abstract double readDouble();

    public double readDouble(double d, int n) {
        if (this.readField(n)) return this.readDouble();
        return d;
    }

    protected double[] readDoubleArray() {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        double[] dArray = new double[n];
        int n2 = 0;
        while (n2 < n) {
            dArray[n2] = this.readDouble();
            ++n2;
        }
        return dArray;
    }

    public double[] readDoubleArray(double[] dArray, int n) {
        if (this.readField(n)) return this.readDoubleArray();
        return dArray;
    }

    public Exception readException(Exception exception, int n) {
        if (!this.readField(n)) {
            return exception;
        }
        n = this.readExceptionCode();
        if (n == 0) return exception;
        exception = this.readException(n, this.readString());
        return exception;
    }

    protected abstract boolean readField(int var1);

    protected abstract float readFloat();

    public float readFloat(float f, int n) {
        if (this.readField(n)) return this.readFloat();
        return f;
    }

    protected float[] readFloatArray() {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        float[] fArray = new float[n];
        int n2 = 0;
        while (n2 < n) {
            fArray[n2] = this.readFloat();
            ++n2;
        }
        return fArray;
    }

    public float[] readFloatArray(float[] fArray, int n) {
        if (this.readField(n)) return this.readFloatArray();
        return fArray;
    }

    protected <T extends VersionedParcelable> T readFromParcel(String string, VersionedParcel versionedParcel) {
        try {
            string = (VersionedParcelable)this.getReadMethod(string).invoke(null, versionedParcel);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (!(invocationTargetException.getCause() instanceof RuntimeException)) throw new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
            throw (RuntimeException)invocationTargetException.getCause();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
        }
        return (T)string;
    }

    protected abstract int readInt();

    public int readInt(int n, int n2) {
        if (this.readField(n2)) return this.readInt();
        return n;
    }

    protected int[] readIntArray() {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        int[] nArray = new int[n];
        int n2 = 0;
        while (n2 < n) {
            nArray[n2] = this.readInt();
            ++n2;
        }
        return nArray;
    }

    public int[] readIntArray(int[] nArray, int n) {
        if (this.readField(n)) return this.readIntArray();
        return nArray;
    }

    public <T> List<T> readList(List<T> list, int n) {
        if (this.readField(n)) return this.readCollection(new ArrayList());
        return list;
    }

    protected abstract long readLong();

    public long readLong(long l, int n) {
        if (this.readField(n)) return this.readLong();
        return l;
    }

    protected long[] readLongArray() {
        int n = this.readInt();
        if (n < 0) {
            return null;
        }
        long[] lArray = new long[n];
        int n2 = 0;
        while (n2 < n) {
            lArray[n2] = this.readLong();
            ++n2;
        }
        return lArray;
    }

    public long[] readLongArray(long[] lArray, int n) {
        if (this.readField(n)) return this.readLongArray();
        return lArray;
    }

    public <K, V> Map<K, V> readMap(Map<K, V> arrayMap, int n) {
        if (!this.readField(n)) {
            return arrayMap;
        }
        int n2 = this.readInt();
        if (n2 < 0) {
            return null;
        }
        arrayMap = new ArrayMap();
        if (n2 == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.readCollection(arrayList);
        this.readCollection(arrayList2);
        n = 0;
        while (n < n2) {
            arrayMap.put(arrayList.get(n), arrayList2.get(n));
            ++n;
        }
        return arrayMap;
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t, int n) {
        if (this.readField(n)) return this.readParcelable();
        return t;
    }

    protected Serializable readSerializable() {
        String string = this.readString();
        if (string == null) {
            return null;
        }
        Object object = new ByteArrayInputStream(this.readByteArray());
        try {
            1 var3_4 = new /* Unavailable Anonymous Inner Class!! */;
            object = (Serializable)var3_4.readObject();
            return object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(")");
            throw new RuntimeException(((StringBuilder)object).toString(), classNotFoundException);
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VersionedParcelable encountered IOException reading a Serializable object (name = ");
            stringBuilder.append(string);
            stringBuilder.append(")");
            throw new RuntimeException(stringBuilder.toString(), iOException);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int n) {
        if (this.readField(n)) return (Set)this.readCollection(new ArraySet());
        return set;
    }

    public Size readSize(Size size, int n) {
        if (!this.readField(n)) {
            return size;
        }
        if (!this.readBoolean()) return null;
        return new Size(this.readInt(), this.readInt());
    }

    public SizeF readSizeF(SizeF sizeF, int n) {
        if (!this.readField(n)) {
            return sizeF;
        }
        if (!this.readBoolean()) return null;
        return new SizeF(this.readFloat(), this.readFloat());
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int n) {
        if (!this.readField(n)) {
            return sparseBooleanArray;
        }
        int n2 = this.readInt();
        if (n2 < 0) {
            return null;
        }
        sparseBooleanArray = new SparseBooleanArray(n2);
        n = 0;
        while (n < n2) {
            sparseBooleanArray.put(this.readInt(), this.readBoolean());
            ++n;
        }
        return sparseBooleanArray;
    }

    protected abstract String readString();

    public String readString(String string, int n) {
        if (this.readField(n)) return this.readString();
        return string;
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int n) {
        if (this.readField(n)) return this.readStrongBinder();
        return iBinder;
    }

    protected <T extends VersionedParcelable> T readVersionedParcelable() {
        String string = this.readString();
        if (string != null) return this.readFromParcel(string, this.createSubParcel());
        return null;
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t, int n) {
        if (this.readField(n)) return this.readVersionedParcelable();
        return t;
    }

    protected abstract void setOutputField(int var1);

    public void setSerializationFlags(boolean bl, boolean bl2) {
    }

    protected <T> void writeArray(T[] TArray) {
        if (TArray == null) {
            this.writeInt(-1);
            return;
        }
        int n = TArray.length;
        this.writeInt(n);
        if (n <= 0) return;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = this.getType(TArray[0]);
        this.writeInt(n7);
        if (n7 == 1) {
            while (n5 < n) {
                this.writeVersionedParcelable((VersionedParcelable)TArray[n5]);
                ++n5;
            }
            return;
        }
        n5 = n4;
        if (n7 == 2) {
            while (n5 < n) {
                this.writeParcelable((Parcelable)TArray[n5]);
                ++n5;
            }
            return;
        }
        n5 = n3;
        if (n7 == 3) {
            while (n5 < n) {
                this.writeSerializable((Serializable)TArray[n5]);
                ++n5;
            }
            return;
        }
        n5 = n2;
        if (n7 == 4) {
            while (n5 < n) {
                this.writeString((String)TArray[n5]);
                ++n5;
            }
            return;
        }
        n5 = n6;
        if (n7 != 5) {
            return;
        }
        while (n5 < n) {
            this.writeStrongBinder((IBinder)TArray[n5]);
            ++n5;
        }
    }

    public <T> void writeArray(T[] TArray, int n) {
        this.setOutputField(n);
        this.writeArray(TArray);
    }

    protected abstract void writeBoolean(boolean var1);

    public void writeBoolean(boolean bl, int n) {
        this.setOutputField(n);
        this.writeBoolean(bl);
    }

    protected void writeBooleanArray(boolean[] blArray) {
        if (blArray == null) {
            this.writeInt(-1);
            return;
        }
        int n = blArray.length;
        this.writeInt(n);
        int n2 = 0;
        while (n2 < n) {
            this.writeInt(blArray[n2]);
            ++n2;
        }
    }

    public void writeBooleanArray(boolean[] blArray, int n) {
        this.setOutputField(n);
        this.writeBooleanArray(blArray);
    }

    protected abstract void writeBundle(Bundle var1);

    public void writeBundle(Bundle bundle, int n) {
        this.setOutputField(n);
        this.writeBundle(bundle);
    }

    public void writeByte(byte by, int n) {
        this.setOutputField(n);
        this.writeInt(by);
    }

    protected abstract void writeByteArray(byte[] var1);

    public void writeByteArray(byte[] byArray, int n) {
        this.setOutputField(n);
        this.writeByteArray(byArray);
    }

    protected abstract void writeByteArray(byte[] var1, int var2, int var3);

    public void writeByteArray(byte[] byArray, int n, int n2, int n3) {
        this.setOutputField(n3);
        this.writeByteArray(byArray, n, n2);
    }

    public void writeCharArray(char[] cArray, int n) {
        this.setOutputField(n);
        if (cArray == null) {
            this.writeInt(-1);
            return;
        }
        int n2 = cArray.length;
        this.writeInt(n2);
        n = 0;
        while (n < n2) {
            this.writeInt(cArray[n]);
            ++n;
        }
    }

    protected abstract void writeCharSequence(CharSequence var1);

    public void writeCharSequence(CharSequence charSequence, int n) {
        this.setOutputField(n);
        this.writeCharSequence(charSequence);
    }

    protected abstract void writeDouble(double var1);

    public void writeDouble(double d, int n) {
        this.setOutputField(n);
        this.writeDouble(d);
    }

    protected void writeDoubleArray(double[] dArray) {
        if (dArray == null) {
            this.writeInt(-1);
            return;
        }
        int n = dArray.length;
        this.writeInt(n);
        int n2 = 0;
        while (n2 < n) {
            this.writeDouble(dArray[n2]);
            ++n2;
        }
    }

    public void writeDoubleArray(double[] dArray, int n) {
        this.setOutputField(n);
        this.writeDoubleArray(dArray);
    }

    public void writeException(Exception exception, int n) {
        this.setOutputField(n);
        if (exception == null) {
            this.writeNoException();
            return;
        }
        n = 0;
        if (exception instanceof Parcelable && exception.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            n = -9;
        } else if (exception instanceof SecurityException) {
            n = -1;
        } else if (exception instanceof BadParcelableException) {
            n = -2;
        } else if (exception instanceof IllegalArgumentException) {
            n = -3;
        } else if (exception instanceof NullPointerException) {
            n = -4;
        } else if (exception instanceof IllegalStateException) {
            n = -5;
        } else if (exception instanceof NetworkOnMainThreadException) {
            n = -6;
        } else if (exception instanceof UnsupportedOperationException) {
            n = -7;
        }
        this.writeInt(n);
        if (n == 0) {
            if (!(exception instanceof RuntimeException)) throw new RuntimeException(exception);
            throw (RuntimeException)exception;
        }
        this.writeString(exception.getMessage());
        if (n != -9) return;
        this.writeParcelable((Parcelable)exception);
    }

    protected abstract void writeFloat(float var1);

    public void writeFloat(float f, int n) {
        this.setOutputField(n);
        this.writeFloat(f);
    }

    protected void writeFloatArray(float[] fArray) {
        if (fArray == null) {
            this.writeInt(-1);
            return;
        }
        int n = fArray.length;
        this.writeInt(n);
        int n2 = 0;
        while (n2 < n) {
            this.writeFloat(fArray[n2]);
            ++n2;
        }
    }

    public void writeFloatArray(float[] fArray, int n) {
        this.setOutputField(n);
        this.writeFloatArray(fArray);
    }

    protected abstract void writeInt(int var1);

    public void writeInt(int n, int n2) {
        this.setOutputField(n2);
        this.writeInt(n);
    }

    protected void writeIntArray(int[] nArray) {
        if (nArray == null) {
            this.writeInt(-1);
            return;
        }
        int n = nArray.length;
        this.writeInt(n);
        int n2 = 0;
        while (n2 < n) {
            this.writeInt(nArray[n2]);
            ++n2;
        }
    }

    public void writeIntArray(int[] nArray, int n) {
        this.setOutputField(n);
        this.writeIntArray(nArray);
    }

    public <T> void writeList(List<T> list, int n) {
        this.writeCollection(list, n);
    }

    protected abstract void writeLong(long var1);

    public void writeLong(long l, int n) {
        this.setOutputField(n);
        this.writeLong(l);
    }

    protected void writeLongArray(long[] lArray) {
        if (lArray == null) {
            this.writeInt(-1);
            return;
        }
        int n = lArray.length;
        this.writeInt(n);
        int n2 = 0;
        while (n2 < n) {
            this.writeLong(lArray[n2]);
            ++n2;
        }
    }

    public void writeLongArray(long[] lArray, int n) {
        this.setOutputField(n);
        this.writeLongArray(lArray);
    }

    public <K, V> void writeMap(Map<K, V> object, int n) {
        this.setOutputField(n);
        if (object == null) {
            this.writeInt(-1);
            return;
        }
        n = object.size();
        this.writeInt(n);
        if (n == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<K, V>> iterator = object.entrySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.writeCollection(arrayList);
                this.writeCollection(arrayList2);
                return;
            }
            object = iterator.next();
            arrayList.add(object.getKey());
            arrayList2.add(object.getValue());
        }
    }

    protected void writeNoException() {
        this.writeInt(0);
    }

    protected abstract void writeParcelable(Parcelable var1);

    public void writeParcelable(Parcelable parcelable, int n) {
        this.setOutputField(n);
        this.writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int n) {
        this.setOutputField(n);
        this.writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int n) {
        this.writeCollection(set, n);
    }

    public void writeSize(Size size, int n) {
        this.setOutputField(n);
        boolean bl = size != null;
        this.writeBoolean(bl);
        if (size == null) return;
        this.writeInt(size.getWidth());
        this.writeInt(size.getHeight());
    }

    public void writeSizeF(SizeF sizeF, int n) {
        this.setOutputField(n);
        boolean bl = sizeF != null;
        this.writeBoolean(bl);
        if (sizeF == null) return;
        this.writeFloat(sizeF.getWidth());
        this.writeFloat(sizeF.getHeight());
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int n) {
        this.setOutputField(n);
        if (sparseBooleanArray == null) {
            this.writeInt(-1);
            return;
        }
        int n2 = sparseBooleanArray.size();
        this.writeInt(n2);
        n = 0;
        while (n < n2) {
            this.writeInt(sparseBooleanArray.keyAt(n));
            this.writeBoolean(sparseBooleanArray.valueAt(n));
            ++n;
        }
    }

    protected abstract void writeString(String var1);

    public void writeString(String string, int n) {
        this.setOutputField(n);
        this.writeString(string);
    }

    protected abstract void writeStrongBinder(IBinder var1);

    public void writeStrongBinder(IBinder iBinder, int n) {
        this.setOutputField(n);
        this.writeStrongBinder(iBinder);
    }

    protected abstract void writeStrongInterface(IInterface var1);

    public void writeStrongInterface(IInterface iInterface, int n) {
        this.setOutputField(n);
        this.writeStrongInterface(iInterface);
    }

    protected <T extends VersionedParcelable> void writeToParcel(T t, VersionedParcel versionedParcel) {
        try {
            this.getWriteMethod(t.getClass()).invoke(null, t, versionedParcel);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (!(invocationTargetException.getCause() instanceof RuntimeException)) throw new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
            throw (RuntimeException)invocationTargetException.getCause();
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
        }
    }

    protected void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            this.writeString(null);
            return;
        }
        this.writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel versionedParcel = this.createSubParcel();
        this.writeToParcel(versionedParcelable, versionedParcel);
        versionedParcel.closeField();
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int n) {
        this.setOutputField(n);
        this.writeVersionedParcelable(versionedParcelable);
    }
}
