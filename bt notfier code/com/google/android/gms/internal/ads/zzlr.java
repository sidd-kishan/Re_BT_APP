/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzag
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzlq
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzlq;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class zzlr
extends zzag {
    private final byte[] zza = new byte[2000];
    private final DatagramPacket zzb = new DatagramPacket(this.zza, 0, 2000);
    private Uri zzc;
    private DatagramSocket zzd;
    private MulticastSocket zze;
    private InetAddress zzf;
    private InetSocketAddress zzg;
    private boolean zzh;
    private int zzi;

    public zzlr() {
        this(2000);
    }

    public zzlr(int n) {
        super(true);
    }

    public final int zzg(byte[] byArray, int n, int n2) throws zzlq {
        int n3;
        if (n2 == 0) {
            return 0;
        }
        if (this.zzi == 0) {
            try {
                this.zzd.receive(this.zzb);
                this.zzi = n3 = this.zzb.getLength();
            }
            catch (IOException iOException) {
                throw new zzlq((Throwable)iOException, 2001);
            }
            catch (SocketTimeoutException socketTimeoutException) {
                throw new zzlq((Throwable)socketTimeoutException, 2002);
            }
            this.zzd(n3);
        }
        n3 = this.zzb.getLength();
        int n4 = this.zzi;
        n2 = Math.min(n4, n2);
        System.arraycopy(this.zza, n3 - n4, byArray, n, n2);
        this.zzi -= n2;
        return n2;
    }

    public final long zzh(zzan zzan2) throws zzlq {
        Object object = zzan2.zza;
        this.zzc = object;
        object = object.getHost();
        int n = this.zzc.getPort();
        this.zzb(zzan2);
        try {
            this.zzf = InetAddress.getByName((String)object);
            object = new InetSocketAddress(this.zzf, n);
            this.zzg = object;
            if (this.zzf.isMulticastAddress()) {
                object = new MulticastSocket(this.zzg);
                this.zze = object;
                ((MulticastSocket)object).joinGroup(this.zzf);
                this.zzd = this.zze;
            } else {
                object = new DatagramSocket(this.zzg);
                this.zzd = object;
            }
            this.zzd.setSoTimeout(8000);
            this.zzh = true;
        }
        catch (IOException iOException) {
            throw new zzlq((Throwable)iOException, 2001);
        }
        catch (SecurityException securityException) {
            throw new zzlq((Throwable)securityException, 2006);
        }
        this.zzc(zzan2);
        return -1L;
    }

    public final Uri zzi() {
        return this.zzc;
    }

    /*
     * Unable to fully structure code
     */
    public final void zzj() {
        this.zzc = null;
        var1_1 = this.zze;
        if (var1_1 != null) {
            try {
                var1_1.leaveGroup(this.zzf);
lbl6:
                // 2 sources

                while (true) {
                    this.zze = null;
                    break;
                }
            }
            catch (IOException var1_2) {
                ** continue;
            }
        }
        if ((var1_1 = this.zzd) != null) {
            var1_1.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzg = null;
        this.zzi = 0;
        if (this.zzh == false) return;
        this.zzh = false;
        this.zze();
    }
}
