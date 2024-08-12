/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzapo
 *  com.google.android.gms.internal.ads.zzapp
 *  com.google.android.gms.internal.ads.zzath
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzapo;
import com.google.android.gms.internal.ads.zzapp;
import com.google.android.gms.internal.ads.zzath;
import com.google.android.gms.internal.ads.zzave;
import java.io.EOFException;
import java.io.IOException;

final class zzasj {
    private final zzapo[] zza;
    private final zzapp zzb;
    private zzapo zzc;

    public zzasj(zzapo[] zzapoArray, zzapp zzapp2) {
        this.zza = zzapoArray;
        this.zzb = zzapp2;
    }

    public final void zza() {
        if (this.zzc == null) return;
        this.zzc = null;
    }

    /*
     * Unable to fully structure code
     */
    public final zzapo zzb(zzapn var1_1, Uri var2_2) throws IOException, InterruptedException {
        var5_4 = this.zzc;
        if (var5_4 != null) {
            return var5_4;
        }
        block3: for (zzapo var6_7 : this.zza) {
            block7: {
                try {
                    if (!var6_7.zzf((zzapn)var1_1)) break block7;
                    this.zzc = var6_7;
                }
                catch (Throwable var2_3) {
                    var1_1.zzg();
                    throw var2_3;
                }
            }
lbl13:
            // 2 sources

            while (true) {
                var1_1.zzg();
                continue block3;
                break;
            }
            catch (EOFException var6_8) {
                ** continue;
            }
            var1_1.zzg();
            break;
        }
        if ((var1_1 = this.zzc) != null) {
            var1_1.zzd(this.zzb);
            return this.zzc;
        }
        var1_1 = zzave.zzn((Object[])this.zza);
        var5_4 = new StringBuilder(var1_1.length() + 58);
        var5_4.append("None of the available extractors (");
        var5_4.append((String)var1_1);
        var5_4.append(") could read the stream.");
        var1_1 = new zzath(var5_4.toString(), var2_2);
        throw var1_1;
    }
}
