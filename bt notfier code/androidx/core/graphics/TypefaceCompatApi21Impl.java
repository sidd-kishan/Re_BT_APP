/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.system.ErrnoException
 *  android.system.Os
 *  android.system.OsConstants
 *  android.util.Log
 *  androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry
 *  androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry
 *  androidx.core.graphics.TypefaceCompatBaseImpl
 *  androidx.core.graphics.TypefaceCompatUtil
 *  androidx.core.provider.FontsContractCompat$FontInfo
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TypefaceCompatApi21Impl
extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle;
    private static Method sCreateFromFamiliesWithDefault;
    private static Class<?> sFontFamily;
    private static Constructor<?> sFontFamilyCtor;
    private static boolean sHasInitBeenCalled;

    TypefaceCompatApi21Impl() {
    }

    /*
     * WARNING - void declaration
     */
    private static boolean addFontWeightStyle(Object object, String string, int n, boolean bl) {
        void var0_3;
        TypefaceCompatApi21Impl.init();
        try {
            bl = (Boolean)sAddFontWeightStyle.invoke(object, string, n, bl);
            return bl;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        throw new RuntimeException((Throwable)var0_3);
    }

    /*
     * WARNING - void declaration
     */
    private static Typeface createFromFamiliesWithDefault(Object object) {
        void var0_3;
        TypefaceCompatApi21Impl.init();
        try {
            Object object2 = Array.newInstance(sFontFamily, 1);
            Array.set(object2, 0, object);
            object = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, object2);
            return object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        throw new RuntimeException((Throwable)var0_3);
    }

    private File getFile(ParcelFileDescriptor object) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/proc/self/fd/");
            stringBuilder.append(object.getFd());
            object = Os.readlink((String)stringBuilder.toString());
            if (!OsConstants.S_ISREG((int)Os.stat((String)object).st_mode)) return null;
            object = new File((String)object);
            return object;
        }
        catch (ErrnoException errnoException) {
        }
        return null;
    }

    private static void init() {
        Method method;
        GenericDeclaration genericDeclaration;
        Class<?> clazz;
        Constructor<?> constructor;
        block4: {
            if (sHasInitBeenCalled) {
                return;
            }
            sHasInitBeenCalled = true;
            constructor = null;
            try {
                clazz = Class.forName(FONT_FAMILY_CLASS);
                Constructor<?> constructor2 = clazz.getConstructor(new Class[0]);
                genericDeclaration = clazz.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, String.class, Integer.TYPE, Boolean.TYPE);
                method = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(clazz, 1).getClass());
                constructor = constructor2;
                break block4;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            Log.e((String)TAG, (String)method.getClass().getName(), (Throwable)((Object)method));
            method = null;
            genericDeclaration = clazz = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = clazz;
        sAddFontWeightStyle = genericDeclaration;
        sCreateFromFamiliesWithDefault = method;
    }

    /*
     * WARNING - void declaration
     */
    private static Object newFamily() {
        void var0_4;
        TypefaceCompatApi21Impl.init();
        try {
            Object obj = sFontFamilyCtor.newInstance(new Object[0]);
            return obj;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        throw new RuntimeException((Throwable)var0_4);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry object, Resources resources, int n) {
        Object object2 = TypefaceCompatApi21Impl.newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArray = object.getEntries();
        int n2 = fontFileResourceEntryArray.length;
        n = 0;
        while (n < n2) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = fontFileResourceEntryArray[n];
            object = TypefaceCompatUtil.getTempFile((Context)context);
            if (object == null) {
                return null;
            }
            boolean bl = TypefaceCompatUtil.copyToFile((File)object, (Resources)resources, (int)fontFileResourceEntry.getResourceId());
            if (!bl) {
                return null;
            }
            bl = TypefaceCompatApi21Impl.addFontWeightStyle(object2, ((File)object).getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic());
            if (!bl) {
                return null;
            }
            ++n;
        }
        return TypefaceCompatApi21Impl.createFromFamiliesWithDefault(object2);
        catch (RuntimeException runtimeException) {
            return null;
        }
        finally {
            ((File)object).delete();
        }
    }

    /*
     * Exception decompiling
     */
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_5, FontsContractCompat.FontInfo[] var3_7, int var4_9) {
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
}
