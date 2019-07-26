package com.ssafy;

import car.Car;

public class MovieMgr {
	private static final int MOVIE_MAX_SIZE = 10;
	private Movie[] movies;
	private int index;
	private static MovieMgr mm = new MovieMgr();
	private MovieMgr()
	{
		movies = new Movie[MOVIE_MAX_SIZE];
		index = 0;
	}
	public static MovieMgr getInstance()
	{
		return mm;
	}
	public void add(Movie m)
	{
		if(index < MOVIE_MAX_SIZE)
			movies[index++] = m;
		else
			return;
	}
	public Movie[] search()
	{
		Movie[] mList = new Movie[MOVIE_MAX_SIZE];
		int i = 0;
		for(Movie m : movies)
		{
			if(m != null)
				mList[i++] = m;
		}
		return mList;
	}
	public Movie[] search(String title)
	{
		Movie[] mList = new Movie[MOVIE_MAX_SIZE];
		int i = 0;
		for(Movie m : movies)
		{
			if(m != null && m.getTitle().equals(title))
				mList[i++] = m;
		}
		return mList;
	}
	public Movie[] searchDirector(String name)
	{
		Movie[] mList = new Movie[MOVIE_MAX_SIZE];
		int i = 0;
		for(Movie m : movies)
		{
			if(m != null && m.getDirector().equals(name))
				mList[i++] = m;
		}
		return mList;
	}
	public Movie[] searchGenre(String genre)
	{
		Movie[] mList = new Movie[MOVIE_MAX_SIZE];
		int i = 0;
		for(Movie m : movies)
		{
			if(m != null && m.getGenre().equals(genre))
				mList[i++] = m;
		}
		return mList;
	}
	public void delete(String title)
	{
		for(int i = 0 ; i < MOVIE_MAX_SIZE ; i++)
		{
			if(movies[i] != null && movies[i].getTitle().equals(title))
			{
				for(int j = i+1; j < MOVIE_MAX_SIZE; j++)
				{
					movies[j-1] = movies[j];
				}
			}
		}
		movies[--index] = null;
	}
	public int getSize()
	{
		return index;
	}
}
