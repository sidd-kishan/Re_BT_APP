/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface zzgkm
extends Closeable {
    public int zza(ByteBuffer var1) throws IOException;

    public long zzb() throws IOException;

    public long zzc() throws IOException;

    public void zzd(long var1) throws IOException;

    public ByteBuffer zze(long var1, long var3) throws IOException;
}
