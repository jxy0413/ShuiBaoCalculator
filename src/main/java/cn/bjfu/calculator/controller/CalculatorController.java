package cn.bjfu.calculator.controller;

import cn.bjfu.calculator.model.ResultModel;
import cn.bjfu.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CalculatorController {
      @Autowired
      private CalculatorService calculatorService;

    /**
     * 作图 返回青杨这个树种某一天做一个图
     * @param date
     * @return
     *
     */
    @GetMapping("/getQingyangByDay")
    public ResultModel getQingyangByDay(String date) throws Exception{
         List<Map<String,String>> list = calculatorService.getQingyangByDay(date);
         if (!list.isEmpty())
             return ResultModel.ok(list);
         return  ResultModel.error("404","error");
    }

    /**
     * 返回青杨某一月做一个图
     */
    @GetMapping("/getQingyangByMonth")
    public ResultModel getQingyangByMonth(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getQingyangByMonth(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回青杨某一年做一个图
     */
    @GetMapping("/getQingyangByYear")
    public ResultModel getQingyangByYear(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getQingyangByYear(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 作图 返回云杉某一天做一个图
     * @param date
     * @return
     */
    @GetMapping("/getYunshanByDay")
    public ResultModel getYunshanByDay(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getYunshanByDay(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回云杉某一月做一个图
     */
    @GetMapping("/getYunshanByMonth")
    public ResultModel getYunshanByMonth(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getQingyangByMonth(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回云杉某一年做一个图
     */
    @GetMapping("/getYunshanByYear")
    public ResultModel getYunshanByYear(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getYunshanByYear(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 作图 返回白杨某一天做一个图
     * @param date
     * @return
     */
    @GetMapping("/getBaiyangByDay")
    public ResultModel getBaiyangByDay(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getBaiyangByDay(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回白杨某一月做一个图
     */
    @GetMapping("/getBaiyangByMonth")
    public ResultModel getBaiyangByMonth(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getBaiyangByMonth(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回白杨某一年做一个图
     */
    @GetMapping("/getBaiyangByYear")
    public ResultModel getBaiyangByYear(String date) throws Exception{
        List<Map<String,String>> list = calculatorService.getBaiyangByYear(date);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }
}
