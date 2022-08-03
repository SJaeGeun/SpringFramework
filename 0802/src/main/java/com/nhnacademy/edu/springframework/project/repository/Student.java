package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.repository.Score;

public class Student {
    private final int seq;
    private final String name;
    private Score score;

    public Student(int seq, String name) {
        this.seq = seq;
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score)
    {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "학생 번호=" + seq +
                ", 이름='" + name + '\'' +
                ", " + score +
                '}'+ '\n';
    }
}
