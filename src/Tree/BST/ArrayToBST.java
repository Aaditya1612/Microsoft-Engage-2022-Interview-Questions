package Tree.BST;

public class ArrayToBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int data) {
            this.val = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        if (arr.length == 0) {
            printTree(null);
            System.exit(0);
        }

        TreeNode root = createTree(arr, 0, arr.length-1);

        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode createTree(int[] arr, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createTree(arr, left, mid - 1);
        root.right = createTree(arr, mid + 1, right);
        return root;
    }
}
