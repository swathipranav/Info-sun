package testData;

import java.util.HashMap;
import java.util.Map;

public class NestedLoops {

	public static void main(String[] args) {

		int n = 1;

		Map<Integer, Map<Integer, Integer>> totaldata = new HashMap<Integer, Map<Integer, Integer>>();

		Map<Integer, Integer> map = null;

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {

				map = new HashMap<Integer, Integer>();

				map.put(i, j);

				totaldata.put(n, map);
				n++;
				map = null;

			}

		}

		System.out.println(totaldata);
	}

}
