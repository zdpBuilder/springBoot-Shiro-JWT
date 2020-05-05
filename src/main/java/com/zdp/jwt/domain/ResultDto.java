package com.zdp.jwt.domain;

import com.zdp.jwt.utils.EmptyUtils;

import java.util.HashMap;

/**
 * @author zdp
 * @description: 返回数据工具类
 */

public class ResultDto  extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(200),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500),
        /** 无权限 */
        AUTH(403);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /**
     * 初始化一个新创建的 ResultDto 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     */
    public ResultDto(Type type, String msg)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 ResultDto 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResultDto(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (EmptyUtils.objectIsEmpty(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResultDto success()
    {
        return ResultDto.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static ResultDto success(Object data)
    {
        return ResultDto.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultDto success(String msg)
    {
        return ResultDto.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResultDto success(String msg, Object data)
    {
        return new ResultDto(Type.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultDto warn(String msg)
    {
        return ResultDto.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultDto warn(String msg, Object data)
    {
        return new ResultDto(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResultDto error()
    {
        return ResultDto.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultDto error(String msg)
    {
        return ResultDto.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultDto error(String msg, Object data)
    {
        return new ResultDto(Type.ERROR, msg, data);
    }

    /**
     * 返回权限相关消息
     *
     * @return 返回权限相关消息
     */
    public static ResultDto auth()
    {
        return ResultDto.auth("无权限访问");
    }

    /**
     * 返回权限相关消息
     *
     * @return 返回权限相关消息
     */
    public static ResultDto auth(Object data)
    {
        return ResultDto.auth("无权限访问", data);
    }

    /**
     * 返回权限相关消息
     *
     * @param msg 返回权限说明内容
     * @return 返回权限相关消息
     */
    public static ResultDto auth(String msg)
    {
        return ResultDto.auth(msg, null);
    }

    /**
     * 返回权限相关消息
     *
     * @param msg 返回说明内容
     * @param data 数据对象
     * @return 返回权限相关消息
     */
    public static ResultDto auth(String msg, Object data)
    {
        return new ResultDto(Type.AUTH, msg, data);
    }

}
