package com.library.libraryproject.ToJson;

import com.alibaba.fastjson.JSONArray;
import com.library.libraryproject.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TestFastJson {
    public static void main(String[] args) {
        String a[] = new String[]{"金明校区","明伦校区"};
        User aaa = User.builder().userAcademy("aaa").userNumber("13123").build();
        User bbb = User.builder().userAcademy("aac").userNumber("131234").build();
        List<User> list = new ArrayList<>();
        list.add(aaa);
        list.add(bbb);
        String objects = JSONArray.toJSONString(list);
        List<User> list1 = (List<User>) JSONArray.parse(objects);
        System.out.println(objects);
    }
}
