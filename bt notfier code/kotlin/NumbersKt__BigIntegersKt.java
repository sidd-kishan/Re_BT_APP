/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NumbersKt__BigDecimalsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.NumbersKt__BigDecimalsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0087\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u00a8\u0006\u0019"}, d2={"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__BigIntegersKt
extends NumbersKt__BigDecimalsKt {
    private static final BigInteger and(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger.and(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.and(other)");
        return bigInteger;
    }

    private static final BigInteger dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$dec");
        bigInteger = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.subtract(BigInteger.ONE)");
        return bigInteger;
    }

    private static final BigInteger div(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$div");
        bigInteger = bigInteger.divide(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.divide(other)");
        return bigInteger;
    }

    private static final BigInteger inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$inc");
        bigInteger = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(BigInteger.ONE)");
        return bigInteger;
    }

    private static final BigInteger inv(BigInteger bigInteger) {
        bigInteger = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.not()");
        return bigInteger;
    }

    private static final BigInteger minus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$minus");
        bigInteger = bigInteger.subtract(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.subtract(other)");
        return bigInteger;
    }

    private static final BigInteger or(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger.or(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.or(other)");
        return bigInteger;
    }

    private static final BigInteger plus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$plus");
        bigInteger = bigInteger.add(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.add(other)");
        return bigInteger;
    }

    private static final BigInteger rem(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$rem");
        bigInteger = bigInteger.remainder(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.remainder(other)");
        return bigInteger;
    }

    private static final BigInteger shl(BigInteger bigInteger, int n) {
        bigInteger = bigInteger.shiftLeft(n);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.shiftLeft(n)");
        return bigInteger;
    }

    private static final BigInteger shr(BigInteger bigInteger, int n) {
        bigInteger = bigInteger.shiftRight(n);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.shiftRight(n)");
        return bigInteger;
    }

    private static final BigInteger times(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$times");
        bigInteger = bigInteger.multiply(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.multiply(other)");
        return bigInteger;
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger, int n, MathContext mathContext) {
        return new BigDecimal(bigInteger, n, mathContext);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int n, MathContext mathContext, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        if ((n2 & 2) == 0) return new BigDecimal(bigInteger, n, mathContext);
        mathContext = MathContext.UNLIMITED;
        Intrinsics.checkNotNullExpressionValue((Object)mathContext, (String)"MathContext.UNLIMITED");
        return new BigDecimal(bigInteger, n, mathContext);
    }

    private static final BigInteger toBigInteger(int n) {
        BigInteger bigInteger = BigInteger.valueOf(n);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this.toLong())");
        return bigInteger;
    }

    private static final BigInteger toBigInteger(long l) {
        BigInteger bigInteger = BigInteger.valueOf(l);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"BigInteger.valueOf(this)");
        return bigInteger;
    }

    private static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter((Object)bigInteger, (String)"$this$unaryMinus");
        bigInteger = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.negate()");
        return bigInteger;
    }

    private static final BigInteger xor(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger.xor(bigInteger2);
        Intrinsics.checkNotNullExpressionValue((Object)bigInteger, (String)"this.xor(other)");
        return bigInteger;
    }
}
