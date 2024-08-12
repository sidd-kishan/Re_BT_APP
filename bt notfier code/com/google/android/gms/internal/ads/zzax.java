/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzax {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(String object) {
        if (TextUtils.isEmpty((CharSequence)object)) {
            return -1L;
        }
        if (!((Matcher)(object = zzb.matcher((CharSequence)object))).matches()) return -1L;
        if ((object = ((Matcher)object).group(1)) == null) throw null;
        return Long.parseLong((String)object);
    }

    public static long zzb(String string, String string2) {
        CharSequence charSequence;
        long l;
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        long l2 = l = -1L;
        if (!bl) {
            try {
                l2 = Long.parseLong(string);
            }
            catch (NumberFormatException numberFormatException) {
                charSequence = new StringBuilder(String.valueOf(string).length() + 28);
                ((StringBuilder)charSequence).append("Unexpected Content-Length [");
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append("]");
                Log.e((String)"HttpUtil", (String)((StringBuilder)charSequence).toString());
                l2 = l;
            }
        }
        l = l2;
        if (TextUtils.isEmpty((CharSequence)string2)) return l;
        Matcher matcher = zza.matcher(string2);
        l = l2;
        if (!matcher.matches()) return l;
        try {
            charSequence = matcher.group(2);
            if (charSequence == null) throw null;
            l = Long.parseLong((String)charSequence);
            charSequence = matcher.group(1);
            if (charSequence == null) throw null;
            long l3 = l - Long.parseLong((String)charSequence) + 1L;
            if (l2 < 0L) {
                l = l3;
            } else {
                l = l2;
                if (l2 == l3) return l;
                int n = String.valueOf(string).length();
                int n2 = String.valueOf(string2).length();
                charSequence = new StringBuilder(n + 26 + n2);
                ((StringBuilder)charSequence).append("Inconsistent headers [");
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append("] [");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("]");
                Log.w((String)"HttpUtil", (String)((StringBuilder)charSequence).toString());
                l = Math.max(l2, l3);
            }
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 27);
            stringBuilder.append("Unexpected Content-Range [");
            stringBuilder.append(string2);
            stringBuilder.append("]");
            Log.e((String)"HttpUtil", (String)stringBuilder.toString());
            l = l2;
        }
        return l;
    }
}
