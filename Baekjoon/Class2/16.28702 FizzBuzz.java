import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            int value;
            try { // 숫자인 입력 찾기
                value = Integer.parseInt(br.readLine());
            }
            catch (NumberFormatException e) {
                continue;
            }
            value += 3 - i; // 다음 숫자
            if(value % 15 == 0) System.out.print("FizzBuzz"); // 출력
            else if(value % 3 == 0) System.out.print("Fizz");
            else if(value % 5 == 0) System.out.print("Buzz");
            else System.out.print(value);
            break;
        }
        br.close();
    }
}