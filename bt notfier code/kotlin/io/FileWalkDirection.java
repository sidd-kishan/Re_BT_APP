/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin.io;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/io/FileWalkDirection;", "", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class FileWalkDirection
extends Enum<FileWalkDirection> {
    private static final FileWalkDirection[] $VALUES;
    public static final /* enum */ FileWalkDirection BOTTOM_UP;
    public static final /* enum */ FileWalkDirection TOP_DOWN;

    static {
        FileWalkDirection fileWalkDirection;
        FileWalkDirection fileWalkDirection2;
        TOP_DOWN = fileWalkDirection2 = new FileWalkDirection();
        BOTTOM_UP = fileWalkDirection = new FileWalkDirection();
        $VALUES = new FileWalkDirection[]{fileWalkDirection2, fileWalkDirection};
    }

    public static FileWalkDirection valueOf(String string) {
        return Enum.valueOf(FileWalkDirection.class, string);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[])$VALUES.clone();
    }
}
