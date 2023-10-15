package combinations.proj.model;

import java.util.List;

public class DataRequest {
    private List<String> first;
    private List<String> second;
    private List<String> third;
    private List<String> fourth;
    private List<String> fifth;
    private List<String> sixth;
    private List<String> seventh;
    private List<String> eight;

    public DataRequest(List<String> first, List<String> second, List<String> third, List<String> fourth, List<String> fifth,
                       List<String> sixth, List<String> seventh, List<String> eight) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eight = eight;
    }

    public List<String> getFirst() {
        return first;
    }

    public void setFirst(List<String> first) {
        this.first = first;
    }

    public List<String> getSecond() {
        return second;
    }

    public void setSecond(List<String> second) {
        this.second = second;
    }

    public List<String> getThird() {
        return third;
    }

    public void setThird(List<String> third) {
        this.third = third;
    }

    public List<String> getFourth() {
        return fourth;
    }

    public void setFourth(List<String> fourth) {
        this.fourth = fourth;
    }

    public List<String> getFifth() {
        return fifth;
    }

    public void setFifth(List<String> fifth) {
        this.fifth = fifth;
    }

    public List<String> getSixth() {
        return sixth;
    }

    public void setSixth(List<String> sixth) {
        this.sixth = sixth;
    }

    public List<String> getSeventh() {
        return seventh;
    }

    public void setSeventh(List<String> seventh) {
        this.seventh = seventh;
    }

    public List<String> getEight() {
        return eight;
    }

    public void setEight(List<String> eight) {
        this.eight = eight;
    }
}

