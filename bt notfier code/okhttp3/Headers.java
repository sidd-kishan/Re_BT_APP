/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ReplaceWith
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.ArrayIteratorKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.text.StringsKt
 *  okhttp3.Headers$Builder
 *  okhttp3.Headers$Companion
 *  okhttp3.internal.Util
 *  okhttp3.internal.http.DatesKt
 */
package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0096\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\n\u00a8\u0006("}, d2={"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", "values", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Headers
implements Iterable<Pair<? extends String, ? extends String>>,
KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    private Headers(String[] stringArray) {
        this.namesAndValues = stringArray;
    }

    public /* synthetic */ Headers(String[] stringArray, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringArray);
    }

    @JvmStatic
    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    @JvmStatic
    public static final Headers of(String ... stringArray) {
        return Companion.of(stringArray);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
    public final int _deprecated_size() {
        return this.size();
    }

    public final long byteCount() {
        String[] stringArray = this.namesAndValues;
        long l = stringArray.length * 2;
        int n = stringArray.length;
        long l2 = l;
        if (n <= 0) return l2;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            l2 = l + (long)this.namesAndValues[n2].length();
            if (n3 >= n) {
                return l2;
            }
            n2 = n3;
            l = l2;
        }
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof Headers && Arrays.equals(this.namesAndValues, ((Headers)object).namesAndValues);
        return bl;
    }

    public final String get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return okhttp3.Headers$Companion.access$get((Companion)Companion, (String[])this.namesAndValues, (String)string);
    }

    public final Date getDate(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"name");
        object = this.get((String)object);
        object = object == null ? null : DatesKt.toHttpDateOrNull((String)object);
        return object;
    }

    public final Instant getInstant(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"name");
        object = this.getDate((String)object);
        object = object == null ? null : ((Date)object).toInstant();
        return object;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override
    public Iterator<Pair<String, String>> iterator() {
        int n = this.size();
        Object[] objectArray = new Pair[n];
        int n2 = 0;
        while (n2 < n) {
            objectArray[n2] = TuplesKt.to((Object)this.name(n2), (Object)this.value(n2));
            ++n2;
        }
        return ArrayIteratorKt.iterator((Object[])objectArray);
    }

    public final String name(int n) {
        return this.namesAndValues[n * 2];
    }

    public final Set<String> names() {
        TreeSet<String> treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER((StringCompanionObject)StringCompanionObject.INSTANCE));
        int n = this.size();
        if (n > 0) {
            int n2 = 0;
            while (true) {
                int n3 = n2 + 1;
                treeSet.add(this.name(n2));
                if (n3 >= n) break;
                n2 = n3;
            }
        }
        treeSet = Collections.unmodifiableSet((Set)treeSet);
        Intrinsics.checkNotNullExpressionValue(treeSet, (String)"unmodifiableSet(result)");
        return treeSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        CollectionsKt.addAll((Collection)builder.getNamesAndValues$okhttp(), (Object[])this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER((StringCompanionObject)StringCompanionObject.INSTANCE));
        int n = this.size();
        if (n <= 0) return treeMap;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            Object object = this.name(n2);
            Object object2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"US");
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            String string = ((String)object).toLowerCase((Locale)object2);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).toLowerCase(locale)");
            object = object2 = (List)treeMap.get(string);
            if (object2 == null) {
                object = new ArrayList(2);
                ((Map)treeMap).put(string, object);
            }
            object.add(this.value(n2));
            if (n3 >= n) {
                return treeMap;
            }
            n2 = n3;
        }
    }

    public String toString() {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        int n = this.size();
        if (n > 0) {
            int n2 = 0;
            while (true) {
                int n3 = n2 + 1;
                String string2 = this.name(n2);
                string = this.value(n2);
                stringBuilder.append(string2);
                stringBuilder.append(": ");
                if (Util.isSensitiveHeader((String)string2)) {
                    string = "\u2588\u2588";
                }
                stringBuilder.append(string);
                stringBuilder.append("\n");
                if (n3 >= n) break;
                n2 = n3;
            }
        }
        string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int n) {
        return this.namesAndValues[n * 2 + 1];
    }

    public final List<String> values(String list) {
        Intrinsics.checkNotNullParameter((Object)list, (String)"name");
        int n = this.size();
        List list2 = null;
        List list3 = null;
        if (n > 0) {
            int n2 = 0;
            while (true) {
                int n3 = n2 + 1;
                list2 = list3;
                if (StringsKt.equals(list, (String)this.name(n2), (boolean)true)) {
                    list2 = list3;
                    if (list3 == null) {
                        list2 = new ArrayList(2);
                    }
                    list2.add(this.value(n2));
                }
                if (n3 >= n) break;
                n2 = n3;
                list3 = list2;
            }
        }
        if (list2 != null) {
            list = Collections.unmodifiableList(list2);
            Intrinsics.checkNotNullExpressionValue(list, (String)"{\n      Collections.unmodifiableList(result)\n    }");
        } else {
            list = CollectionsKt.emptyList();
        }
        return list;
    }
}
