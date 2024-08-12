/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.RestrictedSuspendLambda
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.SequenceScope
 *  kotlin.text.Regex
 */
package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlin.text.Regex;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.text.Regex$splitToSequence$1", f="Regex.kt", i={}, l={243, 251, 255}, m="invokeSuspend", n={}, s={})
static final class Regex.splitToSequence.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final CharSequence $input;
    final int $limit;
    int I$0;
    private Object L$0;
    Object L$1;
    int label;
    final Regex this$0;

    Regex.splitToSequence.1(Regex regex, CharSequence charSequence, int n, Continuation continuation) {
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = n;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
        Intrinsics.checkNotNullParameter(object2, (String)"completion");
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(Object object, Object object2) {
        return (this.create(object, (Continuation)object2)).invokeSuspend(Unit.INSTANCE);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object invokeSuspend(Object var1_1) {
        block5: {
            var10_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            var2_3 = this.label;
            if (var2_3 == 0) break block5;
            if (var2_3 == 1) {
                ResultKt.throwOnFailure((Object)var1_1);
                return Unit.INSTANCE;
            }
            if (var2_3 != 2) {
                if (var2_3 != 3) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                ResultKt.throwOnFailure((Object)var1_1);
                return Unit.INSTANCE;
            }
            var2_3 = this.I$0;
            var5_4 = (Matcher)this.L$1;
            var6_5 /* !! */  = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure((Object)var1_1);
            var7_6 = this;
            var1_1 = var6_5 /* !! */ ;
            ** GOTO lbl41
        }
        ResultKt.throwOnFailure((Object)var1_1);
        var8_7 /* !! */  = (SequenceScope)this.L$0;
        var9_8 = Regex.access$getNativePattern$p((Regex)this.this$0).matcher(this.$input);
        if (this.$limit == 1 || !var9_8.find()) {
            var1_1 = this.$input.toString();
            this.label = 1;
            if (var8_7 /* !! */ .yield(var1_1, (Continuation)this) != var10_2) return Unit.INSTANCE;
            return var10_2;
        }
        var6_5 /* !! */  = this;
        var3_9 = 0;
        var2_3 = 0;
        do {
            var11_11 = var6_5 /* !! */ .$input.subSequence(var3_9, var9_8.start()).toString();
            var6_5 /* !! */ .L$0 = var8_7 /* !! */ ;
            var6_5 /* !! */ .L$1 = var9_8;
            var6_5 /* !! */ .I$0 = var2_3;
            var6_5 /* !! */ .label = 2;
            var5_4 = var9_8;
            var1_1 = var8_7 /* !! */ ;
            var7_6 = var6_5 /* !! */ ;
            if (var8_7 /* !! */ .yield((Object)var11_11, (Continuation)var6_5 /* !! */ ) == var10_2) {
                return var10_2;
            }
lbl41:
            // 3 sources

            var4_10 = var5_4.end();
            if (++var2_3 == var7_6.$limit - 1) break;
            var9_8 = var5_4;
            var8_7 /* !! */  = var1_1;
            var6_5 /* !! */  = var7_6;
            var3_9 = var4_10;
        } while (var5_4.find());
        var5_4 = var7_6.$input;
        var5_4 = var5_4.subSequence(var4_10, var5_4.length()).toString();
        var7_6.L$0 = null;
        var7_6.L$1 = null;
        var7_6.label = 3;
        if (var1_1.yield(var5_4, (Continuation)var7_6) != var10_2) return Unit.INSTANCE;
        return var10_2;
    }
}
