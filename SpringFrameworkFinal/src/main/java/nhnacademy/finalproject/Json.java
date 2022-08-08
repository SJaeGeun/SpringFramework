package nhnacademy.finalproject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Json {
  @JsonProperty("순번")
  Integer seq;
  @JsonProperty("지자체명")
  String local;
  @JsonProperty("업종")
  String sector;
  @JsonProperty("단계")
  Integer level;
  @JsonProperty("구간시작(세제곱미터)")
  Integer startSection; //세제곱미터
  @JsonProperty("구간끝(세제곱미터)")
  Integer endSection;// 세제곱미터
  @JsonProperty("구간금액(원)")
  Integer baseAmount;
  @JsonProperty("단계별 기본요금(원)")
  Integer stepOfAmount;
}

