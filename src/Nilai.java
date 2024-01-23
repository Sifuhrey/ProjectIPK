import java.util.Map;
import javax.swing.JOptionPane;

public class Nilai {
    final private static Map<String, Double> mutu = Map.of(
            "A", 4.0,
            "AB", 3.5,
            "B", 3.0,
            "BC", 2.5,
            "C", 2.0,
            "D", 1.0,
            "E", 0.0);
    private String[] keyNilai = mutu.keySet().toArray(new String[0]);
    private double sks;
    private String[] daftarsks = { "1", "2", "3", "4", "5", "6", "12" };
    private String nilaihuruf;
    private static double totalSKS;
    private static double totalNilai;

    public Nilai(String namaMatkul) {
        this.sks = Double.parseDouble((String) JOptionPane.showInputDialog(
                null,
                String.format("Pilih jumlah SKS %s : ", namaMatkul),
                "SKS",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.daftarsks,
                this.daftarsks[0]));
        this.nilaihuruf = (String) JOptionPane.showInputDialog(
                null,
                String.format("Pilih nilai mutu %s : ", namaMatkul),
                "Pilih nilai",
                JOptionPane.QUESTION_MESSAGE,
                null,
                this.keyNilai,
                this.keyNilai[0]);
        hitungTotalSKS(this.sks, this.nilaihuruf);
    }

    private void hitungTotalSKS(double sks, String nilai) {
        totalSKS += sks;
        totalNilai += sks * mutu.get(nilai);
    }

    public static double getTotalSKS() {
        return totalSKS;
    }

    public static double getTotalNilai() {
        return totalNilai;
    }

    public double getSKS() {
        return sks;
    }

    public String getNilaihuruf() {
        return nilaihuruf;
    }
}