/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Log
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public abstract class zzzn<K, V> {
    private static final String zza = zzzn.class.getSimpleName();

    protected static <K, V> HashMap<K, V> zzb(String object) {
        try {
            if (TextUtils.isEmpty((CharSequence)object)) return null;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode((byte[])((String)object).getBytes(), (int)0));
            object = new ObjectInputStream(byteArrayInputStream);
            object = (HashMap)((ObjectInputStream)object).readObject();
            return object;
        }
        catch (IOException | ClassNotFoundException exception) {
            Log.d((String)zza, (String)"decode object failure");
        }
        return null;
    }

    public final String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Object object = new ObjectOutputStream(byteArrayOutputStream);
            ((ObjectOutputStream)object).writeObject(this.zza());
            ((ObjectOutputStream)object).close();
            object = Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)0);
            return object;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    protected abstract HashMap<K, V> zza();
}
