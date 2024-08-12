/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaoa
 *  com.google.android.gms.internal.ads.zzaob
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaoa;
import com.google.android.gms.internal.ads.zzaob;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class zzaoy
implements zzaob {
    private int zzb = -1;
    private int zzc = -1;
    private int zzd = 0;
    private ByteBuffer zze = zza;
    private ByteBuffer zzf = zza;
    private boolean zzg;

    public final boolean zza(int n, int n2, int n3) throws zzaoa {
        if (n3 != 3 && n3 != 2 && n3 != Integer.MIN_VALUE) {
            if (n3 != 0x40000000) throw new zzaoa(n, n2, n3);
        }
        if (this.zzb == n && this.zzc == n2) {
            if (this.zzd == n3) return false;
        }
        this.zzb = n;
        this.zzc = n2;
        this.zzd = n3;
        if (n3 != 2) return true;
        this.zze = zza;
        return true;
    }

    public final boolean zzb() {
        int n = this.zzd;
        if (n == 0) return false;
        if (n == 2) return false;
        return true;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return 2;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int n;
        int n2;
        int n3;
        int n4;
        block11: {
            block10: {
                block9: {
                    n4 = byteBuffer.position();
                    n3 = byteBuffer.limit();
                    n2 = n3 - n4;
                    int n5 = this.zzd;
                    if (n5 == Integer.MIN_VALUE) break block9;
                    n = n2;
                    if (n5 == 3) break block10;
                    if (n5 != 0x40000000) throw new IllegalStateException();
                    n = n2 / 2;
                    break block11;
                }
                n = n2 / 3;
            }
            n += n;
        }
        if (this.zze.capacity() < n) {
            this.zze = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
        } else {
            this.zze.clear();
        }
        n2 = this.zzd;
        if (n2 != Integer.MIN_VALUE) {
            if (n2 != 3) {
                if (n2 != 0x40000000) throw new IllegalStateException();
                while (n4 < n3) {
                    this.zze.put(byteBuffer.get(n4 + 2));
                    this.zze.put(byteBuffer.get(n4 + 3));
                    n4 += 4;
                }
            } else {
                for (n = n4; n < n3; ++n) {
                    this.zze.put((byte)0);
                    this.zze.put((byte)((byteBuffer.get(n) & 0xFF) - 128));
                }
            }
        } else {
            for (n = n4; n < n3; n += 3) {
                this.zze.put(byteBuffer.get(n + 1));
                this.zze.put(byteBuffer.get(n + 2));
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.zze.flip();
        this.zzf = this.zze;
    }

    public final void zzf() {
        this.zzg = true;
    }

    public final ByteBuffer zzg() {
        ByteBuffer byteBuffer = this.zzf;
        this.zzf = zza;
        return byteBuffer;
    }

    public final boolean zzh() {
        if (!this.zzg) return false;
        if (this.zzf != zza) return false;
        return true;
    }

    public final void zzi() {
        this.zzf = zza;
        this.zzg = false;
    }

    public final void zzj() {
        this.zzi();
        this.zze = zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = 0;
    }
}
