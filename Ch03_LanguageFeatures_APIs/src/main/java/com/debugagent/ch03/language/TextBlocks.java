package com.debugagent.ch03.language;

public class TextBlocks {
    public static String regularStrings(String title, String link) {
       return
            "<html>\n" +
            "<head>\n" +
            "<title>" + title + "</title>\n" +
            "</head>" +
            "<body>\n" +
            "   <a href=\"https://debugagent.com\">" + link + "</a>\n" +
            "</body>";
    }

    public static String textBlockString(String title, String link) {
        return
                """
                <html>
                <head>
                <title>%s</title>
                </head><body>
                   <a href="https://debugagent.com">%s</a>
                </body>
                """.formatted(title, link);
    }

    public static void main(String[] argv) {
        System.out.println(regularStrings("Hi World", "Site"));
        System.out.println(textBlockString("Hi World", "Site"));
    }
}
