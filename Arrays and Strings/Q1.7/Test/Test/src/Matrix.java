
public class Matrix {
	private int[][] matrix;
	private int M;
	private int N;
	
	public Matrix(int[][] m) {
		if (m == null) throw new NullPointerException();
		this.matrix = m;
		this.M = m.length;
		this.N = m[0].length;
	}
	
	public void setZero() {
		boolean[] row = new boolean[M];
		boolean[] col = new boolean[N];
		for (int i = 0; i < M; ++i)
			for (int j = 0; j < N; ++j) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		
		for (int i = 0; i < M; ++i)
			for (int j = 0; j < N; ++j)
				if (row[i] || col[j])
					matrix[i][j] = 0;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				s += matrix[i][j] + " ";
			s += "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		int[][] test = {
		        {1, 2, 3},
		        {5, 0, 7},
		        {9, 10, 11},
		    };
		Matrix solution = new Matrix(test);
		System.out.println(solution.toString());
		solution.setZero();
		System.out.print(solution.toString());
	}
}
