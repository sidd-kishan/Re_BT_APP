/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfth
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzftp
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfud
 *  com.google.android.gms.internal.ads.zzfue
 *  com.google.android.gms.internal.ads.zzfug
 *  com.google.android.gms.internal.ads.zzfuh
 *  com.google.android.gms.internal.ads.zzfui
 *  com.google.android.gms.internal.ads.zzfuj
 *  com.google.android.gms.internal.ads.zzfuk
 *  com.google.android.gms.internal.ads.zzful
 *  com.google.android.gms.internal.ads.zzfvw
 *  com.google.android.gms.internal.ads.zzgar
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfth;
import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfud;
import com.google.android.gms.internal.ads.zzfue;
import com.google.android.gms.internal.ads.zzfug;
import com.google.android.gms.internal.ads.zzfuh;
import com.google.android.gms.internal.ads.zzfui;
import com.google.android.gms.internal.ads.zzfuj;
import com.google.android.gms.internal.ads.zzfuk;
import com.google.android.gms.internal.ads.zzful;
import com.google.android.gms.internal.ads.zzfvw;
import com.google.android.gms.internal.ads.zzgar;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzghi;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzfum {
    private static final Logger zza = Logger.getLogger(zzfum.class.getName());
    private static final ConcurrentMap<String, zzful> zzb = new ConcurrentHashMap<String, zzful>();
    private static final ConcurrentMap<String, zzfuk> zzc = new ConcurrentHashMap<String, zzfuk>();
    private static final ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap<String, Boolean>();
    private static final ConcurrentMap<String, zzfth<?>> zze = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzfue<?, ?>> zzf = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzftp> zzg = new ConcurrentHashMap<String, zzftp>();

    private zzfum() {
    }

    @Deprecated
    public static zzfth<?> zza(String string) throws GeneralSecurityException {
        if (string == null) throw new IllegalArgumentException("catalogueName must be non-null.");
        Object object = (zzfth)zze.get(string.toLowerCase(Locale.US));
        if (object != null) return object;
        Object object2 = object = String.format("no catalogue found for %s. ", string);
        if (string.toLowerCase(Locale.US).startsWith("tinkaead")) {
            object2 = String.valueOf(object).concat("Maybe call AeadConfig.register().");
        }
        if (!string.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
            if (!string.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                if (!string.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") && !string.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                    if (!string.toLowerCase(Locale.US).startsWith("tinkmac")) {
                        if (!string.toLowerCase(Locale.US).startsWith("tinkpublickeysign") && !string.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                            object = object2;
                            if (!string.toLowerCase(Locale.US).startsWith("tink")) throw new GeneralSecurityException((String)object);
                            object = String.valueOf(object2).concat("Maybe call TinkConfig.register().");
                        } else {
                            object = String.valueOf(object2).concat("Maybe call SignatureConfig.register().");
                        }
                    } else {
                        object = String.valueOf(object2).concat("Maybe call MacConfig.register().");
                    }
                } else {
                    object = String.valueOf(object2).concat("Maybe call HybridConfig.register().");
                }
            } else {
                object = String.valueOf(object2).concat("Maybe call StreamingAeadConfig.register().");
            }
        } else {
            object = String.valueOf(object2).concat("Maybe call DeterministicAeadConfig.register().");
        }
        throw new GeneralSecurityException((String)object);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static <P> void zzb(zzftm<P> object, boolean bl) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            if (object != null) {
                String string = object.zzd();
                zzfum.zzp(string, object.getClass(), Collections.emptyMap(), bl);
                ConcurrentMap<String, zzful> concurrentMap = zzb;
                zzfuh zzfuh2 = new zzfuh((zzftm)object);
                concurrentMap.putIfAbsent(string, (zzful)zzfuh2);
                zzd.put(string, bl);
                return;
            }
            try {
                object = new IllegalArgumentException("key manager must be non-null.");
                throw object;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public static <KeyProtoT extends zzghi> void zzc(zzftu<KeyProtoT> object, boolean bl) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            Object object2 = object.zzb();
            zzfum.zzp((String)object2, object.getClass(), object.zzh().zze(), true);
            if (zzfvw.zza((int)object.zzj())) {
                if (!zzb.containsKey(object2)) {
                    ConcurrentMap<String, zzful> concurrentMap = zzb;
                    zzfui zzfui2 = new zzfui(object);
                    concurrentMap.put((String)object2, (zzful)zzfui2);
                    concurrentMap = zzc;
                    zzfui2 = new zzfuk((zzftu)object);
                    concurrentMap.put((String)object2, (zzful)zzfui2);
                    zzfum.zzq((String)object2, object.zzh().zze());
                }
                zzd.put((String)object2, true);
                return;
            }
            String string = String.valueOf(object.getClass());
            int n = String.valueOf(string).length();
            object = new StringBuilder(n + 61);
            ((StringBuilder)object).append("failed to register key manager ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" as it is not FIPS compatible.");
            object2 = new GeneralSecurityException(((StringBuilder)object).toString());
            throw object2;
        }
    }

    public static <KeyProtoT extends zzghi, PublicKeyProtoT extends zzghi> void zzd(zzfug<KeyProtoT, PublicKeyProtoT> object, zzftu<PublicKeyProtoT> object2, boolean bl) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            zzfum.zzp("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", object.getClass(), object.zzh().zze(), true);
            zzfum.zzp("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", object2.getClass(), Collections.emptyMap(), false);
            if (zzfvw.zza((int)1)) {
                Object object3;
                Object object4;
                if (!zzfvw.zza((int)1)) {
                    object2 = String.valueOf(object2.getClass());
                    int n = String.valueOf(object2).length();
                    StringBuilder stringBuilder = new StringBuilder(n + 61);
                    stringBuilder.append("failed to register key manager ");
                    stringBuilder.append((String)object2);
                    stringBuilder.append(" as it is not FIPS compatible.");
                    object = new GeneralSecurityException(stringBuilder.toString());
                    throw object;
                }
                if (zzb.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (object4 = ((zzful)zzb.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).zze()) != null && !((Class)object4).getName().equals(object2.getClass().getName())) {
                    zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey with inconsistent public key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                    GeneralSecurityException generalSecurityException = new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", object.getClass().getName(), ((Class)object4).getName(), object2.getClass().getName()));
                    throw generalSecurityException;
                }
                if (!zzb.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || ((zzful)zzb.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")).zze() == null) {
                    object3 = zzb;
                    object4 = new zzfuj(object, (zzftu)object2);
                    object3.put((String)"type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", (zzful)object4);
                    object4 = zzc;
                    object3 = new zzfuk((zzftu)object);
                    object4.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", object3);
                    zzfum.zzq("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", object.zzh().zze());
                }
                zzd.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", true);
                if (!zzb.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                    object3 = zzb;
                    object = new zzfui((zzftu)object2);
                    object3.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", object);
                }
                zzd.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", false);
                return;
            }
            String string = String.valueOf(object.getClass());
            int n = String.valueOf(string).length();
            object = new StringBuilder(n + 61);
            ((StringBuilder)object).append("failed to register key manager ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" as it is not FIPS compatible.");
            object2 = new GeneralSecurityException(((StringBuilder)object).toString());
            throw object2;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static <B, P> void zze(zzfue<B, P> object) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            if (object != null) {
                Class clazz = object.zzb();
                if (zzf.containsKey(clazz)) {
                    zzfue zzfue2 = (zzfue)zzf.get(clazz);
                    if (!object.getClass().getName().equals(zzfue2.getClass().getName())) {
                        zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(((Object)clazz).toString()));
                        GeneralSecurityException generalSecurityException = new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", clazz.getName(), zzfue2.getClass().getName(), object.getClass().getName()));
                        throw generalSecurityException;
                    }
                }
                zzf.put(clazz, (zzfue<?, ?>)object);
                return;
            }
            try {
                object = new IllegalArgumentException("wrapper must be non-null");
                throw object;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public static zzftm<?> zzf(String string) throws GeneralSecurityException {
        return zzfum.zzo(string).zzb();
    }

    public static zzgar zzg(zzgau object) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            Object object2 = zzfum.zzf(object.zza());
            if (((Boolean)zzd.get(object.zza())).booleanValue()) {
                object = object2.zzf(object.zzc());
                return object;
            }
            object = ((String)(object = String.valueOf(object.zza()))).length() != 0 ? "newKey-operation not permitted for key type ".concat((String)object) : new String("newKey-operation not permitted for key type ");
            object2 = new Object((String)object);
            throw object2;
        }
    }

    public static zzghi zzh(zzgau object) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            Object object2 = zzfum.zzf(object.zza());
            if (((Boolean)zzd.get(object.zza())).booleanValue()) {
                object = object2.zzc(object.zzc());
                return object;
            }
            object = ((String)(object = String.valueOf(object.zza()))).length() != 0 ? "newKey-operation not permitted for key type ".concat((String)object) : new String("newKey-operation not permitted for key type ");
            object2 = new Object((String)object);
            throw object2;
        }
    }

    public static <P> P zzi(String string, zzghi zzghi2, Class<P> clazz) throws GeneralSecurityException {
        return (P)zzfum.zzr(string, clazz).zzb(zzghi2);
    }

    public static <P> P zzj(String string, byte[] byArray, Class<P> clazz) throws GeneralSecurityException {
        return zzfum.zzs(string, zzgex.zzt((byte[])byArray), clazz);
    }

    public static <P> P zzk(zzgar zzgar2, Class<P> clazz) throws GeneralSecurityException {
        return zzfum.zzs(zzgar2.zza(), zzgar2.zzc(), clazz);
    }

    public static <B, P> P zzl(zzfud<B> object, Class<P> object2) throws GeneralSecurityException {
        if ((object2 = (zzfue)zzf.get(object2)) == null) {
            object = ((String)(object = String.valueOf(object.zze().getName()))).length() != 0 ? "No wrapper found for ".concat((String)object) : new String("No wrapper found for ");
            throw new GeneralSecurityException((String)object);
        }
        if (object2.zzc().equals(object.zze())) {
            return (P)object2.zza((zzfud)object);
        }
        object2 = ((Object)object2.zzc()).toString();
        String string = ((Object)object.zze()).toString();
        object = new StringBuilder(((String)object2).length() + 44 + string.length());
        ((StringBuilder)object).append("Wrong input primitive class, expected ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(", got ");
        ((StringBuilder)object).append(string);
        throw new GeneralSecurityException(((StringBuilder)object).toString());
    }

    static Map<String, zzftp> zzm() {
        synchronized (zzfum.class) {
            Map<String, zzftp> map = Collections.unmodifiableMap(zzg);
            return map;
        }
    }

    public static Class<?> zzn(Class<?> zzfue2) {
        if ((zzfue2 = (zzfue)zzf.get(zzfue2)) != null) return zzfue2.zzc();
        return null;
    }

    private static zzful zzo(String string) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            if (!zzb.containsKey(string)) {
                string = (string = String.valueOf(string)).length() != 0 ? "No key manager found for key type ".concat(string) : new String("No key manager found for key type ");
                GeneralSecurityException generalSecurityException = new GeneralSecurityException(string);
                throw generalSecurityException;
            }
            string = (zzful)zzb.get(string);
            return string;
        }
    }

    private static <KeyProtoT extends zzghi, KeyFormatProtoT extends zzghi> void zzp(String object, Class object2, Map<String, zzftr<KeyFormatProtoT>> object3, boolean bl) throws GeneralSecurityException {
        synchronized (zzfum.class) {
            try {
                Object object4 = (zzful)zzb.get(object);
                if (object4 != null && !object4.zzc().equals(object2)) {
                    Logger logger = zza;
                    Level level = Level.WARNING;
                    object3 = ((String)object).length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat((String)object) : new String("Attempted overwrite of a registered key manager for key type ");
                    logger.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", (String)object3);
                    object3 = new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", object, object4.zzc().getName(), ((Class)object2).getName()));
                    throw object3;
                }
                if (!bl) return;
                if (zzd.containsKey(object) && !((Boolean)zzd.get(object)).booleanValue()) {
                    object = ((String)object).length() != 0 ? "New keys are already disallowed for key type ".concat((String)object) : new String("New keys are already disallowed for key type ");
                    object2 = new GeneralSecurityException((String)object);
                    throw object2;
                }
                if (zzb.containsKey(object)) {
                    object2 = object3.entrySet().iterator();
                    do {
                        if (!object2.hasNext()) return;
                    } while (zzg.containsKey((object3 = object2.next()).getKey()));
                    object4 = (String)object3.getKey();
                    int n = String.valueOf(object4).length();
                    object3 = new StringBuilder(n + 79 + ((String)object).length());
                    ((StringBuilder)object3).append("Attempted to register a new key template ");
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append(" from an existing key manager of type ");
                    ((StringBuilder)object3).append((String)object);
                    object2 = new GeneralSecurityException(((StringBuilder)object3).toString());
                    throw object2;
                }
                object2 = object3.entrySet().iterator();
                do {
                    if (!object2.hasNext()) return;
                } while (!zzg.containsKey((object = object2.next()).getKey()));
                object = ((String)(object = String.valueOf((String)object.getKey()))).length() != 0 ? "Attempted overwrite of a registered key template ".concat((String)object) : new String("Attempted overwrite of a registered key template ");
                object2 = new GeneralSecurityException((String)object);
                throw object2;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private static <KeyFormatProtoT extends zzghi> void zzq(String string, Map<String, zzftr<KeyFormatProtoT>> object) {
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            zzg.put((String)entry.getKey(), zzftp.zzc((String)string, (byte[])((zzftr)entry.getValue()).zza.zzao(), (int)((zzftr)entry.getValue()).zzb));
        }
    }

    private static <P> zzftm<P> zzr(String object, Class<P> object2) throws GeneralSecurityException {
        Object object3 = zzfum.zzo((String)object);
        if (object3.zzd().contains(object2)) {
            return object3.zza(object2);
        }
        object = ((Class)object2).getName();
        object2 = String.valueOf(object3.zzc());
        Object object4 = object3.zzd();
        object3 = new StringBuilder();
        Iterator iterator = object4.iterator();
        boolean bl = true;
        while (true) {
            if (!iterator.hasNext()) {
                object3 = ((StringBuilder)object3).toString();
                object4 = new StringBuilder(String.valueOf(object).length() + 77 + String.valueOf(object2).length() + ((String)object3).length());
                ((StringBuilder)object4).append("Primitive type ");
                ((StringBuilder)object4).append((String)object);
                ((StringBuilder)object4).append(" not supported by key manager of type ");
                ((StringBuilder)object4).append((String)object2);
                ((StringBuilder)object4).append(", supported primitives: ");
                ((StringBuilder)object4).append((String)object3);
                object = new GeneralSecurityException(((StringBuilder)object4).toString());
                throw object;
            }
            object4 = (Class)iterator.next();
            if (!bl) {
                ((StringBuilder)object3).append(", ");
            }
            ((StringBuilder)object3).append(((Class)object4).getCanonicalName());
            bl = false;
        }
    }

    private static <P> P zzs(String string, zzgex zzgex2, Class<P> clazz) throws GeneralSecurityException {
        return (P)zzfum.zzr(string, clazz).zza(zzgex2);
    }
}
