package com.avatech.edi.administrative.config;

import com.avatech.edi.administrative.model.bo.B1Connection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;

@Component
public class B1Manager {
    private final Logger logger = LoggerFactory.getLogger(B1Manager.class);
   String path ="C:\\Users\\Administrator\\Desktop\\companyconfig\\companyinfo.jason";
        File file=new File(path);

    private static List<B1Connection> b1Connections;

    private List<B1Connection> getB1Connections() throws IOException {

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);

//            InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
//            inputStreamReader = new InputStreamReader(stream); // 建立一个输入流对象reader
            bufferedReader = new BufferedReader(fileReader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            StringBuffer stringBuffer = new StringBuffer();
            String line = bufferedReader.readLine().trim();
            while (line != null) {
                stringBuffer.append(line);
                line = bufferedReader.readLine(); // 一次读入一行数据
            }
            Gson gson = new GsonBuilder().create();
            List<B1Connection> companyInfos = gson.fromJson(stringBuffer.toString(), new TypeToken<List<B1Connection>>() {
            }.getType());
            return companyInfos;
        } catch (IOException e) {
            logger.info("读取配置文件出错", e);
            throw new ServiceException("50002", "读取配置文件出错");
        } finally {
            if (null != bufferedReader) bufferedReader.close();
        }
    }

    public B1Connection getB1ConnInstance(String companyName)   {
        B1Connection connection = null;
        try{
            if(b1Connections == null || b1Connections.size() == 0){
                b1Connections = getB1Connections();
            }
            for (B1Connection conn:b1Connections) {
                if(companyName.equals(conn.getCompanyName())){
                    connection = conn;
                }
            }
        }
        catch (Exception e){
            throw new ServiceException("50003","公司信息配置信息匹配异常");
        }
        if(connection == null){
            throw new ServiceException("50004","未找到匹配的公司信息");
        }
        return connection;
    }
}
