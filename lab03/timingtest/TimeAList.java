package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int i = 0;
        int ops = 0;

        double startTime = System.currentTimeMillis();

        //前面列的时间不能影响到后面的时间
        while (i < 8){
            AList<Integer> testEg = new AList<>();
            ops = 0;
            startTime = System.currentTimeMillis();
            Stopwatch sw = new Stopwatch();
            for (int N = 1; N <= 128000; N++) {
                testEg.addLast(0);
                ++ops;
                if (N == 1000*Math.pow(2, i)){
                    ++i;

                    Ns.addLast(N);
                    times.addLast(sw.elapsedTime());
                    //times.addLast(System.currentTimeMillis() - startTime);
                    opCounts.addLast(ops);

                    break;
                }
            }
        }

        //print
        printTimingTable(Ns, times, opCounts);
    }
}
