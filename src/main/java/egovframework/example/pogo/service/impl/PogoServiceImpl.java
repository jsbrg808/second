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
package egovframework.example.pogo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.pogo.service.PogoService;
import egovframework.example.pogo.vo.Pogo5VO;
import egovframework.example.pogo.vo.Pogo5de2VO;
import egovframework.example.pogo.vo.Pogo5pc2VO;
import egovframework.example.pogo.vo.Pogo5ynVO;
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

@Service("pogoService")
public class PogoServiceImpl extends EgovAbstractServiceImpl implements PogoService {
    
    @Resource(name = "pogo5fDAO")
    private Pogo5fDAO pogo5fDAO;
    @Resource(name = "pogo5sDAO")
    private Pogo5sDAO pogo5sDAO;
    @Resource(name = "pogo5tDAO")
    private Pogo5tDAO pogo5tDAO;
    @Resource(name = "pogo5pc2DAO")
    private Pogo5pc2DAO pogo5pc2DAO;
    @Resource(name = "pogo5de2DAO")
    private Pogo5de2DAO pogo5de2DAO;
    @Resource(name = "pogo5ynDAO")
    private Pogo5ynDAO pogo5ynDAO;
    
    @Override
    public List<Pogo5VO> selectPogo5fList() throws Exception {
        return pogo5fDAO.list();
    }

    @Override
    public List<Pogo5VO> selectPogo5fListByNm(Pogo5VO pogo5VO) throws Exception {
        return pogo5fDAO.listByNm(pogo5VO);
    }

    @Override
    public List<Pogo5VO> selectPogo5fListByBasNm(Pogo5VO pogo5VO) throws Exception {
        return pogo5fDAO.listByBasNm(pogo5VO);
    }
    
    // default_ 포맷: X<gender(1)><lvl(2)><name>[ <iv>]
    // 예) "ym35피카츄 98" → gender=m, lvl=35, name=피카츄, iv=98
    private void parsePogo5VO(Pogo5VO vo) {
        String d = vo.getDefault_();
        if (d == null || d.length() < 4) return;
        vo.setGender(d.substring(1, 2));
        vo.setLvl(d.substring(2, 4));
        int spaceIdx = d.indexOf(' ');
        if (spaceIdx < 0) {
            vo.setName(d.substring(4));
            vo.setIv("100");
        } else {
            vo.setName(d.substring(4, spaceIdx));
            vo.setIv(d.substring(spaceIdx + 1));
        }
    }

    @Override
    public void appendPogo5f(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5fDAO.append(pogo5VO);
    }

    @Override
    public void updatePogo5f(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5fDAO.update(pogo5VO);
    }

    @Override
    public void deletePogo5f(Pogo5VO pogo5VO) throws Exception {
        pogo5fDAO.delete(pogo5VO);
    }

    @Override
    public void updatePogo5fDec(Pogo5VO pogo5VO) throws Exception {
        pogo5fDAO.updateDec(pogo5VO);
    }

    @Override
    public void updatePogo5fInc(Pogo5VO pogo5VO) throws Exception {
        pogo5fDAO.updateInc(pogo5VO);
    }

    @Override
    public void insertPogo5f(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5fDAO.insert(pogo5VO);
    }

    @Override
    public List<Pogo5VO> selectPogo5sList() throws Exception {
        return pogo5sDAO.list();
    }

    @Override
    public List<Pogo5VO> selectPogo5sListByNm(Pogo5VO pogo5VO) throws Exception {
        return pogo5sDAO.listByNm(pogo5VO);
    }

    @Override
    public List<Pogo5VO> selectPogo5sListByBasNm(Pogo5VO pogo5VO) throws Exception {
        return pogo5sDAO.listByBasNm(pogo5VO);
    }

    @Override
    public void appendPogo5s(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5sDAO.append(pogo5VO);
    }

    @Override
    public void updatePogo5s(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5sDAO.update(pogo5VO);
    }

    @Override
    public void deletePogo5s(Pogo5VO pogo5VO) throws Exception {
        pogo5sDAO.delete(pogo5VO);
    }

    @Override
    public void updatePogo5sDec(Pogo5VO pogo5VO) throws Exception {
        pogo5sDAO.updateDec(pogo5VO);
    }

    @Override
    public void updatePogo5sInc(Pogo5VO pogo5VO) throws Exception {
        pogo5sDAO.updateInc(pogo5VO);
    }

    @Override
    public void insertPogo5s(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5sDAO.insert(pogo5VO);
    }

    @Override
    public List<Pogo5VO> selectPogo5tList() throws Exception {
        return pogo5tDAO.list();
    }

    @Override
    public List<Pogo5VO> selectPogo5tListByNm(Pogo5VO pogo5VO) throws Exception {
        return pogo5tDAO.listByNm(pogo5VO);
    }

    @Override
    public List<Pogo5VO> selectPogo5tListByBasNm(Pogo5VO pogo5VO) throws Exception {
        return pogo5tDAO.listByBasNm(pogo5VO);
    }

    @Override
    public void appendPogo5t(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5tDAO.append(pogo5VO);
    }

    @Override
    public void updatePogo5t(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5tDAO.update(pogo5VO);
    }

    @Override
    public void deletePogo5t(Pogo5VO pogo5VO) throws Exception {
        pogo5tDAO.delete(pogo5VO);
    }

    @Override
    public void updatePogo5tDec(Pogo5VO pogo5VO) throws Exception {
        pogo5tDAO.updateDec(pogo5VO);
    }

    @Override
    public void updatePogo5tInc(Pogo5VO pogo5VO) throws Exception {
        pogo5tDAO.updateInc(pogo5VO);
    }

    @Override
    public void insertPogo5t(Pogo5VO pogo5VO) throws Exception {
        parsePogo5VO(pogo5VO);
        pogo5tDAO.insert(pogo5VO);
    }

    @Override
    public List<Pogo5pc2VO> selectPogo5pc2List() throws Exception {
        return pogo5pc2DAO.list();
    }

    @Override
    public List<Pogo5de2VO> selectPogo5de2List() throws Exception {
        return pogo5de2DAO.list();
    }

    @Override
    public List<Pogo5ynVO> selectPogo5ynList() throws Exception {
        return pogo5ynDAO.list();
    }

}
