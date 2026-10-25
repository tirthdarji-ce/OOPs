import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {

    public static String fillTemplate(String template, String[] names, String[] values) {

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder result = new StringBuilder();

        int last = 0;

        while (matcher.find()) {

            result.append(template.substring(last, matcher.start()));

            String placeholder = matcher.group(1);
            String value = "[?]";

            for (int i = 0; i < names.length; i++) {

                if (placeholder.equals(names[i])) {
                    value = values[i];
                    break;
                }
            }

            result.append(value);
            last = matcher.end();
        }

        result.append(template.substring(last));

        return result.toString();
    }
}