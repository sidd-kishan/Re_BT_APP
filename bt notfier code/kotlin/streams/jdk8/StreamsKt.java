/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package kotlin.streams.jdk8;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u00a8\u0006\r"}, d2={"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "T", "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k=2, mv={1, 5, 1}, pn="kotlin.streams")
public final class StreamsKt {
    public static final Sequence<Double> asSequence(DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter((Object)doubleStream, (String)"$this$asSequence");
        return (Sequence)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final Sequence<Integer> asSequence(IntStream intStream) {
        Intrinsics.checkNotNullParameter((Object)intStream, (String)"$this$asSequence");
        return (Sequence)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final Sequence<Long> asSequence(LongStream longStream) {
        Intrinsics.checkNotNullParameter((Object)longStream, (String)"$this$asSequence");
        return (Sequence)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final <T> Sequence<T> asSequence(Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, (String)"$this$asSequence");
        return (Sequence)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final <T> Stream<T> asStream(Sequence<? extends T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$asStream");
        object = StreamSupport.stream((Supplier)new /* Unavailable Anonymous Inner Class!! */, 16, false);
        Intrinsics.checkNotNullExpressionValue(object, (String)"StreamSupport.stream({ S\u2026literator.ORDERED, false)");
        return object;
    }

    public static final List<Double> toList(DoubleStream object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toList");
        object = object.toArray();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toArray()");
        return ArraysKt.asList((double[])object);
    }

    public static final List<Integer> toList(IntStream object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toList");
        object = object.toArray();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toArray()");
        return ArraysKt.asList((int[])object);
    }

    public static final List<Long> toList(LongStream object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toList");
        object = object.toArray();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toArray()");
        return ArraysKt.asList((long[])object);
    }

    public static final <T> List<T> toList(Stream<T> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$toList");
        object = object.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"collect(Collectors.toList<T>())");
        return (List)object;
    }
}
