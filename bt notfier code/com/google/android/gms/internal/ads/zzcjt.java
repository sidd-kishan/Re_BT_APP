/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcju
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcju;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzcjt
extends SSLSocketFactory {
    final SSLSocketFactory zza;
    final zzcju zzb;

    zzcjt(zzcju zzcju2) {
        this.zzb = zzcju2;
        this.zza = (SSLSocketFactory)SSLSocketFactory.getDefault();
    }

    private final Socket zza(Socket socket) throws SocketException {
        if (zzcju.zzf((zzcju)this.zzb) > 0) {
            socket.setReceiveBufferSize(zzcju.zzf((zzcju)this.zzb));
        }
        zzcju.zzh((zzcju)this.zzb, (Socket)socket);
        return socket;
    }

    @Override
    public final Socket createSocket(String object, int n) throws IOException {
        object = this.zza.createSocket((String)object, n);
        this.zza((Socket)object);
        return object;
    }

    @Override
    public final Socket createSocket(String object, int n, InetAddress inetAddress, int n2) throws IOException {
        object = this.zza.createSocket((String)object, n, inetAddress, n2);
        this.zza((Socket)object);
        return object;
    }

    @Override
    public final Socket createSocket(InetAddress object, int n) throws IOException {
        object = this.zza.createSocket((InetAddress)object, n);
        this.zza((Socket)object);
        return object;
    }

    @Override
    public final Socket createSocket(InetAddress object, int n, InetAddress inetAddress, int n2) throws IOException {
        object = this.zza.createSocket((InetAddress)object, n, inetAddress, n2);
        this.zza((Socket)object);
        return object;
    }

    @Override
    public final Socket createSocket(Socket socket, String string, int n, boolean bl) throws IOException {
        socket = this.zza.createSocket(socket, string, n, bl);
        this.zza(socket);
        return socket;
    }

    @Override
    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    @Override
    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }
}
