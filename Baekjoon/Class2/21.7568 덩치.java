import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static class Person {
        int weight, height;
        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
        public boolean isSmaller(Person person) {
            return this.weight < person.weight && this.height < person.height;
        }
    }

    public static void main(String[] args) throws IOException {
        int n;
        Person[] people;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        people = new Person[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++) {
            int rank = 1; // i의 등수
            for (int j = 0; j < n; j++) {
                if (people[i].isSmaller(people[j]))
                    rank++;
            }
            sb.append(rank).append(' ');
        }
        System.out.print(sb);
        br.close();
    }
}