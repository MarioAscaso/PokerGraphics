import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.util.List;

public class PokerGraph {

    public static JPanel createTotalGraph(double totalIn, double totalOut) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(totalIn, "Ingresado", "Total");
        dataset.addValue(totalOut, "Obtenido", "Total");

        JFreeChart chart = ChartFactory.createBarChart(
                "Totales Ingresado y Obtenido",
                "Categoría",
                "€",
                dataset
        );
        return new ChartPanel(chart);
    }

    public static JPanel createAccumulatedGraph(List<ExcelReader.PokerData> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        double accumulatedAmount = 0;

        for (int i = 0; i < data.size(); i++) {
            ExcelReader.PokerData pokerData = data.get(i);

            double dailyDifference = pokerData.amountOut - pokerData.amountIn;

            accumulatedAmount += dailyDifference;

            dataset.addValue(accumulatedAmount, "Ganancia/Pérdida acumulada", pokerData.date.toString());
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Ganancia/Pérdida Acumulada",
                "Fecha",
                "€",
                dataset
        );
        return new ChartPanel(chart);
    }
}
