package com.example.application.views;

import com.example.application.data.entity.Product;
import com.example.application.data.service.ProductService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PermitAll
@PageTitle("Grid View")
@Route(value="table", layout = MainLayout.class)
public class ListView extends VerticalLayout {

    Grid<Product> productGrid = new Grid<>(Product.class);

    private ProductService productService;

    public ListView(ProductService productService) {
        this.productService = productService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        add(productGrid);
        loadData();
    }

    private void loadData() {
        productGrid.setItems(productService.getProducts());
    }

    private void configureGrid() {
        productGrid.addClassName("contact-grid");
        productGrid.setSizeFull();
        productGrid.setColumns("code", "name");
        productGrid.getColumns().forEach(productColumn -> productColumn.setAutoWidth(true));
    }

}
