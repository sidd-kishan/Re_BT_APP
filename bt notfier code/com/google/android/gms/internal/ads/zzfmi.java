/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflw;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

public final class zzfmi {
    public static String zza(@CheckForNull String string) {
        return zzflw.zzb((String)string);
    }

    @CheckForNull
    public static String zzb(@CheckForNull String string) {
        String string2 = string;
        if (!zzflw.zza((String)string)) return string2;
        string2 = null;
        return string2;
    }

    public static boolean zzc(@CheckForNull String string) {
        return zzflw.zza((String)string);
    }

    public static String zzd(@CheckForNull String string, Object ... objectArray) {
        int n;
        CharSequence charSequence;
        int n2;
        int n3;
        int n4 = 0;
        for (n3 = 0; n3 < (n2 = objectArray.length); ++n3) {
            Object object = objectArray[n3];
            if (object == null) {
                charSequence = "null";
            } else {
                try {
                    charSequence = object.toString();
                }
                catch (Exception exception) {
                    charSequence = object.getClass().getName();
                    Object object2 = Integer.toHexString(System.identityHashCode(object));
                    object = new StringBuilder(String.valueOf(charSequence).length() + 1 + String.valueOf(object2).length());
                    ((StringBuilder)object).append((String)charSequence);
                    ((StringBuilder)object).append('@');
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    object2 = Level.WARNING;
                    charSequence = ((String)object).length() != 0 ? "Exception during lenientFormat for ".concat((String)object) : new String("Exception during lenientFormat for ");
                    logger.logp((Level)object2, "com.google.common.base.Strings", "lenientToString", (String)charSequence, exception);
                    String string2 = exception.getClass().getName();
                    n2 = String.valueOf(string2).length();
                    charSequence = new StringBuilder(((String)object).length() + 9 + n2);
                    ((StringBuilder)charSequence).append("<");
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(" threw ");
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append(">");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            }
            objectArray[n3] = charSequence;
        }
        charSequence = new StringBuilder(string.length() + n2 * 16);
        n2 = 0;
        for (n3 = n4; n3 < (n = objectArray.length) && (n4 = string.indexOf("%s", n2)) != -1; ++n3) {
            ((StringBuilder)charSequence).append(string, n2, n4);
            ((StringBuilder)charSequence).append(objectArray[n3]);
            n2 = n4 + 2;
        }
        ((StringBuilder)charSequence).append(string, n2, string.length());
        if (n3 >= n) return ((StringBuilder)charSequence).toString();
        ((StringBuilder)charSequence).append(" [");
        n2 = n3 + 1;
        ((StringBuilder)charSequence).append(objectArray[n3]);
        n3 = n2;
        while (true) {
            if (n3 >= objectArray.length) {
                ((StringBuilder)charSequence).append(']');
                return ((StringBuilder)charSequence).toString();
            }
            ((StringBuilder)charSequence).append(", ");
            ((StringBuilder)charSequence).append(objectArray[n3]);
            ++n3;
        }
    }
}
