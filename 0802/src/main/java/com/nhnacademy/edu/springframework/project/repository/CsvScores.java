package com.nhnacademy.edu.springframework.project.repository;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/** TODO 2 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
public class CsvScores implements Scores {
    private final List<Score> scores = new ArrayList<>();

    public List<Score> getScores() {
        return scores;
    }

    public CsvScores() {

    }


    // TODO 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException, CsvValidationException {
        String filePath = "C:/Users/82109/OneDrive/바탕 화면/NHN/Spring Framework/0802/src/main/resources/data/score.csv";
        FileReader fileReader = new FileReader(filePath);
        CSVReader studentCSV = new CSVReader(fileReader);
        String[] studentScore;

        while((studentScore = studentCSV.readNext()) !=null){
            for(int i = 0; i<studentScore.length; i+=2){
                scores.add(new Score(Integer.parseInt(studentScore[i]),
                    Integer.parseInt(studentScore[i+1])));
            }
        }
//        System.out.println(scores.get(0));
    }


    @Override
    public List<Score> findAll() {
        return this.scores;
    }
}
