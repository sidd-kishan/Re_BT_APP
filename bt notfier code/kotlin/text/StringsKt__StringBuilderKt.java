/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__StringBuilderJVMKt
 */
package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\b\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0016"}, d2={"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringBuilderKt
extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level=DeprecationLevel.WARNING, message="Use append(value: Any?) instead", replaceWith=@ReplaceWith(expression="append(value = obj)", imports={}))
    private static final StringBuilder append(StringBuilder stringBuilder, Object object) {
        stringBuilder.append(object);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(obj)");
        return stringBuilder;
    }

    public static final StringBuilder append(StringBuilder stringBuilder, Object ... objectArray) {
        Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"$this$append");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"value");
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n) {
            stringBuilder.append(objectArray[n2]);
            ++n2;
        }
        return stringBuilder;
    }

    public static final StringBuilder append(StringBuilder stringBuilder, String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringBuilder, (String)"$this$append");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"value");
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            stringBuilder.append(stringArray[n2]);
            ++n2;
        }
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder) {
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder, char c) {
        stringBuilder.append(c);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append(value)");
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder, CharSequence charSequence) {
        stringBuilder.append(charSequence);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append(value)");
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder, Object object) {
        stringBuilder.append(object);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append(value)");
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append(value)");
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder, boolean bl) {
        stringBuilder.append(bl);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append(value)");
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final StringBuilder appendLine(StringBuilder stringBuilder, char[] cArray) {
        stringBuilder.append(cArray);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append(value)");
        stringBuilder.append('\n');
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"append('\\n')");
        return stringBuilder;
    }

    private static final String buildString(int n, Function1<? super StringBuilder, Unit> object) {
        StringBuilder stringBuilder = new StringBuilder(n);
        object.invoke((Object)stringBuilder);
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(object, (String)"StringBuilder(capacity).\u2026builderAction).toString()");
        return object;
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> object) {
        StringBuilder stringBuilder = new StringBuilder();
        object.invoke((Object)stringBuilder);
        object = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(object, (String)"StringBuilder().apply(builderAction).toString()");
        return object;
    }
}
