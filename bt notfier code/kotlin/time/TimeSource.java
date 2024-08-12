/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.time.TimeMark
 *  kotlin.time.TimeSource$Companion
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2={"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public interface TimeSource {
    public static final Companion Companion = kotlin.time.TimeSource$Companion.$$INSTANCE;

    public TimeMark markNow();
}
