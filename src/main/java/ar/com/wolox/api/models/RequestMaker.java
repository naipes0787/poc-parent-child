package ar.com.wolox.api.models;

class RequestMaker {

    static void send(RequestInformation requestInformation) {
        System.out.println("Sending the request information: "
            + requestInformation.toString());
    }

}
