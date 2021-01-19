package week1;

import java.net.*;
import java.io.*;
import java.util.Arrays;

public class EchoThread extends Thread {
    protected Socket socket;
    private static final int WAITING = 0;
    private static final int INPUT = 1;

    private int state = WAITING;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        InputStream input = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            input = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(input));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
            return;
        }
        String inputLine = "";
        String outputLine = "";
        while (true) {
            try {
                if (state == WAITING) {
                    outputLine = "Input a list of number";
                    out.println(outputLine);
                    state = INPUT;
                } else if (state == INPUT) {
                    inputLine = in.readLine();
                    String[] numStringArr = inputLine.split("\\,");
                    int highest = Integer.MIN_VALUE;
                    int lowest = Integer.MAX_VALUE;
                    for (int i = 0; i < numStringArr.length; i++) {
                        int number = Integer.parseInt(numStringArr[i]);
                        if (number > highest) {
                            highest = number;
                        }

                        if (number < lowest) {
                            lowest = number;
                        }
                        outputLine = "Highest number is " + highest + ", " + "lowest number is " + lowest;
                    }
                    out.println(outputLine);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}