package com.library.libraryproject.ToJson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.entity.dto.Building;
import com.library.libraryproject.entity.dto.Storey;
import org.assertj.core.util.Lists;
import org.junit.Test;

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
    @Test
    public void testArea(){
        List<Area> list = Lists.newArrayList();
        Storey storey= Storey.builder().name("一层").id("06").rooms(Lists.newArrayList("001", "002")).build();
        Storey storey1= Storey.builder().name("二层").id("07").rooms(Lists.newArrayList("001", "002")).build();
        Building building = Building.builder().id("01").name("图书馆").storeys(Lists.newArrayList(storey, storey1)).build();
        Building building1 = Building.builder().id("02").name("综合楼").storeys(Lists.newArrayList(storey, storey1)).build();
        Area a = Area.builder().name("新校区").id("01").buildings(Lists.newArrayList(building, building1)).build();
        Area b = Area.builder().name("老校区").id("02").buildings(Lists.newArrayList(building, building1)).build();
        list.add(a);
        list.add(b);
        String string = JSONArray.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(string);
    }
    @Test
    public void testParse(){
        String s = "[{\"id\":\"01\",\"name\":\"图书馆\",\"storeys\":[{\"id\":\"06\",\"name\":\"一层\",\"rooms\":[\"001\",\"002\"]},{\"id\":\"07\",\"name\":\"二层\",\"rooms\":[\"001\",\"002\"]}]},{\"id\":\"02\",\"name\":\"综合楼\",\"storeys\":[{\"id\":\"06\",\"name\":\"一层\",\"rooms\":[\"001\",\"002\"]},{\"id\":\"07\",\"name\":\"二层\",\"rooms\":[\"001\",\"002\"]}]}]";
        List<Building> list = (List<Building>) JSONArray.parse(s);
        System.out.println(list);
    }
    @Test
    public void testObjectParse(){
        String s = "{\"id\":\"07\",\"name\":\"二层\",\"rooms\":[\"001\",\"002\"]}";
                Storey storey = JSONArray.parseObject(s,Storey.class);
//        System.out.println(JSONArray.parse(s));
        System.out.println(storey);
    }
}

