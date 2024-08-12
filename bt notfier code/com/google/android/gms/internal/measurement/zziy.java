/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzho
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjt
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjt;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zziy {
    static String zza(zziw zziw2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string);
        zziy.zzc(zziw2, stringBuilder, 0);
        return stringBuilder.toString();
    }

    static final void zzb(StringBuilder stringBuilder, int n, String object, Object iterator) {
        int n2;
        if (iterator instanceof List) {
            iterator = ((List)((Object)iterator)).iterator();
            while (iterator.hasNext()) {
                zziy.zzb(stringBuilder, n, (String)object, iterator.next());
            }
            return;
        }
        if (iterator instanceof Map) {
            iterator = ((Map)((Object)iterator)).entrySet().iterator();
            while (iterator.hasNext()) {
                zziy.zzb(stringBuilder, n, (String)object, (Map.Entry)iterator.next());
            }
            return;
        }
        stringBuilder.append('\n');
        int n3 = 0;
        int n4 = 0;
        for (n2 = 0; n2 < n; ++n2) {
            stringBuilder.append(' ');
        }
        stringBuilder.append((String)object);
        if (iterator instanceof String) {
            stringBuilder.append(": \"");
            stringBuilder.append(zzjt.zza((zzgr)zzgr.zzk((String)((String)((Object)iterator)))));
            stringBuilder.append('\"');
            return;
        }
        if (iterator instanceof zzgr) {
            stringBuilder.append(": \"");
            stringBuilder.append(zzjt.zza((zzgr)((zzgr)iterator)));
            stringBuilder.append('\"');
            return;
        }
        if (iterator instanceof zzhr) {
            stringBuilder.append(" {");
            zziy.zzc((zziw)((zzhr)iterator), stringBuilder, n + 2);
            stringBuilder.append("\n");
            n2 = n4;
            while (true) {
                if (n2 >= n) {
                    stringBuilder.append("}");
                    return;
                }
                stringBuilder.append(' ');
                ++n2;
            }
        }
        if (!(iterator instanceof Map.Entry)) {
            stringBuilder.append(": ");
            stringBuilder.append(iterator.toString());
            return;
        }
        stringBuilder.append(" {");
        object = (Map.Entry)((Object)iterator);
        n2 = n + 2;
        zziy.zzb(stringBuilder, n2, "key", object.getKey());
        zziy.zzb(stringBuilder, n2, "value", object.getValue());
        stringBuilder.append("\n");
        n2 = n3;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append("}");
                return;
            }
            stringBuilder.append(' ');
            ++n2;
        }
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private static void zzc(zziw var0, StringBuilder var1_1, int var2_2) {
        var9_3 = new HashMap<String, Object>();
        var10_4 = new HashMap<String, Method>();
        var7_5 = new TreeSet<String>();
        for (Object var6_9 : var0.getClass().getDeclaredMethods()) {
            var10_4.put(var6_9.getName(), (Method)var6_9);
            if (var6_9.getParameterTypes().length != 0) continue;
            var9_3.put(var6_9.getName(), var6_9);
            if (!var6_9.getName().startsWith("get")) continue;
            var7_5.add(var6_9.getName());
        }
        var11_10 = var7_5.iterator();
        while (var11_10.hasNext()) {
            block11: {
                block9: {
                    block15: {
                        block14: {
                            block13: {
                                block12: {
                                    block10: {
                                        var8_6 = (String)var11_10.next();
                                        var6_9 = var8_6.startsWith("get") != false ? var8_6.substring(3) : var8_6;
                                        if (var6_9.endsWith("List") && !var6_9.endsWith("OrBuilderList") && !var6_9.equals("List")) {
                                            var7_5 = String.valueOf(var6_9.substring(0, 1).toLowerCase());
                                            var12_12 = String.valueOf(var6_9.substring(1, var6_9.length() - 4));
                                            var7_5 = var12_12.length() != 0 ? var7_5.concat((String)var12_12) : new String((String)var7_5);
                                            var12_12 = (Method)var9_3.get(var8_6);
                                            if (var12_12 != null && var12_12.getReturnType().equals(List.class)) {
                                                zziy.zzb(var1_1, var2_2, zziy.zzd((String)var7_5), zzhr.zzbA((Method)var12_12, (Object)var0, (Object[])new Object[0]));
                                                continue;
                                            }
                                        }
                                        if (var6_9.endsWith("Map") && !var6_9.equals("Map")) {
                                            var7_5 = String.valueOf(var6_9.substring(0, 1).toLowerCase());
                                            var12_12 = String.valueOf(var6_9.substring(1, var6_9.length() - 3));
                                            var7_5 = var12_12.length() != 0 ? var7_5.concat((String)var12_12) : new String((String)var7_5);
                                            if ((var8_6 = (Method)var9_3.get(var8_6)) != null && var8_6.getReturnType().equals(Map.class) && !var8_6.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(var8_6.getModifiers())) {
                                                zziy.zzb(var1_1, var2_2, zziy.zzd((String)var7_5), zzhr.zzbA((Method)var8_6, (Object)var0, (Object[])new Object[0]));
                                                continue;
                                            }
                                        }
                                        if ((Method)var10_4.get(var7_5 = (var7_5 = String.valueOf(var6_9)).length() != 0 ? "set".concat((String)var7_5) : new String("set")) == null || var6_9.endsWith("Bytes") && var9_3.containsKey(var7_5 = (var7_5 = String.valueOf(var6_9.substring(0, var6_9.length() - 5))).length() != 0 ? "get".concat((String)var7_5) : new String("get"))) continue;
                                        var7_5 = String.valueOf(var6_9.substring(0, 1).toLowerCase());
                                        var8_6 = String.valueOf(var6_9.substring(1));
                                        var7_5 = var8_6.length() != 0 ? var7_5.concat((String)var8_6) : new String((String)var7_5);
                                        var8_6 = String.valueOf(var6_9);
                                        var8_6 = var8_6.length() != 0 ? "get".concat((String)var8_6) : new String("get");
                                        var8_6 = (Method)var9_3.get(var8_6);
                                        var6_9 = String.valueOf(var6_9);
                                        var6_9 = var6_9.length() != 0 ? "has".concat((String)var6_9) : new String("has");
                                        var6_9 = (Method)var9_3.get(var6_9);
                                        if (var8_6 == null) continue;
                                        var8_6 = zzhr.zzbA((Method)var8_6, (Object)var0, (Object[])new Object[0]);
                                        if (var6_9 != null) break block9;
                                        if (!(var8_6 instanceof Boolean)) break block10;
                                        if (!((Boolean)var8_6).booleanValue()) continue;
                                        break block11;
                                    }
                                    if (!(var8_6 instanceof Integer)) break block12;
                                    if ((Integer)var8_6 == 0) continue;
                                    break block11;
                                }
                                if (!(var8_6 instanceof Float)) break block13;
                                if (((Float)var8_6).floatValue() == 0.0f) continue;
                                break block11;
                            }
                            if (!(var8_6 instanceof Double)) break block14;
                            if ((Double)var8_6 == 0.0) continue;
                            break block11;
                        }
                        if (!(var8_6 instanceof String)) break block15;
                        var5_11 = var8_6.equals("");
                        ** GOTO lbl68
                    }
                    if (var8_6 instanceof zzgr) {
                        var5_11 = var8_6.equals(zzgr.zzb);
lbl68:
                        // 2 sources

                        if (var5_11) continue;
                    } else if (!(var8_6 instanceof zziw != false ? var8_6 != ((zziw)var8_6).zzbK() : var8_6 instanceof Enum == false || ((Enum)var8_6).ordinal() != 0)) continue;
                    break block11;
                }
                if (!((Boolean)zzhr.zzbA((Method)var6_9, (Object)var0, (Object[])new Object[0])).booleanValue()) continue;
            }
            zziy.zzb(var1_1, var2_2, zziy.zzd((String)var7_5), var8_6);
        }
        if (!(var0 instanceof zzho)) {
            var0 = ((zzhr)var0).zzc;
            if (var0 == null) return;
            var0.zzg(var1_1, var2_2);
            return;
        }
        var0 = ((zzho)var0).zza;
        throw null;
    }

    private static final String zzd(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while (n < string.length()) {
            char c = string.charAt(n);
            if (Character.isUpperCase(c)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(c));
            ++n;
        }
        return stringBuilder.toString();
    }
}
