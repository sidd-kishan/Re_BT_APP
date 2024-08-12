/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.FileAlreadyExistsException
 *  kotlin.io.FilePathComponents
 *  kotlin.io.FilesKt
 *  kotlin.io.FilesKt__FileTreeWalkKt
 *  kotlin.io.FilesKt__UtilsKt$copyRecursively$1
 *  kotlin.io.NoSuchFileException
 *  kotlin.io.OnErrorAction
 *  kotlin.io.TerminateException
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.text.StringsKt
 */
package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FileAlreadyExistsException;
import kotlin.io.FilePathComponents;
import kotlin.io.FilesKt;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.io.NoSuchFileException;
import kotlin.io.OnErrorAction;
import kotlin.io.TerminateException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002\u00a2\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002\u00a2\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002\u00a2\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u00a8\u0006+"}, d2={"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__UtilsKt
extends FilesKt__FileTreeWalkKt {
    public static final boolean copyRecursively(File file, File file2, boolean bl, Function2<? super File, ? super IOException, ? extends OnErrorAction> function2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$copyRecursively");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"target");
        Intrinsics.checkNotNullParameter(function2, (String)"onError");
        boolean bl2 = file.exists();
        boolean bl3 = true;
        if (!bl2) {
            bl = (OnErrorAction)function2.invoke((Object)file, (Object)new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE ? bl3 : false;
            return bl;
        }
        try {
            Object object = FilesKt.walkTopDown((File)file);
            Object object2 = new /* Unavailable Anonymous Inner Class!! */;
            object2 = object.onFail((Function2)object2).iterator();
            while (object2.hasNext()) {
                boolean bl4;
                Object object3;
                object = (File)object2.next();
                if (!((File)object).exists()) {
                    object3 = new NoSuchFileException((File)object, null, "The source file doesn't exist.", 2, null);
                    if ((OnErrorAction)function2.invoke(object, object3) != OnErrorAction.TERMINATE) continue;
                    return false;
                }
                String string = FilesKt.toRelativeString((File)object, (File)file);
                object3 = new File(file2, string);
                if (((File)object3).exists() && (!((File)object).isDirectory() || !((File)object3).isDirectory()) && (bl4 = !bl || (((File)object3).isDirectory() ? !FilesKt.deleteRecursively((File)object3) : !((File)object3).delete()))) {
                    string = new FileAlreadyExistsException((File)object, (File)object3, "The destination file already exists.");
                    if ((OnErrorAction)function2.invoke(object3, (Object)string) != OnErrorAction.TERMINATE) continue;
                    return false;
                }
                if (((File)object).isDirectory()) {
                    ((File)object3).mkdirs();
                    continue;
                }
                if (FilesKt.copyTo$default((File)object, (File)object3, (boolean)bl, (int)0, (int)4, null).length() == ((File)object).length()) continue;
                object3 = new IOException("Source file wasn't copied completely, length of destination file differs.");
                if ((object = (OnErrorAction)function2.invoke(object, object3)) == (object3 = OnErrorAction.TERMINATE)) return false;
            }
            return true;
        }
        catch (TerminateException terminateException) {
            return false;
        }
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean bl, Function2 function2, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) == 0) return FilesKt.copyRecursively((File)file, (File)file2, (boolean)bl, (Function2)function2);
        function2 = (Function2)copyRecursively.1.INSTANCE;
        return FilesKt.copyRecursively((File)file, (File)file2, (boolean)bl, (Function2)function2);
    }

    /*
     * Exception decompiling
     */
    public static final File copyTo(File var0, File var1_1, boolean var2_4, int var3_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean bl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) == 0) return FilesKt.copyTo((File)file, (File)file2, (boolean)bl, (int)n);
        n = 8192;
        return FilesKt.copyTo((File)file, (File)file2, (boolean)bl, (int)n);
    }

    @Deprecated(message="Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String charSequence, String object, File file) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"prefix");
        object = File.createTempFile((String)charSequence, (String)object, file);
        ((File)object).delete();
        if (((File)object).mkdir()) {
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"dir");
            return object;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Unable to create temporary directory ");
        ((StringBuilder)charSequence).append(object);
        ((StringBuilder)charSequence).append('.');
        throw (Throwable)new IOException(((StringBuilder)charSequence).toString());
    }

    public static /* synthetic */ File createTempDir$default(String string, String string2, File file, int n, Object object) {
        if ((n & 1) != 0) {
            string = "tmp";
        }
        if ((n & 2) != 0) {
            string2 = null;
        }
        if ((n & 4) == 0) return FilesKt.createTempDir((String)string, (String)string2, (File)file);
        file = null;
        return FilesKt.createTempDir((String)string, (String)string2, (File)file);
    }

    @Deprecated(message="Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String object, String string, File file) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"prefix");
        object = File.createTempFile((String)object, string, file);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"File.createTempFile(prefix, suffix, directory)");
        return object;
    }

    public static /* synthetic */ File createTempFile$default(String string, String string2, File file, int n, Object object) {
        if ((n & 1) != 0) {
            string = "tmp";
        }
        if ((n & 2) != 0) {
            string2 = null;
        }
        if ((n & 4) == 0) return FilesKt.createTempFile((String)string, (String)string2, (File)file);
        file = null;
        return FilesKt.createTempFile((String)string, (String)string2, (File)file);
    }

    public static final boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$deleteRecursively");
        Iterator iterator = ((Sequence)FilesKt.walkBottomUp((File)file)).iterator();
        block0: while (true) {
            boolean bl = true;
            while (iterator.hasNext()) {
                file = (File)iterator.next();
                if ((file.delete() || !file.exists()) && bl) continue block0;
                bl = false;
            }
            return bl;
        }
    }

    public static final boolean endsWith(File file, File file2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$endsWith");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"other");
        FilePathComponents filePathComponents = FilesKt.toComponents((File)file);
        FilePathComponents filePathComponents2 = FilesKt.toComponents((File)file2);
        if (filePathComponents2.isRooted()) {
            return Intrinsics.areEqual((Object)file, (Object)file2);
        }
        int n = filePathComponents.getSize() - filePathComponents2.getSize();
        boolean bl = n < 0 ? false : ((Object)filePathComponents.getSegments().subList(n, filePathComponents.getSize())).equals(filePathComponents2.getSegments());
        return bl;
    }

    public static final boolean endsWith(File file, String string) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$endsWith");
        Intrinsics.checkNotNullParameter((Object)string, (String)"other");
        return FilesKt.endsWith((File)file, (File)new File(string));
    }

    public static final String getExtension(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$extension");
        object = ((File)object).getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"name");
        return StringsKt.substringAfterLast((String)object, (char)'.', (String)"");
    }

    public static final String getInvariantSeparatorsPath(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$invariantSeparatorsPath");
        if (File.separatorChar != '/') {
            object = ((File)object).getPath();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"path");
            object = StringsKt.replace$default((String)object, (char)File.separatorChar, (char)'/', (boolean)false, (int)4, null);
        } else {
            object = ((File)object).getPath();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"path");
        }
        return object;
    }

    public static final String getNameWithoutExtension(File object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$nameWithoutExtension");
        object = ((File)object).getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"name");
        return StringsKt.substringBeforeLast$default((String)object, (String)".", null, (int)2, null);
    }

    public static final File normalize(File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$normalize");
        Object object = FilesKt.toComponents((File)file);
        file = object.getRoot();
        object = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(object.getSegments());
        String string = File.separator;
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"File.separator");
        return FilesKt.resolve((File)file, (String)CollectionsKt.joinToString$default((Iterable)object, (CharSequence)string, null, null, (int)0, null, null, (int)62, null));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> object) {
        List list = new ArrayList(object.size());
        Iterator<? extends File> iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            String string = ((File)object).getName();
            if (string != null) {
                int n = string.hashCode();
                if (n != 46) {
                    if (n == 1472 && string.equals("..")) {
                        if (!list.isEmpty() && Intrinsics.areEqual((Object)((File)CollectionsKt.last((List)list)).getName(), (Object)"..") ^ true) {
                            list.remove(list.size() - 1);
                            continue;
                        }
                        list.add(object);
                        continue;
                    }
                } else if (string.equals(".")) continue;
            }
            list.add(object);
        }
        return list;
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    public static final File relativeTo(File file, File file2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$relativeTo");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"base");
        return new File(FilesKt.toRelativeString((File)file, (File)file2));
    }

    public static final File relativeToOrNull(File object, File file) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$relativeToOrNull");
        Intrinsics.checkNotNullParameter((Object)file, (String)"base");
        object = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt((File)object, file);
        object = object != null ? new File((String)object) : null;
        return object;
    }

    public static final File relativeToOrSelf(File file, File object) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$relativeToOrSelf");
        Intrinsics.checkNotNullParameter((Object)object, (String)"base");
        object = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt(file, (File)object);
        if (object == null) return file;
        file = new File((String)object);
        return file;
    }

    public static final File resolve(File object, File file) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)file, (String)"relative");
        if (FilesKt.isRooted((File)file)) {
            return file;
        }
        object = ((File)object).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"this.toString()");
        CharSequence charSequence = (CharSequence)object;
        boolean bl = charSequence.length() == 0;
        if (!bl && !StringsKt.endsWith$default((CharSequence)charSequence, (char)File.separatorChar, (boolean)false, (int)2, null)) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(File.separatorChar);
            ((StringBuilder)charSequence).append(file);
            object = new File(((StringBuilder)charSequence).toString());
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(file);
            object = new File(((StringBuilder)charSequence).toString());
        }
        return object;
    }

    public static final File resolve(File file, String string) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$resolve");
        Intrinsics.checkNotNullParameter((Object)string, (String)"relative");
        return FilesKt.resolve((File)file, (File)new File(string));
    }

    public static final File resolveSibling(File file, File file2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$resolveSibling");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"relative");
        FilePathComponents filePathComponents = FilesKt.toComponents((File)file);
        file = filePathComponents.getSize() == 0 ? new File("..") : filePathComponents.subPath(0, filePathComponents.getSize() - 1);
        return FilesKt.resolve((File)FilesKt.resolve((File)filePathComponents.getRoot(), (File)file), (File)file2);
    }

    public static final File resolveSibling(File file, String string) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$resolveSibling");
        Intrinsics.checkNotNullParameter((Object)string, (String)"relative");
        return FilesKt.resolveSibling((File)file, (File)new File(string));
    }

    public static final boolean startsWith(File file, File file2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$startsWith");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"other");
        file = FilesKt.toComponents((File)file);
        file2 = FilesKt.toComponents((File)file2);
        boolean bl = Intrinsics.areEqual((Object)file.getRoot(), (Object)file2.getRoot());
        boolean bl2 = false;
        if (bl ^ true) {
            return false;
        }
        if (file.getSize() < file2.getSize()) return bl2;
        bl2 = ((Object)file.getSegments().subList(0, file2.getSize())).equals(file2.getSegments());
        return bl2;
    }

    public static final boolean startsWith(File file, String string) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$startsWith");
        Intrinsics.checkNotNullParameter((Object)string, (String)"other");
        return FilesKt.startsWith((File)file, (File)new File(string));
    }

    public static final String toRelativeString(File file, File file2) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"$this$toRelativeString");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"base");
        CharSequence charSequence = FilesKt__UtilsKt.toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (charSequence != null) {
            return charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("this and base files have different roots: ");
        ((StringBuilder)charSequence).append(file);
        ((StringBuilder)charSequence).append(" and ");
        ((StringBuilder)charSequence).append(file2);
        ((StringBuilder)charSequence).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)charSequence).toString());
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File serializable, File object) {
        int n;
        Object object2 = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(FilesKt.toComponents((File)serializable));
        object = FilesKt__UtilsKt.normalize$FilesKt__UtilsKt(FilesKt.toComponents((File)object));
        if (Intrinsics.areEqual((Object)object2.getRoot(), (Object)object.getRoot()) ^ true) {
            return null;
        }
        int n2 = object.getSize();
        int n3 = object2.getSize();
        int n4 = Math.min(n3, n2);
        for (n = 0; n < n4 && Intrinsics.areEqual((Object)((File)object2.getSegments().get(n)), (Object)((File)object.getSegments().get(n))); ++n) {
        }
        serializable = new StringBuilder();
        n4 = n2 - 1;
        if (n4 >= n) {
            while (true) {
                if (Intrinsics.areEqual((Object)((File)object.getSegments().get(n4)).getName(), (Object)"..")) {
                    return null;
                }
                ((StringBuilder)serializable).append("..");
                if (n4 != n) {
                    ((StringBuilder)serializable).append(File.separatorChar);
                }
                if (n4 == n) break;
                --n4;
            }
        }
        if (n >= n3) return ((StringBuilder)serializable).toString();
        if (n < n2) {
            ((StringBuilder)serializable).append(File.separatorChar);
        }
        object = CollectionsKt.drop((Iterable)object2.getSegments(), (int)n);
        Appendable appendable = (Appendable)((Object)serializable);
        object2 = File.separator;
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"File.separator");
        CollectionsKt.joinTo$default((Iterable)object, (Appendable)appendable, (CharSequence)((CharSequence)object2), null, null, (int)0, null, null, (int)124, null);
        return ((StringBuilder)serializable).toString();
    }
}
