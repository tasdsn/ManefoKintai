package com.jinten.manefo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jinten.manefo.login.domain.SignupForm;

@Controller
public class SignupController {

  // ラジオボタンの実装
  private Map<String, String> radioMarriage;
  
  //ラジオボタン初期化
  private Map<String, String> initRadioMarrige() {
    Map<String, String> radio = new LinkedHashMap<>();

    //既婚、未婚をMapに格納
    radio.put("既婚", "true");
    radio.put("未婚", "false");

    return radio;
  }

  // ユーザー登録画面のGET用コントローラー
  @GetMapping("/signup")
  public String getSignUp(@ModelAttribute SignupForm form, Model model) {
    //ラジオボタンの初期化メソッド呼び出し
    radioMarriage = initRadioMarrige();

    //ラジオボタン用のMapをModelに登録
    model.addAttribute("radioMarriage", radioMarriage);

    // 画面遷移
    return "login/signup";
  }

  // ユーザー登録画面のPOST用コントローラー
  @PostMapping("/signup")
  public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult,
   Model model) {
    // エラーの場合
    if (bindingResult.hasErrors()) {
      return getSignUp(form, model);
    }

    System.out.println(form);
    // リダイレクト
    return "redirect:/login";
  }
  
}