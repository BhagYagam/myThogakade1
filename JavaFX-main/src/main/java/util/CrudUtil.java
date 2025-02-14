package util;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String SQL, Object... obj) throws SQLException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(SQL);
        for(int i=0; i<obj.length; i++){
            pstm.setObject(i+1,obj[i]);
        }
        if(SQL.startsWith("SELECT")||SQL.startsWith("select")){
            return (T) pstm.executeQuery();
        }else{
            return (T) (Boolean) (pstm.executeUpdate()>0);
        }
    }
}
