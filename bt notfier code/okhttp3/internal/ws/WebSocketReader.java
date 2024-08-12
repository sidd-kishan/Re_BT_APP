/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.ws.MessageInflater
 *  okhttp3.internal.ws.WebSocketProtocol
 *  okhttp3.internal.ws.WebSocketReader$FrameCallback
 *  okio.Buffer
 *  okio.Buffer$UnsafeCursor
 *  okio.BufferedSource
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.ws.MessageInflater;
import okhttp3.internal.ws.WebSocketProtocol;
import okhttp3.internal.ws.WebSocketReader;
import okio.Buffer;
import okio.BufferedSource;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001&B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2={"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "isClient", "", "source", "Lokio/BufferedSource;", "frameCallback", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "perMessageDeflate", "noContextTakeover", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "closed", "controlFrameBuffer", "Lokio/Buffer;", "frameLength", "", "isControlFrame", "isFinalFrame", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageFrameBuffer", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "opcode", "", "readingCompressedMessage", "getSource", "()Lokio/BufferedSource;", "close", "", "processNextFrame", "readControlFrame", "readHeader", "readMessage", "readMessageFrame", "readUntilNonControlFrame", "FrameCallback", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebSocketReader
implements Closeable {
    private boolean closed;
    private final Buffer controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final BufferedSource source;

    public WebSocketReader(boolean bl, BufferedSource object, FrameCallback frameCallback, boolean bl2, boolean bl3) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        Intrinsics.checkNotNullParameter((Object)frameCallback, (String)"frameCallback");
        this.isClient = bl;
        this.source = object;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = bl2;
        this.noContextTakeover = bl3;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        bl = this.isClient;
        frameCallback = null;
        object = bl ? null : (Object)new byte[4];
        this.maskKey = (byte[])object;
        object = this.isClient ? frameCallback : new Buffer.UnsafeCursor();
        this.maskCursor = object;
    }

    private final void readControlFrame() throws IOException {
        Object object;
        Object object2;
        long l = this.frameLength;
        if (l > 0L) {
            this.source.readFully(this.controlFrameBuffer, l);
            if (!this.isClient) {
                object2 = this.controlFrameBuffer;
                object = this.maskCursor;
                Intrinsics.checkNotNull((Object)object);
                object2.readAndWriteUnsafe(object);
                this.maskCursor.seek(0L);
                object2 = WebSocketProtocol.INSTANCE;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                object = this.maskKey;
                Intrinsics.checkNotNull((Object)object);
                object2.toggleMask(unsafeCursor, (byte[])object);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            default: {
                throw new ProtocolException(Intrinsics.stringPlus((String)"Unknown control opcode: ", (Object)Util.toHexString((int)this.opcode)));
            }
            case 10: {
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                break;
            }
            case 9: {
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                break;
            }
            case 8: {
                int n = 1005;
                l = this.controlFrameBuffer.size();
                if (l == 1L) throw new ProtocolException("Malformed close payload length of 1.");
                if (l != 0L) {
                    n = this.controlFrameBuffer.readShort();
                    object = this.controlFrameBuffer.readUtf8();
                    object2 = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(n);
                    if (object2 != null) throw new ProtocolException((String)object2);
                } else {
                    object = "";
                }
                this.frameCallback.onReadClose(n, (String)object);
                this.closed = true;
            }
        }
    }

    private final void readHeader() throws IOException, ProtocolException {
        if (this.closed) throw new IOException("closed");
        long l = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        int n = Util.and((byte)this.source.readByte(), (int)255);
        this.opcode = n & 0xF;
        boolean bl = false;
        boolean bl2 = (n & 0x80) != 0;
        this.isFinalFrame = bl2;
        bl2 = (n & 8) != 0;
        this.isControlFrame = bl2;
        if (bl2) {
            if (!this.isFinalFrame) throw new ProtocolException("Control frames must be final.");
        }
        int n2 = (n & 0x40) != 0 ? 1 : 0;
        int n3 = this.opcode;
        if (n3 != 1 && n3 != 2) {
            if (n2 != 0) throw new ProtocolException("Unexpected rsv1 flag");
        } else {
            if (n2 != 0) {
                if (!this.perMessageDeflate) throw new ProtocolException("Unexpected rsv1 flag");
                bl2 = true;
            } else {
                bl2 = false;
            }
            this.readingCompressedMessage = bl2;
        }
        n2 = (n & 0x20) != 0 ? 1 : 0;
        if (n2 != 0) throw new ProtocolException("Unexpected rsv2 flag");
        n2 = (n & 0x10) != 0 ? 1 : 0;
        if (n2 != 0) throw new ProtocolException("Unexpected rsv3 flag");
        n2 = Util.and((byte)this.source.readByte(), (int)255);
        bl2 = bl;
        if ((n2 & 0x80) != 0) {
            bl2 = true;
        }
        if (bl2 == this.isClient) {
            String string = this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.";
            throw new ProtocolException(string);
        }
        this.frameLength = l = (long)(n2 & 0x7F);
        if (l == 126L) {
            this.frameLength = Util.and((short)this.source.readShort(), (int)65535);
        } else if (l == 127L) {
            this.frameLength = l = this.source.readLong();
            if (l < 0L) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Frame length 0x");
                stringBuilder.append(Util.toHexString((long)this.frameLength));
                stringBuilder.append(" > 0x7FFFFFFFFFFFFFFF");
                throw new ProtocolException(stringBuilder.toString());
            }
        }
        if (this.isControlFrame) {
            if (this.frameLength > 125L) throw new ProtocolException("Control frame must be less than 125B.");
        }
        if (!bl2) return;
        BufferedSource bufferedSource = this.source;
        byte[] byArray = this.maskKey;
        Intrinsics.checkNotNull((Object)byArray);
        bufferedSource.readFully(byArray);
        return;
        finally {
            this.source.timeout().timeout(l, TimeUnit.NANOSECONDS);
        }
    }

    private final void readMessage() throws IOException {
        while (true) {
            IOException iOException;
            if (this.closed) {
                iOException = new IOException("closed");
                throw iOException;
            }
            long l = this.frameLength;
            if (l > 0L) {
                this.source.readFully(this.messageFrameBuffer, l);
                if (!this.isClient) {
                    iOException = this.messageFrameBuffer;
                    Object object = this.maskCursor;
                    Intrinsics.checkNotNull((Object)object);
                    iOException.readAndWriteUnsafe((Buffer.UnsafeCursor)object);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    iOException = this.maskCursor;
                    object = this.maskKey;
                    Intrinsics.checkNotNull((Object)object);
                    webSocketProtocol.toggleMask((Buffer.UnsafeCursor)iOException, (byte[])object);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            this.readUntilNonControlFrame();
            if (this.opcode != 0) throw new ProtocolException(Intrinsics.stringPlus((String)"Expected continuation opcode. Got: ", (Object)Util.toHexString((int)this.opcode)));
        }
    }

    private final void readMessageFrame() throws IOException {
        int n = this.opcode;
        if (n != 1) {
            if (n != 2) throw new ProtocolException(Intrinsics.stringPlus((String)"Unknown opcode: ", (Object)Util.toHexString((int)n)));
        }
        this.readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater;
            MessageInflater messageInflater2 = messageInflater = this.messageInflater;
            if (messageInflater == null) {
                this.messageInflater = messageInflater2 = new MessageInflater(this.noContextTakeover);
            }
            messageInflater2.inflate(this.messageFrameBuffer);
        }
        if (n == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            this.readHeader();
            if (!this.isControlFrame) {
                return;
            }
            this.readControlFrame();
        }
    }

    @Override
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater == null) return;
        messageInflater.close();
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        this.readHeader();
        if (this.isControlFrame) {
            this.readControlFrame();
        } else {
            this.readMessageFrame();
        }
    }
}
