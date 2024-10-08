/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinVersion$Companion
 *  kotlin.KotlinVersionCurrentValue
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import kotlin.KotlinVersion;
import kotlin.KotlinVersionCurrentValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class KotlinVersion
implements Comparable<KotlinVersion> {
    public static final KotlinVersion CURRENT;
    public static final Companion Companion;
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    static {
        Companion = new Companion(null);
        CURRENT = KotlinVersionCurrentValue.get();
    }

    public KotlinVersion(int n, int n2) {
        this(n, n2, 0);
    }

    public KotlinVersion(int n, int n2, int n3) {
        this.major = n;
        this.minor = n2;
        this.patch = n3;
        this.version = this.versionOf(n, n2, n3);
    }

    private final int versionOf(int n, int n2, int n3) {
        boolean bl = n >= 0 && 255 >= n && n2 >= 0 && 255 >= n2 && n3 >= 0 && 255 >= n3;
        if (bl) {
            return (n << 16) + (n2 << 8) + n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Version components are out of range: ");
        stringBuilder.append(n);
        stringBuilder.append('.');
        stringBuilder.append(n2);
        stringBuilder.append('.');
        stringBuilder.append(n3);
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
    }

    @Override
    public int compareTo(KotlinVersion kotlinVersion) {
        Intrinsics.checkNotNullParameter((Object)kotlinVersion, (String)"other");
        return this.version - kotlinVersion.version;
    }

    public boolean equals(Object object) {
        Object object2 = this;
        boolean bl = true;
        if (object2 == object) {
            return true;
        }
        object2 = object;
        if (!(object instanceof KotlinVersion)) {
            object2 = null;
        }
        if ((object = (KotlinVersion)object2) == null) return false;
        if (this.version == ((KotlinVersion)object).version) return bl;
        bl = false;
        return bl;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return this.version;
    }

    public final boolean isAtLeast(int n, int n2) {
        int n3 = this.major;
        boolean bl = n3 > n || n3 == n && this.minor >= n2;
        return bl;
    }

    public final boolean isAtLeast(int n, int n2, int n3) {
        int n4 = this.major;
        boolean bl = n4 > n || n4 == n && ((n = this.minor) > n2 || n == n2 && this.patch >= n3);
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.major);
        stringBuilder.append('.');
        stringBuilder.append(this.minor);
        stringBuilder.append('.');
        stringBuilder.append(this.patch);
        return stringBuilder.toString();
    }
}
