/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$\u00a2\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int n) {
        this.size = n;
        this.spreads = new Object[n];
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public final void addSpread(T t) {
        Intrinsics.checkNotNullParameter(t, (String)"spreadArgument");
        T[] TArray = this.spreads;
        int n = this.position;
        this.position = n + 1;
        TArray[n] = t;
    }

    protected final int getPosition() {
        return this.position;
    }

    protected abstract int getSize(T var1);

    protected final void setPosition(int n) {
        this.position = n;
    }

    protected final int size() {
        int n = this.size - 1;
        int n2 = 0;
        int n3 = 0;
        if (n < 0) return n2;
        int n4 = 0;
        n2 = n3;
        while (true) {
            T t;
            n3 = (t = this.spreads[n4]) != null ? this.getSize(t) : 1;
            n2 = n3 = n2 + n3;
            if (n4 == n) return n2;
            ++n4;
            n2 = n3;
        }
    }

    protected final T toArray(T t, T t2) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter(t, (String)"values");
        Intrinsics.checkNotNullParameter(t2, (String)"result");
        int n3 = this.size - 1;
        int n4 = 0;
        if (n3 >= 0) {
            int n5 = 0;
            int n6 = 0;
            n4 = 0;
            while (true) {
                T t3 = this.spreads[n5];
                n2 = n6;
                n = n4;
                if (t3 != null) {
                    n = n4;
                    if (n6 < n5) {
                        n = n5 - n6;
                        System.arraycopy(t, n6, t2, n4, n);
                        n = n4 + n;
                    }
                    n4 = this.getSize(t3);
                    System.arraycopy(t3, 0, t2, n, n4);
                    n += n4;
                    n2 = n5 + 1;
                }
                if (n5 == n3) break;
                ++n5;
                n6 = n2;
                n4 = n;
            }
            n4 = n2;
        } else {
            n = 0;
        }
        n2 = this.size;
        if (n4 >= n2) return t2;
        System.arraycopy(t, n4, t2, n, n2 - n4);
        return t2;
    }
}
