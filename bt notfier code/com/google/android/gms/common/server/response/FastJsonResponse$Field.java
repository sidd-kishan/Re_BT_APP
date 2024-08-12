/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Objects$ToStringHelper
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.converter.zaa
 *  com.google.android.gms.common.server.response.FastJsonResponse
 *  com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
 *  com.google.android.gms.common.server.response.SafeParcelResponse
 *  com.google.android.gms.common.server.response.zaj
 *  com.google.android.gms.common.server.response.zan
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zaj;
import com.google.android.gms.common.server.response.zan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public static class FastJsonResponse.Field<I, O>
extends AbstractSafeParcelable {
    public static final zaj CREATOR = new zaj();
    protected final int zaa;
    protected final boolean zab;
    protected final int zac;
    protected final boolean zad;
    protected final String zae;
    protected final int zaf;
    protected final Class<? extends FastJsonResponse> zag;
    protected final String zah;
    private final int zai;
    private zan zaj;
    private FastJsonResponse.FieldConverter<I, O> zak;

    FastJsonResponse.Field(int n, int n2, boolean bl, int n3, boolean bl2, String string, int n4, String string2, zaa zaa2) {
        this.zai = n;
        this.zaa = n2;
        this.zab = bl;
        this.zac = n3;
        this.zad = bl2;
        this.zae = string;
        this.zaf = n4;
        if (string2 == null) {
            this.zag = null;
            this.zah = null;
        } else {
            this.zag = SafeParcelResponse.class;
            this.zah = string2;
        }
        if (zaa2 == null) {
            this.zak = null;
            return;
        }
        this.zak = zaa2.zab();
    }

    protected FastJsonResponse.Field(int n, boolean bl, int n2, boolean bl2, String string, int n3, Class<? extends FastJsonResponse> clazz, FastJsonResponse.FieldConverter<I, O> fieldConverter) {
        this.zai = 1;
        this.zaa = n;
        this.zab = bl;
        this.zac = n2;
        this.zad = bl2;
        this.zae = string;
        this.zaf = n3;
        this.zag = clazz;
        this.zah = clazz == null ? null : clazz.getCanonicalName();
        this.zak = fieldConverter;
    }

    public static FastJsonResponse.Field<byte[], byte[]> forBase64(String string, int n) {
        return new FastJsonResponse.Field<byte[], byte[]>(8, false, 8, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<Boolean, Boolean> forBoolean(String string, int n) {
        return new FastJsonResponse.Field<Boolean, Boolean>(6, false, 6, false, string, n, null, null);
    }

    public static <T extends FastJsonResponse> FastJsonResponse.Field<T, T> forConcreteType(String string, int n, Class<T> clazz) {
        return new FastJsonResponse.Field(11, false, 11, false, string, n, clazz, null);
    }

    public static <T extends FastJsonResponse> FastJsonResponse.Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String string, int n, Class<T> clazz) {
        return new FastJsonResponse.Field<ArrayList<T>, ArrayList<T>>(11, true, 11, true, string, n, clazz, null);
    }

    public static FastJsonResponse.Field<Double, Double> forDouble(String string, int n) {
        return new FastJsonResponse.Field<Double, Double>(4, false, 4, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<Float, Float> forFloat(String string, int n) {
        return new FastJsonResponse.Field<Float, Float>(3, false, 3, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<Integer, Integer> forInteger(String string, int n) {
        return new FastJsonResponse.Field<Integer, Integer>(0, false, 0, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<Long, Long> forLong(String string, int n) {
        return new FastJsonResponse.Field<Long, Long>(2, false, 2, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<String, String> forString(String string, int n) {
        return new FastJsonResponse.Field<String, String>(7, false, 7, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String string, int n) {
        return new FastJsonResponse.Field<HashMap<String, String>, HashMap<String, String>>(10, false, 10, false, string, n, null, null);
    }

    public static FastJsonResponse.Field<ArrayList<String>, ArrayList<String>> forStrings(String string, int n) {
        return new FastJsonResponse.Field<ArrayList<String>, ArrayList<String>>(7, true, 7, true, string, n, null, null);
    }

    public static FastJsonResponse.Field withConverter(String string, int n, FastJsonResponse.FieldConverter<?, ?> fieldConverter, boolean bl) {
        fieldConverter.zaa();
        fieldConverter.zab();
        return new FastJsonResponse.Field(7, bl, 0, false, string, n, null, fieldConverter);
    }

    static /* synthetic */ FastJsonResponse.FieldConverter zaj(FastJsonResponse.Field field) {
        return field.zak;
    }

    public int getSafeParcelableFieldId() {
        return this.zaf;
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper((Object)((Object)this)).add("versionCode", (Object)this.zai).add("typeIn", (Object)this.zaa).add("typeInArray", (Object)this.zab).add("typeOut", (Object)this.zac).add("typeOutArray", (Object)this.zad).add("outputFieldName", (Object)this.zae).add("safeParcelFieldId", (Object)this.zaf).add("concreteTypeName", (Object)this.zab());
        Class<? extends FastJsonResponse> clazz = this.zag;
        if (clazz != null) {
            toStringHelper.add("concreteType.class", (Object)clazz.getCanonicalName());
        }
        if ((clazz = this.zak) == null) return toStringHelper.toString();
        toStringHelper.add("converterName", (Object)clazz.getClass().getCanonicalName());
        return toStringHelper.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zai);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zaa);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.zab);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)4, (int)this.zac);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zad);
        SafeParcelWriter.writeString((Parcel)parcel, (int)6, (String)this.zae, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)7, (int)this.getSafeParcelableFieldId());
        SafeParcelWriter.writeString((Parcel)parcel, (int)8, (String)this.zab(), (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)9, (Parcelable)this.zae(), (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final FastJsonResponse.Field<I, O> zaa() {
        return new FastJsonResponse.Field<I, O>(this.zai, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zah, this.zae());
    }

    final String zab() {
        String string;
        String string2 = string = this.zah;
        if (string != null) return string2;
        string2 = null;
        return string2;
    }

    public final boolean zac() {
        if (this.zak == null) return false;
        return true;
    }

    public final void zad(zan zan2) {
        this.zaj = zan2;
    }

    final zaa zae() {
        FastJsonResponse.FieldConverter<I, O> fieldConverter = this.zak;
        if (fieldConverter != null) return com.google.android.gms.common.server.converter.zaa.zaa(fieldConverter);
        return null;
    }

    public final FastJsonResponse zaf() throws InstantiationException, IllegalAccessException {
        Preconditions.checkNotNull(this.zag);
        Class<? extends FastJsonResponse> clazz = this.zag;
        if (clazz != SafeParcelResponse.class) return clazz.newInstance();
        Preconditions.checkNotNull((Object)this.zah);
        Preconditions.checkNotNull((Object)this.zaj, (Object)"The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
        return new SafeParcelResponse(this.zaj, this.zah);
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zag() {
        Preconditions.checkNotNull((Object)this.zah);
        Preconditions.checkNotNull((Object)this.zaj);
        return (Map)Preconditions.checkNotNull((Object)this.zaj.zad(this.zah));
    }

    public final O zah(I i) {
        Preconditions.checkNotNull(this.zak);
        return (O)Preconditions.checkNotNull((Object)this.zak.zad(i));
    }

    public final I zai(O o) {
        Preconditions.checkNotNull(this.zak);
        return (I)this.zak.zac(o);
    }
}
