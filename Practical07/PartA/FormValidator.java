
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    String name;

    @NotBlank
    @MaxLength(30)
    String email;

    SignupForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class FormValidator {

    static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)
                        && (value == null || value.toString().isBlank())) {
                    errors.add(field.getName() + " must not be blank");
                }

                if (field.isAnnotationPresent(MaxLength.class)
                        && value != null
                        && value.toString().length()
                        > field.getAnnotation(MaxLength.class).value()) {
                    errors.add(field.getName() + " is too long");
                }

            } catch (IllegalAccessException e) {
                errors.add("Cannot access field: " + field.getName());
            }
        }

        return errors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        SignupForm form = new SignupForm(name, email);
        List<String> errors = validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid!");
        } else {
            System.out.println("Validation errors:");
            for (String error : errors) {
                System.out.println(error);
            }
        }

        sc.close();
    }
}
