package com.aninterface.interactive.app_mob2_labo3;

import android.graphics.Color;

public class AstreCeleste {
    private String NomAstre;
    private int TailleAstre;
    private Color CouleurAstre;
    private Boolean StatusAstre;
    private String NomImageAstre;

    public AstreCeleste(){

    }

    public AstreCeleste(String nomAstre, int tailleAstre, Color couleurAstre, Boolean statusAstre, String nomImageAstre) {
        NomAstre = nomAstre;
        TailleAstre = tailleAstre;
        CouleurAstre = couleurAstre;
        StatusAstre = statusAstre;
        NomImageAstre = nomImageAstre;
    }

    public String getNomAstre() {
        return NomAstre;
    }

    public void setNomAstre(String nomAstre) {
        NomAstre = nomAstre;
    }

    public int getTailleAstre() {
        return TailleAstre;
    }

    public void setTailleAstre(int tailleAstre) {
        TailleAstre = tailleAstre;
    }

    public Color getCouleurAstre() {
        return CouleurAstre;
    }

    public void setCouleurAstre(Color couleurAstre) {
        CouleurAstre = couleurAstre;
    }

    public Boolean getStatusAstre() {
        return StatusAstre;
    }

    public void setStatusAstre(Boolean statusAstre) {
        StatusAstre = statusAstre;
    }

    public String getNomImageAstre() {
        return NomImageAstre;
    }

    public void setNomImageAstre(String nomImageAstre) {
        NomImageAstre = nomImageAstre;
    }
}
