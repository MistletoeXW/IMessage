package net.qiujuer.italker.factory.model.api.account;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class LoginModel {
    private String phone;
    private String password;
    //private String pushId;

    public LoginModel(String account, String password) {
        this.phone = account;
        this.password = password;
    }

    public LoginModel(String account, String password, String pushId) {
        this.phone = account;
        this.password = password;
        //this.pushId = pushId;
    }

    public String getAccount() {
        return phone;
    }

    public void setAccount(String account) {
        this.phone = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getPushId() {
//        return pushId;
//    }
//
//    public void setPushId(String pushId) {
//        this.pushId = pushId;
//    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                //", pushId='" + pushId + '\'' +
                '}';
    }
}
