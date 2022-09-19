package mm.behavioral.observer;

public class Main {

    public static void main(String[] args) {
        final ChatChannel chatChannel = new ChatChannel("design-patterns");

        final BaseObserver userA = new UserObserver(chatChannel, "andrew");
        final BaseObserver userB = new UserObserver(chatChannel, "ala");
        final BaseObserver adminA = new AdminObserver(chatChannel, "john");
        final BaseObserver adminB = new AdminObserver(chatChannel, "ann");

        System.out.println();
        userA.sendMessage("Hello all");
        System.out.println();
        userB.sendMessage("Hi Andrew");
        System.out.println();
        adminA.sendMessage("ann they can't see what we write");
        System.out.println();
        adminB.sendMessage("Yes I know");
    }
}
