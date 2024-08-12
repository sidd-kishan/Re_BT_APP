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
 *  okio.ForwardingSource
 *  okio.HashingSource$Companion
 *  okio.Segment
 *  okio.Source
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
import okio.ForwardingSource;
import okio.HashingSource;
import okio.Segment;
import okio.Source;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0007\u00a2\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0011\u0010\u0010\u001a\u00020\u000e8G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", "digest", "Ljava/security/MessageDigest;", "(Lokio/Source;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Source;Ljavax/crypto/Mac;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "messageDigest", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class HashingSource
extends ForwardingSource
implements Source {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public HashingSource(Source source, String object) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)object, (String)"algorithm");
        object = MessageDigest.getInstance((String)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getInstance(algorithm)");
        this(source, (MessageDigest)object);
    }

    public HashingSource(Source source, MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)messageDigest, (String)"digest");
        super(source);
        this.messageDigest = messageDigest;
        this.mac = null;
    }

    public HashingSource(Source source, Mac mac) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)mac, (String)"mac");
        super(source);
        this.mac = mac;
        this.messageDigest = null;
    }

    public HashingSource(Source source, ByteString byteString, String string) {
        Mac mac;
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
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
        this(source, mac);
    }

    @JvmStatic
    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @JvmStatic
    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    @JvmStatic
    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    @JvmStatic
    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    @JvmStatic
    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
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

    public long read(Buffer buffer, long l) throws IOException {
        Segment segment;
        long l2;
        long l3;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        long l4 = super.read(buffer, l);
        if (l4 == -1L) return l4;
        long l5 = buffer.size() - l4;
        l = buffer.size();
        Object object = buffer.head;
        Intrinsics.checkNotNull((Object)object);
        while (true) {
            l3 = l5;
            l2 = l;
            segment = object;
            if (l <= l5) break;
            object = ((Segment)object).prev;
            Intrinsics.checkNotNull((Object)object);
            l -= (long)(((Segment)object).limit - ((Segment)object).pos);
        }
        while (l2 < buffer.size()) {
            int n = (int)((long)segment.pos + l3 - l2);
            object = this.messageDigest;
            if (object != null) {
                ((MessageDigest)object).update(segment.data, n, segment.limit - n);
            } else {
                object = this.mac;
                Intrinsics.checkNotNull((Object)object);
                ((Mac)object).update(segment.data, n, segment.limit - n);
            }
            segment = segment.next;
            Intrinsics.checkNotNull((Object)segment);
            l3 = l2 += (long)(segment.limit - segment.pos);
        }
        return l4;
    }
}
