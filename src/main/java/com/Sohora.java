package com;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class Sohora {
    // stage 1 and stage 2
    // stage 1
    public String strDeal(String str) {
        String a1, a2, a3, finalString;

        for (int i = 0; i < str.length() - 2; i++) {
            a1 = str.split("")[i];
            a2 = str.split("")[i + 1];
            a3 = str.split("")[i + 2];
            if (a1.equals(a2) && a1.equals(a3)) {
                finalString = str.replace(a1, "");
                System.out.println("after is :" + finalString);
                //递归调用点
                return strDeal(finalString);
            }
        }
        return str;
    }

    @Test
    public void test1() throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = null;
        System.out.println("请输入字符串：");
        str = sc.nextLine();
        while (str != null) {
            System.out.println("orginal string: " + str);
            strDeal(str);
            System.out.println("请输入字符串：");
            str = sc.nextLine();
        }
    }


    //stage 2

    public String strDealWithPre(String str) {
        String a1, a2, a3, r, finalString;

        for (int i = 0; i < str.length() - 2; i++) {
            a1 = String.valueOf(str.charAt(i));
            a2 = String.valueOf(str.charAt(i + 1));
            a3 = String.valueOf(str.charAt(i + 2));
            if (a1.equals(a2) && a1.equals(a3)) {
                if (a1.charAt(0) != 'a') {
                    r = String.valueOf((char) (a1.charAt(0) - 1));
                } else {
                    r = "";
                }
                CharSequence cSeq1 = a1 + a2 + a3;
                finalString = str.replace(cSeq1, r);
                if ("".equals(r)) {
                    System.out.println("after is :" + finalString);
                } else {
                    System.out.println("after is :" + finalString + "," + a1 + a1 + a1 + " is replace by " + r);
                }
                //递归调用点
                return strDealWithPre(finalString);
            }
        }
        return str;
    }

    @Test
    public void test2() throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = null;
        System.out.println("请输入字符串：");
        str = sc.nextLine();
        while (str != null) {
            System.out.println("orginal string: " + str);
            strDealWithPre(str);
            System.out.println("请输入字符串：");
            str = sc.nextLine();
        }
    }

}
