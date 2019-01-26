package com.with.bai.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile,MultipartFile editorFile, HttpServletRequest request) {
        MultipartFile multiFile = dropFile == null ? editorFile:dropFile;
        Map<String,Object> result = new HashMap<>();
        File pai = new File("C:\\www\\webapps\\api\\static\\upload");
        File filePath = new File(request.getServletContext().getRealPath("/static/upload"));
        //2.如果该文件夹不存在则创建
        if(!filePath.exists()){
            filePath.mkdir();
        }
        if(!pai.exists()){
            pai.mkdirs();
        }

        //创建一个File来描述文件
        String filename = multiFile.getOriginalFilename();
        //获得扩展名

        filename = filename.substring(filename.lastIndexOf('.'));
        filename = UUID.randomUUID()+filename;
        File fil = new File(pai,filename);
        File file = new File(filePath,filename);
        //把dropFile对象转换成file
        try {
            multiFile.transferTo(fil);
        } catch (IOException e) {
            e.printStackTrace();
        }

        filename = "/static/upload/"+filename;
        if(dropFile!=null){
            result.put("filename",filename);
            return result;
        }else{
            //通过wangEidtor上传的图片
            result.put("errno",0);
            String editorFilePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+filename;
            result.put("data",new String[]{editorFilePath});//线上图片的地址
            return result;
        }


    }


}
