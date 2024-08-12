/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 5, 1})
static final class CombinedContext.toString.1
extends Lambda
implements Function2<String, CoroutineContext.Element, String> {
    public static final CombinedContext.toString.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    CombinedContext.toString.1() {
    }

    public final String invoke(String string, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"acc");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        boolean bl = ((CharSequence)string).length() == 0;
        if (bl) {
            string = element.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(", ");
            stringBuilder.append(element);
            string = stringBuilder.toString();
        }
        return string;
    }
}
