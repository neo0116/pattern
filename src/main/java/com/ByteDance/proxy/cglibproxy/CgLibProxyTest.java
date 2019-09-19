package com.ByteDance.proxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @ClassName CgLibProxyTest
 * @Description TODO
 * @Version 1.0
 **/
public class CgLibProxyTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "G:\\cglib_proxy_classes");

        Sweetheart sweetheart = new Sweetheart();

        Boss boss = (Boss) sweetheart.getInstance(Boss.class);

        System.out.println(boss.getClass());

        boss.managementCompany();

    }

}
