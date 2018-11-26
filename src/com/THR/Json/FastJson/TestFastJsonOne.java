package com.THR.Json.FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Date;

public class TestFastJsonOne {
    public static void main(String args[]){

        Student stu = new Student();
        stu.setUserName("thr");
        stu.setBirthDay(new Date());
        stu.setAge(23);
        String str = JSON.toJSONString(stu);
        System.out.println(str);
        Student2 stu2 = JSON.parseObject(str, Student2.class);
        System.out.println(stu2.toString());
        System.out.println(stu2.getSchool());
        SimplePropertyPreFilter sp = new SimplePropertyPreFilter(Student.class, "userName");
        str = JSON.toJSONString(stu, sp);
        System.out.println(str);
    }

    static class Student{
        private String userName;
        private Date birthDay;
        private int age;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "userName='" + userName + '\'' +
                    ", birthDay=" + birthDay +
                    ", age=" + age +
                    '}';
        }
    }
    static class Student2{
        private String userName;
        private String School;
        private Date birthDay;
        private int age;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Date getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(Date birthDay) {
            this.birthDay = birthDay;
        }

        public String getSchool() {
            return School;
        }

        public void setSchool(String school) {
            School = school;
        }

        @Override
        public String toString() {
            return "Student2{" +
                    "userName='" + userName + '\'' +
                    ", School='" + School + '\'' +
                    ", birthDay=" + birthDay +
                    ", age=" + age +
                    '}';
        }
    }
}
