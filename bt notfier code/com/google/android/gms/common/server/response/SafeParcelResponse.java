/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelable
 *  com.google.android.gms.common.server.response.FastJsonResponse
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 *  com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
 *  com.google.android.gms.common.server.response.zan
 *  com.google.android.gms.common.server.response.zaq
 *  com.google.android.gms.common.util.Base64Utils
 *  com.google.android.gms.common.util.JsonUtils
 *  com.google.android.gms.common.util.MapUtils
 */
package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.common.server.response.zan;
import com.google.android.gms.common.server.response.zaq;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SafeParcelResponse
extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();
    private final int zaa;
    private final Parcel zab;
    private final int zac;
    private final zan zad;
    private final String zae;
    private int zaf;
    private int zag;

    SafeParcelResponse(int n, Parcel object, zan zan2) {
        this.zaa = n;
        this.zab = (Parcel)Preconditions.checkNotNull((Object)object);
        this.zac = 2;
        this.zad = zan2;
        object = zan2 == null ? null : zan2.zaf();
        this.zae = object;
        this.zaf = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zan2, String string) {
        Parcel parcel;
        this.zaa = 1;
        this.zab = parcel = Parcel.obtain();
        safeParcelable.writeToParcel(parcel, 0);
        this.zac = 1;
        this.zad = (zan)Preconditions.checkNotNull((Object)zan2);
        this.zae = (String)Preconditions.checkNotNull((Object)string);
        this.zaf = 2;
    }

    public SafeParcelResponse(zan zan2, String string) {
        this.zaa = 1;
        this.zab = Parcel.obtain();
        this.zac = 0;
        this.zad = (zan)Preconditions.checkNotNull((Object)zan2);
        this.zae = (String)Preconditions.checkNotNull((Object)string);
        this.zaf = 0;
    }

    public static <T extends FastJsonResponse> SafeParcelResponse from(T t) {
        String string = (String)Preconditions.checkNotNull((Object)t.getClass().getCanonicalName());
        zan zan2 = new zan(t.getClass());
        SafeParcelResponse.zaF(zan2, t);
        zan2.zab();
        zan2.zaa();
        return new SafeParcelResponse((SafeParcelable)t, zan2, string);
    }

    private static void zaF(zan object, FastJsonResponse fastJsonResponse) {
        Class clazz = fastJsonResponse.getClass();
        if (object.zae(clazz)) return;
        Map map = fastJsonResponse.getFieldMappings();
        object.zac(clazz, map);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            fastJsonResponse = (FastJsonResponse.Field)map.get((String)iterator.next());
            clazz = fastJsonResponse.zag;
            if (clazz == null) continue;
            try {
                SafeParcelResponse.zaF((zan)object, (FastJsonResponse)clazz.newInstance());
            }
            catch (IllegalAccessException illegalAccessException) {
                object = String.valueOf(((Class)Preconditions.checkNotNull((Object)fastJsonResponse.zag)).getCanonicalName());
                object = ((String)object).length() != 0 ? "Could not access object of type ".concat((String)object) : new String("Could not access object of type ");
                throw new IllegalStateException((String)object, illegalAccessException);
            }
            catch (InstantiationException instantiationException) {
                object = String.valueOf(((Class)Preconditions.checkNotNull((Object)fastJsonResponse.zag)).getCanonicalName());
                object = ((String)object).length() != 0 ? "Could not instantiate an object of type ".concat((String)object) : new String("Could not instantiate an object of type ");
                throw new IllegalStateException((String)object, instantiationException);
            }
        }
    }

    private final void zaG(FastJsonResponse.Field<?, ?> parcel) {
        if (parcel.zaf == -1) throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        parcel = this.zab;
        if (parcel == null) throw new IllegalStateException("Internal Parcel object is null.");
        int n = this.zaf;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            return;
        }
        this.zag = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        this.zaf = 1;
    }

    /*
     * Exception decompiling
     */
    private final void zaH(StringBuilder var1_1, Map<String, FastJsonResponse.Field<?, ?>> var2_2, Parcel var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static final void zaI(StringBuilder stringBuilder, int n, Object object) {
        switch (n) {
            default: {
                stringBuilder = new StringBuilder(26);
                stringBuilder.append("Unknown type = ");
                stringBuilder.append(n);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 11: {
                throw new IllegalArgumentException("Method does not accept concrete type.");
            }
            case 10: {
                MapUtils.writeStringMapToJson((StringBuilder)stringBuilder, (HashMap)((HashMap)Preconditions.checkNotNull((Object)object)));
                return;
            }
            case 9: {
                stringBuilder.append("\"");
                stringBuilder.append(Base64Utils.encodeUrlSafe((byte[])((byte[])object)));
                stringBuilder.append("\"");
                return;
            }
            case 8: {
                stringBuilder.append("\"");
                stringBuilder.append(Base64Utils.encode((byte[])((byte[])object)));
                stringBuilder.append("\"");
                return;
            }
            case 7: {
                stringBuilder.append("\"");
                stringBuilder.append(JsonUtils.escapeString((String)Preconditions.checkNotNull((Object)object).toString()));
                stringBuilder.append("\"");
                return;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
        }
        stringBuilder.append(object);
    }

    private static final void zaJ(StringBuilder stringBuilder, FastJsonResponse.Field<?, ?> field, Object object) {
        if (!field.zab) {
            SafeParcelResponse.zaI(stringBuilder, field.zaa, object);
            return;
        }
        object = (ArrayList)object;
        stringBuilder.append("[");
        int n = ((ArrayList)object).size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append("]");
                return;
            }
            if (n2 != 0) {
                stringBuilder.append(",");
            }
            SafeParcelResponse.zaI(stringBuilder, field.zaa, ((ArrayList)object).get(n2));
            ++n2;
        }
    }

    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String object, ArrayList<T> arrayList) {
        this.zaG(field);
        object = new ArrayList();
        ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        int n = arrayList.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeParcelList((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (List)object, (boolean)true);
                return;
            }
            ((ArrayList)object).add(((SafeParcelResponse)((FastJsonResponse)arrayList.get(n2))).zaE());
            ++n2;
        }
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field field, String string, T t) {
        this.zaG(field);
        string = ((SafeParcelResponse)t).zaE();
        SafeParcelWriter.writeParcel((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (Parcel)string, (boolean)true);
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zan2 = this.zad;
        if (zan2 != null) return zan2.zad((String)Preconditions.checkNotNull((Object)this.zae));
        return null;
    }

    public final Object getValueObject(String string) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean isPrimitiveFieldSet(String string) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected final void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String string, boolean bl) {
        this.zaG(field);
        SafeParcelWriter.writeBoolean((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (boolean)bl);
    }

    protected final void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String string, byte[] byArray) {
        this.zaG(field);
        SafeParcelWriter.writeByteArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (byte[])byArray, (boolean)true);
    }

    protected final void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String string, int n) {
        this.zaG(field);
        SafeParcelWriter.writeInt((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (int)n);
    }

    protected final void setLongInternal(FastJsonResponse.Field<?, ?> field, String string, long l) {
        this.zaG(field);
        SafeParcelWriter.writeLong((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (long)l);
    }

    protected final void setStringInternal(FastJsonResponse.Field<?, ?> field, String string, String string2) {
        this.zaG(field);
        SafeParcelWriter.writeString((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (String)string2, (boolean)true);
    }

    protected final void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String string, Map<String, String> map) {
        this.zaG(field);
        string = new Bundle();
        Iterator iterator = ((Map)Preconditions.checkNotNull(map)).keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                SafeParcelWriter.writeBundle((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (Bundle)string, (boolean)true);
                return;
            }
            String string2 = (String)iterator.next();
            string.putString(string2, map.get(string2));
        }
    }

    protected final void setStringsInternal(FastJsonResponse.Field<?, ?> field, String stringArray, ArrayList<String> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        stringArray = new String[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeStringArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (String[])stringArray, (boolean)true);
                return;
            }
            stringArray[n2] = arrayList.get(n2);
            ++n2;
        }
    }

    public final String toString() {
        Preconditions.checkNotNull((Object)this.zad, (Object)"Cannot convert to JSON on client side.");
        Parcel parcel = this.zaE();
        parcel.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        this.zaH(stringBuilder, (Map)Preconditions.checkNotNull((Object)this.zad.zad((String)Preconditions.checkNotNull((Object)this.zae))), parcel);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeParcel((Parcel)parcel, (int)2, (Parcel)this.zaE(), (boolean)false);
        int n3 = this.zac;
        zan zan2 = n3 != 0 ? (n3 != 1 ? this.zad : this.zad) : null;
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)zan2, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    protected final void zaA(FastJsonResponse.Field<?, ?> field, String string, BigDecimal bigDecimal) {
        this.zaG(field);
        SafeParcelWriter.writeBigDecimal((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (BigDecimal)bigDecimal, (boolean)true);
    }

    protected final void zaB(FastJsonResponse.Field<?, ?> field, String bigDecimalArray, ArrayList<BigDecimal> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        bigDecimalArray = new BigDecimal[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeBigDecimalArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (BigDecimal[])bigDecimalArray, (boolean)true);
                return;
            }
            bigDecimalArray[n2] = arrayList.get(n2);
            ++n2;
        }
    }

    protected final void zaC(FastJsonResponse.Field<?, ?> field, String object, ArrayList<Boolean> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        object = new boolean[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeBooleanArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (boolean[])object, (boolean)true);
                return;
            }
            object[n2] = arrayList.get(n2);
            ++n2;
        }
    }

    public final Parcel zaE() {
        int n = this.zaf;
        if (n != 0) {
            if (n != 1) return this.zab;
            SafeParcelWriter.finishObjectHeader((Parcel)this.zab, (int)this.zag);
            this.zaf = 2;
        } else {
            this.zag = n = SafeParcelWriter.beginObjectHeader((Parcel)this.zab);
            SafeParcelWriter.finishObjectHeader((Parcel)this.zab, (int)n);
            this.zaf = 2;
        }
        return this.zab;
    }

    protected final void zas(FastJsonResponse.Field<?, ?> field, String object, ArrayList<Integer> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        object = new int[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeIntArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (int[])object, (boolean)true);
                return;
            }
            object[n2] = arrayList.get(n2);
            ++n2;
        }
    }

    protected final void zat(FastJsonResponse.Field<?, ?> field, String string, BigInteger bigInteger) {
        this.zaG(field);
        SafeParcelWriter.writeBigInteger((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (BigInteger)bigInteger, (boolean)true);
    }

    protected final void zau(FastJsonResponse.Field<?, ?> field, String bigIntegerArray, ArrayList<BigInteger> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        bigIntegerArray = new BigInteger[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeBigIntegerArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (BigInteger[])bigIntegerArray, (boolean)true);
                return;
            }
            bigIntegerArray[n2] = arrayList.get(n2);
            ++n2;
        }
    }

    protected final void zav(FastJsonResponse.Field<?, ?> field, String object, ArrayList<Long> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        object = new long[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeLongArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (long[])object, (boolean)true);
                return;
            }
            object[n2] = arrayList.get(n2);
            ++n2;
        }
    }

    protected final void zaw(FastJsonResponse.Field<?, ?> field, String string, float f) {
        this.zaG(field);
        SafeParcelWriter.writeFloat((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (float)f);
    }

    protected final void zax(FastJsonResponse.Field<?, ?> field, String object, ArrayList<Float> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        object = new float[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeFloatArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (float[])object, (boolean)true);
                return;
            }
            object[n2] = arrayList.get(n2).floatValue();
            ++n2;
        }
    }

    protected final void zay(FastJsonResponse.Field<?, ?> field, String string, double d) {
        this.zaG(field);
        SafeParcelWriter.writeDouble((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (double)d);
    }

    protected final void zaz(FastJsonResponse.Field<?, ?> field, String object, ArrayList<Double> arrayList) {
        this.zaG(field);
        int n = ((ArrayList)Preconditions.checkNotNull(arrayList)).size();
        object = new double[n];
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                SafeParcelWriter.writeDoubleArray((Parcel)this.zab, (int)field.getSafeParcelableFieldId(), (double[])object, (boolean)true);
                return;
            }
            object[n2] = arrayList.get(n2);
            ++n2;
        }
    }
}
