/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzak
extends IOException {
    public final int zza;

    public zzak(int n) {
        this.zza = n;
    }

    public zzak(String string, int n) {
        super(string);
        this.zza = n;
    }

    public zzak(String string, Throwable throwable, int n) {
        super(string, throwable);
        this.zza = n;
    }

    public zzak(Throwable throwable, int n) {
        super(throwable);
        this.zza = n;
    }
}
