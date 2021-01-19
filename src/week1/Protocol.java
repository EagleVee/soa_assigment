package week1;

public class Protocol {
    private static final int WAITING = 0;
    private static final int INPUT = 1;
    private static final int CALCULATING = 2;
    private static final int END = 3;

    private int state = WAITING;

    public String processInput(String theInput) {
        String theOutput = "";

        if (state == WAITING) {
            theOutput = "Input a list of number";
            state = INPUT;
        } else if (state == INPUT) {
            String[] numStringArr = theInput.split("\\,");
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i < numStringArr.length; i++) {
                int number = Integer.parseInt(numStringArr[i]);
                theOutput = theOutput + number + ", ";
                if (number > highest) {
                    highest = number;
                } else if (number < lowest) {
                    lowest = number;
                }
            }

            theOutput = theOutput + "Highest number is " + highest + ", " + "lowest number is " + lowest;
        }

        return theOutput;
    }
}