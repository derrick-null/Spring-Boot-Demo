package com.derrick.controller;

import com.alibaba.fastjson.JSON;
import com.derrick.util.Base64EncryptorUtils;
import com.derrick.util.Constant;
import com.derrick.util.RSAEncrypt;
import com.derrick.vo.RequestVO;
import com.derrick.vo.TokenVO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.interfaces.RSAPrivateKey;

/**
 * Created by Derrick on 2016/4/26.
 */
@Controller
@EnableAutoConfiguration
public class OpenClaimController  implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
        org.springframework.boot.SpringApplication.run(OpenClaimController.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(9001);
    }

    @RequestMapping(value = "/claim/openClaimWindow", method = RequestMethod.POST,
            headers = "content-type=application/x-www-form-urlencoded")
    //@ResponseBody
    String openClaimWindow(@ModelAttribute RequestVO requestVO,HttpServletRequest request) {
        String base64TokenStr = requestVO.getBase64Token();
        String encryptTokenStr = requestVO.getToken();
        String plainTxt = Base64EncryptorUtils.decoderBASE64(base64TokenStr);
        TokenVO base64Token = JSON.parseObject(plainTxt, TokenVO.class);
        System.out.println("base64Token:" + base64Token);
        RSAPrivateKey privateKey;
        TokenVO tokenVO = null;
        try {
            privateKey = RSAEncrypt.loadPrivateKeyByStr(Constant.PRIVATE_KEY_STR);
            byte[] deByte = Base64.decodeBase64(encryptTokenStr);
            System.out.println("deByte:" + new String(deByte));
            byte[] deTxt = RSAEncrypt.decrypt(privateKey, deByte);
            System.out.println("deTxt:" + new String(deTxt));
            tokenVO = JSON.parseObject(new String(deTxt), TokenVO.class);
            System.out.println("tokenVO:" + tokenVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result;
        int i = tokenVO.getExpTime().compareTo(base64Token.getExpTime());
        if(i>0){
            result = "redirect:/failed.html";
        }else{
            result = "redirect:/toSuccessPage";
        }
        request.getSession().setAttribute("token", requestVO.getToken());
        return result;
    }

    @RequestMapping(value = "/toSuccessPage")
    public ModelAndView toSuccessPage() {
        return new ModelAndView("success");
    }
}
