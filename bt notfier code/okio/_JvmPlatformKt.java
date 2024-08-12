/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000<\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\t*\u00020\bH\u0000*\n\u0010\u000b\"\u00020\f2\u00020\f*\n\u0010\r\"\u00020\u000e2\u00020\u000e*\n\u0010\u000f\"\u00020\u00102\u00020\u0010*\n\u0010\u0011\"\u00020\u00122\u00020\u0012*\n\u0010\u0013\"\u00020\u00142\u00020\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0015"}, d2={"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "Closeable", "Ljava/io/Closeable;", "EOFException", "Ljava/io/EOFException;", "FileNotFoundException", "Ljava/io/FileNotFoundException;", "IOException", "Ljava/io/IOException;", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _JvmPlatformKt {
    public static final byte[] asUtf8ToByteArray(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = ((String)object).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return object;
    }

    public static final <R> R synchronized(Object object, Function0<? extends R> object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"lock");
        Intrinsics.checkNotNullParameter(object2, (String)"block");
        synchronized (object) {
            try {
                object2 = object2.invoke();
                return (R)object2;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl9 : MonitorExitStatement: MONITOREXIT : var0
                InlineMarker.finallyEnd((int)1);
            }
        }
    }

    public static final String toUtf8String(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        return new String(byArray, Charsets.UTF_8);
    }
}
