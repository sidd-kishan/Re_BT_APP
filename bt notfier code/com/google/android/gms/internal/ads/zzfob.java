/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

final class zzfob {
    static int zza(int n) {
        return (int)((long)Integer.rotateLeft((int)((long)n * -862048943L), 15) * 461845907L);
    }

    static int zzb(@CheckForNull Object object) {
        int n = object == null ? 0 : object.hashCode();
        return zzfob.zza(n);
    }
}
