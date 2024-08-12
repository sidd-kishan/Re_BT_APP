/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 *  kotlin.text.FlagEnum
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.FlagEnum;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"<anonymous>", "", "T", "Lkotlin/text/FlagEnum;", "", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Enum;)Z", "kotlin/text/RegexKt$fromInt$1$1"}, k=3, mv={1, 5, 1})
public static final class Regex$fromInt$.inlined.apply.lambda.1
extends Lambda
implements Function1<T, Boolean> {
    final int $value$inlined;

    public Regex$fromInt$.inlined.apply.lambda.1(int n) {
        this.$value$inlined = n;
        super(1);
    }

    public final boolean invoke(T object) {
        int n = this.$value$inlined;
        boolean bl = (n & (object = (FlagEnum)object).getMask()) == object.getValue();
        return bl;
    }
}
