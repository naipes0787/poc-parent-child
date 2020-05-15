package ar.com.wolox.api.services;

import ar.com.wolox.api.models.RequestInformation;
import ar.com.wolox.utils.Greeter;

public class ConnectionService {

    public void connect() {
        RequestInformation.Builder requestInformationBuilder = new RequestInformation.Builder();
        RequestInformation requestInformation = requestInformationBuilder
            .withUser("Usuario")
            .withSourceAccount("MyAccount")
            .withTargetAccount("MyFriendAccount")
            .withAmount(100)
            .build();
        requestInformation.send();

        Greeter.sayGoodbye("Leandro");

    }

}
