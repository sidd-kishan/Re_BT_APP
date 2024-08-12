/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.checkerframework.checker.nullness.compatqual.NullableDecl
 */
package com.google.android.gms.internal.common;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzm {
    public static String zza(@NullableDecl String string, Object ... objectArray) {
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
                    object = Integer.toHexString(System.identityHashCode(object));
                    Serializable serializable = new StringBuilder(String.valueOf(charSequence).length() + 1 + String.valueOf(object).length());
                    serializable.append((String)charSequence);
                    serializable.append('@');
                    serializable.append((String)object);
                    object = serializable.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    serializable = Level.WARNING;
                    charSequence = String.valueOf(object);
                    charSequence = ((String)charSequence).length() != 0 ? "Exception during lenientFormat for ".concat((String)charSequence) : new String("Exception during lenientFormat for ");
                    logger.logp((Level)serializable, "com.google.common.base.Strings", "lenientToString", (String)charSequence, exception);
                    String string2 = exception.getClass().getName();
                    charSequence = new StringBuilder(String.valueOf(object).length() + 9 + String.valueOf(string2).length());
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
        n3 = n4;
        while (n3 < (n4 = objectArray.length) && (n = string.indexOf("%s", n2)) != -1) {
            ((StringBuilder)charSequence).append(string, n2, n);
            ((StringBuilder)charSequence).append(objectArray[n3]);
            n2 = n + 2;
            ++n3;
        }
        ((StringBuilder)charSequence).append(string, n2, string.length());
        if (n3 >= n4) return ((StringBuilder)charSequence).toString();
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
