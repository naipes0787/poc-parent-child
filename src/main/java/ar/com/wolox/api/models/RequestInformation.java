package ar.com.wolox.api.models;

import static org.springframework.util.StringUtils.isEmpty;

import ar.com.wolox.api.exceptions.MissingRequiredPropertiesException;
import ar.com.wolox.api.exceptions.SameAccountException;

public class RequestInformation {

    private String user;
    private String targetAccount;
    private String sourceAccount;
    private double amount;

    private RequestInformation(String user, String targetAccount, String sourceAccount,
        double amount) {
        this.user = user;
        this.targetAccount = targetAccount;
        this.sourceAccount = sourceAccount;
        this.amount = amount;
    }

    public void send() {
        RequestMaker.send(this);
    }

    public static class Builder {
        private String user;
        private String targetAccount;
        private String sourceAccount;
        private double amount;

        public Builder withUser(String user) {
            this.user = user;
            return this;
        }

        public Builder withTargetAccount(String targetAccount) {
            this.targetAccount = targetAccount;
            return this;
        }

        public Builder withSourceAccount(String sourceAccount) {
            this.sourceAccount = sourceAccount;
            return this;
        }

        public Builder withAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public RequestInformation build() {
            if(!isEmpty(user) && !isEmpty(targetAccount) &&
                !isEmpty(sourceAccount) && !isEmpty(amount)) {
                if(!this.sourceAccount.equals(this.targetAccount)) {
                    return new RequestInformation(user, targetAccount, sourceAccount, amount);
                }
                throw new SameAccountException("The target account can't be the same as the "
                    + "source account");
            }
            throw new MissingRequiredPropertiesException();
        }
    }

}
