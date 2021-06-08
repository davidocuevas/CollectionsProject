import java.util.ListIterator;

/**
 *
 * MiniWP - Is an object for a Mini Word Processor where a user inputs a word and can insert,
 * search, and delete characters depending on where their cursor is.
 * @author Rainier Getuaban, David Cuevas, Ernesto Diaz
 *
 */
public class MiniWP implements MiniWPI {

    private String initialString;

    /**
     * Default Constructor
     */
    public MiniWP() {
        initialString = "";
    }

    /**
     * Overloaded Constructor
     * @param initialString - user input for the string in the word processor
     */
    public MiniWP(String initialString) {
        this.initialString = initialString;
        for (int i = 0; i < this.initialString.length(); ++i) {
            left.push(initialString.charAt(i));
        }
    }

    /**
     * Detects if the cursor is at the start
     * @return left.empty() - returns true if left node is null, returns false if there is a left node
     */
    public boolean isAtStart() {
        return left.empty();
    }

    /**
     * Detects if the cursor is a the end
     * @return right.empty() - returns true if right node is null, returns false if there is a right node
     */
    public boolean isAtEnd() {
        return right.empty();
    }

    /**
     * Inserts character
     * @param c
     */
    public void insertChar(char c) {
        left.push(c);
    }

    /**
     * Moves cursor to the left
     */
    public void moveLeft() {
        right.push(left.pop());
    }

    /**
     * Moves cursor to the right
     */
    public void moveRight() {
        left.push(right.pop());
    }

    /**
     * Removes character to the left
     */
    public void backspace() {
        left.pop();
    }

    /**
     * Removes a character to the right
     */
    public void delete() {
        right.pop();
    }

    /**
     * Moves cursor to the beginning of the stack
     */
    public void moveToStart() {
        while (!left.empty()) {
            right.push(left.pop());
        }
    }

    /**
     * Moves cursor to the end of the stack
     */
    public void moveToEnd() {
        while (!right.empty()) {
            left.push(right.pop());
        }
    }

    /**
     * Finds a character and moves the cursor to the spot to the right of the cursor
     * @param c - user's character that will be found
     * @return - true if inLeft and inRight are equal to -1, false if else
     */
    public boolean search(char c) {
        int inLeft = left.search(c);
        int inRight = right.search(c);

        if (inLeft == -1 && inRight == -1) {
            return false;
        }

        if (inLeft != -1) {
            while (left.peek() != c) {
                right.push(left.pop());
            }
        }

        // cursor is always being placed to right of found char
        else if (inRight != -1) {
            while (left.peek() != c) {
                left.push(right.pop());
            }
        }

        return true;
    }

    /**
     * Processes command based on user input
     * @param s - usert defined command
     * @throws IllegalArgumentException
     */
    public void processCommand(String s) throws IllegalArgumentException {

        String[] cmd = s.trim().split(" ");

        if (cmd.length > 2 || cmd.length < 1) {
            throw new IllegalArgumentException("Invalid format of command found!");
        }

        cmd[0] = cmd[0].toLowerCase();

        switch (cmd[0]) {
            case "insert": {

                if (cmd.length == 1) {
                    throw new IllegalArgumentException("Character to be inserted is not provided!");
                }
                if (cmd[1].length() > 1) {
                    throw new IllegalArgumentException("Character to be inserted is InValid!");
                }

                insertChar(cmd[1].charAt(0));
                break;
            }

            case "move": {

                cmd[1] = cmd[1].toLowerCase();

                switch (cmd[1]) {
                    case "left":
                        moveLeft();
                        ;
                        break;

                    case "right":
                        moveRight();
                        ;
                        break;

                    case "end":
                        moveToEnd();
                        break;

                    case "start":
                        moveToStart();
                        break;

                    default:
                        throw new IllegalArgumentException("You can only move to either left or right!");
                }

                break;
            }

            case "search": {

                if (cmd.length == 1) {
                    throw new IllegalArgumentException("Character to be searched is not provided!");
                }

                if (cmd[1].length() > 1) {
                    throw new IllegalArgumentException("Character to be searched is InValid!");
                }

                search(cmd[1].charAt(0));

                break;
            }

            case "backspace": {
                if (cmd.length > 1) {
                    throw new IllegalArgumentException("backpace instruction does accept any arguments!");
                }

                backspace();
                break;
            }

            case "delete": {
                if (cmd.length > 1) {
                    throw new IllegalArgumentException("delete instruction does accept any arguments!");
                }

                delete();
                break;
            }

            case "quit": {
                if (cmd.length > 1 ) {
                    throw new IllegalArgumentException("Invalid Arguments provided!");
                }
            }
            default: {
                throw new IllegalArgumentException("Invalid Command provided!");
            }
        }

        printtest(s);
    }

    /**
     * Prints out the command and the results
     * @param s - String of command
     */
    public void printtest(String s) {
        System.out.println(s + ": " + this.toStringCursor());
    }

    /**
     * Overrides toString() to print the user's word along with the cursor in the correct position
     * @return
     */
    @Override
    public String toString() {
        String res = left + " ";

        ListIterator li = right.listIterator(right.size());

        if (right.empty()) {
            return res + right;
        }

        res += "[" + li.previous();

        // Iterate in reverse.
        while(li.hasPrevious()) {
            res += ", " + li.previous();
        }

        return res + "]";
    }

    /**
     * Prints the user's word along with the cursor in the correct position
     * @return
     */
    public String toStringCursor() {
        return toString();
    }
}
