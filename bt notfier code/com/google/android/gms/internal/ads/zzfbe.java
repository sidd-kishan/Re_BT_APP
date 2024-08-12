/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzfbe {
    private final Pattern zza;

    public zzfbe() {
        Object object;
        try {
            object = zzbjl.zzfe;
            object = Pattern.compile((String)zzbet.zzc().zzc(object));
        }
        catch (PatternSyntaxException patternSyntaxException) {
            object = null;
        }
        this.zza = object;
    }

    public final String zza(String object) {
        Pattern pattern = this.zza;
        if (pattern == null) return null;
        if (object == null) {
            return null;
        }
        if (!((Matcher)(object = pattern.matcher((CharSequence)object))).find()) return null;
        return ((Matcher)object).group();
    }
}
