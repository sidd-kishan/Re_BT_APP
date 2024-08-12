/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflo
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflo;
import com.google.android.gms.internal.ads.zzfmg;
import java.io.IOException;
import java.util.Iterator;

final class zzfmd
implements Iterable<String> {
    final CharSequence zza;
    final zzfmg zzb;

    zzfmd(zzfmg zzfmg2, CharSequence charSequence) {
        this.zzb = zzfmg2;
        this.zza = charSequence;
    }

    @Override
    public final Iterator<String> iterator() {
        return zzfmg.zze((zzfmg)this.zzb, (CharSequence)this.zza);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Iterator iterator = this.iterator();
        try {
            if (iterator.hasNext()) {
                stringBuilder.append(zzflo.zza(iterator.next(), (String)", "));
                while (iterator.hasNext()) {
                    stringBuilder.append((CharSequence)", ");
                    stringBuilder.append(zzflo.zza(iterator.next(), (String)", "));
                }
            }
            stringBuilder.append(']');
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
        return stringBuilder.toString();
    }
}
