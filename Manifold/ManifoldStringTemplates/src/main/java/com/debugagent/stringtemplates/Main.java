package com.debugagent.stringtemplates;

import manifold.rt.api.DisableStringLiteralTemplates;
import templates.HelloTemplate;
import templates.JavaCode;

public class Main {
    public static void main(String[] args) {
        String world = args.length > 0 ? args[0] : "world";
        System.out.println("Hello $world! I can write \$world as the variable...");
        noTemplate(world);

        System.out.println(HelloTemplate.render("My Title", "My Body"));
        System.out.println(JavaCode.render("MyClass", "System.out.println(\"Hello World\");"));
    }

    @DisableStringLiteralTemplates
    private static void noTemplate(String word) {
        System.out.println("Hello $world!");
    }
}

