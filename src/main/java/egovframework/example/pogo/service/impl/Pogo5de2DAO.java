package egovframework.example.pogo.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.pogo.vo.Pogo5de2VO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("pogo5de2DAO")
public class Pogo5de2DAO extends EgovAbstractDAO {

    public List<Pogo5de2VO> list() throws Exception {
        return (List<Pogo5de2VO>) list("pogo5de2DAO.list");
    }

}
