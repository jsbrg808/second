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
package egovframework.example.pogo.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.example.pogo.service.PogoService;
import egovframework.example.pogo.vo.Pogo5VO;
import egovframework.example.pogo.vo.Pogo5de2VO;
import egovframework.example.pogo.vo.Pogo5pc2VO;
import egovframework.example.pogo.vo.Pogo5ynVO;

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
@SessionAttributes(types = Pogo5VO.class)
public class PogoController {
    
    @Resource(name = "pogoService")
    private PogoService pogoService;
    
    @RequestMapping(value = "/selectPogo5fList.do")
    public String selectPogo5fList(Pogo5VO pogo5VO, ModelMap model, HttpServletResponse response) throws Exception {

        List<Pogo5VO> pogo5List;
        String srchNm = pogo5VO.getSrchNm();

        if (srchNm != null && !srchNm.trim().isEmpty()) {
            if (srchNm.startsWith("+")) {
                pogo5VO.setSrchNm(srchNm.substring(1));
                pogo5List = pogoService.selectPogo5fListByBasNm(pogo5VO);
            } else {
                pogo5List = pogoService.selectPogo5fListByNm(pogo5VO);
            }
            model.addAttribute("srchNm", srchNm);
        } else {
            pogo5List = pogoService.selectPogo5fList();
        }

        model.addAttribute("pogo5List", pogo5List);

        return "pogo/pogo5fList";
    }
    
    @RequestMapping("/appendPogo5f.do")
    public String appendPogo5f(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.appendPogo5f(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5fList.do";
    }
    
    @RequestMapping("/updatePogo5f.do")
    public String updatePogo5f(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.updatePogo5f(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5fList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping("/deletePogo5f.do")
    public String deletePogo5f(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.deletePogo5f(pogo5VO);
        pogoService.updatePogo5fDec(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5fList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping("/insertPogo5f.do")
    public String insertPogo5f(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.updatePogo5fInc(pogo5VO);
        pogoService.insertPogo5f(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5fList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping(value = "/selectPogo5sList.do")
    public String selectPogo5sList(Pogo5VO pogo5VO, ModelMap model) throws Exception {

        List<Pogo5VO> pogo5List;
        String srchNm = pogo5VO.getSrchNm();

        if (srchNm != null && !srchNm.trim().isEmpty()) {
            if (srchNm.startsWith("+")) {
                pogo5VO.setSrchNm(srchNm.substring(1));
                pogo5List = pogoService.selectPogo5sListByBasNm(pogo5VO);
            } else {
                pogo5List = pogoService.selectPogo5sListByNm(pogo5VO);
            }
            model.addAttribute("srchNm", srchNm);
        } else {
            pogo5List = pogoService.selectPogo5sList();
        }

        model.addAttribute("pogo5List", pogo5List);

        return "pogo/pogo5sList";
    }
    
    @RequestMapping("/appendPogo5s.do")
    public String appendPogo5s(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.appendPogo5s(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5sList.do";
    }
    
    @RequestMapping("/updatePogo5s.do")
    public String updatePogo5s(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.updatePogo5s(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5sList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping("/deletePogo5s.do")
    public String deletePogo5s(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.deletePogo5s(pogo5VO);
        pogoService.updatePogo5sDec(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5sList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping("/insertPogo5s.do")
    public String insertPogo5s(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.updatePogo5sInc(pogo5VO);
        pogoService.insertPogo5s(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5sList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping(value = "/selectPogo5tList.do")
    public String selectPogo5tList(Pogo5VO pogo5VO, ModelMap model, HttpServletResponse response) throws Exception {

        List<Pogo5VO> pogo5List;
        String srchNm = pogo5VO.getSrchNm();

        if (srchNm != null && !srchNm.trim().isEmpty()) {
            if (srchNm.startsWith("+")) {
                pogo5VO.setSrchNm(srchNm.substring(1));
                pogo5List = pogoService.selectPogo5tListByBasNm(pogo5VO);
            } else {
                pogo5List = pogoService.selectPogo5tListByNm(pogo5VO);
            }
            model.addAttribute("srchNm", srchNm);
        } else {
            pogo5List = pogoService.selectPogo5tList();
        }

        model.addAttribute("pogo5List", pogo5List);

        return "pogo/pogo5tList";
    }
    
    @RequestMapping("/appendPogo5t.do")
    public String appendPogo5t(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.appendPogo5t(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5tList.do";
    }
    
    @RequestMapping("/updatePogo5t.do")
    public String updatePogo5t(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.updatePogo5t(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5tList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping("/deletePogo5t.do")
    public String deletePogo5t(Pogo5VO pogo5VO, SessionStatus status) throws Exception {
        
        pogoService.deletePogo5t(pogo5VO);
        pogoService.updatePogo5tDec(pogo5VO);
        
        status.setComplete();
        
        return "redirect:/selectPogo5tList.do#seq" + pogo5VO.getSeq();
    }
    
    @RequestMapping("/insertPogo5t.do")
    public String insertPogo5t(Pogo5VO pogo5VO, SessionStatus status) throws Exception {

        pogoService.updatePogo5tInc(pogo5VO);
        pogoService.insertPogo5t(pogo5VO);

        status.setComplete();

        return "redirect:/selectPogo5tList.do#seq" + pogo5VO.getSeq();
    }

    @RequestMapping(value = "/selectPogo5de2List.do")
    public String selectPogo5de2List(ModelMap model) throws Exception {
        List<Pogo5de2VO> pogo5de2List = pogoService.selectPogo5de2List();
        model.addAttribute("pogo5de2List", pogo5de2List);
        return "pogo/pogo5de2List";
    }

    @RequestMapping(value = "/selectPogo5ynList.do")
    public String selectPogo5ynList(ModelMap model) throws Exception {
        List<Pogo5ynVO> pogo5ynList = pogoService.selectPogo5ynList();
        model.addAttribute("pogo5ynList", pogo5ynList);
        return "pogo/pogo5ynList";
    }

    @RequestMapping(value = "/downloadPogo5pc2.do")
    public void downloadPogo5pc2(HttpServletResponse response) throws Exception {

        List<Pogo5pc2VO> list = pogoService.selectPogo5pc2List();

        HSSFWorkbook wb = new HSSFWorkbook();

        // 커스텀 팔레트 등록
        HSSFPalette palette = wb.getCustomPalette();
        palette.setColorAtIndex((short) 55, (byte) 0xCC, (byte) 0xEC, (byte) 0xFF); // 배경 연파랑
        palette.setColorAtIndex((short) 56, (byte) 0xFF, (byte) 0xCC, (byte) 0xCC); // 배경 연빨강
        palette.setColorAtIndex((short) 57, (byte) 0xFF, (byte) 0xFF, (byte) 0xCC); // 배경 연노랑
        palette.setColorAtIndex((short) 58, (byte) 0x00, (byte) 0x70, (byte) 0xC0); // 폰트 파랑
        palette.setColorAtIndex((short) 59, (byte) 0xFF, (byte) 0x00, (byte) 0x00); // 폰트 빨강
        palette.setColorAtIndex((short) 60, (byte) 0x92, (byte) 0xD0, (byte) 0x50); // 배경 연한 녹색
        palette.setColorAtIndex((short) 61, (byte) 0xFF, (byte) 0xC0, (byte) 0x00); // 배경 주황

        // 폰트: 0=기본, 1=파랑(전/울), 2=빨강(환)
        HSSFFont[] fonts = new HSSFFont[3];
        fonts[0] = wb.createFont(); fonts[0].setFontName("굴림체"); fonts[0].setFontHeightInPoints((short) 11);
        fonts[1] = wb.createFont(); fonts[1].setFontName("굴림체"); fonts[1].setFontHeightInPoints((short) 11); fonts[1].setColor((short) 58);
        fonts[2] = wb.createFont(); fonts[2].setFontName("굴림체"); fonts[2].setFontHeightInPoints((short) 11); fonts[2].setColor((short) 59);

        // styles[fontType][bgType]: bgType 0=plain, 1=yellow, 2=#CCECFF, 3=pink
        short[] bgIdx = {0, (short) 55, (short) 56, (short) 57};
        CellStyle[][] styles = new CellStyle[3][4];
        for (int ft = 0; ft < 3; ft++) {
            for (int bg = 0; bg < 4; bg++) {
                CellStyle s = wb.createCellStyle();
                if (bgIdx[bg] > 0) {
                    s.setFillForegroundColor(bgIdx[bg]);
                    s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                }
                s.setFont(fonts[ft]);
                s.setAlignment(HorizontalAlignment.CENTER);
                s.setVerticalAlignment(VerticalAlignment.CENTER);
                s.setBorderTop(BorderStyle.THIN);
                s.setBorderBottom(BorderStyle.THIN);
                s.setBorderLeft(BorderStyle.THIN);
                s.setBorderRight(BorderStyle.THIN);
                styles[ft][bg] = s;
            }
        }

        // 주황색 스타일 (조건부 행)
        CellStyle[] orangeStyles = new CellStyle[3];
        for (int fontIdx = 0; fontIdx < 3; fontIdx++) {
            CellStyle s = wb.createCellStyle();
            s.setFillForegroundColor((short) 61);
            s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            s.setFont(fonts[fontIdx]);
            s.setAlignment(HorizontalAlignment.CENTER);
            s.setVerticalAlignment(VerticalAlignment.CENTER);
            s.setBorderTop(BorderStyle.THIN);
            s.setBorderBottom(BorderStyle.THIN);
            s.setBorderLeft(BorderStyle.THIN);
            s.setBorderRight(BorderStyle.THIN);
            orangeStyles[fontIdx] = s;
        }

        // 테두리 없는 스타일 (437~438행): 배경 0=plain, 1=yellow, 2=#CCECFF, 3=pink
        CellStyle[] noBorder = new CellStyle[4];
        for (int bg = 0; bg < 4; bg++) {
            CellStyle s = wb.createCellStyle();
            if (bgIdx[bg] > 0) {
                s.setFillForegroundColor(bgIdx[bg]);
                s.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            s.setFont(fonts[0]);
            s.setAlignment(HorizontalAlignment.CENTER);
            s.setVerticalAlignment(VerticalAlignment.CENTER);
            noBorder[bg] = s;
        }

        // 녹색 스타일 (435~436행)
        HSSFFont greenFont = wb.createFont();
        greenFont.setFontName("굴림체");
        greenFont.setFontHeightInPoints((short) 11);
        CellStyle greenStyle = wb.createCellStyle();
        greenStyle.setFillForegroundColor((short) 60);
        greenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        greenStyle.setFont(greenFont);
        greenStyle.setAlignment(HorizontalAlignment.CENTER);
        greenStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        greenStyle.setBorderTop(BorderStyle.THIN);
        greenStyle.setBorderBottom(BorderStyle.THIN);
        greenStyle.setBorderLeft(BorderStyle.THIN);
        greenStyle.setBorderRight(BorderStyle.THIN);

        Sheet sheet = wb.createSheet("Sheet1");

        // 인쇄 설정
        sheet.setAutobreaks(true);                          // 페이지에 맞추기 활성화
        sheet.getPrintSetup().setPaperSize((short) 9);      // A4
        sheet.getPrintSetup().setFitWidth((short) 1);       // 모든 열을 1페이지 폭에 맞춤
        sheet.getPrintSetup().setFitHeight((short) 0);      // 높이 자동
        for (short m = 0; m <= 5; m++) sheet.setMargin(m, 0.0); // 여백 모두 0

        // 열 너비 설정 (목표 픽셀 기준, 1px ≈ 1152/31 POI units)
        // A=36px, B=44px, C=28px, D=111px, 나머지=36px, AR=28px
        final double PX = 1152.0 / 31.5; // 관측값(4.5*256=1152units=31px) 기준 단위환산
        int[] colPx = {
            36,  44,  28, 111, // A B C D
            36,  36,  36,  36, // E F G H
            36,  36,  36,  36, // I J K L
            36,  36,           // M N
            36,  36,  36,      // O P Q
            36,  36,  36,  36, // R S T U
            36,  36,  36,  36, // V W X Y
            36,  36,           // Z AA
            36,  36,  36,      // AB AC AD
            36,  36,  36,  36, // AE AF AG AH
            36,  36,  36,  36, // AI AJ AK AL
            36,  36,           // AM AN
            36,  36,  36       // AO AP AQ
        };
        for (int i = 0; i < colPx.length; i++) {
            sheet.setColumnWidth(i, (int)(colPx[i] * PX));
        }

        // 열 숨김: C(2), I~N(8~13), V~AA(21~26), AI~AN(34~39)
        sheet.setColumnHidden(2, true);
        for (int i = 8;  i <= 13; i++) sheet.setColumnHidden(i, true);
        for (int i = 21; i <= 26; i++) sheet.setColumnHidden(i, true);
        for (int i = 34; i <= 39; i++) sheet.setColumnHidden(i, true);

        int[] cntEN   = new int[10];
        int[] cntRAA  = new int[10];
        int[] cntAEAN = new int[10];
        int[] sumOQ   = new int[3];
        int[] sumABAD = new int[3];
        int[] sumAOAQ = new int[3];

        // 레벨별 카운트 맵 (f/s/t): 키="35"(div있음) 또는 "?35"(div없음)
        Map<String, Integer> fLvlMap = new HashMap<String, Integer>();
        Map<String, Integer> sLvlMap = new HashMap<String, Integer>();
        Map<String, Integer> tLvlMap = new HashMap<String, Integer>();

        int rowNum = 0;
        int seqNum = 0;
        for (Pogo5pc2VO vo : list) {
            String div = vo.getDiv() == null ? "" : vo.getDiv();

            // 숨김 여부 먼저 판단
            boolean allPowEmpty = effectivelyEmpty(vo.getPogo5fPow())
                                && effectivelyEmpty(vo.getPogo5sPow())
                                && effectivelyEmpty(vo.getPogo5tPow());
            boolean fCatEmpty = effectivelyEmpty(vo.getPogo5fCat());
            boolean sCatEmpty = effectivelyEmpty(vo.getPogo5sCat());
            String tcat = vo.getPogo5tCat() == null ? "" : vo.getPogo5tCat();
            String pmax = vo.getPogoMax()   == null ? "" : vo.getPogoMax();

            if (allPowEmpty && fCatEmpty && sCatEmpty && tcat.equals(pmax)) {
                // 숨김 행: Excel 행 미생성, fCat 집계만 유지 (수치 불변)
                accumCat(vo.getPogo5tCat(), sumAOAQ);
                continue;
            }

            // 가시 행: Excel 행 생성
            Row row = sheet.createRow(rowNum);

            int ft = "M".equals(div) ? 2 : ("L".equals(div) || "U".equals(div)) ? 1 : 0;

            // 조건부 주황색 여부 판단: AO<AB or O<AO / AP<AC or P<AP / AQ<AD or Q<AQ
            int[] fCatVals = parseCatVals(vo.getPogo5fCat(), 3);
            int[] sCatVals = parseCatVals(vo.getPogo5sCat(), 3);
            int[] tCatVals = parseCatVals(vo.getPogo5tCat(), 3);
            boolean isOrange = (sCatVals[0] < fCatVals[0] || tCatVals[0] < sCatVals[0])
                            || (sCatVals[1] < fCatVals[1] || tCatVals[1] < sCatVals[1])
                            || (sCatVals[2] < fCatVals[2] || tCatVals[2] < sCatVals[2]);

            for (int col = 0; col <= 42; col++) {
                CellStyle cs;
                if (isOrange) {
                    cs = orangeStyles[ft];
                } else {
                    int bg = (col >= 4 && col <= 13) ? 1
                           : (col >= 17 && col <= 26) ? 2
                           : (col >= 30 && col <= 39) ? 3 : 0;
                    cs = styles[ft][bg];
                }
                row.createCell(col).setCellStyle(cs);
            }

            row.getCell(0).setCellValue(++seqNum);
            if (!empty(vo.getBasId())) row.getCell(1).setCellValue(vo.getBasId());
            if (!empty(div))           row.getCell(2).setCellValue(div);
            if (!empty(vo.getName()))  row.getCell(3).setCellValue(vo.getName());

            fillPow(row, 4,  vo.getPogo5fPow(), cntEN);
            fillCat(row, 14, vo.getPogo5fCat(), sumOQ);
            fillPow(row, 17, vo.getPogo5sPow(), cntRAA);
            fillCat(row, 27, vo.getPogo5sCat(), sumABAD);
            fillPow(row, 30, vo.getPogo5tPow(), cntAEAN);
            fillCat(row, 40, vo.getPogo5tCat(), sumAOAQ);

            countLvl(vo.getPogo5fPow(), div, fLvlMap);
            countLvl(vo.getPogo5sPow(), div, sLvlMap);
            countLvl(vo.getPogo5tPow(), div, tLvlMap);

            rowNum++;
        }

        int dc = rowNum; // 실제 Excel에 쓴 행 수 (숨김 행 제외)
        int d435 = list.isEmpty() ? 0 : list.get(0).getPogoTotal(); // D435: mal_max+fem_max+gen_max 합계

        // ===== 435행 =====
        Row r435 = sheet.createRow(dc);
        for (int col = 0; col <= 42; col++) r435.createCell(col).setCellStyle(greenStyle);

        r435.getCell(3).setCellValue(d435); // D435

        for (int i = 0; i < 10; i++) {
            if (cntEN[i]   > 0) r435.getCell(4  + i).setCellValue(cntEN[i]);
            if (cntRAA[i]  > 0) r435.getCell(17 + i).setCellValue(cntRAA[i]);
            if (cntAEAN[i] > 0) r435.getCell(30 + i).setCellValue(cntAEAN[i]);
        }
        for (int i = 0; i < 3; i++) {
            if (sumOQ[i]   > 0) r435.getCell(14 + i).setCellValue(sumOQ[i]);
            if (sumABAD[i] > 0) r435.getCell(27 + i).setCellValue(sumABAD[i]);
            if (sumAOAQ[i] > 0) r435.getCell(40 + i).setCellValue(sumAOAQ[i]);
        }

        // ===== 436행 =====
        Row r436 = sheet.createRow(dc + 1);
        for (int col = 0; col <= 42; col++) r436.createCell(col).setCellStyle(greenStyle);

        int sEN   = 0; for (int v : cntEN)   sEN   += v;
        int sRAA  = 0; for (int v : cntRAA)  sRAA  += v;
        int sAEAN = 0; for (int v : cntAEAN) sAEAN += v;
        int sOQ   = sumOQ[0]   + sumOQ[1]   + sumOQ[2];
        int sABAD = sumABAD[0] + sumABAD[1] + sumABAD[2];
        int sAOAQ = sumAOAQ[0] + sumAOAQ[1] + sumAOAQ[2];

        String today = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

        addMerge(sheet, r436, dc + 1, 0,  3,  today,           greenStyle);
        addMerge(sheet, r436, dc + 1, 4,  13, sEN,             greenStyle);
        addMerge(sheet, r436, dc + 1, 14, 16, d435 - sOQ,      greenStyle);
        addMerge(sheet, r436, dc + 1, 17, 26, sRAA,             greenStyle);
        addMerge(sheet, r436, dc + 1, 27, 29, d435 - sABAD,    greenStyle);
        addMerge(sheet, r436, dc + 1, 30, 39, sAEAN,            greenStyle);
        addMerge(sheet, r436, dc + 1, 40, 42, d435 - sAOAQ,    greenStyle);

        // ===== 437행(레벨 숫자) / 438행(카운트) =====
        // 가시 열: E~H(4~7), O~Q(14~16) / R~U(17~20), AB~AD(27~29) / AE~AH(30~33), AO~AQ(40~42)
        int[] fCols = {4, 5, 6, 7, 14, 15, 16};
        int[] sCols = {17, 18, 19, 20, 27, 28, 29};
        int[] tCols = {30, 31, 32, 33, 40, 41, 42};

        List<String[]> fLvls = topLevels(fLvlMap);
        List<String[]> sLvls = topLevels(sLvlMap);
        List<String[]> tLvls = topLevels(tLvlMap);

        Row r437 = sheet.createRow(dc + 2);
        Row r438 = sheet.createRow(dc + 3);

        for (int col = 0; col <= 42; col++) {
            int bg = (col >= 4 && col <= 16) ? 1
                   : (col >= 17 && col <= 29) ? 2
                   : (col >= 30) ? 3 : 0;
            r437.createCell(col).setCellStyle(noBorder[bg]);
            r438.createCell(col).setCellStyle(noBorder[bg]);
        }
        for (int i = 0; i < fLvls.size(); i++) {
            r437.getCell(fCols[i]).setCellValue(fLvls.get(i)[0]);           // 레벨 라벨
            r438.getCell(fCols[i]).setCellValue(Integer.parseInt(fLvls.get(i)[1])); // 카운트
        }
        for (int i = 0; i < sLvls.size(); i++) {
            r437.getCell(sCols[i]).setCellValue(sLvls.get(i)[0]);
            r438.getCell(sCols[i]).setCellValue(Integer.parseInt(sLvls.get(i)[1]));
        }
        for (int i = 0; i < tLvls.size(); i++) {
            r437.getCell(tCols[i]).setCellValue(tLvls.get(i)[0]);
            r438.getCell(tCols[i]).setCellValue(Integer.parseInt(tLvls.get(i)[1]));
        }

        List<String[]> fOver = overflowLevels(fLvlMap);
        List<String[]> sOver = overflowLevels(sLvlMap);
        List<String[]> tOver = overflowLevels(tLvlMap);
        boolean hasOverflow = !fOver.isEmpty() || !sOver.isEmpty() || !tOver.isEmpty();

        if (hasOverflow) {
            Row r439 = sheet.createRow(dc + 4);
            Row r440 = sheet.createRow(dc + 5);
            for (int col = 0; col <= 42; col++) {
                int bg = (col >= 4 && col <= 16) ? 1
                       : (col >= 17 && col <= 29) ? 2
                       : (col >= 30) ? 3 : 0;
                r439.createCell(col).setCellStyle(noBorder[bg]);
                r440.createCell(col).setCellStyle(noBorder[bg]);
            }
            for (int i = 0; i < fOver.size() && i < fCols.length; i++) {
                r439.getCell(fCols[i]).setCellValue(fOver.get(i)[0]);
                r440.getCell(fCols[i]).setCellValue(Integer.parseInt(fOver.get(i)[1]));
            }
            for (int i = 0; i < sOver.size() && i < sCols.length; i++) {
                r439.getCell(sCols[i]).setCellValue(sOver.get(i)[0]);
                r440.getCell(sCols[i]).setCellValue(Integer.parseInt(sOver.get(i)[1]));
            }
            for (int i = 0; i < tOver.size() && i < tCols.length; i++) {
                r439.getCell(tCols[i]).setCellValue(tOver.get(i)[0]);
                r440.getCell(tCols[i]).setCellValue(Integer.parseInt(tOver.get(i)[1]));
            }
        }

        // 모든 행 높이 일괄 설정: 4500 / (총행수를 4의 배수로 올림)
        int totalRows = dc + 4 + (hasOverflow ? 2 : 0);
        int rounded = ((totalRows + 3) / 4) * 4;
        float rowHeight = 4400f / rounded;
        for (int i = 0; i < totalRows; i++) {
            Row r = sheet.getRow(i);
            if (r != null) r.setHeightInPoints(rowHeight);
        }

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\"Pogo5pc2.xls\"");

        try {
            wb.write(response.getOutputStream());
        } finally {
            wb.close();
        }
    }

    private boolean empty(String s) {
        return s == null || s.isEmpty();
    }

    // 숨김 행의 tCat 집계만 유지 (Excel 행 미생성 시 수치 불변 보장)
    private void accumCat(String value, int[] sum) {
        if (empty(value)) return;
        String[] parts = value.split("\t", -1);
        for (int i = 0; i < parts.length && i < sum.length; i++) {
            String p = parts[i].trim();
            if (!p.isEmpty()) {
                try { sum[i] += Integer.parseInt(p); } catch (NumberFormatException ignored) {}
            }
        }
    }

    // pow 문자열에서 레벨 추출, div 유무에 따라 "35" 또는 "?35" 키로 집계
    private void countLvl(String pow, String div, Map<String, Integer> map) {
        if (effectivelyEmpty(pow)) return;
        boolean hasDiv = !empty(div);
        for (String part : pow.split("\t", -1)) {
            if (part.length() >= 2) {
                try {
                    int lvl = Integer.parseInt(part.substring(1));
                    String key = hasDiv ? "?" + lvl : String.valueOf(lvl);
                    Integer prev = map.get(key);
                    map.put(key, prev == null ? 1 : prev + 1);
                } catch (NumberFormatException ignored) {}
            }
        }
    }

    // 레벨 내림차순, 같은 레벨이면 div있음("?") 먼저, 상위 7개 반환: [label, count]
    private List<String[]> topLevels(Map<String, Integer> map) {
        return levelSlice(map, 0, 7);
    }

    // 8번째 이후 항목 반환 (전체 정렬 기준 동일하게 적용)
    private List<String[]> overflowLevels(Map<String, Integer> map) {
        return levelSlice(map, 7, Integer.MAX_VALUE);
    }

    // ?30, ?25, ?20, 30 최우선, 이후 레벨 내림차순 · 같은 레벨이면 div없음(non-?) 먼저
    private List<String[]> levelSlice(Map<String, Integer> map, int from, int maxCount) {
        final java.util.List<String> prior = java.util.Arrays.asList("?30", "?25", "?20", "30");
        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys, new java.util.Comparator<String>() {
            public int compare(String a, String b) {
                int pa = prior.indexOf(a), pb = prior.indexOf(b);
                if (pa >= 0 && pb >= 0) return pa - pb;
                if (pa >= 0) return -1;
                if (pb >= 0) return 1;
                int lvlA = Integer.parseInt(a.startsWith("?") ? a.substring(1) : a);
                int lvlB = Integer.parseInt(b.startsWith("?") ? b.substring(1) : b);
                if (lvlB != lvlA) return lvlB - lvlA;
                return (b.startsWith("?") ? 1 : 0) - (a.startsWith("?") ? 1 : 0);
            }
        });
        List<String[]> result = new ArrayList<String[]>();
        for (int i = from; i < keys.size() && result.size() < maxCount; i++) {
            result.add(new String[]{keys.get(i), String.valueOf(map.get(keys.get(i)))});
        }
        return result;
    }

    // 탭만 있는 문자열도 비어있는 것으로 처리 (SQL에서 NULL pow를 탭 9개로 반환하는 경우)
    private boolean effectivelyEmpty(String s) {
        if (s == null || s.isEmpty()) return true;
        for (String part : s.split("\t", -1)) {
            if (!part.isEmpty()) return false;
        }
        return true;
    }

    // pow: 탭 구분 문자열 → 기존 셀에 값 입력, count 추적
    private void fillPow(Row row, int startCol, String value, int[] cnt) {
        if (empty(value)) return;
        String[] parts = value.split("\t", -1);
        for (int i = 0; i < parts.length && i < cnt.length; i++) {
            if (!parts[i].isEmpty()) {
                row.getCell(startCol + i).setCellValue(parts[i]);
                cnt[i]++;
            }
        }
    }

    // cat 문자열에서 앞 count개 정수값 파싱 (주황색 조건 판단용)
    private int[] parseCatVals(String value, int count) {
        int[] vals = new int[count];
        if (value == null || value.isEmpty()) return vals;
        String[] parts = value.split("\t", -1);
        for (int i = 0; i < parts.length && i < count; i++) {
            String p = parts[i].trim();
            if (!p.isEmpty()) {
                try { vals[i] = Integer.parseInt(p); } catch (NumberFormatException ignored) {}
            }
        }
        return vals;
    }

    // cat/max: 탭 구분 숫자 → 기존 셀에 값 입력, sum 추적
    private void fillCat(Row row, int startCol, String value, int[] sum) {
        if (empty(value)) return;
        String[] parts = value.split("\t", -1);
        for (int i = 0; i < parts.length && i < sum.length; i++) {
            String p = parts[i].trim();
            if (!p.isEmpty()) {
                try {
                    int num = Integer.parseInt(p);
                    row.getCell(startCol + i).setCellValue(num);
                    sum[i] += num;
                } catch (NumberFormatException e) {
                    row.getCell(startCol + i).setCellValue(p);
                }
            }
        }
    }

    // 셀 머지 + 값 입력 (숫자)
    private void addMerge(Sheet sheet, Row row, int rowIdx, int c1, int c2, int value, CellStyle style) {
        sheet.addMergedRegion(new CellRangeAddress(rowIdx, rowIdx, c1, c2));
        row.getCell(c1).setCellValue(value);
    }

    // 셀 머지 + 값 입력 (문자열)
    private void addMerge(Sheet sheet, Row row, int rowIdx, int c1, int c2, String value, CellStyle style) {
        sheet.addMergedRegion(new CellRangeAddress(rowIdx, rowIdx, c1, c2));
        row.getCell(c1).setCellValue(value);
    }

}
