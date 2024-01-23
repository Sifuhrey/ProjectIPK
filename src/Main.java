import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Map<String, Nilai> matkul = new HashMap<>();
        StringBuilder daftarMatkul = new StringBuilder();
        int jumlahMatkul = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah mata kuliah : "));
        for (int i = 1; i <= jumlahMatkul; i++) {
            String namaMatkul = JOptionPane.showInputDialog("Masukkan nama mata kuliah ke " + i + " : ");
            matkul.put(namaMatkul, new Nilai(namaMatkul));
        }
        for (String key : matkul.keySet()) {
            Nilai perMatkul = matkul.get(key);
            daftarMatkul.append("\t- ").append(key)
                        .append("\nJumlah SKS\t: ").append(String.format("%.0f", perMatkul.getSKS()))
                        .append("\nNilai mutu\t: ").append(perMatkul.getNilaihuruf())
                        .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, daftarMatkul.toString(), "Daftar Mata Kuliah",
                JOptionPane.INFORMATION_MESSAGE);
        double ipk = (double) Nilai.getTotalNilai() / Nilai.getTotalSKS();
        JOptionPane.showMessageDialog(null, String.format("IPK anda adalah : %.2f", ipk), "IPK",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
