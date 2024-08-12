/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzahu
 *  com.google.android.gms.internal.ads.zzaln
 *  com.google.android.gms.internal.ads.zzalp
 *  com.google.android.gms.internal.ads.zzalq
 *  com.google.android.gms.internal.ads.zzalt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzdp
 *  com.google.android.gms.internal.ads.zzdq
 *  com.google.android.gms.internal.ads.zzdr
 *  com.google.android.gms.internal.ads.zzds
 *  com.google.android.gms.internal.ads.zzdt
 *  com.google.android.gms.internal.ads.zzdv
 *  com.google.android.gms.internal.ads.zzdw
 *  com.google.android.gms.internal.ads.zzep
 *  com.google.android.gms.internal.ads.zzfl
 *  com.google.android.gms.internal.ads.zzfm
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzfq
 *  com.google.android.gms.internal.ads.zzfs
 *  com.google.android.gms.internal.ads.zzfy
 *  com.google.android.gms.internal.ads.zzg
 *  com.google.android.gms.internal.ads.zzge
 *  com.google.android.gms.internal.ads.zzgh
 *  com.google.android.gms.internal.ads.zzh
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzalq;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzdp;
import com.google.android.gms.internal.ads.zzdq;
import com.google.android.gms.internal.ads.zzdr;
import com.google.android.gms.internal.ads.zzds;
import com.google.android.gms.internal.ads.zzdt;
import com.google.android.gms.internal.ads.zzdv;
import com.google.android.gms.internal.ads.zzdw;
import com.google.android.gms.internal.ads.zzep;
import com.google.android.gms.internal.ads.zzfl;
import com.google.android.gms.internal.ads.zzfm;
import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzfq;
import com.google.android.gms.internal.ads.zzfs;
import com.google.android.gms.internal.ads.zzfy;
import com.google.android.gms.internal.ads.zzg;
import com.google.android.gms.internal.ads.zzge;
import com.google.android.gms.internal.ads.zzgh;
import com.google.android.gms.internal.ads.zzh;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzer
extends zzfq
implements zzalp {
    private final Context zzb;
    private final zzdp zzc;
    private final zzdw zzd;
    private int zze;
    private boolean zzf;
    private zzafv zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private zzahu zzl;

    public zzer(Context context, zzfm zzfm2, zzfs zzfs2, boolean bl, Handler handler, zzdq zzdq2, zzdw zzdw2) {
        super(1, zzfm2, zzfs2, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzdw2;
        this.zzc = new zzdp(handler, zzdq2);
        zzdw2.zza((zzdt)new zzep(this, null));
    }

    static /* synthetic */ zzdp zza(zzer zzer2) {
        return zzer2.zzc;
    }

    private final int zzaa(zzfo zzfo2, zzafv zzafv2) {
        if (!"OMX.google.raw.decoder".equals(zzfo2.zza)) return zzafv2.zzm;
        if (zzamq.zza >= 24) return zzafv2.zzm;
        if (zzamq.zza != 23) return -1;
        if (zzamq.zzZ((Context)this.zzb)) return zzafv2.zzm;
        return -1;
    }

    private final void zzab() {
        long l = this.zzd.zzd(this.zzw());
        if (l == Long.MIN_VALUE) return;
        if (!this.zzj) {
            l = Math.max(this.zzh, l);
        }
        this.zzh = l;
        this.zzj = false;
    }

    static /* synthetic */ zzahu zzb(zzer zzer2) {
        return zzer2.zzl;
    }

    public final zzahf zzA() {
        return this.zzd.zzm();
    }

    protected final void zzB(zzaf zzaf2) {
        if (!this.zzi) return;
        if (zzaf2.zzb()) return;
        if (Math.abs(zzaf2.zzd - this.zzh) > 500000L) {
            this.zzh = zzaf2.zzd;
        }
        this.zzi = false;
    }

    protected final void zzC() {
        this.zzd.zzg();
    }

    protected final void zzD() throws zzaeg {
        try {
            this.zzd.zzi();
            return;
        }
        catch (zzdv zzdv2) {
            throw this.zzaw(zzdv2, zzdv2.zzb, zzdv2.zza, 5002);
        }
    }

    public final void zzE(int n, Object object) throws zzaeg {
        if (n == 2) {
            this.zzd.zzr(((Float)object).floatValue());
            return;
        }
        if (n == 3) {
            object = (zzg)object;
            this.zzd.zzo((zzg)object);
            return;
        }
        if (n == 6) {
            object = (zzh)object;
            this.zzd.zzq((zzh)object);
            return;
        }
        switch (n) {
            default: {
                return;
            }
            case 11: {
                this.zzl = (zzahu)object;
                return;
            }
            case 10: {
                this.zzd.zzp(((Integer)object).intValue());
                return;
            }
            case 9: 
        }
        this.zzd.zzn(((Boolean)object).booleanValue());
    }

    protected final boolean zzF(long l, long l2, zzgh zzgh2, ByteBuffer byteBuffer, int n, int n2, int n3, long l3, boolean bl, boolean bl2, zzafv zzafv2) throws zzaeg {
        block6: {
            if (byteBuffer == null) throw null;
            if (this.zzg != null && (n2 & 2) != 0) {
                if (zzgh2 == null) throw null;
                zzgh2.zzh(n, false);
                return true;
            }
            if (bl) {
                if (zzgh2 != null) {
                    zzgh2.zzh(n, false);
                }
                zzgh2 = this.zza;
                zzgh2.zzf += n3;
                this.zzd.zzg();
                return true;
            }
            try {
                bl = this.zzd.zzh(byteBuffer, l3, n3);
                if (!bl) return false;
                if (zzgh2 == null) break block6;
            }
            catch (zzdv zzdv2) {
                throw this.zzaw(zzdv2, zzafv2, zzdv2.zza, 5002);
            }
            catch (zzds zzds2) {
                throw this.zzaw(zzds2, zzds2.zzb, false, 5001);
            }
            zzgh2.zzh(n, false);
        }
        zzgh2 = this.zza;
        zzgh2.zze += n3;
        return true;
    }

    public final String zzc() {
        return "MediaCodecAudioRenderer";
    }

    protected final int zzd(zzfs object, zzafv zzafv2) throws zzfy {
        int n;
        if (!zzalt.zza((String)zzafv2.zzl)) {
            return 0;
        }
        int n2 = zzamq.zza >= 21 ? 32 : 0;
        int n3 = zzafv2.zzE;
        boolean bl = zzer.zzY((zzafv)zzafv2);
        if (bl && this.zzd.zzb(zzafv2)) {
            if (n3 == 0) return n2 | 0xC;
            if (zzge.zza() != null) return n2 | 0xC;
        }
        if ("audio/raw".equals(zzafv2.zzl)) {
            if (!this.zzd.zzb(zzafv2)) return 1;
        }
        if (!this.zzd.zzb(zzamq.zzN((int)2, (int)zzafv2.zzy, (int)zzafv2.zzz))) {
            return 1;
        }
        if ((object = this.zze((zzfs)object, zzafv2, false)).isEmpty()) {
            return 1;
        }
        if (!bl) {
            return 2;
        }
        object = (zzfo)object.get(0);
        bl = object.zzc(zzafv2);
        n3 = n = 8;
        if (bl) {
            n3 = n;
            if (object.zzd(zzafv2)) {
                n3 = 16;
            }
        }
        n = true != bl ? 3 : 4;
        return n | n3 | n2;
    }

    protected final List<zzfo> zze(zzfs object, zzafv object2, boolean bl) throws zzfy {
        String string = object2.zzl;
        if (string == null) {
            return Collections.emptyList();
        }
        if (this.zzd.zzb(object2)) {
            object = zzge.zza();
            if (object != null) return Collections.singletonList(object);
        }
        object2 = zzge.zzd((List)zzge.zzc((String)string, (boolean)false, (boolean)false), (zzafv)object2);
        object = object2;
        if (!"audio/eac3-joc".equals(string)) return Collections.unmodifiableList(object);
        object = new ArrayList(object2);
        object.addAll(zzge.zzc((String)"audio/eac3", (boolean)false, (boolean)false));
        return Collections.unmodifiableList(object);
    }

    protected final boolean zzf(zzafv zzafv2) {
        return this.zzd.zzb(zzafv2);
    }

    protected final zzfl zzg(zzfo zzfo2, zzafv zzafv2, MediaCrypto object, float f) {
        int n;
        MediaFormat mediaFormat = this.zzau();
        int n2 = this.zzaa(zzfo2, zzafv2);
        int n3 = ((zzafv[])mediaFormat).length;
        if (n3 == 1) {
            n = n2;
        } else {
            int n4 = 0;
            while (true) {
                n = n2;
                if (n4 >= n3) break;
                object = mediaFormat[n4];
                n = n2;
                if (zzfo2.zze((zzafv)zzafv2, (zzafv)object).zzd != 0) {
                    n = Math.max(n2, this.zzaa(zzfo2, (zzafv)object));
                }
                ++n4;
                n2 = n;
            }
        }
        this.zze = n;
        object = zzfo2.zza;
        boolean bl = zzamq.zza < 24 && "OMX.SEC.aac.dec".equals(object) && "samsung".equals(zzamq.zzc) && (zzamq.zzb.startsWith("zeroflte") || zzamq.zzb.startsWith("herolte") || zzamq.zzb.startsWith("heroqlte"));
        this.zzf = bl;
        object = zzfo2.zzc;
        n2 = this.zze;
        mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", (String)object);
        mediaFormat.setInteger("channel-count", zzafv2.zzy);
        mediaFormat.setInteger("sample-rate", zzafv2.zzz);
        zzalq.zza((MediaFormat)mediaFormat, (List)zzafv2.zzn);
        zzalq.zzb((MediaFormat)mediaFormat, (String)"max-input-size", (int)n2);
        if (zzamq.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzamq.zza != 23 || !"ZTE B2017G".equals(zzamq.zzd) && !"AXON 7 mini".equals(zzamq.zzd))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzamq.zza <= 28 && "audio/ac4".equals(zzafv2.zzl)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzamq.zza >= 24 && this.zzd.zzc(zzamq.zzN((int)4, (int)zzafv2.zzy, (int)zzafv2.zzz)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        object = "audio/raw".equals(zzfo2.zzb) && !"audio/raw".equals(zzafv2.zzl) ? zzafv2 : null;
        this.zzg = object;
        return zzfl.zza((zzfo)zzfo2, (MediaFormat)mediaFormat, (zzafv)zzafv2, null);
    }

    protected final zzba zzh(zzfo object, zzafv zzafv2, zzafv zzafv3) {
        int n;
        zzba zzba2 = object.zze(zzafv2, zzafv3);
        int n2 = n = zzba2.zze;
        if (this.zzaa((zzfo)object, zzafv3) > this.zze) {
            n2 = n | 0x40;
        }
        object = object.zza;
        if (n2 != 0) {
            n = 0;
        } else {
            n = zzba2.zzd;
            n2 = 0;
        }
        return new zzba((String)object, zzafv2, zzafv3, n, n2);
    }

    public final zzalp zzi() {
        return this;
    }

    protected final float zzj(float f, zzafv zzafv2, zzafv[] zzafvArray) {
        int n = zzafvArray.length;
        int n2 = 0;
        int n3 = -1;
        while (true) {
            if (n2 >= n) {
                if (n3 != -1) return (float)n3 * f;
                return -1.0f;
            }
            int n4 = zzafvArray[n2].zzz;
            int n5 = n3;
            if (n4 != -1) {
                n5 = Math.max(n3, n4);
            }
            ++n2;
            n3 = n5;
        }
    }

    protected final void zzk(String string, long l, long l2) {
        this.zzc.zzb(string, l, l2);
    }

    protected final void zzl(String string) {
        this.zzc.zzf(string);
    }

    protected final void zzm(Exception exception) {
        zzaln.zzb((String)"MediaCodecAudioRenderer", (String)"Audio codec error", (Throwable)exception);
        this.zzc.zzj(exception);
    }

    protected final zzba zzn(zzafw zzafw2) throws zzaeg {
        zzba zzba2 = super.zzn(zzafw2);
        this.zzc.zzc(zzafw2.zza, zzba2);
        return zzba2;
    }

    protected final void zzo(zzafv zzafv2, MediaFormat object) throws zzaeg {
        zzafv zzafv3 = this.zzg;
        zzaft zzaft2 = null;
        int[] nArray = null;
        if (zzafv3 != null) {
            zzafv2 = zzafv3;
            object = zzaft2;
        } else if (this.zzZ() == null) {
            object = zzaft2;
        } else {
            int n = "audio/raw".equals(zzafv2.zzl) ? zzafv2.zzA : (zzamq.zza >= 24 && object.containsKey("pcm-encoding") ? object.getInteger("pcm-encoding") : (object.containsKey("v-bits-per-sample") ? zzamq.zzO((int)object.getInteger("v-bits-per-sample")) : ("audio/raw".equals(zzafv2.zzl) ? zzafv2.zzA : 2)));
            zzaft2 = new zzaft();
            zzaft2.zzN("audio/raw");
            zzaft2.zzac(n);
            zzaft2.zzad(zzafv2.zzB);
            zzaft2.zzae(zzafv2.zzC);
            zzaft2.zzaa(object.getInteger("channel-count"));
            zzaft2.zzab(object.getInteger("sample-rate"));
            zzaft2 = zzaft2.zzah();
            object = nArray;
            if (this.zzf) {
                object = nArray;
                if (zzaft2.zzy == 6) {
                    n = zzafv2.zzy;
                    object = nArray;
                    if (n < 6) {
                        nArray = new int[n];
                        n = 0;
                        while (true) {
                            object = nArray;
                            if (n >= zzafv2.zzy) break;
                            nArray[n] = n;
                            ++n;
                        }
                    }
                }
            }
            zzafv2 = zzaft2;
        }
        try {
            this.zzd.zze(zzafv2, 0, (int[])object);
            return;
        }
        catch (zzdr zzdr2) {
            zzaeg zzaeg2 = this.zzaw(zzdr2, zzdr2.zza, false, 5001);
            throw zzaeg2;
        }
    }

    protected final void zzp() {
        this.zzj = true;
    }

    protected final void zzq(boolean bl, boolean bl2) throws zzaeg {
        super.zzq(bl, bl2);
        this.zzc.zza(this.zza);
        this.zzav();
    }

    protected final void zzr(long l, boolean bl) throws zzaeg {
        super.zzr(l, bl);
        this.zzd.zzt();
        this.zzh = l;
        this.zzi = true;
        this.zzj = true;
    }

    protected final void zzs() {
        this.zzd.zzf();
    }

    protected final void zzt() {
        this.zzab();
        this.zzd.zzs();
    }

    protected final void zzu() {
        this.zzk = true;
        try {
            this.zzd.zzt();
        }
        catch (Throwable throwable) {
            try {
                super.zzu();
                throw throwable;
            }
            finally {
                this.zzc.zzg(this.zza);
            }
        }
        try {
            super.zzu();
            return;
        }
        finally {
            this.zzc.zzg(this.zza);
        }
    }

    protected final void zzv() {
        try {
            super.zzv();
            if (!this.zzk) return;
            this.zzk = false;
        }
        catch (Throwable throwable) {
            if (!this.zzk) throw throwable;
            this.zzk = false;
            this.zzd.zzu();
            throw throwable;
        }
        this.zzd.zzu();
    }

    public final boolean zzw() {
        if (!super.zzw()) return false;
        if (!this.zzd.zzj()) return false;
        return true;
    }

    public final boolean zzx() {
        if (this.zzd.zzk()) return true;
        if (!super.zzx()) return false;
        return true;
    }

    public final long zzy() {
        if (this.zzaf() != 2) return this.zzh;
        this.zzab();
        return this.zzh;
    }

    public final void zzz(zzahf zzahf2) {
        this.zzd.zzl(zzahf2);
    }
}
