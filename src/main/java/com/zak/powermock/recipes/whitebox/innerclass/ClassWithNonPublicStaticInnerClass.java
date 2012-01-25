package com.zak.powermock.recipes.whitebox.innerclass;

import com.zak.powermock.recipes.whitebox.Util;

public class ClassWithNonPublicStaticInnerClass {

    private  ProtectedInnerClass protectedInnerClass;
    private  PrivateInnerClass privateInnerClass;
    private  PackagePrivateInnerClass packagePrivateInnerClass;

    private  ProtectedStaticInnerClass protectedStaticInnerClass;
    private  PrivateStaticInnerClass privateStaticInnerClass;
    private  PackagePrivateStaticInnerClass packagePrivateStaticInnerClass;

    public ProtectedInnerClass getProtectedInnerClass() {
        return protectedInnerClass;
    }

    public PrivateInnerClass getPrivateInnerClass() {
        return privateInnerClass;
    }

    protected class ProtectedInnerClass implements Description{

        public String getDescription() {
            return getMethodDescription(this.getClass().getName());
        }
    }

    private class PrivateInnerClass implements Description {

        public String getDescription() {
            return getMethodDescription(this.getClass().getName());
        }
    }

    class PackagePrivateInnerClass implements Description {

        public String getDescription() {
            return getMethodDescription(this.getClass().getName());
        }

    }

    protected static class ProtectedStaticInnerClass implements Description {

        public String getDescription() {
            return getMethodDescription(this.getClass().getName());
        }
    }

    private static class PrivateStaticInnerClass implements Description {

        public String getDescription() {
            return getMethodDescription(this.getClass().getName());
        }
    }

    static class PackagePrivateStaticInnerClass implements Description {

        public String getDescription() {
            return getMethodDescription(this.getClass().getName());
        }

    }

    private static String getMethodDescription(String className) {
        return Util.getMethodDescription(className);
    }
}
