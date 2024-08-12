/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelable
 *  com.google.android.gms.common.util.Base64Utils
 *  com.google.android.gms.internal.common.zzu
 */
package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzu;
import java.util.ArrayList;
import java.util.List;

public final class SafeParcelableSerializer {
    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] object, Parcelable.Creator<T> creator) {
        Preconditions.checkNotNull(creator);
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(object, 0, ((byte[])object).length);
        parcel.setDataPosition(0);
        object = (SafeParcelable)creator.createFromParcel(parcel);
        parcel.recycle();
        return (T)object;
    }

    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent object, String string, Parcelable.Creator<T> creator) {
        if ((object = (Object)object.getByteArrayExtra(string)) != null) return SafeParcelableSerializer.deserializeFromBytes((byte[])object, creator);
        return null;
    }

    public static <T extends SafeParcelable> T deserializeFromString(String string, Parcelable.Creator<T> creator) {
        return SafeParcelableSerializer.deserializeFromBytes(Base64Utils.decodeUrlSafe((String)string), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle object, String object2, Parcelable.Creator<T> creator) {
        if ((object = (ArrayList)object.getSerializable((String)object2)) == null) {
            return null;
        }
        object2 = new ArrayList(((ArrayList)object).size());
        int n = object.size();
        int n2 = 0;
        while (n2 < n) {
            ((ArrayList)object2).add(SafeParcelableSerializer.deserializeFromBytes((byte[])object.get(n2), creator));
            ++n2;
        }
        return object2;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(Bundle bundle, String string, Parcelable.Creator<T> creator) {
        return SafeParcelableSerializer.deserializeIterableFromBytes(bundle.getByteArray(string), creator);
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(byte[] object, Parcelable.Creator<T> creator) {
        if (object == null) {
            return null;
        }
        int n = ((byte[])object).length;
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(object, 0, n);
        parcel.setDataPosition(0);
        try {
            object = new ArrayList;
            object();
            parcel.readTypedList((List)object, creator);
            return object;
        }
        finally {
            parcel.recycle();
        }
    }

    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent object, String object2, Parcelable.Creator<T> creator) {
        if ((object2 = (ArrayList)object.getSerializableExtra((String)object2)) == null) {
            return null;
        }
        object = new ArrayList(((ArrayList)object2).size());
        int n = object2.size();
        int n2 = 0;
        while (n2 < n) {
            ((ArrayList)object).add(SafeParcelableSerializer.deserializeFromBytes((byte[])object2.get(n2), creator));
            ++n2;
        }
        return object;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(Intent intent, String string, Parcelable.Creator<T> creator) {
        return SafeParcelableSerializer.deserializeIterableFromBytes(intent.getByteArrayExtra(string), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> object, Bundle bundle, String string) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                bundle.putSerializable(string, arrayList);
                return;
            }
            arrayList.add(SafeParcelableSerializer.serializeToBytes((SafeParcelable)object.next()));
        }
    }

    public static <T extends SafeParcelable> void serializeIterableToBundleSafe(Iterable<T> iterable, Bundle bundle, String string) {
        bundle.putByteArray(string, SafeParcelableSerializer.zza(iterable));
    }

    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> object, Intent intent, String string) {
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                intent.putExtra(string, arrayList);
                return;
            }
            arrayList.add(SafeParcelableSerializer.serializeToBytes((SafeParcelable)object.next()));
        }
    }

    public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(Iterable<T> iterable, Intent intent, String string) {
        intent.putExtra(string, SafeParcelableSerializer.zza(iterable));
    }

    public static <T extends SafeParcelable> byte[] serializeToBytes(T object) {
        Parcel parcel = Parcel.obtain();
        object.writeToParcel(parcel, 0);
        object = parcel.marshall();
        parcel.recycle();
        return object;
    }

    public static <T extends SafeParcelable> void serializeToIntentExtra(T t, Intent intent, String string) {
        intent.putExtra(string, SafeParcelableSerializer.serializeToBytes(t));
    }

    public static <T extends SafeParcelable> String serializeToString(T t) {
        return Base64Utils.encodeUrlSafe((byte[])SafeParcelableSerializer.serializeToBytes(t));
    }

    private static <T extends SafeParcelable> byte[] zza(Iterable<T> object) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeTypedList((List)zzu.zzl(object));
            object = parcel.marshall();
            return object;
        }
        finally {
            parcel.recycle();
        }
    }
}
