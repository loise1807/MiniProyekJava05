package com.group05.miniproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
	private String pasienId;
	private String namaPasien;
	private String sakitPasien;
	
	public String getPasienId() {
		return pasienId;
	}
	public void setPasienId(String pasienId) {
		this.pasienId = pasienId;
	}
	public String getNamaPasien() {
		return namaPasien;
	}
	public void setNamaPasien(String namaPasien) {
		this.namaPasien = namaPasien;
	}
	public String getSakitPasien() {
		return sakitPasien;
	}
	public void setSakitPasien(String sakitPasien) {
		this.sakitPasien = sakitPasien;
	}
	
}