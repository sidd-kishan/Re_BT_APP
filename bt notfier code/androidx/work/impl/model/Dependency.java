/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.model;

public class Dependency {
    public final String prerequisiteId;
    public final String workSpecId;

    public Dependency(String string, String string2) {
        this.workSpecId = string;
        this.prerequisiteId = string2;
    }
}
