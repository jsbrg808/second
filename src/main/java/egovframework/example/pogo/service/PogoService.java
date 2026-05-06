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
package egovframework.example.pogo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.example.pogo.vo.Pogo5VO;
import egovframework.example.pogo.vo.Pogo5de2VO;
import egovframework.example.pogo.vo.Pogo5pc2VO;
import egovframework.example.pogo.vo.Pogo5ynVO;

/**
 * @Class Name : EgovSampleService.java
 * @Description : EgovSampleService Class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @ 2009.03.16 최초생성
 * 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Service
public interface PogoService {
    
    // selectPogo5fList
    List<Pogo5VO> selectPogo5fList() throws Exception;

    List<Pogo5VO> selectPogo5fListByNm(Pogo5VO pogo5VO) throws Exception;

    List<Pogo5VO> selectPogo5fListByBasNm(Pogo5VO pogo5VO) throws Exception;
    
    // appendPogo5f
    void appendPogo5f(Pogo5VO pogo5VO) throws Exception;
    
    // updatePogo5f
    void updatePogo5f(Pogo5VO pogo5VO) throws Exception;
    
    // deletePogo5f
    void deletePogo5f(Pogo5VO pogo5VO) throws Exception;
    
    void updatePogo5fDec(Pogo5VO pogo5VO) throws Exception;
    
    // insertPogo5f
    void updatePogo5fInc(Pogo5VO pogo5VO) throws Exception;
    
    void insertPogo5f(Pogo5VO pogo5VO) throws Exception;
    
    // selectPogo5sList
    List<Pogo5VO> selectPogo5sList() throws Exception;

    List<Pogo5VO> selectPogo5sListByNm(Pogo5VO pogo5VO) throws Exception;

    List<Pogo5VO> selectPogo5sListByBasNm(Pogo5VO pogo5VO) throws Exception;
    
    // appendPogo5s
    void appendPogo5s(Pogo5VO pogo5VO) throws Exception;
    
    // updatePogo5s
    void updatePogo5s(Pogo5VO pogo5VO) throws Exception;
    
    // deletePogo5s
    void deletePogo5s(Pogo5VO pogo5VO) throws Exception;
    
    void updatePogo5sDec(Pogo5VO pogo5VO) throws Exception;
    
    // insertPogo5s
    void updatePogo5sInc(Pogo5VO pogo5VO) throws Exception;
    
    void insertPogo5s(Pogo5VO pogo5VO) throws Exception;
    
    // selectPogo5tList
    List<Pogo5VO> selectPogo5tList() throws Exception;

    List<Pogo5VO> selectPogo5tListByNm(Pogo5VO pogo5VO) throws Exception;

    List<Pogo5VO> selectPogo5tListByBasNm(Pogo5VO pogo5VO) throws Exception;
    
    // appendPogo5t
    void appendPogo5t(Pogo5VO pogo5VO) throws Exception;
    
    // updatePogo5t
    void updatePogo5t(Pogo5VO pogo5VO) throws Exception;
    
    // deletePogo5t
    void deletePogo5t(Pogo5VO pogo5VO) throws Exception;
    
    void updatePogo5tDec(Pogo5VO pogo5VO) throws Exception;
    
    // insertPogo5t
    void updatePogo5tInc(Pogo5VO pogo5VO) throws Exception;

    void insertPogo5t(Pogo5VO pogo5VO) throws Exception;

    // selectPogo5pc2List
    List<Pogo5pc2VO> selectPogo5pc2List() throws Exception;

    // selectPogo5de2List
    List<Pogo5de2VO> selectPogo5de2List() throws Exception;

    // selectPogo5ynList
    List<Pogo5ynVO> selectPogo5ynList() throws Exception;

}
