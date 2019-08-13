package com.akadatsky;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private String startDate;

    @SerializedName("students")
    private List<Student> list = new ArrayList<>();

    public Group(String name, String startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Group{");
        sb.append("name='").append(name).append('\'');
        sb.append(", startDate='").append(startDate).append('\'');
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
