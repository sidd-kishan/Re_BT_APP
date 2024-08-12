/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.ByteString
 *  okio.HashingSource
 *  okio.Source
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio.HashingSource;
import okio.Source;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2={"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class HashingSource.Companion {
    private HashingSource.Companion() {
    }

    public /* synthetic */ HashingSource.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final HashingSource hmacSha1(Source source, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    @JvmStatic
    public final HashingSource hmacSha256(Source source, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    @JvmStatic
    public final HashingSource hmacSha512(Source source, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"key");
        return new HashingSource(source, byteString, "HmacSHA512");
    }

    @JvmStatic
    public final HashingSource md5(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return new HashingSource(source, "MD5");
    }

    @JvmStatic
    public final HashingSource sha1(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return new HashingSource(source, "SHA-1");
    }

    @JvmStatic
    public final HashingSource sha256(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return new HashingSource(source, "SHA-256");
    }

    @JvmStatic
    public final HashingSource sha512(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return new HashingSource(source, "SHA-512");
    }
}
