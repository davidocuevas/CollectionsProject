/**
 * Task - Is an object that has a priority and description that can be compared to
 * based on the priority of the task.
 * @author Rainier Getuaban, David Cuevas, Ernesto Diaz
 *
 */
class Task implements Comparable<Task> {
    private int priority;
    private String description;

    /**
     * Default constructor
     */
    public Task() {
        priority = 1;
        description = "";
    }

    /**
     * Overloaded constructor
     * @param priority - priority of the object
     * @param description - description of the object
     */
    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    /**
     * Gets priority of the object
     * @return priority - priority of the object
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets description of the object
     * @return description - description of the object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets prioiority of the object
     * @param p - new priority of the object
     */
    public void setPriority(int p) {
        priority = p;
    }

    /**
     * Sets description of the object
     * @param d - new description of the object
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Overrides hashCode() to return the hash code of the description
     * @return description.hashCode - hash code of the description
     */
    @Override
    public int hashCode() {
        return description.hashCode();
    }

    /**
     * Overrides compareTo() to return the difference between the priority of this object and another task
     * @param ot - another task
     * @return priority - ot.getPriority() - difference between priority of this task and the other task
     */
    @Override
    public int compareTo(Task ot) {
        return priority - ot.getPriority();
    }

    /**
     * Overrides equlas() to return if this task is equal to another object
     * @param o - any sort of object
     * @return boolean - true if the other object is a Task object and both descriptions are false. false if else.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Task) {
            Task t = (Task) o;
            return (description.equalsIgnoreCase(t.getDescription()));
        }
        else {
            return false;
        }
    }

    /**
     * Represents string representation of task
     * @returns string representation of task
     */
    @Override
    public String toString() {
        return description;
    }
}