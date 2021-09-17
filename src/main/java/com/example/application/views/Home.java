package com.example.application.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PermitAll
@PageTitle("Oracle DB Project")
@Route(value = "", layout = MainLayout.class)
public class Home extends VerticalLayout {
    public Home() {
    }
}
