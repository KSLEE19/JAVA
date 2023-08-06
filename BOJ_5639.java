import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String value = br.readLine();
            if(value == null || value.isEmpty()){
                break;
            }
            Node node = new Node(Integer.parseInt(value));
            insert(root, node);
        }
        postOrderTraversal(root);
    }

    static void insert(Node root,Node node) {
        if (root.value > node.value) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else if (root.value < node.value) {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    static void postOrderTraversal(Node root) {
        if (root.left != null) {
            postOrderTraversal(root.left);
        }
        if (root.right != null) {
            postOrderTraversal(root.right);
        }
        System.out.println(root.value);
    }

    static class Node{
        public int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
