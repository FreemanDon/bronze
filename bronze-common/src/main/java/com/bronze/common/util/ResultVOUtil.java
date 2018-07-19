package com.bronze.common.util;

import com.bronze.common.enums.ResultEnum;
import com.bronze.common.vo.ResultVO;

/**
 * @author Don
 * @version V1.0
 * @Package: com.imooc.utils
 * @Description: TODO
 * @Creation Date:2018-03-21
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMeg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMeg(msg);
        return resultVO;
    }
}