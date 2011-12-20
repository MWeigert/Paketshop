package com.plagiatorz.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.plagiatorz.db.dao.ReferenzDAO;
import com.plagiatorz.db.dao.exception.DAOException;
import com.plagiatorz.db.dao.factory.DAOFactory;
import com.plagiatorz.db.dto.ValuePairDTO;
import com.plagiatorz.login.LoginObject;

public class ReferenzDAOImpl extends BaseDAOImpl implements ReferenzDAO {

	private static final String GETALLPAKETKATEGORIEN = "SELECT id, text FROM PaketKategorie";
	private static final String GETALLPAKETSTATUS = "SELECT id, text FROM PaketStatus";
	private static final String GETALLMAHNSTATUS = "SELECT id, text FROM MahnStatus";
	private static final String GETALLLAGER = "SELECT id, text FROM Lager";

	public ReferenzDAOImpl(DAOFactory daoFactory) {
		super(daoFactory);
	}

	@Override
	public List<ValuePairDTO> getAllPaketKategorien(LoginObject lo)
			throws DAOException {
		List<ValuePairDTO> retVal = new ArrayList<ValuePairDTO>();

		ResultSet rs = super.executeSelect(lo, GETALLPAKETKATEGORIEN,
				new Object[] {});

		try {
			ValuePairDTO dto;
			while (rs.next()) {
				dto = new ValuePairDTO();
				dto.fillUpRecord(rs);
				retVal.add(dto);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return retVal;
	}

	@Override
	public List<ValuePairDTO> getAllPaketStatus(LoginObject lo)
			throws DAOException {
		List<ValuePairDTO> retVal = new ArrayList<ValuePairDTO>();

		ResultSet rs = super.executeSelect(lo, GETALLPAKETSTATUS,
				new Object[] {});

		try {
			ValuePairDTO dto;
			while (rs.next()) {
				dto = new ValuePairDTO();
				dto.fillUpRecord(rs);
				retVal.add(dto);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return retVal;
	}

	@Override
	public List<ValuePairDTO> getAllMahnStatus(LoginObject lo)
			throws DAOException {
		List<ValuePairDTO> retVal = new ArrayList<ValuePairDTO>();

		ResultSet rs = super.executeSelect(lo, GETALLMAHNSTATUS,
				new Object[] {});

		try {
			ValuePairDTO dto;
			while (rs.next()) {
				dto = new ValuePairDTO();
				dto.fillUpRecord(rs);
				retVal.add(dto);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return retVal;
	}

	@Override
	public List<ValuePairDTO> getAllLager(LoginObject lo) throws DAOException {
		List<ValuePairDTO> retVal = new ArrayList<ValuePairDTO>();

		ResultSet rs = super.executeSelect(lo, GETALLLAGER, new Object[] {});

		try {
			ValuePairDTO dto;
			while (rs.next()) {
				dto = new ValuePairDTO();
				dto.fillUpRecord(rs);
				retVal.add(dto);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return retVal;
	}

}
