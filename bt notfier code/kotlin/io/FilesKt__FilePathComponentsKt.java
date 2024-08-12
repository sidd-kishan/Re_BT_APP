/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.FilePathComponents
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilePathComponents;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002\u00a2\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2={"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public static final File getRoot(File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$root");
        return new File(FilesKt.getRootName((File)file));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String string) {
        CharSequence charSequence = string;
        int n = StringsKt.indexOf$default((CharSequence)charSequence, (char)File.separatorChar, (int)0, (boolean)false, (int)4, null);
        if (n == 0) {
            if (string.length() <= 1) return 1;
            if (string.charAt(1) != File.separatorChar) return 1;
            n = StringsKt.indexOf$default((CharSequence)charSequence, (char)File.separatorChar, (int)2, (boolean)false, (int)4, null);
            if (n < 0) return 1;
            if ((n = StringsKt.indexOf$default((CharSequence)charSequence, (char)File.separatorChar, (int)(n + 1), (boolean)false, (int)4, null)) < 0) return string.length();
            return n + 1;
        }
        if (n > 0 && string.charAt(n - 1) == ':') {
            return n + 1;
        }
        if (n != -1) return 0;
        if (!StringsKt.endsWith$default((CharSequence)charSequence, (char)':', (boolean)false, (int)2, null)) return 0;
        return string.length();
    }

    public static final String getRootName(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$rootName");
        String string = ((File)object).getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"path");
        object = ((File)object).getPath();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"path");
        int n = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt((String)object);
        if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object = string.substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return object;
    }

    public static final boolean isRooted(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$isRooted");
        object = ((File)object).getPath();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"path");
        boolean bl = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt((String)object) > 0;
        return bl;
    }

    public static final File subPath(File file, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$subPath");
        return FilesKt.toComponents((File)file).subPath(n, n2);
    }

    public static final FilePathComponents toComponents(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$toComponents");
        object = ((File)object).getPath();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"path");
        int n = FilesKt__FilePathComponentsKt.getRootLength$FilesKt__FilePathComponentsKt((String)object);
        String string = ((String)object).substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        object = ((String)object).substring(n);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).substring(startIndex)");
        object = (CharSequence)object;
        n = object.length() == 0 ? 1 : 0;
        if (n != 0) {
            object = CollectionsKt.emptyList();
        } else {
            Object object2 = StringsKt.split$default((CharSequence)object, (char[])new char[]{File.separatorChar}, (boolean)false, (int)0, (int)6, null);
            object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object.add(new File((String)object2.next()));
            }
            object = (List)object;
        }
        return new FilePathComponents(new File(string), (List)object);
    }
}
