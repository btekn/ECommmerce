package com.vektorel.controller.website;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vektorel.dao.website.KategoriDao;
import com.vektorel.dao.website.PagesDao;
import com.vektorel.model.tblkategori;
import com.vektorel.model.tblpages;
import com.vektorel.modelview.ModelWebSiteIndex;

@ManagedBean(name="indexBean")
@SessionScoped
public class IndexBean {
	private ModelWebSiteIndex model ;
	private PagesDao dbPages;
	private KategoriDao DbKategori;
	
	// Constructor -> Kurucu MEthod
	public IndexBean() {
		// Kategori Db i�lemlerini yapmak i�in 
		// yeni bir kategori nesnedi olu�turulur.
		DbKategori = new KategoriDao();
		dbPages = new PagesDao();
		
		model = new ModelWebSiteIndex();
		
		PagesAdd();
		Ekleme();
		
		
	}
	
	private void PagesAdd() {
		dbPages = new PagesDao();
		
		tblpages page;
		
		page= new tblpages();
		page.setAd("Home");
		page.setId(0);
		page.setUrl("index.xhtml");
		
		dbPages.Save(page);
		
		page= new tblpages();
		page.setAd("Shop");
		page.setId(0);
		page.setUrl("shop.xhtml");
		
		dbPages.Save(page);
		
		page= new tblpages();
		page.setAd("Pages");
		page.setId(0);
		page.setUrl("pages.xhtml");
		
		dbPages.Save(page);
		
		page= new tblpages();
		page.setAd("Contact");
		page.setId(0);
		page.setUrl("contact.xhtml");
		
		dbPages.Save(page);
		
		
	}
	
	public void Ekleme() {
		tblkategori kategori;
		kategori = new tblkategori();
		kategori.setAd("Erkek Giyim");
		kategori.setResimurl("img/cart-page/product-1.jpg");
		
		DbKategori.Save(kategori);
		
		kategori = new tblkategori();
		kategori.setAd("Kad�n Giyim");
		kategori.setResimurl("img/cart-page/product-2.jpg");
		
		DbKategori.Save(kategori);
		
		kategori = new tblkategori();
		kategori.setAd("�ocuk Giyim");
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
