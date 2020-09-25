package cn.bjfu.calculator.service;

import cn.bjfu.calculator.model.EnvironmentalSilver;
import cn.bjfu.calculator.util.ShuiBaoTimeUntils;
import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 白桦计算的公式
 *
 * @author chaird
 * @create 2020-09-25 14:54
 */
@Component
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

    // 月份从0开始
    int month = DateUtil.month(date) + 1;

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
      // y = -158.2ln(T) + 426.4
      result = -158.2 * Math.log(environmentalSilver.getT()) + 426.4;
    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
      // y = -1109ln(T) + 3751.7
      result = -1109 * Math.log(environmentalSilver.getT()) + 3751.7;
    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // y = 6150.1e-0.047RH
      result = 6150.1 * Math.log(-0.047 * environmentalSilver.getRH());
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
    double result = -1D;
    Date collectDate = environmentalSilver.getCollectDate();

    // 获取小时
    int hour = DateUtil.hour(collectDate, true);

    if (hour >= 5 && hour <= 7) { // 05:00-08:00
      // y = 1E+10e-1.293T

    } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
      // y = 399.28e-1.611VPD
      result = 399.28 * Math.log(-1.611 * environmentalSilver.getVPD());

    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
      // y = 657.7e-0.09T
      result = 657.7 * Math.log(-0.09 * environmentalSilver.getT());
    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // y = 773.36VPD + 53.605
      result = 773.36 * environmentalSilver.getVPD() + 53.605;
    } else {
      result = -1D;
    }

    return result;
  }

  /**
   * 7月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double JulyMethod(EnvironmentalSilver environmentalSilver) {
    double result = -1D;
    Date collectDate = environmentalSilver.getCollectDate();

    // 获取小时
    int hour = DateUtil.hour(collectDate, true);

    if (hour >= 5 && hour <= 7) { // 05:00-08:00
      // y = -1272ln(VPD) - 388.89
      result = -1272 * Math.log(-0.09 * environmentalSilver.getT()) - 388.89;
    } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
      // y = 446.87e-0.126T
      result = 446.87 * Math.log(-0.126 * environmentalSilver.getT());
    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
      // y = 2109.1e-0.105T
      result = 2109.1 * Math.log(-0.105 * environmentalSilver.getT());
    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // y = 150398e-0.075RH
      result = 150398 * Math.log(-0.075 * environmentalSilver.getRH());
    } else {
      result = -1D;
    }

    return result;
  }

  /**
   * 8月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double AugustMethod(EnvironmentalSilver environmentalSilver) {
    double result = -1D;
    Date collectDate = environmentalSilver.getCollectDate();

    // 获取小时
    int hour = DateUtil.hour(collectDate, true);

    if (hour >= 5 && hour <= 7) { // 05:00-08:00
      // y = 4136.8e-6.031VPD
      result = 4136.8 * Math.log(-6.031 * environmentalSilver.getVPD());
    } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
      // y = 3004.9e-0.599VPD
      result = 3004.9 * Math.log(-0.599 * environmentalSilver.getVPD());
    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
      // y = 133.24e0.0255RH
      result = 133.24 * Math.log(0.0255 * environmentalSilver.getRH());
    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // y = 493824e-0.381T
      result = 493824 * Math.log(-0.381 * environmentalSilver.getT());
    } else {
      result = -1D;
    }

    return result;
  }

  /**
   * 9月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double SeptemberMethod(EnvironmentalSilver environmentalSilver) {
    double result = -1D;
    Date collectDate = environmentalSilver.getCollectDate();

    // 获取小时
    int hour = DateUtil.hour(collectDate, true);

    if (hour >= 5 && hour <= 7) { // 05:00-08:00
      // y = 2308.3e-0.06T
      result = 2308.3 * Math.log(-0.06 * environmentalSilver.getT());
    } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
      // y = y = 9982.1e-0.124T
      result = 9982.1 * Math.log(-0.124 * environmentalSilver.getT());
    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
      // y = 389.69e0.0167RH
      result = 389.69 * Math.log(0.0167 * environmentalSilver.getRH());
    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // y = 2636.9e-0.084 T
      result = 2636.9 * Math.log(-0.084 * environmentalSilver.getT());
    } else {
      result = -1D;
    }

    return result;
  }

  /**
   * 10月计算方法
   *
   * @param environmentalSilver
   * @return
   */
  private double OctoberMethod(EnvironmentalSilver environmentalSilver) {
    double result = -1D;
    Date collectDate = environmentalSilver.getCollectDate();

    // 获取小时
    int hour = DateUtil.hour(collectDate, true);

    if (hour >= 5 && hour <= 7) { // 05:00-08:00
      // y = 3400.5e-4.21VPD
      result = 3400.5 * Math.log(-4.21 * environmentalSilver.getVPD());

    } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
      // y = 2370.2e-0.427T
      result = 2370.2 * Math.log(-0.427 * environmentalSilver.getT());
    } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
      // y = 18173e-0.117T
      result = 18173 * Math.log(-0.117 * environmentalSilver.getT());
    } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
      // y = -28.02RH + 3193.6
      result = -28.02 * environmentalSilver.getRH() + 3193.6;
    } else {
      result = -1D;
    }

    return result;
  }
}
