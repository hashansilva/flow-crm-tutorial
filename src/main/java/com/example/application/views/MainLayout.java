package com.example.application.views;

import com.example.application.security.SecurityService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.security.core.userdetails.UserDetails;


public class MainLayout extends AppLayout {

    private final SecurityService securityService;

    private String username;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        this.username = this.getUserName();
        createHeader();
        createMenuBar();
    }

    private String getUserName() {
        UserDetails userDetails = this.securityService.getAuthenticatedUser();
        if (userDetails != null) {
            return userDetails.getUsername();
        }
        return null;
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setOpenOnHover(true);

        MenuItem home = menuBar.addItem("Home");
        MenuItem visit = menuBar.addItem("Visit");
        menuBar.addItem("History");

        SubMenu visitSubMenu = visit.getSubMenu();

        visitSubMenu.addItem("Third Party");
        MenuItem test = visitSubMenu.addItem("Test");

        SubMenu testSubMenu = test.getSubMenu();
        MenuItem tableItem = testSubMenu.addItem("Table");
        MenuItem textItem = testSubMenu.addItem("Text");

        tableItem.addClickListener((ComponentEventListener<ClickEvent<MenuItem>>) event -> UI.getCurrent().getPage().setLocation("table"));

        textItem.addClickListener((ComponentEventListener<ClickEvent<MenuItem>>) event ->
                UI.getCurrent().getPage().setLocation("text")
        );

        home.addClickListener((ComponentEventListener<ClickEvent<MenuItem>>) event -> UI.getCurrent().getPage().setLocation("/"));

        return menuBar;
    }

    private void createHeader() {
        H1 headerText = new H1("Oracle DB Project");
        headerText.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(headerText);

        MenuBar avatarMenu = getAvatarMenuBar();

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(headerText);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");
        header.add(avatarMenu);

        MenuBar menuBar = createMenuBar();
        menuBar.addClassName("menu-bar");

        HorizontalLayout menuHeader = new HorizontalLayout(menuBar);
        menuHeader.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        menuHeader.expand(headerText);
        menuHeader.setWidth("100%");
        menuHeader.addClassNames("py-0", "px-m");

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(header, new Hr(), menuHeader);

        addToNavbar(verticalLayout);
    }

    private MenuBar getAvatarMenuBar() {
        Avatar avatar = new Avatar(this.username);
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY_INLINE);

        MenuItem menuItem = menuBar.addItem(avatar);
        SubMenu subMenu = menuItem.getSubMenu();
        MenuItem signoutItem = subMenu.addItem("Sign out");
        signoutItem.addClickListener((ComponentEventListener<ClickEvent<MenuItem>>) event -> securityService.logout());
        return menuBar;
    }
}
