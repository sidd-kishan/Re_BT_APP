/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Sparta$Internment
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Sparta;
import java.util.Hashtable;

class Sparta$1
implements Sparta.Internment {
    private final Hashtable strings_ = new Hashtable();

    Sparta$1() {
    }

    public String intern(String string) {
        String string2 = (String)this.strings_.get(string);
        if (string2 != null) return string2;
        this.strings_.put(string, string);
        return string;
    }
}
