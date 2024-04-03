package com.vunh.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sach")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sach {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_sach")
    private String maSach;

    @Column(name = "ten_sach")
    private String tenSach;

    @Column(name = "tac_gia")
    private String tacGia;

    @Column(name = "nam_xuat_ban")
    private Integer namXuatBan;

    @Column(name = "so_luong")
    private Integer soLuong;
}
