package com.example.checklistextended;

public class CoordsContainer {
    int ctlx;
    int ctly;
    int ctrx;
    int ctry;
    int cblx;
    int cbly;
    int cbrx;
    int cbry;
    int centerPointx;
    int centerPointy;

    public CoordsContainer(int ctlx, int ctly, int ctrx, int ctry, int cblx, int cbly, int cbrx, int cbry) {
        this.ctlx = ctlx;
        this.ctly = ctly;
        this.ctrx = ctrx;
        this.ctry = ctry;
        this.cblx = cblx;
        this.cbly = cbly;
        this.cbrx = cbrx;
        this.cbry = cbry;
    }

    public int getCtlx() {
        return ctlx;
    }

    public void setCtlx(int ctlx) {
        this.ctlx = ctlx;
    }

    public int getCtly() {
        return ctly;
    }

    public void setCtly(int ctly) {
        this.ctly = ctly;
    }

    public int getCtrx() {
        return ctrx;
    }

    public void setCtrx(int ctrx) {
        this.ctrx = ctrx;
    }

    public int getCtry() {
        return ctry;
    }

    public void setCtry(int ctry) {
        this.ctry = ctry;
    }

    public int getCblx() {
        return cblx;
    }

    public void setCblx(int cblx) {
        this.cblx = cblx;
    }

    public int getCbly() {
        return cbly;
    }

    public void setCbly(int cbly) {
        this.cbly = cbly;
    }

    public int getCbrx() {
        return cbrx;
    }

    public void setCbrx(int cbrx) {
        this.cbrx = cbrx;
    }

    public int getCbry() {
        return cbry;
    }

    public void setCbry(int cbry) {
        this.cbry = cbry;
    }

    public int getCenterPointx() {
        centerPointx =  cbrx / 2;
        return centerPointx;
    }

    public void setCenterPointx(int centerPointx) {
        this.centerPointx = centerPointx;
    }

    public int getCenterPointy() {
        centerPointy = cbry / 2;
        return centerPointy;
    }

    public void setCenterPointy(int centerPointy) {
        this.centerPointy = centerPointy;
    }
}
