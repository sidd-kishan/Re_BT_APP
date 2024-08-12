/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.measurement.internal.zzfh
 */
package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfh;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class zzhx {
    public static String zza(Context context, String string, String string2) {
        Preconditions.checkNotNull((Object)context);
        string = context.getResources();
        if (!TextUtils.isEmpty((CharSequence)string2)) return zzfh.zzb((String)"google_app_id", (Resources)string, (String)string2);
        string2 = zzfh.zza((Context)context);
        return zzfh.zzb((String)"google_app_id", (Resources)string, (String)string2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static Object zzb(Object object) {
        if (object == null) return null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        object = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream((InputStream)object);
        {
            catch (Throwable throwable) {
                objectInputStream = null;
                break block9;
            }
        }
        object = objectInputStream.readObject();
        {
            catch (Throwable throwable) {
                break block9;
            }
        }
        try {
            void var0_4;
            block9: {
                objectOutputStream.close();
                objectInputStream.close();
                return object;
                catch (Throwable throwable) {
                    objectInputStream = null;
                    objectOutputStream = null;
                }
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream == null) throw var0_4;
            objectInputStream.close();
            throw var0_4;
        }
        catch (IOException | ClassNotFoundException exception) {
            return null;
        }
    }

    public static String zzc(String string, String[] stringArray, String[] stringArray2) {
        Preconditions.checkNotNull((Object)stringArray);
        Preconditions.checkNotNull((Object)stringArray2);
        int n = Math.min(stringArray.length, stringArray2.length);
        int n2 = 0;
        while (n2 < n) {
            String string2 = stringArray[n2];
            if (string == null) {
                if (string2 == null) return stringArray2[n2];
            }
            if (string != null && string.equals(string2)) {
                return stringArray2[n2];
            }
            ++n2;
        }
        return null;
    }
}
