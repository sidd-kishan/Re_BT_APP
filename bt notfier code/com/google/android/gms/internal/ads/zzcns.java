/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzcns {
    private static final Pattern zza = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zza(String string, String ... stringArray) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        Object object = zza.matcher(string);
        boolean bl = ((Matcher)object).find();
        int n2 = 0;
        if (bl) {
            n2 = ((Matcher)object).end();
            stringBuilder.append(string.substring(0, n2));
            for (n = 0; n <= 0; ++n) {
                object = stringArray[n];
                if (object == null) continue;
                stringBuilder.append((String)object);
            }
            stringBuilder.append(string.substring(n2));
        } else {
            if (!zzb.matcher(string).find()) {
                for (n = n2; n <= 0; ++n) {
                    object = stringArray[n];
                    if (object == null) continue;
                    stringBuilder.append((String)object);
                }
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
