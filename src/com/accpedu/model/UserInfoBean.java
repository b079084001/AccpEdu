package com.accpedu.model;

public class UserInfoBean {
    private int userNo;     //用户序号
    private String userId;  //用户名（userid:301A007)
    private String userPwd; //密码(userpwd:111111)
    //private String ifFirst; //是否第一次登录(isfirst:是)
    private String roleId;  //用户角色(roleid:accpno_01)

    public UserInfoBean() {
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
/*
    public String getIfFirst() {
        return ifFirst;
    }

    public void setIfFirst(String ifFirst) {
        this.ifFirst = ifFirst;
    }
*/
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
