package cn.xujinchun.ofounlocker.dao;

import cn.xujinchun.ofounlocker.pojo.Tofo;

public interface IActionDao {
	public void queryAll();
	public Tofo queryByBicycleID(String bicycleid);
	public int insert(String bicycleid,String password);
	public int update(String bicycleid, String password);
}

