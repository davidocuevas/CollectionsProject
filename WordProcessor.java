import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;;

/**
 * WordProcessor is meant to act as the main driver for the whole entirety of the Part 2 of the project
 * @author Rainier Getuaban, David Cuevas, Ernesto Diaz
 *
 */
public class WordProcessor {

    public void WordProcessor(){
        Scanner in = new Scanner(System.in);
        Queue<String> dqueue = new LinkedList<>();


        System.out.println("----------------------------------------------");
        System.out.println(" Welcome to Mini-Word Processor\n Please enter an option: \n\t " +
                "wp (runs word possessor) \n\t" +
                "test (runs the hard coded tests)\n\t" +
                "quit (exit this program)");
        System.out.println("-----------------------------------------------");
        System.out.print("Enter: ");

        boolean gate0 = false;
        while(!gate0) {
            String user_input = in.nextLine();
            String[] command = user_input.split(" ");
            if(command.length >= 1) {
                switch(command[0].toLowerCase()) {

                    case "wp":
                        System.out.println("-----------------------------------------------");
                        Scanner scan = new Scanner(System.in);
                        System.out.print("Enter A Word: ");
                        String user_int = scan.nextLine();
                        MiniWP wp = new MiniWP(user_int);

                        System.out.println("-----------------------------------------------");
                        System.out.println("Command List \n\t " +
                                "insert _ (can insert a character) \n\t " +
                                "move left (moves left) \n\t " +
                                "move right (moves right) \n\t " +
                                "search (can search a character) \n\t " +
                                "backspace (moves back) \n\t " +
                                "delete (deletes character) \n\t " +
                                "move to end (moves to the end) \n\t " +
                                "move to start (moves to the start) \n\t " +
                                "quit (exit this program)");
                        boolean gate = false;
                        while(!gate) {
                            String inp1 = in.nextLine();
                            switch (inp1){
                                case "quit":
                                    System.out.println("Exiting program");
                                    gate = true;
                                    break;
                                default:
                                    dqueue.add(inp1);
                                    System.out.println("initial: " + wp.toStringCursor());

                                    while (!dqueue.isEmpty()) {
                                        try {
                                            wp.processCommand((String) dqueue.poll());
                                        }
                                        catch (Exception ex) {
                                            System.out.println(ex.getMessage());
                                            ex.printStackTrace();
                                        }
                                    }
                            }
                        }
                        break;

                    case "test":
                        test((LinkedList) dqueue);
                        break;

                    case "quit":
                        System.out.println("Exiting program to WordProcessor");
                        gate0 = true;
                        break;

                    default:
                        System.out.println("Command does not exist.");
                }
            }
            else {
                System.out.println("Invalid command.");
            }
        }
    }

    public static void test(LinkedList dqueue) {
        MiniWP wp = new MiniWP("initial contents");

        dqueue.add("insert J");
        dqueue.add("insert K");
        dqueue.add("insert L");
        dqueue.add("move left");
        dqueue.add("move right");
        dqueue.add("move left");
        dqueue.add("move left");
        dqueue.add("search K");

        System.out.println("initial: " + wp.toStringCursor());

        while (!dqueue.isEmpty()) {

            try {
                wp.processCommand((String) dqueue.poll());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }

        }

    }

    @Override
    public String toString() {
        return "WordProcessor{}";
    }
}
