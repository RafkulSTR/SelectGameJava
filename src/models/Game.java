package models;

public class Game {
    private Integer id;
    private String name;
    private Double weight;



    public Game(Integer id, String name, Double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double SetWeight(Double weight){
        this.weight = weight;
        return weight;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
