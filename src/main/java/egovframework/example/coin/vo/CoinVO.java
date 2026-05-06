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
package egovframework.example.coin.vo;

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2009.03.16 최초생성
 * 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */
public class CoinVO {
    
    // coinDAO.list
    private String coinVol;
    private String grp2No;
    private String cntrNo;
    private String coinNo;
    private String coinYears;
    private String coinYear2s;
    private String grp2Name;
    private String cntrName;
    private String coinName;
    private String coinEtc;
    private String cntrCnt;
    
    public String getCoinVol() {
        return coinVol;
    }
    
    public void setCoinVol(String coinVol) {
        this.coinVol = coinVol;
    }
    
    public String getGrp2No() {
        return grp2No;
    }
    
    public void setGrp2No(String grp2No) {
        this.grp2No = grp2No;
    }
    
    public String getCntrNo() {
        return cntrNo;
    }
    
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }
    
    public String getCoinNo() {
        return coinNo;
    }
    
    public void setCoinNo(String coinNo) {
        this.coinNo = coinNo;
    }
    
    public String getCoinYears() {
        return coinYears;
    }
    
    public void setCoinYears(String coinYears) {
        this.coinYears = coinYears;
    }
    
    public String getCoinYear2s() {
        return coinYear2s;
    }
    
    public void setCoinYear2s(String coinYear2s) {
        this.coinYear2s = coinYear2s;
    }
    
    public String getGrp2Name() {
        return grp2Name;
    }
    
    public void setGrp2Name(String grp2Name) {
        this.grp2Name = grp2Name;
    }
    
    public String getCntrName() {
        return cntrName;
    }
    
    public void setCntrName(String cntrName) {
        this.cntrName = cntrName;
    }
    
    public String getCoinName() {
        return coinName;
    }
    
    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
    
    public String getCoinEtc() {
        return coinEtc;
    }
    
    public void setCoinEtc(String coinEtc) {
        this.coinEtc = coinEtc;
    }
    
    public String getCntrCnt() {
        return cntrCnt;
    }
    
    public void setCntrCnt(String cntrCnt) {
        this.cntrCnt = cntrCnt;
    }
    
}
