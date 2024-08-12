/*
 * Decompiled with CFR 0.152.
 */
package com.hp.hpl.sparta;

private static class XPathVisitor.BooleanStack.Item {
    final Boolean bool;
    final XPathVisitor.BooleanStack.Item prev;

    XPathVisitor.BooleanStack.Item(Boolean bl, XPathVisitor.BooleanStack.Item item) {
        this.bool = bl;
        this.prev = item;
    }
}
