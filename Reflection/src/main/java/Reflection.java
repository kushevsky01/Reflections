import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.SocketTimeoutException;

class UtilClass {

    private final Class cls;

    UtilClass(Class cls) {
        this.cls = cls;
    }

    public void showInfo() {
        clasaName(cls);

        packageName(cls);

        interfaceName(cls);

        superClass(cls);

        constuctors(cls);

        fields(cls);

        methods(cls);
    }

    public void clasaName(Class cls) {
        System.out.println("Class name :" + cls.getName());
    }

    public void packageName(Class cls) {
        System.out.println("Package :" + cls.getPackageName());
        System.out.println("");
    }

    public void interfaceName(Class cls) {
        Class<?>[] inte = cls.getInterfaces();
        System.out.println();
        System.out.println("Interface");


        for (Class in : inte) {
            System.out.println(in);
        }
        System.out.println("");
    }

    public void superClass(Class cls) {
        System.out.println("Super class");
        Class cl = cls.getSuperclass();
        System.out.println(cl.getName());
    }

    public void constuctors(Class cls) {
        Constructor[] cons = cls.getConstructors();
        System.out.println("Constructors:");
        System.out.println(" ");


        for (Constructor con : cons) {
            System.out.println("Constructor");
            System.out.println(con.getName());
            Class[] types = con.getParameterTypes();


            for (Class ct : types) {
                System.out.println("Constructor parameter types");
                System.out.println("- " + ct.getName());
                System.out.println("");
            }


        }
    }

    public void fields(Class cls){
        Field[] fld = cls.getDeclaredFields();


        for (Field fl : fld) {
            System.out.println("");
            System.out.println("Fields: ");
            System.out.println("Var :" + fl.getName() + "(" + fl.getType().getName() + ")");
        }
    }

    public void methods(Class cls){
        Method[] method = cls.getMethods();
        System.out.println("");
        System.out.println("There are " + method.length + " methods :");


        for (Method meth : method) {
            System.out.println("");
            System.out.println("Mehod name: " + meth.getName());
            System.out.println("Return type : " + meth.getReturnType().getName());
            Class<?>[] params = meth.getParameterTypes();
            System.out.print("Parameters : ");


            for (Class<?> param : params)
                System.out.print(" " + param.getName());


            Annotation[] ann = meth.getAnnotations();
            for (Annotation an : ann) {
                System.out.println("Annotation");
                System.out.println(an.annotationType());

            }

        }
    }


}

public class Reflection {
    public static void main(String[] args) {

        StringBuffer test = new StringBuffer();
        UtilClass cls = new UtilClass(test.getClass());
        cls.showInfo();

    }
}
