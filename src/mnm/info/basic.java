/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.info;

/**
 *
 * @author mnm
 */
public class basic {
private String name;
private String id;
private String mantaghe;
private String ostan;
private String usernum;
private String classnumber;
private String value;
private String kind;
private int dolati;
private String learnkind[];
private boolean dabirestan;
private boolean pish;
private boolean honar;
private boolean fani;
private boolean rahnamai;
private boolean ebtedaee;
private boolean kar[];

    public String getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(String classnumber) {
        this.classnumber = classnumber;
    }

    public boolean isDabirestan() {
        return dabirestan;
    }

    public void setDabirestan(boolean dabirestan) {
        this.dabirestan = dabirestan;
    }

    public int getDolati() {
        return dolati;
    }

    public void setDolati(int dolati) {
        this.dolati = dolati;
    }

    public boolean isEbtedaee() {
        return ebtedaee;
    }

    public void setEbtedaee(boolean ebtedaee) {
        this.ebtedaee = ebtedaee;
    }

    public boolean isFani() {
        return fani;
    }

    public void setFani(boolean fani) {
        this.fani = fani;
    }

    public boolean isHonar() {
        return honar;
    }

    public void setHonar(boolean honar) {
        this.honar = honar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean[] getKar() {
        return kar;
    }

    public void setKar(boolean[] kar) {
        this.kar = kar;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String[] getLearnkind() {
        return learnkind;
    }

    public void setLearnkind(String[] learnkind) {
        this.learnkind = learnkind;
    }

    public String getMantaghe() {
        return mantaghe;
    }

    public void setMantaghe(String mantaghe) {
        this.mantaghe = mantaghe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOstan() {
        return ostan;
    }

    public void setOstan(String ostan) {
        this.ostan = ostan;
    }

    public boolean isPish() {
        return pish;
    }

    public void setPish(boolean pish) {
        this.pish = pish;
    }

    public boolean isRahnamai() {
        return rahnamai;
    }

    public void setRahnamai(boolean rahnamai) {
        this.rahnamai = rahnamai;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
