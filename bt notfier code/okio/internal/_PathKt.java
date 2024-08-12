/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Path
 *  okio.Path$Companion
 */
package okio.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\u0080\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\u0080\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\u0080\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\u0080\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\u0080\b\u001a\u0012\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\u0080\b\u00a2\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00066"}, d2={"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _PathKt {
    private static final ByteString ANY_SLASH;
    private static final ByteString BACKSLASH;
    private static final ByteString DOT;
    private static final ByteString DOT_DOT;
    private static final ByteString SLASH;

    static {
        SLASH = ByteString.Companion.encodeUtf8("/");
        BACKSLASH = ByteString.Companion.encodeUtf8("\\");
        ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
        DOT = ByteString.Companion.encodeUtf8(".");
        DOT_DOT = ByteString.Companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"other");
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(Path path, Object object) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        boolean bl = object instanceof Path && Intrinsics.areEqual((Object)((Path)object).getBytes$okio(), (Object)path.getBytes$okio());
        return bl;
    }

    public static final int commonHashCode(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        boolean bl = _PathKt.rootLength(path) != -1;
        return bl;
    }

    public static final boolean commonIsRelative(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        boolean bl = _PathKt.rootLength(path) == -1;
        return bl;
    }

    public static final boolean commonIsRoot(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        boolean bl = _PathKt.rootLength(path) == path.getBytes$okio().size();
        return bl;
    }

    public static final String commonName(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        return path.nameBytes().utf8();
    }

    public static final ByteString commonNameBytes(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        int n = _PathKt.getIndexOfLastSlash(path);
        path = n != -1 ? ByteString.substring$default((ByteString)path.getBytes$okio(), (int)(n + 1), (int)0, (int)2, null) : (path.volumeLetter() != null && path.getBytes$okio().size() == 2 ? ByteString.EMPTY : path.getBytes$okio());
        return path;
    }

    public static final Path commonNormalized(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        return Path.Companion.get(path.toString(), true);
    }

    public static final Path commonParent(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        if (Intrinsics.areEqual((Object)path.getBytes$okio(), (Object)_PathKt.DOT)) return null;
        if (Intrinsics.areEqual((Object)path.getBytes$okio(), (Object)_PathKt.SLASH)) return null;
        if (Intrinsics.areEqual((Object)path.getBytes$okio(), (Object)_PathKt.BACKSLASH)) return null;
        if (_PathKt.lastSegmentIsDotDot(path)) {
            return null;
        }
        int n = _PathKt.getIndexOfLastSlash(path);
        if (n == 2 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() != 3) return new Path(ByteString.substring$default((ByteString)path.getBytes$okio(), (int)0, (int)3, (int)1, null));
            return null;
        }
        if (n == 1 && path.getBytes$okio().startsWith(_PathKt.BACKSLASH)) {
            return null;
        }
        if (n == -1 && path.volumeLetter() != null) {
            if (path.getBytes$okio().size() != 2) return new Path(ByteString.substring$default((ByteString)path.getBytes$okio(), (int)0, (int)2, (int)1, null));
            return null;
        }
        if (n == -1) {
            return new Path(_PathKt.DOT);
        }
        if (n != 0) return new Path(ByteString.substring$default((ByteString)path.getBytes$okio(), (int)0, (int)n, (int)1, null));
        return new Path(ByteString.substring$default((ByteString)path.getBytes$okio(), (int)0, (int)1, (int)1, null));
    }

    public static final Path commonRelativeTo(Path object, Path path) {
        int n;
        int n2;
        int n3;
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"other");
        if (!Intrinsics.areEqual((Object)object.getRoot(), (Object)path.getRoot())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Paths of different roots cannot be relative to each other: ");
            stringBuilder.append(object);
            stringBuilder.append(" and ");
            stringBuilder.append(path);
            object = new IllegalArgumentException(stringBuilder.toString().toString());
            throw object;
        }
        List list = object.getSegmentsBytes();
        List list2 = path.getSegmentsBytes();
        int n4 = Math.min(list.size(), list2.size());
        for (n3 = 0; n3 < n4 && Intrinsics.areEqual(list.get(n3), list2.get(n3)); ++n3) {
        }
        if (n3 == n4 && object.getBytes$okio().size() == path.getBytes$okio().size()) {
            return Path.Companion.get$default((Path.Companion)Path.Companion, (String)".", (boolean)false, (int)1, null);
        }
        n4 = list2.subList(n3, list2.size()).indexOf(_PathKt.DOT_DOT) == -1 ? 1 : 0;
        if (n4 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Impossible relative path to resolve: ");
            stringBuilder.append(object);
            stringBuilder.append(" and ");
            stringBuilder.append(path);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        Buffer buffer = new Buffer();
        ByteString byteString = _PathKt.getSlash(path);
        path = byteString;
        if (byteString == null) {
            path = object = _PathKt.getSlash(object);
            if (object == null) {
                path = _PathKt.toSlash(Path.DIRECTORY_SEPARATOR);
            }
        }
        if (n3 < (n2 = list2.size())) {
            n4 = n3;
            do {
                n = n4 + 1;
                buffer.write(_PathKt.DOT_DOT);
                buffer.write((ByteString)path);
                n4 = n;
            } while (n < n2);
        }
        if (n3 >= (n = list.size())) return _PathKt.toPath(buffer, false);
        while (true) {
            n4 = n3 + 1;
            buffer.write((ByteString)list.get(n3));
            buffer.write((ByteString)path);
            if (n4 >= n) {
                return _PathKt.toPath(buffer, false);
            }
            n3 = n4;
        }
    }

    public static final Path commonResolve(Path path, String string, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"child");
        return _PathKt.commonResolve(path, _PathKt.toPath(new Buffer().writeUtf8(string), false), bl);
    }

    public static final Path commonResolve(Path path, Buffer buffer, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"child");
        return _PathKt.commonResolve(path, _PathKt.toPath(buffer, false), bl);
    }

    public static final Path commonResolve(Path path, ByteString byteString, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"child");
        return _PathKt.commonResolve(path, _PathKt.toPath(new Buffer().write(byteString), false), bl);
    }

    public static final Path commonResolve(Path path, Path path2, boolean bl) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"child");
        if (path2.isAbsolute()) return path2;
        if (path2.volumeLetter() != null) {
            return path2;
        }
        ByteString byteString2 = byteString = _PathKt.getSlash(path);
        if (byteString == null) {
            byteString2 = byteString = _PathKt.getSlash(path2);
            if (byteString == null) {
                byteString2 = _PathKt.toSlash(Path.DIRECTORY_SEPARATOR);
            }
        }
        byteString = new Buffer();
        byteString.write(path.getBytes$okio());
        if (byteString.size() > 0L) {
            byteString.write(byteString2);
        }
        byteString.write(path2.getBytes$okio());
        return _PathKt.toPath((Buffer)byteString, bl);
    }

    public static final Path commonRoot(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n = _PathKt.rootLength(object);
        object = n == -1 ? null : new Path(object.getBytes$okio().substring(0, n));
        return object;
    }

    public static final List<String> commonSegments(Path object) {
        int n;
        Object object2;
        block11: {
            int n2;
            Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
            object2 = new ArrayList();
            n = _PathKt.rootLength((Path)object);
            if (n == -1) {
                n2 = 0;
            } else {
                n2 = n;
                if (n < object.getBytes$okio().size()) {
                    n2 = n;
                    if (object.getBytes$okio().getByte(n) == (byte)92) {
                        n2 = n + 1;
                    }
                }
            }
            int n3 = object.getBytes$okio().size();
            n = n2;
            if (n2 >= n3) break block11;
            int n4 = n2;
            int n5 = n2;
            while (true) {
                block13: {
                    block12: {
                        n = n5 + 1;
                        if (object.getBytes$okio().getByte(n5) == (byte)47) break block12;
                        n2 = n4;
                        if (object.getBytes$okio().getByte(n5) != (byte)92) break block13;
                    }
                    ((Collection)object2).add(object.getBytes$okio().substring(n4, n5));
                    n2 = n;
                }
                if (n >= n3) {
                    n = n2;
                    break;
                }
                n5 = n;
                n4 = n2;
            }
        }
        if (n < object.getBytes$okio().size()) {
            ((Collection)object2).add(object.getBytes$okio().substring(n, object.getBytes$okio().size()));
        }
        object2 = (Iterable)object2;
        object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(((ByteString)object2.next()).utf8());
        }
        return (List)object;
    }

    public static final List<ByteString> commonSegmentsBytes(Path path) {
        int n;
        List list;
        block9: {
            int n2;
            Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
            list = new ArrayList();
            n = _PathKt.rootLength(path);
            if (n == -1) {
                n2 = 0;
            } else {
                n2 = n;
                if (n < path.getBytes$okio().size()) {
                    n2 = n;
                    if (path.getBytes$okio().getByte(n) == (byte)92) {
                        n2 = n + 1;
                    }
                }
            }
            int n3 = path.getBytes$okio().size();
            n = n2;
            if (n2 >= n3) break block9;
            int n4 = n2;
            int n5 = n2;
            while (true) {
                block11: {
                    block10: {
                        n = n5 + 1;
                        if (path.getBytes$okio().getByte(n5) == (byte)47) break block10;
                        n2 = n4;
                        if (path.getBytes$okio().getByte(n5) != (byte)92) break block11;
                    }
                    ((Collection)list).add(path.getBytes$okio().substring(n4, n5));
                    n2 = n;
                }
                if (n >= n3) {
                    n = n2;
                    break;
                }
                n5 = n;
                n4 = n2;
            }
        }
        if (n >= path.getBytes$okio().size()) return list;
        ((Collection)list).add(path.getBytes$okio().substring(n, path.getBytes$okio().size()));
        return list;
    }

    public static final Path commonToPath(String string, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return _PathKt.toPath(new Buffer().writeUtf8(string), bl);
    }

    public static final String commonToString(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        return path.getBytes$okio().utf8();
    }

    public static final Character commonVolumeLetter(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        ByteString byteString = path.getBytes$okio();
        ByteString byteString2 = _PathKt.SLASH;
        boolean bl = false;
        if (ByteString.indexOf$default((ByteString)byteString, (ByteString)byteString2, (int)0, (int)2, null) != -1) {
            return null;
        }
        if (path.getBytes$okio().size() < 2) {
            return null;
        }
        if (path.getBytes$okio().getByte(1) != (byte)58) {
            return null;
        }
        char c = (char)path.getBytes$okio().getByte(0);
        boolean bl2 = 'a' <= c && c <= 'z';
        if (bl2) return Character.valueOf(c);
        bl2 = bl;
        if ('A' <= c) {
            bl2 = bl;
            if (c <= 'Z') {
                bl2 = true;
            }
        }
        if (bl2) return Character.valueOf(c);
        return null;
    }

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    private static final int getIndexOfLastSlash(Path path) {
        int n = ByteString.lastIndexOf$default((ByteString)path.getBytes$okio(), (ByteString)SLASH, (int)0, (int)2, null);
        if (n == -1) return ByteString.lastIndexOf$default((ByteString)path.getBytes$okio(), (ByteString)BACKSLASH, (int)0, (int)2, null);
        return n;
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    private static final ByteString getSlash(Path path) {
        ByteString byteString = path.getBytes$okio();
        ByteString byteString2 = SLASH;
        ByteString byteString3 = null;
        if (ByteString.indexOf$default((ByteString)byteString, (ByteString)byteString2, (int)0, (int)2, null) != -1) {
            byteString3 = SLASH;
        } else {
            if (ByteString.indexOf$default((ByteString)path.getBytes$okio(), (ByteString)BACKSLASH, (int)0, (int)2, null) == -1) return byteString3;
            byteString3 = BACKSLASH;
        }
        return byteString3;
    }

    private static final boolean lastSegmentIsDotDot(Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT)) return false;
        if (path.getBytes$okio().size() == 2) {
            return true;
        }
        if (path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1)) {
            return true;
        }
        if (!path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1)) return false;
        return true;
    }

    private static final int rootLength(Path path) {
        int n;
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        ByteString byteString = path.getBytes$okio();
        int n2 = 0;
        if (byteString.getByte(0) == (byte)47) {
            return 1;
        }
        char c = path.getBytes$okio().getByte(0);
        if (c == (n = (int)92)) {
            if (path.getBytes$okio().size() <= 2) return 1;
            if (path.getBytes$okio().getByte(1) != n) return 1;
            n = n2 = path.getBytes$okio().indexOf(BACKSLASH, 2);
            if (n2 != -1) return n;
            n = path.getBytes$okio().size();
            return n;
        }
        if (path.getBytes$okio().size() <= 2) return -1;
        if (path.getBytes$okio().getByte(1) != (byte)58) return -1;
        if (path.getBytes$okio().getByte(2) != n) return -1;
        c = (char)path.getBytes$okio().getByte(0);
        n = 'a' <= c && c <= 'z' ? 1 : 0;
        if (n != 0) return 3;
        n = n2;
        if ('A' <= c) {
            n = n2;
            if (c <= 'Z') {
                n = 1;
            }
        }
        if (n != 0) return 3;
        return -1;
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        boolean bl = Intrinsics.areEqual((Object)byteString, (Object)BACKSLASH);
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        if (buffer.size() < 2L) {
            return false;
        }
        if (buffer.getByte(1L) != (byte)58) {
            return false;
        }
        char c = (char)buffer.getByte(0L);
        boolean bl3 = 'a' <= c && c <= 'z';
        if (!bl3) {
            bl3 = 'A' <= c && c <= 'Z';
            if (!bl3) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public static final Path toPath(Buffer buffer, boolean bl) {
        List list;
        ByteString byteString;
        long l;
        int n;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        Buffer buffer2 = new Buffer();
        int n2 = 0;
        ByteString byteString2 = null;
        int n3 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH) && !buffer.rangeEquals(0L, BACKSLASH)) {
                n = n3 >= 2 && Intrinsics.areEqual((Object)byteString2, (Object)BACKSLASH) ? 1 : 0;
                if (n != 0) {
                    Intrinsics.checkNotNull((Object)byteString2);
                    buffer2.write(byteString2);
                    buffer2.write(byteString2);
                } else if (n3 > 0) {
                    Intrinsics.checkNotNull((Object)byteString2);
                    buffer2.write(byteString2);
                } else {
                    l = buffer.indexOfElement(ANY_SLASH);
                    byteString = byteString2;
                    if (byteString2 == null) {
                        byteString = l == -1L ? _PathKt.toSlash(Path.DIRECTORY_SEPARATOR) : _PathKt.toSlash(buffer.getByte(l));
                    }
                    byteString2 = byteString;
                    if (_PathKt.startsWithVolumeLetterAndColon(buffer, byteString)) {
                        if (l == 2L) {
                            buffer2.write(buffer, 3L);
                            byteString2 = byteString;
                        } else {
                            buffer2.write(buffer, 2L);
                            byteString2 = byteString;
                        }
                    }
                }
                n3 = buffer2.size() > 0L ? 1 : 0;
                list = new ArrayList();
                break;
            }
            byte by = buffer.readByte();
            byteString = byteString2;
            if (byteString2 == null) {
                byteString = _PathKt.toSlash(by);
            }
            ++n3;
            byteString2 = byteString;
        }
        while (!buffer.exhausted()) {
            l = buffer.indexOfElement(ANY_SLASH);
            if (l == -1L) {
                byteString = buffer.readByteString();
            } else {
                byteString = buffer.readByteString(l);
                buffer.readByte();
            }
            if (Intrinsics.areEqual((Object)byteString, (Object)DOT_DOT)) {
                if (n3 != 0 && list.isEmpty()) continue;
                if (bl && (n3 != 0 || !list.isEmpty() && !Intrinsics.areEqual((Object)CollectionsKt.last((List)list), (Object)DOT_DOT))) {
                    if (n != 0 && list.size() == 1) continue;
                    CollectionsKt.removeLastOrNull((List)list);
                    continue;
                }
                list.add(byteString);
                continue;
            }
            if (Intrinsics.areEqual((Object)byteString, (Object)DOT) || Intrinsics.areEqual((Object)byteString, (Object)ByteString.EMPTY)) continue;
            list.add(byteString);
        }
        int n4 = list.size();
        if (n4 > 0) {
            n = n2;
            while (true) {
                n3 = n + 1;
                if (n > 0) {
                    buffer2.write(byteString2);
                }
                buffer2.write((ByteString)list.get(n));
                if (n3 >= n4) break;
                n = n3;
            }
        }
        if (buffer2.size() != 0L) return new Path(buffer2.readByteString());
        buffer2.write(DOT);
        return new Path(buffer2.readByteString());
    }

    private static final ByteString toSlash(byte by) {
        ByteString byteString;
        if (by == 47) {
            byteString = SLASH;
        } else {
            if (by != 92) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"not a directory separator: ", (Object)by));
            byteString = BACKSLASH;
        }
        return byteString;
    }

    private static final ByteString toSlash(String string) {
        if (Intrinsics.areEqual((Object)string, (Object)"/")) {
            string = SLASH;
        } else {
            if (!Intrinsics.areEqual((Object)string, (Object)"\\")) throw new IllegalArgumentException(Intrinsics.stringPlus((String)"not a directory separator: ", (Object)string));
            string = BACKSLASH;
        }
        return string;
    }
}
