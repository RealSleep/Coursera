import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private static final int NEIGHBORSNUM = 4;
    private final int n;
    private final int[][] grid;
    private final WeightedQuickUnionUF wquUF;
    private boolean[][] open;
    private int openCount;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
		if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        this.wquUF = new WeightedQuickUnionUF(n*n+2);
        openCount = 0;
        grid = new int[n][n];
        open = new boolean[n][n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = k++;
            }   
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	valid(row, col);

        open[row-1][col-1] = true;
        openCount++;

        int[][] neighbors = neighbors(row, col);
		
		canConnect(neighbors[0], row, col);
		canConnect(neighbors[1], row, col);
		canConnect(neighbors[2], row, col);
		canConnect(neighbors[3], row, col);

        if (row == 1) {
        	wquUF.union(0, grid[row-1][col-1]);
        }
        if (row == n) {
        	wquUF.union(n*n+1, grid[row-1][col-1]);
        }
    }

    private int[][] neighbors(int row, int col) {
    	int[][] s = new int[NEIGHBORSNUM][2];
		int rowN = row+1;
		int colN = col;
		if (!(rowN <= 0 || rowN > n || colN <= 0 || colN > n)) {
			s[0] = new int[]{rowN, colN};
		}
		rowN = row-1;
		colN = col;
		if (!(rowN <= 0 || rowN > n || colN <= 0 || colN > n)) {
			s[1] = new int[]{rowN, colN};
		}
		rowN = row;
		colN = col+1;
		if (!(rowN <= 0 || rowN > n || colN <= 0 || colN > n)) {
			s[2] = new int[]{rowN, colN};
		}
		rowN = row;
		colN = col-1;
		if (!(rowN <= 0 || rowN > n || colN <= 0 || colN > n)) {
			s[3] = new int[]{rowN, colN};
		}
		
    	return s; 
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        valid(row, col);
        return open[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        valid(row, col);
        return this.isOpen(row, col) && (wquUF.find(0) == wquUF.find(grid[row-1][col-1]));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return wquUF.find(0) == wquUF.find(n*n+1);
    }

    private void valid(int row, int col) {
		if (row <= 0 || row > n || col <= 0 || col > n)  {
	        throw new IllegalArgumentException();
	    }
    }

    private void canConnect(int[] pair, int row, int col) {
    	if (pair[0] + pair[1] != 0 && isOpen(pair[0], pair[1])) {
        		wquUF.union(grid[row-1][col-1], grid[pair[0]-1][pair[1]-1]);
        }
    }
}