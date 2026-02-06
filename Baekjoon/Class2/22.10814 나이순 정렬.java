import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static class Person {
        private int age;
        private String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
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
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(people, (p1, p2) -> p1.age - p2.age);
        for(Person person: people)
            sb.append(person.age).append(' ').append(person.name).append('\n');
        System.out.print(sb.toString());
        br.close();
    }
}