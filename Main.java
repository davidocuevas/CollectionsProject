import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("              WELCOME FELLOW HUMAN               ");
        System.out.println("-------------------------------------------------");
        System.out.println("Please choose one of the following options bellow");
        System.out.println("-------------------------------------------------");
        System.out.println("TaskHub (Gives you the ability to create an agenda\n and set each item with a priority value)\n");
        System.out.println("WordProcessor (Will allow you to edit text however\n you'd like!!)\n");
        System.out.println("quit (You can always quit the program and try some\n other time!!)\n");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter: ");
        Scanner in = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            String input = in.nextLine();
            switch (input) {
                case "TaskHub":
                    new TaskHub().TaskHub();
                    break;
                case "WordProcessor":
                    new WordProcessor().WordProcessor();
                    break;
                case "quit":
                    System.out.println("Exiting program, main menu: ");
                    break;
                default:
                    System.out.println("Command does not exist.");
            }
        }
    }
}