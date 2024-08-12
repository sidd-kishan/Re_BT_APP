/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri$Builder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.util.Log
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamite.DynamiteModule$LoadingException
 *  com.google.android.gms.dynamite.DynamiteModule$VersionPolicy
 *  com.google.android.gms.dynamite.zzb
 *  com.google.android.gms.dynamite.zzc
 *  com.google.android.gms.dynamite.zzd
 *  com.google.android.gms.dynamite.zze
 *  com.google.android.gms.dynamite.zzf
 *  com.google.android.gms.dynamite.zzg
 *  com.google.android.gms.dynamite.zzh
 *  com.google.android.gms.dynamite.zzi
 *  com.google.android.gms.dynamite.zzj
 *  com.google.android.gms.dynamite.zzk
 *  com.google.android.gms.dynamite.zzm
 *  com.google.android.gms.dynamite.zzo
 *  com.google.android.gms.dynamite.zzp
 */
package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.zzb;
import com.google.android.gms.dynamite.zzc;
import com.google.android.gms.dynamite.zzd;
import com.google.android.gms.dynamite.zze;
import com.google.android.gms.dynamite.zzf;
import com.google.android.gms.dynamite.zzg;
import com.google.android.gms.dynamite.zzh;
import com.google.android.gms.dynamite.zzi;
import com.google.android.gms.dynamite.zzj;
import com.google.android.gms.dynamite.zzk;
import com.google.android.gms.dynamite.zzm;
import com.google.android.gms.dynamite.zzo;
import com.google.android.gms.dynamite.zzp;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
    public static final VersionPolicy PREFER_LOCAL;
    public static final VersionPolicy PREFER_REMOTE;
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING;
    public static final VersionPolicy zza;
    private static Boolean zzb;
    private static String zzc;
    private static int zzd = -1;
    private static final ThreadLocal<zzk> zze;
    private static final ThreadLocal<Long> zzf;
    private static final zzm zzg;
    private static zzo zzi;
    private static zzp zzj;
    private final Context zzh;

    static {
        zze = new ThreadLocal();
        zzf = new zzb();
        zzg = new zzc();
        PREFER_REMOTE = new zzd();
        PREFER_LOCAL = new zze();
        PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzf();
        PREFER_HIGHEST_OR_LOCAL_VERSION = new zzg();
        PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzh();
        PREFER_HIGHEST_OR_REMOTE_VERSION = new zzi();
        zza = new zzj();
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull((Object)context);
        this.zzh = context;
    }

    public static int getLocalVersion(Context object, String string) {
        try {
            Object object2 = object.getApplicationContext().getClassLoader();
            int n = String.valueOf(string).length();
            object = new StringBuilder(n + 61);
            ((StringBuilder)object).append("com.google.android.gms.dynamite.descriptors.");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(".");
            ((StringBuilder)object).append("ModuleDescriptor");
            object2 = ((ClassLoader)object2).loadClass(((StringBuilder)object).toString());
            object = ((Class)object2).getDeclaredField("MODULE_ID");
            object2 = ((Class)object2).getDeclaredField("MODULE_VERSION");
            if (!Objects.equal((Object)((Field)object).get(null), (Object)string)) {
                object = String.valueOf(((Field)object).get(null));
                n = String.valueOf(object).length();
                int n2 = String.valueOf(string).length();
                object2 = new StringBuilder(n + 51 + n2);
                ((StringBuilder)object2).append("Module descriptor id '");
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append("' didn't match expected id '");
                ((StringBuilder)object2).append(string);
                ((StringBuilder)object2).append("'");
                Log.e((String)"DynamiteModule", (String)((StringBuilder)object2).toString());
                return 0;
            }
            n = ((Field)object2).getInt(null);
            return n;
        }
        catch (Exception exception) {
            String string2 = String.valueOf(exception.getMessage());
            string2 = string2.length() != 0 ? "Failed to load module descriptor class: ".concat(string2) : new String("Failed to load module descriptor class: ");
            Log.e((String)"DynamiteModule", (String)string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 45);
            stringBuilder.append("Local module descriptor class for ");
            stringBuilder.append(string);
            stringBuilder.append(" not found.");
            Log.w((String)"DynamiteModule", (String)stringBuilder.toString());
        }
        return 0;
    }

    public static int getRemoteVersion(Context context, String string) {
        return DynamiteModule.zza(context, string, false);
    }

    /*
     * Exception decompiling
     */
    public static DynamiteModule load(Context var0, VersionPolicy var1_4, String var2_5) throws LoadingException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 9[TRYBLOCK] [37 : 600->603)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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
    public static int zza(Context var0, String var1_1, boolean var2_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 22[TRYBLOCK] [71 : 790->793)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private static int zzb(Context var0, String var1_2, boolean var2_4) throws LoadingException {
        block17: {
            var7_5 /* !! */  = null;
            var8_10 = null;
            var5_11 = DynamiteModule.zzf.get();
            var9_12 = var0 /* !! */ .getContentResolver();
            var0 /* !! */  = "api_force_staging";
            if (!var2_4) {
                var0 /* !! */  = "api";
            }
            if ((var1_2 = var9_12.query((var10_13 = new Uri.Builder()).scheme("content").authority("com.google.android.gms.chimera").path((String)var0 /* !! */ ).appendPath((String)var1_2).appendQueryParameter("requestStartTime", String.valueOf(var5_11)).build(), null, null, null, null)) == null) ** GOTO lbl38
            var0 /* !! */  = var1_2;
            if (!var1_2.moveToFirst()) ** GOTO lbl38
            var0 /* !! */  = var1_2;
            var3_14 = var1_2.getInt(0);
            if (var3_14 <= 0) ** GOTO lbl34
            var0 /* !! */  = var1_2;
            // MONITORENTER : com.google.android.gms.dynamite.DynamiteModule.class
            DynamiteModule.zzc = var1_2.getString(2);
            var4_15 = var1_2.getColumnIndex("loaderVersion");
            if (var4_15 >= 0) {
                DynamiteModule.zzd = var1_2.getInt(var4_15);
            }
            // MONITOREXIT : com.google.android.gms.dynamite.DynamiteModule.class
            var0 /* !! */  = var1_2;
            var2_4 = DynamiteModule.zzc((Cursor)var1_2);
            if (!var2_4) ** GOTO lbl34
            var0 /* !! */  = var8_10;
            ** GOTO lbl35
            {
                catch (Throwable var7_6) {}
                var0 /* !! */  = var1_2;
                throw var7_6;
lbl34:
                // 2 sources

                var0 /* !! */  = var1_2;
lbl35:
                // 2 sources

                if (var0 /* !! */  == null) return var3_14;
                var0 /* !! */ .close();
                return var3_14;
lbl38:
                // 2 sources

                var0 /* !! */  = var1_2;
                try {
                    block18: {
                        try {
                            Log.w((String)"DynamiteModule", (String)"Failed to retrieve remote module version.");
                            var0 /* !! */  = var1_2;
                            var0 /* !! */  = var1_2;
                            var7_5 /* !! */  = new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
                            var0 /* !! */  = var1_2;
                            throw var7_5 /* !! */ ;
                        }
                        catch (Exception var7_7) {}
                        break block18;
                        catch (Throwable var0_1) {
                            var1_2 = var0_1;
                            break block17;
                        }
                        catch (Exception var7_8) {
                            var1_2 = null;
                        }
                    }
                    var0 /* !! */  = var1_2;
                    if (var7_9 instanceof LoadingException) {
                        var0 /* !! */  = var1_2;
                        throw var7_9;
                    }
                    var0 /* !! */  = var1_2;
                    var0 /* !! */  = var1_2;
                    var8_10 = new LoadingException("V2 version check failed", (Throwable)var7_9, null);
                    var0 /* !! */  = var1_2;
                    throw var8_10;
                }
                catch (Throwable var1_3) {
                    var7_5 /* !! */  = var0 /* !! */ ;
                }
            }
        }
        if (var7_5 /* !! */  == null) throw var1_2;
        var7_5 /* !! */ .close();
        throw var1_2;
    }

    private static boolean zzc(Cursor cursor) {
        zzk zzk2 = zze.get();
        if (zzk2 == null) return false;
        if (zzk2.zza != null) return false;
        zzk2.zza = cursor;
        return true;
    }

    private static DynamiteModule zzd(Context context, String string) {
        string = (string = String.valueOf(string)).length() != 0 ? "Selected local version of ".concat(string) : new String("Selected local version of ");
        Log.i((String)"DynamiteModule", (String)string);
        return new DynamiteModule(context.getApplicationContext());
    }

    /*
     * WARNING - void declaration
     */
    private static void zze(ClassLoader classLoader) throws LoadingException {
        void var0_6;
        try {
            IInterface iInterface;
            classLoader = (IBinder)classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            classLoader = classLoader == null ? null : ((iInterface = classLoader.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2")) instanceof zzp ? (zzp)iInterface : new zzp((IBinder)classLoader));
            zzj = classLoader;
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        throw new LoadingException("Failed to instantiate dynamite loader", (Throwable)var0_6, null);
    }

    private static zzo zzf(Context object) {
        synchronized (DynamiteModule.class) {
            block6: {
                if (zzi != null) {
                    object = zzi;
                    return object;
                }
                try {
                    IInterface iInterface;
                    object = (IBinder)object.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader")) instanceof zzo ? (zzo)iInterface : new zzo((IBinder)object));
                    if (object == null) return null;
                    zzi = object;
                }
                catch (Exception exception) {
                    String string = String.valueOf(exception.getMessage());
                    string = string.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(string) : new String("Failed to load IDynamiteLoader from GmsCore: ");
                    Log.e((String)"DynamiteModule", (String)string);
                    break block6;
                }
                return object;
            }
            return null;
        }
    }

    public Context getModuleContext() {
        return this.zzh;
    }

    /*
     * WARNING - void declaration
     */
    public IBinder instantiate(String string) throws LoadingException {
        void var2_6;
        try {
            IBinder iBinder = (IBinder)this.zzh.getClassLoader().loadClass(string).newInstance();
            return iBinder;
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        string = String.valueOf(string);
        string = string.length() != 0 ? "Failed to instantiate module class: ".concat(string) : new String("Failed to instantiate module class: ");
        throw new LoadingException(string, (Throwable)var2_6, null);
    }
}
