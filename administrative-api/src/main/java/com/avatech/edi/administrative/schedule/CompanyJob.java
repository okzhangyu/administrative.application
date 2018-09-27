package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Company;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.service.CompanyService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyJob {

    private final Logger logger = LoggerFactory.getLogger(CompanyJob.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private HttpRequest request;

    @Autowired
    public  ObjectMapper mapper ;

    @Scheduled(cron="0 0/1 * * * ?")
    private void process() throws IOException {
        try {
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> result = template.getForEntity(request.getRequestUrl(MasterDataType.COMPANY, OpType.FETCH), String.class);
            logger.info("接收到公司信息：" + result.toString());
            JavaType javaType = getCollectionType(ArrayList.class, Company.class);
            List<Company> companies = (List<Company>) mapper.readValue(result.getBody(), javaType);
            companyService.saveCompany(companies);
        } catch (Exception e) {
            logger.error("公司信息获取异常：" + e);
        }

    }

    public  JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
