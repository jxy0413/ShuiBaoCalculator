package cn.bjfu.calculator.test;

import cn.bjfu.calculator.util.ShuiBaoTimeUntils;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author chaird
 * @create 2020-09-25 15:26
 */
public class CBeannTest {
  public static void main(String[] args) {

    String str = "2020年9月9日 11:00:00";

    Date parse = DateUtil.parse(str, ShuiBaoTimeUntils.TIME_STYPE);

    System.out.println(parse);
  }
}
