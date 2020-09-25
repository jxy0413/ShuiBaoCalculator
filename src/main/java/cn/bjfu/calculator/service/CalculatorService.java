package cn.bjfu.calculator.service;

import cn.bjfu.calculator.model.EnvironmentalSilver;
import cn.bjfu.calculator.util.CalculatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculatorService {
    @Autowired
    private CalculatorUtils calculatorUtils;

    /*
    青杨根据日、月、年
    */
    public List<Map<String, String>> getQingyangByDay(String date, InputStream in) throws Exception {
        //先挑选出青扬
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> qingyang = getShuzhong(environmentalSilvers, "青杨");
        //挑选出时间
        List<EnvironmentalSilver> shijianList = new ArrayList();
        for(EnvironmentalSilver q : qingyang){
            if(q.getCollectTime().contains(date)){
                shijianList.add(q);
            }
        }
        //返回个集合
        List<Map<String, String>> listMap = new ArrayList<>();
        for(EnvironmentalSilver list:shijianList){
             Map map = new HashMap();
             map.put(list.getCollectTime(),list.getE());
             listMap.add(map);
        }
        return listMap;
    }

    public List<Map<String,String>> getQingyangByMonth(String date, InputStream in) throws Exception{
        //挑选青杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> qingyang = getShuzhong(environmentalSilvers,"青杨");
        //查找相应月份
        String[] month = date.split("月");
        List<EnvironmentalSilver> monthList = new ArrayList<>();
        for (EnvironmentalSilver q:qingyang){
            if (q.getCollectTime().contains(month[0])){
                monthList.add(q);
            }
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:monthList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String,String>> getQingyangByYear(String date, InputStream in) throws Exception{
        //挑选青杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> qingyang = getShuzhong(environmentalSilvers,"青杨");
        //查找相应年份
        List<EnvironmentalSilver> yearList = new ArrayList<>();
        for (EnvironmentalSilver q:qingyang){
            String[] year = date.split("年");
            if (q.getCollectTime().contains(year[0]))
                yearList.add(q);
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:yearList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    /*
    云杉根据日、月、年
     */
    public List<Map<String,String>> getYunshanByDay(String date, InputStream in) throws Exception{
         //挑选云杉
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> yunshan = getShuzhong(environmentalSilvers,"云杉");
        //按天查找
        List<EnvironmentalSilver> dayList = new ArrayList<>();
        for (EnvironmentalSilver y:yunshan){
            if (y.getCollectTime().contains(date))
                dayList.add(y);
        }
        //返回键值列表
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:dayList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String,String>> getYunshanByMonth(String date, InputStream in) throws Exception{
        //挑选云杉
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> yunshan = getShuzhong(environmentalSilvers,"云杉");
        //查找相应月份
        List<EnvironmentalSilver> monthList = new ArrayList<>();
        for (EnvironmentalSilver q:yunshan){
            String[] month = date.split("月");
            if (q.getCollectTime().contains(month[0])){
                monthList.add(q);
            }
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:monthList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String,String>> getYunshanByYear(String date, InputStream in) throws Exception{
        //挑选云杉
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> yunshan = getShuzhong(environmentalSilvers,"云杉");
        //查找相应年份
        List<EnvironmentalSilver> yearList = new ArrayList<>();
        for (EnvironmentalSilver q:yunshan){
            String[] month = date.split("年");
            if (q.getCollectTime().contains(month[0]))
                yearList.add(q);
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:yearList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    /*
    白杨根据日、月、年
     */
    public List<Map<String,String>> getBaiyangByDay(String date, InputStream in) throws Exception{
        //挑选白杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> baiyang = getShuzhong(environmentalSilvers,"白杨");
        //按天查找
        List<EnvironmentalSilver> dayList = new ArrayList<>();
        for (EnvironmentalSilver y:baiyang){
            if (y.getCollectTime().contains(date))
                dayList.add(y);
        }
        //返回键值列表
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:dayList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String,String>> getBaiyangByMonth(String date, InputStream in) throws Exception{
        //挑选白杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> baiyang = getShuzhong(environmentalSilvers,"白杨");
        //查找相应月份
        List<EnvironmentalSilver> monthList = new ArrayList<>();
        for (EnvironmentalSilver q:baiyang){
            String[] month = date.split("月");
            if (q.getCollectTime().contains(month[0])){
                monthList.add(q);
            }
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:monthList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String,String>> getBaiyangByYear(String date, InputStream in) throws Exception{
        //挑选白杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> baiyang = getShuzhong(environmentalSilvers,"白杨");
        //查找相应年份
        List<EnvironmentalSilver> yearList = new ArrayList<>();
        for (EnvironmentalSilver q:baiyang){
            String[] month = date.split("年");
            if (q.getCollectTime().contains(month[0]))
                yearList.add(q);
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:yearList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<EnvironmentalSilver> getShuzhong(List<EnvironmentalSilver> list,String shuzhong){
        List<EnvironmentalSilver> shuzhongList = new ArrayList<>();
        for(EnvironmentalSilver e:list){
            if(shuzhong.equals(e.getShuzhou())){
                shuzhongList.add(e);
            }
        }
        return shuzhongList;
    }

    public List<Map<String, String>> getLuoyesongByDay(String date, InputStream in) throws Exception{
        //挑选白杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> baiyang = getShuzhong(environmentalSilvers,"落叶松");
        //按天查找
        List<EnvironmentalSilver> dayList = new ArrayList<>();
        for (EnvironmentalSilver y:baiyang){
            if (y.getCollectTime().contains(date))
                dayList.add(y);
        }
        //返回键值列表
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:dayList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String, String>> getLuoyesongByMonth(String date, InputStream in)throws Exception{
        //挑选白杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> baiyang = getShuzhong(environmentalSilvers,"落叶松");
        //查找相应月份
        List<EnvironmentalSilver> monthList = new ArrayList<>();
        for (EnvironmentalSilver q:baiyang){
            String[] month = date.split("月");
            if (q.getCollectTime().contains(month[0])){
                monthList.add(q);
            }
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:monthList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }

    public List<Map<String, String>> getLuoyesongByYear(String date, InputStream in)throws Exception {
        //挑选白杨
        List<EnvironmentalSilver> environmentalSilvers = calculatorUtils.importExcel(in);
        List<EnvironmentalSilver> baiyang = getShuzhong(environmentalSilvers,"落叶松");
        //查找相应年份
        List<EnvironmentalSilver> yearList = new ArrayList<>();
        for (EnvironmentalSilver q:baiyang){
            String[] month = date.split("年");
            if (q.getCollectTime().contains(month[0]))
                yearList.add(q);
        }
        //返回键值集合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (EnvironmentalSilver list:yearList){
            Map map = new HashMap();
            map.put(list.getCollectTime(),list.getE());
            mapList.add(map);
        }
        return mapList;
    }
}
