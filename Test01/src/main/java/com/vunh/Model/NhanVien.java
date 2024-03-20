package com.vunh.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private String diaChi;
    private int tuoi;
    private String phongBan;
    private boolean gioiTinh;
}
