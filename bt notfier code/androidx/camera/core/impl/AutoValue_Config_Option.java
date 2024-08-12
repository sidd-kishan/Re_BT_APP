/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config$Option
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

final class AutoValue_Config_Option<T>
extends Config.Option<T> {
    private final String id;
    private final Object token;
    private final Class<T> valueClass;

    AutoValue_Config_Option(String string, Class<T> clazz, Object object) {
        if (string == null) throw new NullPointerException("Null id");
        this.id = string;
        if (clazz == null) throw new NullPointerException("Null valueClass");
        this.valueClass = clazz;
        this.token = object;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof Config.Option)) return false;
        Config.Option option = (Config.Option)object;
        if (this.id.equals(option.getId()) && this.valueClass.equals(option.getValueClass()) && ((object = this.token) == null ? option.getToken() == null : object.equals(option.getToken()))) return bl;
        bl = false;
        return bl;
    }

    public String getId() {
        return this.id;
    }

    public Object getToken() {
        return this.token;
    }

    public Class<T> getValueClass() {
        return this.valueClass;
    }

    public int hashCode() {
        int n = this.id.hashCode();
        int n2 = this.valueClass.hashCode();
        Object object = this.token;
        int n3 = object == null ? 0 : object.hashCode();
        return ((n ^ 0xF4243) * 1000003 ^ n2) * 1000003 ^ n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", valueClass=");
        stringBuilder.append(this.valueClass);
        stringBuilder.append(", token=");
        stringBuilder.append(this.token);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
