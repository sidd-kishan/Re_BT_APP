/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Node
 */
package com.hp.hpl.sparta;

import com.hp.hpl.sparta.Node;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class NodeListWithPosition {
    private static final Integer EIGHT;
    private static final Integer FIVE;
    private static final Integer FOUR;
    private static final Integer NINE;
    private static final Integer ONE;
    private static final Integer SEVEN;
    private static final Integer SIX;
    private static final Integer TEN;
    private static final Integer THREE;
    private static final Integer TWO;
    private Hashtable positions_;
    private final Vector vector_ = new Vector();

    static {
        ONE = new Integer(1);
        TWO = new Integer(2);
        THREE = new Integer(3);
        FOUR = new Integer(4);
        FIVE = new Integer(5);
        SIX = new Integer(6);
        SEVEN = new Integer(7);
        EIGHT = new Integer(8);
        NINE = new Integer(9);
        TEN = new Integer(10);
    }

    NodeListWithPosition() {
        this.positions_ = new Hashtable();
    }

    private static Integer identity(Node node) {
        return new Integer(System.identityHashCode(node));
    }

    void add(Node node, int n) {
        Integer n2;
        this.vector_.addElement(node);
        switch (n) {
            default: {
                n2 = new Integer(n);
                break;
            }
            case 10: {
                n2 = TEN;
                break;
            }
            case 9: {
                n2 = NINE;
                break;
            }
            case 8: {
                n2 = EIGHT;
                break;
            }
            case 7: {
                n2 = SEVEN;
                break;
            }
            case 6: {
                n2 = SIX;
                break;
            }
            case 5: {
                n2 = FIVE;
                break;
            }
            case 4: {
                n2 = FOUR;
                break;
            }
            case 3: {
                n2 = THREE;
                break;
            }
            case 2: {
                n2 = TWO;
                break;
            }
            case 1: {
                n2 = ONE;
            }
        }
        this.positions_.put(NodeListWithPosition.identity(node), n2);
    }

    void add(String string) {
        this.vector_.addElement(string);
    }

    Enumeration iterator() {
        return this.vector_.elements();
    }

    int position(Node node) {
        return (Integer)this.positions_.get(NodeListWithPosition.identity(node));
    }

    void removeAllElements() {
        this.vector_.removeAllElements();
        this.positions_.clear();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration enumeration = this.vector_.elements();
            while (true) {
                StringBuffer stringBuffer2;
                if (!enumeration.hasMoreElements()) {
                    stringBuffer.append("}");
                    return stringBuffer.toString();
                }
                Object object = enumeration.nextElement();
                if (object instanceof String) {
                    stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("String(");
                    stringBuffer2.append(object);
                    stringBuffer2.append(") ");
                    object = stringBuffer2.toString();
                } else {
                    object = (Node)object;
                    stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Node(");
                    stringBuffer2.append(object.toXml());
                    stringBuffer2.append(")[");
                    stringBuffer2.append(this.positions_.get(NodeListWithPosition.identity(object)));
                    stringBuffer2.append("] ");
                    object = stringBuffer2.toString();
                }
                stringBuffer.append((String)object);
            }
        }
        catch (IOException iOException) {
            return iOException.toString();
        }
    }
}
