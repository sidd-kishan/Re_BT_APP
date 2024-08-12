/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinVersion
 *  kotlin.Metadata
 *  kotlin.internal.PlatformImplementations
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 */
package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b\u00a2\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static {
        block21: {
            var0 = PlatformImplementationsKt.getJavaVersion();
            if (var0 < 65544) break block21;
            try {
                block17: {
                    block22: {
                        var2_1 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(var2_1, (String)"Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                        if (var2_1 == null) break block22;
                        try {
                            var1_5 = (PlatformImplementations)var2_1;
                            ** GOTO lbl125
                        }
                        catch (ClassCastException var1_6) {
                            break block17;
                        }
                    }
                    var1_7 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    throw var1_7;
                }
                var5_22 = var2_1.getClass().getClassLoader();
                var3_26 = PlatformImplementations.class.getClassLoader();
                var2_1 = new StringBuilder();
                var2_1.append("Instance classloader: ");
                var2_1.append(var5_22);
                var2_1.append(", base type classloader: ");
                var2_1.append(var3_26);
                var4_30 = new ClassCastException(var2_1.toString());
                var1_8 = var4_30.initCause(var1_6);
                Intrinsics.checkNotNullExpressionValue((Object)var1_8, (String)"ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                throw var1_8;
            }
            catch (ClassNotFoundException var1_9) {
                try {
                    block18: {
                        block23: {
                            var2_2 /* !! */  = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                            Intrinsics.checkNotNullExpressionValue(var2_2 /* !! */ , (String)"Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                            if (var2_2 /* !! */  == null) break block23;
                            try {
                                var1_5 = (PlatformImplementations)var2_2 /* !! */ ;
                                ** GOTO lbl125
                            }
                            catch (ClassCastException var1_10) {
                                break block18;
                            }
                        }
                        var1_11 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        throw var1_11;
                    }
                    var2_2 /* !! */  = var2_2 /* !! */ .getClass().getClassLoader();
                    var5_23 = PlatformImplementations.class.getClassLoader();
                    var3_27 = new StringBuilder();
                    var3_27.append("Instance classloader: ");
                    var3_27.append(var2_2 /* !! */ );
                    var3_27.append(", base type classloader: ");
                    var3_27.append(var5_23);
                    var4_31 = new ClassCastException(var3_27.toString());
                    var1_12 = var4_31.initCause(var1_10);
                    Intrinsics.checkNotNullExpressionValue((Object)var1_12, (String)"ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                    throw var1_12;
                }
                catch (ClassNotFoundException var1_13) {
                    // empty catch block
                }
            }
        }
        if (var0 < 65543) ** GOTO lbl123
        try {
            block19: {
                block24: {
                    var2_3 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(var2_3, (String)"Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                    if (var2_3 == null) break block24;
                    try {
                        var1_5 = (PlatformImplementations)var2_3;
                        ** GOTO lbl125
                    }
                    catch (ClassCastException var1_14) {
                        break block19;
                    }
                }
                var1_15 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                throw var1_15;
            }
            var5_24 = var2_3.getClass().getClassLoader();
            var3_28 = PlatformImplementations.class.getClassLoader();
            var2_3 = new StringBuilder();
            var2_3.append("Instance classloader: ");
            var2_3.append(var5_24);
            var2_3.append(", base type classloader: ");
            var2_3.append(var3_28);
            var4_32 = new ClassCastException(var2_3.toString());
            var1_16 = var4_32.initCause(var1_14);
            Intrinsics.checkNotNullExpressionValue((Object)var1_16, (String)"ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
            throw var1_16;
        }
        catch (ClassNotFoundException var1_17) {
            try {
                block20: {
                    block25: {
                        var2_4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(var2_4, (String)"Class.forName(\"kotlin.in\u2026entations\").newInstance()");
                        if (var2_4 == null) break block25;
                        try {
                            var1_5 = (PlatformImplementations)var2_4;
                            ** GOTO lbl125
                        }
                        catch (ClassCastException var1_18) {
                            break block20;
                        }
                    }
                    var1_19 = new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    throw var1_19;
                }
                var5_25 = var2_4.getClass().getClassLoader();
                var4_33 = PlatformImplementations.class.getClassLoader();
                var2_4 = new StringBuilder();
                var2_4.append("Instance classloader: ");
                var2_4.append(var5_25);
                var2_4.append(", base type classloader: ");
                var2_4.append(var4_33);
                var3_29 = new ClassCastException(var2_4.toString());
                var1_20 = var3_29.initCause(var1_18);
                Intrinsics.checkNotNullExpressionValue((Object)var1_20, (String)"ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
                throw var1_20;
            }
            catch (ClassNotFoundException var1_21) {
                ** continue;
            }
lbl123:
            // 2 sources

            while (true) {
                var1_5 = new PlatformImplementations();
lbl125:
                // 5 sources

                PlatformImplementationsKt.IMPLEMENTATIONS = var1_5;
                return;
            }
        }
    }

    public static final boolean apiVersionIsAtLeast(int n, int n2, int n3) {
        return KotlinVersion.CURRENT.isAtLeast(n, n2, n3);
    }

    private static final /* synthetic */ <T> T castToBaseType(Object object) {
        Object object2;
        try {
            Intrinsics.reifiedOperationMarker((int)1, (String)"T");
            object2 = object;
        }
        catch (ClassCastException classCastException) {
            object = object.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
            ClassLoader classLoader = Object.class.getClassLoader();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Instance classloader: ");
            stringBuilder.append(object);
            stringBuilder.append(", base type classloader: ");
            stringBuilder.append(classLoader);
            object = new ClassCastException(stringBuilder.toString()).initCause(classCastException);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
            throw object;
        }
        return (T)object2;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     */
    private static final int getJavaVersion() {
        int n;
        int n2;
        CharSequence charSequence;
        String string;
        block6: {
            string = System.getProperty("java.specification.version");
            int n3 = 65542;
            if (string == null) return 65542;
            charSequence = string;
            int n4 = StringsKt.indexOf$default((CharSequence)charSequence, (char)'.', (int)0, (boolean)false, (int)6, null);
            if (n4 < 0) {
                int n5 = Integer.parseInt(string);
                return n5 * 65536;
            }
            int n6 = n4 + 1;
            n = n2 = StringsKt.indexOf$default((CharSequence)charSequence, (char)'.', (int)n6, (boolean)false, (int)4, null);
            if (n2 < 0) {
                n = string.length();
            }
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            charSequence = string.substring(0, n4);
            Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            string = string.substring(n6, n);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            try {}
            catch (NumberFormatException numberFormatException) {
                return n3;
            }
            break block6;
            catch (NumberFormatException numberFormatException) {
                return n3;
            }
        }
        n2 = Integer.parseInt((String)charSequence);
        n = Integer.parseInt(string);
        return n2 * 65536 + n;
    }
}
