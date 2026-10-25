import java.lang.reflect.*; import java.util.*;

import model.annotation.Positive;
import modell.annotation.*;
public class AnnotationValidator {
    public static String[] validate(Object obj){
        List<String> errors=new ArrayList<>();
        for(Field f:obj.getClass().getDeclaredFields()){
            try{f.setAccessible(true);Object v=f.get(obj);
                if(f.isAnnotationPresent(Positive.class)&&v instanceof Number n&&n.longValue()<=0) errors.add(f.getAnnotation(Positive.class).message());
                if(f.isAnnotationPresent(MaxLength.class)&&v!=null&&v.toString().length()>f.getAnnotation(MaxLength.class).value()) errors.add(f.getName()+" too long");
            }catch(Exception e){errors.add(e.getMessage());}
        } return errors.toArray(new String[0]);
    }
}
