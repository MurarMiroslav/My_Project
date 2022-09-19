package mm.behavioral.mediator;

public class Main {

    public static void main(String[] args) {
        final ActionAppliedMessage actionAppliedMessage = new ActionAppliedMessage();
        final SelectOptions selectOptions = new SelectOptions();
        final WarningMessage warningMessage = new WarningMessage();

        final Mediator mediator = new UserActionMediator(actionAppliedMessage, selectOptions, warningMessage);

        selectOptions.sendRequest("load");
        selectOptions.sendRequest("save");
        selectOptions.sendRequest("restart");
        warningMessage.sendRequest("hide");
    }
}
