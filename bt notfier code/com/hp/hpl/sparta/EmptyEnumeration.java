/*
 * Decompiled with CFR 0.152.
 */
package com.hp.hpl.sparta;

import java.util.Enumeration;
import java.util.NoSuchElementException;

class EmptyEnumeration
implements Enumeration {
    EmptyEnumeration() {
    }

    @Override
    public boolean hasMoreElements() {
        return false;
    }

    public Object nextElement() {
        throw new NoSuchElementException();
    }
}
