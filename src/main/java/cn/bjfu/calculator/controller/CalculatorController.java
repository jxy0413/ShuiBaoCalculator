package cn.bjfu.calculator.controller;

import cn.bjfu.calculator.model.ResultModel;
import cn.bjfu.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
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
    public ResultModel getQingyangByDay(String date,InputStream inputStream) throws Exception{
         List<Map<String,String>> list = calculatorService.getQingyangByDay(date,inputStream);
         if (!list.isEmpty())
             return ResultModel.ok(list);
         return  ResultModel.error("404","error");
    }

    /**
     * 返回青杨某一月做一个图
     */
    @GetMapping("/getQingyangByMonth")
    public ResultModel getQingyangByMonth(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getQingyangByMonth(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回青杨某一年做一个图
     */
    @GetMapping("/getQingyangByYear")
    public ResultModel getQingyangByYear(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getQingyangByYear(date,inputStream);
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
    public ResultModel getYunshanByDay(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getYunshanByDay(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回云杉某一月做一个图
     */
    @GetMapping("/getYunshanByMonth")
    public ResultModel getYunshanByMonth(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getQingyangByMonth(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回云杉某一年做一个图
     */
    @GetMapping("/getYunshanByYear")
    public ResultModel getYunshanByYear(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getYunshanByYear(date,inputStream);
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
    public ResultModel getBaiyangByDay(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getBaiyangByDay(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回白杨某一月做一个图
     */
    @GetMapping("/getBaiyangByMonth")
    public ResultModel getBaiyangByMonth(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getBaiyangByMonth(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回白杨某一年做一个图
     */
    @GetMapping("/getBaiyangByYear")
    public ResultModel getBaiyangByYear(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getBaiyangByYear(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    @PostMapping("/putFile")
    public ResultModel putFile(@RequestParam("file")MultipartFile file,String date)throws Exception{
        ResultModel res =getQingyangByDay(date,file.getInputStream());
        ResultModel res1 = getBaiyangByMonth(date, file.getInputStream());
        Object arr [] =new Object[12];
        arr[0] =res.getData();
        arr[1] =res1.getData();
        return ResultModel.ok(arr);
    }


}
