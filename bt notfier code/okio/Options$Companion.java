/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Options
 *  okio.Source
 */
package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Source;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007\u00a2\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2={"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Options.Companion {
    private Options.Companion() {
    }

    public /* synthetic */ Options.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void buildTrieRecursive(long l, Buffer object, int n, List<? extends ByteString> list, int n2, int n3, List<Integer> list2) {
        block21: {
            int n4;
            ByteString byteString;
            int n5;
            int n6;
            block27: {
                int n7;
                ByteString byteString2;
                block26: {
                    int n8;
                    block24: {
                        block25: {
                            block23: {
                                n6 = n;
                                n = n2 < n3 ? 1 : 0;
                                if (n == 0) {
                                    object = new IllegalArgumentException("Failed requirement.".toString());
                                    throw object;
                                }
                                if (n2 < n3) {
                                    n = n2;
                                    while (true) {
                                        n5 = n + 1;
                                        n = list.get(n).size() >= n6 ? 1 : 0;
                                        if (n == 0) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
                                        if (n5 >= n3) break;
                                        n = n5;
                                    }
                                }
                                byteString = list.get(n2);
                                byteString2 = list.get(n3 - 1);
                                if (n6 == byteString.size()) {
                                    n4 = ((Number)list2.get(n2)).intValue();
                                    n = n2 + 1;
                                    byteString = list.get(n);
                                } else {
                                    n = n2;
                                    n4 = -1;
                                }
                                if (byteString.getByte(n6) == byteString2.getByte(n6)) break block23;
                                n8 = n + 1;
                                n2 = 1;
                                n5 = 1;
                                if (n8 >= n3) break block24;
                                break block25;
                            }
                            n7 = Math.min(byteString.size(), byteString2.size());
                            if (n6 < n7) break block26;
                            n2 = 0;
                            break block27;
                        }
                        while (true) {
                            int n9 = n8 + 1;
                            n2 = n5;
                            if (list.get(n8 - 1).getByte(n6) != list.get(n8).getByte(n6)) {
                                n2 = n5 + 1;
                            }
                            if (n9 >= n3) break;
                            n8 = n9;
                            n5 = n2;
                        }
                    }
                    l = l + this.getIntCount((Buffer)object) + (long)2 + (long)(n2 * 2);
                    object.writeInt(n2);
                    object.writeInt(n4);
                    if (n < n3) {
                        n2 = n;
                        while (true) {
                            n5 = n2 + 1;
                            n4 = list.get(n2).getByte(n6);
                            if (n2 == n || n4 != list.get(n2 - 1).getByte(n6)) {
                                object.writeInt(n4 & 0xFF);
                            }
                            if (n5 >= n3) break;
                            n2 = n5;
                        }
                    }
                    byteString = new Buffer();
                    n2 = n;
                    while (true) {
                        block22: {
                            block29: {
                                block30: {
                                    block28: {
                                        if (n2 >= n3) break block28;
                                        n8 = list.get(n2).getByte(n6);
                                        n5 = n2 + 1;
                                        if (n5 >= n3) break block29;
                                        break block30;
                                    }
                                    object.writeAll((Source)byteString);
                                    break block21;
                                }
                                n = n5;
                                while (true) {
                                    n4 = n + 1;
                                    if (n8 == list.get(n).getByte(n6)) {
                                        if (n4 >= n3) break;
                                        n = n4;
                                        continue;
                                    }
                                    break block22;
                                    break;
                                }
                            }
                            n = n3;
                        }
                        if (n5 == n && n6 + 1 == list.get(n2).size()) {
                            object.writeInt(((Number)list2.get(n2)).intValue());
                        } else {
                            object.writeInt((int)(l + this.getIntCount((Buffer)byteString)) * -1);
                            this.buildTrieRecursive(l, (Buffer)byteString, n6 + 1, list, n2, n, list2);
                        }
                        n2 = n;
                    }
                }
                int n10 = n6;
                n2 = 0;
                while (true) {
                    int n11 = n10 + 1;
                    n5 = n2++;
                    if (byteString.getByte(n10) != byteString2.getByte(n10)) break;
                    if (n11 >= n7) {
                        n5 = n2;
                        break;
                    }
                    n10 = n11;
                }
                n2 = n5;
            }
            l = l + this.getIntCount((Buffer)object) + (long)2 + (long)n2 + 1L;
            object.writeInt(-n2);
            object.writeInt(n4);
            n5 = n6 + n2;
            if (n6 < n5) {
                while (true) {
                    n2 = n6 + 1;
                    object.writeInt(byteString.getByte(n6) & 0xFF);
                    if (n2 >= n5) break;
                    n6 = n2;
                }
            }
            if (n + 1 == n3) {
                n2 = n5 == list.get(n).size() ? 1 : 0;
                if (n2 == 0) throw (Throwable)new IllegalStateException("Check failed.".toString());
                object.writeInt(((Number)list2.get(n)).intValue());
            } else {
                byteString = new Buffer();
                object.writeInt((int)(this.getIntCount((Buffer)byteString) + l) * -1);
                this.buildTrieRecursive(l, (Buffer)byteString, n5, list, n, n3, list2);
                object.writeAll((Source)byteString);
            }
        }
    }

    static /* synthetic */ void buildTrieRecursive$default(Options.Companion companion, long l, Buffer buffer, int n, List list, int n2, int n3, List list2, int n4, Object object) {
        if ((n4 & 1) != 0) {
            l = 0L;
        }
        if ((n4 & 4) != 0) {
            n = 0;
        }
        if ((n4 & 0x10) != 0) {
            n2 = 0;
        }
        if ((n4 & 0x20) != 0) {
            n3 = list.size();
        }
        companion.buildTrieRecursive(l, buffer, n, list, n2, n3, list2);
    }

    private final long getIntCount(Buffer buffer) {
        return buffer.size() / (long)4;
    }

    @JvmStatic
    public final Options of(ByteString ... object) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"byteStrings");
        int n = ((ByteString[])object).length;
        int n2 = 0;
        n = n == 0 ? 1 : 0;
        if (n != 0) {
            return new Options(new ByteString[0], new int[]{0, -1}, null);
        }
        Object object3 = ArraysKt.toMutableList((Object[])object);
        CollectionsKt.sort((List)object3);
        Collection collection = new ArrayList(((ByteString[])object).length);
        int n3 = ((ByteString[])object).length;
        for (n = 0; n < n3; ++n) {
            object2 = object[n];
            collection.add(-1);
        }
        object2 = ((Collection)((List)collection)).toArray(new Integer[0]);
        if (object2 == null) {
            object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            throw object;
        }
        object2 = CollectionsKt.mutableListOf((Object[])Arrays.copyOf(object2, ((Integer[])object2).length));
        int n4 = ((ByteString[])object).length;
        n = 0;
        for (n3 = 0; n3 < n4; ++n3, ++n) {
            object2.set(CollectionsKt.binarySearch$default((List)object3, (Comparable)((Comparable)object[n3]), (int)0, (int)0, (int)6, null), n);
        }
        n = ((ByteString)object3.get(0)).size() > 0 ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException("the empty byte string is not a supported option".toString());
        n = 0;
        while (n < object3.size()) {
            ByteString byteString;
            collection = (ByteString)object3.get(n);
            n4 = n3 = n + 1;
            while (n4 < object3.size() && (byteString = (ByteString)object3.get(n4)).startsWith((ByteString)collection)) {
                boolean bl = byteString.size() != collection.size();
                if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"duplicate option: ", (Object)byteString).toString());
                if (((Number)object2.get(n4)).intValue() > ((Number)object2.get(n)).intValue()) {
                    object3.remove(n4);
                    object2.remove(n4);
                    continue;
                }
                ++n4;
            }
            n = n3;
        }
        collection = new Buffer();
        Options.Companion.buildTrieRecursive$default(this, 0L, (Buffer)collection, 0, (List)object3, 0, 0, (List)object2, 53, null);
        object3 = new int[(int)this.getIntCount((Buffer)collection)];
        n = n2;
        while (true) {
            if (collection.exhausted()) {
                object = Arrays.copyOf(object, ((ByteString[])object).length);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, size)");
                return new Options(object, (int[])object3, null);
            }
            object3[n] = collection.readInt();
            ++n;
        }
    }
}
