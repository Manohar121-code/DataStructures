package binarySearchTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CommonNodesInBSTs {
	public static void main(String[] args) {
		/*MyBST bstObj1 = new MyBST();
		bstObj1.insert(5);
		bstObj1.insert(1);
		bstObj1.insert(10);
		bstObj1.insert(0);
		bstObj1.insert(4);
		bstObj1.insert(7);
		bstObj1.insert(9);
		
		MyBST bstObj2 = new MyBST();
		bstObj2.insert(10);
		bstObj2.insert(7);
		bstObj2.insert(20);
		bstObj2.insert(4);
		bstObj2.insert(9);*/
		
		MyBST bstObj1 = new MyBST();
		String s = "28 188 329 327 72 33 130 270 110 150 335 166 132 123 92 331 222 293 55 302 221 281 230 172 217 109 154 247 334 256 195 36 297 283 182 175 332 45 316 206 37 227 314 174 75 322 319 120 264 103 179 74 300 165 299 324 213 290 162 177 79 34 338 192 156 180 73 301 223 276 114 232 52 155 157 268 95 304 159 160 163 214 47 25 246 243 191 124 50 279 101 63 70 347 39 149 184 62 185 77 225 196 269 202 125 41 280 215 210 266 310 197 343 51 234 53 119 272 48 250 143 326 287 84 139 56 118 323 207 284 32 96 292 148 286 229 83 330 209 176 193 82 76 321 105 67 265 261 142 66 260 68 57 140 58 341 27 40 183 90 311 282 346 31 198 226 134 80 337 133 152 86 255 205 94 263 274 100 78 224 71 131 325 112 170 88 254 54 212 267 248 308 219 307 87 104 305 249 278 147 153 339 333 108 129 106 107 228 49 164 38 42 313 262 336 91 208 296 277 64 190 201 113 271 245 144 60 252 244 303 178 111 291 315 115 318 204 241 128 181 294 317 126 69 220 235 116 320 29 238 173 200 169 342 289 167 30 85 251 345 189 240 253 59 135 312 194 239 65 151 136 237 46 242 102 44 122 285 127 161 273 288 187 218 121 81 138 98 203 141 344 295 233 158 171 186 99 199 236 61 258 43 275 93 168 35 259 145 146 137 211 89 328 216 340 117 97 26 231 257 306 309 298";
		String[] split = s.split(" ");
		for (String str: split) {
			bstObj1.insert(Integer.parseInt(str));
		}
		
		MyBST bstObj2 = new MyBST();
		String s2 = "130 32 48 115 141 104 134 108 99 67 71 158 180 98 96 81 87 38 95 175 102 89 165 125 173 60 167 169 178 45 33 56 64 53 179 135 143 111 174 25 161 156 172 177 59 184 126 82 29 148 55 123 42 149 163 34 62 144 171 136 86 91 127 146 47 142 57 113 128 110 121 35 151 94 51 168 176 28 119 31 27 58 107 37 41 54 75 43 183 92 40 77 72 74 157 97 138 150 76 155 44 79 90 114 66 112 50 88 68 103 140 30 84 70 131 80 65 63 152 78 116 61 120 154 117 159 118 153 129 181 164 133 132 93 85 83 160 26 36 162 69 147 39 145 100 139 106 101 49 122 124 105 166 73 109 52 182 170 46 137";
		String[] split2 = s2.split(" ");
		for (String str: split2) {
			bstObj2.insert(Integer.parseInt(str));
		}
		
		CommonNodesInBSTs obj = new CommonNodesInBSTs();
		
		obj.printCommon(bstObj1.root, bstObj2.root);
		System.out.println();
		obj.printCommonNodesOptimal(bstObj1.root, bstObj2.root);
		System.out.println();
	}

	private void printCommonNodesOptimal(MyBSTNode root1, MyBSTNode root2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		fillIntoStack(root1, stack1);
		fillIntoStack(root2, stack2);
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek().intValue() == stack2.peek().intValue()) {
				System.out.print(stack1.pop()+" ");
				stack2.pop();
			} else if (stack1.peek() < stack2.peek()) {
				stack1.pop();
			} else {
				stack2.pop();
			}
		}
	}

	private void fillIntoStack(MyBSTNode root, Stack<Integer> stack) {
		if (root == null)
			return;
		fillIntoStack(root.right, stack);
		stack.push(root.data);
		fillIntoStack(root.left, stack);
	}

	private void printCommon(MyBSTNode root, MyBSTNode root2) {
		Set<Integer> set = new HashSet<>();
		fillSetForHashing(root, set);
		getCommonFromSet(root2, set);
	}

	private void fillSetForHashing(MyBSTNode root, Set<Integer> set) {
		if (root == null)
			return;
		fillSetForHashing(root.left, set);
		set.add(root.data);
		fillSetForHashing(root.right, set);
	}

	private void getCommonFromSet(MyBSTNode root, Set<Integer> set) {
		if (root == null)
			return;
		getCommonFromSet(root.left, set);
		if (set.contains(root.data))
			System.out.print(root.data+" ");
		getCommonFromSet(root.right, set);
	}
	
}
