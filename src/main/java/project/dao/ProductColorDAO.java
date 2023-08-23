package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.model.PriceRange;
import project.model.ProductColor;
import project.util.DbUtil;

public class ProductColorDAO {
	// function: public [dataType] [functionName](parameters){}
	public List<ProductColor> getAllColor() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductColor> list = new ArrayList<ProductColor>();
		try {
			conn = DbUtil.makeConnection();

			ps = conn.prepareStatement("SELECT DISTINCT RIGHT(title, LENGTH(title) - LOCATE('- ', title)) AS color FROM product ORDER BY color;");
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new ProductColor(rs.getString(1)));
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