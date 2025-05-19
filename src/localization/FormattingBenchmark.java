package localization;

import java.text.MessageFormat;

public class FormattingBenchmark {
    public static void main(String[] args) {
        final String messageFormatPattern = "Hello {0} {1}, you have {2} new messages.";
        final String formatterPattern = "Hello %s %s, you have %d new messages.";
        final Object[] params = {"John", "Doe", 5};

        // 1. Formatter
        long startTime = System.nanoTime();
        String formatted1 = String.format(formatterPattern, params);
        long endTime = System.nanoTime();
        System.out.println("Formatter time: " + (endTime - startTime) + " ns");

        // 2. MessageFormat without caching
        startTime = System.nanoTime();
        MessageFormat messageFormat1 = new MessageFormat(messageFormatPattern);
        String formatted2 = messageFormat1.format(params);
        endTime = System.nanoTime();
        System.out.println("MessageFormat without cache time: " + (endTime - startTime) + " ns");

        // 3. MessageFormat with caching
        startTime = System.nanoTime();
        String formatted3 = LocalizationManager.getLocalizedText(messageFormatPattern, params);
        endTime = System.nanoTime();
        System.out.println("MessageFormat with cache time: " + (endTime - startTime) + " ns");
    }
}
