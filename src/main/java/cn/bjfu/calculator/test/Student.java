package cn.bjfu.calculator.test;

public class Student {
    public static void main(String[] args) {
        String str = "2020年9月9日 11:11:11";
        String[] months = str.split("年");
        System.out.println(months[0]);
    }
}
