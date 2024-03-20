package com.vunh.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private int soLuong;
    private int giaBan;
    private String danhMuc;
    private boolean trangThai;
}
