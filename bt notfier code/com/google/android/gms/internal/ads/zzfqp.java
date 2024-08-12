/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public final class zzfqp
implements FilenameFilter {
    private final Pattern zza;

    public zzfqp(Pattern pattern) {
        if (pattern == null) throw null;
        this.zza = pattern;
    }

    @Override
    public final boolean accept(File file, String string) {
        return this.zza.matcher(string).matches();
    }
}
