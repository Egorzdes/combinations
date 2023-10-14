package sber_project.proj.model;

import java.util.List;

public class DataResponse {
    private List<String> combinations;

    // конструктор, геттеры, сеттеры

    public List<String> getCombinations() {
        return combinations;
    }

    public void setCombinations(List<String> combinations) {
        this.combinations = combinations;
    }

    public DataResponse(List<String> combinations) {
        this.combinations = combinations;
    }

    public DataResponse() {
    }
}
