/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002\u00a8\u0006\u0006"}, d2={"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class ExceptionsKt {
    public static final /* synthetic */ String access$constructMessage(File file, File file2, String string) {
        return ExceptionsKt.constructMessage(file, file2, string);
    }

    private static final String constructMessage(File object, File serializable, String string) {
        object = new StringBuilder(((File)object).toString());
        if (serializable != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" -> ");
            stringBuilder.append(serializable);
            ((StringBuilder)object).append(stringBuilder.toString());
        }
        if (string != null) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(": ");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)object).append(((StringBuilder)serializable).toString());
        }
        object = ((StringBuilder)object).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"sb.toString()");
        return object;
    }
}
