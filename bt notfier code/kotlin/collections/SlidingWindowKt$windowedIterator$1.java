/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.RingBuffer
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.RestrictedSuspendLambda
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.SequenceScope
 */
package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.RingBuffer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.collections.SlidingWindowKt$windowedIterator$1", f="SlidingWindow.kt", i={}, l={34, 40, 49, 55, 58}, m="invokeSuspend", n={}, s={})
static final class SlidingWindowKt.windowedIterator.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final Iterator $iterator;
    final boolean $partialWindows;
    final boolean $reuseBuffer;
    final int $size;
    final int $step;
    int I$0;
    private Object L$0;
    Object L$1;
    Object L$2;
    int label;

    SlidingWindowKt.windowedIterator.1(int n, int n2, Iterator iterator, boolean bl, boolean bl2, Continuation continuation) {
        this.$size = n;
        this.$step = n2;
        this.$iterator = iterator;
        this.$reuseBuffer = bl;
        this.$partialWindows = bl2;
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
        block14: {
            block15: {
                block16: {
                    block17: {
                        block18: {
                            var11_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            var2_3 = this.label;
                            if (var2_3 == 0) break block14;
                            if (var2_3 == 1) break block15;
                            if (var2_3 == 2) break block16;
                            if (var2_3 == 3) break block17;
                            if (var2_3 == 4) break block18;
                            if (var2_3 != 5) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            break block16;
                        }
                        var6_4 /* !! */  = (RingBuffer)this.L$1;
                        var7_6 = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure((Object)var1_1);
                        var9_8 = this;
                        ** GOTO lbl125
                    }
                    var7_6 = (Iterator)this.L$2;
                    var5_9 /* !! */  = (RingBuffer)this.L$1;
                    var8_10 /* !! */  = (SequenceScope)this.L$0;
                    ResultKt.throwOnFailure((Object)var1_1);
                    var9_8 = this;
                    var1_1 = var5_9 /* !! */ ;
                    ** GOTO lbl99
                }
                ResultKt.throwOnFailure((Object)var1_1);
                return Unit.INSTANCE;
            }
            var2_3 = this.I$0;
            var7_7 = (Iterator)this.L$2;
            var8_11 /* !! */  = (ArrayList)this.L$1;
            var5_9 /* !! */  = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure((Object)var1_1);
            var6_5 = this;
            var1_1 = var8_11 /* !! */ ;
            ** GOTO lbl66
        }
        ResultKt.throwOnFailure((Object)var1_1);
        var5_9 /* !! */  = (SequenceScope)this.L$0;
        var3_12 = RangesKt.coerceAtMost((int)this.$size, (int)1024);
        var2_3 = this.$step - this.$size;
        if (var2_3 < 0) {
            var1_1 = new RingBuffer(var3_12);
            var7_6 = this.$iterator;
            var6_4 /* !! */  = var5_9 /* !! */ ;
            var5_9 /* !! */  = this;
        } else {
            var1_1 = new ArrayList(var3_12);
            var3_12 = 0;
            var7_7 = this.$iterator;
            var6_5 = this;
            while (var7_7.hasNext()) {
                var8_11 /* !! */  = var7_7.next();
                if (var3_12 > 0) {
                    --var3_12;
                    continue;
                }
                var1_1.add(var8_11 /* !! */ );
                if (var1_1.size() != var6_5.$size) continue;
                var6_5.L$0 = var5_9 /* !! */ ;
                var6_5.L$1 = var1_1;
                var6_5.L$2 = var7_7;
                var6_5.I$0 = var2_3;
                var6_5.label = 1;
                if (var5_9 /* !! */ .yield(var1_1, (Continuation)var6_5) == var11_2) {
                    return var11_2;
                }
lbl66:
                // 3 sources

                if (var6_5.$reuseBuffer) {
                    var1_1.clear();
                } else {
                    var1_1 = new ArrayList<E>(var6_5.$size);
                }
                var4_13 = var2_3;
                var3_12 = var2_3;
                var2_3 = var4_13;
            }
            if ((((Collection)var1_1).isEmpty() ^ true) == false) return Unit.INSTANCE;
            if (!var6_5.$partialWindows) {
                if (var1_1.size() != var6_5.$size) return Unit.INSTANCE;
            }
            var6_5.L$0 = null;
            var6_5.L$1 = null;
            var6_5.L$2 = null;
            var6_5.label = 2;
            if (var5_9 /* !! */ .yield(var1_1, (Continuation)var6_5) != var11_2) return Unit.INSTANCE;
            return var11_2;
        }
        while (var7_6.hasNext()) {
            var1_1.add(var7_6.next());
            if (!var1_1.isFull()) continue;
            var2_3 = var1_1.size();
            if (var2_3 < (var3_12 = var5_9 /* !! */ .$size)) {
                var1_1 = var1_1.expanded(var3_12);
                continue;
            }
            var10_14 = var5_9 /* !! */ .$reuseBuffer != false ? (List)var1_1 : (List)new ArrayList<E>((Collection)var1_1);
            var5_9 /* !! */ .L$0 = var6_4 /* !! */ ;
            var5_9 /* !! */ .L$1 = var1_1;
            var5_9 /* !! */ .L$2 = var7_6;
            var5_9 /* !! */ .label = 3;
            var8_10 /* !! */  = var6_4 /* !! */ ;
            var9_8 = var5_9 /* !! */ ;
            if (var6_4 /* !! */ .yield((Object)var10_14, (Continuation)var5_9 /* !! */ ) == var11_2) {
                return var11_2;
            }
lbl99:
            // 3 sources

            var1_1.removeFirst(var9_8.$step);
            var6_4 /* !! */  = var8_10 /* !! */ ;
            var5_9 /* !! */  = var9_8;
        }
        if (var5_9 /* !! */ .$partialWindows == false) return Unit.INSTANCE;
        var7_6 = var1_1;
        var1_1 = var6_4 /* !! */ ;
        var6_4 /* !! */  = var7_6;
        while (true) {
            if (var6_4 /* !! */ .size() <= var5_9 /* !! */ .$step) {
                if ((((Collection)var6_4 /* !! */ ).isEmpty() ^ true) == false) return Unit.INSTANCE;
                var5_9 /* !! */ .L$0 = null;
                var5_9 /* !! */ .L$1 = null;
                var5_9 /* !! */ .L$2 = null;
                var5_9 /* !! */ .label = 5;
                if (var1_1.yield((Object)var6_4 /* !! */ , (Continuation)var5_9 /* !! */ ) != var11_2) return Unit.INSTANCE;
                return var11_2;
            }
            var8_10 /* !! */  = var5_9 /* !! */ .$reuseBuffer != false ? (List)var6_4 /* !! */  : (List)new ArrayList<E>((Collection)var6_4 /* !! */ );
            var5_9 /* !! */ .L$0 = var1_1;
            var5_9 /* !! */ .L$1 = var6_4 /* !! */ ;
            var5_9 /* !! */ .L$2 = null;
            var5_9 /* !! */ .label = 4;
            var7_6 = var1_1;
            var9_8 = var5_9 /* !! */ ;
            if (var1_1.yield((Object)var8_10 /* !! */ , (Continuation)var5_9 /* !! */ ) == var11_2) {
                return var11_2;
            }
lbl125:
            // 3 sources

            var6_4 /* !! */ .removeFirst(var9_8.$step);
            var1_1 = var7_6;
            var5_9 /* !! */  = var9_8;
        }
    }
}
