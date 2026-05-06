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

import org.springframework.stereotype.Repository;

import egovframework.example.pogo.vo.Pogo5VO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2009.03.16 최초생성
 * 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Repository("pogo5fDAO")
public class Pogo5fDAO extends EgovAbstractDAO {
    
    public List<Pogo5VO> list() throws Exception {
        return (List<Pogo5VO>) list("pogo5fDAO.list");
    }

    public List<Pogo5VO> listByNm(Pogo5VO pogo5VO) throws Exception {
        return (List<Pogo5VO>) list("pogo5fDAO.listByNm", pogo5VO);
    }

    public List<Pogo5VO> listByBasNm(Pogo5VO pogo5VO) throws Exception {
        return (List<Pogo5VO>) list("pogo5fDAO.listByBasNm", pogo5VO);
    }
    
    public void append(Pogo5VO pogo5VO) throws Exception {
        insert("pogo5fDAO.append", pogo5VO);
    }
    
    public void update(Pogo5VO pogo5VO) throws Exception {
        update("pogo5fDAO.update", pogo5VO);
    }
    
    public void delete(Pogo5VO pogo5VO) throws Exception {
        delete("pogo5fDAO.delete", pogo5VO);
    }
    
    public void updateDec(Pogo5VO pogo5VO) throws Exception {
        update("pogo5fDAO.updateDec", pogo5VO);
    }
    
    public void updateInc(Pogo5VO pogo5VO) throws Exception {
        update("pogo5fDAO.updateInc", pogo5VO);
    }
    
    public void insert(Pogo5VO pogo5VO) throws Exception {
        insert("pogo5fDAO.insert", pogo5VO);
    }
    
}
