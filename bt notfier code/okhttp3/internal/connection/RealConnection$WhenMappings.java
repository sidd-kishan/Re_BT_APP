/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package okhttp3.internal.connection;

import java.net.Proxy;
import kotlin.Metadata;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class RealConnection.WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[Proxy.Type.values().length];
        nArray[Proxy.Type.DIRECT.ordinal()] = 1;
        nArray[Proxy.Type.HTTP.ordinal()] = 2;
        $EnumSwitchMapping$0 = nArray;
    }
}
