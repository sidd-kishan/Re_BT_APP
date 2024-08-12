/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.net.DatagramSocketWrapper$DatagramSocketImplWrapper
 */
package androidx.core.net;

import androidx.core.net.DatagramSocketWrapper;
import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;

class DatagramSocketWrapper
extends Socket {
    DatagramSocketWrapper(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) throws SocketException {
        super((SocketImpl)new DatagramSocketImplWrapper(datagramSocket, fileDescriptor));
    }
}
