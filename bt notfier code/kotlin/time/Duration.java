/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  kotlin.ranges.ClosedRange
 *  kotlin.ranges.LongRange
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlin.time.Duration$Companion
 *  kotlin.time.DurationKt
 *  kotlin.time.DurationUnitKt
 *  kotlin.time.FormatToDecimalsKt
 */
package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnitKt;
import kotlin.time.FormatToDecimalsKt;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 \u00ac\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u00ac\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bV\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bV\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\\2\b\u0010Q\u001a\u0004\u0018\u00010]H\u00d6\u0003\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\ba\u0010\rJ\r\u0010b\u001a\u00020\\\u00a2\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002\u00a2\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002\u00a2\u0006\u0004\bh\u0010dJ\r\u0010i\u001a\u00020\\\u00a2\u0006\u0004\bj\u0010dJ\r\u0010k\u001a\u00020\\\u00a2\u0006\u0004\bl\u0010dJ\r\u0010m\u001a\u00020\\\u00a2\u0006\u0004\bn\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010qJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bu\u0010WJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bu\u0010XJ\u00a0\u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2v\u0010x\u001ar\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t\u00a2\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0yH\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u008c\u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2b\u0010x\u001a^\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t\u00a2\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0083\u0001H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0084\u0001Jw\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2M\u0010x\u001aI\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t\u00a2\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0085\u0001H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0086\u0001Jb\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w28\u0010x\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u007f\u0012\u0014\u0012\u00120\t\u00a2\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hw0\u0087\u0001H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0088\u0001J\u001e\u0010\u0089\u0001\u001a\u00020\u000f2\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001e\u0010\u008e\u0001\u001a\u00020\t2\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00030\u0092\u0001\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u001e\u0010\u0095\u0001\u001a\u00020\u00032\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u0001\u00a2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u0003H\u0007\u00a2\u0006\u0005\b\u0099\u0001\u0010\u0005J\u0011\u0010\u009a\u0001\u001a\u00020\u0003H\u0007\u00a2\u0006\u0005\b\u009b\u0001\u0010\u0005J\u0013\u0010\u009c\u0001\u001a\u00030\u0092\u0001H\u0016\u00a2\u0006\u0006\b\u009d\u0001\u0010\u0094\u0001J*\u0010\u009c\u0001\u001a\u00030\u0092\u00012\f\u0010\u008a\u0001\u001a\u00070Dj\u0003`\u008b\u00012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\t\u00a2\u0006\u0006\b\u009d\u0001\u0010\u009f\u0001J\u0018\u0010\u00a0\u0001\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0005\b\u00a1\u0001\u0010\u0005JK\u0010\u00a2\u0001\u001a\u00030\u00a3\u0001*\b0\u00a4\u0001j\u0003`\u00a5\u00012\u0007\u0010\u00a6\u0001\u001a\u00020\t2\u0007\u0010\u00a7\u0001\u001a\u00020\t2\u0007\u0010\u00a8\u0001\u001a\u00020\t2\b\u0010\u008a\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u00a9\u0001\u001a\u00020\\H\u0002\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u0017\u0010\u0006\u001a\u00020\u00008F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0015\u0010G\u001a\u00020\t8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001\u00a8\u0006\u00ad\u0001"}, d2={"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
@JvmInline
public final class Duration
implements Comparable<Duration> {
    public static final Companion Companion = new Companion(null);
    private static final long INFINITE;
    private static final long NEG_INFINITE;
    private static final long ZERO;
    private final long rawValue;

    static {
        ZERO = Duration.constructor_impl(0L);
        INFINITE = DurationKt.access$durationOfMillis((long)0x3FFFFFFFFFFFFFFFL);
        NEG_INFINITE = DurationKt.access$durationOfMillis((long)-4611686018427387903L);
    }

    private /* synthetic */ Duration(long l) {
        this.rawValue = l;
    }

    public static final /* synthetic */ long access$getINFINITE$cp_UwyO8pc() {
        return INFINITE;
    }

    public static final /* synthetic */ long access$getNEG_INFINITE$cp_UwyO8pc() {
        return NEG_INFINITE;
    }

    public static final /* synthetic */ long access$getZERO$cp_UwyO8pc() {
        return ZERO;
    }

    private static final long addValuesMixedRanges_UwyO8pc(long l, long l2, long l3) {
        long l4 = DurationKt.access$nanosToMillis((long)l3);
        l = l2 + l4;
        if (-4611686018426L <= l && 4611686018426L >= l) {
            l2 = DurationKt.access$millisToNanos((long)l4);
            l = DurationKt.access$durationOfNanos((long)(DurationKt.access$millisToNanos((long)l) + (l3 - l2)));
        } else {
            l = DurationKt.access$durationOfMillis((long)RangesKt.coerceIn((long)l, (long)-4611686018427387903L, (long)0x3FFFFFFFFFFFFFFFL));
        }
        return l;
    }

    private static final void appendFractional_impl(long l, StringBuilder stringBuilder, int n, int n2, int n3, String string, boolean bl) {
        stringBuilder.append(n);
        if (n2 != 0) {
            stringBuilder.append('.');
            CharSequence charSequence = StringsKt.padStart((String)String.valueOf(n2), (int)n3, (char)'0');
            n = charSequence.length();
            n3 = -1;
            --n;
            while (true) {
                n2 = n3;
                if (n < 0) break;
                n2 = charSequence.charAt(n) != '0' ? 1 : 0;
                if (n2 != 0) {
                    n2 = n;
                    break;
                }
                --n;
            }
            n = n2 + 1;
            if (!bl && n < 3) {
                stringBuilder.append(charSequence, 0, n);
                Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(value, startIndex, endIndex)");
            } else {
                stringBuilder.append(charSequence, 0, (n + 2) / 3 * 3);
                Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(value, startIndex, endIndex)");
            }
        }
        stringBuilder.append(string);
    }

    public static final /* synthetic */ Duration box_impl(long l) {
        return new Duration(l);
    }

    public static int compareTo_LRDsOJo(long l, long l2) {
        int n;
        long l3 = l ^ l2;
        if (l3 < 0L) return l == l2 ? 0 : (l < l2 ? -1 : 1);
        if (((int)l3 & 1) == 0) {
            return l == l2 ? 0 : (l < l2 ? -1 : 1);
        }
        int n2 = n = ((int)l & 1) - ((int)l2 & 1);
        if (!Duration.isNegative_impl(l)) return n2;
        n2 = -n;
        return n2;
    }

    public static long constructor_impl(long l) {
        if (Duration.isInNanos_impl(l)) {
            long l2 = Duration.getValue_impl(l);
            if (-4611686018426999999L <= l2 && 4611686018426999999L >= l2) return l;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Duration.getValue_impl(l));
            stringBuilder.append(" ns is out of nanoseconds range");
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        long l3 = Duration.getValue_impl(l);
        if (-4611686018427387903L <= l3 && 0x3FFFFFFFFFFFFFFFL >= l3) {
            l3 = Duration.getValue_impl(l);
            if (-4611686018426L > l3) return l;
            if (4611686018426L < l3) return l;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Duration.getValue_impl(l));
            stringBuilder.append(" ms is denormalized");
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Duration.getValue_impl(l));
        stringBuilder.append(" ms is out of milliseconds range");
        throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
    }

    public static final double div_LRDsOJo(long l, long l2) {
        TimeUnit timeUnit = (TimeUnit)((Object)ComparisonsKt.maxOf((Comparable)((Comparable)((Object)Duration.getStorageUnit_impl(l))), (Comparable)((Comparable)((Object)Duration.getStorageUnit_impl(l2)))));
        return Duration.toDouble_impl(l, timeUnit) / Duration.toDouble_impl(l2, timeUnit);
    }

    public static final long div_UwyO8pc(long l, double d) {
        int n = MathKt.roundToInt((double)d);
        if ((double)n == d && n != 0) {
            return Duration.div_UwyO8pc(l, n);
        }
        TimeUnit timeUnit = Duration.getStorageUnit_impl(l);
        return DurationKt.toDuration((double)(Duration.toDouble_impl(l, timeUnit) / d), (TimeUnit)timeUnit);
    }

    public static final long div_UwyO8pc(long l, int n) {
        if (n == 0) {
            if (Duration.isPositive_impl(l)) {
                l = INFINITE;
            } else {
                if (!Duration.isNegative_impl(l)) throw (Throwable)new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
                l = NEG_INFINITE;
            }
            return l;
        }
        if (Duration.isInNanos_impl(l)) {
            return DurationKt.access$durationOfNanos((long)(Duration.getValue_impl(l) / (long)n));
        }
        if (Duration.isInfinite_impl(l)) {
            return Duration.times_UwyO8pc(l, MathKt.getSign((int)n));
        }
        long l2 = Duration.getValue_impl(l);
        long l3 = n;
        if (-4611686018426L > (l2 /= l3)) {
            return DurationKt.access$durationOfMillis((long)l2);
        }
        if (4611686018426L < l2) return DurationKt.access$durationOfMillis((long)l2);
        l = DurationKt.access$millisToNanos((long)(Duration.getValue_impl(l) - l2 * l3)) / l3;
        return DurationKt.access$durationOfNanos((long)(DurationKt.access$millisToNanos((long)l2) + l));
    }

    public static boolean equals_impl(long l, Object object) {
        if (!(object instanceof Duration)) return false;
        if (l != ((Duration)object).unbox_impl()) return false;
        return true;
    }

    public static final boolean equals_impl0(long l, long l2) {
        boolean bl = l == l2;
        return bl;
    }

    public static final long getAbsoluteValue_UwyO8pc(long l) {
        long l2 = l;
        if (!Duration.isNegative_impl(l)) return l2;
        l2 = Duration.unaryMinus_UwyO8pc(l);
        return l2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static final int getHoursComponent_impl(long l) {
        int n = Duration.isInfinite_impl(l) ? 0 : (int)(Duration.getInWholeHours_impl(l) % (long)24);
        return n;
    }

    @Deprecated(message="Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.DAYS)", imports={}))
    public static /* synthetic */ void getInDays$annotations() {
    }

    public static final double getInDays_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.DAYS);
    }

    @Deprecated(message="Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.HOURS)", imports={}))
    public static /* synthetic */ void getInHours$annotations() {
    }

    public static final double getInHours_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.HOURS);
    }

    @Deprecated(message="Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.MICROSECONDS)", imports={}))
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    public static final double getInMicroseconds_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.MICROSECONDS);
    }

    @Deprecated(message="Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.MILLISECONDS)", imports={}))
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    public static final double getInMilliseconds_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.MILLISECONDS);
    }

    @Deprecated(message="Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.MINUTES)", imports={}))
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    public static final double getInMinutes_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.MINUTES);
    }

    @Deprecated(message="Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.NANOSECONDS)", imports={}))
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    public static final double getInNanoseconds_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.NANOSECONDS);
    }

    @Deprecated(message="Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith=@ReplaceWith(expression="toDouble(DurationUnit.SECONDS)", imports={}))
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static final double getInSeconds_impl(long l) {
        return Duration.toDouble_impl(l, TimeUnit.SECONDS);
    }

    public static /* synthetic */ void getInWholeDays$annotations() {
    }

    public static final long getInWholeDays_impl(long l) {
        return Duration.toLong_impl(l, TimeUnit.DAYS);
    }

    public static /* synthetic */ void getInWholeHours$annotations() {
    }

    public static final long getInWholeHours_impl(long l) {
        return Duration.toLong_impl(l, TimeUnit.HOURS);
    }

    public static /* synthetic */ void getInWholeMicroseconds$annotations() {
    }

    public static final long getInWholeMicroseconds_impl(long l) {
        return Duration.toLong_impl(l, TimeUnit.MICROSECONDS);
    }

    public static /* synthetic */ void getInWholeMilliseconds$annotations() {
    }

    public static final long getInWholeMilliseconds_impl(long l) {
        l = Duration.isInMillis_impl(l) && Duration.isFinite_impl(l) ? Duration.getValue_impl(l) : Duration.toLong_impl(l, TimeUnit.MILLISECONDS);
        return l;
    }

    public static /* synthetic */ void getInWholeMinutes$annotations() {
    }

    public static final long getInWholeMinutes_impl(long l) {
        return Duration.toLong_impl(l, TimeUnit.MINUTES);
    }

    public static /* synthetic */ void getInWholeNanoseconds$annotations() {
    }

    public static final long getInWholeNanoseconds_impl(long l) {
        long l2 = Duration.getValue_impl(l);
        l = Duration.isInNanos_impl(l) ? l2 : (l2 > 9223372036854L ? Long.MAX_VALUE : (l2 < -9223372036854L ? Long.MIN_VALUE : DurationKt.access$millisToNanos((long)l2)));
        return l;
    }

    public static /* synthetic */ void getInWholeSeconds$annotations() {
    }

    public static final long getInWholeSeconds_impl(long l) {
        return Duration.toLong_impl(l, TimeUnit.SECONDS);
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static final int getMinutesComponent_impl(long l) {
        int n = Duration.isInfinite_impl(l) ? 0 : (int)(Duration.getInWholeMinutes_impl(l) % (long)60);
        return n;
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static final int getNanosecondsComponent_impl(long l) {
        int n;
        if (Duration.isInfinite_impl(l)) {
            n = 0;
        } else {
            l = Duration.isInMillis_impl(l) ? DurationKt.access$millisToNanos((long)(Duration.getValue_impl(l) % (long)1000)) : Duration.getValue_impl(l) % (long)1000000000;
            n = (int)l;
        }
        return n;
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    public static final int getSecondsComponent_impl(long l) {
        int n = Duration.isInfinite_impl(l) ? 0 : (int)(Duration.getInWholeSeconds_impl(l) % (long)60);
        return n;
    }

    private static final TimeUnit getStorageUnit_impl(long l) {
        TimeUnit timeUnit = Duration.isInNanos_impl(l) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
        return timeUnit;
    }

    private static final int getUnitDiscriminator_impl(long l) {
        return (int)l & 1;
    }

    private static final long getValue_impl(long l) {
        return l >> 1;
    }

    public static int hashCode_impl(long l) {
        return (int)(l ^ l >>> 32);
    }

    public static final boolean isFinite_impl(long l) {
        return Duration.isInfinite_impl(l) ^ true;
    }

    private static final boolean isInMillis_impl(long l) {
        int n = (int)l;
        boolean bl = true;
        if ((n & 1) == 1) return bl;
        bl = false;
        return bl;
    }

    private static final boolean isInNanos_impl(long l) {
        int n = (int)l;
        boolean bl = true;
        if ((n & 1) == 0) return bl;
        bl = false;
        return bl;
    }

    public static final boolean isInfinite_impl(long l) {
        boolean bl = l == INFINITE || l == NEG_INFINITE;
        return bl;
    }

    public static final boolean isNegative_impl(long l) {
        boolean bl = l < 0L;
        return bl;
    }

    public static final boolean isPositive_impl(long l) {
        boolean bl = l > 0L;
        return bl;
    }

    public static final long minus_LRDsOJo(long l, long l2) {
        return Duration.plus_LRDsOJo(l, Duration.unaryMinus_UwyO8pc(l2));
    }

    public static final long plus_LRDsOJo(long l, long l2) {
        if (Duration.isInfinite_impl(l)) {
            if (Duration.isFinite_impl(l2)) return l;
            if ((l2 ^ l) < 0L) throw (Throwable)new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            return l;
        }
        if (Duration.isInfinite_impl(l2)) {
            return l2;
        }
        if (((int)l & 1) == ((int)l2 & 1)) {
            l2 = Duration.getValue_impl(l) + Duration.getValue_impl(l2);
            l = Duration.isInNanos_impl(l) ? DurationKt.access$durationOfNanosNormalized((long)l2) : DurationKt.access$durationOfMillisNormalized((long)l2);
        } else {
            l = Duration.isInMillis_impl(l) ? Duration.addValuesMixedRanges_UwyO8pc(l, Duration.getValue_impl(l), Duration.getValue_impl(l2)) : Duration.addValuesMixedRanges_UwyO8pc(l, Duration.getValue_impl(l2), Duration.getValue_impl(l));
        }
        return l;
    }

    public static final long times_UwyO8pc(long l, double d) {
        int n = MathKt.roundToInt((double)d);
        if ((double)n == d) {
            return Duration.times_UwyO8pc(l, n);
        }
        TimeUnit timeUnit = Duration.getStorageUnit_impl(l);
        return DurationKt.toDuration((double)(Duration.toDouble_impl(l, timeUnit) * d), (TimeUnit)timeUnit);
    }

    public static final long times_UwyO8pc(long l, int n) {
        if (Duration.isInfinite_impl(l)) {
            if (n == 0) throw (Throwable)new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
            if (n > 0) return l;
            l = Duration.unaryMinus_UwyO8pc(l);
            return l;
        }
        if (n == 0) {
            return ZERO;
        }
        long l2 = Duration.getValue_impl(l);
        long l3 = n;
        long l4 = l2 * l3;
        if (Duration.isInNanos_impl(l)) {
            if (-2147483647L <= l2 && Integer.MAX_VALUE >= l2) {
                l = DurationKt.access$durationOfNanos((long)l4);
            } else if (l4 / l3 == l2) {
                l = DurationKt.access$durationOfNanosNormalized((long)l4);
            } else {
                l4 = DurationKt.access$nanosToMillis((long)l2);
                long l5 = DurationKt.access$millisToNanos((long)l4);
                l = l4 * l3;
                l5 = DurationKt.access$nanosToMillis((long)((l2 - l5) * l3)) + l;
                l = l / l3 == l4 && (l5 ^ l) >= 0L ? DurationKt.access$durationOfMillis((long)RangesKt.coerceIn((long)l5, (ClosedRange)((ClosedRange)new LongRange(-4611686018427387903L, 0x3FFFFFFFFFFFFFFFL)))) : (MathKt.getSign((long)l2) * MathKt.getSign((int)n) > 0 ? INFINITE : NEG_INFINITE);
            }
        } else {
            l = l4 / l3 == l2 ? DurationKt.access$durationOfMillis((long)RangesKt.coerceIn((long)l4, (ClosedRange)((ClosedRange)new LongRange(-4611686018427387903L, 0x3FFFFFFFFFFFFFFFL)))) : (MathKt.getSign((long)l2) * MathKt.getSign((int)n) > 0 ? INFINITE : NEG_INFINITE);
        }
        return l;
    }

    public static final <T> T toComponents_impl(long l, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"action");
        return (T)function2.invoke((Object)Duration.getInWholeSeconds_impl(l), (Object)Duration.getNanosecondsComponent_impl(l));
    }

    public static final <T> T toComponents_impl(long l, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, (String)"action");
        return (T)function3.invoke((Object)Duration.toInt_impl(l, TimeUnit.MINUTES), (Object)Duration.getSecondsComponent_impl(l), (Object)Duration.getNanosecondsComponent_impl(l));
    }

    public static final <T> T toComponents_impl(long l, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, (String)"action");
        return (T)function4.invoke((Object)Duration.toInt_impl(l, TimeUnit.HOURS), (Object)Duration.getMinutesComponent_impl(l), (Object)Duration.getSecondsComponent_impl(l), (Object)Duration.getNanosecondsComponent_impl(l));
    }

    public static final <T> T toComponents_impl(long l, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, (String)"action");
        return (T)function5.invoke((Object)Duration.toInt_impl(l, TimeUnit.DAYS), (Object)Duration.getHoursComponent_impl(l), (Object)Duration.getMinutesComponent_impl(l), (Object)Duration.getSecondsComponent_impl(l), (Object)Duration.getNanosecondsComponent_impl(l));
    }

    public static final double toDouble_impl(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        double d = l == INFINITE ? Double.POSITIVE_INFINITY : (l == NEG_INFINITE ? Double.NEGATIVE_INFINITY : DurationUnitKt.convertDurationUnit((double)Duration.getValue_impl(l), (TimeUnit)Duration.getStorageUnit_impl(l), (TimeUnit)timeUnit));
        return d;
    }

    public static final int toInt_impl(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        return (int)RangesKt.coerceIn((long)Duration.toLong_impl(l, timeUnit), (long)Integer.MIN_VALUE, (long)Integer.MAX_VALUE);
    }

    public static final String toIsoString_impl(long l) {
        CharSequence charSequence = new StringBuilder();
        if (Duration.isNegative_impl(l)) {
            charSequence.append('-');
        }
        charSequence.append("PT");
        long l2 = Duration.getAbsoluteValue_UwyO8pc(l);
        Duration.toInt_impl(l2, TimeUnit.HOURS);
        int n = Duration.getMinutesComponent_impl(l2);
        int n2 = Duration.getSecondsComponent_impl(l2);
        int n3 = Duration.getNanosecondsComponent_impl(l2);
        l2 = Duration.getInWholeHours_impl(l2);
        if (Duration.isInfinite_impl(l)) {
            l2 = 9999999999999L;
        }
        boolean bl = true;
        boolean bl2 = l2 != 0L;
        boolean bl3 = n2 != 0 || n3 != 0;
        boolean bl4 = bl;
        if (n == 0) {
            bl4 = bl3 && bl2 ? bl : false;
        }
        if (bl2) {
            charSequence.append(l2);
            charSequence.append('H');
        }
        if (bl4) {
            charSequence.append(n);
            charSequence.append('M');
        }
        if (bl3 || !bl2 && !bl4) {
            Duration.appendFractional_impl(l, charSequence, n2, n3, 9, "S", true);
        }
        charSequence = charSequence.toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }

    public static final long toLong_impl(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        l = l == INFINITE ? Long.MAX_VALUE : (l == NEG_INFINITE ? Long.MIN_VALUE : DurationUnitKt.convertDurationUnit((long)Duration.getValue_impl(l), (TimeUnit)Duration.getStorageUnit_impl(l), (TimeUnit)timeUnit));
        return l;
    }

    @Deprecated(message="Use inWholeMilliseconds property instead.", replaceWith=@ReplaceWith(expression="this.inWholeMilliseconds", imports={}))
    public static final long toLongMilliseconds_impl(long l) {
        return Duration.getInWholeMilliseconds_impl(l);
    }

    @Deprecated(message="Use inWholeNanoseconds property instead.", replaceWith=@ReplaceWith(expression="this.inWholeNanoseconds", imports={}))
    public static final long toLongNanoseconds_impl(long l) {
        return Duration.getInWholeNanoseconds_impl(l);
    }

    public static String toString_impl(long l) {
        CharSequence charSequence;
        block20: {
            int n;
            boolean bl;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            int n2;
            int n3;
            int n4;
            boolean bl5;
            block26: {
                int n5;
                block25: {
                    block24: {
                        int n6;
                        block23: {
                            block22: {
                                block21: {
                                    block19: {
                                        if (l != 0L) break block19;
                                        charSequence = "0s";
                                        break block20;
                                    }
                                    if (l != INFINITE) break block21;
                                    charSequence = "Infinity";
                                    break block20;
                                }
                                if (l != NEG_INFINITE) break block22;
                                charSequence = "-Infinity";
                                break block20;
                            }
                            bl5 = Duration.isNegative_impl(l);
                            charSequence = new StringBuilder();
                            if (bl5) {
                                ((StringBuilder)charSequence).append('-');
                            }
                            l = Duration.getAbsoluteValue_UwyO8pc(l);
                            Duration.toInt_impl(l, TimeUnit.DAYS);
                            n6 = Duration.getHoursComponent_impl(l);
                            n5 = Duration.getMinutesComponent_impl(l);
                            n4 = Duration.getSecondsComponent_impl(l);
                            n3 = Duration.getNanosecondsComponent_impl(l);
                            long l2 = Duration.getInWholeDays_impl(l);
                            n2 = 0;
                            bl4 = l2 != 0L;
                            bl3 = n6 != 0;
                            bl2 = n5 != 0;
                            bl = n4 != 0 || n3 != 0;
                            if (bl4) {
                                ((StringBuilder)charSequence).append(l2);
                                ((StringBuilder)charSequence).append('d');
                                n2 = 1;
                            }
                            if (bl3) break block23;
                            n = n2;
                            if (!bl4) break block24;
                            if (bl2) break block23;
                            n = n2;
                            if (!bl) break block24;
                        }
                        if (n2 > 0) {
                            ((StringBuilder)charSequence).append(' ');
                        }
                        ((StringBuilder)charSequence).append(n6);
                        ((StringBuilder)charSequence).append('h');
                        n = n2 + 1;
                    }
                    if (bl2) break block25;
                    n2 = n;
                    if (!bl) break block26;
                    if (bl3) break block25;
                    n2 = n;
                    if (!bl4) break block26;
                }
                if (n > 0) {
                    ((StringBuilder)charSequence).append(' ');
                }
                ((StringBuilder)charSequence).append(n5);
                ((StringBuilder)charSequence).append('m');
                n2 = n + 1;
            }
            n = n2;
            if (bl) {
                if (n2 > 0) {
                    ((StringBuilder)charSequence).append(' ');
                }
                if (!(n4 != 0 || bl4 || bl3 || bl2)) {
                    if (n3 >= 1000000) {
                        Duration.appendFractional_impl(l, (StringBuilder)charSequence, n3 / 1000000, n3 % 1000000, 6, "ms", false);
                    } else if (n3 >= 1000) {
                        Duration.appendFractional_impl(l, (StringBuilder)charSequence, n3 / 1000, n3 % 1000, 3, "us", false);
                    } else {
                        ((StringBuilder)charSequence).append(n3);
                        ((StringBuilder)charSequence).append("ns");
                    }
                } else {
                    Duration.appendFractional_impl(l, (StringBuilder)charSequence, n4, n3, 9, "s", false);
                }
                n = n2 + 1;
            }
            if (bl5 && n > 1) {
                ((StringBuilder)charSequence).insert(1, '(').append(')');
            }
            charSequence = ((StringBuilder)charSequence).toString();
            Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"StringBuilder().apply(builderAction).toString()");
        }
        return charSequence;
    }

    public static final String toString_impl(long l, TimeUnit object, int n) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"unit");
        boolean bl = n >= 0;
        if (!bl) {
            object = new StringBuilder();
            ((StringBuilder)object).append("decimals must be not negative, but was ");
            ((StringBuilder)object).append(n);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        double d = Duration.toDouble_impl(l, (TimeUnit)((Object)object));
        if (Double.isInfinite(d)) {
            return String.valueOf(d);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FormatToDecimalsKt.formatToExactDecimals((double)d, (int)RangesKt.coerceAtMost((int)n, (int)12)));
        stringBuilder.append(DurationUnitKt.shortName((TimeUnit)((Object)object)));
        return stringBuilder.toString();
    }

    public static /* synthetic */ String toString_impl$default(long l, TimeUnit timeUnit, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return Duration.toString_impl(l, timeUnit, n);
        n = 0;
        return Duration.toString_impl(l, timeUnit, n);
    }

    public static final long unaryMinus_UwyO8pc(long l) {
        return DurationKt.access$durationOf((long)(-Duration.getValue_impl(l)), (int)((int)l & 1));
    }

    public int compareTo_LRDsOJo(long l) {
        return Duration.compareTo_LRDsOJo(this.rawValue, l);
    }

    public boolean equals(Object object) {
        return Duration.equals_impl(this.rawValue, object);
    }

    public int hashCode() {
        return Duration.hashCode_impl(this.rawValue);
    }

    public String toString() {
        return Duration.toString_impl(this.rawValue);
    }

    public final /* synthetic */ long unbox_impl() {
        return this.rawValue;
    }
}
