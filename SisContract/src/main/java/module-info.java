module SisContract {
	
	exports controller;
	exports dao;
	exports application;
	exports model;

	opens application;
	opens controller;
	opens dao;
	opens model;
	
	requires javafx.base;
	requires transitive javafx.controls;
	requires transitive java.sql;
	requires javafx.fxml;
	requires com.jfoenix;
	requires javafx.graphics;
	requires itextpdf;
}