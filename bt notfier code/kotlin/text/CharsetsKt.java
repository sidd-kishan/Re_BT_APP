/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u00a8\u0006\u0004"}, d2={"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class CharsetsKt {
    private static final Charset charset(String object) {
        object = Charset.forName((String)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Charset.forName(charsetName)");
        return object;
    }
}
