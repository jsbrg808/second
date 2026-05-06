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
package egovframework.example.coin.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.example.coin.service.CoinService;
import egovframework.example.coin.vo.CodeVO;
import egovframework.example.coin.vo.CoinVO;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2009.03.16 최초생성
 * 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Controller
@SessionAttributes(types = CoinVO.class)
public class CoinController {
    
    @Resource(name = "coinService")
    private CoinService coinService;
    
    @RequestMapping(value = "/selectCoinList.do")
    public String selectCoinList(CoinVO coinVO, ModelMap model) throws Exception {
        
        List<CodeVO> grp2CodeList = coinService.selectGrp2CodeList();
        model.addAttribute("grp2CodeList", grp2CodeList);
        
        List<CoinVO> coinList = coinService.selectCoinList(coinVO);
        model.addAttribute("coinList", coinList);
        
        return "coin/coinList";
    }
    
}
