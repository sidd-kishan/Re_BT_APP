/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0002\u00a2\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private static final class Jdk8WithJettyBootPlatform.AlpnProvider
implements InvocationHandler {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;

    public Jdk8WithJettyBootPlatform.AlpnProvider(List<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"protocols");
        this.protocols = list;
    }

    public final String getSelected() {
        return this.selected;
    }

    public final boolean getUnsupported() {
        return this.unsupported;
    }

    @Override
    public Object invoke(Object object, Method object2, Object[] object3) throws Throwable {
        block8: {
            int n;
            int n2;
            block10: {
                block9: {
                    Intrinsics.checkNotNullParameter((Object)object, (String)"proxy");
                    Intrinsics.checkNotNullParameter((Object)object2, (String)"method");
                    object = object3;
                    if (object3 == null) {
                        object = new Object[]{};
                    }
                    object3 = ((Method)object2).getName();
                    Class<?> clazz = ((Method)object2).getReturnType();
                    if (Intrinsics.areEqual((Object)object3, (Object)"supports") && Intrinsics.areEqual(Boolean.TYPE, clazz)) {
                        return true;
                    }
                    if (Intrinsics.areEqual((Object)object3, (Object)"unsupported") && Intrinsics.areEqual(Void.TYPE, clazz)) {
                        this.unsupported = true;
                        return null;
                    }
                    if (Intrinsics.areEqual((Object)object3, (Object)"protocols") && (n2 = ((Object[])object).length == 0 ? 1 : 0) != 0) {
                        return this.protocols;
                    }
                    if (!Intrinsics.areEqual((Object)object3, (Object)"selectProtocol") && !Intrinsics.areEqual((Object)object3, (Object)"select") || !Intrinsics.areEqual(String.class, clazz) || ((Object[])object).length != 1 || !(object[0] instanceof List)) break block9;
                    if ((object = object[0]) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    n = (object = (List)object).size();
                    if (n < 0) break block8;
                    break block10;
                }
                if (!Intrinsics.areEqual((Object)object3, (Object)"protocolSelected")) {
                    if (!Intrinsics.areEqual((Object)object3, (Object)"selected")) return ((Method)object2).invoke(this, Arrays.copyOf(object, ((Object[])object).length));
                }
                if (((Object[])object).length != 1) return ((Method)object2).invoke(this, Arrays.copyOf(object, ((Object[])object).length));
                if ((object = object[0]) == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                this.selected = (String)object;
                return null;
            }
            n2 = 0;
            while ((object2 = object.get(n2)) != null) {
                if (this.protocols.contains(object2 = (String)object2)) {
                    this.selected = object2;
                    return object2;
                }
                if (n2 != n) {
                    ++n2;
                    continue;
                }
                break block8;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        this.selected = object = this.protocols.get(0);
        return object;
    }

    public final void setSelected(String string) {
        this.selected = string;
    }

    public final void setUnsupported(boolean bl) {
        this.unsupported = bl;
    }
}
