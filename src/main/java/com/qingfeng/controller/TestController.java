package com.qingfeng.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
public class TestController {

    @RequestMapping(path = "/save_photo", method = {RequestMethod.POST})
    public Map  addDish(@RequestParam("imgFile") MultipartFile imgFile, HttpServletResponse response,HttpServletRequest request,@RequestParam String callBackPath) throws Exception {
        Map map=new HashMap();
        String returnUrl;
        String fileName = imgFile.getOriginalFilename();// 文件原名称
        String path = null;// 文件路径
        double fileSize = imgFile.getSize();
        System.out.println("文件的大小是"+ fileSize);
        byte[] sizebyte=imgFile.getBytes();
        System.out.println("文件的byte大小是"+ sizebyte.toString());
        if (imgFile != null) {// 判断上传的文件是否为空
            String type = null;// 文件类型
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空

                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径
                    path = "D:\\upload\\images\\"+fileName;
                    System.out.println("存放图片文件的路径:" + path);
                    // 转存文件到指定的路径
                    imgFile.transferTo(new File(path));
                    //数据库里存"http://localhost:8083/images/"+fileName这个路径就好，因为配置文件有映射
                    map.put("error", 0);
                    map.put("url", path);
                    response.sendRedirect(callBackPath+"?error=0&url="+path);
                    return null;
                }
            } else {
                System.out.println("不是我们想要的文件类型,请按要求重新上传");
                map.put("error", 1);
                response.sendRedirect(callBackPath+ "?error=1&message="+"错误信息");
                return null;
            }
        } else {
            map.put("error", 1);
            response.sendRedirect(callBackPath+ "?error=1&message="+"错误信息");
            return null;
        }
        map.put("error", 0);
        map.put("url", "http://localhost:8083/images/"+fileName);

        response.sendRedirect(callBackPath+"?error=0&url="+"http://localhost:8083/images/"+fileName);
        return null;
    }
}

