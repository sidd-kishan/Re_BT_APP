/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000\u00a2\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a7\u0010\u0010\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2={"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__AppendableKt {
    public static final <T extends Appendable> T append(T t, CharSequence ... charSequenceArray) {
        Intrinsics.checkNotNullParameter(t, (String)"$this$append");
        Intrinsics.checkNotNullParameter((Object)charSequenceArray, (String)"value");
        int n = charSequenceArray.length;
        int n2 = 0;
        while (n2 < n) {
            t.append(charSequenceArray[n2]);
            ++n2;
        }
        return t;
    }

    public static final <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter((Object)appendable, (String)"$this$appendElement");
        if (function1 != null) {
            appendable.append((CharSequence)function1.invoke(t));
        } else {
            boolean bl = t != null ? t instanceof CharSequence : true;
            if (bl) {
                appendable.append((CharSequence)t);
            } else if (t instanceof Character) {
                appendable.append(((Character)t).charValue());
            } else {
                appendable.append(String.valueOf(t));
            }
        }
    }

    private static final Appendable appendLine(Appendable appendable) {
        appendable = appendable.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)appendable, (String)"append('\\n')");
        return appendable;
    }

    private static final Appendable appendLine(Appendable appendable, char c) {
        appendable = appendable.append(c);
        Intrinsics.checkNotNullExpressionValue((Object)appendable, (String)"append(value)");
        appendable = appendable.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)appendable, (String)"append('\\n')");
        return appendable;
    }

    private static final Appendable appendLine(Appendable appendable, CharSequence charSequence) {
        appendable = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue((Object)appendable, (String)"append(value)");
        appendable = appendable.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)appendable, (String)"append('\\n')");
        return appendable;
    }

    public static final <T extends Appendable> T appendRange(T object, CharSequence charSequence, int n, int n2) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$appendRange");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"value");
        object = object.append(charSequence, n, n2);
        if (object == null) throw new NullPointerException("null cannot be cast to non-null type T");
        return object;
    }
}