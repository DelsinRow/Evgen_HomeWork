package coding_exercise_10;

import java.lang.reflect.Method;

public class SimpleUnitTester {
    public static void main(String[] args) throws Exception {
       Class ReflectionClass = Reflection.class;

        System.out.println("There are " + execute(ReflectionClass) + " methods, began with 'test'");
    }
    public static int execute(Class clazz) throws Exception {
        int failedCount = 0;
       Method[] methodsArray = clazz.getMethods();
       for(Method method : methodsArray){
           if(method.getName().startsWith("test")){
               failedCount++;
           }
       }
        return failedCount;
    }
}