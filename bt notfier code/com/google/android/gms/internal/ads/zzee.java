/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioFormat
 *  android.media.AudioTrack
 *  android.media.AudioTrack$Builder
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzde
 *  com.google.android.gms.internal.ads.zzds
 *  com.google.android.gms.internal.ads.zzen
 *  com.google.android.gms.internal.ads.zzg
 */
package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzde;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzen;
import com.google.android.gms.internal.ads.zzg;

final class zzee {
    public final zzafv zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzde[] zzi;

    public zzee(zzafv zzafv2, int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, zzde[] zzdeArray) {
        this.zza = zzafv2;
        this.zzb = n;
        bl = false;
        this.zzc = 0;
        this.zzd = n3;
        this.zze = n4;
        this.zzf = n5;
        this.zzg = n6;
        this.zzi = zzdeArray;
        n = AudioTrack.getMinBufferSize((int)n4, (int)n5, (int)n6);
        if (n != -2) {
            bl = true;
        }
        zzakt.zzd((boolean)bl);
        this.zzh = zzamq.zzx((int)(n * 4), (int)((int)this.zzb(250000L) * this.zzd), (int)Math.max(n, (int)this.zzb(750000L) * this.zzd));
    }

    public final long zza(long l) {
        return l * 1000000L / (long)this.zze;
    }

    public final long zzb(long l) {
        return l * (long)this.zze / 1000000L;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public final AudioTrack zzc(boolean bl, zzg zzg2, int n) throws zzds {
        block9: {
            void var2_5;
            block8: {
                if (zzamq.zza >= 29) {
                    AudioFormat audioFormat = zzen.zzC((int)this.zze, (int)this.zzf, (int)this.zzg);
                    zzg2 = zzg2.zza();
                    AudioTrack.Builder builder = new AudioTrack.Builder();
                    zzg2 = builder.setAudioAttributes((AudioAttributes)zzg2).setAudioFormat(audioFormat).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(n).setOffloadedPlayback(false).build();
                    break block8;
                }
                if (zzamq.zza >= 21) {
                    zzg2 = new AudioTrack(zzg2.zza(), zzen.zzC((int)this.zze, (int)this.zzf, (int)this.zzg), this.zzh, 1, n);
                    break block8;
                }
                int n2 = zzg2.zzb;
                zzg2 = n == 0 ? new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1) : new AudioTrack(3, this.zze, this.zzf, this.zzg, this.zzh, 1, n);
            }
            n = zzg2.getState();
            if (n == 1) {
                return zzg2;
            }
            try {}
            catch (Exception exception) {
                throw new zzds(n, this.zze, this.zzf, this.zzh, this.zza, false, null);
            }
            break block9;
            catch (IllegalArgumentException illegalArgumentException) {
                throw new zzds(0, this.zze, this.zzf, this.zzh, this.zza, false, (Exception)var2_5);
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
                throw new zzds(0, this.zze, this.zzf, this.zzh, this.zza, false, (Exception)var2_5);
            }
        }
        zzg2.release();
        throw new zzds(n, this.zze, this.zzf, this.zzh, this.zza, false, null);
    }
}
