package com.Chlin.blog.Util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;

/**
 * 服务工具类
 */
public class ServiceUtils {
    private ServiceUtils(){

    }
    public static ServiceUtils getInstance(){
        return new ServiceUtils();
    }

    /**
     * 比较两个对象的不同，更新其中一个
     * @param source 源对象
     * @param target 目标对象
     * @return target=source+target
     * @throws IllegalAccessException
     */
    public static Object copyChangedFields(Object source, Object target) throws IllegalAccessException {

        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        // 两个对象类类型必须相同
        if (!sourceClass.equals(targetClass)) {
            return null;
        }

        Object copiedTarget = null;
        try {
            copiedTarget = sourceClass.newInstance();
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
