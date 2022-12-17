package com.debugagent.ch03.language;

import com.debugagent.ch03.language.sealed.SealedA;
import com.debugagent.ch03.language.sealed.SealedB;
import com.debugagent.ch03.language.sealed.SealedBase;
import static java.lang.System.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class SwitchExpressions {
    enum ENUM {
        A, B, C
    }

    public static void main(String[] argv) {
        var value = ENUM.A;

        // Case prior to switch expressions
        String result;
        switch (value) {
            case A:
                result = "The A Value";
                break;
            case B:
                result = "It's B";
                break;
            case C:
                result = "It's C";
                break;
        }

        // with switch expressions
        result = switch (value) {
            case A -> "The A Value";
            case B -> "It's B";
            case C -> "It's C";
        };

        // with switch expressions and yield...
        result = switch (value) {
            case A:
                System.out.println("A reached");
                yield "The A Value";
            case B:
                System.out.println("B reached");
                yield "It's B";
            case C:
                System.out.println("C reached");
                yield "It's C";
        };

        Shape myShape = new Rectangle();
        var height = switch (myShape) {
            case Rectangle r    -> r.height;
            case GeneralPath c  -> c.getBounds().height;
            default             ->
                    throw new IllegalArgumentException("Unrecognized shape");
        };

        SealedBase base = new SealedA();
        switch (base) {
            case SealedA a -> out.println("It's A");
            case SealedB b -> out.println("It's B");
            case SealedBase theBase -> out.println("It's The Base");
        }
    }
}
