package com.zak.powermock.recipes.whitebox;

public class Util {

    public static String DESCRIPTION_TEMPLATE = "I am the \"%s\" method of the \"%s\" class";

    public static String getMethodDescription(String className) {
        return String.format(DESCRIPTION_TEMPLATE, extractMethodName(className), className);
    }

    private static String extractMethodName(String className) {
        return getStackTraceElementForClass(className).getMethodName();
    }

    private static StackTraceElement getStackTraceElementForClass(String className) {

        //I refuse to pass nulls around thus creating an instance of StackTraceElement
        StackTraceElement stackTraceElement = new StackTraceElement("declaringClass", "methodName", "fileName", 0);

        for(StackTraceElement each : getCurrentStackTrace()) {

            if(each.getClassName().equals(className)) {
                stackTraceElement = each;
            }
        }

        return stackTraceElement;
    }

    public static StackTraceElement[] getCurrentStackTrace() {
        return Thread.currentThread().getStackTrace();
    }
}
