package cn.bjfu.calculator.util;

import cn.bjfu.calculator.model.EnvironmentalSilver;
import com.alibaba.fastjson.JSON;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorUtils {
    public double getResults(EnvironmentalSilver environmentalSilver){
        //System.out.println("----"+environmentalSilver);
        double kaitou,fenmu,fenzi,zhongjian,zhongjianfenmu,x,x1,x2,x3,x4,x5,x6,result;
        double zhishu =environmentalSilver.getLH()/(18400*(1+environmentalSilver.getT()/273));//10上面的数
        kaitou = Math.pow(10,zhishu);
        zhongjian = 4098*(0.618*Math.pow(Math.E,(17.27*environmentalSilver.getT())/(environmentalSilver.getT()+237.3)/(environmentalSilver.getT()+237.3)));
        zhongjianfenmu = 0.665*environmentalSilver.getP()/1000;
        x=(1-Math.pow(Math.E,-environmentalSilver.getK()*environmentalSilver.getLAI()))*environmentalSilver.getRn();
        x1=1012*environmentalSilver.getP1()*1000/0.665*environmentalSilver.getP();
        x2=0.6108*Math.pow(Math.E,17.27*environmentalSilver.getT()/(environmentalSilver.getT()+237.3))*(1-environmentalSilver.getRH());
        x3=4.72/(1+0.54*environmentalSilver.getU()) * Math.log((environmentalSilver.getZ()-environmentalSilver.getD())/environmentalSilver.getZ0())* Math.log((environmentalSilver.getZ()-environmentalSilver.getD())/environmentalSilver.getZ0());
        x4=(1+environmentalSilver.getRST()/(4.72*Math.log(environmentalSilver.getZ()-environmentalSilver.getD())/environmentalSilver.getZ0()*Math.log(environmentalSilver.getZ()-environmentalSilver.getD())/environmentalSilver.getZ0())/(1+0.54*environmentalSilver.getU()));
        fenzi=(kaitou*zhongjian/zhongjianfenmu*x+x1)*x2/x3;
        fenmu=kaitou*(zhongjian/zhongjian)+x4;
        return fenzi/fenmu;
    }
    public List<EnvironmentalSilver> importExcel(String filePath) throws Exception{
        XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = wookbook.getSheet("Sheet1");
        //获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        List<EnvironmentalSilver> list = new ArrayList();
        for(int i=1;i<rows;i++){
            XSSFRow row = sheet.getRow(i);
            if(row!=null){
                //获取到Excel文件中的所有的列
                XSSFCell LHCell = row.getCell(1);
                String LH = getValue(LHCell);
                XSSFCell TCell = row.getCell(2);
                String T = getValue(TCell);
                XSSFCell Pcell = row.getCell(3);
                String P = getValue(Pcell);
                XSSFCell KCell = row.getCell(4);
                String K= getValue(KCell);
                XSSFCell LAICELL = row.getCell(5);
                String LAI = getValue(LAICELL);
                XSSFCell RnCell = row.getCell(6);
                String Rn = getValue(RnCell);
                XSSFCell PCell = row.getCell(7);
                String P1 = getValue(PCell);
                XSSFCell UCell = row.getCell(8);
                String U = getValue(UCell);
                XSSFCell ZCell = row.getCell(9);
                String Z = getValue(ZCell);
                XSSFCell dCell = row.getCell(10);
                String D = getValue(dCell);
                XSSFCell zCell = row.getCell(11);
                String Z0 = getValue(zCell);
                XSSFCell Datecell = row.getCell(12);
                String collectTime = getValue(Datecell);
                XSSFCell shuzhongcell = row.getCell(13);
                String shuzhong = getValue(shuzhongcell);
                XSSFCell shuiqiyacell = row.getCell(14);
                String shuiqiya = getValue(shuiqiyacell);
                XSSFCell RhCell = row.getCell(15);
                String Rh= getValue(RhCell);
                EnvironmentalSilver environmentalSilver = new EnvironmentalSilver();
                environmentalSilver.setLH(Double.parseDouble(LH));
                environmentalSilver.setT(Double.parseDouble(T));
                environmentalSilver.setP(Double.parseDouble(P));
                environmentalSilver.setK(Double.parseDouble(K));
                environmentalSilver.setLAI(Double.parseDouble(LAI));
                environmentalSilver.setRn(Double.parseDouble(Rn));
                environmentalSilver.setP1(Double.parseDouble(P1));
                environmentalSilver.setU(Double.parseDouble(U));
                environmentalSilver.setZ(Double.parseDouble(Z));
                environmentalSilver.setD(Double.parseDouble(D));
                environmentalSilver.setZ0(Double.parseDouble(Z0));
                environmentalSilver.setCollectTime(collectTime);
                environmentalSilver.setShuzhou(shuzhong);
                environmentalSilver.setVPD(Double.parseDouble(shuiqiya));
                environmentalSilver.setRH(Double.parseDouble(Rh));
                //todo 需要一个方法 算出RST
                Double rst = getRsT(environmentalSilver);
                environmentalSilver.setRST(rst);
                double result = getResults(environmentalSilver);
                environmentalSilver.setE(result);
                System.out.println("888"+environmentalSilver);
                list.add(environmentalSilver);
            }
        }
        //System.out.println("list = "+ JSON.toJSONString(list));
        return list;
    }

    private Double getRsT(EnvironmentalSilver environmentalSilver) {
        return 1000.0;
    }

    private String getValue(XSSFCell xSSFCell){
        if(null == xSSFCell){
            return "";
        }
        if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值  
            return String.valueOf(xSSFCell.getBooleanCellValue());
        } else if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值  
            return String.valueOf(xSSFCell.getNumericCellValue());
        }else{
            // 返回字符串类型的值  
            return String.valueOf(xSSFCell.getStringCellValue());
        }
    }
}
