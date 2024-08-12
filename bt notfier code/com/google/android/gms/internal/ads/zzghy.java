/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgem
 *  com.google.android.gms.internal.ads.zzger
 *  com.google.android.gms.internal.ads.zzges
 *  com.google.android.gms.internal.ads.zzget
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgez
 *  com.google.android.gms.internal.ads.zzgfb
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzggn
 *  com.google.android.gms.internal.ads.zzghu
 *  com.google.android.gms.internal.ads.zzghv
 *  com.google.android.gms.internal.ads.zzghw
 *  com.google.android.gms.internal.ads.zzghx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgem;
import com.google.android.gms.internal.ads.zzger;
import com.google.android.gms.internal.ads.zzges;
import com.google.android.gms.internal.ads.zzget;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgez;
import com.google.android.gms.internal.ads.zzgfb;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzggn;
import com.google.android.gms.internal.ads.zzghu;
import com.google.android.gms.internal.ads.zzghv;
import com.google.android.gms.internal.ads.zzghw;
import com.google.android.gms.internal.ads.zzghx;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

final class zzghy
extends zzgex {
    static final int[] zza = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 0x8CCCC9, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgex zzd;
    private final zzgex zze;
    private final int zzf;
    private final int zzg;

    private zzghy(zzgex zzgex2, zzgex zzgex3) {
        int n;
        this.zzd = zzgex2;
        this.zze = zzgex3;
        this.zzf = n = zzgex2.zzc();
        this.zzc = n + zzgex3.zzc();
        this.zzg = Math.max(zzgex2.zzf(), zzgex3.zzf()) + 1;
    }

    /* synthetic */ zzghy(zzgex zzgex2, zzgex zzgex3, zzghw zzghw2) {
        this(zzgex2, zzgex3);
    }

    static zzgex zzF(zzgex zzgex2, zzgex zzgex3) {
        if (zzgex3.zzc() == 0) {
            return zzgex2;
        }
        if (zzgex2.zzc() == 0) {
            return zzgex3;
        }
        int n = zzgex2.zzc() + zzgex3.zzc();
        if (n < 128) {
            return zzghy.zzH(zzgex2, zzgex3);
        }
        if (zzgex2 instanceof zzghy) {
            zzghy zzghy2 = (zzghy)zzgex2;
            if (zzghy2.zze.zzc() + zzgex3.zzc() < 128) {
                zzgex2 = zzghy.zzH(zzghy2.zze, zzgex3);
                return new zzghy(zzghy2.zzd, zzgex2);
            }
            if (zzghy2.zzd.zzf() > zzghy2.zze.zzf() && zzghy2.zzg > zzgex3.zzf()) {
                zzgex2 = new zzghy(zzghy2.zze, zzgex3);
                return new zzghy(zzghy2.zzd, zzgex2);
            }
        }
        if (n < zzghy.zzG(Math.max(zzgex2.zzf(), zzgex3.zzf()) + 1)) return zzghv.zza((zzghv)new zzghv(null), (zzgex)zzgex2, (zzgex)zzgex3);
        return new zzghy(zzgex2, zzgex3);
    }

    static int zzG(int n) {
        int[] nArray = zza;
        int n2 = nArray.length;
        if (n < 47) return nArray[n];
        return Integer.MAX_VALUE;
    }

    private static zzgex zzH(zzgex zzgex2, zzgex zzgex3) {
        int n = zzgex2.zzc();
        int n2 = zzgex3.zzc();
        byte[] byArray = new byte[n + n2];
        zzgex2.zzy(byArray, 0, 0, n);
        zzgex3.zzy(byArray, 0, n, n2);
        return new zzget(byArray);
    }

    static /* synthetic */ zzgex zzd(zzghy zzghy2) {
        return zzghy2.zzd;
    }

    static /* synthetic */ zzgex zzh(zzghy zzghy2) {
        return zzghy2.zze;
    }

    public final boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof zzgex)) {
            return false;
        }
        if (this.zzc != (object = (zzgex)object).zzc()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int n = this.zzC();
        int n2 = object.zzC();
        if (n != 0 && n2 != 0) {
            if (n != n2) return false;
        }
        zzghx zzghx2 = new zzghx((zzgex)this, null);
        zzges zzges2 = zzghx2.zza();
        zzghx zzghx3 = new zzghx((zzgex)object, null);
        object = zzghx3.zza();
        n = 0;
        n2 = 0;
        int n3 = 0;
        while (true) {
            int n4;
            int n5;
            int n6;
            block14: {
                boolean bl2;
                block13: {
                    block12: {
                        n6 = zzges2.zzc() - n;
                        n5 = object.zzc() - n2;
                        n4 = Math.min(n6, n5);
                        bl2 = n == 0 ? zzges2.zzh((zzgex)object, n2, n4) : object.zzh((zzgex)zzges2, n, n4);
                        if (bl2) break block12;
                        bl2 = false;
                        break block13;
                    }
                    int n7 = this.zzc;
                    if ((n3 += n4) < n7) break block14;
                    if (n3 != n7) throw new IllegalStateException();
                    bl2 = bl;
                }
                return bl2;
            }
            if (n4 == n6) {
                zzges2 = zzghx2.zza();
                n = 0;
            } else {
                n += n4;
            }
            if (n4 == n5) {
                object = zzghx3.zza();
                n2 = 0;
                continue;
            }
            n2 += n4;
        }
    }

    public final byte zza(int n) {
        zzghy.zzD((int)n, (int)this.zzc);
        return this.zzb(n);
    }

    final byte zzb(int n) {
        int n2 = this.zzf;
        if (n >= n2) return this.zze.zzb(n - n2);
        return this.zzd.zzb(n);
    }

    public final int zzc() {
        return this.zzc;
    }

    protected final void zze(byte[] byArray, int n, int n2, int n3) {
        int n4 = this.zzf;
        if (n + n3 <= n4) {
            this.zzd.zze(byArray, n, n2, n3);
            return;
        }
        if (n >= n4) {
            this.zze.zze(byArray, n - n4, n2, n3);
            return;
        }
        this.zzd.zze(byArray, n, n2, n4 -= n);
        this.zze.zze(byArray, 0, n2 + n4, n3 - n4);
    }

    protected final int zzf() {
        return this.zzg;
    }

    protected final boolean zzg() {
        if (this.zzc < zzghy.zzG(this.zzg)) return false;
        return true;
    }

    public final zzgex zzi(int n, int n2) {
        int n3 = zzghy.zzE((int)n, (int)n2, (int)this.zzc);
        if (n3 == 0) {
            return zzgex.zzb;
        }
        if (n3 == this.zzc) {
            return this;
        }
        n3 = this.zzf;
        if (n2 <= n3) {
            return this.zzd.zzi(n, n2);
        }
        if (n >= n3) {
            return this.zze.zzi(n - n3, n2 - n3);
        }
        zzgex zzgex2 = this.zzd;
        return new zzghy(zzgex2.zzi(n, zzgex2.zzc()), this.zze.zzi(0, n2 - this.zzf));
    }

    public final ByteBuffer zzj() {
        throw null;
    }

    final void zzk(zzgem zzgem2) throws IOException {
        this.zzd.zzk(zzgem2);
        this.zze.zzk(zzgem2);
    }

    protected final String zzl(Charset charset) {
        return new String(this.zzz(), charset);
    }

    public final boolean zzm() {
        zzgex zzgex2 = this.zze;
        int n = this.zzd.zzn(0, 0, this.zzf);
        if (zzgex2.zzn(n, 0, zzgex2.zzc()) != 0) return false;
        return true;
    }

    protected final int zzn(int n, int n2, int n3) {
        int n4 = this.zzf;
        if (n2 + n3 <= n4) {
            return this.zzd.zzn(n, n2, n3);
        }
        if (n2 >= n4) {
            return this.zze.zzn(n, n2 - n4, n3);
        }
        n = this.zzd.zzn(n, n2, n4 -= n2);
        return this.zze.zzn(n, 0, n3 - n4);
    }

    protected final int zzo(int n, int n2, int n3) {
        int n4 = this.zzf;
        if (n2 + n3 <= n4) {
            return this.zzd.zzo(n, n2, n3);
        }
        if (n2 >= n4) {
            return this.zze.zzo(n, n2 - n4, n3);
        }
        n = this.zzd.zzo(n, n2, n4 -= n2);
        return this.zze.zzo(n, 0, n3 - n4);
    }

    public final zzgfc zzp() {
        Object object = new ArrayList();
        Object object2 = new zzghx((zzgex)this, null);
        while (object2.hasNext()) {
            object.add(object2.zza().zzj());
        }
        int n = zzgfc.zzd;
        object2 = object.iterator();
        n = 0;
        int n2 = 0;
        while (object2.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer)object2.next();
            n2 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                n |= 1;
                continue;
            }
            if (byteBuffer.isDirect()) {
                n |= 2;
                continue;
            }
            n |= 4;
        }
        object = n == 2 ? new zzgez(object, n2, true, null) : new zzgfb((InputStream)new zzggn(object), 4096, null);
        return object;
    }

    public final zzger zzq() {
        return new zzghu(this);
    }
}
