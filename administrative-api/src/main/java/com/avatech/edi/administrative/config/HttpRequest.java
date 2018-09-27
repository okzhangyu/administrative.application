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
    private final String BASE_URL = "http://oatest.chinaautomationgroup.com/seeyon/rest/";
    private final String TOKEN_URL = "http://oatest.chinaautomationgroup.com/seeyon/rest/token/rest/12345abc!";


    @Autowired
    private UserTokenService userTokenService;

    public String getRequestUrl(String objCode, String opType) {
        String resource = getResource(objCode, opType);
        UserToken userToken = userTokenService.fetchUserToken();
        if (userToken == null || (userToken != null && userToken.getExpired() <= DateUtil.getLongTime())) {
            RestTemplate template = new RestTemplate();
            String token = template.getForObject(TOKEN_URL, String.class);
            userToken = new UserToken();
            userToken.setExpired(DateUtil.getLongTime(LocalDateTime.now().plusMinutes(15)));
            userToken.setId("1");
            userToken.setToken(token);
            userTokenService.updateToken(userToken);

            return resource + "?token=" + token;
        } else {
            userToken.setExpired(DateUtil.getLongTime(LocalDateTime.now().plusMinutes(15)));
            userTokenService.updateToken(userToken);
            return resource + "?token=" + userToken.getToken();
        }
    }


    private String getResource(String objCode, String opType) {
        switch (opType) {
            case OpType.ADD: {
                switch (objCode) {
                    case MasterDataType.ACCOUNT:
                        return BASE_URL + "sapvoucher/addsubject";
                    case MasterDataType.COSTCENTER:
                        return BASE_URL + "sapvoucher/addcostcenter";
                    case MasterDataType.PROJECT:
                        return BASE_URL + "sapvoucher/addproject";
                    case MasterDataType.CASHFLOW:
                        return BASE_URL + "sapvoucher/addcashstream";
                    case MasterDataType.DEPARTMENT:
                        return BASE_URL + "orgDepartment";
                    case MasterDataType.EMPLOYEE:
                        return BASE_URL + "orgMember";
                    default:
                        return null;
                }
            }
            case OpType.UPDATE: {
                switch (objCode) {
                    case MasterDataType.ACCOUNT:
                        return BASE_URL + "sapvoucher/changesubject";
                    case MasterDataType.COSTCENTER:
                        return BASE_URL + "sapvoucher/changecostcenter";
                    case MasterDataType.PROJECT:
                        return BASE_URL + "sapvoucher/changeproject";
                    case MasterDataType.CASHFLOW:
                        return BASE_URL + "sapvoucher/changecashstream";
                    default:
                        return null;
                }
            }
            case OpType.FETCH: {
                switch (objCode) {
                    case MasterDataType.COMPANY:
                        return BASE_URL + "orgAccounts";
                    default:
                        return null;
                }
            }
            default:
                throw new ServiceException("无效的操作类型");
        }
    }
}
