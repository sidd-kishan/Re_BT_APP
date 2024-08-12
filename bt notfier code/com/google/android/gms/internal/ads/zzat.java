/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzak
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzas
 *  com.google.android.gms.internal.ads.zzflf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzak;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzas;
import com.google.android.gms.internal.ads.zzflf;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class zzat
extends zzak {
    public final zzan zzb;

    public zzat(zzan zzan2, int n, int n2) {
        super(zzat.zzb(2008, 1));
        this.zzb = zzan2;
    }

    public zzat(IOException iOException, zzan zzan2, int n, int n2) {
        super((Throwable)iOException, zzat.zzb(n, n2));
        this.zzb = zzan2;
    }

    public zzat(String string, zzan zzan2, int n, int n2) {
        super(string, zzat.zzb(2001, 1));
        this.zzb = zzan2;
    }

    @Deprecated
    public zzat(String string, IOException iOException, zzan zzan2, int n) {
        this(string, iOException, zzan2, 2000, 1);
    }

    public zzat(String string, IOException iOException, zzan zzan2, int n, int n2) {
        super(string, (Throwable)iOException, zzat.zzb(n, 1));
        this.zzb = zzan2;
    }

    public static zzat zza(IOException object, zzan zzan2, int n) {
        int n2;
        String string = object.getMessage();
        boolean bl = object instanceof SocketTimeoutException;
        int n3 = 2001;
        if (bl) {
            n2 = 2002;
        } else if (object instanceof InterruptedIOException) {
            n2 = 1004;
        } else {
            n2 = n3;
            if (string != null) {
                n2 = n3;
                if (zzflf.zza((String)string).matches("cleartext.*not permitted.*")) {
                    n2 = 2007;
                }
            }
        }
        object = n2 == 2007 ? new zzas(object, zzan2) : new zzat((IOException)object, zzan2, n2, n);
        return object;
    }

    private static int zzb(int n, int n2) {
        int n3 = n;
        if (n != 2000) return n3;
        n3 = n2 != 1 ? 2000 : 2001;
        return n3;
    }
}
