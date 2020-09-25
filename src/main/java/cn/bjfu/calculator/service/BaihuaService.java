package cn.bjfu.calculator.service;

import cn.bjfu.calculator.model.EnvironmentalSilver;
import cn.bjfu.calculator.util.ShuiBaoTimeUntils;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 白桦计算的公式
 *
 * @author chaird
 * @create 2020-09-25 14:54
 */
public class BaihuaService {

  public double calc(EnvironmentalSilver environmentalSilver) {

    Date date;

    double reult = -1D;

    try {
      date = DateUtil.parse(environmentalSilver.getCollectTime(), ShuiBaoTimeUntils.TIME_STYPE);
    } catch (Exception e) {
      e.printStackTrace();
      // 说明时间格式不对
      return reult;
    }

    // 赋值
    environmentalSilver.setCollectDate(date);

    int month = DateUtil.month(date);

    if (5 == month) {
      reult = MayMethod(environmentalSilver);
    } else if (6 == month) {
      reult = JuneMethod(environmentalSilver);
    } else if (7 == month) {
      reult = JulyMethod(environmentalSilver);
    } else if (8 == month) {
      reult = AugustMethod(environmentalSilver);
    } else if (9 == month) {
      reult = SeptemberMethod(environmentalSilver);
    } else if (10 == month) {
      reult = OctoberMethod(environmentalSilver);
    }

    return reult;
  }

  /**
   * 5月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double MayMethod(EnvironmentalSilver environmentalSilver) {
    return -1D;
  }

  /**
   * 6月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double JuneMethod(EnvironmentalSilver environmentalSilver) {
    return -1D;
  }

  /**
   * 7月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double JulyMethod(EnvironmentalSilver environmentalSilver) {
    return -1D;
  }

  /**
   * 8月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double AugustMethod(EnvironmentalSilver environmentalSilver) {
    return -1D;
  }

  /**
   * 9月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double SeptemberMethod(EnvironmentalSilver environmentalSilver) {
    return -1D;
  }

  /**
   * 10月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double OctoberMethod(EnvironmentalSilver environmentalSilver) {
    return -1D;
  }
}
