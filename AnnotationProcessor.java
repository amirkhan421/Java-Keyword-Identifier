import java.lang.annotation.*;
import java.lang.reflect.*;

// Define a custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value() default "Default Message";
}

// Class using the annotation
class DemoClass {
    @MyAnnotation(value = "Hello, this is a custom annotation!")
    public void myMethod() {
        System.out.println("Executing myMethod...");
    }
}

// Processor that reads the annotation
public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        DemoClass obj = new DemoClass();
        Method method = obj.getClass().getMethod("myMethod");

        // Check if @MyAnnotation is present
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("Annotation Found: " + annotation.value());
        }

        // Execute the method
        obj.myMethod();
    }
}
