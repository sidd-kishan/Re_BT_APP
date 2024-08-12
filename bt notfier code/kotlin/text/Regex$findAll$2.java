/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.FunctionReferenceImpl
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.MatchResult
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "Lkotlin/text/MatchResult;", "p1", "invoke"}, k=3, mv={1, 5, 1})
static final class Regex.findAll.2
extends FunctionReferenceImpl
implements Function1<MatchResult, MatchResult> {
    public static final Regex.findAll.2 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    Regex.findAll.2() {
    }

    public final MatchResult invoke(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter((Object)matchResult, (String)"p1");
        return matchResult.next();
    }
}
