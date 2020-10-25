package Practice.Practice_13;

public class Country {
    private int population;

    public void addPopulation(int population) throws MyException
    {
        if(population<=0)
            throw new MyException();
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "population=" + population +
                '}';
    }
}
