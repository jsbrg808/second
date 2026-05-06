/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.coin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.coin.service.CoinService;
import egovframework.example.coin.vo.CodeVO;
import egovframework.example.coin.vo.CoinVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2009.03.16 최초생성
 * 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Service("coinService")
public class CoinServiceImpl extends EgovAbstractServiceImpl implements CoinService {
    
    @Resource(name = "codeDAO")
    private CodeDAO codeDAO;
    
    @Resource(name = "coinDAO")
    private CoinDAO coinDAO;
    
    @Override
    public List<CodeVO> selectGrp2CodeList() throws Exception {
        return codeDAO.list();
    }
    
    @Override
    public List<CoinVO> selectCoinList(CoinVO coinVO) throws Exception {
        return coinDAO.list(coinVO);
    }
    
}
