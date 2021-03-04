import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @since 2021. 2. 18.
* @author Jin
* @see https://www.acmicpc.net/problem/5639
* @mem 20084kb
* @time 420ms
* @caution
*/

public class 이진_검색_트리_5639 {

	public static class Tree {
		int root;
		int left;
		int right;

		public Tree(int root) {
			super();
			this.root = root;
		}

		@Override
		public String toString() {
			return "Tree [root=" + root + ", left=" + left + ", right=" + right + "]";
		}
	}

	static List<Tree> tree;
	static StringBuilder output;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		output = new StringBuilder("");

		tree = new ArrayList<>();
		tree.add(new Tree(Integer.parseInt(br.readLine())));
		
		String s = null;
		while(true) {
			s = br.readLine();
			if(s == null || s.equals("")) break;
			tree.add(new Tree(Integer.parseInt(s)));
		}
	
		int cnt = 0;
		for (int i = 1; i < tree.size(); i++) {
			if (tree.get(i).root < tree.get(i - 1).root) {
				tree.get(i - 1).left = i; 
			} else {
				for (int j = 1; j <= i; j++) {
					if (tree.get(i - j).root > tree.get(i).root) { // 나보다 처음으로 커졌을 때 그 노드의 오른쪽
						int idx = tree.get(i-j).left;
						while(tree.get(idx).right!=0){
							idx = tree.get(idx).right;
						}
						tree.get(idx).right = i;
						break;
					}
					if(j==i) { // 끝까지 올라갔는데 큰 수가 없으면 루트노드의 오른쪽
						tree.get(cnt).right = i; 
						cnt = i;
					}
				}
			}
		}

		// System.out.println(Arrays.toString(tree.toArray()));
		visit(tree.get(0)); // 첫번째가 트리의 루트 노드
		System.out.println(output);

	}// Main
	
	static void visit(Tree node) {
		if (node.left == 0 && node.right == 0) { // 양의 정수만 주어지므로 0은 나올 일 없다.
			output.append(node.root).append("\n");
			return;
		}
		if(node.left != 0) 
			visit(tree.get(node.left)); // 왼쪽 방문		
		if(node.right != 0) 
			visit(tree.get(node.right)); // 오른쪽 방문		
		output.append(node.root).append("\n"); // 루트 방문
	}
}
