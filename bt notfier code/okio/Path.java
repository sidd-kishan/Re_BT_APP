/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Path$Companion
 *  okio.internal._PathKt
 */
package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import okio.internal._PathKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rH\u0087\u0002\u00a2\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0087\u0002\u00a2\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002\u00a2\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c\u00a8\u0006/"}, d2={"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "root", "getRoot", "segments", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", "other", "div", "child", "resolve", "equals", "", "hashCode", "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class Path
implements Comparable<Path> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    static {
        String string = File.separator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"separator");
        DIRECTORY_SEPARATOR = string;
    }

    public Path(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        this.bytes = byteString;
    }

    @JvmStatic
    public static final Path get(File file) {
        return Companion.get(file);
    }

    @JvmStatic
    public static final Path get(File file, boolean bl) {
        return Companion.get(file, bl);
    }

    @JvmStatic
    public static final Path get(String string) {
        return Companion.get(string);
    }

    @JvmStatic
    public static final Path get(String string, boolean bl) {
        return Companion.get(string, bl);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path, boolean bl) {
        return Companion.get(path, bl);
    }

    public static /* synthetic */ Path resolve$default(Path path, String string, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return path.resolve(string, bl);
        bl = false;
        return path.resolve(string, bl);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return path.resolve(byteString, bl);
        bl = false;
        return path.resolve(byteString, bl);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean bl, int n, Object object) {
        if ((n & 2) == 0) return path.resolve(path2, bl);
        bl = false;
        return path.resolve(path2, bl);
    }

    @Override
    public int compareTo(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"other");
        return this.getBytes$okio().compareTo(path.getBytes$okio());
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof Path && Intrinsics.areEqual((Object)((Path)object).getBytes$okio(), (Object)this.getBytes$okio());
        return bl;
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int n = _PathKt.access$rootLength((Path)this);
        Path path = n == -1 ? null : new Path(this.getBytes$okio().substring(0, n));
        return path;
    }

    public final List<String> getSegments() {
        int n;
        Collection<String> collection;
        block11: {
            int n2;
            collection = new ArrayList();
            n = _PathKt.access$rootLength((Path)this);
            if (n == -1) {
                n2 = 0;
            } else {
                n2 = n;
                if (n < this.getBytes$okio().size()) {
                    n2 = n;
                    if (this.getBytes$okio().getByte(n) == (byte)92) {
                        n2 = n + 1;
                    }
                }
            }
            int n3 = this.getBytes$okio().size();
            n = n2;
            if (n2 >= n3) break block11;
            int n4 = n2;
            int n5 = n2;
            while (true) {
                block13: {
                    block12: {
                        n = n5 + 1;
                        if (this.getBytes$okio().getByte(n5) == (byte)47) break block12;
                        n2 = n4;
                        if (this.getBytes$okio().getByte(n5) != (byte)92) break block13;
                    }
                    ((Collection)collection).add(this.getBytes$okio().substring(n4, n5));
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
        if (n < this.getBytes$okio().size()) {
            ((Collection)collection).add(this.getBytes$okio().substring(n, this.getBytes$okio().size()));
        }
        Object object = collection;
        collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(((ByteString)object.next()).utf8());
        }
        return collection;
    }

    public final List<ByteString> getSegmentsBytes() {
        int n;
        List list;
        block9: {
            int n2;
            list = new ArrayList();
            n = _PathKt.access$rootLength((Path)this);
            if (n == -1) {
                n2 = 0;
            } else {
                n2 = n;
                if (n < this.getBytes$okio().size()) {
                    n2 = n;
                    if (this.getBytes$okio().getByte(n) == (byte)92) {
                        n2 = n + 1;
                    }
                }
            }
            int n3 = this.getBytes$okio().size();
            n = n2;
            if (n2 >= n3) break block9;
            n = n2;
            int n4 = n2;
            while (true) {
                int n5;
                block11: {
                    block10: {
                        n5 = n4 + 1;
                        if (this.getBytes$okio().getByte(n4) == (byte)47) break block10;
                        n2 = n;
                        if (this.getBytes$okio().getByte(n4) != (byte)92) break block11;
                    }
                    ((Collection)list).add(this.getBytes$okio().substring(n, n4));
                    n2 = n5;
                }
                if (n5 >= n3) {
                    n = n2;
                    break;
                }
                n4 = n5;
                n = n2;
            }
        }
        if (n >= this.getBytes$okio().size()) return list;
        ((Collection)list).add(this.getBytes$okio().substring(n, this.getBytes$okio().size()));
        return list;
    }

    public int hashCode() {
        return this.getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        boolean bl = _PathKt.access$rootLength((Path)this) != -1;
        return bl;
    }

    public final boolean isRelative() {
        boolean bl = _PathKt.access$rootLength((Path)this) == -1;
        return bl;
    }

    public final boolean isRoot() {
        boolean bl = _PathKt.access$rootLength((Path)this) == this.getBytes$okio().size();
        return bl;
    }

    public final String name() {
        return this.nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int n = _PathKt.access$getIndexOfLastSlash((Path)this);
        ByteString byteString = n != -1 ? ByteString.substring$default((ByteString)this.getBytes$okio(), (int)(n + 1), (int)0, (int)2, null) : (this.volumeLetter() != null && this.getBytes$okio().size() == 2 ? ByteString.EMPTY : this.getBytes$okio());
        return byteString;
    }

    public final Path normalized() {
        return Companion.get(this.toString(), true);
    }

    public final Path parent() {
        int n;
        Path path;
        boolean bl = Intrinsics.areEqual((Object)this.getBytes$okio(), (Object)_PathKt.access$getDOT$p());
        Path path2 = path = null;
        if (bl) return path2;
        path2 = path;
        if (Intrinsics.areEqual((Object)this.getBytes$okio(), (Object)_PathKt.access$getSLASH$p())) return path2;
        path2 = path;
        if (Intrinsics.areEqual((Object)this.getBytes$okio(), (Object)_PathKt.access$getBACKSLASH$p())) return path2;
        path2 = _PathKt.access$lastSegmentIsDotDot((Path)this) ? path : ((n = _PathKt.access$getIndexOfLastSlash((Path)this)) == 2 && this.volumeLetter() != null ? (this.getBytes$okio().size() == 3 ? path : new Path(ByteString.substring$default((ByteString)this.getBytes$okio(), (int)0, (int)3, (int)1, null))) : (n == 1 && this.getBytes$okio().startsWith(_PathKt.access$getBACKSLASH$p()) ? path : (n == -1 && this.volumeLetter() != null ? (this.getBytes$okio().size() == 2 ? path : new Path(ByteString.substring$default((ByteString)this.getBytes$okio(), (int)0, (int)2, (int)1, null))) : (n == -1 ? new Path(_PathKt.access$getDOT$p()) : (n == 0 ? new Path(ByteString.substring$default((ByteString)this.getBytes$okio(), (int)0, (int)1, (int)1, null)) : new Path(ByteString.substring$default((ByteString)this.getBytes$okio(), (int)0, (int)n, (int)1, null)))))));
        return path2;
    }

    public final Path relativeTo(Path object) {
        int n;
        Intrinsics.checkNotNullParameter((Object)object, (String)"other");
        if (!Intrinsics.areEqual((Object)this.getRoot(), (Object)((Path)object).getRoot())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Paths of different roots cannot be relative to each other: ");
            stringBuilder.append(this);
            stringBuilder.append(" and ");
            stringBuilder.append(object);
            object = new IllegalArgumentException(stringBuilder.toString().toString());
            throw object;
        }
        List<ByteString> list = this.getSegmentsBytes();
        List<ByteString> list2 = ((Path)object).getSegmentsBytes();
        int n2 = Math.min(list.size(), list2.size());
        for (n = 0; n < n2 && Intrinsics.areEqual((Object)list.get(n), (Object)list2.get(n)); ++n) {
        }
        if (n == n2 && this.getBytes$okio().size() == ((Path)object).getBytes$okio().size()) {
            object = okio.Path$Companion.get$default((Companion)Companion, (String)".", (boolean)false, (int)1, null);
        } else {
            int n3;
            int n4;
            n2 = list2.subList(n, list2.size()).indexOf(_PathKt.access$getDOT_DOT$p()) == -1 ? 1 : 0;
            if (n2 == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Impossible relative path to resolve: ");
                stringBuilder.append(this);
                stringBuilder.append(" and ");
                stringBuilder.append(object);
                throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
            }
            Buffer buffer = new Buffer();
            ByteString byteString = _PathKt.access$getSlash((Path)object);
            object = byteString;
            if (byteString == null) {
                byteString = _PathKt.access$getSlash((Path)this);
                object = byteString;
                if (byteString == null) {
                    object = _PathKt.access$toSlash((String)DIRECTORY_SEPARATOR);
                }
            }
            if (n < (n4 = list2.size())) {
                n2 = n;
                do {
                    n3 = n2 + 1;
                    buffer.write(_PathKt.access$getDOT_DOT$p());
                    buffer.write((ByteString)object);
                    n2 = n3;
                } while (n3 < n4);
            }
            if (n < (n3 = list.size())) {
                while (true) {
                    n2 = n + 1;
                    buffer.write(list.get(n));
                    buffer.write((ByteString)object);
                    if (n2 >= n3) break;
                    n = n2;
                }
            }
            object = _PathKt.toPath((Buffer)buffer, (boolean)false);
        }
        return object;
    }

    public final Path resolve(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"child");
        return _PathKt.commonResolve((Path)this, (Path)_PathKt.toPath((Buffer)new Buffer().writeUtf8(string), (boolean)false), (boolean)false);
    }

    public final Path resolve(String string, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"child");
        return _PathKt.commonResolve((Path)this, (Path)_PathKt.toPath((Buffer)new Buffer().writeUtf8(string), (boolean)false), (boolean)bl);
    }

    public final Path resolve(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"child");
        return _PathKt.commonResolve((Path)this, (Path)_PathKt.toPath((Buffer)new Buffer().write(byteString), (boolean)false), (boolean)false);
    }

    public final Path resolve(ByteString byteString, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"child");
        return _PathKt.commonResolve((Path)this, (Path)_PathKt.toPath((Buffer)new Buffer().write(byteString), (boolean)false), (boolean)bl);
    }

    public final Path resolve(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"child");
        return _PathKt.commonResolve((Path)this, (Path)path, (boolean)false);
    }

    public final Path resolve(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"child");
        return _PathKt.commonResolve((Path)this, (Path)path, (boolean)bl);
    }

    public final File toFile() {
        return new File(this.toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(this.toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(toString())");
        return path;
    }

    public String toString() {
        return this.getBytes$okio().utf8();
    }

    public final Character volumeLetter() {
        ByteString byteString = this.getBytes$okio();
        ByteString byteString2 = _PathKt.access$getSLASH$p();
        Character c = null;
        boolean bl = false;
        if (ByteString.indexOf$default((ByteString)byteString, (ByteString)byteString2, (int)0, (int)2, null) != -1 || this.getBytes$okio().size() < 2 || this.getBytes$okio().getByte(1) != (byte)58) return c;
        char c2 = (char)this.getBytes$okio().getByte(0);
        boolean bl2 = 'a' <= c2 && c2 <= 'z';
        if (!bl2) {
            bl2 = bl;
            if ('A' <= c2) {
                bl2 = bl;
                if (c2 <= 'Z') {
                    bl2 = true;
                }
            }
            if (!bl2) return c;
        }
        c = Character.valueOf(c2);
        return c;
    }
}
