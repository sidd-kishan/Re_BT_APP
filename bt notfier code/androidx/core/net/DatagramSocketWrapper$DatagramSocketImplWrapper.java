/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;

private static class DatagramSocketWrapper.DatagramSocketImplWrapper
extends SocketImpl {
    DatagramSocketWrapper.DatagramSocketImplWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        this.localport = datagramSocket.getLocalPort();
        this.fd = fileDescriptor;
    }

    @Override
    protected void accept(SocketImpl socketImpl) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected int available() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void bind(InetAddress inetAddress, int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void close() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void connect(String string, int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void connect(InetAddress inetAddress, int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void connect(SocketAddress socketAddress, int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void create(boolean bl) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected InputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getOption(int n) throws SocketException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void listen(int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void sendUrgentData(int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setOption(int n, Object object) throws SocketException {
        throw new UnsupportedOperationException();
    }
}
