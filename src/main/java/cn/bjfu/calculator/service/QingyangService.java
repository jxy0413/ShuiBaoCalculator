package cn.bjfu.calculator.service;

import cn.bjfu.calculator.model.EnvironmentalSilver;
import cn.bjfu.calculator.util.ShuiBaoTimeUntils;
import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chaird
 * @create 2020-09-25 16:26
 */
@Component
public class QingyangService {

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

    double result = -1D;
    Date collectDate = environmentalSilver.getCollectDate();

    // 获取小时
    int hour = DateUtil.hour(collectDate, true);

    if (hour >= 5 && hour <= 7) { // 05:00-08:00

    } else if (hour >= 8 && hour <= 14) { // 08:00-15:00

    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00

    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // 6150.1e-0.047RH
      result = Math.pow(6150.1, -0.047 * environmentalSilver.getRH());
    } else {
      result = -1D;
    }

    return result;
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
