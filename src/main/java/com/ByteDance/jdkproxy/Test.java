package com.ByteDance.jdkproxy;

/**
 * @ClassName Test
 * @Description TODO
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {

        Iron iron = new Iron();
        Sweetheart sweetheart = new Sweetheart();
        Marvel proxy = sweetheart.getInstance(iron);
        proxy.attackBadPerson();
        System.out.println(proxy.getClass());
    }

}
