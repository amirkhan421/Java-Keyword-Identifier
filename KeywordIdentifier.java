import java.util.*;
import java.util.regex.*;

public class KeywordIdentifier {
    public static void main(String[] args) {
        String code = """
            public class Main {
                public static void main(String[] args) {
                    int x = 10;
                    if (x > 5) {
                        System.out.println("x is greater than 5");
                    } else {
                        System.out.println("x is 5 or less");
                    }
                }
            }
            """;

        // List of all Java keywords
        Set<String> javaKeywords = new HashSet<>(Arrays.asList(
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
                "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile", "while"
        ));

        // Extract words from the code using regex
        Pattern pattern = Pattern.compile("\\b[a-zA-Z_][a-zA-Z0-9_]*\\b");
        Matcher matcher = pattern.matcher(code);

        // Categorize words as keywords or not keywords
        Set<String> foundKeywords = new HashSet<>();
        Set<String> notKeywords = new HashSet<>();

        while (matcher.find()) {
            String word = matcher.group();
            if (javaKeywords.contains(word)) {
                foundKeywords.add(word);
            } else {
                notKeywords.add(word);
            }
        }

        // Print results
        System.out.println("Keywords found: " + foundKeywords);
        System.out.println("Non-keywords found: " + notKeywords);
    }
}
