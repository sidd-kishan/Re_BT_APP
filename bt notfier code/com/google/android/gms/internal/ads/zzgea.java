/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgdx
 *  com.google.android.gms.internal.ads.zzgdz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgdx;
import com.google.android.gms.internal.ads.zzgdz;
import java.io.PrintWriter;
import java.util.Iterator;

final class zzgea
extends zzgdx {
    private final zzgdz zza = new zzgdz();

    zzgea() {
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        if (throwable2 == throwable) throw new IllegalArgumentException("Self suppression is not allowed.", throwable2);
        this.zza.zza(throwable, true).add(throwable2);
    }

    public final void zzb(Throwable object) {
        ((Throwable)object).printStackTrace();
        object = this.zza.zza((Throwable)object, false);
        if (object == null) {
            return;
        }
        synchronized (object) {
            try {
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    Throwable throwable = (Throwable)iterator.next();
                    System.err.print("Suppressed: ");
                    throwable.printStackTrace();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zzc(Throwable object, PrintWriter printWriter) {
        ((Throwable)object).printStackTrace(printWriter);
        object = this.zza.zza((Throwable)object, false);
        if (object == null) {
            return;
        }
        synchronized (object) {
            try {
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    Throwable throwable = (Throwable)iterator.next();
                    printWriter.print("Suppressed: ");
                    throwable.printStackTrace(printWriter);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
