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
         return ResultModel.ok(list);
    }
}
