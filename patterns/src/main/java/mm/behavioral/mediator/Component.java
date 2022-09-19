package mm.behavioral.mediator;

public interface Component {

    public void sendRequest();

    default void sendRequest(String context) {
        sendRequest();
    }
}
