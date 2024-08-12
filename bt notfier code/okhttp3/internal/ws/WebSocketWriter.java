/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.ws.MessageDeflater
 *  okhttp3.internal.ws.WebSocketProtocol
 *  okio.Buffer
 *  okio.Buffer$UnsafeCursor
 *  okio.BufferedSink
 *  okio.ByteString
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.MessageDeflater;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!H\u0002J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020!J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2={"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "isClient", "", "sink", "Lokio/BufferedSink;", "random", "Ljava/util/Random;", "perMessageDeflate", "noContextTakeover", "minimumDeflateSize", "", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageBuffer", "Lokio/Buffer;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "getRandom", "()Ljava/util/Random;", "getSink", "()Lokio/BufferedSink;", "sinkBuffer", "writerClosed", "close", "", "writeClose", "code", "", "reason", "Lokio/ByteString;", "writeControlFrame", "opcode", "payload", "writeMessageFrame", "formatOpcode", "data", "writePing", "writePong", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSocketWriter
implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean bl, BufferedSink object, Random random, boolean bl2, boolean bl3, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        this.isClient = bl;
        this.sink = object;
        this.random = random;
        this.perMessageDeflate = bl2;
        this.noContextTakeover = bl3;
        this.minimumDeflateSize = l;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = this.sink.getBuffer();
        bl = this.isClient;
        random = null;
        object = bl ? (Object)new byte[4] : null;
        this.maskKey = (byte[])object;
        object = random;
        if (this.isClient) {
            object = new Buffer.UnsafeCursor();
        }
        this.maskCursor = object;
    }

    private final void writeControlFrame(int n, ByteString byteString) throws IOException {
        if (this.writerClosed) throw new IOException("closed");
        int n2 = byteString.size();
        boolean bl = (long)n2 <= 125L;
        if (!bl) throw (Throwable)new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        this.sinkBuffer.writeByte(n | 0x80);
        if (this.isClient) {
            this.sinkBuffer.writeByte(n2 | 0x80);
            Random random = this.random;
            byte[] byArray = this.maskKey;
            Intrinsics.checkNotNull((Object)byArray);
            random.nextBytes(byArray);
            this.sinkBuffer.write(this.maskKey);
            if (n2 > 0) {
                long l = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                random = this.sinkBuffer;
                byteString = this.maskCursor;
                Intrinsics.checkNotNull((Object)byteString);
                random.readAndWriteUnsafe((Buffer.UnsafeCursor)byteString);
                this.maskCursor.seek(l);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(n2);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    @Override
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater == null) return;
        messageDeflater.close();
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int n, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (n != 0 || byteString != null) {
            if (n != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(n);
            }
            byteString2 = new Buffer();
            byteString2.writeShort(n);
            if (byteString != null) {
                byteString2.write(byteString);
            }
            byteString2 = byteString2.readByteString();
        }
        try {
            this.writeControlFrame(8, byteString2);
            return;
        }
        finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int n, ByteString object) throws IOException {
        Object object2;
        int n2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"data");
        if (this.writerClosed) throw new IOException("closed");
        this.messageBuffer.write((ByteString)object);
        int n3 = 128;
        n = n2 = n | 0x80;
        if (this.perMessageDeflate) {
            n = n2;
            if ((long)object.size() >= this.minimumDeflateSize) {
                object2 = this.messageDeflater;
                object = object2;
                if (object2 == null) {
                    object = new MessageDeflater(this.noContextTakeover);
                    this.messageDeflater = object;
                }
                object.deflate(this.messageBuffer);
                n = n2 | 0x40;
            }
        }
        long l = this.messageBuffer.size();
        this.sinkBuffer.writeByte(n);
        n = this.isClient ? n3 : 0;
        if (l <= 125L) {
            n3 = (int)l;
            this.sinkBuffer.writeByte(n3 | n);
        } else if (l <= 65535L) {
            this.sinkBuffer.writeByte(n | 0x7E);
            this.sinkBuffer.writeShort((int)l);
        } else {
            this.sinkBuffer.writeByte(n | 0x7F);
            this.sinkBuffer.writeLong(l);
        }
        if (this.isClient) {
            object = this.random;
            object2 = this.maskKey;
            Intrinsics.checkNotNull((Object)object2);
            ((Random)object).nextBytes((byte[])object2);
            this.sinkBuffer.write(this.maskKey);
            if (l > 0L) {
                object = this.messageBuffer;
                object2 = this.maskCursor;
                Intrinsics.checkNotNull((Object)object2);
                object.readAndWriteUnsafe((Buffer.UnsafeCursor)object2);
                this.maskCursor.seek(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, l);
        this.sink.emit();
    }

    public final void writePing(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"payload");
        this.writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"payload");
        this.writeControlFrame(10, byteString);
    }
}
