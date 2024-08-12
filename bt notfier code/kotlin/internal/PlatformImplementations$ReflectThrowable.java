/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class PlatformImplementations.ReflectThrowable {
    public static final PlatformImplementations.ReflectThrowable INSTANCE;
    public static final Method addSuppressed;
    public static final Method getSuppressed;

    /*
     * Unable to fully structure code
     */
    static {
        block5: {
            PlatformImplementations.ReflectThrowable.INSTANCE = new PlatformImplementations.ReflectThrowable();
            var6 = Throwable.class.getMethods();
            Intrinsics.checkNotNullExpressionValue((Object)var6, (String)"throwableMethods");
            var3_1 = var6.length;
            var2_2 = 0;
            var0_3 = 0;
            while (true) {
                var5_6 = null;
                if (var0_3 >= var3_1) break;
                var4_5 = var6[var0_3];
                Intrinsics.checkNotNullExpressionValue((Object)var4_5, (String)"it");
                if (!Intrinsics.areEqual((Object)var4_5.getName(), (Object)"addSuppressed")) ** GOTO lbl-1000
                var7_7 = var4_5.getParameterTypes();
                Intrinsics.checkNotNullExpressionValue(var7_7, (String)"it.parameterTypes");
                if (Intrinsics.areEqual((Object)((Class)ArraysKt.singleOrNull((Object[])var7_7)), Throwable.class)) {
                    var1_4 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var1_4 = 0;
                }
                if (var1_4 == 0) {
                    ++var0_3;
                    continue;
                }
                break block5;
                break;
            }
            var4_5 = null;
        }
        PlatformImplementations.ReflectThrowable.addSuppressed = var4_5;
        var1_4 = var6.length;
        var0_3 = var2_2;
        while (true) {
            var4_5 = var5_6;
            if (var0_3 >= var1_4) break;
            var4_5 = var6[var0_3];
            Intrinsics.checkNotNullExpressionValue((Object)var4_5, (String)"it");
            if (Intrinsics.areEqual((Object)var4_5.getName(), (Object)"getSuppressed")) break;
            ++var0_3;
        }
        PlatformImplementations.ReflectThrowable.getSuppressed = var4_5;
    }

    private PlatformImplementations.ReflectThrowable() {
    }
}
