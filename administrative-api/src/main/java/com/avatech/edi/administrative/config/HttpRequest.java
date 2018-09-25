package com.avatech.edi.administrative.config;

import com.avatech.edi.administrative.data.DateUtil;
import com.avatech.edi.administrative.data.OpType;
import com.avatech.edi.administrative.model.config.MasterDataType;
import com.avatech.edi.administrative.model.dto.Response;
import com.avatech.edi.administrative.model.dto.UserToken;
import com.avatech.edi.administrative.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class HttpRequest {
    private final String BASE_URL = "http://oatest.chinaautomationgroup.com/seeyon/rest/sapvoucher";
    private final String TOKEN_URL = "http://oatest.chinaautomationgroup.com/seeyon/rest/token/rest/12345abc!";


    @Autowired
    private UserTokenService userTokenService;

    public String getRequestUrl(String objCode, String opType){
        String url = getResource(objCode,opType);
        // get token
        UserToken userToken = userTokenService.fetchUserToken();
        if(userToken == null || (userToken != null && userToken.getExpired() <= DateUtil.getLongTime())){
            RestTemplate template = new RestTemplate();
            String token = template.getForObject(TOKEN_URL,String.class);
            userToken = new UserToken();
            userToken.setExpired(DateUtil.getLongTime(LocalDateTime.now().plusMinutes(15)));
            userToken.setId("1");
            userToken.setToken(token);
            userTokenService.updateToken(userToken);

            return url+"?token="+token;
        }else {
            userToken.setExpired(DateUtil.getLongTime(LocalDateTime.now().plusMinutes(15)));
            userTokenService.updateToken(userToken);
            return url+"?token="+userToken.getToken();
        }
    }


    private String getResource(String objCode,String opType) {
        if(OpType.ADD.equals(opType)){
            switch (objCode) {
                case MasterDataType.ACCOUNT:
                    return BASE_URL + "/addsubject";
                case MasterDataType.COSTCENTER:
                    return BASE_URL + "/addcostcenter";
                case MasterDataType.PROJECT:
                    return BASE_URL + "/addproject";
                case MasterDataType.CASHFLOW:
                    return BASE_URL + "/addcashstream";
                default:
                    return null;
            }
        }else if(OpType.UPDATE.equals(opType)){
            switch (objCode) {
                case MasterDataType.ACCOUNT:
                    return BASE_URL + "/changesubject";
                case MasterDataType.COSTCENTER:
                    return BASE_URL + "/changecostcenter";
                case MasterDataType.PROJECT:
                    return BASE_URL + "/changeproject";
                case MasterDataType.CASHFLOW:
                    return BASE_URL + "/changecashstream";
                default:
                    return null;
            }
        }else {
            throw new ServiceException("无效的中间表操作类型");
        }
    }
}
