/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlin.reflect.KClasses
 *  okio.Path
 */
package okio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import okio.Path;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r\u00a2\u0006\u0002\u0010\u000fJu\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r\u00a2\u0006\u0002\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u00012\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0\u000e\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\"H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R!\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0012\u0004\u0012\u00020\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2={"Lokio/FileMetadata;", "", "isRegularFile", "", "isDirectory", "symlinkTarget", "Lokio/Path;", "size", "", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "extras", "", "Lkotlin/reflect/KClass;", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getCreatedAtMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "()Z", "getLastAccessedAtMillis", "getLastModifiedAtMillis", "getSize", "getSymlinkTarget", "()Lokio/Path;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "extra", "T", "type", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<KClass<?>, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }

    public FileMetadata(boolean bl, boolean bl2, Path path, Long l, Long l2, Long l3, Long l4, Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, (String)"extras");
        this.isRegularFile = bl;
        this.isDirectory = bl2;
        this.symlinkTarget = path;
        this.size = l;
        this.createdAtMillis = l2;
        this.lastModifiedAtMillis = l3;
        this.lastAccessedAtMillis = l4;
        this.extras = MapsKt.toMap(map);
    }

    public /* synthetic */ FileMetadata(boolean bl, boolean bl2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int n, DefaultConstructorMarker defaultConstructorMarker) {
        boolean bl3 = false;
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            bl2 = bl3;
        }
        defaultConstructorMarker = null;
        if ((n & 4) != 0) {
            path = null;
        }
        if ((n & 8) != 0) {
            l = null;
        }
        if ((n & 0x10) != 0) {
            l2 = null;
        }
        if ((n & 0x20) != 0) {
            l3 = null;
        }
        if ((n & 0x40) != 0) {
            l4 = defaultConstructorMarker;
        }
        if ((n & 0x80) != 0) {
            map = MapsKt.emptyMap();
        }
        this(bl, bl2, path, l, l2, l3, l4, map);
    }

    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean bl, boolean bl2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            bl = fileMetadata.isRegularFile;
        }
        if ((n & 2) != 0) {
            bl2 = fileMetadata.isDirectory;
        }
        if ((n & 4) != 0) {
            path = fileMetadata.symlinkTarget;
        }
        if ((n & 8) != 0) {
            l = fileMetadata.size;
        }
        if ((n & 0x10) != 0) {
            l2 = fileMetadata.createdAtMillis;
        }
        if ((n & 0x20) != 0) {
            l3 = fileMetadata.lastModifiedAtMillis;
        }
        if ((n & 0x40) != 0) {
            l4 = fileMetadata.lastAccessedAtMillis;
        }
        if ((n & 0x80) == 0) return fileMetadata.copy(bl, bl2, path, l, l2, l3, l4, map);
        map = fileMetadata.extras;
        return fileMetadata.copy(bl, bl2, path, l, l2, l3, l4, map);
    }

    public final FileMetadata copy(boolean bl, boolean bl2, Path path, Long l, Long l2, Long l3, Long l4, Map<KClass<?>, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, (String)"extras");
        return new FileMetadata(bl, bl2, path, l, l2, l3, l4, map);
    }

    public final <T> T extra(KClass<? extends T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, (String)"type");
        Object object = this.extras.get(kClass);
        if (object != null) return (T)KClasses.cast(kClass, (Object)object);
        return null;
    }

    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    public final Map<KClass<?>, Object> getExtras() {
        return this.extras;
    }

    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    public String toString() {
        Long l;
        List list = new ArrayList();
        if (this.isRegularFile) {
            ((Collection)list).add("isRegularFile");
        }
        if (this.isDirectory) {
            ((Collection)list).add("isDirectory");
        }
        if ((l = this.size) != null) {
            ((Collection)list).add(Intrinsics.stringPlus((String)"byteCount=", (Object)l));
        }
        if ((l = this.createdAtMillis) != null) {
            ((Collection)list).add(Intrinsics.stringPlus((String)"createdAt=", (Object)l));
        }
        if ((l = this.lastModifiedAtMillis) != null) {
            ((Collection)list).add(Intrinsics.stringPlus((String)"lastModifiedAt=", (Object)l));
        }
        if ((l = this.lastAccessedAtMillis) != null) {
            ((Collection)list).add(Intrinsics.stringPlus((String)"lastAccessedAt=", (Object)l));
        }
        if (!(this.extras.isEmpty() ^ true)) return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)"FileMetadata(", (CharSequence)")", (int)0, null, null, (int)56, null);
        ((Collection)list).add(Intrinsics.stringPlus((String)"extras=", this.extras));
        return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)", ", (CharSequence)"FileMetadata(", (CharSequence)")", (int)0, null, null, (int)56, null);
    }
}
