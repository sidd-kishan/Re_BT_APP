/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.Android10Platform
 *  okhttp3.internal.platform.AndroidPlatform
 *  okhttp3.internal.platform.BouncyCastlePlatform
 *  okhttp3.internal.platform.ConscryptPlatform
 *  okhttp3.internal.platform.Jdk8WithJettyBootPlatform
 *  okhttp3.internal.platform.Jdk9Platform
 *  okhttp3.internal.platform.OpenJSSEPlatform
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.AndroidLog
 *  okio.Buffer
 */
package okhttp3.internal.platform;

import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Android10Platform;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Jdk8WithJettyBootPlatform;
import okhttp3.internal.platform.Jdk9Platform;
import okhttp3.internal.platform.OpenJSSEPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.AndroidLog;
import okio.Buffer;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lokhttp3/internal/platform/Platform$Companion;", "", "()V", "INFO", "", "WARN", "isAndroid", "", "()Z", "isBouncyCastlePreferred", "isConscryptPreferred", "isOpenJSSEPreferred", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "platform", "Lokhttp3/internal/platform/Platform;", "alpnProtocolNames", "", "", "protocols", "Lokhttp3/Protocol;", "concatLengthPrefixed", "", "findAndroidPlatform", "findJvmPlatform", "findPlatform", "get", "resetForTests", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Platform.Companion {
    private Platform.Companion() {
    }

    public /* synthetic */ Platform.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ Platform access$findPlatform(Platform.Companion companion) {
        return companion.findPlatform();
    }

    private final Platform findAndroidPlatform() {
        Platform platform;
        AndroidLog.INSTANCE.enable();
        Platform platform2 = platform = Android10Platform.Companion.buildIfSupported();
        if (platform != null) return platform2;
        platform2 = AndroidPlatform.Companion.buildIfSupported();
        Intrinsics.checkNotNull((Object)platform2);
        return platform2;
    }

    private final Platform findJvmPlatform() {
        ConscryptPlatform conscryptPlatform;
        if (this.isConscryptPreferred() && (conscryptPlatform = ConscryptPlatform.Companion.buildIfSupported()) != null) {
            return (Platform)conscryptPlatform;
        }
        if (this.isBouncyCastlePreferred() && (conscryptPlatform = BouncyCastlePlatform.Companion.buildIfSupported()) != null) {
            return (Platform)conscryptPlatform;
        }
        if (this.isOpenJSSEPreferred() && (conscryptPlatform = OpenJSSEPlatform.Companion.buildIfSupported()) != null) {
            return (Platform)conscryptPlatform;
        }
        conscryptPlatform = Jdk9Platform.Companion.buildIfSupported();
        if (conscryptPlatform != null) {
            return (Platform)conscryptPlatform;
        }
        conscryptPlatform = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
        if (conscryptPlatform == null) return new Platform();
        return conscryptPlatform;
    }

    private final Platform findPlatform() {
        Platform platform = this.isAndroid() ? this.findAndroidPlatform() : this.findJvmPlatform();
        return platform;
    }

    private final boolean isBouncyCastlePreferred() {
        return Intrinsics.areEqual((Object)"BC", (Object)Security.getProviders()[0].getName());
    }

    private final boolean isConscryptPreferred() {
        return Intrinsics.areEqual((Object)"Conscrypt", (Object)Security.getProviders()[0].getName());
    }

    private final boolean isOpenJSSEPreferred() {
        return Intrinsics.areEqual((Object)"OpenJSSE", (Object)Security.getProviders()[0].getName());
    }

    public static /* synthetic */ void resetForTests$default(Platform.Companion companion, Platform platform, int n, Object object) {
        if ((n & 1) != 0) {
            platform = companion.findPlatform();
        }
        companion.resetForTests(platform);
    }

    public final List<String> alpnProtocolNames(List<? extends Protocol> collection) {
        Intrinsics.checkNotNullParameter(collection, (String)"protocols");
        Object object = collection;
        collection = new ArrayList();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            boolean bl = (Protocol)object != Protocol.HTTP_1_0;
            if (!bl) continue;
            collection.add((Protocol)object);
        }
        object = collection;
        collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add((Protocol)((Protocol)object.next()).toString());
        }
        return collection;
    }

    public final byte[] concatLengthPrefixed(List<? extends Protocol> object) {
        Intrinsics.checkNotNullParameter(object, (String)"protocols");
        Buffer buffer = new Buffer();
        object = this.alpnProtocolNames((List<? extends Protocol>)object).iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            buffer.writeByte(string.length());
            buffer.writeUtf8(string);
        }
        return buffer.readByteArray();
    }

    @JvmStatic
    public final Platform get() {
        return Platform.access$getPlatform$cp();
    }

    public final boolean isAndroid() {
        return Intrinsics.areEqual((Object)"Dalvik", (Object)System.getProperty("java.vm.name"));
    }

    public final void resetForTests(Platform platform) {
        Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
        Platform.access$setPlatform$cp((Platform)platform);
    }
}
