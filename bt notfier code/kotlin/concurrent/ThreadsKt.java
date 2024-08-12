/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0014"}, d2={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class ThreadsKt {
    private static final <T> T getOrSet(ThreadLocal<T> threadLocal, Function0<? extends T> object) {
        T t = threadLocal.get();
        if (t != null) {
            threadLocal = t;
        } else {
            object = object.invoke();
            threadLocal.set((Function0<? extends T>)object);
            threadLocal = object;
        }
        return (T)threadLocal;
    }

    public static final Thread thread(boolean bl, boolean bl2, ClassLoader classLoader, String string, int n, Function0<Unit> var5_5) {
        Intrinsics.checkNotNullParameter(var5_5, (String)"block");
        var5_5 = new /* Unavailable Anonymous Inner Class!! */;
        if (bl2) {
            var5_5.setDaemon(true);
        }
        if (n > 0) {
            var5_5.setPriority(n);
        }
        if (string != null) {
            var5_5.setName(string);
        }
        if (classLoader != null) {
            var5_5.setContextClassLoader(classLoader);
        }
        if (!bl) return (Thread)var5_5;
        var5_5.start();
        return (Thread)var5_5;
    }

    public static /* synthetic */ Thread thread$default(boolean bl, boolean bl2, ClassLoader classLoader, String string, int n, Function0 function0, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = true;
        }
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        if ((n2 & 4) != 0) {
            classLoader = null;
        }
        if ((n2 & 8) != 0) {
            string = null;
        }
        if ((n2 & 0x10) == 0) return ThreadsKt.thread(bl, bl2, classLoader, string, n, (Function0<Unit>)function0);
        n = -1;
        return ThreadsKt.thread(bl, bl2, classLoader, string, n, (Function0<Unit>)function0);
    }
}
