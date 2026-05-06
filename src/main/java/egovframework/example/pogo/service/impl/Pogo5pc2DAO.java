package egovframework.example.pogo.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.pogo.vo.Pogo5pc2VO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("pogo5pc2DAO")
public class Pogo5pc2DAO extends EgovAbstractDAO {

    public List<Pogo5pc2VO> list() throws Exception {
        return (List<Pogo5pc2VO>) list("pogo5pc2DAO.list");
    }

}
