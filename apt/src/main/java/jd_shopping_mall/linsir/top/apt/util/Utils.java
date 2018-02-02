package jd_shopping_mall.linsir.top.apt.util;

import javax.annotation.processing.Messager;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * 作者：潇湘夜雨 on 2018/2/2.
 * 邮箱：879689064@qq.com
 */

public class Utils {
    public static final String ANNOTATION = "@";

    public static boolean isPublic(TypeElement element) {
        return element.getModifiers().contains(PUBLIC);
    }
    public static boolean isAbstract(TypeElement element) {
        return element.getModifiers().contains(ABSTRACT);
    }

    public static boolean isValidClass(Messager messager, TypeElement element) {
        if (element.getKind() != ElementKind.CLASS) {
            return false;
        }

        if (!isPublic(element)) {
            String message = String.format("Classes annotated with %s must be public.", ANNOTATION);
            messager.printMessage(Diagnostic.Kind.ERROR, message, element);
            return false;
        }

        if (isAbstract(element)) {
            String message = String.format("Classes annotated with %s must not be abstract.", ANNOTATION);
            messager.printMessage(Diagnostic.Kind.ERROR, message, element);
            return false;
        }

        return true;
    }
}
