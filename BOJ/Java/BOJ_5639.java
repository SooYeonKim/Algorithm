import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5639 {
	
	static class Node {
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public void makeChild(int cNum) {
			if (cNum < num) {
				if (this.left == null) this.left = new Node(cNum);
				else this.left.makeChild(cNum);
			} else {
				if (this.right == null) this.right = new Node(cNum);
				else this.right.makeChild(cNum);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) break;
			
			int num = Integer.parseInt(str);
			root.makeChild(num);
		}
		
		postOrder(root);
	}
	
	private static void postOrder(Node node) {
		if (node.left != null) postOrder(node.left);
		if (node.right != null) postOrder(node.right);
		System.out.println(node.num);
	}

}
