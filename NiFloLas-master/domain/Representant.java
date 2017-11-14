package domain;

public class Representant extends Seller {

    public Representant(String firstname, String lastname, int age, String entryYear, double turnover) {
        super(firstname, lastname, age, entryYear, turnover);
        setType("Representant");
    }

    @Override
    public String getPosition() {
        return "Le représentant";
    }

    @Override
    protected double getBonus() {
        return 800;
    }
}
