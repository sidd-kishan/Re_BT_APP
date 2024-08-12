/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

final class zzan
implements DialogInterface.OnClickListener {
    private final AtomicInteger zza;

    zzan(AtomicInteger atomicInteger) {
        this.zza = atomicInteger;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.zza.set(n);
    }
}
