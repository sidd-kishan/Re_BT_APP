/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.DropTakeSequence
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SubSequence
 *  kotlin.sequences.TakeSequence
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SubSequence;
import kotlin.sequences.TakeSequence;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class DropSequence<T>
implements Sequence<T>,
DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    public DropSequence(Sequence<? extends T> object, int n) {
        Intrinsics.checkNotNullParameter(object, (String)"sequence");
        this.sequence = object;
        this.count = n;
        n = n >= 0 ? 1 : 0;
        if (n != 0) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("count must be non-negative, but was ");
        ((StringBuilder)object).append(this.count);
        ((StringBuilder)object).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
    }

    public static final /* synthetic */ int access$getCount$p(DropSequence dropSequence) {
        return dropSequence.count;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(DropSequence dropSequence) {
        return dropSequence.sequence;
    }

    public Sequence<T> drop(int n) {
        int n2 = this.count + n;
        DropSequence<T> dropSequence = n2 < 0 ? new DropSequence<T>(this, n) : new DropSequence<T>(this.sequence, n2);
        return dropSequence;
    }

    public Iterator<T> iterator() {
        return (Iterator)new /* Unavailable Anonymous Inner Class!! */;
    }

    public Sequence<T> take(int n) {
        int n2 = this.count;
        int n3 = n2 + n;
        DropTakeSequence dropTakeSequence = n3 < 0 ? (DropTakeSequence)new TakeSequence((Sequence)this, n) : (DropTakeSequence)new SubSequence(this.sequence, n2, n3);
        return (Sequence)dropTakeSequence;
    }
}
