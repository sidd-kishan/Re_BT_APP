/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.TimeMark
 */
package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeMark;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2={"compareTo", "", "Lkotlin/time/TimeMark;", "other", "minus", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)J", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class TimeSourceKt {
    @Deprecated(level=DeprecationLevel.ERROR, message="Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final int compareTo(TimeMark timeMark, TimeMark timeMark2) {
        Intrinsics.checkNotNullParameter((Object)timeMark, (String)"$this$compareTo");
        throw (Throwable)new Error("Operation is disallowed.");
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final long minus(TimeMark timeMark, TimeMark timeMark2) {
        Intrinsics.checkNotNullParameter((Object)timeMark, (String)"$this$minus");
        throw (Throwable)new Error("Operation is disallowed.");
    }
}
