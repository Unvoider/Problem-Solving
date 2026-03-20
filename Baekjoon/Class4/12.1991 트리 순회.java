import java.io.*;
import java.util.HashMap;

class Main {
    private static class TreeNode {
        char left, right;
        public TreeNode(char left, char right) { this.left = left; this.right = right; }
    }

    private static final char EMPTY_NODE = '.';

    private static HashMap<Character, TreeNode> tree = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    private static void preorder(char node) {
        if (node == EMPTY_NODE) return;
        sb.append(node);
        preorder(tree.get(node).left);
        preorder(tree.get(node).right);
    }

    private static void inorder(char node) {
        if (node == EMPTY_NODE) return;
        inorder(tree.get(node).left);
        sb.append(node);
        inorder(tree.get(node).right);
    }

    private static void postorder(char node) {
        if (node == EMPTY_NODE) return;
        postorder(tree.get(node).left);
        postorder(tree.get(node).right);
        sb.append(node);
    }

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) { // 이진 트리
            String line = br.readLine();
            tree.put(line.charAt(0), new TreeNode(line.charAt(2), line.charAt(4)));
        }

        preorder('A'); sb.append('\n'); // 탐색
        inorder('A'); sb.append('\n');
        postorder('A'); sb.append('\n');
        System.out.print(sb);
        br.close();
    }
}