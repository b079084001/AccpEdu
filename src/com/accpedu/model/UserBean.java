package com.accpedu.model;

public class UserBean {
    private int userNo;
    private String userId;
    private String userPwd;
    private String userRole;

    public UserBean() {
    }

    public void setUserNo(int userNo){
        this.userNo=userNo;
    }
    public int getUserNo(){
        return this.userNo;
    }

    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
        return this.userId;
    }

    public void setUserPwd(String userPwd){
        this.userPwd=userPwd;
    }
    public String getUserPwd(){
        return this.userPwd;
    }

    public void setUserRole(String userRole){
        this.userRole=userRole;
    }
    public String getUserRole(){
        return this.userRole;
    }
}
