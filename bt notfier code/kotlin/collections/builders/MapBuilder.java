/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.builders.ListBuilderKt
 *  kotlin.collections.builders.MapBuilder$Companion
 *  kotlin.collections.builders.MapBuilder$EntriesItr
 *  kotlin.collections.builders.MapBuilder$KeysItr
 *  kotlin.collections.builders.MapBuilder$ValuesItr
 *  kotlin.collections.builders.MapBuilderEntries
 *  kotlin.collections.builders.MapBuilderKeys
 *  kotlin.collections.builders.MapBuilderValues
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.markers.KMutableMap
 *  kotlin.ranges.RangesKt
 */
package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.builders.ListBuilderKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.MapBuilderEntries;
import kotlin.collections.builders.MapBuilderKeys;
import kotlin.collections.builders.MapBuilderValues;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 v*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0006vwxyz{B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007BE\b\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0010J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b0\u00101J\u0013\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002\u00a2\u0006\u0002\u00103J\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105J\r\u00106\u001a\u000207H\u0000\u00a2\u0006\u0002\b8J\b\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000207H\u0002J\u0019\u0010;\u001a\u00020\u001f2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0000\u00a2\u0006\u0002\b>J!\u0010?\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000\u00a2\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u001f2\u0006\u0010/\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010DJ\u0018\u0010G\u001a\u00020\u001f2\u000e\u0010H\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000305H\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0019\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010MH\u0000\u00a2\u0006\u0002\bNJ\u0013\u0010O\u001a\u00020\u001f2\b\u0010H\u001a\u0004\u0018\u00010PH\u0096\u0002J\u0015\u0010Q\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u00101J\u0015\u0010R\u001a\u00020\u00062\u0006\u0010F\u001a\u00028\u0001H\u0002\u00a2\u0006\u0002\u00101J\u0018\u0010S\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010TJ\u0015\u0010U\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u00101J\b\u0010V\u001a\u00020\u0006H\u0016J\b\u0010W\u001a\u00020\u001fH\u0016J\u0019\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010YH\u0000\u00a2\u0006\u0002\bZJ\u001f\u0010[\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\\J\u001e\u0010]\u001a\u0002072\u0014\u0010^\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105H\u0016J\"\u0010_\u001a\u00020\u001f2\u0018\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A0=H\u0002J\u001c\u0010`\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0002J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u0006H\u0002J\u0010\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020\u0006H\u0002J\u0017\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010TJ!\u0010f\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000\u00a2\u0006\u0002\bgJ\u0010\u0010h\u001a\u0002072\u0006\u0010i\u001a\u00020\u0006H\u0002J\u0017\u0010j\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\bk\u00101J\u0010\u0010l\u001a\u0002072\u0006\u0010m\u001a\u00020\u0006H\u0002J\u0017\u0010n\u001a\u00020\u001f2\u0006\u0010o\u001a\u00028\u0001H\u0000\u00a2\u0006\u0004\bp\u0010DJ\b\u0010q\u001a\u00020rH\u0016J\u0019\u0010s\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010tH\u0000\u00a2\u0006\u0002\buR\u0014\u0010\u0011\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\"R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\"R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006|"}, d2={"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "isReadOnly", "", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "<set-?>", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class MapBuilder<K, V>
implements Map<K, V>,
KMutableMap {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int n) {
        this(ListBuilderKt.arrayOfUninitializedElements((int)n), null, new int[n], new int[kotlin.collections.builders.MapBuilder$Companion.access$computeHashSize((Companion)Companion, (int)n)], 2, 0);
    }

    private MapBuilder(K[] KArray, V[] VArray, int[] nArray, int[] nArray2, int n, int n2) {
        this.keysArray = KArray;
        this.valuesArray = VArray;
        this.presenceArray = nArray;
        this.hashArray = nArray2;
        this.maxProbeDistance = n;
        this.length = n2;
        this.hashShift = kotlin.collections.builders.MapBuilder$Companion.access$computeShift((Companion)Companion, (int)this.getHashSize());
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(MapBuilder mapBuilder) {
        return mapBuilder.allocateValuesArray();
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(MapBuilder mapBuilder) {
        return mapBuilder.keysArray;
    }

    public static final /* synthetic */ int access$getLength$p(MapBuilder mapBuilder) {
        return mapBuilder.length;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(MapBuilder mapBuilder) {
        return mapBuilder.presenceArray;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(MapBuilder mapBuilder) {
        return mapBuilder.valuesArray;
    }

    public static final /* synthetic */ void access$removeKeyAt(MapBuilder mapBuilder, int n) {
        mapBuilder.removeKeyAt(n);
    }

    public static final /* synthetic */ void access$setKeysArray$p(MapBuilder mapBuilder, Object[] objectArray) {
        mapBuilder.keysArray = objectArray;
    }

    public static final /* synthetic */ void access$setLength$p(MapBuilder mapBuilder, int n) {
        mapBuilder.length = n;
    }

    public static final /* synthetic */ void access$setPresenceArray$p(MapBuilder mapBuilder, int[] nArray) {
        mapBuilder.presenceArray = nArray;
    }

    public static final /* synthetic */ void access$setValuesArray$p(MapBuilder mapBuilder, Object[] objectArray) {
        mapBuilder.valuesArray = objectArray;
    }

    private final V[] allocateValuesArray() {
        Object[] objectArray = this.valuesArray;
        if (objectArray != null) {
            return objectArray;
        }
        this.valuesArray = objectArray = ListBuilderKt.arrayOfUninitializedElements((int)this.getCapacity());
        return objectArray;
    }

    private final void compact() {
        int n;
        Object[] objectArray = this.valuesArray;
        int n2 = 0;
        for (int i = 0; i < (n = this.length); ++i) {
            n = n2;
            if (this.presenceArray[i] >= 0) {
                K[] KArray = this.keysArray;
                KArray[n2] = KArray[i];
                if (objectArray != null) {
                    objectArray[n2] = objectArray[i];
                }
                n = n2 + 1;
            }
            n2 = n;
        }
        ListBuilderKt.resetRange((Object[])this.keysArray, (int)n2, (int)n);
        if (objectArray != null) {
            ListBuilderKt.resetRange((Object[])objectArray, (int)n2, (int)this.length);
        }
        this.length = n2;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        boolean bl = this.size() == map.size() && this.containsAllEntries$kotlin_stdlib((Collection)map.entrySet());
        return bl;
    }

    private final void ensureCapacity(int n) {
        if (n > this.getCapacity()) {
            int n2 = this.getCapacity() * 3 / 2;
            if (n <= n2) {
                n = n2;
            }
            this.keysArray = ListBuilderKt.copyOfUninitializedElements((Object[])this.keysArray, (int)n);
            Object object = this.valuesArray;
            object = object != null ? ListBuilderKt.copyOfUninitializedElements((Object[])object, (int)n) : null;
            this.valuesArray = object;
            object = Arrays.copyOf(this.presenceArray, n);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, newSize)");
            this.presenceArray = (int[])object;
            n = kotlin.collections.builders.MapBuilder$Companion.access$computeHashSize((Companion)Companion, (int)n);
            if (n <= this.getHashSize()) return;
            this.rehash(n);
        } else {
            if (this.length + n - this.size() <= this.getCapacity()) return;
            this.rehash(this.getHashSize());
        }
    }

    private final void ensureExtraCapacity(int n) {
        this.ensureCapacity(this.length + n);
    }

    private final int findKey(K k) {
        int n = this.hash(k);
        int n2 = this.maxProbeDistance;
        int n3;
        while ((n3 = this.hashArray[n]) != 0) {
            K[] KArray;
            if (n3 > 0 && Intrinsics.areEqual((KArray = this.keysArray)[--n3], k)) {
                return n3;
            }
            if (--n2 < 0) {
                return -1;
            }
            if (n == 0) {
                n = this.getHashSize() - 1;
                continue;
            }
            --n;
        }
        return -1;
    }

    private final int findValue(V v) {
        int n;
        int n2 = this.length;
        while ((n = n2 - 1) >= 0) {
            n2 = n;
            if (this.presenceArray[n] < 0) continue;
            V[] VArray = this.valuesArray;
            Intrinsics.checkNotNull(VArray);
            n2 = n;
            if (Intrinsics.areEqual(VArray[n], v)) return n;
        }
        return -1;
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k) {
        int n = k != null ? k.hashCode() : 0;
        return n * -1640531527 >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> object) {
        boolean bl = object.isEmpty();
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        this.ensureExtraCapacity(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            if (!this.putEntry((Map.Entry)object.next())) continue;
            bl2 = true;
        }
        return bl2;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int n = this.addKey$kotlin_stdlib(entry.getKey());
        V[] VArray = this.allocateValuesArray();
        if (n >= 0) {
            VArray[n] = entry.getValue();
            return true;
        }
        n = -n - 1;
        V v = VArray[n];
        if (!(Intrinsics.areEqual(entry.getValue(), v) ^ true)) return false;
        VArray[n] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int n) {
        int n2 = this.hash(this.keysArray[n]);
        int n3 = this.maxProbeDistance;
        while (true) {
            int[] nArray;
            if ((nArray = this.hashArray)[n2] == 0) {
                nArray[n2] = n + 1;
                this.presenceArray[n] = n2;
                return true;
            }
            if (--n3 < 0) {
                return false;
            }
            if (n2 == 0) {
                n2 = this.getHashSize() - 1;
                continue;
            }
            --n2;
        }
    }

    private final void rehash(int n) {
        if (this.length > this.size()) {
            this.compact();
        }
        int n2 = this.getHashSize();
        int n3 = 0;
        if (n != n2) {
            this.hashArray = new int[n];
            this.hashShift = kotlin.collections.builders.MapBuilder$Companion.access$computeShift((Companion)Companion, (int)n);
            n = n3;
        } else {
            ArraysKt.fill((int[])this.hashArray, (int)0, (int)0, (int)this.getHashSize());
            n = n3;
        }
        while (n < this.length) {
            if (!this.putRehash(n)) throw (Throwable)new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            ++n;
        }
    }

    private final void removeHashAt(int n) {
        int n2;
        int n3 = RangesKt.coerceAtMost((int)(this.maxProbeDistance * 2), (int)(this.getHashSize() / 2));
        int n4 = 0;
        int n5 = n;
        do {
            int n6;
            block8: {
                block7: {
                    int n7;
                    Object[] objectArray;
                    block6: {
                        n = n == 0 ? this.getHashSize() - 1 : --n;
                        n2 = n4 + 1;
                        if (n2 > this.maxProbeDistance) {
                            this.hashArray[n5] = 0;
                            return;
                        }
                        objectArray = this.hashArray;
                        n7 = objectArray[n];
                        if (n7 == 0) {
                            objectArray[n5] = 0;
                            return;
                        }
                        if (n7 >= 0) break block6;
                        objectArray[n5] = -1;
                        break block7;
                    }
                    objectArray = this.keysArray;
                    int n8 = n7 - 1;
                    n6 = n5;
                    n4 = n2;
                    if ((this.hash(objectArray[n8]) - n & this.getHashSize() - 1) < n2) break block8;
                    this.hashArray[n5] = n7;
                    this.presenceArray[n8] = n5;
                }
                n6 = n;
                n4 = 0;
            }
            n2 = n3 - 1;
            n5 = n6;
            n3 = n2;
        } while (n2 >= 0);
        this.hashArray[n6] = -1;
    }

    private final void removeKeyAt(int n) {
        ListBuilderKt.resetAt((Object[])this.keysArray, (int)n);
        this.removeHashAt(this.presenceArray[n]);
        this.presenceArray[n] = -1;
        this.size = this.size() - 1;
    }

    public final int addKey$kotlin_stdlib(K k) {
        this.checkIsMutable$kotlin_stdlib();
        block0: while (true) {
            int n = this.hash(k);
            int n2 = RangesKt.coerceAtMost((int)(this.maxProbeDistance * 2), (int)(this.getHashSize() / 2));
            int n3 = 0;
            while (true) {
                int n4;
                if ((n4 = this.hashArray[n]) <= 0) {
                    if (this.length < this.getCapacity()) {
                        n4 = this.length;
                        this.length = n2 = n4 + 1;
                        this.keysArray[n4] = k;
                        this.presenceArray[n4] = n;
                        this.hashArray[n] = n2;
                        this.size = this.size() + 1;
                        if (n3 <= this.maxProbeDistance) return n4;
                        this.maxProbeDistance = n3;
                        return n4;
                    }
                    this.ensureExtraCapacity(1);
                    continue block0;
                }
                if (Intrinsics.areEqual(this.keysArray[n4 - 1], k)) {
                    return -n4;
                }
                if (++n3 > n2) {
                    this.rehash(this.getHashSize() * 2);
                    continue block0;
                }
                if (n == 0) {
                    n = this.getHashSize() - 1;
                    continue;
                }
                --n;
            }
            break;
        }
    }

    public final Map<K, V> build() {
        this.checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) throw (Throwable)new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        Object[] objectArray;
        this.checkIsMutable$kotlin_stdlib();
        int n = this.length - 1;
        if (n >= 0) {
            int n2 = 0;
            while (true) {
                int n3;
                if ((n3 = (objectArray = this.presenceArray)[n2]) >= 0) {
                    this.hashArray[n3] = 0;
                    objectArray[n2] = -1;
                }
                if (n2 == n) break;
                ++n2;
            }
        }
        ListBuilderKt.resetRange((Object[])this.keysArray, (int)0, (int)this.length);
        objectArray = this.valuesArray;
        if (objectArray != null) {
            ListBuilderKt.resetRange((Object[])objectArray, (int)0, (int)this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    /*
     * Exception decompiling
     */
    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 0[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        int n = this.findKey(entry.getKey());
        if (n < 0) {
            return false;
        }
        V[] VArray = this.valuesArray;
        Intrinsics.checkNotNull(VArray);
        return Intrinsics.areEqual(VArray[n], entry.getValue());
    }

    @Override
    public boolean containsKey(Object object) {
        boolean bl = this.findKey(object) >= 0;
        return bl;
    }

    @Override
    public boolean containsValue(Object object) {
        boolean bl = this.findValue(object) >= 0;
        return bl;
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr(this);
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = object == this || object instanceof Map && this.contentEquals((Map)object);
        return bl;
    }

    @Override
    public V get(Object VArray) {
        int n = this.findKey(VArray);
        if (n < 0) {
            return null;
        }
        VArray = this.valuesArray;
        Intrinsics.checkNotNull(VArray);
        return VArray[n];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries != null) return (Set)mapBuilderEntries;
        this.entriesView = mapBuilderEntries = new MapBuilderEntries(this);
        return (Set)mapBuilderEntries;
    }

    public Set<K> getKeys() {
        Object object = this.keysView;
        if (object == null) {
            this.keysView = object = new MapBuilderKeys(this);
            object = (Set)object;
        } else {
            object = (Set)object;
        }
        return object;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        Object object = this.valuesView;
        if (object == null) {
            this.valuesView = object = new MapBuilderValues(this);
            object = (Collection)object;
        } else {
            object = (Collection)object;
        }
        return object;
    }

    @Override
    public int hashCode() {
        EntriesItr<K, V> entriesItr = this.entriesIterator$kotlin_stdlib();
        int n = 0;
        while (entriesItr.hasNext()) {
            n += entriesItr.nextHashCode$kotlin_stdlib();
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.size() == 0;
        return bl;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr(this);
    }

    @Override
    public V put(K object, V v) {
        this.checkIsMutable$kotlin_stdlib();
        int n = this.addKey$kotlin_stdlib(object);
        object = this.allocateValuesArray();
        if (n < 0) {
            n = -n - 1;
            K k = object[n];
            object[n] = v;
            return (V)k;
        }
        object[n] = v;
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, (String)"from");
        this.checkIsMutable$kotlin_stdlib();
        this.putAllEntries((Collection)map.entrySet());
    }

    @Override
    public V remove(Object objectArray) {
        int n = this.removeKey$kotlin_stdlib(objectArray);
        if (n < 0) {
            return null;
        }
        objectArray = this.valuesArray;
        Intrinsics.checkNotNull(objectArray);
        V v = objectArray[n];
        ListBuilderKt.resetAt((Object[])objectArray, (int)n);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        this.checkIsMutable$kotlin_stdlib();
        int n = this.findKey(entry.getKey());
        if (n < 0) {
            return false;
        }
        V[] VArray = this.valuesArray;
        Intrinsics.checkNotNull(VArray);
        if (Intrinsics.areEqual(VArray[n], entry.getValue()) ^ true) {
            return false;
        }
        this.removeKeyAt(n);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        this.checkIsMutable$kotlin_stdlib();
        int n = this.findKey(k);
        if (n < 0) {
            return -1;
        }
        this.removeKeyAt(n);
        return n;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        this.checkIsMutable$kotlin_stdlib();
        int n = this.findValue(v);
        if (n < 0) {
            return false;
        }
        this.removeKeyAt(n);
        return true;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder(this.size() * 3 + 2);
        charSequence.append("{");
        EntriesItr<K, V> entriesItr = this.entriesIterator$kotlin_stdlib();
        int n = 0;
        while (true) {
            if (!entriesItr.hasNext()) {
                charSequence.append("}");
                charSequence = charSequence.toString();
                Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"sb.toString()");
                return charSequence;
            }
            if (n > 0) {
                charSequence.append(", ");
            }
            entriesItr.nextAppendString(charSequence);
            ++n;
        }
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr(this);
    }
}
