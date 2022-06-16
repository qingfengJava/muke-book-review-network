package com.qingfeng.controller;

import com.qingfeng.bean.BookEntity;
import com.qingfeng.common.KindEditorResult;
import com.qingfeng.common.ResultVO;
import com.qingfeng.service.BookService;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 清风学Java
 * @email 清风学Java@qq.com
 * @date 2022-05-21 11:21:03
 */
@RestController
@RequestMapping("shop/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 定义绝对路径
     */
    String realPath = "D:\\upload";

    /**
     * 查询所有图书列表，不带条件。唯一的条件的是按照热度排序
     * @return
     */
    @GetMapping("/list")
    public ResultVO list() {
        return bookService.queryList();
    }

    /**
     * 分页查询图书列表
     */
    @GetMapping("/bookList")
    public ResultVO bookList(Integer pageNum, Integer limit) {
        return bookService.queryBookList(pageNum, limit);
    }

    /**
     * 按条件进行查询
     */
    @GetMapping("/listByCondition/{categoryId}/{styleId}")
    public ResultVO listByCondition(@PathVariable("categoryId") Integer categoryId,
                                    @PathVariable("styleId") Integer styleId) {
        return bookService.queryListByCondition(categoryId, styleId);
    }

    /**
     * 根据图书id查询图书详情
     */
    @GetMapping("/detail/{id}")
    public ResultVO detail(@PathVariable("id") Integer id) {
        return bookService.queryDetail(id);
    }

    /**
     * 上传图片
     */
    /*@RequestMapping("/upload")
    public KindEditorResult uploadImg(@RequestParam("imgFile") MultipartFile imgFile){
        KindEditorResult result = new KindEditorResult();
        try {
            //查看是否有该文件夹
            File imageFolder = new File(realPath);
            //如果不存在
            if (!imageFolder.exists()) {
                //创建该文件夹
                imageFolder.mkdirs();
            }
            //如果存在,将图片的名称重新命名
            String fileName = imgFile.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String imageName= UUID.randomUUID()+suffixName;
            // 上传文件
            imgFile.transferTo(new File(realPath, imageName));
            result.setError(0);
            result.setUrl(realPath + "/" + imgFile.getOriginalFilename());
            result.setMessage("上传图片成功！");
        } catch (Exception e) {
            result.setError(1);
            result.setMessage("上传图片出错！");
        }

        return result;
    }*/

    /**
     * 删除书籍信息
     */
    @DeleteMapping("/delete/{id}")
    public ResultVO delete(@PathVariable("id") Integer id) {
        return bookService.delete(id);
    }

    /**
     * 上传图片
     * @param callBackPath
     * @param file
     * @param request
     * @param response
     * @throws FileUploadException
     * @throws IOException
     */
    @RequestMapping("/upmethod")
    public void uploadMethod(@RequestParam String callBackPath, @RequestParam(value = "imgFile", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        String scheme = request.getScheme();//http
        String serverName = request.getServerName();//localhost
        String url = scheme + "://" + serverName +":8080";//http://127.0.0.1:8080

        String referer = request.getHeader("referer");
        Pattern p = Pattern.compile("([a-z]*:(//[^/?#]+/[^/?#]*/)?)", Pattern.CASE_INSENSITIVE);
        Matcher mathcer = p.matcher(referer);
        if (mathcer.find()){
            String htmlheader = mathcer.group();// 请求来源

            response.setContentType("text/html;charset=UTF-8");
            String savePath = "D://upload/";
            String saveUrl = request.getContextPath();
            //定义允许上传的文件扩展名
            HashMap<String, String> extMap = new HashMap<String, String>();
            extMap.put("image", "gif,jpg,jpeg,png,bmp");
            extMap.put("flash", "swf,flv");
            extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
            extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

            //最大文件大小
            long maxSize = 1000000000000000L;

            response.setContentType("text/html; charset=UTF-8");

            if (!ServletFileUpload.isMultipartContent(request)) {
                System.out.println("请选择文件。");
                response.sendRedirect(getError(htmlheader,"请选择文件.", callBackPath));
                return;
            }
            //检查目录
            File uploadDir = new File(savePath);
            if (!uploadDir.isDirectory()) {
                System.out.println("上传目录不存在。");
                response.sendRedirect(getError(htmlheader,"上传目录不存在。", callBackPath));
                return;
            }
            //检查目录写权限
            if (!uploadDir.canWrite()) {
                System.out.println("上传目录没有写权限。");
                response.sendRedirect(getError(htmlheader,"上传目录没有写权限。", callBackPath));
                return;
            }

            String dirName = request.getParameter("dir");
            if (dirName == null) {
                dirName = "image";
            }
            if (!extMap.containsKey(dirName)) {
                System.out.println("目录名不正确。");
                response.sendRedirect(getError(htmlheader,"目录名不正确。", callBackPath));
                return;
            }
            //创建文件夹
            savePath += dirName + "/";
            saveUrl += dirName + "/";
            File saveDirFile = new File(savePath);
            if (!saveDirFile.exists()) {
                saveDirFile.mkdirs();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            savePath += ymd + "/";
            saveUrl += ymd + "/";
            File dirFile = new File(savePath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            long fileSize = file.getSize();
            //检查文件大小
            if (file.getSize() > maxSize) {
                System.out.println("上传文件大小超过限制。");
                response.sendRedirect(getError(htmlheader,"上传文件大小超过限制。", callBackPath));
                return;
            }
            //检查扩展名
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
                System.out.println("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
                response.sendRedirect(getError(htmlheader,"上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。", callBackPath));
                return;
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
            try {
                File uploadedFile = new File(savePath, newFileName);
                OutputStream os = new FileOutputStream(uploadedFile);
                InputStream inputStream = file.getInputStream();
                byte[] buf = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(buf)) != -1) {
                    os.write(buf, 0, length);
                }
                inputStream.close();
                os.close();
            } catch (Exception e) {
                System.out.println("上传文件失败。");
                response.sendRedirect(getError(htmlheader,"上传文件失败。", callBackPath));
                return;
            }

            Map<String, Object> msgMap = new HashMap<String, Object>();
            msgMap.put("error", 0);
            msgMap.put("url", "");
            String urlString = "";
            //根据自己实际情况做修改
            //urlString = "http://localhost:63342/Beginner_admin/" + callBackPath + "?error=0&url=" + "http://192.168.2.158:8080/file/" + saveUrl + newFileName;
            urlString = htmlheader + callBackPath + "?error=0&url=" + url+"/file/" + saveUrl + newFileName;
            System.out.println(urlString);
            response.sendRedirect(urlString);
        }
    }

    private String getError(String htmluel,String message, String callBackPath) throws UnsupportedEncodingException {
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("error", 1);
        msg.put("message", message);

        String urlString = htmluel + callBackPath + "?error=1&message=" + URLEncoder.encode(message, "UTF-8");

        return urlString;
    }

    /**
     * 添加图书
     */
    @PostMapping("/addBook")
    public ResultVO addBook(@RequestBody BookEntity book) {
        return bookService.addBook(book);
    }


}
