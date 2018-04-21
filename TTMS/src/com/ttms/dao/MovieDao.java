package com.ttms.dao;
import com.ttms.model.*;
import com.ttms.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MovieDao {
	
	/**
	 * ���ɾ���޸ĵ�Ӱ
	 */
	public int admMovie(Connection con,String sql)
	{
		PreparedStatement ptmt=null;
		int result=0;
		try {
			ptmt=con.prepareStatement(sql);
			result=ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * �������е�Ӱ
	 */
	public List<Movie> movieList(Connection con,String sql)
	{
		List<Movie> listMovie=new ArrayList<>();
		try{
			PreparedStatement ptmt=con.prepareStatement(sql);
			ResultSet res=ptmt.executeQuery();
			Movie movie=null;
			while(res.next())
			{
				movie=new Movie();
				movie.setMovieId(res.getInt("movieId"));
				movie.setMovieName(res.getString("movieName"));
				movie.setMovieDesc(res.getString("movieDesc"));
				movie.setMovieImage(res.getString("movieImage"));
				movie.setIsReleased(res.getInt("isReleased"));
				listMovie.add(movie);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return listMovie;
	}
	public static void main(String[] args) {
		MovieDao movieDao=new MovieDao();
		DbUtil d=new DbUtil();
		Connection con=d.getConnection();
		String sql="select * from movie";
		List<Movie> list=new ArrayList<>();
		list=movieDao.movieList(con, sql);
		for(Movie m:list)
		{
			System.out.println(m.getIsReleased());
		}
	}
}
