package cn.bjfu.calculator.service;

import cn.bjfu.calculator.model.EnvironmentalSilver;
import cn.bjfu.calculator.util.ShuiBaoTimeUntils;
import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Fei
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
            result = 0.0081 * Math.exp(0.1468 * environmentalSilver.getRH());

        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 3.812 * environmentalSilver.getRH() + 25.59 * environmentalSilver.getVPD() + 2.202 * environmentalSilver.getT() - 166.609;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -5.5187 * Math.pow(environmentalSilver.getT(), 2) + 182.52 * environmentalSilver.getT() - 1282.9;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            // 6150.1e-0.047RH
            // result = Math.pow(6150.1, -0.047 * environmentalSilver.getRH());
            result = 3818.6 * Math.exp(-0.197 * environmentalSilver.getT());
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
            result = 6 * environmentalSilver.getE() + 10 * Math.exp(-2.135 * environmentalSilver.getT());

        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = -83.642 * environmentalSilver.getVPD() - 1.275 * environmentalSilver.getT() - 2.134 * environmentalSilver.getRH() + 287.754;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -8.024 * environmentalSilver.getRH() + 438.443 * environmentalSilver.getVPD() - 77.39 * environmentalSilver.getT() + 1592.868;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 1.0473 * Math.exp(0.087 * environmentalSilver.getRH());
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
            //result = 3*environmentalSilver.getE()+07e-1.125T
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 252.082 * environmentalSilver.getVPD() + 3.904 * environmentalSilver.getRH() - 16.454 * environmentalSilver.getT() - 118.67;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 0.5698 * Math.pow(environmentalSilver.getRH(), 2) - 70.423 * environmentalSilver.getRH() + 2259.8;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 5058.4 * environmentalSilver.getE() - 2.305 * environmentalSilver.getVPD();
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
            result = 9 * environmentalSilver.getE() + 69 * environmentalSilver.getE() - 12.53 * environmentalSilver.getT();
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 1688.672 * environmentalSilver.getVPD() + 51.886 * environmentalSilver.getRH() - 4325.047;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 259.94 * Math.pow(environmentalSilver.getVPD(), 2) - 399.07 * environmentalSilver.getVPD() + 230.15;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            // result = 2*environmentalSilver.getE()+09e-1.243T
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
