/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.time.AbstractLongTimeSource
 *  kotlin.time.Duration
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.time.AbstractLongTimeSource;
import kotlin.time.Duration;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2={"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class TestTimeSource
extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    private final void overflow_LRDsOJo(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TestTimeSource will overflow if its reading ");
        stringBuilder.append(this.reading);
        stringBuilder.append("ns is advanced by ");
        stringBuilder.append(Duration.toString_impl((long)l));
        stringBuilder.append('.');
        throw (Throwable)new IllegalStateException(stringBuilder.toString());
    }

    public final void plusAssign_LRDsOJo(long l) {
        long l2;
        long l3 = Duration.toLong_impl((long)l, (TimeUnit)this.getUnit());
        if (l3 != Long.MIN_VALUE && l3 != Long.MAX_VALUE) {
            long l4;
            long l5 = this.reading;
            l2 = l4 = l5 + l3;
            if ((l3 ^ l5) >= 0L) {
                l2 = l4;
                if ((l5 ^ l4) < 0L) {
                    this.overflow_LRDsOJo(l);
                    l2 = l4;
                }
            }
        } else {
            double d = Duration.toDouble_impl((long)l, (TimeUnit)this.getUnit());
            double d2 = this.reading;
            Double.isNaN(d2);
            if ((d2 += d) > (double)Long.MAX_VALUE || d2 < (double)Long.MIN_VALUE) {
                this.overflow_LRDsOJo(l);
            }
            l2 = (long)d2;
        }
        this.reading = l2;
    }

    protected long read() {
        return this.reading;
    }
}
