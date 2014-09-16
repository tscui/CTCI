public class uniqueCharacter {
	// If we assume we have a character set of ASCII.
	// We can use a bool array with the space of 256
	// to help us mark the repeating chracter ture.
	public static boolean isUnique1(String s) {
		boolean[] a = new boolean[256];
		int len = s.length();
		for (int i = 0; i < len; ++i) {
			int v = (int) s.charAt(i);
			if (a[v]) return false;
			a[v] = true;
		}
		return true;
	}
	
	// For ASCII, we need 256 bit to store the info. 
	// So that a int array with length 8 will be good.
	// To map the character to the right number.
	// For example, 'b' has the code 98.
	// We use 98 / 32 to get the suffix of the array.
	// We use 98 % 32 to get the place where we should set to 1.
	public static boolean isUnique2(String s) { 
		int[] a = new int[8];
		int len = s.length();
		for (int i = 0; i < len; ++i) {
			int v = (int) s.charAt(i);
			int idx = v / 32, shift = v % 32;
			if ((a[idx] & (1 << shift)) == 0) return false;
			a[idx] |= (1 << shift);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "asjdhfaoi21390f9";
		String s2 = "as dw az.";
		System.out.println(isUnique1(s1));
		System.out.println(isUnique2(s2));
	}
}