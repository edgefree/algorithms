package localtest.advanceTest;

import junit.framework.TestCase;
import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/*

 */
public class 反射 extends TestCase {

    @Test
    public void testReflectInterface() throws ClassNotFoundException, NoSuchMethodException {

        Class<?> interfaceClass = Class.forName(RpcService.class.getName());

        Method[] declaredMethods = interfaceClass.getDeclaredMethods();

        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            String name = declaredMethod.getName();

            Parameter[] parameters = declaredMethod.getParameters();

            System.out.println();

        }

        System.out.println();

    }

    interface RpcService {
        Person ping(Person person);
    }

    @Data
    class Person {
        private int age;

        String getName() {
            return "xxx";
        }

        String getAddress() {
            return "lll";
        }
    }

    @Test
    public void testCase() throws IllegalAccessException {
        Field[] fields = null;
        Class[] declaredClasses = null;
        try {
            Class clz = Class.forName(Person.class.getName());
            fields = clz.getDeclaredFields();
            declaredClasses = clz.getDeclaredClasses();
        } catch (Exception e) {

        }

        if (declaredClasses != null) {
            for (int i = 0; i < declaredClasses.length; i++) {
                String name = declaredClasses[i].getName();
                System.out.println(name);
            }
        }


        Person person = new Person();
        person.setAge(1);
        if (fields != null) {
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                System.out.println(name);
                int age = fields[i].getInt(person);
                System.out.println(age);
                fields[i].setInt(person, 2);
                fields[i].setAccessible(true);
            }
        }

    }
}
