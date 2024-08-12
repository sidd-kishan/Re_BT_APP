/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.app.Person
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

public static class Person.Builder {
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    CharSequence mName;
    String mUri;

    public Person.Builder() {
    }

    Person.Builder(Person person) {
        this.mName = person.mName;
        this.mIcon = person.mIcon;
        this.mUri = person.mUri;
        this.mKey = person.mKey;
        this.mIsBot = person.mIsBot;
        this.mIsImportant = person.mIsImportant;
    }

    public Person build() {
        return new Person(this);
    }

    public Person.Builder setBot(boolean bl) {
        this.mIsBot = bl;
        return this;
    }

    public Person.Builder setIcon(IconCompat iconCompat) {
        this.mIcon = iconCompat;
        return this;
    }

    public Person.Builder setImportant(boolean bl) {
        this.mIsImportant = bl;
        return this;
    }

    public Person.Builder setKey(String string) {
        this.mKey = string;
        return this;
    }

    public Person.Builder setName(CharSequence charSequence) {
        this.mName = charSequence;
        return this;
    }

    public Person.Builder setUri(String string) {
        this.mUri = string;
        return this;
    }
}
