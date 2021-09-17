package com.example.application.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PermitAll
@PageTitle("Text View")
@Route(value = "text", layout = MainLayout.class)
public class TextView extends VerticalLayout {

    public TextView() {
        addClassName("text-view");
        setSizeFull();
        TextArea textArea = new TextArea("Text Area");
        textArea.setValue(this.getTextValue());
        textArea.setWidth("100%");

        add(textArea);
    }

    private String getTextValue() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec tellus sed est tincidunt tristique id sit amet diam. Curabitur quis felis dui. Vestibulum id enim tempus, porttitor elit et, vehicula neque. Ut id nunc quis magna semper lacinia. Nunc finibus ultricies risus, eu laoreet justo dapibus vel. Praesent vestibulum metus quis ante bibendum, vitae facilisis diam tempor. Nunc condimentum pulvinar posuere. Aenean consectetur tortor sapien, ut molestie tellus placerat et. Ut urna enim, suscipit non tincidunt sit amet, laoreet lacinia nibh. Morbi in dictum mi. Duis maximus velit non arcu venenatis, sed consequat nisi ultricies. Phasellus iaculis quam et ultricies tempor.\n" +
                "\n" +
                "Interdum et malesuada fames ac ante ipsum primis in faucibus. Vestibulum eu leo ante. Integer condimentum tempus placerat. Vivamus vestibulum eros a congue bibendum. Pellentesque nec erat nec sem placerat mollis ut in justo. Proin eget euismod est. Suspendisse ac cursus lectus, dapibus fringilla nisi. Curabitur vitae blandit justo. Morbi dictum feugiat orci, eu vehicula neque rutrum ut. Integer at ante ac tellus sodales congue. Aenean nec erat rutrum, consectetur dui vel, convallis lacus.\n" +
                "\n" +
                "Maecenas ut dolor mauris. Sed consequat faucibus nisl, ac viverra arcu viverra hendrerit. Pellentesque sed velit tortor. Duis et eleifend ligula, nec ornare felis. Sed finibus suscipit volutpat. Mauris quam risus, condimentum id pretium ac, venenatis a neque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam facilisis nisi maximus, blandit augue a, egestas est. Nulla at diam at felis fermentum euismod.\n" +
                "\n" +
                "Ut et vehicula libero. Nunc ligula dolor, porta non tellus eu, bibendum pulvinar urna. Ut accumsan venenatis dui quis tincidunt. In sed egestas ipsum. Duis maximus ex mi, sit amet mattis enim placerat sed. In euismod massa neque, non luctus metus iaculis at. Quisque vel accumsan risus. Sed tristique neque non lobortis egestas. Sed rhoncus lacus eu turpis volutpat interdum. Sed in dolor justo. Vestibulum molestie ex sit amet magna condimentum tristique. Aliquam luctus massa eget dignissim dignissim. Praesent sed nulla vitae arcu imperdiet porttitor non quis lorem. Sed efficitur enim nibh, in fermentum elit placerat in. In ut tempus enim.\n" +
                "\n" +
                "Nunc scelerisque, urna ullamcorper placerat consequat, ante risus maximus neque, id euismod eros turpis id libero. Nulla euismod mollis lectus, eget volutpat lorem gravida nec. Nullam at dolor efficitur, ultricies libero et, tempor nisi. Morbi at ipsum porta, pellentesque justo sit amet, sodales sem. In erat ex, viverra vitae urna et, mollis volutpat magna. Nam auctor magna vitae condimentum ullamcorper. Pellentesque nec elementum metus. Pellentesque at dui diam. Vestibulum convallis elit sed rhoncus scelerisque. Ut turpis lectus, gravida quis mattis vitae, iaculis eu ipsum. Phasellus feugiat dignissim turpis finibus vehicula.";
    }

}
