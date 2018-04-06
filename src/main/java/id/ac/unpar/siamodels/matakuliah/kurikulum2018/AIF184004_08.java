package id.ac.unpar.siamodels.matakuliah.kurikulum2018;

import id.ac.unpar.siamodels.InfoMataKuliah;
import id.ac.unpar.siamodels.MataKuliah;
import id.ac.unpar.siamodels.matakuliah.interfaces.*;
import id.ac.unpar.siamodels.Mahasiswa;

import java.util.List;


@InfoMataKuliah(nama = "Tugas Akhir", sks = 8)
public class AIF184004_08 extends MataKuliah implements HasPrasyarat{

    @Override
    public boolean checkPrasyarat(Mahasiswa mahasiswa, List<String> reasonsContainer) {
        boolean ok = true;
        if (!mahasiswa.hasLulusKuliah("AIF183002-02") && !mahasiswa.hasLulusKuliah("AIF182007-02")) {
            reasonsContainer.add("Tidak memenuhi prasyarat lulus AIF183002-02 atau AIF 182007-02");
            ok = false;
        }
        int sksLulus = mahasiswa.calculateSKSLulus();
        if (sksLulus < 124) {
            reasonsContainer.add("SKS Lulus " + sksLulus + ", belum mencapai syarat minimal 124");
            return false;
        }
        return ok;
    }
}
