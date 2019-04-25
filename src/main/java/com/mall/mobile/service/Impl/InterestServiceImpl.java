package com.mall.mobile.service.Impl;

import com.mall.common.param.BasicData;
import com.mall.mobile.dao.InterestMapper;
import com.mall.mobile.dao.UserMapper;
import com.mall.mobile.domen.Interest;
import com.mall.mobile.domen.User;
import com.mall.mobile.service.InterestService;
import com.mall.pc.dao.TradeInfoMapper;
import com.mall.pc.domen.TradeInfo;
import com.mall.pc.domen.TradeInfoTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-04-16 15:25
 **/

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestMapper interestMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TradeInfoMapper tradeInfoMapper;

    @Override
    public BasicData getInterestList(String token,String languagetype) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        List<Interest> list = interestMapper.getInterestList(user.getId());
        List<TradeInfo> tradeInfos = new ArrayList<>();
        for(Interest interest:list){
            TradeInfo tradeInfo = tradeInfoMapper.QuerytradeById(interest.getTrandid());
            TradeInfoTranslate tradeInfoTranslate = tradeInfoMapper.QueryTradeTranslateBytrandidANDType(interest.getTrandid(),languagetype);
            if(tradeInfoTranslate!=null){
                tradeInfo.setTradename(tradeInfoTranslate.getTradename());
                tradeInfo.setIntroduce(tradeInfoTranslate.getIntroduce());
                tradeInfo.setTradebright(tradeInfoTranslate.getTradebright());
                tradeInfo.setMoreinfo(tradeInfoTranslate.getMoreinfo());
            }
            tradeInfos.add(tradeInfo);
        }
        return BasicData.CreateSucess(tradeInfos);
    }

    @Override
    public BasicData lovetrade(String token, Integer trandid) {
        User user = userMapper.selectByToken(token);
        if(user==null){
            return BasicData.CreateErrorInvalidUser();
        }
        Interest interest =new Interest();
        interest.setCustid(user.getId());
        interest.setTrandid(trandid);
        Interest interest1 = interestMapper.getInterest(interest);
        if(interest1!=null){
            interestMapper.delInterest(interest);

        }else{
            interest.setCreatetime(new Date());
            interestMapper.addInterest(interest);
        }

        return BasicData.CreateSucess();
    }


}

