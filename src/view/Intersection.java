package view;

import javax.swing.*;

/**
 * Created by rudolpha on 24/06/2014.
 */
public enum Intersection {

    TOP_LEFT_EMPTY("imagenes/sup-izq-vacia.png"),
    TOP_LEFT_WHITE("imagenes/sup-izq-blanca.png"),
    TOP_LEFT_BLACK("imagenes/sup-izq-negra.png"),

    TOP_RIGTH_EMPTY("imagenes/sup-der-vacia.png"),
    TOP_RIGTH_WHITE("imagenes/sup-der-blanca.png"),
    TOP_RIGTH_BLACK("imagenes/sup-der-negra.png"),

    BOTTOM_LEFT_EMPTY("imagenes/inf-izq-vacia.png"),
    BOTTOM_LEFT_WHITE("imagenes/inf-izq-blanca.png"),
    BOTTOM_LEFT_BLACK("imagenes/inf-izq-negra.png"),

    BOTTOM_RIGTH_EMPTY("imagenes/inf-der-vacia.png"),
    BOTTOM_RIGTH_WHITE("imagenes/inf-der-blanca.png"),
    BOTTOM_RIGTH_BLACK("imagenes/inf-der-negra.png"),

    LEFT_EMPTY("imagenes/izq-vacia.png"),
    LEFT_WHITE("imagenes/izq-blanca.png"),
    LEFT_BLACK("imagenes/izq-negra.png"),

    RIGTH_EMPTY("imagenes/der-vacia.png"),
    RIGTH_WHITE("imagenes/der-blanca.png"),
    RIGTH_BLACK("imagenes/der-negra.png"),

    TOP_EMPTY("imagenes/sup-vacia.png"),
    TOP_WHITE("imagenes/sup-blanca.png"),
    TOP_BLACK("imagenes/sup-negra.png"),

    BOTTOM_EMPTY("imagenes/inf-vacia.png"),
    BOTTOM_WHITE("imagenes/inf-blanca.png"),
    BOTTOM_BLACK("imagenes/inf-negra.png"),

    INTERIOR_EMPTY("imagenes/interior-vacia.png"),
    INTERIOR_WHITE("imagenes/interior-blanca.png"),
    INTERIOR_BLACK("imagenes/interior-negra.png");

    private ImageIcon imgIcon;

    private Intersection(String imgPath) {
        imgIcon= new ImageIcon(getClass().getResource(imgPath));
    }

    public ImageIcon getImage(){
        return imgIcon;
    }
}
