package 패턴매칭과PJT;

public class 패턴매칭01_KMP {
	public static void main(String[] args) {
		String text = "ABABABACABAABABACACA";
		String pattern = "ABABACA";
	}

	static void KMP(String t, String p) {
		int[] pi = getPi(p);

		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			while (j > 0 && t.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}

			if (t.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					System.out.println((i - p.length() + 1) + "위치부터 시작하면 찾을 수 있어요");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	static int[] getPi(String p) {
		int[] pi = new int[p.length()];

		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			// if p[i] != p[j]
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}

			if (p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}

		}

		return pi;
	}
}
