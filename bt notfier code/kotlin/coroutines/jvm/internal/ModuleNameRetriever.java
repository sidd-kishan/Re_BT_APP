/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.jvm.internal.BaseContinuationImpl
 *  kotlin.coroutines.jvm.internal.ModuleNameRetriever$Cache
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ModuleNameRetriever;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class ModuleNameRetriever {
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    private static Cache cache;
    private static final Cache notOnJava9;

    static {
        notOnJava9 = new Cache(null, null, null);
    }

    private ModuleNameRetriever() {
    }

    private final Cache buildCache(BaseContinuationImpl object) {
        try {
            Cache cache;
            Method method = Class.class.getDeclaredMethod("getModule", new Class[0]);
            Method method2 = object.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]);
            object = object.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]);
            ModuleNameRetriever.cache = cache = new Cache(method, method2, (Method)object);
            return cache;
        }
        catch (Exception exception) {
            Cache cache;
            ModuleNameRetriever.cache = cache = notOnJava9;
            return cache;
        }
    }

    public final String getModuleName(BaseContinuationImpl object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"continuation");
        Object object2 = cache;
        if (object2 == null) {
            object2 = this.buildCache((BaseContinuationImpl)object);
        }
        Object object3 = notOnJava9;
        Object var5_4 = null;
        Object var4_5 = null;
        if (object2 == object3) {
            return null;
        }
        Object object4 = ((Cache)object2).getModuleMethod;
        object3 = var5_4;
        if (object4 == null) return object3;
        object4 = ((Method)object4).invoke(object.getClass(), new Object[0]);
        object3 = var5_4;
        if (object4 == null) return object3;
        object = ((Cache)object2).getDescriptorMethod;
        object3 = var5_4;
        if (object == null) return object3;
        object = ((Method)object).invoke(object4, new Object[0]);
        object3 = var5_4;
        if (object == null) return object3;
        object2 = ((Cache)object2).nameMethod;
        object = object2 != null ? ((Method)object2).invoke(object, new Object[0]) : null;
        if (!(object instanceof String)) {
            object = var4_5;
        }
        object3 = (String)object;
        return object3;
    }
}
