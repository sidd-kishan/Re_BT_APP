/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzhx
 *  com.google.android.gms.internal.ads.zzjb
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzqq
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzhx;
import com.google.android.gms.internal.ads.zzjb;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzqq;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class zzgk
implements zzhx {
    private final zzoa zza;
    private zznu zzb;
    private zznv zzc;

    public zzgk(zzoa zzoa2) {
        this.zza = zzoa2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(zzah object, Uri uri, Map<String, List<String>> object2, long l, long l2, zznx zznx2) throws IOException {
        block16: {
            boolean bl;
            boolean bl2;
            int n;
            block15: {
                object = new zznp((zzah)object, l, l2);
                this.zzc = object;
                if (this.zzb != null) {
                    return;
                }
                object2 = this.zza.zza(uri, (Map)object2);
                n = ((Object)object2).length;
                bl2 = false;
                bl = false;
                if (n != 1) break block15;
                this.zzb = object2[0];
                break block16;
            }
            for (int i = 0; i < n; ++i) {
                boolean bl3;
                block21: {
                    block14: {
                        block18: {
                            block12: {
                                block17: {
                                    block13: {
                                        Object object3 = object2[i];
                                        try {
                                            if (!object3.zza((zznv)object)) break block12;
                                            this.zzb = object3;
                                            if (object3 != null) break block13;
                                            bl3 = bl;
                                        }
                                        catch (Throwable throwable) {
                                            block20: {
                                                block19: {
                                                    if (this.zzb != null) break block19;
                                                    bl3 = bl2;
                                                    if (object.zzn() != l) break block20;
                                                }
                                                bl3 = true;
                                            }
                                            zzakt.zzd((boolean)bl3);
                                            object.zzl();
                                            throw throwable;
                                        }
                                        catch (EOFException eOFException) {
                                            if (this.zzb != null || object.zzn() == l) break block14;
                                        }
                                        if (object.zzn() != l) break block17;
                                    }
                                    bl3 = true;
                                }
                                zzakt.zzd((boolean)bl3);
                                object.zzl();
                                break;
                            }
                            if (this.zzb == null && object.zzn() != l) break block18;
                            break block14;
                        }
                        bl3 = false;
                        break block21;
                    }
                    bl3 = true;
                }
                zzakt.zzd((boolean)bl3);
                object.zzl();
            }
            if (this.zzb == null) {
                object2 = zzamq.zzM((Object[])object2);
                object = new StringBuilder(((String)object2).length() + 58);
                ((StringBuilder)object).append("None of the available extractors (");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(") could read the stream.");
                object = new zzjb(((StringBuilder)object).toString(), uri);
                throw object;
            }
        }
        this.zzb.zzb(zznx2);
    }

    public final void zzb() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    public final void zzc() {
        zznu zznu2 = this.zzb;
        if (!(zznu2 instanceof zzqq)) return;
        ((zzqq)zznu2).zze();
    }

    public final long zzd() {
        zznv zznv2 = this.zzc;
        if (zznv2 == null) return -1L;
        return zznv2.zzn();
    }

    public final void zze(long l, long l2) {
        zznu zznu2 = this.zzb;
        if (zznu2 == null) throw null;
        zznu2.zzd(l, l2);
    }

    public final int zzf(zzoq zzoq2) throws IOException {
        zznu zznu2 = this.zzb;
        if (zznu2 == null) throw null;
        zznv zznv2 = this.zzc;
        if (zznv2 == null) throw null;
        return zznu2.zzc(zznv2, zzoq2);
    }
}
