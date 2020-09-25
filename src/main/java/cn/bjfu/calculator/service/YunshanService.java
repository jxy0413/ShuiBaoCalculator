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
public class YunshanService {

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
            result = 415.27 * Math.exp(0.018 * environmentalSilver.getRH());
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 1130.1 * Math.exp(-0.368 * environmentalSilver.getT());
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 12.391 * Math.exp(0.0939 * environmentalSilver.getT());
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 785.99 * Math.exp(0.0383 * environmentalSilver.getRH());
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
            result = -99.11 * environmentalSilver.getRH() + 9975.2;
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 59.658 * Math.pow(environmentalSilver.getRH(), 2) - 1860.7 * environmentalSilver.getRH() + 14610;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 11108 * Math.exp(-0.102 * environmentalSilver.getT());
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = -10604 * environmentalSilver.getT() + 209029;
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
            //  result = 7*environmentalSilver.getE()+08e-2.003T
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 7.6733 * Math.pow(environmentalSilver.getRH(), 2) - 1242.1 * environmentalSilver.getRH() + 50152;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = -646.2 * environmentalSilver.getT() + 11531;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 177.25 * Math.pow(environmentalSilver.getT(), 2) - 3966.8 * environmentalSilver.getT() + 22218;
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
            //result = 1*environmentalSilver.getE()+07e-0.91RH
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 1203.1 * Math.exp(-0.11 * environmentalSilver.getRH());
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 395.36 * Math.log(environmentalSilver.getT()) - 1229.4;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = -213.97 * Math.pow(environmentalSilver.getRH(), 2) + 7698.2 * environmentalSilver.getRH() - 68750;
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
            result = -73.227 * Math.pow(environmentalSilver.getT(), 2) + 1186.1 * environmentalSilver.getT() - 4722.1;
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = 654.21 * Math.log(environmentalSilver.getT()) - 2619;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 521.36 * Math.pow(environmentalSilver.getT(), 2) - 20732 * environmentalSilver.getT() + 206330;
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = -28018 * Math.log(environmentalSilver.getRH()) + 89078;
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
            result = 2670.1 * Math.pow(environmentalSilver.getT(), 2) - 16425 * environmentalSilver.getT() + 28631;
        } else if (hour >= 8 && hour <= 14) { // 08:00-15:00
            result = -638.426 * environmentalSilver.getT() + 50.558 * environmentalSilver.getRH() + 6926.777 * environmentalSilver.getVPD() + 1535.506;
        } else if (hour >= 15 && hour <= 20) { // 15:00-20:00
            result = 328.39 * Math.exp(0.0676 * environmentalSilver.getT());
        } else if (hour >= 20 && hour <= 23) { // 20:00-24:00
            result = 9725.3 * Math.exp(-0.076 * environmentalSilver.getT());
        } else {
            result = -1D;
        }

        return result;
    }
}
