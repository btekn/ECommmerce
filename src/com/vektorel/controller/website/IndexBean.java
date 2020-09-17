package com.vektorel.controller.website;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.dao.website.KategoriDao;
import com.vektorel.model.tblkategori;
import com.vektorel.modelview.ModelWebSiteIndex;

@ManagedBean(name="indexBean")
@SessionScoped
public class IndexBean {
	private ModelWebSiteIndex model ;
	private KategoriDao DbKategori;
	
	// Constructor -> Kurucu MEthod
	public IndexBean() {
		// Kategori Db iþlemlerini yapmak için 
		// yeni bir kategori nesnedi oluþturulur.
		DbKategori = new KategoriDao();
		model = new ModelWebSiteIndex();
		
		Ekleme();
		
		model.setListKategori(DbKategori.MyList(new tblkategori()));
	}
	
	public void Ekleme() {
		tblkategori kategori;
		kategori = new tblkategori();
		kategori.setAd("Erkek Giyim");
		kategori.setResimurl("img/cart-page/product-1.jpg");
		
		DbKategori.Save(kategori);
		
		kategori = new tblkategori();
		kategori.setAd("Kadýn Giyim");
		kategori.setResimurl("img/cart-page/product-2.jpg");
		
		DbKategori.Save(kategori);
		
		kategori = new tblkategori();
		kategori.setAd("Çocuk Giyim");
		kategori.setResimurl("img/cart-page/product-3.jpg");
		
		DbKategori.Save(kategori);
		
		
	}
	public ModelWebSiteIndex getModel() {
		return model;
	}

	public void setModel(ModelWebSiteIndex model) {
		this.model = model;
	}
}
