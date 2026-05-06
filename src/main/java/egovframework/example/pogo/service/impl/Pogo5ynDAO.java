package egovframework.example.pogo.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.pogo.vo.Pogo5ynVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("pogo5ynDAO")
public class Pogo5ynDAO extends EgovAbstractDAO {

    public List<Pogo5ynVO> list() throws Exception {
        return (List<Pogo5ynVO>) list("pogo5ynDAO.list");
    }

}
