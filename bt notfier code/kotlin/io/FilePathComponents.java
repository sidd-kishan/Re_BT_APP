/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J#\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0013H\u00d6\u0001J\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013J\t\u0010\u001f\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2={"Lkotlin/io/FilePathComponents;", "", "root", "Ljava/io/File;", "segments", "", "(Ljava/io/File;Ljava/util/List;)V", "isRooted", "", "()Z", "getRoot", "()Ljava/io/File;", "rootName", "", "getRootName", "()Ljava/lang/String;", "getSegments", "()Ljava/util/List;", "size", "", "getSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "subPath", "beginIndex", "endIndex", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class FilePathComponents {
    private final File root;
    private final List<File> segments;

    public FilePathComponents(File file, List<? extends File> list) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"root");
        Intrinsics.checkNotNullParameter(list, (String)"segments");
        this.root = file;
        this.segments = list;
    }

    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List list, int n, Object object) {
        if ((n & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((n & 2) == 0) return filePathComponents.copy(file, list);
        list = filePathComponents.segments;
        return filePathComponents.copy(file, list);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy(File file, List<? extends File> list) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"root");
        Intrinsics.checkNotNullParameter(list, (String)"segments");
        return new FilePathComponents(file, list);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof FilePathComponents)) return false;
        object = (FilePathComponents)object;
        if (!Intrinsics.areEqual((Object)this.root, (Object)((FilePathComponents)object).root)) return false;
        if (!Intrinsics.areEqual(this.segments, ((FilePathComponents)object).segments)) return false;
        return true;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String string = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"root.path");
        return string;
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        Object object = this.root;
        int n = 0;
        int n2 = object != null ? object.hashCode() : 0;
        object = this.segments;
        if (object == null) return n2 * 31 + n;
        n = object.hashCode();
        return n2 * 31 + n;
    }

    public final boolean isRooted() {
        String string = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"root.path");
        boolean bl = ((CharSequence)string).length() > 0;
        return bl;
    }

    public final File subPath(int n, int n2) {
        if (n < 0) throw (Throwable)new IllegalArgumentException();
        if (n > n2) throw (Throwable)new IllegalArgumentException();
        if (n2 > this.getSize()) throw (Throwable)new IllegalArgumentException();
        Iterable iterable = this.segments.subList(n, n2);
        String string = File.separator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"File.separator");
        return new File(CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)string, null, null, (int)0, null, null, (int)62, null));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FilePathComponents(root=");
        stringBuilder.append(this.root);
        stringBuilder.append(", segments=");
        stringBuilder.append(this.segments);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
