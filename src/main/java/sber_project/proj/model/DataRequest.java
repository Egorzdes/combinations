package sber_project.proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;


import java.util.ArrayList;

public class DataRequest {
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> first;


    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> second;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> third;

    public DataRequest() {
    }

    public DataRequest(ArrayList<String> first, ArrayList<String> second, ArrayList<String> third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public ArrayList<String> getfirst() {
        return new ArrayList<>(first);
        }

    public void setFirst(ArrayList<String> first) {
        this.first = first;
    }

    public ArrayList<String> getsecond() {
        return new ArrayList<>(second);
    }

    public void setSecond(ArrayList<String> second) {
        this.second = second;
    }

    public ArrayList<String> getThird() {
        return new ArrayList<>(third);
    }

    public void setThird(ArrayList<String> third) {
        this.third = third;
    }
}