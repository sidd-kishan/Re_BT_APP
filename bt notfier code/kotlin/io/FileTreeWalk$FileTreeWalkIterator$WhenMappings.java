/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.FileWalkDirection
 */
package kotlin.io;

import kotlin.Metadata;
import kotlin.io.FileWalkDirection;

@Metadata(k=3, mv={1, 5, 1})
public final class FileTreeWalk$FileTreeWalkIterator$WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    static {
        int[] nArray = new int[FileWalkDirection.values().length];
        $EnumSwitchMapping$0 = nArray;
        nArray[FileWalkDirection.TOP_DOWN.ordinal()] = 1;
        FileTreeWalk$FileTreeWalkIterator$WhenMappings.$EnumSwitchMapping$0[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
    }
}
