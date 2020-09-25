package cn.bjfu.calculator.model;

import lombok.Data;

import java.util.Date;

@Data
public class EnvironmentalSilver {
  private String shuzhou; // 树种
  private Double E; // 蒸腾量
  private Double LH; // 海拔
  private Double T; // 温度
  private Double P; // 气压
  private Double K; // 消光系数
  private Double LAI; // 叶面积指数
  private Double Rn; // 净辐射
  private Double p1; // 空气密度
  private Double u; // 风速
  private Double Z; // 蒸腾以上2m高度
  private Double d; // 0.75被树高
  private Double Z0; // 0.1倍树高
  private Double RH; // 相对空气湿度
  private Double RST; //
  private Double VPD; // 包和水气压差
  private String collectTime; // 收集时间
  private Date collectDate; // 收集时间格式后的数据
}
