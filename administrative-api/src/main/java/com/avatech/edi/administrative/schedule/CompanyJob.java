package com.avatech.edi.administrative.schedule;

import com.avatech.edi.administrative.config.HttpRequest;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.bo.Company;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.DefaultValue;
import com.avatech.edi.administrative.service.CompanyService;
import com.fasterxml.jackson.core.type.TypeReference;
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
@Component
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
            if(companies == null || companies.size() == 0)
                return;
            companyService.saveCompany(companies);

            for (Company company :companies) {
                ResponseEntity<String> rstPosition = template.getForEntity(request.getOrgUrl(MasterDataType.POSITION, company.getOrgAccountId()), String.class);
                if(rstPosition.hasBody()){
                    List<DefaultValue> defaultValues = mapper.readValue(rstPosition.getBody(), new TypeReference<List<DefaultValue>>() {});
                    if(defaultValues.size() > 0)
                        company.setDefPositionId(defaultValues.get(0).getId());
                }

                ResponseEntity<String> rstLevel = template.getForEntity(request.getOrgUrl(MasterDataType.LEVEL, company.getOrgAccountId()), String.class);
                if(rstLevel.hasBody()){
                    List<DefaultValue> defaultValues = mapper.readValue(rstLevel.getBody(), new TypeReference<List<DefaultValue>>() {});
                    if(defaultValues.size() > 0)
                        company.setDefLevelId(defaultValues.get(0).getId());
                }
            }
            companyService.saveCompany(companies);
        } catch (Exception e) {
            logger.error("公司信息获取异常：" + e);
        }

    }

    public  JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
