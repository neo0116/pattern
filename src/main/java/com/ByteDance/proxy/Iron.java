package com.ByteDance.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Iron
 * @Description TODO
 * @Version 1.0
 **/
public class Iron implements Marvel {

    @Override
    public void attackBadPerson() {
        System.out.println("攻击灭霸");
    }

    @Override
    public String getSlogan() {
        System.out.println("爱你不止三千遍");
        return "爱你不止三千遍";
    }

    @Override
    public String getSlogan1(String name) {
        System.out.println("1号：string");
        return "string";
    }

    @Override
    public String getSlogan2(List<String> name) {
        System.out.println("2号：list集合");
        return "list集合";
    }

    @Override
    public String getSlogan3(String[] name) {
        System.out.println("3号：string数组");
        return "string数组";
    }

    @Override
    public String getSlogan4(int[] name) {
        System.out.println("4号：int数组");
        return "int数组";
    }

    @Override
    public String getSlogan5(double[] name) {
        System.out.println("5号：double数组");
        return "double数组";
    }

    @Override
    public String getSlogan6(String name, int num) {
        System.out.println("6号：String，int两个参数");
        return "String，int两个参数";
    }

    @Override
    public List<String> getSlogan7() {
        System.out.println("7号：返回类型为list集合");
        return new ArrayList<>();
    }

}
