/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzdy
 *  com.google.android.gms.internal.ads.zzdz
 *  com.google.android.gms.internal.ads.zzej
 *  com.google.android.gms.internal.ads.zzen
 *  com.google.android.gms.internal.ads.zzep
 *  com.google.android.gms.internal.ads.zzer
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzdy;
import com.google.android.gms.internal.ads.zzdz;
import com.google.android.gms.internal.ads.zzej;
import com.google.android.gms.internal.ads.zzen;
import com.google.android.gms.internal.ads.zzep;
import com.google.android.gms.internal.ads.zzer;
import java.lang.reflect.Method;

final class zzea {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzdz zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    private zzdy zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzea(zzdz zzdz2) {
        this.zza = zzdz2;
        if (zzamq.zza >= 18) {
            try {
                this.zzn = AudioTrack.class.getMethod("getLatency", null);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
        }
        this.zzb = new long[10];
    }

    private final long zzm(long l) {
        return l * 1000000L / (long)this.zzg;
    }

    private final void zzn() {
        this.zzl = 0L;
        this.zzw = 0;
        this.zzv = 0;
        this.zzm = 0L;
        this.zzC = 0L;
        this.zzF = 0L;
        this.zzk = false;
    }

    private final long zzo() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) throw null;
        if (this.zzx != -9223372036854775807L) {
            long l = SystemClock.elapsedRealtime();
            long l2 = this.zzx;
            int n = this.zzg;
            return Math.min(this.zzA, this.zzz + (l * 1000L - l2) * (long)n / 1000000L);
        }
        int n = audioTrack.getPlayState();
        if (n == 1) {
            return 0L;
        }
        long l = (long)audioTrack.getPlaybackHeadPosition() & 0xFFFFFFFFL;
        int n2 = n;
        long l3 = l;
        if (this.zzh) {
            n2 = n;
            if (n == 2) {
                if (l == 0L) {
                    this.zzu = this.zzs;
                }
                n2 = 2;
            }
            l3 = l + this.zzu;
        }
        if (zzamq.zza <= 29) {
            if (l3 == 0L && this.zzs > 0L && n2 == 3) {
                if (this.zzy != -9223372036854775807L) return this.zzs;
                this.zzy = SystemClock.elapsedRealtime();
                return this.zzs;
            }
            this.zzy = -9223372036854775807L;
        }
        if (this.zzs > l3) {
            ++this.zzt;
        }
        this.zzs = l3;
        return l3 + (this.zzt << 32);
    }

    public final void zza(AudioTrack audioTrack, boolean bl, int n, int n2, int n3) {
        this.zzc = audioTrack;
        this.zzd = n2;
        this.zze = n3;
        this.zzf = new zzdy(audioTrack);
        this.zzg = audioTrack.getSampleRate();
        this.zzh = false;
        this.zzq = bl = zzamq.zzP((int)n);
        long l = bl ? this.zzm(n3 / n2) : -9223372036854775807L;
        this.zzi = l;
        this.zzs = 0L;
        this.zzt = 0L;
        this.zzu = 0L;
        this.zzp = false;
        this.zzx = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzr = 0L;
        this.zzo = 0L;
        this.zzj = 1.0f;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzb(boolean bl) {
        long l;
        long l2;
        long l3;
        long l4;
        Object object;
        block21: {
            block20: {
                Object object2;
                int n;
                object = this.zzc;
                if (object == null) throw null;
                if (object.getPlayState() != 3 || (l4 = this.zzm(this.zzo())) == 0L) break block21;
                l3 = System.nanoTime() / 1000L;
                if (l3 - this.zzm >= 30000L) {
                    int n2;
                    object = this.zzb;
                    n = this.zzv;
                    object[n] = (AudioTrack)(l4 - l3);
                    this.zzv = (n + 1) % 10;
                    n = this.zzw;
                    if (n < 10) {
                        this.zzw = n + 1;
                    }
                    this.zzm = l3;
                    this.zzl = 0L;
                    for (n = 0; n < (n2 = this.zzw); this.zzl += this.zzb[n] / (long)n2, ++n) {
                    }
                }
                if (this.zzh) break block21;
                object = this.zzf;
                if (object == null) throw null;
                if (object.zza(l3)) {
                    l2 = object.zzf();
                    l = object.zzg();
                    if (Math.abs(l2 - l3) > 5000000L) {
                        object2 = (zzej)this.zza;
                        long l5 = zzen.zzA((zzen)((zzej)object2).zza);
                        long l6 = zzen.zzB((zzen)((zzej)object2).zza);
                        object2 = new StringBuilder(180);
                        ((StringBuilder)object2).append("Spurious audio timestamp (system clock mismatch): ");
                        ((StringBuilder)object2).append(l);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l2);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l3);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l4);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l5);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l6);
                        Log.w((String)"DefaultAudioSink", (String)((StringBuilder)object2).toString());
                        object.zzb();
                    } else if (Math.abs(this.zzm(l) - l4) > 5000000L) {
                        object2 = (zzej)this.zza;
                        long l7 = zzen.zzA((zzen)((zzej)object2).zza);
                        long l8 = zzen.zzB((zzen)((zzej)object2).zza);
                        object2 = new StringBuilder(182);
                        ((StringBuilder)object2).append("Spurious audio timestamp (frame position mismatch): ");
                        ((StringBuilder)object2).append(l);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l2);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l3);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l4);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l7);
                        ((StringBuilder)object2).append(", ");
                        ((StringBuilder)object2).append(l8);
                        Log.w((String)"DefaultAudioSink", (String)((StringBuilder)object2).toString());
                        object.zzb();
                    } else {
                        object.zzc();
                    }
                }
                if (!this.zzq || (object = this.zzn) == null || l3 - this.zzr < 500000L) break block21;
                try {
                    object2 = this.zzc;
                    if (object2 == null) break block20;
                    object = (Integer)((Method)object).invoke(object2, new Object[0]);
                    n = zzamq.zza;
                    this.zzo = l4 = (long)((Integer)object).intValue() * 1000L - this.zzi;
                    this.zzo = l4 = Math.max(l4, 0L);
                    if (l4 > 5000000L) {
                        object = new StringBuilder(61);
                        ((StringBuilder)object).append("Ignoring impossibly large audio latency: ");
                        ((StringBuilder)object).append(l4);
                        Log.w((String)"DefaultAudioSink", (String)((StringBuilder)object).toString());
                        this.zzo = 0L;
                    }
                }
                catch (Exception exception) {}
            }
            try {
                throw null;
            }
            catch (Exception exception) {}
            {
                this.zzn = null;
            }
            this.zzr = l3;
        }
        l = System.nanoTime() / 1000L;
        object = this.zzf;
        if (object == null) throw null;
        boolean bl2 = object.zzd();
        if (bl2) {
            l3 = this.zzm(object.zzg()) + zzamq.zzJ((long)(l - object.zzf()), (float)this.zzj);
        } else {
            l4 = this.zzw == 0 ? this.zzm(this.zzo()) : this.zzl + l;
            l3 = l4;
            if (!bl) {
                l3 = Math.max(0L, l4 - this.zzo);
            }
        }
        if (this.zzD != bl2) {
            this.zzF = this.zzC;
            this.zzE = this.zzB;
        }
        l2 = l - this.zzF;
        l4 = l3;
        if (l2 < 1000000L) {
            l4 = l2 * 1000L / 1000000L;
            l4 = (l3 * l4 + (1000L - l4) * (this.zzE + zzamq.zzJ((long)l2, (float)this.zzj))) / 1000L;
        }
        if (!this.zzk && l4 > (l3 = this.zzB)) {
            this.zzk = true;
            l2 = zzamq.zzK((long)zzadx.zza((long)(l4 - l3)), (float)this.zzj);
            l3 = System.currentTimeMillis();
            l2 = zzadx.zza((long)l2);
            object = (zzej)this.zza;
            if (zzen.zzw((zzen)((zzej)object).zza) != null) {
                zzer.zza((zzer)((zzep)zzen.zzw((zzen)((zzej)object).zza)).zza).zzd(l3 - l2);
            }
        }
        this.zzC = l;
        this.zzB = l4;
        this.zzD = bl2;
        return l4;
    }

    public final void zzc() {
        zzdy zzdy2 = this.zzf;
        if (zzdy2 == null) throw null;
        zzdy2.zze();
    }

    public final boolean zzd() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) throw null;
        if (audioTrack.getPlayState() != 3) return false;
        return true;
    }

    public final boolean zze(long l) {
        boolean bl;
        int n;
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) throw null;
        int n2 = n = audioTrack.getPlayState();
        if (this.zzh) {
            if (n == 2) {
                this.zzp = false;
                return false;
            }
            n2 = n;
            if (n == 1) {
                if (this.zzo() == 0L) return false;
                n2 = 1;
            }
        }
        boolean bl2 = this.zzp;
        this.zzp = bl = this.zzj(l);
        if (!bl2) return true;
        if (bl) return true;
        if (n2 == 1) return true;
        audioTrack = this.zza;
        n2 = this.zze;
        long l2 = zzadx.zza((long)this.zzi);
        audioTrack = (zzej)audioTrack;
        if (zzen.zzw((zzen)audioTrack.zza) == null) return true;
        l = SystemClock.elapsedRealtime();
        long l3 = zzen.zzz((zzen)audioTrack.zza);
        zzer.zza((zzer)((zzep)zzen.zzw((zzen)audioTrack.zza)).zza).zze(n2, l2, l - l3);
        return true;
    }

    public final int zzf(long l) {
        long l2 = this.zzo();
        int n = this.zzd;
        return this.zze - (int)(l - l2 * (long)n);
    }

    public final long zzg(long l) {
        return zzadx.zza((long)this.zzm(-this.zzo()));
    }

    public final boolean zzh(long l) {
        if (this.zzy == -9223372036854775807L) return false;
        if (l <= 0L) return false;
        if (SystemClock.elapsedRealtime() - this.zzy < 200L) return false;
        return true;
    }

    public final void zzi(long l) {
        this.zzz = this.zzo();
        this.zzx = SystemClock.elapsedRealtime() * 1000L;
        this.zzA = l;
    }

    public final boolean zzj(long l) {
        if (l > this.zzo()) return true;
        if (!this.zzh) return false;
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) throw null;
        if (audioTrack.getPlayState() != 2) return false;
        if (this.zzo() != 0L) return false;
        return true;
    }

    public final boolean zzk() {
        this.zzn();
        if (this.zzx != -9223372036854775807L) return false;
        zzdy zzdy2 = this.zzf;
        if (zzdy2 == null) throw null;
        zzdy2.zze();
        return true;
    }

    public final void zzl() {
        this.zzn();
        this.zzc = null;
        this.zzf = null;
    }
}
