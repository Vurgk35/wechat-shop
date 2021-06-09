package cn.blbsz.shop.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2017/3/31.
 */
public interface UserService {
    public List<Map<String, Object>> getNewBankUserInfo(Integer userID);
}
