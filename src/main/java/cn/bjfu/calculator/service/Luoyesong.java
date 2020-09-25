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
public class Luoyesong {

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
            result = 241267 * Math.exp(-1.323 * environmentalSilver.getT());
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 5.9786 * Math.pow(environmentalSilver.getT(), 2) - 146.37 * environmentalSilver.getT() + 1070.7;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -71.844 * environmentalSilver.getT() + 2.279 * environmentalSilver.getRH() + 580.584 * environmentalSilver.getVPD() + 648.386;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            //result = 2*environmentalSilver.getE()+07e-18.49VPD
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
            result = -28849.115 * environmentalSilver.getT() + 30253.242 * environmentalSilver.getRH() + 2517254.003 * environmentalSilver.getVPD() - 2745677.7;
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = -82.854 * environmentalSilver.getT() + 755.299 * environmentalSilver.getVPD() + 883.863;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 16.43 * environmentalSilver.getT() - 1.491 * environmentalSilver.getRH() - 506.196 * environmentalSilver.getVPD() + 471.952;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 14.458 * Math.pow(environmentalSilver.getVPD(), 2) - 2241.7 * environmentalSilver.getVPD() + 87276;
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
            // result = 4*environmentalSilver.getE()-06e1.9397T
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 1628.718 * environmentalSilver.getVPD() - 232.674 * environmentalSilver.getT() + 3219.486;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 25.357 * Math.pow(environmentalSilver.getT(), 2) - 1014.4 * environmentalSilver.getT() + 10213;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 7469.397 * environmentalSilver.getVPD() - 364.451 * environmentalSilver.getT() + 113.025 * environmentalSilver.getRH() - 6248.033;
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
            result = -82.871 * Math.pow(environmentalSilver.getRH(), 2) + 14460 * environmentalSilver.getRH() - 629990;
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 1155 * Math.exp(-0.114 * environmentalSilver.getT());
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -23.642 * environmentalSilver.getT() + 5.704 * environmentalSilver.getRH() + 188.097 * environmentalSilver.getVPD() + 81.739;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 154.44 * Math.pow(environmentalSilver.getT(), 2) - 4757.4 * environmentalSilver.getT() + 36781;
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
            result = -6421.798 * environmentalSilver.getT() + 11008.359 * environmentalSilver.getRH() + 923390.966 * environmentalSilver.getVPD() - 1039000.788;
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 2.9126 * Math.pow(environmentalSilver.getT(), 2) - 100.8 * environmentalSilver.getT() + 928.24;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -19.56 * environmentalSilver.getT() + 4.657 * environmentalSilver.getRH() + 146.92 * environmentalSilver.getVPD() + 99.682;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 776726 * Math.exp(-0.553 * environmentalSilver.getT());
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
            result = 505038 * Math.exp(-1.205 * environmentalSilver.getT());
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = -424.544 * environmentalSilver.getT() + 142.858 * environmentalSilver.getRH() + 5025.656 * environmentalSilver.getVPD() - 3570.167;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -96.852 * environmentalSilver.getT() + 16.548 * environmentalSilver.getRH() + 620.427 * environmentalSilver.getVPD() + 974.846;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = -67.921 * environmentalSilver.getT() + 69.375 * environmentalSilver.getRH() + 2812.273 * environmentalSilver.getVPD() - 4144.951;
        } else {
            result = -1D;
        }

        return result;
    }
}
