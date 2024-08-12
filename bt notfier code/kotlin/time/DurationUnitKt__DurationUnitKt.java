/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.time.DurationUnitKt$WhenMappings
 *  kotlin.time.DurationUnitKt__DurationUnitJvmKt
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnitKt;
import kotlin.time.DurationUnitKt__DurationUnitJvmKt;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0014\u0010\u0007\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0010\u0010\b\u001a\u00020\t*\u00060\u0001j\u0002`\u0002H\u0001\u00a8\u0006\n"}, d2={"durationUnitByIsoChar", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt
extends DurationUnitKt__DurationUnitJvmKt {
    public static final TimeUnit durationUnitByIsoChar(char c, boolean bl) {
        TimeUnit timeUnit;
        if (!bl) {
            if (c != 'D') {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid or unsupported duration ISO non-time unit: ");
                stringBuilder.append(c);
                throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
            }
            timeUnit = TimeUnit.DAYS;
        } else if (c != 'H') {
            if (c != 'M') {
                if (c != 'S') {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid duration ISO time unit: ");
                    stringBuilder.append(c);
                    throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
                }
                timeUnit = TimeUnit.SECONDS;
            } else {
                timeUnit = TimeUnit.MINUTES;
            }
        } else {
            timeUnit = TimeUnit.HOURS;
        }
        return timeUnit;
    }

    public static final TimeUnit durationUnitByShortName(String object) {
        block8: {
            block9: {
                block2: {
                    block3: {
                        block4: {
                            block5: {
                                block6: {
                                    block7: {
                                        Intrinsics.checkNotNullParameter((Object)object, (String)"shortName");
                                        int n = object.hashCode();
                                        if (n == 100) break block2;
                                        if (n == 104) break block3;
                                        if (n == 109) break block4;
                                        if (n == 115) break block5;
                                        if (n == 3494) break block6;
                                        if (n == 3525) break block7;
                                        if (n != 3742 || !object.equals("us")) break block8;
                                        object = TimeUnit.MICROSECONDS;
                                        break block9;
                                    }
                                    if (!object.equals("ns")) break block8;
                                    object = TimeUnit.NANOSECONDS;
                                    break block9;
                                }
                                if (!object.equals("ms")) break block8;
                                object = TimeUnit.MILLISECONDS;
                                break block9;
                            }
                            if (!object.equals("s")) break block8;
                            object = TimeUnit.SECONDS;
                            break block9;
                        }
                        if (!object.equals("m")) break block8;
                        object = TimeUnit.MINUTES;
                        break block9;
                    }
                    if (!object.equals("h")) break block8;
                    object = TimeUnit.HOURS;
                    break block9;
                }
                if (!object.equals("d")) break block8;
                object = TimeUnit.DAYS;
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown duration unit short name: ");
        stringBuilder.append((String)object);
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public static final String shortName(TimeUnit object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$shortName");
        switch (DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[object.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown unit: ");
                stringBuilder.append(object);
                throw (Throwable)new IllegalStateException(stringBuilder.toString().toString());
            }
            case 7: {
                object = "d";
                break;
            }
            case 6: {
                object = "h";
                break;
            }
            case 5: {
                object = "m";
                break;
            }
            case 4: {
                object = "s";
                break;
            }
            case 3: {
                object = "ms";
                break;
            }
            case 2: {
                object = "us";
                break;
            }
            case 1: {
                object = "ns";
            }
        }
        return object;
    }
}
