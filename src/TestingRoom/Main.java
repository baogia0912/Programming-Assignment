package TestingRoom;

public class Main {
    public static void main(String[] args) {
        String[][] x = new String[30][10];

        for (int i = 0; i < x.length; i ++) {
            x[i] = new String[]{String.valueOf(i), String.valueOf(i)};
            System.out.print(x[i][0] + " ");
            System.out.println(x[i][1]);
        }
    }
}
