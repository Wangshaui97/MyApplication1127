package com.bawei.www.dome2;

public class MobileBean {

    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":"c975055bda678660","appsecret":"8706624035DC05804F3E85A14103D996","createtime":"2018-11-27T18:58:03","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18811795066","money":null,"nickname":null,"password":"7F14BAAF818358E25E2D9C5259AA47DD","praiseNum":null,"token":"3DB4F86834F669C01A58624BAE1A9A6C","uid":23012,"userId":null,"username":"18811795066"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : c975055bda678660
         * appsecret : 8706624035DC05804F3E85A14103D996
         * createtime : 2018-11-27T18:58:03
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 18811795066
         * money : null
         * nickname : null
         * password : 7F14BAAF818358E25E2D9C5259AA47DD
         * praiseNum : null
         * token : 3DB4F86834F669C01A58624BAE1A9A6C
         * uid : 23012
         * userId : null
         * username : 18811795066
         */

        private String mobile;
        private String password;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
