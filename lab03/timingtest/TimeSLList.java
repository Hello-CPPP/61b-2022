package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int i = 0;
        final int ops = 10000;
        double startTime = System.currentTimeMillis();

        while (i < 6) {
            SLList<Integer> testEg = new SLList<>();
            for (int N = 1; N <= 128000; N++) {
                testEg.addLast(0);
                if (N == 1000*Math.pow(2, i)){
                    ++i;
                    Ns.addLast(N);

                    Stopwatch sw = new Stopwatch();
                    for (int j = 0; j < ops; j++) {
                        testEg.getLast();
                    }
                    times.addLast(sw.elapsedTime());
                    //times.addLast(System.currentTimeMillis() - startTime);
                    opCounts.addLast(ops);

                }
            }
        }
        //print
        printTimingTable(Ns, times, opCounts);


    }

}
