import java.util.ArrayList;
import java.util.List;

public class PokerDataProcessor {

    public static double getTotalIn(List<ExcelReader.PokerData> data) {
        return data.stream().mapToDouble(d -> d.amountIn).sum();
    }

    public static double getTotalOut(List<ExcelReader.PokerData> data) {
        return data.stream().mapToDouble(d -> d.amountOut).sum();
    }

    public static List<Double> getInOverTime(List<ExcelReader.PokerData> data) {
        List<Double> inOverTime = new ArrayList<>();
        double cumulativeIn = 0;
        for (ExcelReader.PokerData d : data) {
            cumulativeIn += d.amountIn;
            inOverTime.add(cumulativeIn);
        }
        return inOverTime;
    }

    public static List<Double> getOutOverTime(List<ExcelReader.PokerData> data) {
        List<Double> outOverTime = new ArrayList<>();
        double cumulativeOut = 0;
        for (ExcelReader.PokerData d : data) {
            cumulativeOut += d.amountOut;
            outOverTime.add(cumulativeOut);
        }
        return outOverTime;
    }
}
