package servicee;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import modell.annotation.MaxLength;
import modell.annotation.Positive;

public class AnnotationValidator {
    public static String[] validate(Object obj) {
        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (field.isAnnotationPresent(Positive.class)) {
                    Positive rule = field.getAnnotation(Positive.class);
                    if (value instanceof Number && ((Number) value).doubleValue() <= 0) {
                        errors.add(field.getName() + " " + rule.message());
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class) && value != null) {
                    int max = field.getAnnotation(MaxLength.class).value();
                    if (value.toString().length() > max) {
                        errors.add(field.getName() + " must be at most " + max + " characters");
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Cannot access field: " + field.getName());
            }
        }
        return errors.toArray(new String[0]);
    }
}
