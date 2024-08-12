/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioFormat
 *  android.media.AudioFormat$Builder
 *  android.media.AudioTrack
 *  android.os.ConditionVariable
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzdb
 *  com.google.android.gms.internal.ads.zzdc
 *  com.google.android.gms.internal.ads.zzdd
 *  com.google.android.gms.internal.ads.zzde
 *  com.google.android.gms.internal.ads.zzdr
 *  com.google.android.gms.internal.ads.zzds
 *  com.google.android.gms.internal.ads.zzdt
 *  com.google.android.gms.internal.ads.zzdu
 *  com.google.android.gms.internal.ads.zzdv
 *  com.google.android.gms.internal.ads.zzdw
 *  com.google.android.gms.internal.ads.zzdz
 *  com.google.android.gms.internal.ads.zzea
 *  com.google.android.gms.internal.ads.zzeb
 *  com.google.android.gms.internal.ads.zzec
 *  com.google.android.gms.internal.ads.zzed
 *  com.google.android.gms.internal.ads.zzee
 *  com.google.android.gms.internal.ads.zzef
 *  com.google.android.gms.internal.ads.zzeg
 *  com.google.android.gms.internal.ads.zzei
 *  com.google.android.gms.internal.ads.zzej
 *  com.google.android.gms.internal.ads.zzem
 *  com.google.android.gms.internal.ads.zzeo
 *  com.google.android.gms.internal.ads.zzep
 *  com.google.android.gms.internal.ads.zzer
 *  com.google.android.gms.internal.ads.zzes
 *  com.google.android.gms.internal.ads.zzew
 *  com.google.android.gms.internal.ads.zzg
 *  com.google.android.gms.internal.ads.zzh
 */
package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzdb;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdd;
import com.google.android.gms.internal.ads.zzde;
import com.google.android.gms.internal.ads.zzdr;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzdu;
import com.google.android.gms.internal.ads.zzdv;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzdz;
import com.google.android.gms.internal.ads.zzea;
import com.google.android.gms.internal.ads.zzeb;
import com.google.android.gms.internal.ads.zzec;
import com.google.android.gms.internal.ads.zzed;
import com.google.android.gms.internal.ads.zzee;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zzej;
import com.google.android.gms.internal.ads.zzem;
import com.google.android.gms.internal.ads.zzeo;
import com.google.android.gms.internal.ads.zzep;
import com.google.android.gms.internal.ads.zzer;
import com.google.android.gms.internal.ads.zzes;
import com.google.android.gms.internal.ads.zzew;
import com.google.android.gms.internal.ads.zzg;
import com.google.android.gms.internal.ads.zzh;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public final class zzen
implements zzdw {
    private ByteBuffer[] zzA;
    private ByteBuffer zzB;
    private ByteBuffer zzC;
    private byte[] zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private int zzK;
    private zzh zzL;
    private long zzM;
    private boolean zzN;
    private boolean zzO;
    private final zzef zzP;
    private final zzec zza;
    private final zzew zzb;
    private final zzde[] zzc;
    private final zzde[] zzd;
    private final ConditionVariable zze;
    private final zzea zzf;
    private final ArrayDeque<zzeg> zzg;
    private zzem zzh;
    private final zzei<zzds> zzi;
    private final zzei<zzdv> zzj;
    private zzdt zzk;
    private zzee zzl;
    private zzee zzm;
    private AudioTrack zzn;
    private zzg zzo;
    private zzeg zzp;
    private zzeg zzq;
    private final zzahf zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private boolean zzv;
    private boolean zzw;
    private long zzx;
    private float zzy;
    private zzde[] zzz;

    public zzen(zzdb object, zzde[] zzef2, boolean bl) {
        zzef2 = new zzef((zzde[])zzef2);
        this.zzP = zzef2;
        int n = zzamq.zza;
        this.zze = new ConditionVariable(true);
        this.zzf = new zzea((zzdz)new zzej(this, null));
        this.zza = new zzec();
        this.zzb = new zzew();
        object = new ArrayList();
        Collections.addAll(object, new zzeb[]{new zzes(), this.zza, this.zzb});
        Collections.addAll(object, zzef2.zza());
        this.zzc = ((ArrayList)object).toArray(new zzde[0]);
        this.zzd = new zzde[]{new zzeo()};
        this.zzy = 1.0f;
        this.zzo = com.google.android.gms.internal.ads.zzg.zza;
        this.zzK = 0;
        this.zzL = new zzh(0, 0.0f);
        this.zzq = new zzeg(zzahf.zza, false, 0L, 0L, null);
        this.zzr = zzahf.zza;
        this.zzF = -1;
        this.zzz = new zzde[0];
        this.zzA = new ByteBuffer[0];
        this.zzg = new ArrayDeque();
        this.zzi = new zzei(100L);
        this.zzj = new zzei(100L);
    }

    static /* synthetic */ long zzA(zzen zzen2) {
        return zzen2.zzN();
    }

    static /* synthetic */ long zzB(zzen zzen2) {
        return zzen2.zzO();
    }

    static /* synthetic */ AudioFormat zzC(int n, int n2, int n3) {
        return new AudioFormat.Builder().setSampleRate(n).setChannelMask(n2).setEncoding(n3).build();
    }

    private final void zzD() {
        zzde zzde2;
        int n = 0;
        while (n < ((zzde[])(zzde2 = this.zzz)).length) {
            zzde2 = zzde2[n];
            zzde2.zzg();
            this.zzA[n] = zzde2.zze();
            ++n;
        }
    }

    private final void zzE(long l) throws zzdv {
        int n;
        int n2 = n = this.zzz.length;
        while (n2 >= 0) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            if (n2 > 0) {
                byteBuffer2 = this.zzA[n2 - 1];
            } else {
                byteBuffer2 = byteBuffer = this.zzB;
                if (byteBuffer == null) {
                    byteBuffer2 = zzde.zza;
                }
            }
            if (n2 == n) {
                this.zzF(byteBuffer2, l);
            } else {
                byteBuffer = this.zzz[n2];
                if (n2 > this.zzF) {
                    byteBuffer.zzc(byteBuffer2);
                }
                this.zzA[n2] = byteBuffer = byteBuffer.zze();
                if (byteBuffer.hasRemaining()) {
                    ++n2;
                    continue;
                }
            }
            if (byteBuffer2.hasRemaining()) {
                return;
            }
            --n2;
        }
    }

    private final void zzF(ByteBuffer byteBuffer, long l) throws zzdv {
        int n;
        int n2;
        int n3;
        block17: {
            boolean bl;
            Object object;
            block19: {
                boolean bl2;
                block18: {
                    if (!byteBuffer.hasRemaining()) {
                        return;
                    }
                    object = this.zzC;
                    bl2 = true;
                    if (object != null) {
                        bl = object == byteBuffer;
                        zzakt.zza((boolean)bl);
                    } else {
                        this.zzC = byteBuffer;
                        if (zzamq.zza < 21) {
                            n3 = byteBuffer.remaining();
                            object = this.zzD;
                            if (object == null || ((Object)object).length < n3) {
                                this.zzD = new byte[n3];
                            }
                            n2 = byteBuffer.position();
                            byteBuffer.get(this.zzD, 0, n3);
                            byteBuffer.position(n2);
                            this.zzE = 0;
                        }
                    }
                    n = byteBuffer.remaining();
                    if (zzamq.zza < 21) {
                        n2 = this.zzf.zzf(this.zzt);
                        if (n2 > 0) {
                            n2 = Math.min(n, n2);
                            n2 = n3 = this.zzn.write(this.zzD, this.zzE, n2);
                            if (n3 > 0) {
                                this.zzE += n3;
                                byteBuffer.position(byteBuffer.position() + n3);
                                n2 = n3;
                            }
                        } else {
                            n2 = 0;
                        }
                    } else {
                        n2 = this.zzn.write(byteBuffer, n, 1);
                    }
                    this.zzM = SystemClock.elapsedRealtime();
                    if (n2 >= 0) break block17;
                    if (zzamq.zza < 24) break block18;
                    bl = bl2;
                    if (n2 == -6) break block19;
                }
                bl = n2 == -32 ? bl2 : false;
            }
            byteBuffer = new zzdv(n2, this.zzm.zza, bl);
            object = this.zzk;
            if (object != null) {
                object.zzb((Exception)((Object)byteBuffer));
            }
            if (((zzdv)byteBuffer).zza) throw byteBuffer;
            this.zzj.zza((Exception)((Object)byteBuffer));
            return;
        }
        this.zzj.zzb();
        if (zzen.zzP(this.zzn) && this.zzI && this.zzk != null && n2 < n && !this.zzO) {
            l = this.zzf.zzg(0L);
            byteBuffer = (zzep)this.zzk;
            if (zzer.zzb((zzer)((zzep)byteBuffer).zza) != null) {
                zzer.zzb((zzer)((zzep)byteBuffer).zza).zza(l);
            }
        }
        n3 = this.zzm.zzc;
        this.zzt += (long)n2;
        if (n2 != n) return;
        this.zzC = null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final boolean zzG() throws zzdv {
        block4: {
            block5: {
                if (this.zzF == -1) break block5;
                var1_1 = false;
                ** GOTO lbl8
            }
            this.zzF = 0;
            do {
                var1_1 = true;
lbl8:
                // 2 sources

                var2_2 = ++this.zzF;
                var3_3 /* !! */  = this.zzz;
                if (var2_2 >= ((zzde[])var3_3 /* !! */ ).length) break block4;
                var3_3 /* !! */  = var3_3 /* !! */ [var2_2];
                if (var1_1) {
                    var3_3 /* !! */ .zzd();
                }
                this.zzE(-9223372036854775807L);
            } while (var3_3 /* !! */ .zzf());
            return false;
        }
        var3_3 /* !! */  = this.zzC;
        if (var3_3 /* !! */  != null) {
            this.zzF((ByteBuffer)var3_3 /* !! */ , -9223372036854775807L);
            if (this.zzC != null) {
                return false;
            }
        }
        this.zzF = -1;
        return true;
    }

    private final void zzH() {
        if (!this.zzM()) {
            return;
        }
        if (zzamq.zza >= 21) {
            this.zzn.setVolume(this.zzy);
            return;
        }
        AudioTrack audioTrack = this.zzn;
        float f = this.zzy;
        audioTrack.setStereoVolume(f, f);
    }

    private final void zzI(zzahf zzahf2, boolean bl) {
        zzeg zzeg2 = this.zzJ();
        if (zzahf2.equals((Object)zzeg2.zza)) {
            if (bl == zzeg2.zzb) return;
        }
        zzahf2 = new zzeg(zzahf2, bl, -9223372036854775807L, -9223372036854775807L, null);
        if (this.zzM()) {
            this.zzp = zzahf2;
            return;
        }
        this.zzq = zzahf2;
    }

    private final zzeg zzJ() {
        zzeg zzeg2 = this.zzp;
        if (zzeg2 != null) return zzeg2;
        zzeg2 = !this.zzg.isEmpty() ? this.zzg.getLast() : this.zzq;
        return zzeg2;
    }

    private final void zzK(long l) {
        zzdt zzdt2;
        zzef zzef2;
        if (this.zzL()) {
            zzef2 = this.zzP;
            zzdt2 = this.zzJ().zza;
            zzef2.zzb((zzahf)zzdt2);
        } else {
            zzdt2 = zzahf.zza;
        }
        boolean bl = this.zzL();
        int n = 0;
        if (bl) {
            zzef2 = this.zzP;
            bl = this.zzJ().zzb;
            zzef2.zzc(bl);
        } else {
            bl = false;
        }
        this.zzg.add(new zzeg((zzahf)zzdt2, bl, Math.max(0L, l), this.zzm.zza(this.zzO()), null));
        zzdt2 = this.zzm.zzi;
        ArrayList<zzef> arrayList = new ArrayList<zzef>();
        int n2 = ((zzde[])zzdt2).length;
        while (true) {
            if (n >= n2) {
                n = arrayList.size();
                this.zzz = arrayList.toArray(new zzde[n]);
                this.zzA = new ByteBuffer[n];
                this.zzD();
                zzdt2 = this.zzk;
                if (zzdt2 == null) return;
                zzer.zza((zzer)((zzep)zzdt2).zza).zzh(bl);
                return;
            }
            zzef2 = zzdt2[n];
            if (zzef2.zzb()) {
                arrayList.add(zzef2);
            } else {
                zzef2.zzg();
            }
            ++n;
        }
    }

    private final boolean zzL() {
        if (!"audio/raw".equals(this.zzm.zza.zzl)) return false;
        int n = this.zzm.zza.zzA;
        return true;
    }

    private final boolean zzM() {
        if (this.zzn == null) return false;
        return true;
    }

    private final long zzN() {
        zzee zzee2 = this.zzm;
        int n = zzee2.zzc;
        return this.zzs / (long)zzee2.zzb;
    }

    private final long zzO() {
        zzee zzee2 = this.zzm;
        int n = zzee2.zzc;
        return this.zzt / (long)zzee2.zzd;
    }

    private static boolean zzP(AudioTrack audioTrack) {
        if (zzamq.zza < 29) return false;
        if (!audioTrack.isOffloadedPlayback()) return false;
        return true;
    }

    private final void zzQ() {
        if (this.zzH) return;
        this.zzH = true;
        this.zzf.zzi(this.zzO());
        this.zzn.stop();
    }

    static /* synthetic */ ConditionVariable zzv(zzen zzen2) {
        return zzen2.zze;
    }

    static /* synthetic */ zzdt zzw(zzen zzen2) {
        return zzen2.zzk;
    }

    static /* synthetic */ AudioTrack zzx(zzen zzen2) {
        return zzen2.zzn;
    }

    static /* synthetic */ boolean zzy(zzen zzen2) {
        return zzen2.zzI;
    }

    static /* synthetic */ long zzz(zzen zzen2) {
        return zzen2.zzM;
    }

    public final void zza(zzdt zzdt2) {
        this.zzk = zzdt2;
    }

    public final boolean zzb(zzafv zzafv2) {
        if (this.zzc(zzafv2) == 0) return false;
        return true;
    }

    public final int zzc(zzafv object) {
        if (!"audio/raw".equals(((zzafv)object).zzl)) {
            int n = zzamq.zza;
            return 0;
        }
        if (!zzamq.zzP((int)((zzafv)object).zzA)) {
            int n = ((zzafv)object).zzA;
            object = new StringBuilder(33);
            ((StringBuilder)object).append("Invalid PCM encoding: ");
            ((StringBuilder)object).append(n);
            Log.w((String)"DefaultAudioSink", (String)((StringBuilder)object).toString());
            return 0;
        }
        if (((zzafv)object).zzA == 2) return 2;
        return 1;
    }

    public final long zzd(boolean bl) {
        if (!this.zzM()) return Long.MIN_VALUE;
        if (this.zzw) {
            return Long.MIN_VALUE;
        }
        long l = Math.min(this.zzf.zzb(bl), this.zzm.zza(this.zzO()));
        while (!this.zzg.isEmpty() && l >= this.zzg.getFirst().zzd) {
            this.zzq = this.zzg.remove();
        }
        zzeg zzeg2 = this.zzq;
        long l2 = l - zzeg2.zzd;
        if (zzeg2.zza.equals((Object)zzahf.zza)) {
            l = this.zzq.zzc + l2;
        } else if (this.zzg.isEmpty()) {
            l = this.zzP.zzd(l2) + this.zzq.zzc;
        } else {
            zzeg2 = this.zzg.getFirst();
            l = zzamq.zzJ((long)(zzeg2.zzd - l), (float)this.zzq.zza.zzb);
            l = zzeg2.zzc - l;
        }
        return l + this.zzm.zza(this.zzP.zze());
    }

    public final void zze(zzafv zzafv2, int n, int[] object) throws zzdr {
        if (!"audio/raw".equals(zzafv2.zzl)) {
            n = zzafv2.zzz;
            n = zzamq.zza;
            object = String.valueOf(zzafv2);
            String.valueOf(object).length();
            zzafv2 = new zzdr("Unable to configure passthrough for: ".concat(String.valueOf(object)), zzafv2);
            throw zzafv2;
        }
        zzakt.zza((boolean)zzamq.zzP((int)zzafv2.zzA));
        int n2 = zzamq.zzS((int)zzafv2.zzA, (int)zzafv2.zzy);
        n = zzafv2.zzA;
        zzde[] zzdeArray = this.zzc;
        this.zzb.zzo(zzafv2.zzB, zzafv2.zzC);
        Object object2 = object;
        if (zzamq.zza < 21) {
            object2 = object;
            if (zzafv2.zzy == 8) {
                object2 = object;
                if (object == null) {
                    object = new int[6];
                    n = 0;
                    while (true) {
                        object2 = object;
                        if (n >= 6) break;
                        object[n] = n;
                        ++n;
                    }
                }
            }
        }
        this.zza.zzo((int[])object2);
        object = new zzdc(zzafv2.zzz, zzafv2.zzy, zzafv2.zzA);
        for (zzde zzde2 : zzdeArray) {
            try {
                object2 = zzde2.zza((zzdc)object);
                boolean bl = zzde2.zzb();
                if (!bl) continue;
                object = object2;
            }
            catch (zzdd zzdd2) {
                throw new zzdr((Throwable)zzdd2, zzafv2);
            }
        }
        int n3 = object.zzd;
        int n4 = object.zzb;
        int n5 = zzamq.zzR((int)object.zzc);
        n = zzamq.zzS((int)n3, (int)object.zzc);
        if (n3 == 0) {
            object = String.valueOf(zzafv2);
            object2 = new StringBuilder(String.valueOf(object).length() + 48);
            ((StringBuilder)object2).append("Invalid output encoding (mode=0) for: ");
            ((StringBuilder)object2).append((String)object);
            throw new zzdr(((StringBuilder)object2).toString(), zzafv2);
        }
        if (n5 == 0) {
            object = String.valueOf(zzafv2);
            object2 = new StringBuilder(String.valueOf(object).length() + 54);
            ((StringBuilder)object2).append("Invalid output channel config (mode=0) for: ");
            ((StringBuilder)object2).append((String)object);
            throw new zzdr(((StringBuilder)object2).toString(), zzafv2);
        }
        this.zzN = false;
        zzafv2 = new zzee(zzafv2, n2, 0, n, n4, n5, n3, 0, false, zzdeArray);
        if (this.zzM()) {
            this.zzl = zzafv2;
            return;
        }
        this.zzm = zzafv2;
    }

    public final void zzf() {
        this.zzI = true;
        if (!this.zzM()) return;
        this.zzf.zzc();
        this.zzn.play();
    }

    public final void zzg() {
        this.zzv = true;
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final boolean zzh(ByteBuffer byteBuffer, long l, int n) throws zzds, zzdv {
        zzee zzee2;
        ByteBuffer byteBuffer2 = this.zzB;
        boolean bl = byteBuffer2 == null || byteBuffer == byteBuffer2;
        zzakt.zza((boolean)bl);
        if (this.zzl != null) {
            if (!this.zzG()) {
                return false;
            }
            byteBuffer2 = this.zzl;
            zzee2 = this.zzm;
            n = zzee2.zzc;
            n = ((zzee)byteBuffer2).zzc;
            if (zzee2.zzg == ((zzee)byteBuffer2).zzg && zzee2.zze == ((zzee)byteBuffer2).zze && zzee2.zzf == ((zzee)byteBuffer2).zzf && zzee2.zzd == ((zzee)byteBuffer2).zzd) {
                this.zzm = byteBuffer2;
                this.zzl = null;
                if (zzen.zzP(this.zzn)) {
                    this.zzn.setOffloadEndOfStream();
                    zzee2 = this.zzn;
                    byteBuffer2 = this.zzm.zza;
                    zzee2.setOffloadDelayPadding(((zzafv)byteBuffer2).zzB, ((zzafv)byteBuffer2).zzC);
                    this.zzO = true;
                }
            } else {
                this.zzQ();
                if (this.zzk()) {
                    return false;
                }
                this.zzt();
            }
            this.zzK(l);
        }
        if (!this.zzM()) {
            block28: {
                this.zze.block();
                {
                    catch (zzds zzds2) {
                        this.zzi.zza((Exception)((Object)zzds2));
                        return false;
                    }
                }
                byteBuffer2 = this.zzm;
                if (byteBuffer2 == null) break block28;
                byteBuffer2 = byteBuffer2.zzc(false, this.zzo, this.zzK);
                this.zzn = byteBuffer2;
                if (zzen.zzP((AudioTrack)byteBuffer2)) {
                    byteBuffer2 = this.zzn;
                    if (this.zzh == null) {
                        zzee2 = new zzem(this);
                        this.zzh = zzee2;
                    }
                    this.zzh.zza((AudioTrack)byteBuffer2);
                    zzee2 = this.zzn;
                    byteBuffer2 = this.zzm.zza;
                    zzee2.setOffloadDelayPadding(((zzafv)byteBuffer2).zzB, ((zzafv)byteBuffer2).zzC);
                }
                this.zzK = this.zzn.getAudioSessionId();
                zzea zzea2 = this.zzf;
                byteBuffer2 = this.zzn;
                zzee2 = this.zzm;
                n = zzee2.zzc;
                zzea2.zza((AudioTrack)byteBuffer2, false, zzee2.zzg, zzee2.zzd, zzee2.zzh);
                this.zzH();
                n = this.zzL.zza;
                this.zzw = true;
            }
            try {
                throw null;
            }
            catch (zzds zzds3) {
                byteBuffer = this.zzk;
                if (byteBuffer == null) throw zzds3;
                byteBuffer.zzb((Exception)((Object)zzds3));
                throw zzds3;
            }
        }
        this.zzi.zzb();
        if (this.zzw) {
            this.zzx = Math.max(0L, l);
            this.zzv = false;
            this.zzw = false;
            this.zzK(l);
            if (this.zzI) {
                this.zzf();
            }
        }
        if (!this.zzf.zze(this.zzO())) {
            return false;
        }
        if (this.zzB == null) {
            bl = byteBuffer.order() == ByteOrder.LITTLE_ENDIAN;
            zzakt.zza((boolean)bl);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            n = this.zzm.zzc;
            if (this.zzp != null) {
                if (!this.zzG()) {
                    return false;
                }
                this.zzK(l);
                this.zzp = null;
            }
            long l2 = this.zzx;
            byteBuffer2 = this.zzm;
            if (!this.zzv && Math.abs((l2 += (this.zzN() - this.zzb.zzq()) * 1000000L / (long)((zzee)byteBuffer2).zza.zzz) - l) > 200000L) {
                this.zzk.zzb((Exception)new zzdu(l, l2));
                this.zzv = true;
            }
            if (this.zzv) {
                if (!this.zzG()) {
                    return false;
                }
                l2 = l - l2;
                this.zzx += l2;
                this.zzv = false;
                this.zzK(l);
                byteBuffer2 = this.zzk;
                if (byteBuffer2 != null && l2 != 0L) {
                    ((zzep)byteBuffer2).zza.zzp();
                }
            }
            n = this.zzm.zzc;
            this.zzs += (long)byteBuffer.remaining();
            this.zzB = byteBuffer;
        }
        this.zzE(l);
        if (!this.zzB.hasRemaining()) {
            this.zzB = null;
            return true;
        }
        if (!this.zzf.zzh(this.zzO())) return false;
        Log.w((String)"DefaultAudioSink", (String)"Resetting stalled audio track");
        this.zzt();
        return true;
    }

    public final void zzi() throws zzdv {
        if (this.zzG) return;
        if (!this.zzM()) return;
        if (!this.zzG()) return;
        this.zzQ();
        this.zzG = true;
    }

    public final boolean zzj() {
        boolean bl = this.zzM();
        boolean bl2 = false;
        if (bl) {
            if (!this.zzG) return bl2;
            if (this.zzk()) return false;
        }
        bl2 = true;
        return bl2;
    }

    public final boolean zzk() {
        if (!this.zzM()) return false;
        if (!this.zzf.zzj(this.zzO())) return false;
        return true;
    }

    public final void zzl(zzahf zzahf2) {
        this.zzI(new zzahf(zzamq.zzz((float)zzahf2.zzb, (float)0.1f, (float)8.0f), zzamq.zzz((float)zzahf2.zzc, (float)0.1f, (float)8.0f)), this.zzJ().zzb);
    }

    public final zzahf zzm() {
        return this.zzJ().zza;
    }

    public final void zzn(boolean bl) {
        this.zzI(this.zzJ().zza, bl);
    }

    public final void zzo(zzg zzg2) {
        if (this.zzo.equals((Object)zzg2)) {
            return;
        }
        this.zzo = zzg2;
        this.zzt();
    }

    public final void zzp(int n) {
        if (this.zzK == n) return;
        this.zzK = n;
        boolean bl = n != 0;
        this.zzJ = bl;
        this.zzt();
    }

    public final void zzq(zzh zzh2) {
        if (this.zzL.equals((Object)zzh2)) {
            return;
        }
        int n = zzh2.zza;
        float f = zzh2.zzb;
        if (this.zzn != null) {
            n = this.zzL.zza;
        }
        this.zzL = zzh2;
    }

    public final void zzr(float f) {
        if (this.zzy == f) return;
        this.zzy = f;
        this.zzH();
    }

    public final void zzs() {
        this.zzI = false;
        if (!this.zzM()) return;
        if (!this.zzf.zzk()) return;
        this.zzn.pause();
    }

    public final void zzt() {
        if (this.zzM()) {
            zzee zzee2;
            zzem zzem2;
            this.zzs = 0L;
            this.zzt = 0L;
            this.zzu = 0L;
            this.zzO = false;
            this.zzq = new zzeg(this.zzJ().zza, this.zzJ().zzb, 0L, 0L, null);
            this.zzx = 0L;
            this.zzp = null;
            this.zzg.clear();
            this.zzB = null;
            this.zzC = null;
            this.zzH = false;
            this.zzG = false;
            this.zzF = -1;
            this.zzb.zzp();
            this.zzD();
            if (this.zzf.zzd()) {
                this.zzn.pause();
            }
            if (zzen.zzP(this.zzn)) {
                zzem2 = this.zzh;
                if (zzem2 == null) throw null;
                zzem2.zzb(this.zzn);
            }
            zzem2 = this.zzn;
            this.zzn = null;
            if (zzamq.zza < 21 && !this.zzJ) {
                this.zzK = 0;
            }
            if ((zzee2 = this.zzl) != null) {
                this.zzm = zzee2;
                this.zzl = null;
            }
            this.zzf.zzl();
            this.zze.close();
            new zzed(this, "ExoPlayer:AudioTrackReleaseThread", (AudioTrack)zzem2).start();
        }
        this.zzj.zzb();
        this.zzi.zzb();
    }

    public final void zzu() {
        int n;
        this.zzt();
        zzde[] zzdeArray = this.zzc;
        int n2 = zzdeArray.length;
        for (n = 0; n < n2; ++n) {
            zzdeArray[n].zzh();
        }
        zzdeArray = this.zzd;
        n = zzdeArray.length;
        n = 0;
        while (true) {
            if (n > 0) {
                this.zzI = false;
                this.zzN = false;
                return;
            }
            zzdeArray[n].zzh();
            ++n;
        }
    }
}
