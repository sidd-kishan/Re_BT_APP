/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.XPathVisitor$BooleanStack$Item
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.XPathVisitor;

private static class XPathVisitor.BooleanStack {
    private Item top_ = null;

    private XPathVisitor.BooleanStack() {
    }

    Boolean pop() {
        Boolean bl = this.top_.bool;
        this.top_ = this.top_.prev;
        return bl;
    }

    void push(Boolean bl) {
        this.top_ = new Item(bl, this.top_);
    }
}
