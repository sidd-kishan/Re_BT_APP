/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzcir
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzcir;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzcis {
    protected static final AtomicInteger zza = new AtomicInteger(0);
    protected static final AtomicInteger zzb = new AtomicInteger(0);

    public static int zzP() {
        return zza.get();
    }

    public static int zzQ() {
        return zzb.get();
    }

    public abstract boolean zzA();

    public abstract int zzB();

    public abstract long zzC();

    public abstract boolean zzD();

    public abstract void zzE(boolean var1);

    public abstract void zzF(int var1);

    public abstract void zzG(int var1);

    public abstract long zzH();

    public abstract long zzI();

    public abstract long zzJ();

    public abstract long zzK();

    public abstract int zzL();

    public abstract void zzM(boolean var1);

    public abstract long zzN();

    public abstract long zzO();

    public abstract void zzp(Uri[] var1, String var2);

    public abstract void zzq(Uri[] var1, String var2, ByteBuffer var3, boolean var4);

    public abstract void zzr(zzcir var1);

    public abstract void zzs();

    public abstract void zzt(Surface var1, boolean var2) throws IOException;

    public abstract void zzu(float var1, boolean var2) throws IOException;

    public abstract void zzv();

    public abstract void zzw(long var1);

    public abstract void zzx(int var1);

    public abstract void zzy(int var1);

    public abstract void zzz(int var1);
}
