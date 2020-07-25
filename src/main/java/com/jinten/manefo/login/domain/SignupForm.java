package com.jinten.manefo.login.domain;

import java.util.Date;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class SignupForm {
  // 必須、 メール形式
  @NotBlank
  @Email
  private String userId; //ユーザーID

  // 必須入力、長さ4〜100桁、半角英数
  @NotBlank
  @Length(min = 4, max = 100)
  @Pattern(regexp = "^[a-zA-Z0-9]+$")
  private String password; //パスワード

  // 必須
  @NotBlank
  private String userName; //ユーザー名

  // 必須
  @NotNull
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date birthday;

  // 20〜100まで
  @Min(20)
  @Max(100)
  private int age;

  // falseのみ可能
  @AssertFalse
  private boolean marriage;
  
}