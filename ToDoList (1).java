import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * ToDoList - Is an object that contains a Priority Queue of Tasks that
 * can be added and deleted/skikpped over.
 * @author Rainier Getuaban, David Cuevas, Ernesto Diaz
 *
 */
class ToDoList {

    private PriorityQueue<Task> tasks;

    /**
     * Default constructor
     */
    public ToDoList() {
        tasks = new PriorityQueue<>();
    }

    /**
     * Adds task. Input must be equal to "add" to add a task, otherwise a task wont be added
     * @param command - type of command entered by user
     */
    public void addTask(String command) {
        String[] add = command.split(" ");

        if (add.length >= 3 && add[0].equals("add")) { //makes sure that the input command is a valid command
            String description = ""; //anything past and including the third word is part of description
            for (int i = 2; i < add.length; i++) {
                description += add[i] + " ";
            }
            description = description.trim();

            try { //try-catch for exceptions
                int priority = Integer.parseInt(add[1]);
                if(priority < 1 || priority > 9){
                    throw new IllegalArgumentException("The priority must be an integer between 1 and 9.");
                }
                Task createdTask = new Task(priority, description);

                for(Task t: tasks) { //checks for if the description already exists in the list
                    if(createdTask.equals(t)) {
                        String errorMsg = "Added task already exists in list. \nCreated task hash code: " + createdTask.hashCode() + "\nExisting task hash code: " + t.hashCode();
                        throw new IllegalArgumentException(errorMsg);
                    }
                }
                tasks.add(createdTask);
            } catch(NumberFormatException e) { //when the priority isn't a valid integer
                System.out.println("The priority must be an integer between 1 and 9.");
            } catch(IllegalArgumentException e) { //when an argument is invalid
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Invalid format for adding task, must be \"Key word: add (priority number) (task description)\"");
        }
    }

    /**
     * Checks and returns next task if there is a next task. If not, prints string.
     * @return t - PriorityQueue of Tasks
     */
    public Task nextTask() {
        Task t = tasks.poll();
        if(t == null) {
            System.out.println("There are no tasks in the list!!.");
        }
        else {
            System.out.println(t);
        }
        return t;
    }

    /**
     * Overrides hashCode() to return the hash code of tasks
     * @return tasks.hashCode - hash code of the tasks priority queue
     */
    @Override
    public int hashCode() {
        return tasks.hashCode();
    }

    /**
     * Overrides toString() to return an array of the tasks
     * @returns tasks.toString() - an array of the tasks
     */
    @Override
    public String toString() {
        return tasks.toString();
    }
}