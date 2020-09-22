package cn.bjfu.calculator.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "通用结果数据模型")
public class ResultModel<E> {
    @ApiModelProperty(name = "code", value = "响应代码", example = "200")
    private String code;
    @ApiModelProperty(name = "msg", value = "响应信息", example = "success")
    private String msg;
    @ApiModelProperty(name = "data", value = "响应数据")
    private E data;

    public ResultModel<E> setData(E data) {
        this.data = data;
        return this;
    }

    public static <E> ResultModel<E> ok(E data) {
        ResultModel<E> result = new ResultModel<E>();
        result.code = "200";
        result.msg = "success";
        result.data = data;
        return result;
    }

    public static <E> ResultModel<E> error(String code, String error) {
        ResultModel<E> result = new ResultModel<E>();
        result.code = code;
        result.msg = error;
        return result;
    }

    public static <E> ResultModel<E> error(String error) {
        return error("470", error);
    }

}