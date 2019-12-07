package com.zxk.demo.controller;

import com.zxk.demo.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@CrossOrigin
public class FileUpLoadController {
    private int number;

    @Autowired
    private InvestmentService investmentService;

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String pattern="(.*?)\\.xlsx";
        if(!fileName.matches(pattern)){
            return("只能上传excel文件");
        }


        String path = "/root/local/work/FileLoad/"+ this.number+fileName;
        File dest = new File(path);


        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
        } catch (IOException e) {
            return "-3";
        }

        return "successful";
    }

    //传递上传文件时的项目编号
    @RequestMapping("/addNumber/{number}")
    public void addNumber(@PathVariable("number") int number){
        this.number=number;
        System.out.println(this.number);
    }

    @RequestMapping("/deleteFile")
    public String delFile(@RequestParam("fileName")String fileName,@RequestParam("investmentNumber") Integer investmentNumber) {
        String resultInfo = null;
        System.out.println(fileName);
        String path="/root/local/work/FileLoad/"  + fileName;

        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                resultInfo =  "删除成功";
            } else {
                resultInfo =  "删除失败";
            }
        } else {
            resultInfo = "文件不存在！";
        }

        investmentService.updateFile(investmentNumber);
        return resultInfo;
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    public String downloadFile(@RequestParam("fileName") String fileName, HttpServletRequest request,
                               HttpServletResponse response) throws UnsupportedEncodingException {

        System.out.println(fileName);

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            //设置文件路径
            String realPath = "/root/local/work/FileLoad/";
            File file = new File(realPath, fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download the song successfully!");
                } catch (Exception e) {
                    System.out.println("Download the song failed!");
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("Don't exists");
            }
        }
        return null;
    }


//    @RequestMapping(value = "/fileUpload",method =RequestMethod.POST )
//    public String imgUpload(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
//        long  startTime=System.currentTimeMillis();
//        System.out.println("fileName："+file.getOriginalFilename());
//        String path="D:/"+new Date().getTime()+file.getOriginalFilename();
//
//        File newFile=new File(path);
//        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
//        file.transferTo(newFile);
//        long  endTime=System.currentTimeMillis();
//        System.out.println("采用file.Transto的运行时间："+String.valueOf(endTime-startTime)+"ms");
//        return "/success";
//
//    }
}


