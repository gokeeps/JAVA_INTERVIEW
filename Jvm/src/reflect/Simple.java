package reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Simple {

    public static void main(String[] args)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
        InvocationTargetException, NoSuchFieldException {
        Class classes = Class.forName("reflect.User");
        Method[] methods = classes.getDeclaredMethods();
        Field[] fields = classes.getDeclaredFields();
        Constructor[] constructor =  classes.getDeclaredConstructors();
        System.out.println(Arrays.toString(methods));
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(constructor));

//        User user = (User)classes.newInstance();
//        user.setName("徐宁");
//        System.out.println(user);

        Method method = classes.getMethod("getName");
        Method setNickName = classes.getMethod("setNickName", String.class);
        String name = (String)method.invoke(classes.newInstance(), null);
        System.out.println(name);

        Field field = classes.getField("nickName");
        if (field.isAnnotationPresent(Test.class)) {
            Test[] datas = field.getAnnotationsByType(Test.class);
            Arrays.stream(datas).forEach(System.out::println);
            User user1 = (User)classes.newInstance();
            setNickName.invoke(user1, datas[0].name1() + "-" +  datas[0].name2());
        }


        User user2 = new User();
        user2.setAge(18);
        user2.setName("gggg");
        Class userClass = user2.getClass();
        Field nameField = userClass.getDeclaredField("name");

        Method getNameMethod = userClass.getDeclaredMethod("getName");
        String name2 = (String)getNameMethod.invoke(user2);
        System.out.println("---------" + name2);
        Method nameMethod = userClass.getDeclaredMethod("setName", String.class);
        if (nameField.isAnnotationPresent(Test.class)) {
            Test[] datas = nameField.getAnnotationsByType(Test.class);
            Arrays.stream(datas).forEach(System.out::println);
            nameMethod.invoke(user2, datas[0].name1() + "-" +  datas[0].name2());
        }
        System.out.println(user2.toString());
    }
}





class User {

    private String name;
    private int age;
    public String nickName;
    protected String inters;
    String remark;
    private boolean status;

    @Test(name1 = "888")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getInters() {
        return inters;
    }

    public void setInters(String inters) {
        this.inters = inters;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", nickName='" + nickName + '\'' + ", inters='" + inters + '\'' + ", remark='" + remark + '\'' + ", status=" + status + '}';
    }
}
