package org.example.java8.defaultinaction;

public class DefaultInAction {


    public static void main(String[] args) {
//        A a = () -> 10;
//        System.out.println(a.size());
//        System.out.println(a.isEmpty());

//        DefaultInAction action = new DefaultInAction();
//        action.confuse(null);
//
//        int[] arr = null;
//        Object o = arr;
//        action.confuse(o);

        A c = new C();
        c.hello();
    }


    private void confuse(Object o) {
        System.out.println("object");
    }

    private void confuse(int[] i) {
        System.out.println("int[]");
    }


    private interface A {

//        int size();
//
//        default boolean isEmpty() {
//            return size() == 0;
//        }


        default void hello() {
            System.out.println("==A=.hello=");
        }

    }

    private interface B extends A {
        @Override
        default void hello() {
            System.out.println("==B=.hello=");
        }
    }

    private static class C implements B, A {

//        @Override
//        public void hello() {
//            System.out.println("==C=.hello=");
//        }
    }


}
