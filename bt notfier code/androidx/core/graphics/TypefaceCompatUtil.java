/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.Process
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    /*
     * Enabled force condition propagation
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static ByteBuffer copyToDirectBuffer(Context object, Resources object2, int n) {
        block5: {
            void var2_4;
            if ((object = TypefaceCompatUtil.getTempFile((Context)object)) == null) {
                return null;
            }
            boolean bl = TypefaceCompatUtil.copyToFile((File)object, object2, (int)var2_4);
            if (bl) break block5;
            ((File)object).delete();
            return null;
        }
        try {
            ByteBuffer byteBuffer = TypefaceCompatUtil.mmap((File)object);
            return byteBuffer;
        }
        finally {
            ((File)object).delete();
        }
    }

    /*
     * WARNING - void declaration
     */
    public static boolean copyToFile(File file, Resources object, int n) {
        void var0_3;
        block4: {
            boolean bl;
            try {
                object = object.openRawResource(n);
            }
            catch (Throwable throwable) {
                object = null;
                break block4;
            }
            try {
                bl = TypefaceCompatUtil.copyToFile(file, (InputStream)object);
            }
            catch (Throwable throwable) {
                break block4;
            }
            TypefaceCompatUtil.closeQuietly((Closeable)object);
            return bl;
        }
        TypefaceCompatUtil.closeQuietly((Closeable)object);
        throw var0_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public static boolean copyToFile(File object, InputStream inputStream) {
        void var0_3;
        Object object2;
        StrictMode.ThreadPolicy threadPolicy;
        block8: {
            Object object3;
            block9: {
                threadPolicy = StrictMode.allowThreadDiskWrites();
                Object var5_9 = null;
                File file = null;
                object2 = file;
                try {
                    object2 = file;
                    object3 = new FileOutputStream((File)object, false);
                }
                catch (Throwable throwable) {
                    break block8;
                }
                catch (IOException iOException) {
                    object = var5_9;
                    break block9;
                }
                try {
                    int n;
                    object = new byte[1024];
                    while ((n = inputStream.read((byte[])object)) != -1) {
                        ((FileOutputStream)object3).write((byte[])object, 0, n);
                    }
                }
                catch (Throwable throwable) {
                    object2 = object3;
                    break block8;
                }
                catch (IOException iOException) {
                    object = object3;
                    break block9;
                }
                TypefaceCompatUtil.closeQuietly((Closeable)object3);
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                return true;
            }
            object2 = object;
            {
                void var1_7;
                object2 = object;
                object3 = new StringBuilder();
                object2 = object;
                ((StringBuilder)object3).append("Error copying resource contents to temp file: ");
                object2 = object;
                ((StringBuilder)object3).append(var1_7.getMessage());
                object2 = object;
                Log.e((String)TAG, (String)((StringBuilder)object3).toString());
            }
            TypefaceCompatUtil.closeQuietly((Closeable)object);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            return false;
        }
        TypefaceCompatUtil.closeQuietly(object2);
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw var0_3;
    }

    public static File getTempFile(Context object) {
        if ((object = object.getCacheDir()) == null) {
            return null;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append(CACHE_FILE_PREFIX);
        charSequence.append(Process.myPid());
        charSequence.append("-");
        charSequence.append(Process.myTid());
        charSequence.append("-");
        charSequence = charSequence.toString();
        int n = 0;
        while (n < 100) {
            Serializable serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)charSequence);
            ((StringBuilder)serializable).append(n);
            serializable = new File((File)object, ((StringBuilder)serializable).toString());
            try {
                boolean bl = ((File)serializable).createNewFile();
                if (bl) {
                    return serializable;
                }
            }
            catch (IOException iOException) {}
            ++n;
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public static ByteBuffer mmap(Context var0, CancellationSignal var1_3, Uri var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    /*
     * Exception decompiling
     */
    private static ByteBuffer mmap(File var0) {
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

    public static Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer(Context context, FontsContractCompat.FontInfo[] fontInfoArray, CancellationSignal cancellationSignal) {
        HashMap<FontsContractCompat.FontInfo, ByteBuffer> hashMap = new HashMap<FontsContractCompat.FontInfo, ByteBuffer>();
        int n = fontInfoArray.length;
        int n2 = 0;
        while (n2 < n) {
            FontsContractCompat.FontInfo fontInfo = fontInfoArray[n2];
            if (fontInfo.getResultCode() == 0 && !hashMap.containsKey(fontInfo = fontInfo.getUri())) {
                hashMap.put(fontInfo, TypefaceCompatUtil.mmap(context, cancellationSignal, (Uri)fontInfo));
            }
            ++n2;
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
