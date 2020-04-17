package com.lec.android.a008_practice;

import java.io.Serializable;

public class My implements Serializable {
    String name;
    String age;
    String juso;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJuso() {
        return juso;
    }

    public void setJuso(String juso) {
        this.juso = juso;
    }

    public My (String name, String age, String juso){
        this.name = name;
        this.age = age;
        this.juso = juso;

    }



}

