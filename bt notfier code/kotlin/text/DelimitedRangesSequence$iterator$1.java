/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.text.DelimitedRangesSequence
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.StringsKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u001c"}, d2={"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class DelimitedRangesSequence.iterator.1
implements Iterator<IntRange>,
KMappedMarker {
    private int counter;
    private int currentStartIndex;
    private IntRange nextItem;
    private int nextSearchIndex;
    private int nextState;
    final DelimitedRangesSequence this$0;

    DelimitedRangesSequence.iterator.1(DelimitedRangesSequence delimitedRangesSequence) {
        int n;
        this.this$0 = delimitedRangesSequence;
        this.nextState = -1;
        this.currentStartIndex = n = RangesKt.coerceIn((int)DelimitedRangesSequence.access$getStartIndex$p((DelimitedRangesSequence)delimitedRangesSequence), (int)0, (int)DelimitedRangesSequence.access$getInput$p((DelimitedRangesSequence)delimitedRangesSequence).length());
        this.nextSearchIndex = n;
    }

    /*
     * Unable to fully structure code
     */
    private final void calcNext() {
        block6: {
            block7: {
                block5: {
                    var2_1 = this.nextSearchIndex;
                    var1_2 = 0;
                    if (var2_1 >= 0) break block5;
                    this.nextState = 0;
                    this.nextItem = null;
                    break block6;
                }
                if (DelimitedRangesSequence.access$getLimit$p((DelimitedRangesSequence)this.this$0) <= 0) break block7;
                this.counter = var2_1 = this.counter + 1;
                if (var2_1 >= DelimitedRangesSequence.access$getLimit$p((DelimitedRangesSequence)this.this$0)) ** GOTO lbl-1000
            }
            if (this.nextSearchIndex > DelimitedRangesSequence.access$getInput$p((DelimitedRangesSequence)this.this$0).length()) lbl-1000:
            // 2 sources

            {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex((CharSequence)DelimitedRangesSequence.access$getInput$p((DelimitedRangesSequence)this.this$0)));
                this.nextSearchIndex = -1;
            } else {
                var4_3 = (Pair)DelimitedRangesSequence.access$getGetNextMatch$p((DelimitedRangesSequence)this.this$0).invoke((Object)DelimitedRangesSequence.access$getInput$p((DelimitedRangesSequence)this.this$0), (Object)this.nextSearchIndex);
                if (var4_3 == null) {
                    this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex((CharSequence)DelimitedRangesSequence.access$getInput$p((DelimitedRangesSequence)this.this$0)));
                    this.nextSearchIndex = -1;
                } else {
                    var3_4 = ((Number)var4_3.component1()).intValue();
                    var2_1 = ((Number)var4_3.component2()).intValue();
                    this.nextItem = RangesKt.until((int)this.currentStartIndex, (int)var3_4);
                    this.currentStartIndex = var3_4 += var2_1;
                    if (var2_1 == 0) {
                        var1_2 = 1;
                    }
                    this.nextSearchIndex = var3_4 + var1_2;
                }
            }
            this.nextState = 1;
        }
    }

    public final int getCounter() {
        return this.counter;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    public final IntRange getNextItem() {
        return this.nextItem;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override
    public boolean hasNext() {
        if (this.nextState == -1) {
            this.calcNext();
        }
        int n = this.nextState;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    @Override
    public IntRange next() {
        if (this.nextState == -1) {
            this.calcNext();
        }
        if (this.nextState == 0) throw (Throwable)new NoSuchElementException();
        IntRange intRange = this.nextItem;
        if (intRange == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.nextItem = null;
        this.nextState = -1;
        return intRange;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCounter(int n) {
        this.counter = n;
    }

    public final void setCurrentStartIndex(int n) {
        this.currentStartIndex = n;
    }

    public final void setNextItem(IntRange intRange) {
        this.nextItem = intRange;
    }

    public final void setNextSearchIndex(int n) {
        this.nextSearchIndex = n;
    }

    public final void setNextState(int n) {
        this.nextState = n;
    }
}
