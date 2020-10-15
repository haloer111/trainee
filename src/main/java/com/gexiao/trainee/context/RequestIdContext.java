package com.gexiao.trainee.context;

import java.util.UUID;

/**
 * RequestId的上下文环境，
 * RequestId：一次request请求的唯一标识
 */
public class RequestIdContext {
    /**
     * requestId的线程存储器
     */
    private static ThreadLocal<String> requestIdHolder = new ThreadLocal<>();
    /**
     * 请求头中的requestId的key值
     */
    public static final String REQUEST_ID_KEY = "x=requestId";
    /**
     * MDC中存放的requestId的key值
     */
    public static final String REQUEST_ID_MDC_KEY = "requestId";

    public static String getRequestId() {
        return requestIdHolder.get();
    }

    public static void setRequestId(String requestId){
        requestIdHolder.set(requestId);
    }

    public static String init(){
        String requestId = UUID.randomUUID().toString();
        requestId = requestId.replace("-","");
        return requestId;
    }
}
