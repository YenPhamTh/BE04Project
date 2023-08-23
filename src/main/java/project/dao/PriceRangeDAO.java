package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.model.PriceRange;
import project.util.DbUtil;

public class PriceRangeDAO {
	// function: public [dataType] [functionName](parameters){}
	public List<PriceRange> getAllRange() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PriceRange> list = new ArrayList<PriceRange>();
		try {
			conn = DbUtil.makeConnection();

			ps = conn.prepareStatement("Select * from price_range");
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new PriceRange(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
}