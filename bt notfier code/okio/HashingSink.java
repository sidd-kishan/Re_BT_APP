/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ByteString
 *  okio.ForwardingSink
 *  okio.HashingSink$Companion
 *  okio.Segment
 *  okio.Sink
 *  okio._UtilKt
 */
package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSink;
import okio.HashingSink;
import okio.Segment;
import okio.Sink;
import okio._UtilKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0007\u00a2\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0010\u001a\u00020\u000e8G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "digest", "Ljava/security/MessageDigest;", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "messageDigest", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class HashingSink
extends ForwardingSink
implements Sink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public HashingSink(Sink sink, String object) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)object, (String)"algorithm");
        object = MessageDigest.getInstance((String)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getInstance(algorithm)");
        this(sink, (MessageDigest)object);
    }

    public HashingSink(Sink sink, MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)messageDigest, (String)"digest");
        super(sink);
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    public HashingSink(Sink sink, Mac mac) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)mac, (String)"mac");
        super(sink);
        this.mac = mac;
        this.messageDigest = null;
    }

    public HashingSink(Sink sink, ByteString byteString, String string) {
        Mac mac;
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        Intrinsics.checkNotNullParameter((Object)string, (String)"algorithm");
        try {
            mac = Mac.getInstance(string);
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteString.toByteArray(), string);
            mac.init(secretKeySpec);
            byteString = Unit.INSTANCE;
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new IllegalArgumentException(invalidKeyException);
        }
        Intrinsics.checkNotNullExpressionValue((Object)mac, (String)"try {\n      Mac.getInsta\u2026rgumentException(e)\n    }");
        this(sink, mac);
    }

    @JvmStatic
    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="hash", imports={}))
    public final ByteString _deprecated_hash() {
        return this.hash();
    }

    public final ByteString hash() {
        Object object = this.messageDigest;
        if (object != null) {
            object = ((MessageDigest)object).digest();
        } else {
            object = this.mac;
            Intrinsics.checkNotNull((Object)object);
            object = ((Mac)object).doFinal();
        }
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"result");
        return new ByteString((byte[])object);
    }

    public void write(Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)l);
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        long l2 = 0L;
        while (true) {
            if (l2 >= l) {
                super.write(buffer, l);
                return;
            }
            int n = (int)Math.min(l - l2, (long)(segment.limit - segment.pos));
            Object object = this.messageDigest;
            if (object != null) {
                ((MessageDigest)object).update(segment.data, segment.pos, n);
            } else {
                object = this.mac;
                Intrinsics.checkNotNull((Object)object);
                ((Mac)object).update(segment.data, segment.pos, n);
            }
            l2 += (long)n;
            segment = segment.next;
            Intrinsics.checkNotNull((Object)segment);
        }
    }
}
