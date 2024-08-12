/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcll
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcll;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzclk
extends SSLSocketFactory {
    final SSLSocketFactory zza;
    final zzcll zzb;

    zzclk(zzcll zzcll2) {
        this.zzb = zzcll2;
        this.zza = (SSLSocketFactory)SSLSocketFactory.getDefault();
    }

    private final Socket zza(Socket socket) throws SocketException {
        if (zzcll.zzk((zzcll)this.zzb) > 0) {
            socket.setReceiveBufferSize(zzcll.zzk((zzcll)this.zzb));
        }
        zzcll.zzm((zzcll)this.zzb, (Socket)socket);
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
