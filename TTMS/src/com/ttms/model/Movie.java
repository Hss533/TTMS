package com.ttms.model;

public class Movie {
	
		private int movieId;//ӰƬId
		private String movieName;//ӰƬ����
		private String movieDesc;//ӰƬ����
		private String movieImage;//ӰƬ����
		private int isReleased;//�Ƿ��ǽ�����ӳ�ģ������0�Ͳ��ǽ�����ӳ�������1 ���ǽ�����ӳ��
		
		public int getIsReleased() {
			return isReleased;
		}
		public void setIsReleased(int isReleased) {
			this.isReleased = isReleased;
		}
		public String getMovieImage() {
			return movieImage;
		}
		public void setMovieImage(String movieImage) {
			this.movieImage = movieImage;
		}
		public int getMovieId() {
			return movieId;
		}
		public void setMovieId(int movieId) {
			this.movieId = movieId;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getMovieDesc() {
			return movieDesc;
		}
		public void setMovieDesc(String movieDesc) {
			this.movieDesc = movieDesc;
		}		
}
