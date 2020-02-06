package com.revature.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.model.Celebrity;
import com.revature.util.ConnectionUtil;

public class CelebrityRepositoryJdbc implements CelebrityRepository {

	private static Logger logger = Logger.getLogger(CelebrityRepositoryJdbc.class);

	/*
	 * Singleton Logic
	 */
	private static CelebrityRepositoryJdbc repository = new CelebrityRepositoryJdbc();
	
	private CelebrityRepositoryJdbc() {}
	
	public static CelebrityRepository getInstance() {
		//We not need this part because we are init inline.
//		if(repository == null) {
//			return new CelebrityRepositoryJdbc();
//		}
		return repository;
	}
	
	@Override
	public boolean insert(Celebrity celebrity) {
		logger.trace("Inserting celebrity.");
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "INSERT INTO CELEBRITY(C_ID, C_FIRST_NAME, C_LAST_NAME, C_STAGE_NAME, C_GENDER) VALUES(?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(++parameterIndex, celebrity.getId());
			statement.setString(++parameterIndex, celebrity.getFirstName());
			statement.setString(++parameterIndex, celebrity.getLastName());
			statement.setString(++parameterIndex, celebrity.getStageName());
			statement.setString(++parameterIndex, celebrity.getGender());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.error("Exception thrown while inserting new Celebrity", e);
		}
		return false;
	}

	@Override
	public boolean insertProcedure(Celebrity celebrity) {
		logger.trace("Inserting celebrity with stored procedure.");
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "{ call INSERT_CELEBRITY(?,?,?,?,NULL,NULL,NULL) }";

			CallableStatement statement = connection.prepareCall(sql);
			statement.setString(++parameterIndex, celebrity.getFirstName());
			statement.setString(++parameterIndex, celebrity.getLastName());
			statement.setString(++parameterIndex, celebrity.getStageName());
			statement.setString(++parameterIndex, celebrity.getGender());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.error("Exception thrown while inserting new Celebrity with stored procedure.", e);
		}
		return false;
	}

	@Override
	public Celebrity findByFirstName(String firstName) {
		logger.trace("Getting celebrity by first name.");
		try(Connection connection = ConnectionUtil.getConnection()) {
			int parameterIndex = 0;
			String sql = "SELECT * FROM CELEBRITY WHERE C_FIRST_NAME = ?";	
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(++parameterIndex, firstName);
			
			ResultSet result = statement.executeQuery();
		
			if(result.next()) {
				return new Celebrity(
						result.getLong("C_ID"),
						result.getString("C_FIRST_NAME"),
						result.getString("C_LAST_NAME"),
						result.getString("C_STAGE_NAME"),
						result.getString("C_GENDER")
						);
			}
		} catch (SQLException e) {
			logger.error("Error while selecting celebrity by name.", e);
		}
		return null;
	}

	@Override
	public Set<Celebrity> selectAll() {
		logger.trace("Getting all celebrities.");
		try(Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM CELEBRITY";
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			Set<Celebrity> set = new HashSet<>();			
			while(result.next()) {
				set.add(new Celebrity(
						result.getLong("C_ID"),
						result.getString("C_FIRST_NAME"),
						result.getString("C_LAST_NAME"),
						result.getString("C_STAGE_NAME"),
						result.getString("C_GENDER")
						));
			}
			return set;
		} catch (SQLException e) {
			logger.error("Error while selecting all celebrities.", e);
		}
		return null;
	}

	public static void main(String[] args) {
		CelebrityRepository repository = new CelebrityRepositoryJdbc();

		//Testing Insert
		//repository.insert(new Celebrity(10,"Beyonce","Giselle","Beyonce","F"));
		logger.info(repository.insertProcedure(new Celebrity(0,"Michael","Jackson","MJ","M")));
		logger.info(repository.selectAll());
		logger.info(repository.findByFirstName("Beyonce"));
	}
}
