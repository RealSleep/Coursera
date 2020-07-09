import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

	private static final double CONST = 1.96; 
    private final int n;
    private final int trials;
    private double[] xt;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.trials = trials;
        xt = new double[trials];
    }

    // sample mean of percolation threshold
    public double mean() {
        for (int i = 0; i < trials; i++) {
            Percolation per = new Percolation(n);
            go(per);
            double p = per.numberOfOpenSites()/(n*n*1.0);
            xt[i] = p;
        }
        return StdStats.mean(xt);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(xt);
    }

    private void go(Percolation per) {
        while (!per.percolates()) {
            int i = StdRandom.uniform(n)+1;
            int j = StdRandom.uniform(n)+1;
            if (!per.isOpen(i, j)) {
                per.open(i, j);
            }

        }
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return StdStats.mean(xt) - ((CONST * stddev())/Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return StdStats.mean(xt) + ((CONST * stddev())/Math.sqrt(trials));
    }

    // test client (see below) 
    public static void main(String[] args) {
        PercolationStats perS = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean                    =" + perS.mean());
        StdOut.println("stddev                  =" + perS.stddev());
        StdOut.println("95% confidence interval =" + "["+perS.confidenceLo()+" ,"+perS.confidenceHi()+"]");
    }

}