package org.joonzis.service;

import org.joonzis.dao.CDao;
import org.joonzis.dao.CDaoImpl;
import org.joonzis.vo.CVO;

public class CommentServiceImpl implements CommentService{
	private CDao cDao = CDaoImpl.getInstance();

	@Override
	public int insertComment(CVO cvo) {
		return cDao.insertComment(cvo);
	}

}
