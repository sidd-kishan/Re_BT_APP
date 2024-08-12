/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.os.Handler
 *  android.util.Log
 *  com.google.android.gms.internal.consent_sdk.zzaa
 *  com.google.android.gms.internal.consent_sdk.zzab
 *  com.google.android.gms.internal.consent_sdk.zzal
 *  com.google.android.gms.internal.consent_sdk.zzaz
 *  com.google.android.gms.internal.consent_sdk.zzbn
 *  com.google.android.gms.internal.consent_sdk.zzby
 *  com.google.android.gms.internal.consent_sdk.zzbz
 *  com.google.android.gms.internal.consent_sdk.zze
 *  com.google.android.gms.internal.consent_sdk.zzk
 *  com.google.android.gms.internal.consent_sdk.zzn
 *  com.google.android.gms.internal.consent_sdk.zzr
 *  com.google.android.gms.internal.consent_sdk.zzs
 *  com.google.android.gms.internal.consent_sdk.zzt
 *  com.google.android.gms.internal.consent_sdk.zzu
 *  com.google.android.gms.internal.consent_sdk.zzw
 *  com.google.android.gms.internal.consent_sdk.zzz
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener
 *  com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.internal.consent_sdk.zzaa;
import com.google.android.gms.internal.consent_sdk.zzab;
import com.google.android.gms.internal.consent_sdk.zzal;
import com.google.android.gms.internal.consent_sdk.zzaz;
import com.google.android.gms.internal.consent_sdk.zzbn;
import com.google.android.gms.internal.consent_sdk.zzby;
import com.google.android.gms.internal.consent_sdk.zzbz;
import com.google.android.gms.internal.consent_sdk.zze;
import com.google.android.gms.internal.consent_sdk.zzk;
import com.google.android.gms.internal.consent_sdk.zzn;
import com.google.android.gms.internal.consent_sdk.zzr;
import com.google.android.gms.internal.consent_sdk.zzs;
import com.google.android.gms.internal.consent_sdk.zzt;
import com.google.android.gms.internal.consent_sdk.zzu;
import com.google.android.gms.internal.consent_sdk.zzw;
import com.google.android.gms.internal.consent_sdk.zzz;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;

final class zzp {
    private final Application zza;
    private final zzab zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zzal zze;
    private final zzaz zzf;
    private final zzn zzg;
    private final zzz zzh;
    private final zze zzi;

    zzp(Application application, zzab zzab2, Handler handler, Executor executor, zzal zzal2, zzaz zzaz2, zzn zzn2, zzz zzz2, zze zze2) {
        this.zza = application;
        this.zzb = zzab2;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzal2;
        this.zzf = zzaz2;
        this.zzg = zzn2;
        this.zzh = zzz2;
        this.zzi = zze2;
    }

    private final zzby zza(zzbn zzbn2) throws zzk {
        try {
            zzbn2 = this.zzb(zzbn2);
            return zzbn2;
        }
        catch (IOException iOException) {
            throw new zzk(2, "Error making request.", (Throwable)iOException);
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw new zzk(4, "The server timed out.", (Throwable)socketTimeoutException);
        }
    }

    /*
     * Exception decompiling
     */
    private final zzby zzb(zzbn var1_1) throws IOException {
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

    final void zza(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzd.execute((Runnable)new zzs(this, activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener));
    }

    final /* synthetic */ void zza(ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener) {
        Handler handler = this.zzc;
        onConsentInfoUpdateSuccessListener.getClass();
        handler.post(zzu.zza((ConsentInformation.OnConsentInfoUpdateSuccessListener)onConsentInfoUpdateSuccessListener));
    }

    final /* synthetic */ void zzb(Activity activity, ConsentRequestParameters object, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        try {
            Object object2 = object.getConsentDebugSettings();
            if (object2 == null || !object2.isTestDevice()) {
                object2 = zzbz.zza((Context)this.zza);
                int n = String.valueOf(object2).length();
                StringBuilder stringBuilder = new StringBuilder(n + 95);
                stringBuilder.append("Use new ConsentDebugSettings.Builder().addTestDeviceHashedId(\"");
                stringBuilder.append((String)object2);
                stringBuilder.append("\") to set this as a debug device.");
                Log.i((String)"UserMessagingPlatform", (String)stringBuilder.toString());
            }
            activity = this.zza(this.zzg.zza(activity, (ConsentRequestParameters)object));
            object2 = this.zzh;
            object = new zzaa((zzz)object2, (zzby)activity);
            activity = object.zza();
            this.zze.zza(activity.zza);
            this.zze.zzb(activity.zzb);
            this.zzf.zza(activity.zzc);
            object = this.zzi.zza();
            activity = new zzr(this, onConsentInfoUpdateSuccessListener);
            object.execute((Runnable)activity);
            return;
        }
        catch (RuntimeException runtimeException) {
            Object object3 = String.valueOf(Log.getStackTraceString((Throwable)runtimeException));
            object3 = object3.length() != 0 ? "Caught exception when trying to request consent info update: ".concat((String)object3) : new String("Caught exception when trying to request consent info update: ");
            object3 = new zzk(1, object3);
            this.zzc.post((Runnable)new zzw(onConsentInfoUpdateFailureListener, (zzk)((Object)object3)));
            return;
        }
        catch (zzk zzk2) {
            this.zzc.post((Runnable)new zzt(onConsentInfoUpdateFailureListener, zzk2));
            return;
        }
    }
}
