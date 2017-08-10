package com.nzsc.mylibrary.RecycleView.dao;

import android.content.ContentValues;


import com.nzsc.mylibrary.RecycleView.AdapterAndOther.ChannelItem;

import java.util.List;
import java.util.Map;

public interface ChannelDaoInface {
	public boolean addCache(ChannelItem item);

	public boolean deleteCache(String whereClause, String[] whereArgs);

	public boolean updateCache(ContentValues values, String whereClause,
                               String[] whereArgs);

	public Map<String, String> viewCache(String selection,
                                         String[] selectionArgs);

	public List<Map<String, String>> listCache(String selection,
                                               String[] selectionArgs);

	public void clearFeedTable();
}