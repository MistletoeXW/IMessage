package net.qiujuer.italker.factory.model.api.account;

/**
 * 注册使用的请求Model
 *
 */
public class RegisterModel {
    private String phone;
    private String password;
    private String name;
    private String pushId;

    public RegisterModel(String account, String password, String name) {
        this(account, password, name, null);
    }

    public RegisterModel(String account, String password, String name, String pushId) {
        this.phone = account;
        this.password = password;
        this.name = name;
        this.pushId = pushId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "account='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", pushId='" + pushId + '\'' +
                '}';
    }
}
