package com.Javaboy.vhr.bean;


public class RespBean {

    private Integer status;
    private String massage;
    private Object obj;

    public static RespBean ok(String msg,Object obj){

        return new RespBean(200,msg,obj);
    }

    public static RespBean ok(String msg){

        return new RespBean(200,msg,null);
    }

    public static RespBean error(String msg,Object obj){

        return new RespBean(500,msg,obj);
    }

    public static RespBean error(String msg){

        return new RespBean(500,msg,null);
    }

    private RespBean(){

    }

    private RespBean(Integer status,String massage,Object obj){
        this.status =status;
        this.massage =massage;
        this.obj = obj;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
