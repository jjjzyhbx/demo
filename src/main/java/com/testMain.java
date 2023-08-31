package com;

import com.Chlin.blog.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

/**
 * 用来测试一些工具
 */
public class testMain {
    public static void main(String[] args) {
        User user=new User();
        user.setPassword("12345");
        user.setEmail("derthyj");
        user.setId(10);
        User user1=new User();
        user1.setId(1);
        user1.setPassword("12345");
        user1.setEmail("cfyasgu");
        try {
            System.out.println((copyChangedFields(user,user1).toString()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static Object copyChangedFields(Object source, Object target) throws IllegalAccessException {

        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        // 两个对象类类型必须相同
        if (!sourceClass.equals(targetClass)) {
            return null;
        }

        Object copiedTarget = null;
        try {
            copiedTarget = targetClass.newInstance();
        } catch (Exception e) {
            // 如果目标对象无法实例化,直接返回
            return null;
        }

        Field[] fields = sourceClass.getDeclaredFields();

        fields = Arrays.stream(fields)
                .filter(f -> !Modifier.isStatic(f.getModifiers()) || !Modifier.isFinal(f.getModifiers()))
                .toArray(Field[]::new);

            for (Field field : fields) {
                field.setAccessible(true);
                // 获取源对象和目标对象的字段值
                Object sourceValue = field.get(source);
                Object targetValue = field.get(target);

                // 比较两个值
                if (!Objects.equals(sourceValue, targetValue)) {

                    // 设置不同的值到复制的目标对象
                    field.set(copiedTarget, targetValue);
                } else {

                    // 相同的值也需要设置到复制的目标对象
                    field.set(copiedTarget, targetValue);
                }
            }

        return copiedTarget;

    }
}
