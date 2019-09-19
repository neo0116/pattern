package com.ByteDance.proxy.bdproxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws NoSuchMethodException {

        Iron iron = new Iron();
        Sweetheart sweetheart = new Sweetheart();
        Marvel proxy = (Marvel) sweetheart.getInstance(iron);
        System.out.println(proxy.getClass());

        proxy.attackBadPerson();

        proxy.getSlogan();

        proxy.getSlogan1("1号测试");

        List<String> list = new ArrayList<>();

        list.add("2号测试1");
        list.add("2号测试2");
        proxy.getSlogan2(list);

        proxy.getSlogan3(new String[]{"3号测试1", "3号测试2"});
        proxy.getSlogan4(new int[]{2, 4, 5, 6});
        proxy.getSlogan5(new double[]{2.1, 4.4, 2.0});
        proxy.getSlogan6("6号测试", 6);
        proxy.getSlogan7();
    }

}
