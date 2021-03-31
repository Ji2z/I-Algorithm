import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
* @since 2021. 2. 18.
* @author
* @see https://www.acmicpc.net/problem/1991
* @mem 14612 kb
* @time 148ms
* @caution
*/

public class 트리순회_1991 {

	static StringBuilder output = new StringBuilder();

	static class Tree implements Comparable<Tree> {
		String root;
		int left;
		int right;

		public Tree(String root) {
			super();
			this.root = root;
		}

		@Override
		public String toString() {
			return "Tree [root=" + root + ", left=" + left + ", right=" + right + "]";
		}

		@Override
		public int compareTo(Tree o) {
			return this.root.compareTo(o.root);
		}
	}

	static List<Tree> tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		tree = new ArrayList<>();
		String s = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			tree.add(new Tree(st.nextToken()));

			s = st.nextToken();
			if (!s.equals("."))
				tree.get(t).left = (int) s.charAt(0) - 65; // index로 저장
			s = st.nextToken();
			if (!s.equals("."))
				tree.get(t).right = (int) s.charAt(0) - 65; // index로 저장
		}

		Collections.sort(tree);
		//System.out.println(Arrays.toString(tree.toArray()));
		VLR(0);
		output.append("\n");
		LVR(0);
		output.append("\n");
		LRV(0);
		output.append("\n");
		System.out.println(output);
	}

	// 전위순회 : VLR
	static public void VLR(int idx) {
		if(tree.get(idx).left == 0 && tree.get(idx).right == 0) {
			output.append(tree.get(idx).root);
			return;
		}
		output.append(tree.get(idx).root);
		if(tree.get(idx).left != 0)
			VLR(tree.get(idx).left);
		if(tree.get(idx).right != 0)
			VLR(tree.get(idx).right);
	}

	// 중위순회 : LVR
	static public void LVR(int idx) {
		if(tree.get(idx).left == 0 && tree.get(idx).right == 0) {
			output.append(tree.get(idx).root);
			return;
		}
		if(tree.get(idx).left != 0)
			LVR(tree.get(idx).left);
		output.append(tree.get(idx).root);
		if(tree.get(idx).right != 0)
			LVR(tree.get(idx).right);
	}

	// 후위순회 : LRV
	static public void LRV(int idx) {
		if(tree.get(idx).left == 0 && tree.get(idx).right == 0) {
			output.append(tree.get(idx).root);
			return;
		}
		if(tree.get(idx).left != 0)
			LRV(tree.get(idx).left);
		if(tree.get(idx).right != 0)
			LRV(tree.get(idx).right);
		output.append(tree.get(idx).root);
	}
}
