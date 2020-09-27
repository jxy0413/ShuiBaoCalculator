package cn.bjfu.calculator.controller;

import cn.bjfu.calculator.model.ResultModel;
import cn.bjfu.calculator.model.ThirdModel;
import cn.bjfu.calculator.model.ThirdModelShuzhong;
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


    /**
     * 作图 返回落叶松某一天做一个图
     * @param date
     * @return
     */
    @GetMapping("/getLuoyesongByDay")
    public ResultModel getLuoyesongByDay(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getLuoyesongByDay(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回白杨某一月做一个图
     */
    @GetMapping("/getLuoyesongByMonth")
    public ResultModel getLuoyesongByMonth(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getLuoyesongByMonth(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 返回白杨某一年做一个图
     */
    @GetMapping("/getLuoyesongByYear")
    public ResultModel getLuoyesongByYear(String date,InputStream inputStream) throws Exception{
        List<Map<String,String>> list = calculatorService.getLuoyesongByYear(date,inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 日序 时许 温度
     */
    @GetMapping("/getThirdByWendu")
    public ResultModel getThirdByWendu(InputStream inputStream) throws Exception{
        List<ThirdModel> list = calculatorService.getThirdByWendu( inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 日序 时许 温度
     */
    @GetMapping("/getThirdByShidu")
    public ResultModel getThirdByShidu(InputStream inputStream) throws Exception{
        List<ThirdModel> list = calculatorService.getThirdByShidu( inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    /**
     * 日序 时许 温度
     */
    @GetMapping("/getThirdBybaihua")
    public ResultModel getThirdBybaiyang(InputStream inputStream) throws Exception{
        List<ThirdModelShuzhong> list = calculatorService.getThirdBybaihua( inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    @GetMapping("/getThirdByLuoyesong")
    public ResultModel getThirdByLuoyesong(InputStream inputStream) throws Exception{
        List<ThirdModelShuzhong> list = calculatorService.getThirdByLuoyesong( inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }

    @GetMapping("/getThirdQingyang")
    public ResultModel getThirdQingyang(InputStream inputStream) throws Exception{
        List<ThirdModelShuzhong> list = calculatorService.getThirdQingyang( inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }


    @GetMapping("/getThirdByYunshan")
    public ResultModel getThirdByYunshan(InputStream inputStream) throws Exception{
        List<ThirdModelShuzhong> list = calculatorService.getThirdByYunshan( inputStream);
        if (!list.isEmpty())
            return ResultModel.ok(list);
        return  ResultModel.error("404","error");
    }


    @PostMapping("/putFile")
    public ResultModel putFile(@RequestParam("file")MultipartFile file,String date)throws Exception{
        ResultModel res =getBaiyangByDay(date,file.getInputStream());
        ResultModel res1 = getBaiyangByMonth(date, file.getInputStream());
        ResultModel res2 = getBaiyangByYear(date, file.getInputStream());
        ResultModel res3 = getQingyangByDay(date,file.getInputStream());
        ResultModel res4 = getQingyangByMonth(date, file.getInputStream());
        ResultModel res5 = getQingyangByYear(date, file.getInputStream());
        ResultModel res6 = getYunshanByDay(date, file.getInputStream());
        ResultModel res7 = getYunshanByMonth(date, file.getInputStream());
        ResultModel res8 = getYunshanByYear(date, file.getInputStream());
        ResultModel res9 = getLuoyesongByDay(date, file.getInputStream());
        ResultModel res10 = getLuoyesongByMonth(date, file.getInputStream());
        ResultModel res11 = getLuoyesongByYear(date, file.getInputStream());
        ResultModel res12 = getThirdByWendu(file.getInputStream());
        ResultModel res13 = getThirdByShidu(file.getInputStream());
        ResultModel res14 = getThirdBybaiyang(file.getInputStream());
        ResultModel res15 = getThirdByLuoyesong(file.getInputStream());
        ResultModel res16 = getThirdQingyang(file.getInputStream());
        ResultModel res17 = getThirdByYunshan(file.getInputStream());
        Object arr [] =new Object[18];
        arr[0] =res.getData();
        arr[1] =res1.getData();
        arr[2] =res2.getData();
        arr[3] =res3.getData();
        arr[4] =res4.getData();
        arr[5] =res5.getData();
        arr[6] =res6.getData();
        arr[7] =res7.getData();
        arr[8] =res8.getData();
        arr[9] =res9.getData();
        arr[10] =res10.getData();
        arr[11] =res11.getData();
        arr[12] =res12.getData();
        arr[13] =res13.getData();
        arr[14] =res14.getData();
        arr[15] =res15.getData();
        arr[16] =res16.getData();
        arr[17] =res17.getData();
        return ResultModel.ok(arr);
    }


}
