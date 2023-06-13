package com.works.services;

import com.works.props.Notes;
import com.works.props.Products;
import com.works.services.utils.DB;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoteService {

    public List<Notes> notes() {
        List<Notes> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from note";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Notes notes=new Notes();
                notes.setNid( rs.getInt("nid") );
                notes.setTitle( rs.getString("title") );
                notes.setDetail( rs.getString("detail") );
                ls.add(notes);
            }
        }catch (Exception ex) {
            System.err.println("Users Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }


    public int addNote (Notes notes){
        DB db = new DB();
        int status = 0;
        try{
            String sql = "insert into note values( null,?,?)";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, notes.getTitle());
            pre.setString(2, notes.getDetail());

            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Product Save Exception : " +ex);
        } finally {
            db.close();
        }
        return status;
    }

}
