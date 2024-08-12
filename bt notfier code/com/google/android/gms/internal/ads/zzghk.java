/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzgim
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzgim;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zzghk {
    static String zza(zzghi zzghi2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ");
        stringBuilder.append(string);
        zzghk.zzc(zzghi2, stringBuilder, 0);
        return stringBuilder.toString();
    }

    static final void zzb(StringBuilder stringBuilder, int n, String object, Object iterator) {
        int n2;
        if (iterator instanceof List) {
            iterator = ((List)((Object)iterator)).iterator();
            while (iterator.hasNext()) {
                zzghk.zzb(stringBuilder, n, (String)object, iterator.next());
            }
            return;
        }
        if (iterator instanceof Map) {
            iterator = ((Map)((Object)iterator)).entrySet().iterator();
            while (iterator.hasNext()) {
                zzghk.zzb(stringBuilder, n, (String)object, (Map.Entry)iterator.next());
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
            stringBuilder.append(zzgim.zza((zzgex)zzgex.zzv((String)((String)((Object)iterator)))));
            stringBuilder.append('\"');
            return;
        }
        if (iterator instanceof zzgex) {
            stringBuilder.append(": \"");
            stringBuilder.append(zzgim.zza((zzgex)((zzgex)iterator)));
            stringBuilder.append('\"');
            return;
        }
        if (iterator instanceof zzgga) {
            stringBuilder.append(" {");
            zzghk.zzc((zzghi)((zzgga)iterator), stringBuilder, n + 2);
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
        zzghk.zzb(stringBuilder, n2, "key", object.getKey());
        zzghk.zzb(stringBuilder, n2, "value", object.getValue());
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
    private static void zzc(zzghi var0, StringBuilder var1_1, int var2_2) {
        var9_3 = new HashMap<String, Method>();
        var10_4 = new HashMap<String, Method>();
        var8_5 = new TreeSet<E>();
        for (Object var7_9 : var0.getClass().getDeclaredMethods()) {
            var10_4.put(var7_9.getName(), (Method)var7_9);
            if (var7_9.getParameterTypes().length != 0) continue;
            var9_3.put(var7_9.getName(), (Method)var7_9);
            if (!var7_9.getName().startsWith("get")) continue;
            var8_5.add(var7_9.getName());
        }
        var11_10 = var8_5.iterator();
        while (var11_10.hasNext()) {
            block11: {
                block9: {
                    block15: {
                        block14: {
                            block13: {
                                block12: {
                                    block10: {
                                        var8_5 = (String)var11_10.next();
                                        var6_6 = var8_5.startsWith("get") != false ? var8_5.substring(3) : var8_5;
                                        if (var6_6.endsWith("List") && !var6_6.endsWith("OrBuilderList") && !var6_6.equals("List")) {
                                            var12_12 = String.valueOf(var6_6.substring(0, 1).toLowerCase());
                                            var7_9 = String.valueOf(var6_6.substring(1, var6_6.length() - 4));
                                            var7_9 = var7_9.length() != 0 ? var12_12.concat((String)var7_9) : new String((String)var12_12);
                                            var12_12 = (Method)var9_3.get(var8_5);
                                            if (var12_12 != null && var12_12.getReturnType().equals(List.class)) {
                                                zzghk.zzb(var1_1, var2_2, zzghk.zzd((String)var7_9), zzgga.zzaA((Method)var12_12, (Object)var0, (Object[])new Object[0]));
                                                continue;
                                            }
                                        }
                                        if (var6_6.endsWith("Map") && !var6_6.equals("Map")) {
                                            var7_9 = String.valueOf(var6_6.substring(0, 1).toLowerCase());
                                            var12_12 = String.valueOf(var6_6.substring(1, var6_6.length() - 3));
                                            var7_9 = var12_12.length() != 0 ? var7_9.concat((String)var12_12) : new String((String)var7_9);
                                            if ((var8_5 = (Method)var9_3.get(var8_5)) != null && var8_5.getReturnType().equals(Map.class) && !var8_5.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(var8_5.getModifiers())) {
                                                zzghk.zzb(var1_1, var2_2, zzghk.zzd((String)var7_9), zzgga.zzaA((Method)var8_5, (Object)var0, (Object[])new Object[0]));
                                                continue;
                                            }
                                        }
                                        if ((Method)var10_4.get(var7_9 = (var7_9 = String.valueOf(var6_6)).length() != 0 ? "set".concat((String)var7_9) : new String("set")) == null || var6_6.endsWith("Bytes") && var9_3.containsKey(var7_9 = (var7_9 = String.valueOf(var6_6.substring(0, var6_6.length() - 5))).length() != 0 ? "get".concat((String)var7_9) : new String("get"))) continue;
                                        var7_9 = String.valueOf(var6_6.substring(0, 1).toLowerCase());
                                        var8_5 = String.valueOf(var6_6.substring(1));
                                        var7_9 = var8_5.length() != 0 ? var7_9.concat((String)var8_5) : new String((String)var7_9);
                                        var8_5 = String.valueOf(var6_6);
                                        var8_5 = var8_5.length() != 0 ? "get".concat((String)var8_5) : new String("get");
                                        var8_5 = (Method)var9_3.get(var8_5);
                                        var6_6 = String.valueOf(var6_6);
                                        var6_6 = var6_6.length() != 0 ? "has".concat((String)var6_6) : new String("has");
                                        var6_6 = (Method)var9_3.get(var6_6);
                                        if (var8_5 == null) continue;
                                        var8_5 = zzgga.zzaA((Method)var8_5, (Object)var0, (Object[])new Object[0]);
                                        if (var6_6 != null) break block9;
                                        if (!(var8_5 instanceof Boolean)) break block10;
                                        if (!((Boolean)var8_5).booleanValue()) continue;
                                        break block11;
                                    }
                                    if (!(var8_5 instanceof Integer)) break block12;
                                    if ((Integer)var8_5 == 0) continue;
                                    break block11;
                                }
                                if (!(var8_5 instanceof Float)) break block13;
                                if (((Float)var8_5).floatValue() == 0.0f) continue;
                                break block11;
                            }
                            if (!(var8_5 instanceof Double)) break block14;
                            if ((Double)var8_5 == 0.0) continue;
                            break block11;
                        }
                        if (!(var8_5 instanceof String)) break block15;
                        var5_11 = var8_5.equals("");
                        ** GOTO lbl68
                    }
                    if (var8_5 instanceof zzgex) {
                        var5_11 = var8_5.equals(zzgex.zzb);
lbl68:
                        // 2 sources

                        if (var5_11) continue;
                    } else if (!(var8_5 instanceof zzghi != false ? var8_5 != ((zzghi)var8_5).zzbe() : var8_5 instanceof Enum == false || ((Enum)var8_5).ordinal() != 0)) continue;
                    break block11;
                }
                if (!((Boolean)zzgga.zzaA((Method)var6_6, (Object)var0, (Object[])new Object[0])).booleanValue()) continue;
            }
            zzghk.zzb(var1_1, var2_2, zzghk.zzd((String)var7_9), var8_5);
        }
        if (!(var0 instanceof zzgfx)) {
            var0 = ((zzgga)var0).zzc;
            if (var0 == null) return;
            var0.zzg(var1_1, var2_2);
            return;
        }
        var0 = ((zzgfx)var0).zzb;
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
