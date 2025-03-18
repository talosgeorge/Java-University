package isp.lab6.exercise3;

public class UserInterface {
    private LoginSystem loginSystem;
    private OnlineStore onlineStore;

    public UserInterface(LoginSystem loginSystem, OnlineStore onlineStore) {
        this.loginSystem = loginSystem;
        this.onlineStore = onlineStore;
        this.loginSystem.setOnlineStore(onlineStore);
    }

}
