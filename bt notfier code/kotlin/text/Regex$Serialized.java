/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.Regex$Serialized$Companion
 */
package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class Regex.Serialized
implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0L;
    private final int flags;
    private final String pattern;

    public Regex.Serialized(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"pattern");
        this.pattern = string;
        this.flags = n;
    }

    private final Object readResolve() {
        Pattern pattern = Pattern.compile(this.pattern, this.flags);
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"Pattern.compile(pattern, flags)");
        return new Regex(pattern);
    }

    public final int getFlags() {
        return this.flags;
    }

    public final String getPattern() {
        return this.pattern;
    }
}
