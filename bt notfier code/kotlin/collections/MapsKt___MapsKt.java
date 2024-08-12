/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecatedSinceKotlin
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt__MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
@Metadata(d1={"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\b\u00f8\u0001\u0000\u001aa\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\b\u00f8\u0001\u0000\u001aV\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\b\u00f8\u0001\u0000\u001a\\\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\b\u00f8\u0001\u0000\u001au\u0010#\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u001ah\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u001ah\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u001a_\u0010)\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001aJ\u0010)\u001a\u00020+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\b\u00f8\u0001\u0000\u001aJ\u0010)\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000\u001aa\u0010-\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001aQ\u0010-\u001a\u0004\u0018\u00010+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.\u001aQ\u0010-\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/\u001aq\u00100\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104\u001as\u00105\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104\u001ai\u00106\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0087\b\u001ai\u00107\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0087\b\u001ah\u00108\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u001ah\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u001a_\u0010:\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001aJ\u0010:\u001a\u00020+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\b\u00f8\u0001\u0000\u001aJ\u0010:\u001a\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000\u001aa\u0010;\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001aQ\u0010;\u001a\u0004\u0018\u00010+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.\u001aQ\u0010;\u001a\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010/\u001aq\u0010<\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104\u001as\u0010=\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u001002j\n\u0012\u0006\b\u0000\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104\u001ah\u0010>\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0007\u001ai\u0010?\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0087\b\u001a$\u0010@\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010@\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001aY\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HB2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010C\u001an\u0010D\u001a\u0002HB\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HB23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0EH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010I\u001a6\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030K0\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006L"}, d2={"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrNull", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt___MapsKt
extends MapsKt__MapsKt {
    public static final <K, V> boolean all(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$all");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        if (object.isEmpty()) {
            return true;
        }
        object = object.entrySet().iterator();
        do {
            if (!object.hasNext()) return true;
        } while (((Boolean)function1.invoke((Object)((Map.Entry)object.next()))).booleanValue());
        return false;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, (String)"$this$any");
        return map.isEmpty() ^ true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$any");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        if (object.isEmpty()) {
            return false;
        }
        object = object.entrySet().iterator();
        do {
            if (!object.hasNext()) return false;
        } while (!((Boolean)function1.invoke((Object)((Map.Entry)object.next()))).booleanValue());
        return true;
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, (String)"$this$asSequence");
        return CollectionsKt.asSequence((Iterable)map.entrySet());
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> map) {
        return map.size();
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$count");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        boolean bl = object.isEmpty();
        int n = 0;
        if (bl) {
            return 0;
        }
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            if (!((Boolean)function1.invoke((Object)((Map.Entry)object.next()))).booleanValue()) continue;
            ++n;
        }
        return n;
    }

    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        block2: {
            Iterator<Map.Entry<K, V>> iterator = object.entrySet().iterator();
            while (iterator.hasNext()) {
                object = function1.invoke(iterator.next());
                if (object == null) continue;
                break block2;
            }
            object = null;
        }
        if (object != null) {
            return (R)object;
        }
        object = new NoSuchElementException("No element of the map was transformed to a non-null value.");
        throw object;
    }

    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<Map.Entry<K, V>> iterator = object.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((object = function1.invoke(iterator.next())) == null);
        return (R)object;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        Collection collection = new ArrayList();
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            CollectionsKt.addAll((Collection)collection, (Iterable)((Iterable)function1.invoke((Object)((Map.Entry)object.next()))));
        }
        return (List)collection;
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        Collection collection = new ArrayList();
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            CollectionsKt.addAll((Collection)collection, (Sequence)((Sequence)function1.invoke((Object)((Map.Entry)object.next()))));
        }
        return (List)collection;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> object, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c, (String)"destination");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            CollectionsKt.addAll(c, (Sequence)((Sequence)function1.invoke((Object)((Map.Entry)object.next()))));
        }
        return c;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> object, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c, (String)"destination");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            CollectionsKt.addAll(c, (Iterable)((Iterable)function1.invoke((Object)((Map.Entry)object.next()))));
        }
        return c;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$forEach");
        Intrinsics.checkNotNullParameter(function1, (String)"action");
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            function1.invoke((Object)((Map.Entry)object.next()));
        }
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$map");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        Collection collection = new ArrayList(object.size());
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            collection.add(function1.invoke((Object)((Map.Entry)object.next())));
        }
        return (List)collection;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$mapNotNull");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        Collection collection = new ArrayList();
        Iterator<Map.Entry<K, V>> iterator = object.entrySet().iterator();
        while (iterator.hasNext()) {
            object = function1.invoke(iterator.next());
            if (object == null) continue;
            collection.add(object);
        }
        return (List)collection;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> object, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(c, (String)"destination");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            Object object2 = function1.invoke((Object)((Map.Entry)object.next()));
            if (object2 == null) continue;
            c.add((Object)object2);
        }
        return c;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> object, C c, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$mapTo");
        Intrinsics.checkNotNullParameter(c, (String)"destination");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            c.add((Object)function1.invoke((Object)((Map.Entry)object.next())));
        }
        return c;
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith=@ReplaceWith(expression="this.maxByOrNull(selector)", imports={}))
    @DeprecatedSinceKotlin(errorSince="1.5", warningSince="1.4")
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)map.entrySet()).iterator();
        if (!iterator.hasNext()) {
            map = null;
        } else {
            map = iterator.next();
            if (!iterator.hasNext()) return (Map.Entry)((Object)map);
            Comparable comparable = (Comparable)function1.invoke(map);
            Map<K, V> map2 = map;
            do {
                Object t = iterator.next();
                Comparable comparable2 = (Comparable)function1.invoke(t);
                map = map2;
                Comparable comparable3 = comparable;
                if (comparable.compareTo(comparable2) < 0) {
                    map = t;
                    comparable3 = comparable2;
                }
                map2 = map;
                comparable = comparable3;
            } while (iterator.hasNext());
        }
        return (Map.Entry)((Object)map);
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)map.entrySet()).iterator();
        if (!iterator.hasNext()) {
            map = null;
        } else {
            map = iterator.next();
            if (!iterator.hasNext()) return (Map.Entry)((Object)map);
            Comparable comparable = (Comparable)function1.invoke(map);
            Map<K, V> map2 = map;
            do {
                Object t = iterator.next();
                Comparable comparable2 = (Comparable)function1.invoke(t);
                map = map2;
                Comparable comparable3 = comparable;
                if (comparable.compareTo(comparable2) < 0) {
                    map = t;
                    comparable3 = comparable2;
                }
                map2 = map;
                comparable = comparable3;
            } while (iterator.hasNext());
        }
        return (Map.Entry)((Object)map);
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        double d = ((Number)function1.invoke(object.next())).doubleValue();
        while (object.hasNext()) {
            d = Math.max(d, ((Number)function1.invoke(object.next())).doubleValue());
        }
        return d;
    }

    private static final <K, V> float maxOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        float f = ((Number)function1.invoke(object.next())).floatValue();
        while (object.hasNext()) {
            f = Math.max(f, ((Number)function1.invoke(object.next())).floatValue());
        }
        return f;
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        object = (Comparable)function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)function1.invoke(iterator.next());
            if (object.compareTo(comparable) >= 0) continue;
            object = comparable;
        }
        return (R)object;
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = null;
            return (R)object;
        }
        object = (Comparable)function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)function1.invoke(iterator.next());
            if (object.compareTo(comparable) >= 0) continue;
            object = comparable;
        }
        return (R)object;
    }

    private static final <K, V> Double maxOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = null;
        } else {
            double d = ((Number)function1.invoke(object.next())).doubleValue();
            while (object.hasNext()) {
                d = Math.max(d, ((Number)function1.invoke(object.next())).doubleValue());
            }
            object = d;
        }
        return object;
    }

    private static final <K, V> Float maxOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = null;
        } else {
            float f = ((Number)function1.invoke(object.next())).floatValue();
            while (object.hasNext()) {
                f = Math.max(f, ((Number)function1.invoke(object.next())).floatValue());
            }
            object = Float.valueOf(f);
        }
        return object;
    }

    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> object, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        object = function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Object object2 = function1.invoke(iterator.next());
            if (comparator.compare(object, object2) >= 0) continue;
            object = object2;
        }
        return (R)object;
    }

    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> object, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = null;
            return (R)object;
        }
        object = function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Object object2 = function1.invoke(iterator.next());
            if (comparator.compare(object, object2) >= 0) continue;
            object = object2;
        }
        return (R)object;
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith=@ReplaceWith(expression="this.maxWithOrNull(comparator)", imports={}))
    @DeprecatedSinceKotlin(errorSince="1.5", warningSince="1.4")
    private static final <K, V> Map.Entry<K, V> maxWith(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry)CollectionsKt.maxWithOrNull((Iterable)map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry)CollectionsKt.maxWithOrNull((Iterable)map.entrySet(), comparator);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith=@ReplaceWith(expression="this.minByOrNull(selector)", imports={}))
    @DeprecatedSinceKotlin(errorSince="1.5", warningSince="1.4")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, (String)"$this$minBy");
        Intrinsics.checkNotNullParameter(function1, (String)"selector");
        Iterator iterator = ((Iterable)map.entrySet()).iterator();
        if (!iterator.hasNext()) {
            map = null;
        } else {
            map = iterator.next();
            if (!iterator.hasNext()) return (Map.Entry)((Object)map);
            Comparable comparable = (Comparable)function1.invoke(map);
            Map<K, V> map2 = map;
            do {
                Object t = iterator.next();
                Comparable comparable2 = (Comparable)function1.invoke(t);
                map = map2;
                Comparable comparable3 = comparable;
                if (comparable.compareTo(comparable2) > 0) {
                    map = t;
                    comparable3 = comparable2;
                }
                map2 = map;
                comparable = comparable3;
            } while (iterator.hasNext());
        }
        return (Map.Entry)((Object)map);
    }

    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)map.entrySet()).iterator();
        if (!iterator.hasNext()) {
            map = null;
        } else {
            map = iterator.next();
            if (!iterator.hasNext()) return (Map.Entry)((Object)map);
            Comparable comparable = (Comparable)function1.invoke(map);
            Map<K, V> map2 = map;
            do {
                Object t = iterator.next();
                Comparable comparable2 = (Comparable)function1.invoke(t);
                map = map2;
                Comparable comparable3 = comparable;
                if (comparable.compareTo(comparable2) > 0) {
                    map = t;
                    comparable3 = comparable2;
                }
                map2 = map;
                comparable = comparable3;
            } while (iterator.hasNext());
        }
        return (Map.Entry)((Object)map);
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        double d = ((Number)function1.invoke(object.next())).doubleValue();
        while (object.hasNext()) {
            d = Math.min(d, ((Number)function1.invoke(object.next())).doubleValue());
        }
        return d;
    }

    private static final <K, V> float minOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        float f = ((Number)function1.invoke(object.next())).floatValue();
        while (object.hasNext()) {
            f = Math.min(f, ((Number)function1.invoke(object.next())).floatValue());
        }
        return f;
    }

    private static final <K, V, R extends Comparable<? super R>> R minOf(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        object = (Comparable)function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)function1.invoke(iterator.next());
            if (object.compareTo(comparable) <= 0) continue;
            object = comparable;
        }
        return (R)object;
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = null;
            return (R)object;
        }
        object = (Comparable)function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)function1.invoke(iterator.next());
            if (object.compareTo(comparable) <= 0) continue;
            object = comparable;
        }
        return (R)object;
    }

    private static final <K, V> Double minOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = null;
        } else {
            double d = ((Number)function1.invoke(object.next())).doubleValue();
            while (object.hasNext()) {
                d = Math.min(d, ((Number)function1.invoke(object.next())).doubleValue());
            }
            object = d;
        }
        return object;
    }

    private static final <K, V> Float minOfOrNull(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        if (!(object = ((Iterable)object.entrySet()).iterator()).hasNext()) {
            object = null;
        } else {
            float f = ((Number)function1.invoke(object.next())).floatValue();
            while (object.hasNext()) {
                f = Math.min(f, ((Number)function1.invoke(object.next())).floatValue());
            }
            object = Float.valueOf(f);
        }
        return object;
    }

    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> object, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = new NoSuchElementException();
            throw object;
        }
        object = function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Object object2 = function1.invoke(iterator.next());
            if (comparator.compare(object, object2) <= 0) continue;
            object = object2;
        }
        return (R)object;
    }

    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> object, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator iterator = ((Iterable)object.entrySet()).iterator();
        if (!iterator.hasNext()) {
            object = null;
            return (R)object;
        }
        object = function1.invoke(iterator.next());
        while (iterator.hasNext()) {
            Object object2 = function1.invoke(iterator.next());
            if (comparator.compare(object, object2) <= 0) continue;
            object = object2;
        }
        return (R)object;
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith=@ReplaceWith(expression="this.minWithOrNull(comparator)", imports={}))
    @DeprecatedSinceKotlin(errorSince="1.5", warningSince="1.4")
    public static final <K, V> Map.Entry<K, V> minWith(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, (String)"$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
        return (Map.Entry)CollectionsKt.minWithOrNull((Iterable)map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry)CollectionsKt.minWithOrNull((Iterable)map.entrySet(), comparator);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, (String)"$this$none");
        return map.isEmpty();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> object, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$none");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        if (object.isEmpty()) {
            return true;
        }
        object = object.entrySet().iterator();
        do {
            if (!object.hasNext()) return true;
        } while (!((Boolean)function1.invoke((Object)((Map.Entry)object.next()))).booleanValue());
        return false;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M m, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(m, (String)"$this$onEach");
        Intrinsics.checkNotNullParameter(function1, (String)"action");
        Iterator<Map.Entry<K, V>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()) {
            function1.invoke(iterator.next());
        }
        return m;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M m, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> function2) {
        Intrinsics.checkNotNullParameter(m, (String)"$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(function2, (String)"action");
        Iterator iterator = ((Iterable)m.entrySet()).iterator();
        int n = 0;
        while (iterator.hasNext()) {
            Object t = iterator.next();
            if (n < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function2.invoke((Object)n, t);
            ++n;
        }
        return m;
    }

    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> object) {
        Intrinsics.checkNotNullParameter(object, (String)"$this$toList");
        if (object.size() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterator<Map.Entry<K, V>> iterator = object.entrySet().iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Map.Entry<K, V> entry = iterator.next();
        if (!iterator.hasNext()) {
            return CollectionsKt.listOf((Object)new Pair(entry.getKey(), entry.getValue()));
        }
        object = new ArrayList(object.size());
        ((ArrayList)object).add(new Pair(entry.getKey(), entry.getValue()));
        do {
            entry = iterator.next();
            ((ArrayList)object).add(new Pair(entry.getKey(), entry.getValue()));
        } while (iterator.hasNext());
        return (List)object;
    }
}
