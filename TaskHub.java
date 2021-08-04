import java.util.*;

class TaskHub {

    public void TaskHub(){
        Scanner in = new Scanner(System.in);
        ToDoList list = new ToDoList();
        System.out.println("-----------------------------------------------------");
        System.out.println(" Welcome to To Do List\n Please enter an option of the following \n\t " +
                "add priority description (add a new task) \n\t " +
                "next (remove and print most urgent task) \n\t " +
                "test (runs the hard coded tests)\n\t " +
                "quit (exit this program)");
        System.out.println("-----------------------------------------------------");
        System.out.print("Enter: ");
        boolean gate = false;
        while(!gate) {
            String user_input = in.nextLine();
            String[] command = user_input.split(" ");
            if(command.length >= 1) {
                switch(command[0].toLowerCase()) { // sets user input to lowercase to validate input
                    case "add":
                        list.addTask(user_input);
                        break;
                    case "next":
                        list.nextTask();
                        break;
                    case "test":
                        test(list);
                        break;
                    case "quit":
                        System.out.println("Exiting program to TaskHub");
                        gate = true;
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

    public static void test(ToDoList list) {
        System.out.println("Adding the following 6 items to the list.");
        System.out.println("\"add 1 Complete Programming Exercise 15.11\"");
        System.out.println("\"add 8 Read for tomorrow's class\"");
        System.out.println("\"add 3 Soccer practice\"");
        System.out.println("\"add 6 Call parents\"");
        System.out.println("\"add 5 Have dinner with friends\"");
        System.out.println("\"add 9 Sleep well\"");
        list.addTask("add 1 Complete Programming Exercise 15.11");
        list.addTask("add 8 Read for tomorrow's class");
        list.addTask("add 3 Soccer practice");
        list.addTask("add 6 Call parents");
        list.addTask("add 5 Have dinner with friends");
        list.addTask("add 9 Sleep well");

        System.out.println("exception testing for when item already exists");
        System.out.println("Entering 'add 9 Sleep well'");
        list.addTask("add 9 Sleep well");
        System.out.println("Expected: Added task already exists in list.");
        System.out.println("exception testing for bad priority input");
        System.out.println("Entering 'add bad command'");
        list.addTask("add bad command");
        System.out.println("Expected: The priority must be an integer between 1 and 9.");
        System.out.println("\nList to string");
        System.out.println(list + "\n");

        System.out.println("\nEntering 'add 1 test for equals'");
        list.addTask("add 1 test for equals");
        Task equalsTest = new Task(1, "test for equals");
        System.out.println(list.nextTask().equals(equalsTest));
        System.out.println("Expected: true");
        System.out.println("\nEntering 'add 1 test for hashcode'");
        list.addTask("add 1 test for hashcode");
        System.out.println(list.nextTask().hashCode());
        String testDescription = "test for hashcode";
        System.out.println("Expected: " + testDescription.hashCode());
        System.out.println("\nPrinting hash code of ToDoList");
        System.out.println(list.hashCode());

        System.out.println("Priority items");
        list.nextTask();
        System.out.println("Expected: Complete Programming Exercise 15.11");
        list.nextTask();
        System.out.println("Expected: Soccer practice");
        list.nextTask();
        System.out.println("Expected: Have dinner with friends");
        list.nextTask();
        System.out.println("Expected: Call parents");
        list.nextTask();
        System.out.println("Expected: Read for tomorrow's class");
        list.nextTask();
        System.out.println("Expected: Sleep well");
        list.nextTask();
        System.out.println("Expected: There are no tasks in the list.");
    }

    @Override
    public String toString() { //standard coding practice
        return "TaskHub{}";
    }
}


