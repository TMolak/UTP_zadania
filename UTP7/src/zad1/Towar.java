package zad1;

public class Towar {

private int id_towaru;
private int waga;

    public Towar(int id_towaru, int waga) {
        this.id_towaru = id_towaru;
        this.waga = waga;
    }

    public int getId_towaru() {
        return id_towaru;
    }

    public void setId_towaru(int id_towaru) {
        this.id_towaru = id_towaru;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }
}
