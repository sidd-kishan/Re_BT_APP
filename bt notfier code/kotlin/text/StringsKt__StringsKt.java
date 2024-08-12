/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.TuplesKt
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CharIterator
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntProgression
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.CharsKt
 *  kotlin.text.DelimitedRangesSequence
 *  kotlin.text.MatchResult
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  kotlin.text.StringsKt__StringsJVMKt
 */
package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1={"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\b\u00f8\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007\u00a2\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006y"}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringsKt
extends StringsKt__StringsJVMKt {
    public static final /* synthetic */ Pair access$findAnyOf(CharSequence charSequence, Collection collection, int n, boolean bl, boolean bl2) {
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence, collection, n, bl, bl2);
    }

    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        int n;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$commonPrefixWith");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"other");
        int n2 = Math.min(charSequence.length(), charSequence2.length());
        for (n = 0; n < n2 && CharsKt.equals((char)charSequence.charAt(n), (char)charSequence2.charAt(n), (boolean)bl); ++n) {
        }
        int n3 = n - 1;
        if (!StringsKt.hasSurrogatePairAt((CharSequence)charSequence, (int)n3)) {
            n2 = n;
            if (!StringsKt.hasSurrogatePairAt((CharSequence)charSequence2, (int)n3)) return ((Object)charSequence.subSequence(0, n2)).toString();
        }
        n2 = n - 1;
        return ((Object)charSequence.subSequence(0, n2)).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.commonPrefixWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
        bl = false;
        return StringsKt.commonPrefixWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        int n;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$commonSuffixWith");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"other");
        int n2 = charSequence.length();
        int n3 = charSequence2.length();
        int n4 = Math.min(n2, n3);
        for (n = 0; n < n4 && CharsKt.equals((char)charSequence.charAt(n2 - n - 1), (char)charSequence2.charAt(n3 - n - 1), (boolean)bl); ++n) {
        }
        if (!StringsKt.hasSurrogatePairAt((CharSequence)charSequence, (int)(n2 - n - 1))) {
            n4 = n;
            if (!StringsKt.hasSurrogatePairAt((CharSequence)charSequence2, (int)(n3 - n - 1))) return ((Object)charSequence.subSequence(n2 - n4, n2)).toString();
        }
        n4 = n - 1;
        return ((Object)charSequence.subSequence(n2 - n4, n2)).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.commonSuffixWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
        bl = false;
        return StringsKt.commonSuffixWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$contains");
        bl = StringsKt.indexOf$default((CharSequence)charSequence, (char)c, (int)0, (boolean)bl, (int)2, null) >= 0;
        return bl;
    }

    /*
     * Enabled force condition propagation
     */
    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$contains");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"other");
        boolean bl2 = charSequence2 instanceof String;
        boolean bl3 = true;
        if (bl2) {
            if (StringsKt.indexOf$default((CharSequence)charSequence, (String)((String)charSequence2), (int)0, (boolean)bl, (int)2, null) < 0) return false;
            return bl3;
        }
        if (StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), bl, false, 16, null) < 0) return false;
        return bl3;
    }

    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$contains");
        return regex.containsMatchIn(charSequence);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.contains((CharSequence)charSequence, (char)c, (boolean)bl);
        bl = false;
        return StringsKt.contains((CharSequence)charSequence, (char)c, (boolean)bl);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.contains((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
        bl = false;
        return StringsKt.contains((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return StringsKt.equals((String)((String)charSequence), (String)((String)charSequence2), (boolean)true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null) return false;
        if (charSequence2 == null) return false;
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        int n = charSequence.length();
        int n2 = 0;
        while (n2 < n) {
            if (!CharsKt.equals((char)charSequence.charAt(n2), (char)charSequence2.charAt(n2), (boolean)true)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return Intrinsics.areEqual((Object)charSequence, (Object)charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null) return false;
        if (charSequence2 == null) return false;
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        int n = charSequence.length();
        int n2 = 0;
        while (n2 < n) {
            if (charSequence.charAt(n2) != charSequence2.charAt(n2)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$endsWith");
        bl = charSequence.length() > 0 && CharsKt.equals((char)charSequence.charAt(StringsKt.getLastIndex((CharSequence)charSequence)), (char)c, (boolean)bl);
        return bl;
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$endsWith");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"suffix");
        if (bl) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)(charSequence.length() - charSequence2.length()), (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        if (!(charSequence instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)(charSequence.length() - charSequence2.length()), (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        if (!(charSequence2 instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)(charSequence.length() - charSequence2.length()), (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        return StringsKt.endsWith$default((String)((String)charSequence), (String)((String)charSequence2), (boolean)false, (int)2, null);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.endsWith((CharSequence)charSequence, (char)c, (boolean)bl);
        bl = false;
        return StringsKt.endsWith((CharSequence)charSequence, (char)c, (boolean)bl);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.endsWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
        bl = false;
        return StringsKt.endsWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$findAnyOf");
        Intrinsics.checkNotNullParameter(collection, (String)"strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence, collection, n, bl, false);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> object, int n, boolean bl, boolean bl2) {
        int n2;
        int n3;
        Object object22 = null;
        if (!bl && object.size() == 1) {
            object = (String)CollectionsKt.single((Iterable)((Iterable)object));
            n = !bl2 ? StringsKt.indexOf$default((CharSequence)charSequence, (String)object, (int)n, (boolean)false, (int)4, null) : StringsKt.lastIndexOf$default((CharSequence)charSequence, (String)object, (int)n, (boolean)false, (int)4, null);
            charSequence = n < 0 ? object22 : TuplesKt.to((Object)n, (Object)object);
            return charSequence;
        }
        object22 = !bl2 ? (IntProgression)new IntRange(RangesKt.coerceAtLeast((int)n, (int)0), charSequence.length()) : RangesKt.downTo((int)RangesKt.coerceAtMost((int)n, (int)StringsKt.getLastIndex((CharSequence)charSequence)), (int)0);
        if (!(charSequence instanceof String)) {
            n = object22.getFirst();
            n3 = object22.getLast();
            n2 = object22.getStep();
            if (n2 >= 0) {
                if (n > n3) return null;
            } else if (n < n3) return null;
        } else {
            n = object22.getFirst();
            int n4 = object22.getLast();
            int n5 = object22.getStep();
            if (n5 >= 0) {
                if (n > n4) return null;
            } else if (n < n4) return null;
            while (true) {
                block13: {
                    for (Object object22 : (Iterable)object) {
                        String string = (String)object22;
                        if (!StringsKt.regionMatches((String)string, (int)0, (String)((String)charSequence), (int)n, (int)string.length(), (boolean)bl)) continue;
                        break block13;
                    }
                    object22 = null;
                }
                object22 = (String)object22;
                if (object22 != null) {
                    return TuplesKt.to((Object)n, (Object)object22);
                }
                if (n == n4) return null;
                n += n5;
            }
        }
        while (true) {
            block14: {
                for (Object object22 : (Iterable)object) {
                    String string = (String)object22;
                    if (!StringsKt.regionMatchesImpl((CharSequence)string, (int)0, (CharSequence)charSequence, (int)n, (int)string.length(), (boolean)bl)) continue;
                    break block14;
                }
                object22 = null;
            }
            object22 = (String)object22;
            if (object22 != null) {
                return TuplesKt.to((Object)n, (Object)object22);
            }
            if (n == n3) return null;
            n += n2;
        }
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) == 0) return StringsKt.findAnyOf((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.findAnyOf((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$findLastAnyOf");
        Intrinsics.checkNotNullParameter(collection, (String)"strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence, collection, n, bl, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex((CharSequence)charSequence);
        }
        if ((n2 & 4) == 0) return StringsKt.findLastAnyOf((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.findLastAnyOf((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$indices");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$hasSurrogatePairAt");
        int n2 = charSequence.length();
        boolean bl = true;
        if (n >= 0 && n2 - 2 >= n && Character.isHighSurrogate(charSequence.charAt(n)) && Character.isLowSurrogate(charSequence.charAt(n + 1))) return bl;
        bl = false;
        return bl;
    }

    private static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        Object object = c;
        if (!StringsKt.isBlank(c)) return object;
        object = function0.invoke();
        return object;
    }

    private static final <C extends CharSequence & R, R> R ifEmpty(C object, Function0<? extends R> function0) {
        boolean bl = object.length() == 0;
        if (!bl) return object;
        object = function0.invoke();
        return object;
    }

    public static final int indexOf(CharSequence charSequence, char c, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$indexOf");
        n = !bl && charSequence instanceof String ? ((String)charSequence).indexOf(c, n) : StringsKt.indexOfAny((CharSequence)charSequence, (char[])new char[]{c}, (int)n, (boolean)bl);
        return n;
    }

    public static final int indexOf(CharSequence charSequence, String string, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$indexOf");
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        n = !bl && charSequence instanceof String ? ((String)charSequence).indexOf(string, n) : StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default(charSequence, string, n, charSequence.length(), bl, false, 16, null);
        return n;
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int n, int n2, boolean bl, boolean bl2) {
        int n3;
        IntProgression intProgression = !bl2 ? (IntProgression)new IntRange(RangesKt.coerceAtLeast((int)n, (int)0), RangesKt.coerceAtMost((int)n2, (int)charSequence.length())) : RangesKt.downTo((int)RangesKt.coerceAtMost((int)n, (int)StringsKt.getLastIndex((CharSequence)charSequence)), (int)RangesKt.coerceAtLeast((int)n2, (int)0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            n = intProgression.getFirst();
            n2 = intProgression.getLast();
            n3 = intProgression.getStep();
            if (n3 >= 0) {
                if (n > n2) return -1;
            } else if (n < n2) return -1;
        } else {
            n = intProgression.getFirst();
            int n4 = intProgression.getLast();
            n2 = intProgression.getStep();
            if (n2 >= 0) {
                if (n > n4) return -1;
            } else if (n < n4) return -1;
            while (true) {
                if (StringsKt.regionMatches((String)((String)charSequence2), (int)0, (String)((String)charSequence), (int)n, (int)charSequence2.length(), (boolean)bl)) {
                    return n;
                }
                if (n == n4) return -1;
                n += n2;
            }
        }
        while (!StringsKt.regionMatchesImpl((CharSequence)charSequence2, (int)0, (CharSequence)charSequence, (int)n, (int)charSequence2.length(), (boolean)bl)) {
            if (n == n2) return -1;
            n += n3;
        }
        return n;
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int n, int n2, boolean bl, boolean bl2, int n3, Object object) {
        if ((n3 & 0x10) == 0) return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(charSequence, charSequence2, n, n2, bl, bl2);
        bl2 = false;
        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(charSequence, charSequence2, n, n2, bl, bl2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) == 0) return StringsKt.indexOf((CharSequence)charSequence, (char)c, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.indexOf((CharSequence)charSequence, (char)c, (int)n, (boolean)bl);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String string, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) == 0) return StringsKt.indexOf((CharSequence)charSequence, (String)string, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.indexOf((CharSequence)charSequence, (String)string, (int)n, (boolean)bl);
    }

    public static final int indexOfAny(CharSequence object, Collection<String> collection, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$indexOfAny");
        Intrinsics.checkNotNullParameter(collection, (String)"strings");
        object = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt((CharSequence)object, collection, n, bl, false);
        n = object != null && (object = (Integer)object.getFirst()) != null ? (Integer)object : -1;
        return n;
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArray, int n, boolean bl) {
        int n2;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$indexOfAny");
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
        if (!bl && cArray.length == 1 && charSequence instanceof String) {
            char c = ArraysKt.single((char[])cArray);
            return ((String)charSequence).indexOf(c, n);
        }
        if ((n = RangesKt.coerceAtLeast((int)n, (int)0)) > (n2 = StringsKt.getLastIndex((CharSequence)charSequence))) return -1;
        while (true) {
            int n3;
            block4: {
                char c = charSequence.charAt(n);
                int n4 = cArray.length;
                for (n3 = 0; n3 < n4; ++n3) {
                    if (!CharsKt.equals((char)cArray[n3], (char)c, (boolean)bl)) continue;
                    n3 = 1;
                    break block4;
                }
                n3 = 0;
            }
            if (n3 != 0) {
                return n;
            }
            if (n == n2) return -1;
            ++n;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) == 0) return StringsKt.indexOfAny((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.indexOfAny((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) == 0) return StringsKt.indexOfAny((CharSequence)charSequence, (char[])cArray, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.indexOfAny((CharSequence)charSequence, (char[])cArray, (int)n, (boolean)bl);
    }

    private static final boolean isEmpty(CharSequence charSequence) {
        boolean bl = charSequence.length() == 0;
        return bl;
    }

    private static final boolean isNotBlank(CharSequence charSequence) {
        return StringsKt.isBlank((CharSequence)charSequence) ^ true;
    }

    private static final boolean isNotEmpty(CharSequence charSequence) {
        boolean bl = charSequence.length() > 0;
        return bl;
    }

    private static final boolean isNullOrBlank(CharSequence charSequence) {
        boolean bl = charSequence == null || StringsKt.isBlank((CharSequence)charSequence);
        return bl;
    }

    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        boolean bl = charSequence == null || charSequence.length() == 0;
        return bl;
    }

    public static final CharIterator iterator(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$iterator");
        return (CharIterator)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$lastIndexOf");
        n = !bl && charSequence instanceof String ? ((String)charSequence).lastIndexOf(c, n) : StringsKt.lastIndexOfAny((CharSequence)charSequence, (char[])new char[]{c}, (int)n, (boolean)bl);
        return n;
    }

    public static final int lastIndexOf(CharSequence charSequence, String string, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$lastIndexOf");
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        n = !bl && charSequence instanceof String ? ((String)charSequence).lastIndexOf(string, n) : StringsKt__StringsKt.indexOf$StringsKt__StringsKt(charSequence, string, n, 0, bl, true);
        return n;
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex((CharSequence)charSequence);
        }
        if ((n2 & 4) == 0) return StringsKt.lastIndexOf((CharSequence)charSequence, (char)c, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.lastIndexOf((CharSequence)charSequence, (char)c, (int)n, (boolean)bl);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String string, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex((CharSequence)charSequence);
        }
        if ((n2 & 4) == 0) return StringsKt.lastIndexOf((CharSequence)charSequence, (String)string, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.lastIndexOf((CharSequence)charSequence, (String)string, (int)n, (boolean)bl);
    }

    public static final int lastIndexOfAny(CharSequence object, Collection<String> collection, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(collection, (String)"strings");
        object = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt((CharSequence)object, collection, n, bl, true);
        n = object != null && (object = (Integer)object.getFirst()) != null ? (Integer)object : -1;
        return n;
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArray, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
        if (!bl && cArray.length == 1 && charSequence instanceof String) {
            char c = ArraysKt.single((char[])cArray);
            return ((String)charSequence).lastIndexOf(c, n);
        }
        n = RangesKt.coerceAtMost((int)n, (int)StringsKt.getLastIndex((CharSequence)charSequence));
        while (n >= 0) {
            boolean bl2;
            char c = charSequence.charAt(n);
            int n2 = cArray.length;
            boolean bl3 = false;
            int n3 = 0;
            while (true) {
                bl2 = bl3;
                if (n3 >= n2) break;
                if (CharsKt.equals((char)cArray[n3], (char)c, (boolean)bl)) {
                    bl2 = true;
                    break;
                }
                ++n3;
            }
            if (bl2) {
                return n;
            }
            --n;
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex((CharSequence)charSequence);
        }
        if ((n2 & 4) == 0) return StringsKt.lastIndexOfAny((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.lastIndexOfAny((CharSequence)charSequence, (Collection)collection, (int)n, (boolean)bl);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = StringsKt.getLastIndex((CharSequence)charSequence);
        }
        if ((n2 & 4) == 0) return StringsKt.lastIndexOfAny((CharSequence)charSequence, (char[])cArray, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.lastIndexOfAny((CharSequence)charSequence, (char[])cArray, (int)n, (boolean)bl);
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$lineSequence");
        return StringsKt.splitToSequence$default((CharSequence)charSequence, (String[])new String[]{"\r\n", "\n", "\r"}, (boolean)false, (int)0, (int)6, null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$lines");
        return SequencesKt.toList((Sequence)StringsKt.lineSequence((CharSequence)charSequence));
    }

    private static final boolean matches(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    private static final String orEmpty(String string) {
        if (string != null) return string;
        string = "";
        return string;
    }

    public static final CharSequence padEnd(CharSequence object, int n, char c) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$padEnd");
        if (n < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Desired length ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" is less than zero.");
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        if (n <= object.length()) {
            return object.subSequence(0, object.length());
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        stringBuilder.append((CharSequence)object);
        int n2 = n - object.length();
        n = 1;
        if (1 > n2) return stringBuilder;
        while (true) {
            stringBuilder.append(c);
            if (n == n2) return stringBuilder;
            ++n;
        }
    }

    public static final String padEnd(String string, int n, char c) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$padEnd");
        return ((Object)StringsKt.padEnd((CharSequence)string, (int)n, (char)c)).toString();
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int n, char c, int n2, Object object) {
        if ((n2 & 2) == 0) return StringsKt.padEnd((CharSequence)charSequence, (int)n, (char)c);
        c = (char)32;
        return StringsKt.padEnd((CharSequence)charSequence, (int)n, (char)c);
    }

    public static /* synthetic */ String padEnd$default(String string, int n, char c, int n2, Object object) {
        if ((n2 & 2) == 0) return StringsKt.padEnd((String)string, (int)n, (char)c);
        c = (char)32;
        return StringsKt.padEnd((String)string, (int)n, (char)c);
    }

    public static final CharSequence padStart(CharSequence object, int n, char c) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$padStart");
        if (n < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Desired length ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" is less than zero.");
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        if (n <= object.length()) {
            return object.subSequence(0, object.length());
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        int n2 = n - object.length();
        n = 1;
        if (1 <= n2) {
            while (true) {
                stringBuilder.append(c);
                if (n == n2) break;
                ++n;
            }
        }
        stringBuilder.append((CharSequence)object);
        return stringBuilder;
    }

    public static final String padStart(String string, int n, char c) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$padStart");
        return ((Object)StringsKt.padStart((CharSequence)string, (int)n, (char)c)).toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int n, char c, int n2, Object object) {
        if ((n2 & 2) == 0) return StringsKt.padStart((CharSequence)charSequence, (int)n, (char)c);
        c = (char)32;
        return StringsKt.padStart((CharSequence)charSequence, (int)n, (char)c);
    }

    public static /* synthetic */ String padStart$default(String string, int n, char c, int n2, Object object) {
        if ((n2 & 2) == 0) return StringsKt.padStart((String)string, (int)n, (char)c);
        c = (char)32;
        return StringsKt.padStart((String)string, (int)n, (char)c);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2) {
        StringsKt.requireNonNegativeLimit((int)n2);
        return (Sequence)new DelimitedRangesSequence(charSequence, n, n2, (Function2)new /* Unavailable Anonymous Inner Class!! */);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] stringArray, int n, boolean bl, int n2) {
        StringsKt.requireNonNegativeLimit((int)n2);
        return (Sequence)new DelimitedRangesSequence(charSequence, n, n2, (Function2)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArray, int n, boolean bl, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            bl = false;
        }
        if ((n3 & 8) == 0) return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArray, n, bl, n2);
        n2 = 0;
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArray, n, bl, n2);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] stringArray, int n, boolean bl, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) != 0) {
            bl = false;
        }
        if ((n3 & 8) == 0) return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, stringArray, n, bl, n2);
        n2 = 0;
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(charSequence, stringArray, n, bl, n2);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int n, CharSequence charSequence2, int n2, int n3, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$regionMatchesImpl");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"other");
        if (n2 < 0) return false;
        if (n < 0) return false;
        if (n > charSequence.length() - n3) return false;
        if (n2 > charSequence2.length() - n3) {
            return false;
        }
        int n4 = 0;
        while (n4 < n3) {
            if (!CharsKt.equals((char)charSequence.charAt(n + n4), (char)charSequence2.charAt(n2 + n4), (boolean)bl)) {
                return false;
            }
            ++n4;
        }
        return true;
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$removePrefix");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"prefix");
        if (!StringsKt.startsWith$default((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)false, (int)2, null)) return charSequence.subSequence(0, charSequence.length());
        return charSequence.subSequence(charSequence2.length(), charSequence.length());
    }

    public static final String removePrefix(String string, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$removePrefix");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"prefix");
        String string2 = string;
        if (!StringsKt.startsWith$default((CharSequence)string, (CharSequence)charSequence, (boolean)false, (int)2, null)) return string2;
        string2 = string.substring(charSequence.length());
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.String).substring(startIndex)");
        return string2;
    }

    public static final CharSequence removeRange(CharSequence charSequence, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$removeRange");
        if (n2 < n) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("End index (");
            ((StringBuilder)charSequence).append(n2);
            ((StringBuilder)charSequence).append(") is less than start index (");
            ((StringBuilder)charSequence).append(n);
            ((StringBuilder)charSequence).append(").");
            throw (Throwable)new IndexOutOfBoundsException(((StringBuilder)charSequence).toString());
        }
        if (n2 == n) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence.length() - (n2 - n));
        stringBuilder.append(charSequence, 0, n);
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(value, startIndex, endIndex)");
        stringBuilder.append(charSequence, n2, charSequence.length());
        Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(value, startIndex, endIndex)");
        return stringBuilder;
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$removeRange");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        return StringsKt.removeRange((CharSequence)charSequence, (int)intRange.getStart(), (int)(intRange.getEndInclusive() + 1));
    }

    private static final String removeRange(String string, int n, int n2) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.removeRange((CharSequence)string, (int)n, (int)n2)).toString();
    }

    private static final String removeRange(String string, IntRange intRange) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.removeRange((CharSequence)string, (IntRange)intRange)).toString();
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$removeSuffix");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"suffix");
        if (!StringsKt.endsWith$default((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)false, (int)2, null)) return charSequence.subSequence(0, charSequence.length());
        return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
    }

    public static final String removeSuffix(String string, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$removeSuffix");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"suffix");
        String string2 = string;
        if (!StringsKt.endsWith$default((CharSequence)string, (CharSequence)charSequence, (boolean)false, (int)2, null)) return string2;
        string2 = string.substring(0, string.length() - charSequence.length());
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$removeSurrounding");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"delimiter");
        return StringsKt.removeSurrounding((CharSequence)charSequence, (CharSequence)charSequence2, (CharSequence)charSequence2);
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$removeSurrounding");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"prefix");
        Intrinsics.checkNotNullParameter((Object)charSequence3, (String)"suffix");
        if (charSequence.length() < charSequence2.length() + charSequence3.length()) return charSequence.subSequence(0, charSequence.length());
        if (!StringsKt.startsWith$default((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)false, (int)2, null)) return charSequence.subSequence(0, charSequence.length());
        if (!StringsKt.endsWith$default((CharSequence)charSequence, (CharSequence)charSequence3, (boolean)false, (int)2, null)) return charSequence.subSequence(0, charSequence.length());
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    public static final String removeSurrounding(String string, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$removeSurrounding");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"delimiter");
        return StringsKt.removeSurrounding((String)string, (CharSequence)charSequence, (CharSequence)charSequence);
    }

    public static final String removeSurrounding(String string, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$removeSurrounding");
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"prefix");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"suffix");
        String string2 = string;
        if (string.length() < charSequence.length() + charSequence2.length()) return string2;
        CharSequence charSequence3 = string;
        string2 = string;
        if (!StringsKt.startsWith$default((CharSequence)charSequence3, (CharSequence)charSequence, (boolean)false, (int)2, null)) return string2;
        string2 = string;
        if (!StringsKt.endsWith$default((CharSequence)charSequence3, (CharSequence)charSequence2, (boolean)false, (int)2, null)) return string2;
        string2 = string.substring(charSequence.length(), string.length() - charSequence2.length());
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    private static final String replace(CharSequence charSequence, Regex regex, String string) {
        return regex.replace(charSequence, string);
    }

    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        return regex.replace(charSequence, function1);
    }

    public static final String replaceAfter(String string, char c, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$replaceAfter");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        CharSequence charSequence = string;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)(n + 1), (int)string.length(), (CharSequence)string2)).toString();
        return string3;
    }

    public static final String replaceAfter(String string, String string2, String string3, String string4) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$replaceAfter");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"missingDelimiterValue");
        CharSequence charSequence = string;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (String)string2, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string4;
        string4 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)(n + string2.length()), (int)string.length(), (CharSequence)string3)).toString();
        return string4;
    }

    public static /* synthetic */ String replaceAfter$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceAfter((String)string, (char)c, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.replaceAfter((String)string, (char)c, (String)string2, (String)string3);
    }

    public static /* synthetic */ String replaceAfter$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceAfter((String)string, (String)string2, (String)string3, (String)string4);
        string4 = string;
        return StringsKt.replaceAfter((String)string, (String)string2, (String)string3, (String)string4);
    }

    public static final String replaceAfterLast(String string, char c, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$replaceAfterLast");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        CharSequence charSequence = string;
        int n = StringsKt.lastIndexOf$default((CharSequence)charSequence, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)(n + 1), (int)string.length(), (CharSequence)string2)).toString();
        return string3;
    }

    public static final String replaceAfterLast(String string, String string2, String string3, String string4) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$replaceAfterLast");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string4, (String)"missingDelimiterValue");
        CharSequence charSequence = string;
        int n = StringsKt.lastIndexOf$default((CharSequence)charSequence, (String)string2, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string4;
        string4 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)(n + string2.length()), (int)string.length(), (CharSequence)string3)).toString();
        return string4;
    }

    public static /* synthetic */ String replaceAfterLast$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceAfterLast((String)string, (char)c, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.replaceAfterLast((String)string, (char)c, (String)string2, (String)string3);
    }

    public static /* synthetic */ String replaceAfterLast$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceAfterLast((String)string, (String)string2, (String)string3, (String)string4);
        string4 = string;
        return StringsKt.replaceAfterLast((String)string, (String)string2, (String)string3, (String)string4);
    }

    public static final String replaceBefore(String charSequence, char c, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replaceBefore");
        Intrinsics.checkNotNullParameter((Object)string, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"missingDelimiterValue");
        charSequence = charSequence;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string2;
        string2 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)0, (int)n, (CharSequence)string)).toString();
        return string2;
    }

    public static final String replaceBefore(String charSequence, String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replaceBefore");
        Intrinsics.checkNotNullParameter((Object)string, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        charSequence = charSequence;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (String)string, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)0, (int)n, (CharSequence)string2)).toString();
        return string3;
    }

    public static /* synthetic */ String replaceBefore$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceBefore((String)string, (char)c, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.replaceBefore((String)string, (char)c, (String)string2, (String)string3);
    }

    public static /* synthetic */ String replaceBefore$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceBefore((String)string, (String)string2, (String)string3, (String)string4);
        string4 = string;
        return StringsKt.replaceBefore((String)string, (String)string2, (String)string3, (String)string4);
    }

    public static final String replaceBeforeLast(String charSequence, char c, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replaceBeforeLast");
        Intrinsics.checkNotNullParameter((Object)string, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"missingDelimiterValue");
        charSequence = charSequence;
        int n = StringsKt.lastIndexOf$default((CharSequence)charSequence, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string2;
        string2 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)0, (int)n, (CharSequence)string)).toString();
        return string2;
    }

    public static final String replaceBeforeLast(String charSequence, String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replaceBeforeLast");
        Intrinsics.checkNotNullParameter((Object)string, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"replacement");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        charSequence = charSequence;
        int n = StringsKt.lastIndexOf$default((CharSequence)charSequence, (String)string, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = ((Object)StringsKt.replaceRange((CharSequence)charSequence, (int)0, (int)n, (CharSequence)string2)).toString();
        return string3;
    }

    public static /* synthetic */ String replaceBeforeLast$default(String string, char c, String string2, String string3, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceBeforeLast((String)string, (char)c, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.replaceBeforeLast((String)string, (char)c, (String)string2, (String)string3);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String string, String string2, String string3, String string4, int n, Object object) {
        if ((n & 4) == 0) return StringsKt.replaceBeforeLast((String)string, (String)string2, (String)string3, (String)string4);
        string4 = string;
        return StringsKt.replaceBeforeLast((String)string, (String)string2, (String)string3, (String)string4);
    }

    private static final String replaceFirst(CharSequence charSequence, Regex regex, String string) {
        return regex.replaceFirst(charSequence, string);
    }

    private static final String replaceFirstCharWithChar(String charSequence, Function1<? super Character, Character> object) {
        boolean bl = ((CharSequence)charSequence).length() > 0;
        String string = charSequence;
        if (!bl) return string;
        char c = ((Character)object.invoke((Object)Character.valueOf(((String)charSequence).charAt(0)))).charValue();
        if (charSequence == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = ((String)charSequence).substring(1);
        Intrinsics.checkNotNullExpressionValue(object, (String)"(this as java.lang.String).substring(startIndex)");
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(String.valueOf(c));
        ((StringBuilder)charSequence).append((String)object);
        string = ((StringBuilder)charSequence).toString();
        return string;
    }

    private static final String replaceFirstCharWithCharSequence(String string, Function1<? super Character, ? extends CharSequence> function1) {
        boolean bl = ((CharSequence)string).length() > 0;
        CharSequence charSequence = string;
        if (!bl) return charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(function1.invoke((Object)Character.valueOf(string.charAt(0))).toString());
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        string = string.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        ((StringBuilder)charSequence).append(string);
        charSequence = ((StringBuilder)charSequence).toString();
        return charSequence;
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int n, int n2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replaceRange");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"replacement");
        if (n2 >= n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(charSequence, 0, n);
            Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(value, startIndex, endIndex)");
            stringBuilder.append(charSequence2);
            stringBuilder.append(charSequence, n2, charSequence.length());
            Intrinsics.checkNotNullExpressionValue((Object)stringBuilder, (String)"this.append(value, startIndex, endIndex)");
            return stringBuilder;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("End index (");
        ((StringBuilder)charSequence).append(n2);
        ((StringBuilder)charSequence).append(") is less than start index (");
        ((StringBuilder)charSequence).append(n);
        ((StringBuilder)charSequence).append(").");
        throw (Throwable)new IndexOutOfBoundsException(((StringBuilder)charSequence).toString());
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange intRange, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$replaceRange");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"replacement");
        return StringsKt.replaceRange((CharSequence)charSequence, (int)intRange.getStart(), (int)(intRange.getEndInclusive() + 1), (CharSequence)charSequence2);
    }

    private static final String replaceRange(String string, int n, int n2, CharSequence charSequence) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.replaceRange((CharSequence)string, (int)n, (int)n2, (CharSequence)charSequence)).toString();
    }

    private static final String replaceRange(String string, IntRange intRange, CharSequence charSequence) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.replaceRange((CharSequence)string, (IntRange)intRange, (CharSequence)charSequence)).toString();
    }

    public static final void requireNonNegativeLimit(int n) {
        boolean bl = n >= 0;
        if (bl) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Limit must be non-negative, but was ");
        stringBuilder.append(n);
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
    }

    private static final List<String> split(CharSequence charSequence, Regex regex, int n) {
        return regex.split(charSequence, n);
    }

    public static final List<String> split(CharSequence charSequence, char[] object, boolean bl, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$split");
        Intrinsics.checkNotNullParameter((Object)object, (String)"delimiters");
        if (((char[])object).length == 1) {
            return StringsKt__StringsKt.split$StringsKt__StringsKt(charSequence, String.valueOf(object[0]), bl, n);
        }
        Object object2 = SequencesKt.asIterable((Sequence)StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, (char[])object, 0, bl, n, 2, null));
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(StringsKt.substring((CharSequence)charSequence, (IntRange)((IntRange)object2.next())));
        }
        return (List)object;
    }

    public static final List<String> split(CharSequence charSequence, String[] object, boolean bl, int n) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$split");
        Intrinsics.checkNotNullParameter((Object)object, (String)"delimiters");
        int n2 = ((String[])object).length;
        boolean bl2 = true;
        if (n2 == 1) {
            object2 = object[0];
            if (((CharSequence)object2).length() != 0) {
                bl2 = false;
            }
            if (!bl2) {
                return StringsKt__StringsKt.split$StringsKt__StringsKt(charSequence, (String)object2, bl, n);
            }
        }
        object2 = SequencesKt.asIterable((Sequence)StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, (String[])object, 0, bl, n, 2, null));
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(StringsKt.substring((CharSequence)charSequence, (IntRange)((IntRange)object2.next())));
        }
        return (List)object;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String string, boolean bl, int n) {
        int n2;
        StringsKt.requireNonNegativeLimit((int)n);
        int n3 = 0;
        int n4 = StringsKt.indexOf((CharSequence)charSequence, (String)string, (int)0, (boolean)bl);
        if (n4 == -1) return CollectionsKt.listOf((Object)((Object)charSequence).toString());
        if (n == 1) {
            return CollectionsKt.listOf((Object)((Object)charSequence).toString());
        }
        boolean bl2 = n > 0;
        int n5 = 10;
        if (bl2) {
            n5 = RangesKt.coerceAtMost((int)n, (int)10);
        }
        ArrayList<String> arrayList = new ArrayList<String>(n5);
        n5 = n4;
        do {
            arrayList.add(((Object)charSequence.subSequence(n3, n5)).toString());
            n2 = string.length() + n5;
            if (bl2 && arrayList.size() == n - 1) break;
            n4 = StringsKt.indexOf((CharSequence)charSequence, (String)string, (int)n2, (boolean)bl);
            n3 = n2;
            n5 = n4;
        } while (n4 != -1);
        arrayList.add(((Object)charSequence.subSequence(n2, charSequence.length())).toString());
        return arrayList;
    }

    static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return regex.split(charSequence, n);
        n = 0;
        return regex.split(charSequence, n);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) == 0) return StringsKt.split((CharSequence)charSequence, (char[])cArray, (boolean)bl, (int)n);
        n = 0;
        return StringsKt.split((CharSequence)charSequence, (char[])cArray, (boolean)bl, (int)n);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] stringArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) == 0) return StringsKt.split((CharSequence)charSequence, (String[])stringArray, (boolean)bl, (int)n);
        n = 0;
        return StringsKt.split((CharSequence)charSequence, (String[])stringArray, (boolean)bl, (int)n);
    }

    private static final Sequence<String> splitToSequence(CharSequence charSequence, Regex regex, int n) {
        return regex.splitToSequence(charSequence, n);
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, char[] cArray, boolean bl, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$splitToSequence");
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"delimiters");
        return SequencesKt.map((Sequence)StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArray, 0, bl, n, 2, null), (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */));
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, String[] stringArray, boolean bl, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$splitToSequence");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"delimiters");
        return SequencesKt.map((Sequence)StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, stringArray, 0, bl, n, 2, null), (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */));
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, Regex regex, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return regex.splitToSequence(charSequence, n);
        n = 0;
        return regex.splitToSequence(charSequence, n);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) == 0) return StringsKt.splitToSequence((CharSequence)charSequence, (char[])cArray, (boolean)bl, (int)n);
        n = 0;
        return StringsKt.splitToSequence((CharSequence)charSequence, (char[])cArray, (boolean)bl, (int)n);
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] stringArray, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) == 0) return StringsKt.splitToSequence((CharSequence)charSequence, (String[])stringArray, (boolean)bl, (int)n);
        n = 0;
        return StringsKt.splitToSequence((CharSequence)charSequence, (String[])stringArray, (boolean)bl, (int)n);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean bl) {
        boolean bl2;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$startsWith");
        int n = charSequence.length();
        boolean bl3 = bl2 = false;
        if (n <= 0) return bl3;
        bl3 = bl2;
        if (!CharsKt.equals((char)charSequence.charAt(0), (char)c, (boolean)bl)) return bl3;
        bl3 = true;
        return bl3;
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int n, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$startsWith");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"prefix");
        if (bl) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        if (!(charSequence instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        if (!(charSequence2 instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)n, (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        return StringsKt.startsWith$default((String)((String)charSequence), (String)((String)charSequence2), (int)n, (boolean)false, (int)4, null);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$startsWith");
        Intrinsics.checkNotNullParameter((Object)charSequence2, (String)"prefix");
        if (bl) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)0, (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        if (!(charSequence instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)0, (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        if (!(charSequence2 instanceof String)) return StringsKt.regionMatchesImpl((CharSequence)charSequence, (int)0, (CharSequence)charSequence2, (int)0, (int)charSequence2.length(), (boolean)bl);
        return StringsKt.startsWith$default((String)((String)charSequence), (String)((String)charSequence2), (boolean)false, (int)2, null);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.startsWith((CharSequence)charSequence, (char)c, (boolean)bl);
        bl = false;
        return StringsKt.startsWith((CharSequence)charSequence, (char)c, (boolean)bl);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int n, boolean bl, int n2, Object object) {
        if ((n2 & 4) == 0) return StringsKt.startsWith((CharSequence)charSequence, (CharSequence)charSequence2, (int)n, (boolean)bl);
        bl = false;
        return StringsKt.startsWith((CharSequence)charSequence, (CharSequence)charSequence2, (int)n, (boolean)bl);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.startsWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
        bl = false;
        return StringsKt.startsWith((CharSequence)charSequence, (CharSequence)charSequence2, (boolean)bl);
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$subSequence");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        return charSequence.subSequence(intRange.getStart(), intRange.getEndInclusive() + 1);
    }

    @Deprecated(message="Use parameters named startIndex and endIndex.", replaceWith=@ReplaceWith(expression="subSequence(startIndex = start, endIndex = end)", imports={}))
    private static final CharSequence subSequence(String string, int n, int n2) {
        return string.subSequence(n, n2);
    }

    private static final String substring(CharSequence charSequence, int n, int n2) {
        return ((Object)charSequence.subSequence(n, n2)).toString();
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$substring");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        return ((Object)charSequence.subSequence(intRange.getStart(), intRange.getEndInclusive() + 1)).toString();
    }

    public static final String substring(String string, IntRange intRange) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substring");
        Intrinsics.checkNotNullParameter((Object)intRange, (String)"range");
        string = string.substring(intRange.getStart(), intRange.getEndInclusive() + 1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    static /* synthetic */ String substring$default(CharSequence charSequence, int n, int n2, int n3, Object object) {
        if ((n3 & 2) == 0) return ((Object)charSequence.subSequence(n, n2)).toString();
        n2 = charSequence.length();
        return ((Object)charSequence.subSequence(n, n2)).toString();
    }

    public static final String substringAfter(String string, char c, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringAfter");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"missingDelimiterValue");
        int n = StringsKt.indexOf$default((CharSequence)string, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string2;
        string2 = string.substring(n + 1, string.length());
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final String substringAfter(String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringAfter");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        int n = StringsKt.indexOf$default((CharSequence)string, (String)string2, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = string.substring(n + string2.length(), string.length());
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    public static /* synthetic */ String substringAfter$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringAfter((String)string, (char)c, (String)string2);
        string2 = string;
        return StringsKt.substringAfter((String)string, (char)c, (String)string2);
    }

    public static /* synthetic */ String substringAfter$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringAfter((String)string, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.substringAfter((String)string, (String)string2, (String)string3);
    }

    public static final String substringAfterLast(String string, char c, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringAfterLast");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"missingDelimiterValue");
        int n = StringsKt.lastIndexOf$default((CharSequence)string, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string2;
        string2 = string.substring(n + 1, string.length());
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final String substringAfterLast(String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringAfterLast");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        int n = StringsKt.lastIndexOf$default((CharSequence)string, (String)string2, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = string.substring(n + string2.length(), string.length());
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    public static /* synthetic */ String substringAfterLast$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringAfterLast((String)string, (char)c, (String)string2);
        string2 = string;
        return StringsKt.substringAfterLast((String)string, (char)c, (String)string2);
    }

    public static /* synthetic */ String substringAfterLast$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringAfterLast((String)string, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.substringAfterLast((String)string, (String)string2, (String)string3);
    }

    public static final String substringBefore(String string, char c, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringBefore");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"missingDelimiterValue");
        int n = StringsKt.indexOf$default((CharSequence)string, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string2;
        string2 = string.substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final String substringBefore(String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringBefore");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        int n = StringsKt.indexOf$default((CharSequence)string, (String)string2, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = string.substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    public static /* synthetic */ String substringBefore$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringBefore((String)string, (char)c, (String)string2);
        string2 = string;
        return StringsKt.substringBefore((String)string, (char)c, (String)string2);
    }

    public static /* synthetic */ String substringBefore$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringBefore((String)string, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.substringBefore((String)string, (String)string2, (String)string3);
    }

    public static final String substringBeforeLast(String string, char c, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringBeforeLast");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"missingDelimiterValue");
        int n = StringsKt.lastIndexOf$default((CharSequence)string, (char)c, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string2;
        string2 = string.substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final String substringBeforeLast(String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$substringBeforeLast");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiter");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"missingDelimiterValue");
        int n = StringsKt.lastIndexOf$default((CharSequence)string, (String)string2, (int)0, (boolean)false, (int)6, null);
        if (n == -1) return string3;
        string3 = string.substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string3;
    }

    public static /* synthetic */ String substringBeforeLast$default(String string, char c, String string2, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringBeforeLast((String)string, (char)c, (String)string2);
        string2 = string;
        return StringsKt.substringBeforeLast((String)string, (char)c, (String)string2);
    }

    public static /* synthetic */ String substringBeforeLast$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 2) == 0) return StringsKt.substringBeforeLast((String)string, (String)string2, (String)string3);
        string3 = string;
        return StringsKt.substringBeforeLast((String)string, (String)string2, (String)string3);
    }

    public static final boolean toBooleanStrict(String string) {
        block3: {
            boolean bl;
            block4: {
                block2: {
                    Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toBooleanStrict");
                    int n = string.hashCode();
                    if (n == 3569038) break block2;
                    if (n != 97196323 || !string.equals("false")) break block3;
                    bl = false;
                    break block4;
                }
                if (!string.equals("true")) break block3;
                bl = true;
            }
            return bl;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The string doesn't represent a boolean value: ");
        stringBuilder.append(string);
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     */
    public static final Boolean toBooleanStrictOrNull(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toBooleanStrictOrNull");
        int n = ((String)object).hashCode();
        if (n != 3569038) {
            if (n != 97196323) return null;
            if (!((String)object).equals("false")) return null;
            return false;
        }
        if (!((String)object).equals("true")) return null;
        return true;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trim");
        int n = charSequence.length() - 1;
        int n2 = 0;
        boolean bl = false;
        while (n2 <= n) {
            int n3 = !bl ? n2 : n;
            boolean bl2 = CharsKt.isWhitespace((char)charSequence.charAt(n3));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n2;
                continue;
            }
            if (!bl2) {
                return charSequence.subSequence(n2, n + 1);
            }
            --n;
        }
        return charSequence.subSequence(n2, n + 1);
    }

    public static final CharSequence trim(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trim");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        int n = charSequence.length() - 1;
        int n2 = 0;
        boolean bl = false;
        while (n2 <= n) {
            int n3 = !bl ? n2 : n;
            boolean bl2 = (Boolean)function1.invoke((Object)Character.valueOf(charSequence.charAt(n3)));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n2;
                continue;
            }
            if (!bl2) {
                return charSequence.subSequence(n2, n + 1);
            }
            --n;
        }
        return charSequence.subSequence(n2, n + 1);
    }

    public static final CharSequence trim(CharSequence charSequence, char ... cArray) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trim");
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
        int n = charSequence.length() - 1;
        int n2 = 0;
        boolean bl = false;
        while (n2 <= n) {
            int n3 = !bl ? n2 : n;
            boolean bl2 = ArraysKt.contains((char[])cArray, (char)charSequence.charAt(n3));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n2;
                continue;
            }
            if (!bl2) {
                return charSequence.subSequence(n2, n + 1);
            }
            --n;
        }
        return charSequence.subSequence(n2, n + 1);
    }

    private static final String trim(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.trim((CharSequence)string)).toString();
    }

    public static final String trim(String charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trim");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        charSequence = charSequence;
        int n = charSequence.length() - 1;
        int n2 = 0;
        boolean bl = false;
        while (n2 <= n) {
            int n3 = !bl ? n2 : n;
            boolean bl2 = (Boolean)function1.invoke((Object)Character.valueOf(charSequence.charAt(n3)));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n2;
                continue;
            }
            if (!bl2) {
                return ((Object)charSequence.subSequence(n2, n + 1)).toString();
            }
            --n;
        }
        return ((Object)charSequence.subSequence(n2, n + 1)).toString();
    }

    public static final String trim(String charSequence, char ... cArray) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trim");
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
        charSequence = charSequence;
        int n = charSequence.length() - 1;
        int n2 = 0;
        boolean bl = false;
        while (n2 <= n) {
            int n3 = !bl ? n2 : n;
            boolean bl2 = ArraysKt.contains((char[])cArray, (char)charSequence.charAt(n3));
            if (!bl) {
                if (!bl2) {
                    bl = true;
                    continue;
                }
                ++n2;
                continue;
            }
            if (!bl2) {
                return ((Object)charSequence.subSequence(n2, n + 1)).toString();
            }
            --n;
        }
        return ((Object)charSequence.subSequence(n2, n + 1)).toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        block1: {
            int n;
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimEnd");
            int n2 = charSequence.length();
            while ((n = n2 - 1) >= 0) {
                n2 = n;
                if (CharsKt.isWhitespace((char)charSequence.charAt(n))) continue;
                charSequence = charSequence.subSequence(0, n + 1);
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    public static final CharSequence trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        int n;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimEnd");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        int n2 = charSequence.length();
        do {
            if ((n = n2 - 1) < 0) return "";
            n2 = n;
        } while (((Boolean)function1.invoke((Object)Character.valueOf(charSequence.charAt(n)))).booleanValue());
        return charSequence.subSequence(0, n + 1);
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char ... cArray) {
        block1: {
            int n;
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimEnd");
            Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
            int n2 = charSequence.length();
            while ((n = n2 - 1) >= 0) {
                n2 = n;
                if (ArraysKt.contains((char[])cArray, (char)charSequence.charAt(n))) continue;
                charSequence = charSequence.subSequence(0, n + 1);
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    private static final String trimEnd(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.trimEnd((CharSequence)string)).toString();
    }

    public static final String trimEnd(String charSequence, Function1<? super Character, Boolean> function1) {
        block1: {
            int n;
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimEnd");
            Intrinsics.checkNotNullParameter(function1, (String)"predicate");
            charSequence = charSequence;
            int n2 = charSequence.length();
            while ((n = n2 - 1) >= 0) {
                n2 = n;
                if (((Boolean)function1.invoke((Object)Character.valueOf(charSequence.charAt(n)))).booleanValue()) continue;
                charSequence = charSequence.subSequence(0, n + 1);
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }

    public static final String trimEnd(String charSequence, char ... cArray) {
        block1: {
            int n;
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimEnd");
            Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
            charSequence = charSequence;
            int n2 = charSequence.length();
            while ((n = n2 - 1) >= 0) {
                n2 = n;
                if (ArraysKt.contains((char[])cArray, (char)charSequence.charAt(n))) continue;
                charSequence = charSequence.subSequence(0, n + 1);
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimStart");
            int n = charSequence.length();
            for (int i = 0; i < n; ++i) {
                if (CharsKt.isWhitespace((char)charSequence.charAt(i))) continue;
                charSequence = charSequence.subSequence(i, charSequence.length());
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimStart");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        int n = charSequence.length();
        int n2 = 0;
        while (n2 < n) {
            if (!((Boolean)function1.invoke((Object)Character.valueOf(charSequence.charAt(n2)))).booleanValue()) {
                return charSequence.subSequence(n2, charSequence.length());
            }
            ++n2;
        }
        return "";
    }

    public static final CharSequence trimStart(CharSequence charSequence, char ... cArray) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimStart");
            Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
            int n = charSequence.length();
            for (int i = 0; i < n; ++i) {
                if (ArraysKt.contains((char[])cArray, (char)charSequence.charAt(i))) continue;
                charSequence = charSequence.subSequence(i, charSequence.length());
                break block1;
            }
            charSequence = "";
        }
        return charSequence;
    }

    private static final String trimStart(String string) {
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        return ((Object)StringsKt.trimStart((CharSequence)string)).toString();
    }

    public static final String trimStart(String charSequence, Function1<? super Character, Boolean> function1) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimStart");
            Intrinsics.checkNotNullParameter(function1, (String)"predicate");
            charSequence = charSequence;
            int n = charSequence.length();
            for (int i = 0; i < n; ++i) {
                if (((Boolean)function1.invoke((Object)Character.valueOf(charSequence.charAt(i)))).booleanValue()) continue;
                charSequence = charSequence.subSequence(i, charSequence.length());
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }

    public static final String trimStart(String charSequence, char ... cArray) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)charSequence, (String)"$this$trimStart");
            Intrinsics.checkNotNullParameter((Object)cArray, (String)"chars");
            charSequence = charSequence;
            int n = charSequence.length();
            for (int i = 0; i < n; ++i) {
                if (ArraysKt.contains((char[])cArray, (char)charSequence.charAt(i))) continue;
                charSequence = charSequence.subSequence(i, charSequence.length());
                break block1;
            }
            charSequence = "";
        }
        return charSequence.toString();
    }
}
