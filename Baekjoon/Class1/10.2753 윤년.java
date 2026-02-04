import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        int year;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        year = Integer.parseInt(br.readLine());
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            System.out.print("1");
        else
            System.out.print("0");
        br.close();
    }
}