package bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * @author heartccace
 * @create 2020-12-08 21:21
 * @Description TODO
 * @Version 1.0
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor.toString());
        });
    }
}
